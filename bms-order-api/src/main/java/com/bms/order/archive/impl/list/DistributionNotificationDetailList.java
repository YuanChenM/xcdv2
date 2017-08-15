package com.bms.order.archive.impl.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import com.bms.order.archive.AbstractArchive;
import com.bms.order.archive.Completable;
import com.bms.order.archive.Createable;
import com.bms.order.archive.Deletable;
import com.bms.order.archive.Linkable;
import com.bms.order.archive.Modifiable;
import com.bms.order.archive.impl.DistributionNotificationDetail;
import com.bms.order.bean.Blackboard;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.bean.entity.DistributionNotificationDetailEntity;
import com.bms.order.bean.entity.DistributionNotificationDetailHistoryEntity;
import com.bms.order.dao.DistributionNotificationDetailDao;
import com.bms.order.util.LinkHelper;
import com.framework.exception.BusinessException;
import com.bms.order.archive.impl.DistributionNotification;
import com.bms.order.archive.impl.BuyerForcastDeliverDetail;
import com.bms.order.archive.impl.SendNotificationDetail;
import com.bms.order.archive.impl.list.SendNotificationDetailList;
import com.bms.order.archive.impl.ReceiveNotificationDetail;
import com.bms.order.archive.impl.list.ReceiveNotificationDetailList;
import com.bms.order.bean.entity.DistributionNotificationEntity;
import com.bms.order.bean.entity.BuyerForcastDeliverDetailEntity;

/**
 *
 * 配送通知单明细表列表辅助类

 * @author li_huiqian

 */
