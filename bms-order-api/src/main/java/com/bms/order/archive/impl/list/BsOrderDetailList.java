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
import com.bms.order.archive.impl.BsOrder;
import com.bms.order.archive.impl.BsOrderDetail;
import com.bms.order.archive.impl.BsStockpileSplitDetail;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.BsOrderDetailAttachedEntity;
import com.bms.order.bean.entity.BsOrderDetailAttachedHistoryEntity;
import com.bms.order.bean.entity.BsOrderDetailEntity;
import com.bms.order.bean.entity.BsOrderDetailHistoryEntity;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.BsOrderDetailAttachedDao;
import com.bms.order.dao.BsOrderDetailDao;
import com.bms.order.util.LinkHelper;
import com.framework.exception.BusinessException;

/**
 *
 * 买手订单明细列表辅助类

 * @author li_huiqian

 */
public class BsOrderDetailList extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(BsOrderDetailList.class);

    private static final String TABLE_NAME = "ORDR_BS_ORDER_DETAIL";

    private static final String HISTORY_TABLE_NAME = "ORDR_BS_ORDER_DETAIL_HISTORY";

    /** 买手订单明细Entity */
    private List<BsOrderDetailEntity> entities;

    /** 买手订单明细附表Entity */
    private List<BsOrderDetailAttachedEntity> attachedEntities;


    /** 买手订单明细列表辅助类 */
    private List<BsOrderDetail> archives;

    public List<BsOrderDetail> getArchives() {
        logger.info(this + "#getArchives");
        return archives;
    }

    /** 买手订单主表 */
    private List<BsOrder> bsOrders;


    private List<Long> ids;


    /**
     * 构造函数
     *
     */
    public  BsOrderDetailList(Long[] ids) {
        logger.info(this + "#BsOrderDetailList");
        Assert.notEmpty(ids);
        this.ids = new ArrayList<>();
        for (Long id : ids)
            this.ids.add(id);
    }

    /**
     * 构造函数
     *
     */
    public  BsOrderDetailList(List<BsOrderDetailEntity> entities, List<BsOrderDetailAttachedEntity> attachedEntities) {
        logger.info(this + "#BsOrderDetailList");
        Assert.notEmpty(entities);
        Assert.notEmpty(attachedEntities);
        Assert.isTrue(entities.size() == attachedEntities.size());
        this.entities = entities;
        this.attachedEntities = attachedEntities;
        setDataSynced(false);
    }

    /**
     * 构造函数
     *
     */
    public  BsOrderDetailList(BsOrderDetail[] archives) {
        logger.info(this + "#BsOrderDetailList");
        Assert.notEmpty(archives);
        for (BsOrderDetail archive : archives) {
            Assert.notNull(archive.getEntity());
            Assert.notNull(archive.getAttachedEntity());
        }

        this.archives = new ArrayList<>();
        this.entities = new ArrayList<>();
        this.attachedEntities = new ArrayList<>();
        for (BsOrderDetail archive : archives) {
            this.archives.add(archive);
            this.entities.add(archive.getEntity());
            this.attachedEntities.add(archive.getAttachedEntity());
        }

        setDataSynced(false);
    }

    /**
     * 构造函数
     *
     */
    public  BsOrderDetailList(BsOrder linkedArchive) {
        logger.info(this + "#BsOrderDetailList");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getBsOrderId());
        this.bsOrders = new ArrayList<>();
        this.bsOrders.add(linkedArchive);
    }

    /**
     * 构造函数
     *
     */
    public  BsOrderDetailList(BsOrder[] linkedArchives) {
        logger.info(this + "#BsOrderDetailList");
        Assert.notEmpty(linkedArchives);
        this.bsOrders = new ArrayList<>();
        for (BsOrder linkedArchive : linkedArchives) {
            Assert.notNull(linkedArchive.getEntity());
            Assert.notNull(linkedArchive.getEntity().getBsOrderId());
            this.bsOrders.add(linkedArchive);
        }
    }


    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof BsOrder) {
            LinkHelper.link(this.archives, target, "entity.bsOrderId");
        
        } else if (target instanceof BsStockpileSplitDetail) {
            LinkHelper.link(this.archives, target, "entity.bsOrderDetailId");
        
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

        if (item0 instanceof BsOrder) {
            LinkHelper.link(this.archives, targets, "entity.bsOrderId");
        
        } else if (item0 instanceof BsStockpileSplitDetail) {
            LinkHelper.link(this.archives, targets, "entity.bsOrderDetailId");
        
        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        Map<String, Object> map = new HashMap<>();

        if (ids != null && ids.size() != 0)
            map.put("ids", ids);
        else if (bsOrders != null && bsOrders.size() != 0)
            map.put("bsOrders", bsOrders);
        // 设置允许DEL_FLG=true
        if (allowDelete)
            map.put("delFlg", true);
        else
            map.put("delFlg", false);

        // 查询数据库
        BsOrderDetailDao dao = getDao(BsOrderDetailDao.class);
        List<BsOrderDetailEntity> entities = dao.findAll(map);
        if (entities == null || entities.isEmpty())
            return;

        // 设置查询条件
        map.clear();
        List<Long> ids = new ArrayList<>();
        for (BsOrderDetailEntity entity : entities) 
            ids.add(entity.getBsOrderDetailId());
        map.put("ids", ids);

        // 设置允许DEL_FLG=true
        if (allowDelete)
            map.put("delFlg", true);
        else
            map.put("delFlg", false);

        BsOrderDetailAttachedDao attachedDao = getDao(BsOrderDetailAttachedDao.class);
        List<BsOrderDetailAttachedEntity> attachedEntities = attachedDao.findAll(map);
        if (attachedEntities == null || attachedEntities.isEmpty())
            return;

        for (BsOrderDetailEntity entity : entities) {
            for (BsOrderDetailAttachedEntity attachedEntity : attachedEntities) {
                if (entity.getBsOrderDetailId().equals(attachedEntity.getBsOrderDetailId())) {
                    BsOrderDetail archive = BsOrderDetail.build(getBlackboard()).forCreate(entity, attachedEntity);
                    archive.setDataSynced(true);
                    archive.setHistory();

                    if (archives == null)
                        archives = new ArrayList<>();
                    archives.add(archive);
                    break;
                }
            }
        }

        setDataSynced(true);

        // 设置历史数据
        setHistory();
    }

    @Override
    public void create() {
        logger.info(this + "#create");
        Assert.notEmpty(entities);
        Assert.notEmpty(attachedEntities);

        // 获取Dao
        BsOrderDetailDao dao = getDao(BsOrderDetailDao.class);
        BsOrderDetailAttachedDao attachedDao = getDao(BsOrderDetailAttachedDao.class);

        // 一意制约检测

        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME, entities.size());
        // 设置ID
        for (int i = 0; i < entities.size(); i++) {
            BsOrderDetailEntity entity = entities.get(i);
            entity.setBsOrderDetailId(id);
            BsOrderDetailAttachedEntity attachedEntity = attachedEntities.get(i);
            attachedEntity.setBsOrderDetailId(id);
            id += 1;
        }

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BsOrderDetailEntity entity = entities.get(i);
            insertCommon(entity);
            BsOrderDetailAttachedEntity attachedEntity = attachedEntities.get(i);
            insertCommon(attachedEntity);
        }

        // 插入数据库
        int count = dao.batchSave(entities);
        if (count != entities.size())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000005);
        count = attachedDao.batchSave(attachedEntities);
        if (count != attachedEntities.size())
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
        for (BsOrderDetail archive : archives)
            archive.setHistory();
    }

    @Override
    public void modify() {
        logger.info(this + "#modify");
        Assert.notEmpty(entities);
        Assert.notEmpty(attachedEntities);

        // 获取Dao
        BsOrderDetailDao dao = getDao(BsOrderDetailDao.class);
        BsOrderDetailAttachedDao attachedDao = getDao(BsOrderDetailAttachedDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BsOrderDetailEntity entity = entities.get(i);
            updateCommon(entity);
            BsOrderDetailAttachedEntity attachedEntity = attachedEntities.get(i);
            updateCommon(attachedEntity);
        }

        // 更新数据库带排他检测
        int count = dao.batchModify(entities);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000007);
        count = attachedDao.batchModify(attachedEntities);
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
        Assert.notEmpty(attachedEntities);

        // 获取Dao
        BsOrderDetailDao dao = getDao(BsOrderDetailDao.class);
        BsOrderDetailAttachedDao attachedDao = getDao(BsOrderDetailAttachedDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BsOrderDetailEntity entity = entities.get(i);
            deleteCommon(entity);
            BsOrderDetailAttachedEntity attachedEntity = attachedEntities.get(i);
            deleteCommon(attachedEntity);
        }

        // 更新数据库带排他检测
        int count = dao.batchDelete(entities);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000009);
        count = attachedDao.batchDelete(attachedEntities);
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
        List<BsOrderDetailHistoryEntity> historyEntities = new ArrayList<>();
        List<BsOrderDetailAttachedHistoryEntity> attachedHistoryEntities = new ArrayList<>();
        for (BsOrderDetail archive : archives) {
            historyEntities.add(archive.getHistoryEntity());
            attachedHistoryEntities.add(archive.getAttachedHistoryEntity());
        }
        // 获取Dao
        BsOrderDetailDao dao = getDao(BsOrderDetailDao.class);
        BsOrderDetailAttachedDao attachedDao = getDao(BsOrderDetailAttachedDao.class);

        // 获取Id
        Long historyId = getBlackboard().maxId(HISTORY_TABLE_NAME, archives.size());
        for (BsOrderDetail archive : archives) {
            archive.getHistoryEntity().setHistoryId(historyId);
            archive.getAttachedHistoryEntity().setHistoryId(historyId);
            historyId ++;
        }

        // 插入数据库
        int count = dao.batchSaveHistory(historyEntities);
        if (count != archives.size())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000010);
        count = attachedDao.batchSaveHistory(attachedHistoryEntities);
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
            for (BsOrderDetail archive : archives)
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
    public BsOrderDetailList forComplete(Long[] ids) {
        logger.info(this + "#forComplete");
        BsOrderDetailList build = new BsOrderDetailList(ids);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象列表，用于插入数据库，此对象列表必须使用create方法插入数据库
     *
     */
    public BsOrderDetailList forCreate(BsOrderDetail[] archives) {
        logger.info(this + "#forCreate");
        BsOrderDetailList build = new BsOrderDetailList(archives);
        build.setBlackboard(blackboard);

        return build;
    }

    /**
     * 创建对象列表，用于修改/删除数据，此对象列表必须使用modify/delete方法
     *
     */
    public BsOrderDetailList forUpdate(BsOrderDetail[] archives) {
        logger.info(this + "#forUpdate");
        BsOrderDetailList build = new BsOrderDetailList(archives);
        build.setBlackboard(blackboard);
        build.setDataSynced(true);

        return build;
    }

    /**
     * 创建对象，用于根据entity.bsOrderId查询数据，此对象必须使用complete方法补全
     *
     */
    public BsOrderDetailList forComplete(BsOrder linkedArchive) {
        logger.info(this + "#forComplete");
        BsOrderDetailList build = new BsOrderDetailList(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    }


}