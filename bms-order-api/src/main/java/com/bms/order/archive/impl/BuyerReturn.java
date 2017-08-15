package com.bms.order.archive.impl;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.bms.order.archive.AbstractArchive;
import com.bms.order.archive.Codeable;
import com.bms.order.archive.Completable;
import com.bms.order.archive.Createable;
import com.bms.order.archive.Deletable;
import com.bms.order.archive.Linkable;
import com.bms.order.archive.Modifiable;
import com.bms.order.archive.impl.list.BuyerReturnDetailList;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.BuyerReturnEntity;
import com.bms.order.bean.entity.BuyerReturnHistoryEntity;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.BuyerReturnDao;
import com.bms.order.util.CodeRule;
import com.bms.order.util.LinkHelper;
import com.framework.exception.BusinessException;

/**
 *
 * 买家退货主表
 * 
 * @author li_huiqian
 * 
 */
public class BuyerReturn extends AbstractArchive
        implements Completable, Createable, Linkable, Modifiable, Deletable, Codeable {

    private static Logger logger = LoggerFactory.getLogger(BuyerReturn.class);

    private static final String TABLE_NAME = "ORDR_BUYER_RETURN";
    private static final String HISTORY_TABLE_NAME = "ORDR_BUYER_RETURN_HISTORY";

    /** 买家退货主表Entity */
    private BuyerReturnEntity entity;

    public BuyerReturnEntity getEntity() {
        logger.info(this + "#getEntity");
        return entity;
    }

    /** 买家退货履历表Entity */
    private BuyerReturnHistoryEntity historyEntity;

    public BuyerReturnHistoryEntity getHistoryEntity() {
        logger.info(this + "#getHistoryEntity");
        return historyEntity;
    }

    /** 买家退货订单明细信息 */
    private List<BuyerReturnDetail> buyerReturnDetails;

    private boolean isBuyerReturnDetailsComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void buyerReturnDetailsLinked() {
        logger.info(this + "#buyerReturnDetailsLinked");
        isBuyerReturnDetailsComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void buyerReturnDetailsUnlink() {
        logger.info(this + "#buyerReturnDetailsUnlink");
        isBuyerReturnDetailsComplete = false;
    }

    public List<BuyerReturnDetail> getBuyerReturnDetails() {
        logger.info(this + "#getBuyerReturnDetails");
        if (!isDataSynced())
            return buyerReturnDetails;

        if (buyerReturnDetails == null || !isBuyerReturnDetailsComplete) {
            BuyerReturnDetailList list = new BuyerReturnDetailList(this);
            list.setBlackboard(getBlackboard());
            list.complete(false);
            isBuyerReturnDetailsComplete = true;
            buyerReturnDetails = null;
            if (list.isDataSynced()) {
                link(list.getArchives());
                for (BuyerReturnDetail item : buyerReturnDetails)
                    item.buyerReturnLinked();
            }
        }

        return buyerReturnDetails;
    }

    /**
     * 构造函数，已过时，请使用BuyerReturn.build(blackboard).forComplete(id)
     *
     */
    
    public BuyerReturn(Long id) {
        logger.info(this + "#BuyerReturn");
        Assert.notNull(id);
        entity = new BuyerReturnEntity();
        entity.setReturnId(id);
    }

    /**
     * 构造函数，已过时，请使用BuyerReturn.build(blackboard).forComplete(code)
     *
     */
    
    public BuyerReturn(String code) {
        logger.info(this + "#BuyerReturn");
        Assert.notNull(code);
        entity = new BuyerReturnEntity();
        entity.setReturnCode(code);
    }

    /**
     * 构造函数，已过时，请使用BuyerReturn.build(blackboard).forCreate(entity,)
     *
     */
    
    public BuyerReturn(BuyerReturnEntity entity) {
        logger.info(this + "#BuyerReturn");
        Assert.notNull(entity);
        this.entity = entity;
        setDataSynced(false);
    }

    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof BuyerReturnDetail) {
            LinkHelper.link(this, target, "entity.returnId");

        }
    }

    @Override
    public void link(List<?> targets) {
        logger.info(this + "#link");
        if (targets == null || targets.size() == 0)
            return;

        Object obj0 = targets.get(0);
        if (!(obj0 instanceof Linkable))
            return;
        Linkable item0 = (Linkable) obj0;

        if (item0 instanceof BuyerReturnDetail) {
            LinkHelper.link(this, targets, "entity.returnId");

        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        // 判断是否是最新
        if (isDataSynced()) {
            return;
        }

        if (entity.getReturnId() != null) {
            BuyerReturnEntity entity = new BuyerReturnEntity();
            entity.setReturnId(this.entity.getReturnId());
            this.entity = entity;
        } else if (entity.getReturnCode() != null) {
            BuyerReturnEntity entity = new BuyerReturnEntity();
            entity.setReturnCode(this.entity.getReturnCode());
            this.entity = entity;
        }

        // 设置允许DEL_FLG=true
        if (allowDelete)
            this.entity.setDelFlg(true);
        else
            this.entity.setDelFlg(false);

        // 查询数据库
        BuyerReturnDao dao = getDao(BuyerReturnDao.class);
        BuyerReturnEntity entity = dao.findOne(this.entity);
        if (entity == null)
            return;
        this.entity = entity;

        setDataSynced(true);

        // 设置历史数据
        setHistory();
    }

    @Override
    public void create() {
        logger.info(this + "#create");
        Assert.notNull(entity);

        // 判断是否需要创建
        if (isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000003);

        // 获取Dao
        BuyerReturnDao dao = getDao(BuyerReturnDao.class);

        // 生成编码
        generateCode();

        // 一意制约检测
        BuyerReturn unique = new BuyerReturn(entity.getReturnCode());
        unique.setBlackboard(getBlackboard());
        unique.complete(false);
        if (unique.isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000004);
        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME);
        // 设置ID
        this.entity.setReturnId(id);

        // 设置共通字段
        insertCommon(this.entity);

        // 插入数据库
        int count = dao.save(this.entity);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000005);

        setDataSynced(true);

        // 设置历史数据
        setHistory();
    }

    /**
     * 为以此时的entity建立历史Entity，此时的数据必须从数据库查出来，这一步不插入数据库
     *
     */
    public void setHistory() {
        logger.info(this + "#setHistory");
        Assert.isTrue(isDataSynced(), "must create or complete before set history.");
        Assert.notNull(entity);
        historyEntity = new BuyerReturnHistoryEntity(entity);
    }

    @Override
    public void modify() {
        logger.info(this + "#modify");
        Assert.notNull(entity);

        // 判断是否需要修改
        if (!isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000006);

        // 获取Dao
        BuyerReturnDao dao = getDao(BuyerReturnDao.class);

        // 设置共通字段
        updateCommon(this.entity);

        // 更新数据库带排他检测
        int count = dao.modify(this.entity);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000007);

        // 插入历史数据
        saveHistory();
        // 设置历史数据
        setHistory();
    }

    @Override
    public void delete() {
        logger.info(this + "#delete");
        Assert.notNull(entity);

        // 判断是否需要删除
        if (!isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000008);

        // 获取Dao
        BuyerReturnDao dao = getDao(BuyerReturnDao.class);

        // 设置共通字段
        deleteCommon(this.entity);

        // 删除数据库带排他检测
        int count = dao.delete(this.entity);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000009);

        // 插入历史数据
        saveHistory();
        // 设置历史数据
        setHistory();
    }

    /**
     * 保存历史数据，在修改或删除之后调用
     *
     */
    private void saveHistory() {
        logger.info(this + "#saveHistory");
        Assert.notNull(historyEntity, "no history entity found.");
        // 获取Dao
        BuyerReturnDao dao = getDao(BuyerReturnDao.class);

        // 获取Id
        Long historyId = getBlackboard().maxId(HISTORY_TABLE_NAME);
        historyEntity.setHistoryId(historyId);
        int count = dao.saveHistory(historyEntity);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000010);
    }

    @Override
    public String toString() {
        if (entity != null)
            return this.getClass().getName() + this.entity.getReturnId();
        else
            return this.getClass().getName();
    }

    public static Builder build(Blackboard blackboard) {
        return new Builder(blackboard);
    }

    public static class Builder {

        private Blackboard blackboard;

        public Builder(Blackboard blackboard) {
            logger.info(this + "#Builder");
            this.blackboard = blackboard;
        }

        /**
         * 创建对象，用于根据id查询数据，此对象必须使用complete方法补全
         *
         */
        public BuyerReturn forComplete(Long id) {
            logger.info(this + "#forComplete");
            BuyerReturn build = new BuyerReturn(id);
            build.setBlackboard(blackboard);
            return build;
        }

        /**
         * 创建对象，用于根据code查询数据，此对象必须使用complete方法补全
         *
         */
        public BuyerReturn forComplete(String code) {
            logger.info(this + "#forComplete");
            BuyerReturn build = new BuyerReturn(code);
            build.setBlackboard(blackboard);
            return build;
        }

        /**
         * 创建对象，用于插入数据库，此对象必须使用create方法插入数据库
         *
         */
        public BuyerReturn forCreate(BuyerReturnEntity entity) {
            logger.info(this + "#forCreate");
            BuyerReturn build = new BuyerReturn(entity);
            build.setBlackboard(blackboard);
            return build;
        }

    }

    public static String createReturnCode() {
        String returnCode = null;
        String uuid = UUID.randomUUID().toString(); // 获取UUID并转化为String对象
        returnCode = uuid.replace("-", ""); // 因为UUID本身为32位只是生成时多了“-”，所以将它们去点就可
        return returnCode;
    }

    @Override
    public void generateCode() {
        entity.setReturnCode(CodeRule.commonRule("MJTH"));
    }
}