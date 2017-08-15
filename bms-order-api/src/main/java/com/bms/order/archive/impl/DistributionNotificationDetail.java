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
import com.bms.order.bean.entity.DistributionNotificationDetailEntity;
import com.bms.order.bean.entity.DistributionNotificationDetailHistoryEntity;
import com.bms.order.dao.DistributionNotificationDetailDao;
import com.bms.order.util.LinkHelper;
import com.framework.exception.BusinessException;
import com.bms.order.archive.impl.DistributionNotification;
import com.bms.order.bean.entity.DistributionNotificationEntity;
import com.bms.order.archive.impl.BuyerForcastDeliverDetail;
import com.bms.order.bean.entity.BuyerForcastDeliverDetailEntity;
import com.bms.order.archive.impl.SendNotificationDetail;
import com.bms.order.archive.impl.list.SendNotificationDetailList;
import com.bms.order.archive.impl.ReceiveNotificationDetail;
import com.bms.order.archive.impl.list.ReceiveNotificationDetailList;

/**
 *
 * 配送通知单明细表

 * @author li_huiqian

 */
public class DistributionNotificationDetail extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(DistributionNotificationDetail.class);

    private static final String TABLE_NAME = "ORDR_DISTRIBUTION_NOTIFICATION_DETAIL";
    private static final String HISTORY_TABLE_NAME = "ORDR_DISTRIBUTION_NOTIFICATION_DETAIL_HISTORY";

    /** 配送通知单明细Entity */
    private DistributionNotificationDetailEntity entity;

    public DistributionNotificationDetailEntity getEntity() {
        logger.info(this + "#getEntity");
        return entity;
    }

    /** 配送通知单明细履历表Entity */
    private DistributionNotificationDetailHistoryEntity historyEntity;

    public DistributionNotificationDetailHistoryEntity getHistoryEntity() {
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
            DistributionNotification distributionNotification = new DistributionNotification(entity.getDistributionNotificationId());
            distributionNotification.setBlackboard(getBlackboard());
            distributionNotification.complete(false);
            isDistributionNotificationComplete = true;
            this.distributionNotification = null;
            if(distributionNotification.isDataSynced())
                link(distributionNotification);
        }

        return distributionNotification;
    }
    /** 买家订单预配送明细表 */
    private BuyerForcastDeliverDetail buyerForcastDeliverDetail;

    private boolean isBuyerForcastDeliverDetailComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void buyerForcastDeliverDetailLinked() {
        logger.info(this + "#buyerForcastDeliverDetailLinked");
        isBuyerForcastDeliverDetailComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void buyerForcastDeliverDetailUnlink() {
        logger.info(this + "#buyerForcastDeliverDetailUnlink");
        isBuyerForcastDeliverDetailComplete = false;
    }

    public BuyerForcastDeliverDetail getBuyerForcastDeliverDetail() {
        logger.info(this + "#getBuyerForcastDeliverDetail");
        if (!isDataSynced())
            return buyerForcastDeliverDetail;

        if (buyerForcastDeliverDetail == null || !isBuyerForcastDeliverDetailComplete) {
            BuyerForcastDeliverDetail buyerForcastDeliverDetail = new BuyerForcastDeliverDetail(entity.getBuyerForcastDeliverDetailId());
            buyerForcastDeliverDetail.setBlackboard(getBlackboard());
            buyerForcastDeliverDetail.complete(false);
            isBuyerForcastDeliverDetailComplete = true;
            this.buyerForcastDeliverDetail = null;
            if(buyerForcastDeliverDetail.isDataSynced())
                link(buyerForcastDeliverDetail);
            buyerForcastDeliverDetail.distributionNotificationDetailLinked();
        }

        return buyerForcastDeliverDetail;
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
            if(list.isDataSynced()) {
                link(list.getArchives());
                for (SendNotificationDetail item : sendNotificationDetails)
                    item.distributionNotificationDetailLinked();
            }
        }

        return sendNotificationDetails;
    }
    /** 收货通知单明细 */
    private List<ReceiveNotificationDetail> receiveNotificationDetails;

    private boolean isReceiveNotificationDetailsComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void receiveNotificationDetailsLinked() {
        logger.info(this + "#receiveNotificationDetailsLinked");
        isReceiveNotificationDetailsComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void receiveNotificationDetailsUnlink() {
        logger.info(this + "#receiveNotificationDetailsUnlink");
        isReceiveNotificationDetailsComplete = false;
    }

    public List<ReceiveNotificationDetail> getReceiveNotificationDetails() {
        logger.info(this + "#getReceiveNotificationDetails");
        if (!isDataSynced())
            return receiveNotificationDetails;

        if (receiveNotificationDetails == null || !isReceiveNotificationDetailsComplete) {
            ReceiveNotificationDetailList list = new ReceiveNotificationDetailList(this);
            list.setBlackboard(getBlackboard());
            list.complete(false);
            isReceiveNotificationDetailsComplete = true;
            receiveNotificationDetails = null;
            if(list.isDataSynced()) {
                link(list.getArchives());
                for (ReceiveNotificationDetail item : receiveNotificationDetails)
                    item.distributionNotificationDetailLinked();
            }
        }

        return receiveNotificationDetails;
    }

    /**
     * 构造函数，已过时，请使用DistributionNotificationDetail..forComplete(id)
     *
     */
    @Deprecated
    public  DistributionNotificationDetail(Long id) {
        logger.info(this + "#DistributionNotificationDetail");
        Assert.notNull(id);
        entity = new DistributionNotificationDetailEntity();
        entity.setDistributionNotificationDetailId(id);
    }

    /**
     * 构造函数，已过时，请使用DistributionNotificationDetail..forCreate(entity,)
     *
     */
    @Deprecated
    public  DistributionNotificationDetail(DistributionNotificationDetailEntity entity) {
        logger.info(this + "#DistributionNotificationDetail");
        Assert.notNull(entity);
        this.entity = entity;
        setDataSynced(false);
    }

    /**
     * 构造函数，已过时，请使用DistributionNotificationDetail..forComplete(linkedArchive)
     *
     */
    @Deprecated
    public  DistributionNotificationDetail(DistributionNotification linkedArchive) {
        logger.info(this + "#DistributionNotificationDetail");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getDistributionNotificationId());
        entity = new DistributionNotificationDetailEntity();
        entity.setDistributionNotificationId(linkedArchive.getEntity().getDistributionNotificationId());
    }
    /**
     * 构造函数，已过时，请使用DistributionNotificationDetail..forComplete(linkedArchive)
     *
     */
    @Deprecated
    public  DistributionNotificationDetail(BuyerForcastDeliverDetail linkedArchive) {
        logger.info(this + "#DistributionNotificationDetail");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getBuyerForcastDeliverDetailId());
        entity = new DistributionNotificationDetailEntity();
        entity.setBuyerForcastDeliverDetailId(linkedArchive.getEntity().getBuyerForcastDeliverDetailId());
    }

    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof DistributionNotification) {
            LinkHelper.link(this, target, "entity.distributionNotificationId");
        
        } else if (target instanceof BuyerForcastDeliverDetail) {
            LinkHelper.link(this, target, "entity.buyerForcastDeliverDetailId");
        
        } else if (target instanceof SendNotificationDetail) {
            LinkHelper.link(this, target, "entity.distributionNotificationDetailId");
        
        } else if (target instanceof ReceiveNotificationDetail) {
            LinkHelper.link(this, target, "entity.distributionNotificationDetailId");
        
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
        
        } else if (item0 instanceof BuyerForcastDeliverDetail) {
            LinkHelper.link(this, targets, "entity.buyerForcastDeliverDetailId");
        
        } else if (item0 instanceof SendNotificationDetail) {
            LinkHelper.link(this, targets, "entity.distributionNotificationDetailId");
        
        } else if (item0 instanceof ReceiveNotificationDetail) {
            LinkHelper.link(this, targets, "entity.distributionNotificationDetailId");
        
        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        // 判断是否是最新
        if (isDataSynced()) {
            return;
        }

        if (entity.getDistributionNotificationDetailId() != null) {
            DistributionNotificationDetailEntity entity = new DistributionNotificationDetailEntity();
            entity.setDistributionNotificationDetailId(this.entity.getDistributionNotificationDetailId());
            this.entity = entity;
        } else if (entity.getDistributionNotificationId() != null) {
            DistributionNotificationDetailEntity entity = new DistributionNotificationDetailEntity();
            entity.setDistributionNotificationId(this.entity.getDistributionNotificationId());
            this.entity = entity;
        } else if (entity.getBuyerForcastDeliverDetailId() != null) {
            DistributionNotificationDetailEntity entity = new DistributionNotificationDetailEntity();
            entity.setBuyerForcastDeliverDetailId(this.entity.getBuyerForcastDeliverDetailId());
            this.entity = entity;
        }

        // 设置允许DEL_FLG=true
        if (allowDelete)
            this.entity.setDelFlg(true);
        else
            this.entity.setDelFlg(false);

        // 查询数据库
        DistributionNotificationDetailDao dao = getDao(DistributionNotificationDetailDao.class);
        DistributionNotificationDetailEntity entity = dao.findOne(this.entity);
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
        DistributionNotificationDetailDao dao = getDao(DistributionNotificationDetailDao.class);

        // 一意制约检测
        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME);
        // 设置ID
        this.entity.setDistributionNotificationDetailId(id);

        // 设置待插入字段
        // TODO 对entity中待插入字段进行补全

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
        historyEntity = new DistributionNotificationDetailHistoryEntity(entity);
    }

    @Override
    public void modify() {
        logger.info(this + "#modify");
        Assert.notNull(entity);

        // 判断是否需要修改
        if (!isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000006);

        // 获取Dao
        DistributionNotificationDetailDao dao = getDao(DistributionNotificationDetailDao.class);

        // 设置待修改字段
        // TODO 对entity中待插入字段进行补全

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
        DistributionNotificationDetailDao dao = getDao(DistributionNotificationDetailDao.class);

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
        DistributionNotificationDetailDao dao = getDao(DistributionNotificationDetailDao.class);

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
            return this.getClass().getName() + this.entity.getDistributionNotificationDetailId();
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
    public DistributionNotificationDetail forComplete(Long id) {
        logger.info(this + "#forComplete");
        DistributionNotificationDetail build = new DistributionNotificationDetail(id);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于插入数据库，此对象必须使用create方法插入数据库
     *
     */
    public DistributionNotificationDetail forCreate(DistributionNotificationDetailEntity entity) {
        logger.info(this + "#forCreate");
        DistributionNotificationDetail build = new DistributionNotificationDetail(entity);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于根据entity.distributionNotificationId查询数据，此对象必须使用complete方法补全
     *
     */
    public DistributionNotificationDetail forComplete(DistributionNotification linkedArchive) {
        logger.info(this + "#forComplete");
        DistributionNotificationDetail build = new DistributionNotificationDetail(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于根据entity.buyerForcastDeliverDetailId查询数据，此对象必须使用complete方法补全
     *
     */
    public DistributionNotificationDetail forComplete(BuyerForcastDeliverDetail linkedArchive) {
        logger.info(this + "#forComplete");
        DistributionNotificationDetail build = new DistributionNotificationDetail(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    }


}