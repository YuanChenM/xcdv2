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
import com.bms.order.archive.impl.list.BsStockpileSplitDetailList;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.BsOrderDetailAttachedEntity;
import com.bms.order.bean.entity.BsOrderDetailAttachedHistoryEntity;
import com.bms.order.bean.entity.BsOrderDetailEntity;
import com.bms.order.bean.entity.BsOrderDetailHistoryEntity;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.BsOrderDetailAttachedDao;
import com.bms.order.dao.BsOrderDetailDao;
import com.bms.order.util.LinkHelper;
import com.framework.exception.BusinessException;

/**
 *
 * 买手订单明细

 * @author li_huiqian

 */
public class BsOrderDetail extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(BsOrderDetail.class);

    private static final String TABLE_NAME = "ORDR_BS_ORDER_DETAIL";
    private static final String HISTORY_TABLE_NAME = "ORDR_BS_ORDER_DETAIL_HISTORY";

    /** 买手订单明细Entity */
    private BsOrderDetailEntity entity;

    public BsOrderDetailEntity getEntity() {
        logger.info(this + "#getEntity");
        return entity;
    }

    /** 买手订单明细履历表Entity */
    private BsOrderDetailHistoryEntity historyEntity;

    public BsOrderDetailHistoryEntity getHistoryEntity() {
        logger.info(this + "#getHistoryEntity");
        return historyEntity;
    }

    /** 买手订单明细附表Entity */
    private BsOrderDetailAttachedEntity attachedEntity;

    public BsOrderDetailAttachedEntity getAttachedEntity() {
        logger.info(this + "#getAttachedEntity");
        return attachedEntity;
    }

    /** 买手订单明细附表履历表Entity */
    private BsOrderDetailAttachedHistoryEntity attachedHistoryEntity;

    public BsOrderDetailAttachedHistoryEntity getAttachedHistoryEntity() {
        logger.info(this + "#getAttachedHistoryEntity");
        return attachedHistoryEntity;
    }


    /** 买手订单主表 */
    private BsOrder bsOrder;

    private boolean isBsOrderComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void bsOrderLinked() {
        logger.info(this + "#bsOrderLinked");
        isBsOrderComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void bsOrderUnlink() {
        logger.info(this + "#bsOrderUnlink");
        isBsOrderComplete = false;
    }

    public BsOrder getBsOrder() {
        logger.info(this + "#getBsOrder");
        if (!isDataSynced())
            return bsOrder;

        if (bsOrder == null || !isBsOrderComplete) {
            BsOrder bsOrder = new BsOrder(entity.getBsOrderId());
            bsOrder.setBlackboard(getBlackboard());
            bsOrder.complete(false);
            isBsOrderComplete = true;
            this.bsOrder = null;
            if(bsOrder.isDataSynced())
                link(bsOrder);
        }

        return bsOrder;
    }
    /** 买手囤货分拆单明细 */
    private List<BsStockpileSplitDetail> bsStockpileSplitDetails;

    private boolean isBsStockpileSplitDetailsComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void bsStockpileSplitDetailsLinked() {
        logger.info(this + "#bsStockpileSplitDetailsLinked");
        isBsStockpileSplitDetailsComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void bsStockpileSplitDetailsUnlink() {
        logger.info(this + "#bsStockpileSplitDetailsUnlink");
        isBsStockpileSplitDetailsComplete = false;
    }

    public List<BsStockpileSplitDetail> getBsStockpileSplitDetails() {
        logger.info(this + "#getBsStockpileSplitDetails");
        if (!isDataSynced())
            return bsStockpileSplitDetails;

        if (bsStockpileSplitDetails == null || !isBsStockpileSplitDetailsComplete) {
            BsStockpileSplitDetailList list = new BsStockpileSplitDetailList(this);
            list.setBlackboard(getBlackboard());
            list.complete(false);
            isBsStockpileSplitDetailsComplete = true;
            bsStockpileSplitDetails = null;
            if(list.isDataSynced()) {
                link(list.getArchives());
                for (BsStockpileSplitDetail item : bsStockpileSplitDetails)
                    item.bsOrderDetailLinked();
            }
        }

        return bsStockpileSplitDetails;
    }

    /**
     * 构造函数，已过时，请使用BsOrderDetail.build(blackboard).forComplete(id)
     *
     */
    public  BsOrderDetail(Long id) {
        logger.info(this + "#BsOrderDetail");
        Assert.notNull(id);
        entity = new BsOrderDetailEntity();
        entity.setBsOrderDetailId(id);
    }

    /**
     * 构造函数，已过时，请使用BsOrderDetail.build(blackboard).forCreate(entity,,BsOrderDetailAttachedEntity)
     *
     */
    public  BsOrderDetail(BsOrderDetailEntity entity, BsOrderDetailAttachedEntity attachedEntity) {
        logger.info(this + "#BsOrderDetail");
        Assert.notNull(entity);
        Assert.notNull(attachedEntity);
        this.entity = entity;
        this.attachedEntity = attachedEntity;
        setDataSynced(false);
    }

    /**
     * 构造函数，已过时，请使用BsOrderDetail.build(blackboard).forComplete(linkedArchive)
     *
     */
    public  BsOrderDetail(BsOrder linkedArchive) {
        logger.info(this + "#BsOrderDetail");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getBsOrderId());
        entity = new BsOrderDetailEntity();
        entity.setBsOrderId(linkedArchive.getEntity().getBsOrderId());
    }

    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof BsOrder) {
            LinkHelper.link(this, target, "entity.bsOrderId");
        
        } else if (target instanceof BsStockpileSplitDetail) {
            LinkHelper.link(this, target, "entity.bsOrderDetailId");
        
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

        if (item0 instanceof BsOrder) {
            LinkHelper.link(this, targets, "entity.bsOrderId");
        
        } else if (item0 instanceof BsStockpileSplitDetail) {
            LinkHelper.link(this, targets, "entity.bsOrderDetailId");
        
        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        // 判断是否是最新
        if (isDataSynced()) {
            return;
        }

        if (entity.getBsOrderDetailId() != null) {
            BsOrderDetailEntity entity = new BsOrderDetailEntity();
            entity.setBsOrderDetailId(this.entity.getBsOrderDetailId());
            this.entity = entity;
        } else if (entity.getBsOrderId() != null) {
            BsOrderDetailEntity entity = new BsOrderDetailEntity();
            entity.setBsOrderId(this.entity.getBsOrderId());
            this.entity = entity;
        }

        // 设置允许DEL_FLG=true
        if (allowDelete)
            this.entity.setDelFlg(true);
        else
            this.entity.setDelFlg(false);

        // 查询数据库
        BsOrderDetailDao dao = getDao(BsOrderDetailDao.class);
        BsOrderDetailEntity entity = dao.findOne(this.entity);
        if (entity == null)
            return;
        this.entity = entity;

        BsOrderDetailAttachedDao attachedDao = getDao(BsOrderDetailAttachedDao.class);
        BsOrderDetailAttachedEntity attachedEntity = attachedDao.findOne(this.entity);
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
        BsOrderDetailDao dao = getDao(BsOrderDetailDao.class);
        BsOrderDetailAttachedDao attachedDao = getDao(BsOrderDetailAttachedDao.class);

        // 一意制约检测
        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME);
        // 设置ID
        this.entity.setBsOrderDetailId(id);
        this.attachedEntity.setBsOrderDetailId(id);

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
        historyEntity = new BsOrderDetailHistoryEntity(entity);
        attachedHistoryEntity = new BsOrderDetailAttachedHistoryEntity(attachedEntity);
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
        BsOrderDetailDao dao = getDao(BsOrderDetailDao.class);
        BsOrderDetailAttachedDao attachedDao = getDao(BsOrderDetailAttachedDao.class);

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
        BsOrderDetailDao dao = getDao(BsOrderDetailDao.class);
        BsOrderDetailAttachedDao attachedDao = getDao(BsOrderDetailAttachedDao.class);

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
        BsOrderDetailDao dao = getDao(BsOrderDetailDao.class);
        BsOrderDetailAttachedDao attachedDao = getDao(BsOrderDetailAttachedDao.class);

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
            return this.getClass().getName() + this.entity.getBsOrderDetailId();
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
    public BsOrderDetail forComplete(Long id) {
        logger.info(this + "#forComplete");
        BsOrderDetail build = new BsOrderDetail(id);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于插入数据库，此对象必须使用create方法插入数据库
     *
     */
    public BsOrderDetail forCreate(BsOrderDetailEntity entity, BsOrderDetailAttachedEntity attachedEntity) {
        logger.info(this + "#forCreate");
        BsOrderDetail build = new BsOrderDetail(entity, attachedEntity);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于根据entity.bsOrderId查询数据，此对象必须使用complete方法补全
     *
     */
    public BsOrderDetail forComplete(BsOrder linkedArchive) {
        logger.info(this + "#forComplete");
        BsOrderDetail build = new BsOrderDetail(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    }


}