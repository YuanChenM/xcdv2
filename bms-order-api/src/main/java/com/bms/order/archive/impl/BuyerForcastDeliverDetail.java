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
import com.bms.order.bean.Blackboard;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.bean.entity.BuyerForcastDeliverDetailEntity;
import com.bms.order.bean.entity.BuyerForcastDeliverDetailHistoryEntity;
import com.bms.order.bean.entity.BuyerForcastDeliverDetailAttachedEntity;
import com.bms.order.bean.entity.BuyerForcastDeliverDetailAttachedHistoryEntity;
import com.bms.order.dao.BuyerForcastDeliverDetailDao;
import com.bms.order.dao.BuyerForcastDeliverDetailAttachedDao;
import com.bms.order.util.LinkHelper;
import com.framework.exception.BusinessException;
import com.bms.order.archive.impl.BuyerBatchOrderDetail;
import com.bms.order.bean.entity.BuyerBatchOrderDetailEntity;
import com.bms.order.archive.impl.BuyerBatchOrder;
import com.bms.order.bean.entity.BuyerBatchOrderEntity;
import com.bms.order.archive.impl.DistributionNotificationDetail;
import com.bms.order.archive.impl.BsStockpileSaleDetail;
import com.bms.order.archive.impl.list.BsStockpileSaleDetailList;

/**
 *
 * 买家订单预配送明细表

 * @author li_huiqian

 */
