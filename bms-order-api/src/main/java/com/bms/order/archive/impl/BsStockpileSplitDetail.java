package com.bms.order.archive.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.bms.order.archive.AbstractArchive;
import com.bms.order.archive.Completable;
import com.bms.order.archive.Createable;
import com.bms.order.archive.Deletable;
import com.bms.order.archive.Linkable;
import com.bms.order.archive.Modifiable;
import com.bms.order.archive.impl.list.BsStockpileSaleDetailList;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.BsStockpileSplitDetailAttachedEntity;
import com.bms.order.bean.entity.BsStockpileSplitDetailAttachedHistoryEntity;
import com.bms.order.bean.entity.BsStockpileSplitDetailEntity;
import com.bms.order.bean.entity.BsStockpileSplitDetailHistoryEntity;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.BsStockpileSplitDetailAttachedDao;
import com.bms.order.dao.BsStockpileSplitDetailDao;
import com.bms.order.util.LinkHelper;
import com.framework.exception.BusinessException;

/**
 *
 * 买手囤货分拆单明细

 * @author li_huiqian

 */
public class BsStockpileSplitDetail extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(BsStockpileSplitDetail.class);

    private static final String TABLE_NAME = "ORDR_BS_STOCKPILE_SPLIT_DETAIL";
    private static final String HISTORY_TABLE_NAME = "ORDR_BS_STOCKPILE_SPLIT_DETAIL_HISTORY";

    /** 买手囤货分拆单明细Entity */
    private BsStockpileSplitDetailEntity entity;

    public BsStockpileSplitDetailEntity getEntity() {
        logger.info(this + "#getEntity");
        return entity;
    }

    /** 买手囤货分拆单明细履历表Entity */
    private BsStockpileSplitDetailHistoryEntity historyEntity;

    public BsStockpileSplitDetailHistoryEntity getHistoryEntity() {
        logger.info(this + "#getHistoryEntity");
        return historyEntity;
    }

    /** 买手囤货分拆单明细附表Entity */
    private BsStockpileSplitDetailAttachedEntity attachedEntity;

    public BsStockpileSplitDetailAttachedEntity getAttachedEntity() {
        logger.info(this + "#getAttachedEntity");
        return attachedEntity;
    }

    /** 买手囤货分拆单明细附表履历表Entity */
    private BsStockpileSplitDetailAttachedHistoryEntity attachedHistoryEntity;

    public BsStockpileSplitDetailAttachedHistoryEntity getAttachedHistoryEntity() {
        logger.info(this + "#getAttachedHistoryEntity");
        return attachedHistoryEntity;
    }


    /** 买手订单明细 */
    private BsOrderDetail bsOrderDetail;

    private boolean isBsOrderDetailComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void bsOrderDetailLinked() {
        logger.info(this + "#bsOrderDetailLinked");
        isBsOrderDetailComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void bsOrderDetailUnlink() {
        logger.info(this + "#bsOrderDetailUnlink");
        isBsOrderDetailComplete = false;
    }

    public BsOrderDetail getBsOrderDetail() {
        logger.info(this + "#getBsOrderDetail");
        if (!isDataSynced())
            return bsOrderDetail;

        if (bsOrderDetail == null || !isBsOrderDetailComplete) {
            BsOrderDetail bsOrderDetail = new BsOrderDetail(entity.getBsOrderDetailId());
            bsOrderDetail.setBlackboard(getBlackboard());
            bsOrderDetail.complete(false);
            isBsOrderDetailComplete = true;
            this.bsOrderDetail = null;
            if(bsOrderDetail.isDataSynced())
                link(bsOrderDetail);
        }

        return bsOrderDetail;
    }
    /** 买手囤货销售明细 */
    private List<BsStockpileSaleDetail> bsStockpileSaleDetails;

    private boolean isBsStockpileSaleDetailsComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void bsStockpileSaleDetailsLinked() {
        logger.info(this + "#bsStockpileSaleDetailsLinked");
        isBsStockpileSaleDetailsComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void bsStockpileSaleDetailsUnlink() {
        logger.info(this + "#bsStockpileSaleDetailsUnlink");
        isBsStockpileSaleDetailsComplete = false;
    }

    public List<BsStockpileSaleDetail> getBsStockpileSaleDetails() {
        logger.info(this + "#getBsStockpileSaleDetails");
        if (!isDataSynced())
            return bsStockpileSaleDetails;

        if (bsStockpileSaleDetails == null || !isBsStockpileSaleDetailsComplete) {
            BsStockpileSaleDetailList list = new BsStockpileSaleDetailList(this);
            list.setBlackboard(getBlackboard());
            list.complete(false);
            isBsStockpileSaleDetailsComplete = true;
            bsStockpileSaleDetails = null;
            if(list.isDataSynced()) {
                link(list.getArchives());
                for (BsStockpileSaleDetail item : bsStockpileSaleDetails)
                    item.bsStockpileSplitDetailLinked();
            }
        }

        return bsStockpileSaleDetails;
    }

    /**
     * 构造函数，已过时，请使用BsStockpileSplitDetail.build(blackboard).forComplete(id)
     *
     */
    
    public  BsStockpileSplitDetail(Long id) {
        logger.info(this + "#BsStockpileSplitDetail");
        Assert.notNull(id);
        entity = new BsStockpileSplitDetailEntity();
        entity.setBsStockpileSplitDetailId(id);
    }

    /**
     * 构造函数，已过时，请使用BsStockpileSplitDetail.build(blackboard).forCreate(entity,,BsStockpileSplitDetailAttachedEntity)
     *
     */
    
    public  BsStockpileSplitDetail(BsStockpileSplitDetailEntity entity, BsStockpileSplitDetailAttachedEntity attachedEntity) {
        logger.info(this + "#BsStockpileSplitDetail");
        Assert.notNull(entity);
        Assert.notNull(attachedEntity);
        this.entity = entity;
        this.attachedEntity = attachedEntity;
        setDataSynced(false);
    }

    /**
     * 构造函数，已过时，请使用BsStockpileSplitDetail.build(blackboard).forComplete(linkedArchive)
     *
     */
    
    public  BsStockpileSplitDetail(BsOrderDetail linkedArchive) {
        logger.info(this + "#BsStockpileSplitDetail");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getBsOrderDetailId());
        entity = new BsStockpileSplitDetailEntity();
        entity.setBsOrderDetailId(linkedArchive.getEntity().getBsOrderDetailId());
    }

    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof BsOrderDetail) {
            LinkHelper.link(this, target, "entity.bsOrderDetailId");
        
        } else if (target instanceof BsStockpileSaleDetail) {
            LinkHelper.link(this, target, "entity.bsStockpileSplitDetailId");
        
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

        if (item0 instanceof BsOrderDetail) {
            LinkHelper.link(this, targets, "entity.bsOrderDetailId");
        
        } else if (item0 instanceof BsStockpileSaleDetail) {
            LinkHelper.link(this, targets, "entity.bsStockpileSplitDetailId");
        
        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        // 判断是否是最新
        if (isDataSynced()) {
            return;
        }

        if (entity.getBsStockpileSplitDetailId() != null) {
            BsStockpileSplitDetailEntity entity = new BsStockpileSplitDetailEntity();
            entity.setBsStockpileSplitDetailId(this.entity.getBsStockpileSplitDetailId());
            this.entity = entity;
        } else if (entity.getBsOrderDetailId() != null) {
            BsStockpileSplitDetailEntity entity = new BsStockpileSplitDetailEntity();
            entity.setBsOrderDetailId(this.entity.getBsOrderDetailId());
            this.entity = entity;
        }

        // 设置允许DEL_FLG=true
        if (allowDelete)
            this.entity.setDelFlg(true);
        else
            this.entity.setDelFlg(false);

        // 查询数据库
        BsStockpileSplitDetailDao dao = getDao(BsStockpileSplitDetailDao.class);
        BsStockpileSplitDetailEntity entity = dao.findOne(this.entity);
        if (entity == null)
            return;
        this.entity = entity;

        BsStockpileSplitDetailAttachedDao attachedDao = getDao(BsStockpileSplitDetailAttachedDao.class);
        BsStockpileSplitDetailAttachedEntity attachedEntity = attachedDao.findOne(this.entity);
        if (attachedEntity == null)
            return;
        this.attachedEntity = attachedEntity;

        setDataSynced(true);

        // 设置历史数据
        setHistory();
    }

    @Override
    public void create() {
        logger.info(this + "#create");
        Assert.notNull(entity);
        Assert.notNull(attachedEntity);

        // 判断是否需要创建
        if (isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000003);

        // 获取Dao
        BsStockpileSplitDetailDao dao = getDao(BsStockpileSplitDetailDao.class);
        BsStockpileSplitDetailAttachedDao attachedDao = getDao(BsStockpileSplitDetailAttachedDao.class);

        // 一意制约检测
        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME);
        // 设置ID
        this.entity.setBsStockpileSplitDetailId(id);
        this.attachedEntity.setBsStockpileSplitDetailId(id);

        // 设置共通字段
        insertCommon(this.entity);
        insertCommon(this.attachedEntity);

        // 插入数据库
        int count = dao.save(this.entity);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000005);
        count = attachedDao.save(this.attachedEntity);
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
        Assert.notNull(attachedEntity);
        historyEntity = new BsStockpileSplitDetailHistoryEntity(entity);
        attachedHistoryEntity = new BsStockpileSplitDetailAttachedHistoryEntity(attachedEntity);
    }

    @Override
    public void modify() {
        logger.info(this + "#modify");
        Assert.notNull(entity);
        Assert.notNull(attachedEntity);

        // 判断是否需要修改
        if (!isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000006);

        // 获取Dao
        BsStockpileSplitDetailDao dao = getDao(BsStockpileSplitDetailDao.class);
        BsStockpileSplitDetailAttachedDao attachedDao = getDao(BsStockpileSplitDetailAttachedDao.class);

        // 设置共通字段
        updateCommon(this.entity);
        updateCommon(this.attachedEntity);

        // 更新数据库带排他检测
        int count = dao.modify(this.entity);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000007);
        count = attachedDao.modify(this.attachedEntity);
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
        Assert.notNull(attachedEntity);

        // 判断是否需要删除
        if (!isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000008);

        // 获取Dao
        BsStockpileSplitDetailDao dao = getDao(BsStockpileSplitDetailDao.class);
        BsStockpileSplitDetailAttachedDao attachedDao = getDao(BsStockpileSplitDetailAttachedDao.class);

        // 设置共通字段
        deleteCommon(this.entity);
        deleteCommon(this.attachedEntity);

        // 删除数据库带排他检测
        int count = dao.delete(this.entity);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000009);
        count = attachedDao.modify(this.attachedEntity);
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
        Assert.notNull(attachedHistoryEntity, "no attached history entity found.");
        // 获取Dao
        BsStockpileSplitDetailDao dao = getDao(BsStockpileSplitDetailDao.class);
        BsStockpileSplitDetailAttachedDao attachedDao = getDao(BsStockpileSplitDetailAttachedDao.class);

        // 获取Id
        Long historyId = getBlackboard().maxId(HISTORY_TABLE_NAME);
        historyEntity.setHistoryId(historyId);
        int count = dao.saveHistory(historyEntity);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000010);
        attachedHistoryEntity.setHistoryId(historyId);
        count = attachedDao.saveHistory(attachedHistoryEntity);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000010);
    }

    @Override
    public String toString() {
        if (entity != null)
            return this.getClass().getName() + this.entity.getBsStockpileSplitDetailId();
        else
            return this.getClass().getName();
    }

    public static Builder build(Blackboard blackboard) {
        return new Builder(blackboard);
    }

    public static class Builder{

    private Blackboard blackboard;

    public  Builder(Blackboard blackboard) {
        logger.info(this + "#Builder");
        this.blackboard = blackboard;
    }

    /**
     * 创建对象，用于根据id查询数据，此对象必须使用complete方法补全
     *
     */
    public BsStockpileSplitDetail forComplete(Long id) {
        logger.info(this + "#forComplete");
        BsStockpileSplitDetail build = new BsStockpileSplitDetail(id);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于插入数据库，此对象必须使用create方法插入数据库
     *
     */
    public BsStockpileSplitDetail forCreate(BsStockpileSplitDetailEntity entity, BsStockpileSplitDetailAttachedEntity attachedEntity) {
        logger.info(this + "#forCreate");
        BsStockpileSplitDetail build = new BsStockpileSplitDetail(entity, attachedEntity);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于根据entity.bsOrderDetailId查询数据，此对象必须使用complete方法补全
     *
     */
    public BsStockpileSplitDetail forComplete(BsOrderDetail linkedArchive) {
        logger.info(this + "#forComplete");
        BsStockpileSplitDetail build = new BsStockpileSplitDetail(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    }


}