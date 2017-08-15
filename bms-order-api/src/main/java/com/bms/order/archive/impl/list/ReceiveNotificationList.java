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
import com.bms.order.archive.impl.DistributionNotification;
import com.bms.order.archive.impl.ReceiveNotification;
import com.bms.order.archive.impl.ReceiveNotificationDetail;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.ReceiveNotificationEntity;
import com.bms.order.bean.entity.ReceiveNotificationHistoryEntity;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.ReceiveNotificationDao;
import com.bms.order.util.LinkHelper;
import com.framework.exception.BusinessException;

/**
 *
 * 收货通知单列表辅助类

 * @author li_huiqian

 */
public class ReceiveNotificationList extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(ReceiveNotificationList.class);

    private static final String TABLE_NAME = "ORDR_RECEIVE_NOTIFICATION";

    private static final String HISTORY_TABLE_NAME = "ORDR_RECEIVE_NOTIFICATION_HISTORY";

    /** 收货通知单Entity */
    private List<ReceiveNotificationEntity> entities;


    /** 收货通知单列表辅助类 */
    private List<ReceiveNotification> archives;

    public List<ReceiveNotification> getArchives() {
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
    public  ReceiveNotificationList(Long[] ids) {
        logger.info(this + "#ReceiveNotificationList");
        Assert.notEmpty(ids);
        this.ids = new ArrayList<>();
        for (Long id : ids)
            this.ids.add(id);
    }

    /**
     * 构造函数
     *
     */
    public  ReceiveNotificationList(List<ReceiveNotificationEntity> entities) {
        logger.info(this + "#ReceiveNotificationList");
        Assert.notEmpty(entities);
        this.entities = entities;
        setDataSynced(false);
    }

    /**
     * 构造函数
     *
     */
    public  ReceiveNotificationList(ReceiveNotification[] archives) {
        logger.info(this + "#ReceiveNotificationList");
        Assert.notEmpty(archives);
        for (ReceiveNotification archive : archives) {
            Assert.notNull(archive.getEntity());
        }

        this.archives = new ArrayList<>();
        this.entities = new ArrayList<>();
        for (ReceiveNotification archive : archives) {
            this.archives.add(archive);
            this.entities.add(archive.getEntity());
        }

        setDataSynced(false);
    }

    /**
     * 构造函数
     *
     */
    public  ReceiveNotificationList(DistributionNotification linkedArchive) {
        logger.info(this + "#ReceiveNotificationList");
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
    public  ReceiveNotificationList(DistributionNotification[] linkedArchives) {
        logger.info(this + "#ReceiveNotificationList");
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
        
        } else if (target instanceof ReceiveNotificationDetail) {
            LinkHelper.link(this.archives, target, "entity.receiveNotificationId");
        
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
        
        } else if (item0 instanceof ReceiveNotificationDetail) {
            LinkHelper.link(this.archives, targets, "entity.receiveNotificationId");
        
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
        ReceiveNotificationDao dao = getDao(ReceiveNotificationDao.class);
        List<ReceiveNotificationEntity> entities = dao.findAll(map);
        if (entities == null || entities.isEmpty())
            return;

        for (ReceiveNotificationEntity entity : entities) {
            ReceiveNotification archive = ReceiveNotification.build(getBlackboard()).forCreate(entity);
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
        ReceiveNotificationDao dao = getDao(ReceiveNotificationDao.class);

        // 一意制约检测

        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME, entities.size());
        // 设置ID
        for (int i = 0; i < entities.size(); i++) {
            ReceiveNotificationEntity entity = entities.get(i);
            entity.setReceiveNotificationId(id);
            id += 1;
        }

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            ReceiveNotificationEntity entity = entities.get(i);
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
        for (ReceiveNotification archive : archives)
            archive.setHistory();
    }

    @Override
    public void modify() {
        logger.info(this + "#modify");
        Assert.notEmpty(entities);

        // 获取Dao
        ReceiveNotificationDao dao = getDao(ReceiveNotificationDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            ReceiveNotificationEntity entity = entities.get(i);
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
        ReceiveNotificationDao dao = getDao(ReceiveNotificationDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            ReceiveNotificationEntity entity = entities.get(i);
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
        List<ReceiveNotificationHistoryEntity> historyEntities = new ArrayList<>();
        for (ReceiveNotification archive : archives) {
            historyEntities.add(archive.getHistoryEntity());
        }
        // 获取Dao
        ReceiveNotificationDao dao = getDao(ReceiveNotificationDao.class);

        // 获取Id
        Long historyId = getBlackboard().maxId(HISTORY_TABLE_NAME, archives.size());
        for (ReceiveNotification archive : archives) {
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
            for (ReceiveNotification archive : archives)
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
    public ReceiveNotificationList forComplete(Long[] ids) {
        logger.info(this + "#forComplete");
        ReceiveNotificationList build = new ReceiveNotificationList(ids);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象列表，用于插入数据库，此对象列表必须使用create方法插入数据库
     *
     */
    public ReceiveNotificationList forCreate(ReceiveNotification[] archives) {
        logger.info(this + "#forCreate");
        ReceiveNotificationList build = new ReceiveNotificationList(archives);
        build.setBlackboard(blackboard);

        return build;
    }

    /**
     * 创建对象列表，用于修改/删除数据，此对象列表必须使用modify/delete方法
     *
     */
    public ReceiveNotificationList forUpdate(ReceiveNotification[] archives) {
        logger.info(this + "#forUpdate");
        ReceiveNotificationList build = new ReceiveNotificationList(archives);
        build.setBlackboard(blackboard);
        build.setDataSynced(true);

        return build;
    }

    /**
     * 创建对象，用于根据entity.distributionNotificationId查询数据，此对象必须使用complete方法补全
     *
     */
    public ReceiveNotificationList forComplete(DistributionNotification linkedArchive) {
        logger.info(this + "#forComplete");
        ReceiveNotificationList build = new ReceiveNotificationList(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    }


}