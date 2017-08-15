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
import com.bms.order.archive.impl.BuyerOrder;
import com.bms.order.archive.impl.DistributionCancelNotification;
import com.bms.order.archive.impl.DistributionNotification;
import com.bms.order.archive.impl.DistributionNotificationDetail;
import com.bms.order.archive.impl.ReceiveNotification;
import com.bms.order.archive.impl.SendNotification;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.DistributionNotificationEntity;
import com.bms.order.bean.entity.DistributionNotificationHistoryEntity;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.DistributionNotificationDao;
import com.bms.order.util.LinkHelper;
import com.framework.exception.BusinessException;

/**
 *
 * 配送通知单表列表辅助类

 * @author li_huiqian

 */
public class DistributionNotificationList extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(DistributionNotificationList.class);

    private static final String TABLE_NAME = "ORDR_DISTRIBUTION_NOTIFICATION";

    private static final String HISTORY_TABLE_NAME = "ORDR_DISTRIBUTION_NOTIFICATION_HISTORY";

    /** 配送通知单Entity */
    private List<DistributionNotificationEntity> entities;


    /** 配送通知单表列表辅助类 */
    private List<DistributionNotification> archives;

    public List<DistributionNotification> getArchives() {
        logger.info(this + "#getArchives");
        return archives;
    }

    /** 订单主表 */
    private List<BuyerOrder> buyerOrders;


    private List<Long> ids;

    private List<String> codes;


    /**
     * 构造函数
     *
     */
    public  DistributionNotificationList(Long[] ids) {
        logger.info(this + "#DistributionNotificationList");
        Assert.notEmpty(ids);
        this.ids = new ArrayList<>();
        for (Long id : ids)
            this.ids.add(id);
    }

    /**
     * 构造函数
     *
     */
    public  DistributionNotificationList(String[] codes) {
        logger.info(this + "#DistributionNotificationList");
        Assert.notEmpty(codes);
        this.codes = new ArrayList<>();
        for (String code : codes)
            this.codes.add(code);
    }

    /**
     * 构造函数
     *
     */
    public  DistributionNotificationList(List<DistributionNotificationEntity> entities) {
        logger.info(this + "#DistributionNotificationList");
        Assert.notEmpty(entities);
        this.entities = entities;
        setDataSynced(false);
    }

    /**
     * 构造函数
     *
     */
    public  DistributionNotificationList(DistributionNotification[] archives) {
        logger.info(this + "#DistributionNotificationList");
        Assert.notEmpty(archives);
        for (DistributionNotification archive : archives) {
            Assert.notNull(archive.getEntity());
        }

        this.archives = new ArrayList<>();
        this.entities = new ArrayList<>();
        for (DistributionNotification archive : archives) {
            this.archives.add(archive);
            this.entities.add(archive.getEntity());
        }

        setDataSynced(false);
    }

    /**
     * 构造函数
     *
     */
    public  DistributionNotificationList(BuyerOrder linkedArchive) {
        logger.info(this + "#DistributionNotificationList");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getBuyerOrderId());
        this.buyerOrders = new ArrayList<>();
        this.buyerOrders.add(linkedArchive);
    }

    /**
     * 构造函数
     *
     */
    public  DistributionNotificationList(BuyerOrder[] linkedArchives) {
        logger.info(this + "#DistributionNotificationList");
        Assert.notEmpty(linkedArchives);
        this.buyerOrders = new ArrayList<>();
        for (BuyerOrder linkedArchive : linkedArchives) {
            Assert.notNull(linkedArchive.getEntity());
            Assert.notNull(linkedArchive.getEntity().getBuyerOrderId());
            this.buyerOrders.add(linkedArchive);
        }
    }


    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof BuyerOrder) {
            LinkHelper.link(this.archives, target, "entity.buyerOrderId");
        
        } else if (target instanceof DistributionNotificationDetail) {
            LinkHelper.link(this.archives, target, "entity.distributionNotificationId");
        
        } else if (target instanceof SendNotification) {
            LinkHelper.link(this.archives, target, "entity.distributionNotificationId");
        
        } else if (target instanceof DistributionCancelNotification) {
            LinkHelper.link(this.archives, target, "entity.distributionNotificationId");
        
        } else if (target instanceof ReceiveNotification) {
            LinkHelper.link(this.archives, target, "entity.distributionNotificationId");
        
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
            LinkHelper.link(this.archives, targets, "entity.buyerOrderId");
        
        } else if (item0 instanceof DistributionNotificationDetail) {
            LinkHelper.link(this.archives, targets, "entity.distributionNotificationId");
        
        } else if (item0 instanceof SendNotification) {
            LinkHelper.link(this.archives, targets, "entity.distributionNotificationId");
        
        } else if (item0 instanceof DistributionCancelNotification) {
            LinkHelper.link(this.archives, targets, "entity.distributionNotificationId");
        
        } else if (item0 instanceof ReceiveNotification) {
            LinkHelper.link(this.archives, targets, "entity.distributionNotificationId");
        
        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        Map<String, Object> map = new HashMap<>();

        if (ids != null && ids.size() != 0)
            map.put("ids", ids);
        else if (codes != null && codes.size() != 0)
            map.put("codes", codes);
        else if (buyerOrders != null && buyerOrders.size() != 0)
            map.put("buyerOrders", buyerOrders);
        // 设置允许DEL_FLG=true
        if (allowDelete)
            map.put("delFlg", true);
        else
            map.put("delFlg", false);

        // 查询数据库
        DistributionNotificationDao dao = getDao(DistributionNotificationDao.class);
        List<DistributionNotificationEntity> entities = dao.findAll(map);
        if (entities == null || entities.isEmpty())
            return;

        for (DistributionNotificationEntity entity : entities) {
            DistributionNotification archive = DistributionNotification.build(getBlackboard()).forCreate(entity);
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
        DistributionNotificationDao dao = getDao(DistributionNotificationDao.class);

        // 生成编码
        for (DistributionNotification archive : archives)
            archive.generateCode();

        // 一意制约检测
        String[] codes = new String[entities.size()];
        for (int i = 0; i < entities.size(); i++) {
            codes[i] = entities.get(i).getDistributionNotificationCode();
        }
        
        
        DistributionNotificationList unique = new DistributionNotificationList(codes);
        unique.setBlackboard(getBlackboard());
        unique.complete(false);
        if (unique.isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000004);

        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME, entities.size());
        // 设置ID
        for (int i = 0; i < entities.size(); i++) {
            DistributionNotificationEntity entity = entities.get(i);
            entity.setDistributionNotificationId(id);
            id += 1;
        }

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            DistributionNotificationEntity entity = entities.get(i);
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
        for (DistributionNotification archive : archives)
            archive.setHistory();
    }

    @Override
    public void modify() {
        logger.info(this + "#modify");
        Assert.notEmpty(entities);

        // 获取Dao
        DistributionNotificationDao dao = getDao(DistributionNotificationDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            DistributionNotificationEntity entity = entities.get(i);
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
        DistributionNotificationDao dao = getDao(DistributionNotificationDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            DistributionNotificationEntity entity = entities.get(i);
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
        List<DistributionNotificationHistoryEntity> historyEntities = new ArrayList<>();
        for (DistributionNotification archive : archives) {
            historyEntities.add(archive.getHistoryEntity());
        }
        // 获取Dao
        DistributionNotificationDao dao = getDao(DistributionNotificationDao.class);

        // 获取Id
        Long historyId = getBlackboard().maxId(HISTORY_TABLE_NAME, archives.size());
        for (DistributionNotification archive : archives) {
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
            for (DistributionNotification archive : archives)
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
    public DistributionNotificationList forComplete(Long[] ids) {
        logger.info(this + "#forComplete");
        DistributionNotificationList build = new DistributionNotificationList(ids);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象列表，用于根据code查询数据，此对象列表必须使用complete方法补全
     *
     */
    public DistributionNotificationList forComplete(String[] codes) {
        logger.info(this + "#forComplete");
        DistributionNotificationList build = new DistributionNotificationList(codes);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象列表，用于插入数据库，此对象列表必须使用create方法插入数据库
     *
     */
    public DistributionNotificationList forCreate(DistributionNotification[] archives) {
        logger.info(this + "#forCreate");
        DistributionNotificationList build = new DistributionNotificationList(archives);
        build.setBlackboard(blackboard);

        return build;
    }

    /**
     * 创建对象列表，用于修改/删除数据，此对象列表必须使用modify/delete方法
     *
     */
    public DistributionNotificationList forUpdate(DistributionNotification[] archives) {
        logger.info(this + "#forUpdate");
        DistributionNotificationList build = new DistributionNotificationList(archives);
        build.setBlackboard(blackboard);
        build.setDataSynced(true);

        return build;
    }

    /**
     * 创建对象，用于根据entity.buyerOrderId查询数据，此对象必须使用complete方法补全
     *
     */
    public DistributionNotificationList forComplete(BuyerOrder linkedArchive) {
        logger.info(this + "#forComplete");
        DistributionNotificationList build = new DistributionNotificationList(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    }


}