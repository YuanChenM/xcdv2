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
import com.bms.order.bean.entity.BuyerSellerDetailEntity;
import com.bms.order.dao.BuyerSellerDetailDao;
import com.bms.order.util.LinkHelper;
import com.framework.exception.BusinessException;
import com.bms.order.archive.impl.BuyerBatchOrderDetail;
import com.bms.order.bean.entity.BuyerBatchOrderDetailEntity;

/**
 *
 * 记录买家订单明细的供货人及供货要求信息

 * @author li_huiqian

 */
public class BuyerSellerDetail extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(BuyerSellerDetail.class);

    private static final String TABLE_NAME = "ORDR_BUYER_SELLER_DETAIL";

    /** 买家分批订单供货信息表Entity */
    private BuyerSellerDetailEntity entity;

    public BuyerSellerDetailEntity getEntity() {
        logger.info(this + "#getEntity");
        return entity;
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

    /**
     * 构造函数，已过时，请使用BuyerSellerDetail..forComplete(id)
     *
     */
    @Deprecated
    public  BuyerSellerDetail(Long id) {
        logger.info(this + "#BuyerSellerDetail");
        Assert.notNull(id);
        entity = new BuyerSellerDetailEntity();
        entity.setSellerDetailId(id);
    }

    /**
     * 构造函数，已过时，请使用BuyerSellerDetail..forCreate(entity,)
     *
     */
    @Deprecated
    public  BuyerSellerDetail(BuyerSellerDetailEntity entity) {
        logger.info(this + "#BuyerSellerDetail");
        Assert.notNull(entity);
        this.entity = entity;
        setDataSynced(false);
    }

    /**
     * 构造函数，已过时，请使用BuyerSellerDetail..forComplete(linkedArchive)
     *
     */
    @Deprecated
    public  BuyerSellerDetail(BuyerBatchOrderDetail linkedArchive) {
        logger.info(this + "#BuyerSellerDetail");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getBuyerBatchOrderDetailId());
        entity = new BuyerSellerDetailEntity();
        entity.setBuyerBatchOrderDetailId(linkedArchive.getEntity().getBuyerBatchOrderDetailId());
    }

    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof BuyerBatchOrderDetail) {
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

        if (item0 instanceof BuyerBatchOrderDetail) {
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

        if (entity.getSellerDetailId() != null) {
            BuyerSellerDetailEntity entity = new BuyerSellerDetailEntity();
            entity.setSellerDetailId(this.entity.getSellerDetailId());
            this.entity = entity;
        } else if (entity.getBuyerBatchOrderDetailId() != null) {
            BuyerSellerDetailEntity entity = new BuyerSellerDetailEntity();
            entity.setBuyerBatchOrderDetailId(this.entity.getBuyerBatchOrderDetailId());
            this.entity = entity;
        }

        // 设置允许DEL_FLG=true
        if (allowDelete)
            this.entity.setDelFlg(true);
        else
            this.entity.setDelFlg(false);

        // 查询数据库
        BuyerSellerDetailDao dao = getDao(BuyerSellerDetailDao.class);
        BuyerSellerDetailEntity entity = dao.findOne(this.entity);
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
        BuyerSellerDetailDao dao = getDao(BuyerSellerDetailDao.class);

        // 一意制约检测
        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME);
        // 设置ID
        this.entity.setSellerDetailId(id);

        // 设置待插入字段
        // TODO 对entity中待插入字段进行补全

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
        BuyerSellerDetailDao dao = getDao(BuyerSellerDetailDao.class);

        // 设置待修改字段
        // TODO 对entity中待插入字段进行补全

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
        BuyerSellerDetailDao dao = getDao(BuyerSellerDetailDao.class);

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
            return this.getClass().getName() + this.entity.getSellerDetailId();
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
    public BuyerSellerDetail forComplete(Long id) {
        logger.info(this + "#forComplete");
        BuyerSellerDetail build = new BuyerSellerDetail(id);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于插入数据库，此对象必须使用create方法插入数据库
     *
     */
    public BuyerSellerDetail forCreate(BuyerSellerDetailEntity entity) {
        logger.info(this + "#forCreate");
        BuyerSellerDetail build = new BuyerSellerDetail(entity);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于根据entity.buyerBatchOrderDetailId查询数据，此对象必须使用complete方法补全
     *
     */
    public BuyerSellerDetail forComplete(BuyerBatchOrderDetail linkedArchive) {
        logger.info(this + "#forComplete");
        BuyerSellerDetail build = new BuyerSellerDetail(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    }


}