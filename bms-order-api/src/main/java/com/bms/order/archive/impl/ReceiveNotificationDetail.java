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
import com.bms.order.archive.impl.list.BuyerReturnDetailList;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.ReceiveNotificationDetailEntity;
import com.bms.order.bean.entity.ReceiveNotificationDetailHistoryEntity;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.ReceiveNotificationDetailDao;
import com.bms.order.util.LinkHelper;
import com.framework.exception.BusinessException;

/**
 *
 * 收货通知单明细

 * @author li_huiqian

 */
public class ReceiveNotificationDetail extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(ReceiveNotificationDetail.class);

    private static final String TABLE_NAME = "ORDR_RECEIVE_NOTIFICATION_DETAIL";
    private static final String HISTORY_TABLE_NAME = "ORDR_RECEIVE_NOTIFICATION_DETAIL_HISTORY";

    /** 收货通知单明细Entity */
    private ReceiveNotificationDetailEntity entity;

    public ReceiveNotificationDetailEntity getEntity() {
        logger.info(this + "#getEntity");
        return entity;
    }

    /** 收货通知单明细履历表Entity */
    private ReceiveNotificationDetailHistoryEntity historyEntity;

    public ReceiveNotificationDetailHistoryEntity getHistoryEntity() {
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
    /** 收货通知单 */
    private ReceiveNotification receiveNotification;

    private boolean isReceiveNotificationComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void receiveNotificationLinked() {
        logger.info(this + "#receiveNotificationLinked");
        isReceiveNotificationComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void receiveNotificationUnlink() {
        logger.info(this + "#receiveNotificationUnlink");
        isReceiveNotificationComplete = false;
    }

    public ReceiveNotification getReceiveNotification() {
        logger.info(this + "#getReceiveNotification");
        if (!isDataSynced())
            return receiveNotification;

        if (receiveNotification == null || !isReceiveNotificationComplete) {
            ReceiveNotification receiveNotification = new ReceiveNotification(entity.getReceiveNotificationId());
            receiveNotification.setBlackboard(getBlackboard());
            receiveNotification.complete(false);
            isReceiveNotificationComplete = true;
            this.receiveNotification = null;
            if(receiveNotification.isDataSynced())
                link(receiveNotification);
        }

        return receiveNotification;
    }
    /** 买家退货订单明细信息 */
    private List<BuyerReturnDetail> buyerReturnDetails;

    private boolean isBuyerReturnDetailsComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void buyerReturnDetailsLinked() {
        logger.info(this + "#buyerReturnDetailsLinked");
        isBuyerReturnDetailsComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void buyerReturnDetailsUnlink() {
        logger.info(this + "#buyerReturnDetailsUnlink");
        isBuyerReturnDetailsComplete = false;
    }

    public List<BuyerReturnDetail> getBuyerReturnDetails() {
        logger.info(this + "#getBuyerReturnDetails");
        if (!isDataSynced())
            return buyerReturnDetails;

        if (buyerReturnDetails == null || !isBuyerReturnDetailsComplete) {
            BuyerReturnDetailList list = new BuyerReturnDetailList(this);
            list.setBlackboard(getBlackboard());
            list.complete(false);
            isBuyerReturnDetailsComplete = true;
            buyerReturnDetails = null;
            if(list.isDataSynced()) {
                link(list.getArchives());
                for (BuyerReturnDetail item : buyerReturnDetails)
                    item.receiveNotificationDetailLinked();
            }
        }

        return buyerReturnDetails;
    }

    /**
     * 构造函数，已过时，请使用ReceiveNotificationDetail.build(blackboard).forComplete(id)
     *
     */
    
    public  ReceiveNotificationDetail(Long id) {
        logger.info(this + "#ReceiveNotificationDetail");
        Assert.notNull(id);
        entity = new ReceiveNotificationDetailEntity();
        entity.setReceiveNotificationDetailId(id);
    }

    /**
     * 构造函数，已过时，请使用ReceiveNotificationDetail.build(blackboard).forCreate(entity,)
     *
     */
    
    public  ReceiveNotificationDetail(ReceiveNotificationDetailEntity entity) {
        logger.info(this + "#ReceiveNotificationDetail");
        Assert.notNull(entity);
        this.entity = entity;
        setDataSynced(false);
    }

    /**
     * 构造函数，已过时，请使用ReceiveNotificationDetail.build(blackboard).forComplete(linkedArchive)
     *
     */
    
    public  ReceiveNotificationDetail(DistributionNotificationDetail linkedArchive) {
        logger.info(this + "#ReceiveNotificationDetail");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getDistributionNotificationDetailId());
        entity = new ReceiveNotificationDetailEntity();
        entity.setDistributionNotificationDetailId(linkedArchive.getEntity().getDistributionNotificationDetailId());
    }
    /**
     * 构造函数，已过时，请使用ReceiveNotificationDetail.build(blackboard).forComplete(linkedArchive)
     *
     */
    
    public  ReceiveNotificationDetail(ReceiveNotification linkedArchive) {
        logger.info(this + "#ReceiveNotificationDetail");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getReceiveNotificationId());
        entity = new ReceiveNotificationDetailEntity();
        entity.setReceiveNotificationId(linkedArchive.getEntity().getReceiveNotificationId());
    }

    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof DistributionNotificationDetail) {
            LinkHelper.link(this, target, "entity.distributionNotificationDetailId");
        
        } else if (target instanceof ReceiveNotification) {
            LinkHelper.link(this, target, "entity.receiveNotificationId");
        
        } else if (target instanceof BuyerReturnDetail) {
            LinkHelper.link(this, target, "entity.receiveNotificationDetailId");
        
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
        
        } else if (item0 instanceof ReceiveNotification) {
            LinkHelper.link(this, targets, "entity.receiveNotificationId");
        
        } else if (item0 instanceof BuyerReturnDetail) {
            LinkHelper.link(this, targets, "entity.receiveNotificationDetailId");
        
        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        // 判断是否是最新
        if (isDataSynced()) {
            return;
        }

        if (entity.getReceiveNotificationDetailId() != null) {
            ReceiveNotificationDetailEntity entity = new ReceiveNotificationDetailEntity();
            entity.setReceiveNotificationDetailId(this.entity.getReceiveNotificationDetailId());
            this.entity = entity;
        } else if (entity.getDistributionNotificationDetailId() != null) {
            ReceiveNotificationDetailEntity entity = new ReceiveNotificationDetailEntity();
            entity.setDistributionNotificationDetailId(this.entity.getDistributionNotificationDetailId());
            this.entity = entity;
        } else if (entity.getReceiveNotificationId() != null) {
            ReceiveNotificationDetailEntity entity = new ReceiveNotificationDetailEntity();
            entity.setReceiveNotificationId(this.entity.getReceiveNotificationId());
            this.entity = entity;
        }

        // 设置允许DEL_FLG=true
        if (allowDelete)
            this.entity.setDelFlg(true);
        else
            this.entity.setDelFlg(false);

        // 查询数据库
        ReceiveNotificationDetailDao dao = getDao(ReceiveNotificationDetailDao.class);
        ReceiveNotificationDetailEntity entity = dao.findOne(this.entity);
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
        ReceiveNotificationDetailDao dao = getDao(ReceiveNotificationDetailDao.class);

        // 一意制约检测
        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME);
        // 设置ID
        this.entity.setReceiveNotificationDetailId(id);

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
        historyEntity = new ReceiveNotificationDetailHistoryEntity(entity);
    }

    @Override
    public void modify() {
        logger.info(this + "#modify");
        Assert.notNull(entity);

        // 判断是否需要修改
        if (!isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000006);

        // 获取Dao
        ReceiveNotificationDetailDao dao = getDao(ReceiveNotificationDetailDao.class);

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
        ReceiveNotificationDetailDao dao = getDao(ReceiveNotificationDetailDao.class);

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
        ReceiveNotificationDetailDao dao = getDao(ReceiveNotificationDetailDao.class);

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
            return this.getClass().getName() + this.entity.getReceiveNotificationDetailId();
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
    public ReceiveNotificationDetail forComplete(Long id) {
        logger.info(this + "#forComplete");
        ReceiveNotificationDetail build = new ReceiveNotificationDetail(id);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于插入数据库，此对象必须使用create方法插入数据库
     *
     */
    public ReceiveNotificationDetail forCreate(ReceiveNotificationDetailEntity entity) {
        logger.info(this + "#forCreate");
        ReceiveNotificationDetail build = new ReceiveNotificationDetail(entity);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于根据entity.distributionNotificationDetailId查询数据，此对象必须使用complete方法补全
     *
     */
    public ReceiveNotificationDetail forComplete(DistributionNotificationDetail linkedArchive) {
        logger.info(this + "#forComplete");
        ReceiveNotificationDetail build = new ReceiveNotificationDetail(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于根据entity.receiveNotificationId查询数据，此对象必须使用complete方法补全
     *
     */
    public ReceiveNotificationDetail forComplete(ReceiveNotification linkedArchive) {
        logger.info(this + "#forComplete");
        ReceiveNotificationDetail build = new ReceiveNotificationDetail(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    }


}