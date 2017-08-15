package com.bms.order.archive.impl;

import java.util.List;

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
import com.bms.order.archive.impl.list.BsReturnDetailList;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.BsReturnEntity;
import com.bms.order.bean.entity.BsReturnHistoryEntity;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.BsReturnDao;
import com.bms.order.util.CodeRule;
import com.bms.order.util.LinkHelper;
import com.framework.exception.BusinessException;

/**
 *
 * 买手退货主表
 * 
 * @author li_huiqian
 * 
 */
public class BsReturn extends AbstractArchive
        implements Completable, Createable, Linkable, Modifiable, Deletable, Codeable {

    private static Logger logger = LoggerFactory.getLogger(BsReturn.class);

    private static final String TABLE_NAME = "ORDR_BS_RETURN";
    private static final String HISTORY_TABLE_NAME = "ORDR_BS_RETURN_HISTORY";

    /** 买手退货主表Entity */
    private BsReturnEntity entity;

    public BsReturnEntity getEntity() {
        logger.info(this + "#getEntity");
        return entity;
    }

    /** 买手退货履历表Entity */
    private BsReturnHistoryEntity historyEntity;

    public BsReturnHistoryEntity getHistoryEntity() {
        logger.info(this + "#getHistoryEntity");
        return historyEntity;
    }

    /** 买手退货明细表 */
    private List<BsReturnDetail> bsReturnDetails;

    private boolean isBsReturnDetailsComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void bsReturnDetailsLinked() {
        logger.info(this + "#bsReturnDetailsLinked");
        isBsReturnDetailsComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void bsReturnDetailsUnlink() {
        logger.info(this + "#bsReturnDetailsUnlink");
        isBsReturnDetailsComplete = false;
    }

    public List<BsReturnDetail> getBsReturnDetails() {
        logger.info(this + "#getBsReturnDetails");
        if (!isDataSynced())
            return bsReturnDetails;

        if (bsReturnDetails == null || !isBsReturnDetailsComplete) {
            BsReturnDetailList list = new BsReturnDetailList(this);
            list.setBlackboard(getBlackboard());
            list.complete(false);
            isBsReturnDetailsComplete = true;
            bsReturnDetails = null;
            if (list.isDataSynced()) {
                link(list.getArchives());
                for (BsReturnDetail item : bsReturnDetails)
                    item.bsReturnLinked();
            }
        }

        return bsReturnDetails;
    }

    /**
     * 构造函数，已过时，请使用BsReturn.build(blackboard).forComplete(id)
     *
     */
    
    public BsReturn(Long id) {
        logger.info(this + "#BsReturn");
        Assert.notNull(id);
        entity = new BsReturnEntity();
        entity.setReturnId(id);
    }

    /**
     * 构造函数，已过时，请使用BsReturn.build(blackboard).forComplete(code)
     *
     */
    
    public BsReturn(String code) {
        logger.info(this + "#BsReturn");
        Assert.notNull(code);
        entity = new BsReturnEntity();
        entity.setReturnCode(code);
    }

    /**
     * 构造函数，已过时，请使用BsReturn.build(blackboard).forCreate(entity,)
     *
     */
    
    public BsReturn(BsReturnEntity entity) {
        logger.info(this + "#BsReturn");
        Assert.notNull(entity);
        this.entity = entity;
        setDataSynced(false);
    }

    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof BsReturnDetail) {
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

        if (item0 instanceof BsReturnDetail) {
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
            BsReturnEntity entity = new BsReturnEntity();
            entity.setReturnId(this.entity.getReturnId());
            this.entity = entity;
        } else if (entity.getReturnCode() != null) {
            BsReturnEntity entity = new BsReturnEntity();
            entity.setReturnCode(this.entity.getReturnCode());
            this.entity = entity;
        }

        // 设置允许DEL_FLG=true
        if (allowDelete)
            this.entity.setDelFlg(true);
        else
            this.entity.setDelFlg(false);

        // 查询数据库
        BsReturnDao dao = getDao(BsReturnDao.class);
        BsReturnEntity entity = dao.findOne(this.entity);
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
        BsReturnDao dao = getDao(BsReturnDao.class);

        // 设置编码
        generateCode();

        // 一意制约检测
        BsReturn unique = new BsReturn(entity.getReturnCode());
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
        historyEntity = new BsReturnHistoryEntity(entity);
    }

    @Override
    public void modify() {
        logger.info(this + "#modify");
        Assert.notNull(entity);

        // 判断是否需要修改
        if (!isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000006);

        // 获取Dao
        BsReturnDao dao = getDao(BsReturnDao.class);

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
        BsReturnDao dao = getDao(BsReturnDao.class);

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
        BsReturnDao dao = getDao(BsReturnDao.class);

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
        public BsReturn forComplete(Long id) {
            logger.info(this + "#forComplete");
            BsReturn build = new BsReturn(id);
            build.setBlackboard(blackboard);
            return build;
        }

        /**
         * 创建对象，用于根据code查询数据，此对象必须使用complete方法补全
         *
         */
        public BsReturn forComplete(String code) {
            logger.info(this + "#forComplete");
            BsReturn build = new BsReturn(code);
            build.setBlackboard(blackboard);
            return build;
        }

        /**
         * 创建对象，用于插入数据库，此对象必须使用create方法插入数据库
         *
         */
        public BsReturn forCreate(BsReturnEntity entity) {
            logger.info(this + "#forCreate");
            BsReturn build = new BsReturn(entity);
            build.setBlackboard(blackboard);
            return build;
        }

    }

    @Override
    public void generateCode() {
        entity.setReturnCode(CodeRule.commonRule("MSTH"));
    }

}