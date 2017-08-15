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
import com.bms.order.archive.impl.list.PriceChannelNotificationDetailList;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.PriceChannelNotificationEntity;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.PriceChannelNotificationDao;
import com.bms.order.util.CodeRule;
import com.bms.order.util.LinkHelper;
import com.framework.exception.BusinessException;

/**
 *
 * 价格通道通知单

 * @author li_huiqian

 */
public class PriceChannelNotification extends AbstractArchive
        implements Completable, Createable, Linkable, Modifiable, Deletable, Codeable {

    private static Logger logger = LoggerFactory.getLogger(PriceChannelNotification.class);

    private static final String TABLE_NAME = "ORDR_PRICE_CHANNEL_NOTIFICATION";

    /** 价格通道通知单Entity */
    private PriceChannelNotificationEntity entity;

    public PriceChannelNotificationEntity getEntity() {
        logger.info(this + "#getEntity");
        return entity;
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
            buyerOrder.priceChannelNotificationLinked();
        }

        return buyerOrder;
    }
    /** 价格通道通知单明细 */
    private List<PriceChannelNotificationDetail> priceChannelNotificationDetails;

    private boolean isPriceChannelNotificationDetailsComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void priceChannelNotificationDetailsLinked() {
        logger.info(this + "#priceChannelNotificationDetailsLinked");
        isPriceChannelNotificationDetailsComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void priceChannelNotificationDetailsUnlink() {
        logger.info(this + "#priceChannelNotificationDetailsUnlink");
        isPriceChannelNotificationDetailsComplete = false;
    }

    public List<PriceChannelNotificationDetail> getPriceChannelNotificationDetails() {
        logger.info(this + "#getPriceChannelNotificationDetails");
        if (!isDataSynced())
            return priceChannelNotificationDetails;

        if (priceChannelNotificationDetails == null || !isPriceChannelNotificationDetailsComplete) {
            PriceChannelNotificationDetailList list = new PriceChannelNotificationDetailList(this);
            list.setBlackboard(getBlackboard());
            list.complete(false);
            isPriceChannelNotificationDetailsComplete = true;
            priceChannelNotificationDetails = null;
            if(list.isDataSynced()) {
                link(list.getArchives());
                for (PriceChannelNotificationDetail item : priceChannelNotificationDetails)
                    item.priceChannelNotificationLinked();
            }
        }

        return priceChannelNotificationDetails;
    }

    /**
     * 构造函数，已过时，请使用PriceChannelNotification.build(blackboard).forComplete(id)
     *
     */
    
    public  PriceChannelNotification(Long id) {
        logger.info(this + "#PriceChannelNotification");
        Assert.notNull(id);
        entity = new PriceChannelNotificationEntity();
        entity.setPriceChannelNotificationId(id);
    }

    /**
     * 构造函数，已过时，请使用PriceChannelNotification.build(blackboard).forComplete(code)
     *
     */
    
    public  PriceChannelNotification(String code) {
        logger.info(this + "#PriceChannelNotification");
        Assert.notNull(code);
        entity = new PriceChannelNotificationEntity();
        entity.setPriceChannelNotificationCode(code);
    }

    /**
     * 构造函数，已过时，请使用PriceChannelNotification.build(blackboard).forCreate(entity,)
     *
     */
    
    public  PriceChannelNotification(PriceChannelNotificationEntity entity) {
        logger.info(this + "#PriceChannelNotification");
        Assert.notNull(entity);
        this.entity = entity;
        setDataSynced(false);
    }

    /**
     * 构造函数，已过时，请使用PriceChannelNotification.build(blackboard).forComplete(linkedArchive)
     *
     */
    
    public  PriceChannelNotification(BuyerOrder linkedArchive) {
        logger.info(this + "#PriceChannelNotification");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getBuyerOrderId());
        entity = new PriceChannelNotificationEntity();
        entity.setBuyerOrderId(linkedArchive.getEntity().getBuyerOrderId());
    }

    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof BuyerOrder) {
            LinkHelper.link(this, target, "entity.buyerOrderId");
        
        } else if (target instanceof PriceChannelNotificationDetail) {
            LinkHelper.link(this, target, "entity.priceChannelNotificationId");
        
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
        
        } else if (item0 instanceof PriceChannelNotificationDetail) {
            LinkHelper.link(this, targets, "entity.priceChannelNotificationId");
        
        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        // 判断是否是最新
        if (isDataSynced()) {
            return;
        }

        if (entity.getPriceChannelNotificationId() != null) {
            PriceChannelNotificationEntity entity = new PriceChannelNotificationEntity();
            entity.setPriceChannelNotificationId(this.entity.getPriceChannelNotificationId());
            this.entity = entity;
        } else if (entity.getPriceChannelNotificationCode() != null) {
            PriceChannelNotificationEntity entity = new PriceChannelNotificationEntity();
            entity.setPriceChannelNotificationCode(this.entity.getPriceChannelNotificationCode());
            this.entity = entity;
        } else if (entity.getBuyerOrderId() != null) {
            PriceChannelNotificationEntity entity = new PriceChannelNotificationEntity();
            entity.setBuyerOrderId(this.entity.getBuyerOrderId());
            this.entity = entity;
        }

        // 设置允许DEL_FLG=true
        if (allowDelete)
            this.entity.setDelFlg(true);
        else
            this.entity.setDelFlg(false);

        // 查询数据库
        PriceChannelNotificationDao dao = getDao(PriceChannelNotificationDao.class);
        PriceChannelNotificationEntity entity = dao.findOne(this.entity);
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
        PriceChannelNotificationDao dao = getDao(PriceChannelNotificationDao.class);

        // 生成编码
        generateCode();

        // 一意制约检测
        PriceChannelNotification unique = new PriceChannelNotification(entity.getPriceChannelNotificationCode());
        unique.setBlackboard(getBlackboard());
        unique.complete(false);
        if (unique.isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000004);
        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME);
        // 设置ID
        this.entity.setPriceChannelNotificationId(id);

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
        PriceChannelNotificationDao dao = getDao(PriceChannelNotificationDao.class);

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
        PriceChannelNotificationDao dao = getDao(PriceChannelNotificationDao.class);

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
            return this.getClass().getName() + this.entity.getPriceChannelNotificationId();
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
    public PriceChannelNotification forComplete(Long id) {
        logger.info(this + "#forComplete");
        PriceChannelNotification build = new PriceChannelNotification(id);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于根据code查询数据，此对象必须使用complete方法补全
     *
     */
    public PriceChannelNotification forComplete(String code) {
        logger.info(this + "#forComplete");
        PriceChannelNotification build = new PriceChannelNotification(code);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于插入数据库，此对象必须使用create方法插入数据库
     *
     */
    public PriceChannelNotification forCreate(PriceChannelNotificationEntity entity) {
        logger.info(this + "#forCreate");
        PriceChannelNotification build = new PriceChannelNotification(entity);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于根据entity.buyerOrderId查询数据，此对象必须使用complete方法补全
     *
     */
    public PriceChannelNotification forComplete(BuyerOrder linkedArchive) {
        logger.info(this + "#forComplete");
        PriceChannelNotification build = new PriceChannelNotification(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    }

    @Override
    public void generateCode() {
        entity.setPriceChannelNotificationCode(CodeRule.commonRule("JGTZ"));
    }

}