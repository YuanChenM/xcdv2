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
import com.bms.order.bean.entity.BuyerReturnDetailEntity;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.BuyerReturnDetailDao;
import com.bms.order.util.LinkHelper;
import com.framework.exception.BusinessException;

/**
 *
 * 买家退货订单明细信息

 * @author li_huiqian

 */
public class BuyerReturnDetail extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(BuyerReturnDetail.class);

    private static final String TABLE_NAME = "ORDR_BUYER_RETURN_DETAIL";

    /** 买家退货订单明细Entity */
    private BuyerReturnDetailEntity entity;

    public BuyerReturnDetailEntity getEntity() {
        logger.info(this + "#getEntity");
        return entity;
    }


    /** 收货通知单明细 */
    private ReceiveNotificationDetail receiveNotificationDetail;

    private boolean isReceiveNotificationDetailComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void receiveNotificationDetailLinked() {
        logger.info(this + "#receiveNotificationDetailLinked");
        isReceiveNotificationDetailComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void receiveNotificationDetailUnlink() {
        logger.info(this + "#receiveNotificationDetailUnlink");
        isReceiveNotificationDetailComplete = false;
    }

    public ReceiveNotificationDetail getReceiveNotificationDetail() {
        logger.info(this + "#getReceiveNotificationDetail");
        if (!isDataSynced())
            return receiveNotificationDetail;

        if (receiveNotificationDetail == null || !isReceiveNotificationDetailComplete) {
            ReceiveNotificationDetail receiveNotificationDetail = new ReceiveNotificationDetail(entity.getReceiveNotificationDetailId());
            receiveNotificationDetail.setBlackboard(getBlackboard());
            receiveNotificationDetail.complete(false);
            isReceiveNotificationDetailComplete = true;
            this.receiveNotificationDetail = null;
            if(receiveNotificationDetail.isDataSynced())
                link(receiveNotificationDetail);
        }

        return receiveNotificationDetail;
    }
    /** 买家退货主表 */
    private BuyerReturn buyerReturn;

    private boolean isBuyerReturnComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void buyerReturnLinked() {
        logger.info(this + "#buyerReturnLinked");
        isBuyerReturnComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void buyerReturnUnlink() {
        logger.info(this + "#buyerReturnUnlink");
        isBuyerReturnComplete = false;
    }

    public BuyerReturn getBuyerReturn() {
        logger.info(this + "#getBuyerReturn");
        if (!isDataSynced())
            return buyerReturn;

        if (buyerReturn == null || !isBuyerReturnComplete) {
            BuyerReturn buyerReturn = new BuyerReturn(entity.getReturnId());
            buyerReturn.setBlackboard(getBlackboard());
            buyerReturn.complete(false);
            isBuyerReturnComplete = true;
            this.buyerReturn = null;
            if(buyerReturn.isDataSynced())
                link(buyerReturn);
        }

        return buyerReturn;
    }
    /** 退货原因表 */
    private ReturnReason returnReason;

    private boolean isReturnReasonComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void returnReasonLinked() {
        logger.info(this + "#returnReasonLinked");
        isReturnReasonComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void returnReasonUnlink() {
        logger.info(this + "#returnReasonUnlink");
        isReturnReasonComplete = false;
    }

    public ReturnReason getReturnReason() {
        logger.info(this + "#getReturnReason");
        if (!isDataSynced())
            return returnReason;

        if (returnReason == null || !isReturnReasonComplete) {
            ReturnReason returnReason = new ReturnReason(entity.getReasonId());
            returnReason.setBlackboard(getBlackboard());
            returnReason.complete(false);
            isReturnReasonComplete = true;
            this.returnReason = null;
            if(returnReason.isDataSynced())
                link(returnReason);
            returnReason.buyerReturnDetailLinked();
        }

        return returnReason;
    }

    /**
     * 构造函数，已过时，请使用BuyerReturnDetail.build(blackboard).forComplete(id)
     *
     */
    
    public  BuyerReturnDetail(Long id) {
        logger.info(this + "#BuyerReturnDetail");
        Assert.notNull(id);
        entity = new BuyerReturnDetailEntity();
        entity.setDetailId(id);
    }

    /**
     * 构造函数，已过时，请使用BuyerReturnDetail.build(blackboard).forCreate(entity,)
     *
     */
    
    public  BuyerReturnDetail(BuyerReturnDetailEntity entity) {
        logger.info(this + "#BuyerReturnDetail");
        Assert.notNull(entity);
        this.entity = entity;
        setDataSynced(false);
    }

    /**
     * 构造函数，已过时，请使用BuyerReturnDetail.build(blackboard).forComplete(linkedArchive)
     *
     */
    
    public  BuyerReturnDetail(ReceiveNotificationDetail linkedArchive) {
        logger.info(this + "#BuyerReturnDetail");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getReceiveNotificationDetailId());
        entity = new BuyerReturnDetailEntity();
        entity.setReceiveNotificationDetailId(linkedArchive.getEntity().getReceiveNotificationDetailId());
    }
    /**
     * 构造函数，已过时，请使用BuyerReturnDetail.build(blackboard).forComplete(linkedArchive)
     *
     */
    
    public  BuyerReturnDetail(BuyerReturn linkedArchive) {
        logger.info(this + "#BuyerReturnDetail");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getReturnId());
        entity = new BuyerReturnDetailEntity();
        entity.setReturnId(linkedArchive.getEntity().getReturnId());
    }
    /**
     * 构造函数，已过时，请使用BuyerReturnDetail.build(blackboard).forComplete(linkedArchive)
     *
     */
    
    public  BuyerReturnDetail(ReturnReason linkedArchive) {
        logger.info(this + "#BuyerReturnDetail");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getReasonId());
        entity = new BuyerReturnDetailEntity();
        entity.setReasonId(linkedArchive.getEntity().getReasonId());
    }

    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof ReceiveNotificationDetail) {
            LinkHelper.link(this, target, "entity.receiveNotificationDetailId");
        
        } else if (target instanceof BuyerReturn) {
            LinkHelper.link(this, target, "entity.returnId");
        
        } else if (target instanceof ReturnReason) {
            LinkHelper.link(this, target, "entity.reasonId");
        
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

        if (item0 instanceof ReceiveNotificationDetail) {
            LinkHelper.link(this, targets, "entity.receiveNotificationDetailId");
        
        } else if (item0 instanceof BuyerReturn) {
            LinkHelper.link(this, targets, "entity.returnId");
        
        } else if (item0 instanceof ReturnReason) {
            LinkHelper.link(this, targets, "entity.reasonId");
        
        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        // 判断是否是最新
        if (isDataSynced()) {
            return;
        }

        if (entity.getDetailId() != null) {
            BuyerReturnDetailEntity entity = new BuyerReturnDetailEntity();
            entity.setDetailId(this.entity.getDetailId());
            this.entity = entity;
        } else if (entity.getReceiveNotificationDetailId() != null) {
            BuyerReturnDetailEntity entity = new BuyerReturnDetailEntity();
            entity.setReceiveNotificationDetailId(this.entity.getReceiveNotificationDetailId());
            this.entity = entity;
        } else if (entity.getReturnId() != null) {
            BuyerReturnDetailEntity entity = new BuyerReturnDetailEntity();
            entity.setReturnId(this.entity.getReturnId());
            this.entity = entity;
        } else if (entity.getReasonId() != null) {
            BuyerReturnDetailEntity entity = new BuyerReturnDetailEntity();
            entity.setReasonId(this.entity.getReasonId());
            this.entity = entity;
        }

        // 设置允许DEL_FLG=true
        if (allowDelete)
            this.entity.setDelFlg(true);
        else
            this.entity.setDelFlg(false);

        // 查询数据库
        BuyerReturnDetailDao dao = getDao(BuyerReturnDetailDao.class);
        BuyerReturnDetailEntity entity = dao.findOne(this.entity);
        if (entity == null)
            return;
        this.entity = entity;

        setDataSynced(true);

    }

    @Override
    public void create() {
        logger.info(this + "#create");
        Assert.notNull(entity);

        // 判断是否需要创建
        if (isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000003);

        // 获取Dao
        BuyerReturnDetailDao dao = getDao(BuyerReturnDetailDao.class);

        // 一意制约检测
        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME);
        // 设置ID
        this.entity.setDetailId(id);

        // 设置共通字段
        insertCommon(this.entity);

        // 插入数据库
        int count = dao.save(this.entity);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000005);

        setDataSynced(true);

    }


    @Override
    public void modify() {
        logger.info(this + "#modify");
        Assert.notNull(entity);

        // 判断是否需要修改
        if (!isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000006);

        // 获取Dao
        BuyerReturnDetailDao dao = getDao(BuyerReturnDetailDao.class);

        // 设置共通字段
        updateCommon(this.entity);

        // 更新数据库带排他检测
        int count = dao.modify(this.entity);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000007);

    }

    @Override
    public void delete() {
        logger.info(this + "#delete");
        Assert.notNull(entity);

        // 判断是否需要删除
        if (!isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000008);

        // 获取Dao
        BuyerReturnDetailDao dao = getDao(BuyerReturnDetailDao.class);

        // 设置共通字段
        deleteCommon(this.entity);

        // 删除数据库带排他检测
        int count = dao.delete(this.entity);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000009);

    }


    @Override
    public String toString() {
        if (entity != null)
            return this.getClass().getName() + this.entity.getDetailId();
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
    public BuyerReturnDetail forComplete(Long id) {
        logger.info(this + "#forComplete");
        BuyerReturnDetail build = new BuyerReturnDetail(id);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于插入数据库，此对象必须使用create方法插入数据库
     *
     */
    public BuyerReturnDetail forCreate(BuyerReturnDetailEntity entity) {
        logger.info(this + "#forCreate");
        BuyerReturnDetail build = new BuyerReturnDetail(entity);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于根据entity.receiveNotificationDetailId查询数据，此对象必须使用complete方法补全
     *
     */
    public BuyerReturnDetail forComplete(ReceiveNotificationDetail linkedArchive) {
        logger.info(this + "#forComplete");
        BuyerReturnDetail build = new BuyerReturnDetail(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于根据entity.returnId查询数据，此对象必须使用complete方法补全
     *
     */
    public BuyerReturnDetail forComplete(BuyerReturn linkedArchive) {
        logger.info(this + "#forComplete");
        BuyerReturnDetail build = new BuyerReturnDetail(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于根据entity.reasonId查询数据，此对象必须使用complete方法补全
     *
     */
    public BuyerReturnDetail forComplete(ReturnReason linkedArchive) {
        logger.info(this + "#forComplete");
        BuyerReturnDetail build = new BuyerReturnDetail(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    }


}