public class BuyerForcastDeliverDetail extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(BuyerForcastDeliverDetail.class);

    private static final String TABLE_NAME = "ORDR_BUYER_FORCAST_DELIVER_DETAIL";
    private static final String HISTORY_TABLE_NAME = "ORDR_BUYER_FORCAST_DELIVER_DETAIL_HISTORY";

    /** 买家订单预配送明细表Entity */
    private BuyerForcastDeliverDetailEntity entity;

    public BuyerForcastDeliverDetailEntity getEntity() {
        logger.info(this + "#getEntity");
        return entity;
    }

    /** 买家订单预配送明细表履历表Entity */
    private BuyerForcastDeliverDetailHistoryEntity historyEntity;

    public BuyerForcastDeliverDetailHistoryEntity getHistoryEntity() {
        logger.info(this + "#getHistoryEntity");
        return historyEntity;
    }

    /** 买家订单预配送明细附表Entity */
    private BuyerForcastDeliverDetailAttachedEntity attachedEntity;

    public BuyerForcastDeliverDetailAttachedEntity getAttachedEntity() {
        logger.info(this + "#getAttachedEntity");
        return attachedEntity;
    }

    /** 买家订单预配送明细附表履历表Entity */
    private BuyerForcastDeliverDetailAttachedHistoryEntity attachedHistoryEntity;

    public BuyerForcastDeliverDetailAttachedHistoryEntity getAttachedHistoryEntity() {
        logger.info(this + "#getAttachedHistoryEntity");
        return attachedHistoryEntity;
    }


    /** 订单明细表，订单的原始信息，与客户提交的订单保持一致 */
    private BuyerBatchOrderDetail buyerBatchOrderDetail;

    private boolean isBuyerBatchOrderDetailComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void buyerBatchOrderDetailLinked() {
        logger.info(this + "#buyerBatchOrderDetailLinked");
        isBuyerBatchOrderDetailComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void buyerBatchOrderDetailUnlink() {
        logger.info(this + "#buyerBatchOrderDetailUnlink");
        isBuyerBatchOrderDetailComplete = false;
    }

    public BuyerBatchOrderDetail getBuyerBatchOrderDetail() {
        logger.info(this + "#getBuyerBatchOrderDetail");
        if (!isDataSynced())
            return buyerBatchOrderDetail;

        if (buyerBatchOrderDetail == null || !isBuyerBatchOrderDetailComplete) {
            BuyerBatchOrderDetail buyerBatchOrderDetail = new BuyerBatchOrderDetail(entity.getBuyerBatchOrderDetailId());
            buyerBatchOrderDetail.setBlackboard(getBlackboard());
            buyerBatchOrderDetail.complete(false);
            isBuyerBatchOrderDetailComplete = true;
            this.buyerBatchOrderDetail = null;
            if(buyerBatchOrderDetail.isDataSynced())
                link(buyerBatchOrderDetail);
        }

        return buyerBatchOrderDetail;
    }
    /** 分批订单表/子订单表 */
    private BuyerBatchOrder buyerBatchOrder;

    private boolean isBuyerBatchOrderComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void buyerBatchOrderLinked() {
        logger.info(this + "#buyerBatchOrderLinked");
        isBuyerBatchOrderComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void buyerBatchOrderUnlink() {
        logger.info(this + "#buyerBatchOrderUnlink");
        isBuyerBatchOrderComplete = false;
    }

    public BuyerBatchOrder getBuyerBatchOrder() {
        logger.info(this + "#getBuyerBatchOrder");
        if (!isDataSynced())
            return buyerBatchOrder;

        if (buyerBatchOrder == null || !isBuyerBatchOrderComplete) {
            BuyerBatchOrder buyerBatchOrder = new BuyerBatchOrder(entity.getBuyerBatchOrderId());
            buyerBatchOrder.setBlackboard(getBlackboard());
            buyerBatchOrder.complete(false);
            isBuyerBatchOrderComplete = true;
            this.buyerBatchOrder = null;
            if(buyerBatchOrder.isDataSynced())
                link(buyerBatchOrder);
        }

        return buyerBatchOrder;
    }
    /** 配送通知单明细表 */
    private DistributionNotificationDetail distributionNotificationDetail;

    private boolean isDistributionNotificationDetailComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void distributionNotificationDetailLinked() {
        logger.info(this + "#distributionNotificationDetailLinked");
        isDistributionNotificationDetailComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void distributionNotificationDetailUnlink() {
        logger.info(this + "#distributionNotificationDetailUnlink");
        isDistributionNotificationDetailComplete = false;
    }

    public DistributionNotificationDetail getDistributionNotificationDetail() {
        logger.info(this + "#getDistributionNotificationDetail");
        if (!isDataSynced())
            return distributionNotificationDetail;

        if (distributionNotificationDetail == null || !isDistributionNotificationDetailComplete) {
            DistributionNotificationDetail distributionNotificationDetail = new DistributionNotificationDetail(this);
            distributionNotificationDetail.setBlackboard(getBlackboard());
            distributionNotificationDetail.complete(false);
            isDistributionNotificationDetailComplete = true;
            this.distributionNotificationDetail = null;
            if(distributionNotificationDetail.isDataSynced())
                link(distributionNotificationDetail);
            distributionNotificationDetail.buyerForcastDeliverDetailLinked();
        }

        return distributionNotificationDetail;
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
                    item.buyerForcastDeliverDetailLinked();
            }
        }

        return bsStockpileSaleDetails;
    }

    /**
     * 构造函数，已过时，请使用BuyerForcastDeliverDetail..forComplete(id)
     *
     */
    @Deprecated
    public  BuyerForcastDeliverDetail(Long id) {
        logger.info(this + "#BuyerForcastDeliverDetail");
        Assert.notNull(id);
        entity = new BuyerForcastDeliverDetailEntity();
        entity.setBuyerForcastDeliverDetailId(id);
    }

    /**
     * 构造函数，已过时，请使用BuyerForcastDeliverDetail..forCreate(entity,,BuyerForcastDeliverDetailAttachedEntity)
     *
     */
    @Deprecated
    public  BuyerForcastDeliverDetail(BuyerForcastDeliverDetailEntity entity, BuyerForcastDeliverDetailAttachedEntity attachedEntity) {
        logger.info(this + "#BuyerForcastDeliverDetail");
        Assert.notNull(entity);
        Assert.notNull(attachedEntity);
        this.entity = entity;
        this.attachedEntity = attachedEntity;
        setDataSynced(false);
    }

    /**
     * 构造函数，已过时，请使用BuyerForcastDeliverDetail..forComplete(linkedArchive)
     *
     */
    @Deprecated
    public  BuyerForcastDeliverDetail(BuyerBatchOrderDetail linkedArchive) {
        logger.info(this + "#BuyerForcastDeliverDetail");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getBuyerBatchOrderDetailId());
        entity = new BuyerForcastDeliverDetailEntity();
        entity.setBuyerBatchOrderDetailId(linkedArchive.getEntity().getBuyerBatchOrderDetailId());
    }
    /**
     * 构造函数，已过时，请使用BuyerForcastDeliverDetail..forComplete(linkedArchive)
     *
     */
    @Deprecated
    public  BuyerForcastDeliverDetail(BuyerBatchOrder linkedArchive) {
        logger.info(this + "#BuyerForcastDeliverDetail");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getBuyerBatchOrderId());
        entity = new BuyerForcastDeliverDetailEntity();
        entity.setBuyerBatchOrderId(linkedArchive.getEntity().getBuyerBatchOrderId());
    }

    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof BuyerBatchOrderDetail) {
            LinkHelper.link(this, target, "entity.buyerBatchOrderDetailId");
        
        } else if (target instanceof BuyerBatchOrder) {
            LinkHelper.link(this, target, "entity.buyerBatchOrderId");
        
        } else if (target instanceof DistributionNotificationDetail) {
            LinkHelper.link(this, target, "entity.buyerForcastDeliverDetailId");
        
        } else if (target instanceof BsStockpileSaleDetail) {
            LinkHelper.link(this, target, "entity.buyerForcastDeliverDetailId");
        
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

        if (item0 instanceof BuyerBatchOrderDetail) {
            LinkHelper.link(this, targets, "entity.buyerBatchOrderDetailId");
        
        } else if (item0 instanceof BuyerBatchOrder) {
            LinkHelper.link(this, targets, "entity.buyerBatchOrderId");
        
        } else if (item0 instanceof DistributionNotificationDetail) {
            LinkHelper.link(this, targets, "entity.buyerForcastDeliverDetailId");
        
        } else if (item0 instanceof BsStockpileSaleDetail) {
            LinkHelper.link(this, targets, "entity.buyerForcastDeliverDetailId");
        
        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        // 判断是否是最新
        if (isDataSynced()) {
            return;
        }

        if (entity.getBuyerForcastDeliverDetailId() != null) {
            BuyerForcastDeliverDetailEntity entity = new BuyerForcastDeliverDetailEntity();
            entity.setBuyerForcastDeliverDetailId(this.entity.getBuyerForcastDeliverDetailId());
            this.entity = entity;
        } else if (entity.getBuyerBatchOrderDetailId() != null) {
            BuyerForcastDeliverDetailEntity entity = new BuyerForcastDeliverDetailEntity();
            entity.setBuyerBatchOrderDetailId(this.entity.getBuyerBatchOrderDetailId());
            this.entity = entity;
        } else if (entity.getBuyerBatchOrderId() != null) {
            BuyerForcastDeliverDetailEntity entity = new BuyerForcastDeliverDetailEntity();
            entity.setBuyerBatchOrderId(this.entity.getBuyerBatchOrderId());
            this.entity = entity;
        }

        // 设置允许DEL_FLG=true
        if (allowDelete)
            this.entity.setDelFlg(true);
        else
            this.entity.setDelFlg(false);

        // 查询数据库
        BuyerForcastDeliverDetailDao dao = getDao(BuyerForcastDeliverDetailDao.class);
        BuyerForcastDeliverDetailEntity entity = dao.findOne(this.entity);
        if (entity == null)
            return;
        this.entity = entity;

        BuyerForcastDeliverDetailAttachedDao attachedDao = getDao(BuyerForcastDeliverDetailAttachedDao.class);
        BuyerForcastDeliverDetailAttachedEntity attachedEntity = attachedDao.findOne(this.entity);
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
        BuyerForcastDeliverDetailDao dao = getDao(BuyerForcastDeliverDetailDao.class);
        BuyerForcastDeliverDetailAttachedDao attachedDao = getDao(BuyerForcastDeliverDetailAttachedDao.class);

        // 一意制约检测
        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME);
        // 设置ID
        this.entity.setBuyerForcastDeliverDetailId(id);
        this.attachedEntity.setBuyerForcastDeliverDetailId(id);

        // 设置待插入字段
        // TODO 对entity中待插入字段进行补全

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
        historyEntity = new BuyerForcastDeliverDetailHistoryEntity(entity);
        attachedHistoryEntity = new BuyerForcastDeliverDetailAttachedHistoryEntity(attachedEntity);
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
        BuyerForcastDeliverDetailDao dao = getDao(BuyerForcastDeliverDetailDao.class);
        BuyerForcastDeliverDetailAttachedDao attachedDao = getDao(BuyerForcastDeliverDetailAttachedDao.class);

        // 设置待修改字段
        // TODO 对entity中待插入字段进行补全

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
        BuyerForcastDeliverDetailDao dao = getDao(BuyerForcastDeliverDetailDao.class);
        BuyerForcastDeliverDetailAttachedDao attachedDao = getDao(BuyerForcastDeliverDetailAttachedDao.class);

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
        BuyerForcastDeliverDetailDao dao = getDao(BuyerForcastDeliverDetailDao.class);
        BuyerForcastDeliverDetailAttachedDao attachedDao = getDao(BuyerForcastDeliverDetailAttachedDao.class);

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
            return this.getClass().getName() + this.entity.getBuyerForcastDeliverDetailId();
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
    public BuyerForcastDeliverDetail forComplete(Long id) {
        logger.info(this + "#forComplete");
        BuyerForcastDeliverDetail build = new BuyerForcastDeliverDetail(id);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于插入数据库，此对象必须使用create方法插入数据库
     *
     */
    public BuyerForcastDeliverDetail forCreate(BuyerForcastDeliverDetailEntity entity, BuyerForcastDeliverDetailAttachedEntity attachedEntity) {
        logger.info(this + "#forCreate");
        BuyerForcastDeliverDetail build = new BuyerForcastDeliverDetail(entity, attachedEntity);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于根据entity.buyerBatchOrderDetailId查询数据，此对象必须使用complete方法补全
     *
     */
    public BuyerForcastDeliverDetail forComplete(BuyerBatchOrderDetail linkedArchive) {
        logger.info(this + "#forComplete");
        BuyerForcastDeliverDetail build = new BuyerForcastDeliverDetail(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于根据entity.buyerBatchOrderId查询数据，此对象必须使用complete方法补全
     *
     */
    public BuyerForcastDeliverDetail forComplete(BuyerBatchOrder linkedArchive) {
        logger.info(this + "#forComplete");
        BuyerForcastDeliverDetail build = new BuyerForcastDeliverDetail(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    }


}