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
import com.bms.order.archive.impl.BuyerBatchOrder;
import com.bms.order.archive.impl.BuyerBatchOrderDetail;
import com.bms.order.archive.impl.BuyerForcastDeliverDetail;
import com.bms.order.archive.impl.BuyerOrder;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.BuyerBatchOrderDetailAttachedEntity;
import com.bms.order.bean.entity.BuyerBatchOrderDetailAttachedHistoryEntity;
import com.bms.order.bean.entity.BuyerBatchOrderDetailEntity;
import com.bms.order.bean.entity.BuyerBatchOrderDetailHistoryEntity;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.BuyerBatchOrderDetailAttachedDao;
import com.bms.order.dao.BuyerBatchOrderDetailDao;
import com.bms.order.util.LinkHelper;
import com.framework.exception.BusinessException;
import com.bms.order.archive.impl.BuyerOrder;
import com.bms.order.archive.impl.BuyerBatchOrder;
import com.bms.order.archive.impl.BuyerForcastDeliverDetail;
import com.bms.order.archive.impl.list.BuyerForcastDeliverDetailList;
import com.bms.order.archive.impl.BuyerSellerDetail;
import com.bms.order.archive.impl.list.BuyerSellerDetailList;
import com.bms.order.bean.entity.BuyerOrderEntity;
import com.bms.order.bean.entity.BuyerBatchOrderEntity;

/**
 *
 * 订单明细表，订单的原始信息，与客户提交的订单保持一致列表辅助类

 * @author li_huiqian

 */
