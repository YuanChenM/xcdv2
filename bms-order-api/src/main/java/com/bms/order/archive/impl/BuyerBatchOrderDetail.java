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
import com.bms.order.archive.impl.list.BuyerForcastDeliverDetailList;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.BuyerBatchOrderDetailAttachedEntity;
import com.bms.order.bean.entity.BuyerBatchOrderDetailAttachedHistoryEntity;
import com.bms.order.bean.entity.BuyerBatchOrderDetailEntity;
import com.bms.order.bean.entity.BuyerBatchOrderDetailHistoryEntity;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.BuyerBatchOrderDetailAttachedDao;
import com.bms.order.dao.BuyerBatchOrderDetailDao;
import com.bms.order.util.LinkHelper;
import com.framework.exception.BusinessException;
import com.bms.order.archive.impl.BuyerOrder;
import com.bms.order.bean.entity.BuyerOrderEntity;
import com.bms.order.archive.impl.BuyerBatchOrder;
import com.bms.order.bean.entity.BuyerBatchOrderEntity;
import com.bms.order.archive.impl.BuyerForcastDeliverDetail;
import com.bms.order.archive.impl.list.BuyerForcastDeliverDetailList;
import com.bms.order.archive.impl.BuyerSellerDetail;
import com.bms.order.archive.impl.list.BuyerSellerDetailList;

/**
 *
 * 订单明细表，订单的原始信息，与客户提交的订单保持一致

 * @author li_huiqian

 */
