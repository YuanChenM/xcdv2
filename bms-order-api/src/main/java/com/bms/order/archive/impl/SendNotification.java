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
import com.bms.order.archive.impl.list.SendNotificationDetailList;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.SendNotificationEntity;
import com.bms.order.bean.entity.SendNotificationHistoryEntity;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.SendNotificationDao;
import com.bms.order.util.LinkHelper;
import com.framework.exception.BusinessException;

/**
 *
 * 发货通知单
 * 
 * @author li_huiqian
 * 
 */
public class SendNotification extends AbstractArchive
        implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(SendNotification.class);

    private static final String TABLE_NAME = "ORDR_SEND_NOTIFICATION";
    private static final String HISTORY_TABLE_NAME = "ORDR_SEND_NOTIFICATION_HISTORY";

    /** 发货通知单Entity */
    private SendNotificationEntity entity;

    public SendNotificationEntity getEntity() {
        logger.info(this + "#getEntity");
        return entity;
    }

    /** 发货通知单履历表Entity */
    private SendNotificationHistoryEntity historyEntity;

    public SendNotificationHistoryEntity getHistoryEntity() {
        logger.info(this + "#getHistoryEntity");
        return historyEntity;
    }

    /** 配送通知单表 */
    private DistributionNotification distributionNotification;

    private boolean isDistributionNotificationComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void distributionNotificationLinked() {
        logger.info(this + "#distributionNotificationLinked");
        isDistributionNotificationComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void distributionNotificationUnlink() {
        logger.info(this + "#distributionNotificationUnlink");
        isDistributionNotificationComplete = false;
    }

    public DistributionNotification getDistributionNotification() {
        logger.info(this + "#getDistributionNotification");
        if (!isDataSynced())
            return distributionNotification;

        if (distributionNotification == null || !isDistributionNotificationComplete) {
            DistributionNotification distributionNotification = new DistributionNotification(
                    entity.getDistributionNotificationId());
            distributionNotification.setBlackboard(getBlackboard());
            distributionNotification.complete(false);
            isDistributionNotificationComplete = true;
            this.distributionNotification = null;
            if (distributionNotification.isDataSynced())
                link(distributionNotification);
        }

        return distributionNotification;
    }

    /** 发货通知单明细 */
    private List<SendNotificationDetail> sendNotificationDetails;

    private boolean isSendNotificationDetailsComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void sendNotificationDetailsLinked() {
        logger.info(this + "#sendNotificationDetailsLinked");
        isSendNotificationDetailsComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void sendNotificationDetailsUnlink() {
        logger.info(this + "#sendNotificationDetailsUnlink");
        isSendNotificationDetailsComplete = false;
    }

    public List<SendNotificationDetail> getSendNotificationDetails() {
        logger.info(this + "#getSendNotificationDetails");
        if (!isDataSynced())
            return sendNotificationDetails;

        if (sendNotificationDetails == null || !isSendNotificationDetailsComplete) {
            SendNotificationDetailList list = new SendNotificationDetailList(this);
            list.setBlackboard(getBlackboard());
            list.complete(false);
            isSendNotificationDetailsComplete = true;
            sendNotificationDetails = null;
            if (list.isDataSynced()) {
                link(list.getArchives());
                for (SendNotificationDetail item : sendNotificationDetails)
                    item.sendNotificationLinked();
            }
        }

        return sendNotificationDetails;
    }

    /**
     * 构造函数，已过时，请使用SendNotification.build(blackboard).forComplete(id)
     *
     */
    
    public SendNotification(Long id) {
        logger.info(this + "#SendNotification");
        Assert.notNull(id);
        entity = new SendNotificationEntity();
        entity.setSendNotificationId(id);
    }

    /**
     * 构造函数，已过时，请使用SendNotification.build(blackboard).forComplete(code)
     *
     */
    
    public SendNotification(String code) {
        logger.info(this + "#SendNotification");
        Assert.notNull(code);
        entity = new SendNotificationEntity();
        entity.setSendNotificationCode(code);
    }

    /**
     * 构造函数，已过时，请使用SendNotification.build(blackboard).forCreate(entity,)
     *
     */
    
    public SendNotification(SendNotificationEntity entity) {
        logger.info(this + "#SendNotification");
        Assert.notNull(entity);
        this.entity = entity;
        setDataSynced(false);
    }

    /**
     * 构造函数，已过时，请使用SendNotification.build(blackboard).forComplete(linkedArchive)
     *
     */
    
    public SendNotification(DistributionNotification linkedArchive) {
        logger.info(this + "#SendNotification");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getDistributionNotificationId());
        entity = new SendNotificationEntity();
        entity.setDistributionNotificationId(linkedArchive.getEntity().getDistributionNotificationId());
    }

    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof DistributionNotification) {
            LinkHelper.link(this, target, "entity.distributionNotificationId");

        } else if (target instanceof SendNotificationDetail) {
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

        if (item0 instanceof DistributionNotification) {
            LinkHelper.link(this, targets, "entity.distributionNotificationId");

        } else if (item0 instanceof SendNotificationDetail) {
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

        if (entity.getSendNotificationId() != null) {
            SendNotificationEntity entity = new SendNotificationEntity();
            entity.setSendNotificationId(this.entity.getSendNotificationId());
            this.entity = entity;
        } else if (entity.getSendNotificationCode() != null && entity.getDistributionNotificationId() != null) {
            SendNotificationEntity entity = new SendNotificationEntity();
            entity.setSendNotificationCode(this.entity.getSendNotificationCode());
            entity.setDistributionNotificationId(this.entity.getDistributionNotificationId());
            this.entity = entity;
        }

        // 设置允许DEL_FLG=true
        if (allowDelete)
            this.entity.setDelFlg(true);
        else
            this.entity.setDelFlg(false);

        // 查询数据库
        SendNotificationDao dao = getDao(SendNotificationDao.class);
        SendNotificationEntity entity = dao.findOne(this.entity);
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
        SendNotificationDao dao = getDao(SendNotificationDao.class);

        // 一意制约检测
        SendNotification unique = new SendNotification(entity);
        unique.setBlackboard(getBlackboard());
        unique.complete(false);
        // 业务需求，发送单号和配送单号为组合主键
        if (unique.isDataSynced()
                && unique.entity.getDistributionNotificationCode().equals(entity.getDistributionNotificationCode()))
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000004); 
        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME);
        // 设置ID
        this.entity.setSendNotificationId(id);

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
        historyEntity = new SendNotificationHistoryEntity(entity);
    }

    @Override
    public void modify() {
        logger.info(this + "#modify");
        Assert.notNull(entity);

        // 判断是否需要修改
        if (!isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000006); 

        // 获取Dao
        SendNotificationDao dao = getDao(SendNotificationDao.class);

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
        SendNotificationDao dao = getDao(SendNotificationDao.class);

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
        SendNotificationDao dao = getDao(SendNotificationDao.class);

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
            return this.getClass().getName() + this.entity.getSendNotificationId();
        else
            return this.getClass().getName();
    }

    public static Builder build(Blackboard blackboard) {
        return new Builder(blackboard);
    }

    public static class Builder {

        private Blackboard blackboard;

        public Builder(Blackboard blackboard) {
            logger.info(this + "#Builder");
            this.blackboard = blackboard;
        }

        /**
         * 创建对象，用于根据id查询数据，此对象必须使用complete方法补全
         *
         */
        public SendNotification forComplete(Long id) {
            logger.info(this + "#forComplete");
            SendNotification build = new SendNotification(id);
            build.setBlackboard(blackboard);
            return build;
        }

        /**
         * 创建对象，用于根据code查询数据，此对象必须使用complete方法补全
         *
         */
        public SendNotification forComplete(String code) {
            logger.info(this + "#forComplete");
            SendNotification build = new SendNotification(code);
            build.setBlackboard(blackboard);
            return build;
        }

        /**
         * 创建对象，用于插入数据库，此对象必须使用create方法插入数据库
         *
         */
        public SendNotification forCreate(SendNotificationEntity entity) {
            logger.info(this + "#forCreate");
            SendNotification build = new SendNotification(entity);
            build.setBlackboard(blackboard);
            return build;
        }

        /**
         * 创建对象，用于根据entity.distributionNotificationId查询数据，此对象必须使用complete方法补全
         *
         */
        public SendNotification forComplete(DistributionNotification linkedArchive) {
            logger.info(this + "#forComplete");
            SendNotification build = new SendNotification(linkedArchive);
            build.setBlackboard(blackboard);
            return build;
        }

    }

}