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
import com.bms.order.bean.entity.SendNotificationDetailEntity;
import com.bms.order.bean.entity.SendNotificationDetailHistoryEntity;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.SendNotificationDetailDao;
import com.bms.order.util.LinkHelper;
import com.framework.exception.BusinessException;

/**
 *
 * 发货通知单明细

 * @author li_huiqian

 */
public class SendNotificationDetail extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(SendNotificationDetail.class);

    private static final String TABLE_NAME = "ORDR_SEND_NOTIFICATION_DETAIL";
    private static final String HISTORY_TABLE_NAME = "ORDR_SEND_NOTIFICATION_DETAIL_HISTORY";

    /** 发货通知单明细Entity */
    private SendNotificationDetailEntity entity;

    public SendNotificationDetailEntity getEntity() {
        logger.info(this + "#getEntity");
        return entity;
    }

    /** 发货通知单明细履历表Entity */
    private SendNotificationDetailHistoryEntity historyEntity;

    public SendNotificationDetailHistoryEntity getHistoryEntity() {
        logger.info(this + "#getHistoryEntity");
        return historyEntity;
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
            DistributionNotificationDetail distributionNotificationDetail = new DistributionNotificationDetail(entity.getDistributionNotificationDetailId());
            distributionNotificationDetail.setBlackboard(getBlackboard());
            distributionNotificationDetail.complete(false);
            isDistributionNotificationDetailComplete = true;
            this.distributionNotificationDetail = null;
            if(distributionNotificationDetail.isDataSynced())
                link(distributionNotificationDetail);
        }

        return distributionNotificationDetail;
    }
    /** 发货通知单 */
    private SendNotification sendNotification;

    private boolean isSendNotificationComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void sendNotificationLinked() {
        logger.info(this + "#sendNotificationLinked");
        isSendNotificationComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void sendNotificationUnlink() {
        logger.info(this + "#sendNotificationUnlink");
        isSendNotificationComplete = false;
    }

    public SendNotification getSendNotification() {
        logger.info(this + "#getSendNotification");
        if (!isDataSynced())
            return sendNotification;

        if (sendNotification == null || !isSendNotificationComplete) {
            SendNotification sendNotification = new SendNotification(entity.getSendNotificationId());
            sendNotification.setBlackboard(getBlackboard());
            sendNotification.complete(false);
            isSendNotificationComplete = true;
            this.sendNotification = null;
            if(sendNotification.isDataSynced())
                link(sendNotification);
        }

        return sendNotification;
    }

    /**
     * 构造函数，已过时，请使用SendNotificationDetail.build(blackboard).forComplete(id)
     *
     */
    
    public  SendNotificationDetail(Long id) {
        logger.info(this + "#SendNotificationDetail");
        Assert.notNull(id);
        entity = new SendNotificationDetailEntity();
        entity.setSendNotificationDetailId(id);
    }

    /**
     * 构造函数，已过时，请使用SendNotificationDetail.build(blackboard).forCreate(entity,)
     *
     */
    
    public  SendNotificationDetail(SendNotificationDetailEntity entity) {
        logger.info(this + "#SendNotificationDetail");
        Assert.notNull(entity);
        this.entity = entity;
        setDataSynced(false);
    }

    /**
     * 构造函数，已过时，请使用SendNotificationDetail.build(blackboard).forComplete(linkedArchive)
     *
     */
    
    public  SendNotificationDetail(DistributionNotificationDetail linkedArchive) {
        logger.info(this + "#SendNotificationDetail");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getDistributionNotificationDetailId());
        entity = new SendNotificationDetailEntity();
        entity.setDistributionNotificationDetailId(linkedArchive.getEntity().getDistributionNotificationDetailId());
    }
    /**
     * 构造函数，已过时，请使用SendNotificationDetail.build(blackboard).forComplete(linkedArchive)
     *
     */
    
    public  SendNotificationDetail(SendNotification linkedArchive) {
        logger.info(this + "#SendNotificationDetail");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getSendNotificationId());
        entity = new SendNotificationDetailEntity();
        entity.setSendNotificationId(linkedArchive.getEntity().getSendNotificationId());
    }

    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof DistributionNotificationDetail) {
            LinkHelper.link(this, target, "entity.distributionNotificationDetailId");
        
        } else if (target instanceof SendNotification) {
            LinkHelper.link(this, target, "entity.sendNotificationId");
        
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

        if (item0 instanceof DistributionNotificationDetail) {
            LinkHelper.link(this, targets, "entity.distributionNotificationDetailId");
        
        } else if (item0 instanceof SendNotification) {
            LinkHelper.link(this, targets, "entity.sendNotificationId");
        
        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        // 判断是否是最新
        if (isDataSynced()) {
            return;
        }

        if (entity.getSendNotificationDetailId() != null) {
            SendNotificationDetailEntity entity = new SendNotificationDetailEntity();
            entity.setSendNotificationDetailId(this.entity.getSendNotificationDetailId());
            this.entity = entity;
        } else if (entity.getDistributionNotificationDetailId() != null) {
            SendNotificationDetailEntity entity = new SendNotificationDetailEntity();
            entity.setDistributionNotificationDetailId(this.entity.getDistributionNotificationDetailId());
            this.entity = entity;
        } else if (entity.getSendNotificationId() != null) {
            SendNotificationDetailEntity entity = new SendNotificationDetailEntity();
            entity.setSendNotificationId(this.entity.getSendNotificationId());
            this.entity = entity;
        }

        // 设置允许DEL_FLG=true
        if (allowDelete)
            this.entity.setDelFlg(true);
        else
            this.entity.setDelFlg(false);

        // 查询数据库
        SendNotificationDetailDao dao = getDao(SendNotificationDetailDao.class);
        SendNotificationDetailEntity entity = dao.findOne(this.entity);
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
        SendNotificationDetailDao dao = getDao(SendNotificationDetailDao.class);

        // 一意制约检测
        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME);
        // 设置ID
        this.entity.setSendNotificationDetailId(id);

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
        historyEntity = new SendNotificationDetailHistoryEntity(entity);
    }

    @Override
    public void modify() {
        logger.info(this + "#modify");
        Assert.notNull(entity);

        // 判断是否需要修改
        if (!isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000006);

        // 获取Dao
        SendNotificationDetailDao dao = getDao(SendNotificationDetailDao.class);

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
        SendNotificationDetailDao dao = getDao(SendNotificationDetailDao.class);

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
        SendNotificationDetailDao dao = getDao(SendNotificationDetailDao.class);

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
            return this.getClass().getName() + this.entity.getSendNotificationDetailId();
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
    public SendNotificationDetail forComplete(Long id) {
        logger.info(this + "#forComplete");
        SendNotificationDetail build = new SendNotificationDetail(id);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于插入数据库，此对象必须使用create方法插入数据库
     *
     */
    public SendNotificationDetail forCreate(SendNotificationDetailEntity entity) {
        logger.info(this + "#forCreate");
        SendNotificationDetail build = new SendNotificationDetail(entity);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于根据entity.distributionNotificationDetailId查询数据，此对象必须使用complete方法补全
     *
     */
    public SendNotificationDetail forComplete(DistributionNotificationDetail linkedArchive) {
        logger.info(this + "#forComplete");
        SendNotificationDetail build = new SendNotificationDetail(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于根据entity.sendNotificationId查询数据，此对象必须使用complete方法补全
     *
     */
    public SendNotificationDetail forComplete(SendNotification linkedArchive) {
        logger.info(this + "#forComplete");
        SendNotificationDetail build = new SendNotificationDetail(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    }


}