public class BuyerBatchOrderDetail extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(BuyerBatchOrderDetail.class);

    private static final String TABLE_NAME = "ORDR_BUYER_BATCH_ORDER_DETAIL";
    private static final String HISTORY_TABLE_NAME = "ORDR_BUYER_BATCH_ORDER_DETAIL_HISTORY";

    /** 买家分批订单明细Entity */
    private BuyerBatchOrderDetailEntity entity;

    public BuyerBatchOrderDetailEntity getEntity() {
        logger.info(this + "#getEntity");
        return entity;
    }

    /** 买家分批订单明细履历表Entity */
    private BuyerBatchOrderDetailHistoryEntity historyEntity;

    public BuyerBatchOrderDetailHistoryEntity getHistoryEntity() {
        logger.info(this + "#getHistoryEntity");
        return historyEntity;
    }

    /** 买家分批订单明细附表Entity */
    private BuyerBatchOrderDetailAttachedEntity attachedEntity;

    public BuyerBatchOrderDetailAttachedEntity getAttachedEntity() {
        logger.info(this + "#getAttachedEntity");
        return attachedEntity;
    }

    /** 买家分批订单明细附表履历表Entity */
    private BuyerBatchOrderDetailAttachedHistoryEntity attachedHistoryEntity;

    public BuyerBatchOrderDetailAttachedHistoryEntity getAttachedHistoryEntity() {
        logger.info(this + "#getAttachedHistoryEntity");
        return attachedHistoryEntity;
    }


    /** 订单主表 */
    private BuyerOrder buyerOrder;

    private boolean isBuyerOrderComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void buyerOrderLinked() {
        logger.info(this + "#buyerOrderLinked");
        isBuyerOrderComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void buyerOrderUnlink() {
        logger.info(this + "#buyerOrderUnlink");
        isBuyerOrderComplete = false;
    }

    public BuyerOrder getBuyerOrder() {
        logger.info(this + "#getBuyerOrder");
        if (!isDataSynced())
            return buyerOrder;

        if (buyerOrder == null || !isBuyerOrderComplete) {
            BuyerOrder buyerOrder = new BuyerOrder(entity.getBuyerOrderId());
            buyerOrder.setBlackboard(getBlackboard());
            buyerOrder.complete(false);
            isBuyerOrderComplete = true;
            this.buyerOrder = null;
            if(buyerOrder.isDataSynced())
                link(buyerOrder);
        }

        return buyerOrder;
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
    /** 买家订单预配送明细表 */
    private List<BuyerForcastDeliverDetail> buyerForcastDeliverDetails;

    private boolean isBuyerForcastDeliverDetailsComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void buyerForcastDeliverDetailsLinked() {
        logger.info(this + "#buyerForcastDeliverDetailsLinked");
        isBuyerForcastDeliverDetailsComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void buyerForcastDeliverDetailsUnlink() {
        logger.info(this + "#buyerForcastDeliverDetailsUnlink");
        isBuyerForcastDeliverDetailsComplete = false;
    }

    public List<BuyerForcastDeliverDetail> getBuyerForcastDeliverDetails() {
        logger.info(this + "#getBuyerForcastDeliverDetails");
        if (!isDataSynced())
            return buyerForcastDeliverDetails;

        if (buyerForcastDeliverDetails == null || !isBuyerForcastDeliverDetailsComplete) {
            BuyerForcastDeliverDetailList list = new BuyerForcastDeliverDetailList(this);
            list.setBlackboard(getBlackboard());
            list.complete(false);
            isBuyerForcastDeliverDetailsComplete = true;
            buyerForcastDeliverDetails = null;
            if(list.isDataSynced()) {
                link(list.getArchives());
                for (BuyerForcastDeliverDetail item : buyerForcastDeliverDetails)
                    item.buyerBatchOrderDetailLinked();
            }
        }

        return buyerForcastDeliverDetails;
    }
    /** 记录买家订单明细的供货人及供货要求信息 */
    private List<BuyerSellerDetail> buyerSellerDetails;

    private boolean isBuyerSellerDetailsComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void buyerSellerDetailsLinked() {
        logger.info(this + "#buyerSellerDetailsLinked");
        isBuyerSellerDetailsComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void buyerSellerDetailsUnlink() {
        logger.info(this + "#buyerSellerDetailsUnlink");
        isBuyerSellerDetailsComplete = false;
    }

    public List<BuyerSellerDetail> getBuyerSellerDetails() {
        logger.info(this + "#getBuyerSellerDetails");
        if (!isDataSynced())
            return buyerSellerDetails;

        if (buyerSellerDetails == null || !isBuyerSellerDetailsComplete) {
            BuyerSellerDetailList list = new BuyerSellerDetailList(this);
            list.setBlackboard(getBlackboard());
            list.complete(false);
            isBuyerSellerDetailsComplete = true;
            buyerSellerDetails = null;
            if(list.isDataSynced()) {
                link(list.getArchives());
                for (BuyerSellerDetail item : buyerSellerDetails)
                    item.buyerBatchOrderDetailLinked();
            }
        }

        return buyerSellerDetails;
    }

    /**
     * 构造函数，已过时，请使用BuyerBatchOrderDetail..forComplete(id)
     *
     */
    @Deprecated
    public  BuyerBatchOrderDetail(Long id) {
        logger.info(this + "#BuyerBatchOrderDetail");
        Assert.notNull(id);
        entity = new BuyerBatchOrderDetailEntity();
        entity.setBuyerBatchOrderDetailId(id);
    }

    /**
     * 构造函数，已过时，请使用BuyerBatchOrderDetail.build(blackboard).forCreate(entity,,BuyerBatchOrderDetailAttachedEntity)
     *
     */
    
    public  BuyerBatchOrderDetail(BuyerBatchOrderDetailEntity entity, BuyerBatchOrderDetailAttachedEntity attachedEntity) {
        logger.info(this + "#BuyerBatchOrderDetail");
        Assert.notNull(entity);
        Assert.notNull(attachedEntity);
        this.entity = entity;
        this.attachedEntity = attachedEntity;
        setDataSynced(false);
    }

    /**
     * 构造函数，已过时，请使用BuyerBatchOrderDetail.build(blackboard).forComplete(linkedArchive)
     *
     */
    
    public  BuyerBatchOrderDetail(BuyerOrder linkedArchive) {
        logger.info(this + "#BuyerBatchOrderDetail");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getBuyerOrderId());
        entity = new BuyerBatchOrderDetailEntity();
        entity.setBuyerOrderId(linkedArchive.getEntity().getBuyerOrderId());
    }
    /**
     * 构造函数，已过时，请使用BuyerBatchOrderDetail.build(blackboard).forComplete(linkedArchive)
     *
     */
    
    public  BuyerBatchOrderDetail(BuyerBatchOrder linkedArchive) {
        logger.info(this + "#BuyerBatchOrderDetail");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getBuyerBatchOrderId());
        entity = new BuyerBatchOrderDetailEntity();
        entity.setBuyerBatchOrderId(linkedArchive.getEntity().getBuyerBatchOrderId());
    }

    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof BuyerOrder) {
            LinkHelper.link(this, target, "entity.buyerOrderId");
        
        } else if (target instanceof BuyerBatchOrder) {
            LinkHelper.link(this, target, "entity.buyerBatchOrderId");
        
        } else if (target instanceof BuyerForcastDeliverDetail) {
            LinkHelper.link(this, target, "entity.buyerBatchOrderDetailId");
        
        } else if (target instanceof BuyerSellerDetail) {
            LinkHelper.link(this, target, "entity.buyerBatchOrderDetailId");
        
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

        if (item0 instanceof BuyerOrder) {
            LinkHelper.link(this, targets, "entity.buyerOrderId");
        
        } else if (item0 instanceof BuyerBatchOrder) {
            LinkHelper.link(this, targets, "entity.buyerBatchOrderId");
        
        } else if (item0 instanceof BuyerForcastDeliverDetail) {
            LinkHelper.link(this, targets, "entity.buyerBatchOrderDetailId");
        
        } else if (item0 instanceof BuyerSellerDetail) {
            LinkHelper.link(this, targets, "entity.buyerBatchOrderDetailId");
        
        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        // 判断是否是最新
        if (isDataSynced()) {
            return;
        }

        if (entity.getBuyerBatchOrderDetailId() != null) {
            BuyerBatchOrderDetailEntity entity = new BuyerBatchOrderDetailEntity();
            entity.setBuyerBatchOrderDetailId(this.entity.getBuyerBatchOrderDetailId());
            this.entity = entity;
        } else if (entity.getBuyerOrderId() != null) {
            BuyerBatchOrderDetailEntity entity = new BuyerBatchOrderDetailEntity();
            entity.setBuyerOrderId(this.entity.getBuyerOrderId());
            this.entity = entity;
        } else if (entity.getBuyerBatchOrderId() != null) {
            BuyerBatchOrderDetailEntity entity = new BuyerBatchOrderDetailEntity();
            entity.setBuyerBatchOrderId(this.entity.getBuyerBatchOrderId());
            this.entity = entity;
        }

        // 设置允许DEL_FLG=true
        if (allowDelete)
            this.entity.setDelFlg(true);
        else
            this.entity.setDelFlg(false);

        // 查询数据库
        BuyerBatchOrderDetailDao dao = getDao(BuyerBatchOrderDetailDao.class);
        BuyerBatchOrderDetailEntity entity = dao.findOne(this.entity);
        if (entity == null)
            return;
        this.entity = entity;

        BuyerBatchOrderDetailAttachedDao attachedDao = getDao(BuyerBatchOrderDetailAttachedDao.class);
        BuyerBatchOrderDetailAttachedEntity attachedEntity = attachedDao.findOne(this.entity);
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
        BuyerBatchOrderDetailDao dao = getDao(BuyerBatchOrderDetailDao.class);
        BuyerBatchOrderDetailAttachedDao attachedDao = getDao(BuyerBatchOrderDetailAttachedDao.class);

        // 一意制约检测
        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME);
        // 设置ID
        this.entity.setBuyerBatchOrderDetailId(id);
        this.attachedEntity.setBuyerBatchOrderDetailId(id);

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
        historyEntity = new BuyerBatchOrderDetailHistoryEntity(entity);
        attachedHistoryEntity = new BuyerBatchOrderDetailAttachedHistoryEntity(attachedEntity);
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
        BuyerBatchOrderDetailDao dao = getDao(BuyerBatchOrderDetailDao.class);
        BuyerBatchOrderDetailAttachedDao attachedDao = getDao(BuyerBatchOrderDetailAttachedDao.class);

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
        BuyerBatchOrderDetailDao dao = getDao(BuyerBatchOrderDetailDao.class);
        BuyerBatchOrderDetailAttachedDao attachedDao = getDao(BuyerBatchOrderDetailAttachedDao.class);

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
        BuyerBatchOrderDetailDao dao = getDao(BuyerBatchOrderDetailDao.class);
        BuyerBatchOrderDetailAttachedDao attachedDao = getDao(BuyerBatchOrderDetailAttachedDao.class);

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
            return this.getClass().getName() + this.entity.getBuyerBatchOrderDetailId();
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
    public BuyerBatchOrderDetail forComplete(Long id) {
        logger.info(this + "#forComplete");
        BuyerBatchOrderDetail build = new BuyerBatchOrderDetail(id);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于插入数据库，此对象必须使用create方法插入数据库
     *
     */
    public BuyerBatchOrderDetail forCreate(BuyerBatchOrderDetailEntity entity, BuyerBatchOrderDetailAttachedEntity attachedEntity) {
        logger.info(this + "#forCreate");
        BuyerBatchOrderDetail build = new BuyerBatchOrderDetail(entity, attachedEntity);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于根据entity.buyerOrderId查询数据，此对象必须使用complete方法补全
     *
     */
    public BuyerBatchOrderDetail forComplete(BuyerOrder linkedArchive) {
        logger.info(this + "#forComplete");
        BuyerBatchOrderDetail build = new BuyerBatchOrderDetail(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于根据entity.buyerBatchOrderId查询数据，此对象必须使用complete方法补全
     *
     */
    public BuyerBatchOrderDetail forComplete(BuyerBatchOrder linkedArchive) {
        logger.info(this + "#forComplete");
        BuyerBatchOrderDetail build = new BuyerBatchOrderDetail(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    }


}