public class DistributionNotificationDetailList extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(DistributionNotificationDetailList.class);

    private static final String TABLE_NAME = "ORDR_DISTRIBUTION_NOTIFICATION_DETAIL";

    private static final String HISTORY_TABLE_NAME = "ORDR_DISTRIBUTION_NOTIFICATION_DETAIL_HISTORY";

    /** 配送通知单明细Entity */
    private List<DistributionNotificationDetailEntity> entities;


    /** 配送通知单明细表列表辅助类 */
    private List<DistributionNotificationDetail> archives;

    public List<DistributionNotificationDetail> getArchives() {
        logger.info(this + "#getArchives");
        return archives;
    }

    /** 配送通知单表 */
    private List<DistributionNotification> distributionNotifications;


    private List<Long> ids;


    /**
     * 构造函数
     *
     */
    @Deprecated
    public  DistributionNotificationDetailList(Long[] ids) {
        logger.info(this + "#DistributionNotificationDetailList");
        Assert.notEmpty(ids);
        this.ids = new ArrayList<>();
        for (Long id : ids)
            this.ids.add(id);
    }

    /**
     * 构造函数
     *
     */
    @Deprecated
    public  DistributionNotificationDetailList(List<DistributionNotificationDetailEntity> entities) {
        logger.info(this + "#DistributionNotificationDetailList");
        Assert.notEmpty(entities);
        this.entities = entities;
        setDataSynced(false);
    }

    /**
     * 构造函数
     *
     */
    @Deprecated
    public  DistributionNotificationDetailList(DistributionNotificationDetail[] archives) {
        logger.info(this + "#DistributionNotificationDetailList");
        Assert.notEmpty(archives);
        for (DistributionNotificationDetail archive : archives) {
            Assert.notNull(archive.getEntity());
        }

        this.archives = new ArrayList<>();
        this.entities = new ArrayList<>();
        for (DistributionNotificationDetail archive : archives) {
            this.archives.add(archive);
            this.entities.add(archive.getEntity());
        }

        setDataSynced(false);
    }

    /**
     * 构造函数
     *
     */
    @Deprecated
    public  DistributionNotificationDetailList(DistributionNotification linkedArchive) {
        logger.info(this + "#DistributionNotificationDetailList");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getDistributionNotificationId());
        this.distributionNotifications = new ArrayList<>();
        this.distributionNotifications.add(linkedArchive);
    }

    /**
     * 构造函数
     *
     */
    @Deprecated
    public  DistributionNotificationDetailList(DistributionNotification[] linkedArchives) {
        logger.info(this + "#DistributionNotificationDetailList");
        Assert.notEmpty(linkedArchives);
        this.distributionNotifications = new ArrayList<>();
        for (DistributionNotification linkedArchive : linkedArchives) {
            Assert.notNull(linkedArchive.getEntity());
            Assert.notNull(linkedArchive.getEntity().getDistributionNotificationId());
            this.distributionNotifications.add(linkedArchive);
        }
    }


    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof DistributionNotification) {
            LinkHelper.link(this.archives, target, "entity.distributionNotificationId");
        
        } else if (target instanceof BuyerForcastDeliverDetail) {
            LinkHelper.link(this.archives, target, "entity.buyerForcastDeliverDetailId");
        
        } else if (target instanceof SendNotificationDetail) {
            LinkHelper.link(this.archives, target, "entity.distributionNotificationDetailId");
        
        } else if (target instanceof ReceiveNotificationDetail) {
            LinkHelper.link(this.archives, target, "entity.distributionNotificationDetailId");
        
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
            LinkHelper.link(this.archives, targets, "entity.distributionNotificationId");
        
        } else if (item0 instanceof BuyerForcastDeliverDetail) {
            LinkHelper.link(this.archives, targets, "entity.buyerForcastDeliverDetailId");
        
        } else if (item0 instanceof SendNotificationDetail) {
            LinkHelper.link(this.archives, targets, "entity.distributionNotificationDetailId");
        
        } else if (item0 instanceof ReceiveNotificationDetail) {
            LinkHelper.link(this.archives, targets, "entity.distributionNotificationDetailId");
        
        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        Map<String, Object> map = new HashMap<>();

        if (ids != null && ids.size() != 0)
            map.put("ids", ids);
        else if (distributionNotifications != null && distributionNotifications.size() != 0)
            map.put("distributionNotifications", distributionNotifications);
        // 设置允许DEL_FLG=true
        if (allowDelete)
            map.put("delFlg", true);
        else
            map.put("delFlg", false);

        // 查询数据库
        DistributionNotificationDetailDao dao = getDao(DistributionNotificationDetailDao.class);
        List<DistributionNotificationDetailEntity> entities = dao.findAll(map);
        if (entities == null || entities.isEmpty())
            return;

        for (DistributionNotificationDetailEntity entity : entities) {
            DistributionNotificationDetail archive = DistributionNotificationDetail.build(getBlackboard()).forCreate(entity);
            archive.setDataSynced(true);
            archive.setHistory();

            if (archives == null)
                archives = new ArrayList<>();
            archives.add(archive);
        }

        setDataSynced(true);

        // 设置历史数据
        setHistory();
    }

    @Override
    public void create() {
        logger.info(this + "#create");
        Assert.notEmpty(entities);

        // 获取Dao
        DistributionNotificationDetailDao dao = getDao(DistributionNotificationDetailDao.class);

        // 一意制约检测

        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME, entities.size());
        // 设置ID
        for (int i = 0; i < entities.size(); i++) {
            DistributionNotificationDetailEntity entity = entities.get(i);
            entity.setDistributionNotificationDetailId(id);
            id += 1;
        }

        // 设置待插入字段
        // TODO 对entity中待插入字段进行补全

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            DistributionNotificationDetailEntity entity = entities.get(i);
            insertCommon(entity);
        }

        // 插入数据库
        int count = dao.batchSave(entities);
        if (count != entities.size())
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
        Assert.notEmpty(archives, "must create or complete first");
        for (DistributionNotificationDetail archive : archives)
            archive.setHistory();
    }

    @Override
    public void modify() {
        logger.info(this + "#modify");
        Assert.notEmpty(entities);

        // 获取Dao
        DistributionNotificationDetailDao dao = getDao(DistributionNotificationDetailDao.class);

        // 设置待修改字段
        // TODO 对entity中待插入字段进行补全

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            DistributionNotificationDetailEntity entity = entities.get(i);
            updateCommon(entity);
        }

        // 更新数据库带排他检测
        int count = dao.batchModify(entities);
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
        Assert.notEmpty(entities);

        // 获取Dao
        DistributionNotificationDetailDao dao = getDao(DistributionNotificationDetailDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            DistributionNotificationDetailEntity entity = entities.get(i);
            deleteCommon(entity);
        }

        // 更新数据库带排他检测
        int count = dao.batchDelete(entities);
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
        Assert.notEmpty(archives, "must modify or delete first");
        // 获取历史Entity
        List<DistributionNotificationDetailHistoryEntity> historyEntities = new ArrayList<>();
        for (DistributionNotificationDetail archive : archives) {
            historyEntities.add(archive.getHistoryEntity());
        }
        // 获取Dao
        DistributionNotificationDetailDao dao = getDao(DistributionNotificationDetailDao.class);

        // 获取Id
        Long historyId = getBlackboard().maxId(HISTORY_TABLE_NAME, archives.size());
        for (DistributionNotificationDetail archive : archives) {
            archive.getHistoryEntity().setHistoryId(historyId);
            historyId ++;
        }

        // 插入数据库
        int count = dao.batchSaveHistory(historyEntities);
        if (count != archives.size())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000010);
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }

    @Override
    public void setDataSynced(boolean dataSynced) {
        logger.info(this + "#setDataSynced");
        if (archives != null)
            for (DistributionNotificationDetail archive : archives)
                archive.setDataSynced(dataSynced);
        super.setDataSynced(dataSynced);
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
     * 创建对象列表，用于根据id查询数据，此对象列表必须使用complete方法补全
     *
     */
    public DistributionNotificationDetailList forComplete(Long[] ids) {
        logger.info(this + "#forComplete");
        DistributionNotificationDetailList build = new DistributionNotificationDetailList(ids);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象列表，用于插入数据库，此对象列表必须使用create方法插入数据库
     *
     */
    public DistributionNotificationDetailList forCreate(DistributionNotificationDetail[] archives) {
        logger.info(this + "#forCreate");
        DistributionNotificationDetailList build = new DistributionNotificationDetailList(archives);
        build.setBlackboard(blackboard);

        return build;
    }

    /**
     * 创建对象列表，用于修改/删除数据，此对象列表必须使用modify/delete方法
     *
     */
    public DistributionNotificationDetailList forUpdate(DistributionNotificationDetail[] archives) {
        logger.info(this + "#forUpdate");
        DistributionNotificationDetailList build = new DistributionNotificationDetailList(archives);
        build.setBlackboard(blackboard);
        build.setDataSynced(true);

        return build;
    }

    /**
     * 创建对象，用于根据entity.distributionNotificationId查询数据，此对象必须使用complete方法补全
     *
     */
    public DistributionNotificationDetailList forComplete(DistributionNotification linkedArchive) {
        logger.info(this + "#forComplete");
        DistributionNotificationDetailList build = new DistributionNotificationDetailList(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    }


}