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
import com.bms.order.archive.impl.list.DistributionNotificationDetailList;
import com.bms.order.archive.impl.list.ReceiveNotificationList;
import com.bms.order.archive.impl.list.SendNotificationList;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.DistributionNotificationEntity;
import com.bms.order.bean.entity.DistributionNotificationHistoryEntity;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.DistributionNotificationDao;
import com.bms.order.util.CodeRule;
import com.bms.order.util.LinkHelper;
import com.framework.exception.BusinessException;

/**
 *
 * 配送通知单表

 * @author li_huiqian

 */
public class DistributionNotification extends AbstractArchive
        implements Completable, Createable, Linkable, Modifiable, Deletable, Codeable {

    private static Logger logger = LoggerFactory.getLogger(DistributionNotification.class);

    private static final String TABLE_NAME = "ORDR_DISTRIBUTION_NOTIFICATION";
    private static final String HISTORY_TABLE_NAME = "ORDR_DISTRIBUTION_NOTIFICATION_HISTORY";

    /** 配送通知单Entity */
    private DistributionNotificationEntity entity;

    public DistributionNotificationEntity getEntity() {
        logger.info(this + "#getEntity");
        return entity;
    }

    /** 配送通知单履历表Entity */
    private DistributionNotificationHistoryEntity historyEntity;

    public DistributionNotificationHistoryEntity getHistoryEntity() {
        logger.info(this + "#getHistoryEntity");
        return historyEntity;
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
    /** 配送通知单明细表 */
    private List<DistributionNotificationDetail> distributionNotificationDetails;

    private boolean isDistributionNotificationDetailsComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void distributionNotificationDetailsLinked() {
        logger.info(this + "#distributionNotificationDetailsLinked");
        isDistributionNotificationDetailsComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void distributionNotificationDetailsUnlink() {
        logger.info(this + "#distributionNotificationDetailsUnlink");
        isDistributionNotificationDetailsComplete = false;
    }

    public List<DistributionNotificationDetail> getDistributionNotificationDetails() {
        logger.info(this + "#getDistributionNotificationDetails");
        if (!isDataSynced())
            return distributionNotificationDetails;

        if (distributionNotificationDetails == null || !isDistributionNotificationDetailsComplete) {
            DistributionNotificationDetailList list = new DistributionNotificationDetailList(this);
            list.setBlackboard(getBlackboard());
            list.complete(false);
            isDistributionNotificationDetailsComplete = true;
            distributionNotificationDetails = null;
            if(list.isDataSynced()) {
                link(list.getArchives());
                for (DistributionNotificationDetail item : distributionNotificationDetails)
                    item.distributionNotificationLinked();
            }
        }

        return distributionNotificationDetails;
    }
    /** 发货通知单 */
    private List<SendNotification> sendNotifications;

    private boolean isSendNotificationsComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void sendNotificationsLinked() {
        logger.info(this + "#sendNotificationsLinked");
        isSendNotificationsComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void sendNotificationsUnlink() {
        logger.info(this + "#sendNotificationsUnlink");
        isSendNotificationsComplete = false;
    }

    public List<SendNotification> getSendNotifications() {
        logger.info(this + "#getSendNotifications");
        if (!isDataSynced())
            return sendNotifications;

        if (sendNotifications == null || !isSendNotificationsComplete) {
            SendNotificationList list = new SendNotificationList(this);
            list.setBlackboard(getBlackboard());
            list.complete(false);
            isSendNotificationsComplete = true;
            sendNotifications = null;
            if(list.isDataSynced()) {
                link(list.getArchives());
                for (SendNotification item : sendNotifications)
                    item.distributionNotificationLinked();
            }
        }

        return sendNotifications;
    }
    /** 配送取消通知单表 */
    private DistributionCancelNotification distributionCancelNotification;

    private boolean isDistributionCancelNotificationComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void distributionCancelNotificationLinked() {
        logger.info(this + "#distributionCancelNotificationLinked");
        isDistributionCancelNotificationComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void distributionCancelNotificationUnlink() {
        logger.info(this + "#distributionCancelNotificationUnlink");
        isDistributionCancelNotificationComplete = false;
    }

    public DistributionCancelNotification getDistributionCancelNotification() {
        logger.info(this + "#getDistributionCancelNotification");
        if (!isDataSynced())
            return distributionCancelNotification;

        if (distributionCancelNotification == null || !isDistributionCancelNotificationComplete) {
            DistributionCancelNotification distributionCancelNotification = new DistributionCancelNotification(this);
            distributionCancelNotification.setBlackboard(getBlackboard());
            distributionCancelNotification.complete(false);
            isDistributionCancelNotificationComplete = true;
            this.distributionCancelNotification = null;
            if(distributionCancelNotification.isDataSynced())
                link(distributionCancelNotification);
            distributionCancelNotification.distributionNotificationLinked();
        }

        return distributionCancelNotification;
    }
    /** 收货通知单 */
    private List<ReceiveNotification> receiveNotifications;

    private boolean isReceiveNotificationsComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void receiveNotificationsLinked() {
        logger.info(this + "#receiveNotificationsLinked");
        isReceiveNotificationsComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void receiveNotificationsUnlink() {
        logger.info(this + "#receiveNotificationsUnlink");
        isReceiveNotificationsComplete = false;
    }

    public List<ReceiveNotification> getReceiveNotifications() {
        logger.info(this + "#getReceiveNotifications");
        if (!isDataSynced())
            return receiveNotifications;

        if (receiveNotifications == null || !isReceiveNotificationsComplete) {
            ReceiveNotificationList list = new ReceiveNotificationList(this);
            list.setBlackboard(getBlackboard());
            list.complete(false);
            isReceiveNotificationsComplete = true;
            receiveNotifications = null;
            if(list.isDataSynced()) {
                link(list.getArchives());
                for (ReceiveNotification item : receiveNotifications)
                    item.distributionNotificationLinked();
            }
        }

        return receiveNotifications;
    }

    /**
     * 构造函数，已过时，请使用DistributionNotification.build(blackboard).forComplete(id)
     *
     */
    
    public  DistributionNotification(Long id) {
        logger.info(this + "#DistributionNotification");
        Assert.notNull(id);
        entity = new DistributionNotificationEntity();
        entity.setDistributionNotificationId(id);
    }

    /**
     * 构造函数，已过时，请使用DistributionNotification.build(blackboard).forComplete(code)
     *
     */
    
    public  DistributionNotification(String code) {
        logger.info(this + "#DistributionNotification");
        Assert.notNull(code);
        entity = new DistributionNotificationEntity();
        entity.setDistributionNotificationCode(code);
    }

    /**
     * 构造函数，已过时，请使用DistributionNotification.build(blackboard).forCreate(entity,)
     *
     */
    
    public  DistributionNotification(DistributionNotificationEntity entity) {
        logger.info(this + "#DistributionNotification");
        Assert.notNull(entity);
        this.entity = entity;
        setDataSynced(false);
    }

    /**
     * 构造函数，已过时，请使用DistributionNotification.build(blackboard).forComplete(linkedArchive)
     *
     */
    
    public  DistributionNotification(BuyerOrder linkedArchive) {
        logger.info(this + "#DistributionNotification");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getBuyerOrderId());
        entity = new DistributionNotificationEntity();
        entity.setBuyerOrderId(linkedArchive.getEntity().getBuyerOrderId());
    }

    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof BuyerOrder) {
            LinkHelper.link(this, target, "entity.buyerOrderId");
        
        } else if (target instanceof DistributionNotificationDetail) {
            LinkHelper.link(this, target, "entity.distributionNotificationId");
        
        } else if (target instanceof SendNotification) {
            LinkHelper.link(this, target, "entity.distributionNotificationId");
        
        } else if (target instanceof DistributionCancelNotification) {
            LinkHelper.link(this, target, "entity.distributionNotificationId");
        
        } else if (target instanceof ReceiveNotification) {
            LinkHelper.link(this, target, "entity.distributionNotificationId");
        
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
        
        } else if (item0 instanceof DistributionNotificationDetail) {
            LinkHelper.link(this, targets, "entity.distributionNotificationId");
        
        } else if (item0 instanceof SendNotification) {
            LinkHelper.link(this, targets, "entity.distributionNotificationId");
        
        } else if (item0 instanceof DistributionCancelNotification) {
            LinkHelper.link(this, targets, "entity.distributionNotificationId");
        
        } else if (item0 instanceof ReceiveNotification) {
            LinkHelper.link(this, targets, "entity.distributionNotificationId");
        
        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        // 判断是否是最新
        if (isDataSynced()) {
            return;
        }

        if (entity.getDistributionNotificationId() != null) {
            DistributionNotificationEntity entity = new DistributionNotificationEntity();
            entity.setDistributionNotificationId(this.entity.getDistributionNotificationId());
            this.entity = entity;
        } else if (entity.getDistributionNotificationCode() != null) {
            DistributionNotificationEntity entity = new DistributionNotificationEntity();
            entity.setDistributionNotificationCode(this.entity.getDistributionNotificationCode());
            this.entity = entity;
        } else if (entity.getBuyerOrderId() != null) {
            DistributionNotificationEntity entity = new DistributionNotificationEntity();
            entity.setBuyerOrderId(this.entity.getBuyerOrderId());
            this.entity = entity;
        }

        // 设置允许DEL_FLG=true
        if (allowDelete)
            this.entity.setDelFlg(true);
        else
            this.entity.setDelFlg(false);

        // 查询数据库
        DistributionNotificationDao dao = getDao(DistributionNotificationDao.class);
        DistributionNotificationEntity entity = dao.findOne(this.entity);
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
        DistributionNotificationDao dao = getDao(DistributionNotificationDao.class);

        // 设置编码
        generateCode();

        // 一意制约检测
        DistributionNotification unique = new DistributionNotification(entity.getDistributionNotificationCode());
        unique.setBlackboard(getBlackboard());
        unique.complete(false);
        if (unique.isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000004);
        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME);
        // 设置ID
        this.entity.setDistributionNotificationId(id);

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
        historyEntity = new DistributionNotificationHistoryEntity(entity);
    }

    @Override
    public void modify() {
        logger.info(this + "#modify");
        Assert.notNull(entity);

        // 判断是否需要修改
        if (!isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000006);

        // 获取Dao
        DistributionNotificationDao dao = getDao(DistributionNotificationDao.class);

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
        DistributionNotificationDao dao = getDao(DistributionNotificationDao.class);

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
        DistributionNotificationDao dao = getDao(DistributionNotificationDao.class);

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
            return this.getClass().getName() + this.entity.getDistributionNotificationId();
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
    public DistributionNotification forComplete(Long id) {
        logger.info(this + "#forComplete");
        DistributionNotification build = new DistributionNotification(id);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于根据code查询数据，此对象必须使用complete方法补全
     *
     */
    public DistributionNotification forComplete(String code) {
        logger.info(this + "#forComplete");
        DistributionNotification build = new DistributionNotification(code);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于插入数据库，此对象必须使用create方法插入数据库
     *
     */
    public DistributionNotification forCreate(DistributionNotificationEntity entity) {
        logger.info(this + "#forCreate");
        DistributionNotification build = new DistributionNotification(entity);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于根据entity.buyerOrderId查询数据，此对象必须使用complete方法补全
     *
     */
    public DistributionNotification forComplete(BuyerOrder linkedArchive) {
        logger.info(this + "#forComplete");
        DistributionNotification build = new DistributionNotification(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    }

    @Override
    public void generateCode() {
        entity.setDistributionNotificationCode(CodeRule.commonRule("PSTZ"));
    }

}