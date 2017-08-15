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
import com.bms.order.archive.impl.PriceChannelNotification;
import com.bms.order.archive.impl.PriceChannelNotificationDetail;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.PriceChannelNotificationDetailEntity;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.PriceChannelNotificationDetailDao;
import com.bms.order.util.LinkHelper;
import com.framework.exception.BusinessException;

/**
 *
 * 价格通道通知单明细列表辅助类

 * @author li_huiqian

 */
public class PriceChannelNotificationDetailList extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(PriceChannelNotificationDetailList.class);

    private static final String TABLE_NAME = "ORDR_PRICE_CHANNEL_NOTIFICATION_DETAIL";

    /** 价格通道通知单明细Entity */
    private List<PriceChannelNotificationDetailEntity> entities;


    /** 价格通道通知单明细列表辅助类 */
    private List<PriceChannelNotificationDetail> archives;

    public List<PriceChannelNotificationDetail> getArchives() {
        logger.info(this + "#getArchives");
        return archives;
    }

    /** 价格通道通知单 */
    private List<PriceChannelNotification> priceChannelNotifications;


    private List<Long> ids;


    /**
     * 构造函数
     *
     */
    public  PriceChannelNotificationDetailList(Long[] ids) {
        logger.info(this + "#PriceChannelNotificationDetailList");
        Assert.notEmpty(ids);
        this.ids = new ArrayList<>();
        for (Long id : ids)
            this.ids.add(id);
    }

    /**
     * 构造函数
     *
     */
    public  PriceChannelNotificationDetailList(List<PriceChannelNotificationDetailEntity> entities) {
        logger.info(this + "#PriceChannelNotificationDetailList");
        Assert.notEmpty(entities);
        this.entities = entities;
        setDataSynced(false);
    }

    /**
     * 构造函数
     *
     */
    public  PriceChannelNotificationDetailList(PriceChannelNotificationDetail[] archives) {
        logger.info(this + "#PriceChannelNotificationDetailList");
        Assert.notEmpty(archives);
        for (PriceChannelNotificationDetail archive : archives) {
            Assert.notNull(archive.getEntity());
        }

        this.archives = new ArrayList<>();
        this.entities = new ArrayList<>();
        for (PriceChannelNotificationDetail archive : archives) {
            this.archives.add(archive);
            this.entities.add(archive.getEntity());
        }

        setDataSynced(false);
    }

    /**
     * 构造函数
     *
     */
    public  PriceChannelNotificationDetailList(PriceChannelNotification linkedArchive) {
        logger.info(this + "#PriceChannelNotificationDetailList");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getPriceChannelNotificationId());
        this.priceChannelNotifications = new ArrayList<>();
        this.priceChannelNotifications.add(linkedArchive);
    }

    /**
     * 构造函数
     *
     */
    public  PriceChannelNotificationDetailList(PriceChannelNotification[] linkedArchives) {
        logger.info(this + "#PriceChannelNotificationDetailList");
        Assert.notEmpty(linkedArchives);
        this.priceChannelNotifications = new ArrayList<>();
        for (PriceChannelNotification linkedArchive : linkedArchives) {
            Assert.notNull(linkedArchive.getEntity());
            Assert.notNull(linkedArchive.getEntity().getPriceChannelNotificationId());
            this.priceChannelNotifications.add(linkedArchive);
        }
    }


    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof PriceChannelNotification) {
            LinkHelper.link(this.archives, target, "entity.priceChannelNotificationId");
        
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
            LinkHelper.link(this.archives, targets, "entity.priceChannelNotificationId");
        
        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        Map<String, Object> map = new HashMap<>();

        if (ids != null && ids.size() != 0)
            map.put("ids", ids);
        else if (priceChannelNotifications != null && priceChannelNotifications.size() != 0)
            map.put("priceChannelNotifications", priceChannelNotifications);
        // 设置允许DEL_FLG=true
        if (allowDelete)
            map.put("delFlg", true);
        else
            map.put("delFlg", false);

        // 查询数据库
        PriceChannelNotificationDetailDao dao = getDao(PriceChannelNotificationDetailDao.class);
        List<PriceChannelNotificationDetailEntity> entities = dao.findAll(map);
        if (entities == null || entities.isEmpty())
            return;

        for (PriceChannelNotificationDetailEntity entity : entities) {
            PriceChannelNotificationDetail archive = PriceChannelNotificationDetail.build(getBlackboard()).forCreate(entity);
            archive.setDataSynced(true);

            if (archives == null)
                archives = new ArrayList<>();
            archives.add(archive);
        }

        setDataSynced(true);

    }

    @Override
    public void create() {
        logger.info(this + "#create");
        Assert.notEmpty(entities);

        // 获取Dao
        PriceChannelNotificationDetailDao dao = getDao(PriceChannelNotificationDetailDao.class);

        // 一意制约检测

        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME, entities.size());
        // 设置ID
        for (int i = 0; i < entities.size(); i++) {
            PriceChannelNotificationDetailEntity entity = entities.get(i);
            entity.setPriceChannelNotificationDetailId(id);
            id += 1;
        }

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            PriceChannelNotificationDetailEntity entity = entities.get(i);
            insertCommon(entity);
        }

        // 插入数据库
        int count = dao.batchSave(entities);
        if (count != entities.size())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000005);

        setDataSynced(true);

    }


    @Override
    public void modify() {
        logger.info(this + "#modify");
        Assert.notEmpty(entities);

        // 获取Dao
        PriceChannelNotificationDetailDao dao = getDao(PriceChannelNotificationDetailDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            PriceChannelNotificationDetailEntity entity = entities.get(i);
            updateCommon(entity);
        }

        // 更新数据库带排他检测
        int count = dao.batchModify(entities);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000007);

    }

    @Override
    public void delete() {
        logger.info(this + "#delete");
        Assert.notEmpty(entities);

        // 获取Dao
        PriceChannelNotificationDetailDao dao = getDao(PriceChannelNotificationDetailDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            PriceChannelNotificationDetailEntity entity = entities.get(i);
            deleteCommon(entity);
        }

        // 更新数据库带排他检测
        int count = dao.batchDelete(entities);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000009);

    }


    @Override
    public String toString() {
        return this.getClass().getName();
    }

    @Override
    public void setDataSynced(boolean dataSynced) {
        logger.info(this + "#setDataSynced");
        if (archives != null)
            for (PriceChannelNotificationDetail archive : archives)
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
    public PriceChannelNotificationDetailList forComplete(Long[] ids) {
        logger.info(this + "#forComplete");
        PriceChannelNotificationDetailList build = new PriceChannelNotificationDetailList(ids);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象列表，用于插入数据库，此对象列表必须使用create方法插入数据库
     *
     */
    public PriceChannelNotificationDetailList forCreate(PriceChannelNotificationDetail[] archives) {
        logger.info(this + "#forCreate");
        PriceChannelNotificationDetailList build = new PriceChannelNotificationDetailList(archives);
        build.setBlackboard(blackboard);

        return build;
    }

    /**
     * 创建对象列表，用于修改/删除数据，此对象列表必须使用modify/delete方法
     *
     */
    public PriceChannelNotificationDetailList forUpdate(PriceChannelNotificationDetail[] archives) {
        logger.info(this + "#forUpdate");
        PriceChannelNotificationDetailList build = new PriceChannelNotificationDetailList(archives);
        build.setBlackboard(blackboard);
        build.setDataSynced(true);

        return build;
    }

    /**
     * 创建对象，用于根据entity.priceChannelNotificationId查询数据，此对象必须使用complete方法补全
     *
     */
    public PriceChannelNotificationDetailList forComplete(PriceChannelNotification linkedArchive) {
        logger.info(this + "#forComplete");
        PriceChannelNotificationDetailList build = new PriceChannelNotificationDetailList(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    }


}