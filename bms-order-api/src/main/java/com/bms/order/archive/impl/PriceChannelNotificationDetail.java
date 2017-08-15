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
import com.bms.order.bean.entity.PriceChannelNotificationDetailEntity;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.PriceChannelNotificationDetailDao;
import com.bms.order.util.LinkHelper;
import com.framework.exception.BusinessException;

/**
 *
 * 价格通道通知单明细

 * @author li_huiqian

 */
public class PriceChannelNotificationDetail extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(PriceChannelNotificationDetail.class);

    private static final String TABLE_NAME = "ORDR_PRICE_CHANNEL_NOTIFICATION_DETAIL";

    /** 价格通道通知单明细Entity */
    private PriceChannelNotificationDetailEntity entity;

    public PriceChannelNotificationDetailEntity getEntity() {
        logger.info(this + "#getEntity");
        return entity;
    }


    /** 价格通道通知单 */
    private PriceChannelNotification priceChannelNotification;

    private boolean isPriceChannelNotificationComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void priceChannelNotificationLinked() {
        logger.info(this + "#priceChannelNotificationLinked");
        isPriceChannelNotificationComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void priceChannelNotificationUnlink() {
        logger.info(this + "#priceChannelNotificationUnlink");
        isPriceChannelNotificationComplete = false;
    }

    public PriceChannelNotification getPriceChannelNotification() {
        logger.info(this + "#getPriceChannelNotification");
        if (!isDataSynced())
            return priceChannelNotification;

        if (priceChannelNotification == null || !isPriceChannelNotificationComplete) {
            PriceChannelNotification priceChannelNotification = new PriceChannelNotification(entity.getPriceChannelNotificationId());
            priceChannelNotification.setBlackboard(getBlackboard());
            priceChannelNotification.complete(false);
            isPriceChannelNotificationComplete = true;
            this.priceChannelNotification = null;
            if(priceChannelNotification.isDataSynced())
                link(priceChannelNotification);
        }

        return priceChannelNotification;
    }

    /**
     * 构造函数，已过时，请使用PriceChannelNotificationDetail.build(blackboard).forComplete(id)
     *
     */
    
    public  PriceChannelNotificationDetail(Long id) {
        logger.info(this + "#PriceChannelNotificationDetail");
        Assert.notNull(id);
        entity = new PriceChannelNotificationDetailEntity();
        entity.setPriceChannelNotificationDetailId(id);
    }

    /**
     * 构造函数，已过时，请使用PriceChannelNotificationDetail.build(blackboard).forCreate(entity,)
     *
     */
    
    public  PriceChannelNotificationDetail(PriceChannelNotificationDetailEntity entity) {
        logger.info(this + "#PriceChannelNotificationDetail");
        Assert.notNull(entity);
        this.entity = entity;
        setDataSynced(false);
    }

    /**
     * 构造函数，已过时，请使用PriceChannelNotificationDetail.build(blackboard).forComplete(linkedArchive)
     *
     */
    
    public  PriceChannelNotificationDetail(PriceChannelNotification linkedArchive) {
        logger.info(this + "#PriceChannelNotificationDetail");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getPriceChannelNotificationId());
        entity = new PriceChannelNotificationDetailEntity();
        entity.setPriceChannelNotificationId(linkedArchive.getEntity().getPriceChannelNotificationId());
    }

    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof PriceChannelNotification) {
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

        if (item0 instanceof PriceChannelNotification) {
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

        if (entity.getPriceChannelNotificationDetailId() != null) {
            PriceChannelNotificationDetailEntity entity = new PriceChannelNotificationDetailEntity();
            entity.setPriceChannelNotificationDetailId(this.entity.getPriceChannelNotificationDetailId());
            this.entity = entity;
        } else if (entity.getPriceChannelNotificationId() != null) {
            PriceChannelNotificationDetailEntity entity = new PriceChannelNotificationDetailEntity();
            entity.setPriceChannelNotificationId(this.entity.getPriceChannelNotificationId());
            this.entity = entity;
        }

        // 设置允许DEL_FLG=true
        if (allowDelete)
            this.entity.setDelFlg(true);
        else
            this.entity.setDelFlg(false);

        // 查询数据库
        PriceChannelNotificationDetailDao dao = getDao(PriceChannelNotificationDetailDao.class);
        PriceChannelNotificationDetailEntity entity = dao.findOne(this.entity);
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
        PriceChannelNotificationDetailDao dao = getDao(PriceChannelNotificationDetailDao.class);

        // 一意制约检测
        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME);
        // 设置ID
        this.entity.setPriceChannelNotificationDetailId(id);

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
        PriceChannelNotificationDetailDao dao = getDao(PriceChannelNotificationDetailDao.class);

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
        PriceChannelNotificationDetailDao dao = getDao(PriceChannelNotificationDetailDao.class);

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
            return this.getClass().getName() + this.entity.getPriceChannelNotificationDetailId();
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
    public PriceChannelNotificationDetail forComplete(Long id) {
        logger.info(this + "#forComplete");
        PriceChannelNotificationDetail build = new PriceChannelNotificationDetail(id);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于插入数据库，此对象必须使用create方法插入数据库
     *
     */
    public PriceChannelNotificationDetail forCreate(PriceChannelNotificationDetailEntity entity) {
        logger.info(this + "#forCreate");
        PriceChannelNotificationDetail build = new PriceChannelNotificationDetail(entity);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于根据entity.priceChannelNotificationId查询数据，此对象必须使用complete方法补全
     *
     */
    public PriceChannelNotificationDetail forComplete(PriceChannelNotification linkedArchive) {
        logger.info(this + "#forComplete");
        PriceChannelNotificationDetail build = new PriceChannelNotificationDetail(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    }


}