public class BuyerBatchOrderDetailList extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(BuyerBatchOrderDetailList.class);

    private static final String TABLE_NAME = "ORDR_BUYER_BATCH_ORDER_DETAIL";

    private static final String HISTORY_TABLE_NAME = "ORDR_BUYER_BATCH_ORDER_DETAIL_HISTORY";

    /** 买家分批订单明细Entity */
    private List<BuyerBatchOrderDetailEntity> entities;

    /** 买家分批订单明细附表Entity */
    private List<BuyerBatchOrderDetailAttachedEntity> attachedEntities;


    /** 订单明细表，订单的原始信息，与客户提交的订单保持一致列表辅助类 */
    private List<BuyerBatchOrderDetail> archives;

    public List<BuyerBatchOrderDetail> getArchives() {
        logger.info(this + "#getArchives");
        return archives;
    }

    /** 订单主表 */
    private List<BuyerOrder> buyerOrders;

    /** 分批订单表/子订单表 */
    private List<BuyerBatchOrder> buyerBatchOrders;


    private List<Long> ids;


    /**
     * 构造函数
     *
     */
    public  BuyerBatchOrderDetailList(Long[] ids) {
        logger.info(this + "#BuyerBatchOrderDetailList");
        Assert.notEmpty(ids);
        this.ids = new ArrayList<>();
        for (Long id : ids)
            this.ids.add(id);
    }

    /**
     * 构造函数
     *
     */
    public  BuyerBatchOrderDetailList(List<BuyerBatchOrderDetailEntity> entities, List<BuyerBatchOrderDetailAttachedEntity> attachedEntities) {
        logger.info(this + "#BuyerBatchOrderDetailList");
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
    public  BuyerBatchOrderDetailList(BuyerBatchOrderDetail[] archives) {
        logger.info(this + "#BuyerBatchOrderDetailList");
        Assert.notEmpty(archives);
        for (BuyerBatchOrderDetail archive : archives) {
            Assert.notNull(archive.getEntity());
            Assert.notNull(archive.getAttachedEntity());
        }

        this.archives = new ArrayList<>();
        this.entities = new ArrayList<>();
        this.attachedEntities = new ArrayList<>();
        for (BuyerBatchOrderDetail archive : archives) {
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
    public  BuyerBatchOrderDetailList(BuyerOrder linkedArchive) {
        logger.info(this + "#BuyerBatchOrderDetailList");
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
    public  BuyerBatchOrderDetailList(BuyerOrder[] linkedArchives) {
        logger.info(this + "#BuyerBatchOrderDetailList");
        Assert.notEmpty(linkedArchives);
        this.buyerOrders = new ArrayList<>();
        for (BuyerOrder linkedArchive : linkedArchives) {
            Assert.notNull(linkedArchive.getEntity());
            Assert.notNull(linkedArchive.getEntity().getBuyerOrderId());
            this.buyerOrders.add(linkedArchive);
        }
    }

    /**
     * 构造函数
     *
     */
    public  BuyerBatchOrderDetailList(BuyerBatchOrder linkedArchive) {
        logger.info(this + "#BuyerBatchOrderDetailList");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getBuyerBatchOrderId());
        this.buyerBatchOrders = new ArrayList<>();
        this.buyerBatchOrders.add(linkedArchive);
    }

    /**
     * 构造函数
     *
     */
    public  BuyerBatchOrderDetailList(BuyerBatchOrder[] linkedArchives) {
        logger.info(this + "#BuyerBatchOrderDetailList");
        Assert.notEmpty(linkedArchives);
        this.buyerBatchOrders = new ArrayList<>();
        for (BuyerBatchOrder linkedArchive : linkedArchives) {
            Assert.notNull(linkedArchive.getEntity());
            Assert.notNull(linkedArchive.getEntity().getBuyerBatchOrderId());
            this.buyerBatchOrders.add(linkedArchive);
        }
    }


    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof BuyerOrder) {
            LinkHelper.link(this.archives, target, "entity.buyerOrderId");
        
        } else if (target instanceof BuyerBatchOrder) {
            LinkHelper.link(this.archives, target, "entity.buyerBatchOrderId");
        
        } else if (target instanceof BuyerForcastDeliverDetail) {
            LinkHelper.link(this.archives, target, "entity.buyerBatchOrderDetailId");
        
        } else if (target instanceof BuyerSellerDetail) {
            LinkHelper.link(this.archives, target, "entity.buyerBatchOrderDetailId");
        
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
        
        } else if (item0 instanceof BuyerBatchOrder) {
            LinkHelper.link(this.archives, targets, "entity.buyerBatchOrderId");
        
        } else if (item0 instanceof BuyerForcastDeliverDetail) {
            LinkHelper.link(this.archives, targets, "entity.buyerBatchOrderDetailId");
        
        } else if (item0 instanceof BuyerSellerDetail) {
            LinkHelper.link(this.archives, targets, "entity.buyerBatchOrderDetailId");
        
        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        Map<String, Object> map = new HashMap<>();

        if (ids != null && ids.size() != 0)
            map.put("ids", ids);
        else if (buyerOrders != null && buyerOrders.size() != 0)
            map.put("buyerOrders", buyerOrders);
        else if (buyerBatchOrders != null && buyerBatchOrders.size() != 0)
            map.put("buyerBatchOrders", buyerBatchOrders);
        // 设置允许DEL_FLG=true
        if (allowDelete)
            map.put("delFlg", true);
        else
            map.put("delFlg", false);

        // 查询数据库
        BuyerBatchOrderDetailDao dao = getDao(BuyerBatchOrderDetailDao.class);
        List<BuyerBatchOrderDetailEntity> entities = dao.findAll(map);
        if (entities == null || entities.isEmpty())
            return;

        // 设置查询条件
        map.clear();
        List<Long> ids = new ArrayList<>();
        for (BuyerBatchOrderDetailEntity entity : entities) 
            ids.add(entity.getBuyerBatchOrderDetailId());
        map.put("ids", ids);

        // 设置允许DEL_FLG=true
        if (allowDelete)
            map.put("delFlg", true);
        else
            map.put("delFlg", false);

        BuyerBatchOrderDetailAttachedDao attachedDao = getDao(BuyerBatchOrderDetailAttachedDao.class);
        List<BuyerBatchOrderDetailAttachedEntity> attachedEntities = attachedDao.findAll(map);
        if (attachedEntities == null || attachedEntities.isEmpty())
            return;

        for (BuyerBatchOrderDetailEntity entity : entities) {
            for (BuyerBatchOrderDetailAttachedEntity attachedEntity : attachedEntities) {
                if (entity.getBuyerBatchOrderDetailId().equals(attachedEntity.getBuyerBatchOrderDetailId())) {
                    BuyerBatchOrderDetail archive = BuyerBatchOrderDetail.build(getBlackboard()).forCreate(entity, attachedEntity);
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
        BuyerBatchOrderDetailDao dao = getDao(BuyerBatchOrderDetailDao.class);
        BuyerBatchOrderDetailAttachedDao attachedDao = getDao(BuyerBatchOrderDetailAttachedDao.class);

        // 一意制约检测

        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME, entities.size());
        // 设置ID
        for (int i = 0; i < entities.size(); i++) {
            BuyerBatchOrderDetailEntity entity = entities.get(i);
            entity.setBuyerBatchOrderDetailId(id);
            BuyerBatchOrderDetailAttachedEntity attachedEntity = attachedEntities.get(i);
            attachedEntity.setBuyerBatchOrderDetailId(id);
            id += 1;
        }

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BuyerBatchOrderDetailEntity entity = entities.get(i);
            insertCommon(entity);
            BuyerBatchOrderDetailAttachedEntity attachedEntity = attachedEntities.get(i);
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
        for (BuyerBatchOrderDetail archive : archives)
            archive.setHistory();
    }

    @Override
    public void modify() {
        logger.info(this + "#modify");
        Assert.notEmpty(entities);
        Assert.notEmpty(attachedEntities);

        // 获取Dao
        BuyerBatchOrderDetailDao dao = getDao(BuyerBatchOrderDetailDao.class);
        BuyerBatchOrderDetailAttachedDao attachedDao = getDao(BuyerBatchOrderDetailAttachedDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BuyerBatchOrderDetailEntity entity = entities.get(i);
            updateCommon(entity);
            BuyerBatchOrderDetailAttachedEntity attachedEntity = attachedEntities.get(i);
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
        BuyerBatchOrderDetailDao dao = getDao(BuyerBatchOrderDetailDao.class);
        BuyerBatchOrderDetailAttachedDao attachedDao = getDao(BuyerBatchOrderDetailAttachedDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BuyerBatchOrderDetailEntity entity = entities.get(i);
            deleteCommon(entity);
            BuyerBatchOrderDetailAttachedEntity attachedEntity = attachedEntities.get(i);
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
        List<BuyerBatchOrderDetailHistoryEntity> historyEntities = new ArrayList<>();
        List<BuyerBatchOrderDetailAttachedHistoryEntity> attachedHistoryEntities = new ArrayList<>();
        for (BuyerBatchOrderDetail archive : archives) {
            historyEntities.add(archive.getHistoryEntity());
            attachedHistoryEntities.add(archive.getAttachedHistoryEntity());
        }
        // 获取Dao
        BuyerBatchOrderDetailDao dao = getDao(BuyerBatchOrderDetailDao.class);
        BuyerBatchOrderDetailAttachedDao attachedDao = getDao(BuyerBatchOrderDetailAttachedDao.class);

        // 获取Id
        Long historyId = getBlackboard().maxId(HISTORY_TABLE_NAME, archives.size());
        for (BuyerBatchOrderDetail archive : archives) {
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
            for (BuyerBatchOrderDetail archive : archives)
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
    public BuyerBatchOrderDetailList forComplete(Long[] ids) {
        logger.info(this + "#forComplete");
        BuyerBatchOrderDetailList build = new BuyerBatchOrderDetailList(ids);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象列表，用于插入数据库，此对象列表必须使用create方法插入数据库
     *
     */
    public BuyerBatchOrderDetailList forCreate(BuyerBatchOrderDetail[] archives) {
        logger.info(this + "#forCreate");
        BuyerBatchOrderDetailList build = new BuyerBatchOrderDetailList(archives);
        build.setBlackboard(blackboard);

        return build;
    }

    /**
     * 创建对象列表，用于修改/删除数据，此对象列表必须使用modify/delete方法
     *
     */
    public BuyerBatchOrderDetailList forUpdate(BuyerBatchOrderDetail[] archives) {
        logger.info(this + "#forUpdate");
        BuyerBatchOrderDetailList build = new BuyerBatchOrderDetailList(archives);
        build.setBlackboard(blackboard);
        build.setDataSynced(true);

        return build;
    }

    /**
     * 创建对象，用于根据entity.buyerOrderId查询数据，此对象必须使用complete方法补全
     *
     */
    public BuyerBatchOrderDetailList forComplete(BuyerOrder linkedArchive) {
        logger.info(this + "#forComplete");
        BuyerBatchOrderDetailList build = new BuyerBatchOrderDetailList(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于根据entity.buyerBatchOrderId查询数据，此对象必须使用complete方法补全
     *
     */
    public BuyerBatchOrderDetailList forComplete(BuyerBatchOrder linkedArchive) {
        logger.info(this + "#forComplete");
        BuyerBatchOrderDetailList build = new BuyerBatchOrderDetailList(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    }


}