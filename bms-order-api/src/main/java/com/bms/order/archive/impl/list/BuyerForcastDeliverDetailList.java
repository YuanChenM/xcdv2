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
import com.bms.order.archive.impl.BuyerForcastDeliverDetail;
import com.bms.order.bean.Blackboard;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.bean.entity.BuyerForcastDeliverDetailEntity;
import com.bms.order.bean.entity.BuyerForcastDeliverDetailHistoryEntity;
import com.bms.order.bean.entity.BuyerForcastDeliverDetailAttachedEntity;
import com.bms.order.bean.entity.BuyerForcastDeliverDetailAttachedHistoryEntity;
import com.bms.order.dao.BuyerForcastDeliverDetailDao;
import com.bms.order.dao.BuyerForcastDeliverDetailAttachedDao;
import com.bms.order.util.LinkHelper;
import com.framework.exception.BusinessException;
import com.bms.order.archive.impl.BuyerBatchOrderDetail;
import com.bms.order.archive.impl.BuyerBatchOrder;
import com.bms.order.archive.impl.DistributionNotificationDetail;
import com.bms.order.archive.impl.BsStockpileSaleDetail;
import com.bms.order.archive.impl.list.BsStockpileSaleDetailList;
import com.bms.order.bean.entity.BuyerBatchOrderDetailEntity;
import com.bms.order.bean.entity.BuyerBatchOrderEntity;

/**
 *
 * 买家订单预配送明细表列表辅助类

 * @author li_huiqian

 */
public class BuyerForcastDeliverDetailList extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(BuyerForcastDeliverDetailList.class);

    private static final String TABLE_NAME = "ORDR_BUYER_FORCAST_DELIVER_DETAIL";

    private static final String HISTORY_TABLE_NAME = "ORDR_BUYER_FORCAST_DELIVER_DETAIL_HISTORY";

    /** 买家订单预配送明细表Entity */
    private List<BuyerForcastDeliverDetailEntity> entities;

    /** 买家订单预配送明细附表Entity */
    private List<BuyerForcastDeliverDetailAttachedEntity> attachedEntities;


    /** 买家订单预配送明细表列表辅助类 */
    private List<BuyerForcastDeliverDetail> archives;

    public List<BuyerForcastDeliverDetail> getArchives() {
        logger.info(this + "#getArchives");
        return archives;
    }

    /** 订单明细表，订单的原始信息，与客户提交的订单保持一致 */
    private List<BuyerBatchOrderDetail> buyerBatchOrderDetails;

    /** 分批订单表/子订单表 */
    private List<BuyerBatchOrder> buyerBatchOrders;


    private List<Long> ids;


    /**
     * 构造函数
     *
     */
    @Deprecated
    public  BuyerForcastDeliverDetailList(Long[] ids) {
        logger.info(this + "#BuyerForcastDeliverDetailList");
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
    public  BuyerForcastDeliverDetailList(List<BuyerForcastDeliverDetailEntity> entities, List<BuyerForcastDeliverDetailAttachedEntity> attachedEntities) {
        logger.info(this + "#BuyerForcastDeliverDetailList");
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
    @Deprecated
    public  BuyerForcastDeliverDetailList(BuyerForcastDeliverDetail[] archives) {
        logger.info(this + "#BuyerForcastDeliverDetailList");
        Assert.notEmpty(archives);
        for (BuyerForcastDeliverDetail archive : archives) {
            Assert.notNull(archive.getEntity());
            Assert.notNull(archive.getAttachedEntity());
        }

        this.archives = new ArrayList<>();
        this.entities = new ArrayList<>();
        this.attachedEntities = new ArrayList<>();
        for (BuyerForcastDeliverDetail archive : archives) {
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
    @Deprecated
    public  BuyerForcastDeliverDetailList(BuyerBatchOrderDetail linkedArchive) {
        logger.info(this + "#BuyerForcastDeliverDetailList");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getBuyerBatchOrderDetailId());
        this.buyerBatchOrderDetails = new ArrayList<>();
        this.buyerBatchOrderDetails.add(linkedArchive);
    }

    /**
     * 构造函数
     *
     */
    @Deprecated
    public  BuyerForcastDeliverDetailList(BuyerBatchOrderDetail[] linkedArchives) {
        logger.info(this + "#BuyerForcastDeliverDetailList");
        Assert.notEmpty(linkedArchives);
        this.buyerBatchOrderDetails = new ArrayList<>();
        for (BuyerBatchOrderDetail linkedArchive : linkedArchives) {
            Assert.notNull(linkedArchive.getEntity());
            Assert.notNull(linkedArchive.getEntity().getBuyerBatchOrderDetailId());
            this.buyerBatchOrderDetails.add(linkedArchive);
        }
    }

    /**
     * 构造函数
     *
     */
    @Deprecated
    public  BuyerForcastDeliverDetailList(BuyerBatchOrder linkedArchive) {
        logger.info(this + "#BuyerForcastDeliverDetailList");
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
    @Deprecated
    public  BuyerForcastDeliverDetailList(BuyerBatchOrder[] linkedArchives) {
        logger.info(this + "#BuyerForcastDeliverDetailList");
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

        if (target instanceof BuyerBatchOrderDetail) {
            LinkHelper.link(this.archives, target, "entity.buyerBatchOrderDetailId");
        
        } else if (target instanceof BuyerBatchOrder) {
            LinkHelper.link(this.archives, target, "entity.buyerBatchOrderId");
        
        } else if (target instanceof DistributionNotificationDetail) {
            LinkHelper.link(this.archives, target, "entity.buyerForcastDeliverDetailId");
        
        } else if (target instanceof BsStockpileSaleDetail) {
            LinkHelper.link(this.archives, target, "entity.buyerForcastDeliverDetailId");
        
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

        if (item0 instanceof BuyerBatchOrderDetail) {
            LinkHelper.link(this.archives, targets, "entity.buyerBatchOrderDetailId");
        
        } else if (item0 instanceof BuyerBatchOrder) {
            LinkHelper.link(this.archives, targets, "entity.buyerBatchOrderId");
        
        } else if (item0 instanceof DistributionNotificationDetail) {
            LinkHelper.link(this.archives, targets, "entity.buyerForcastDeliverDetailId");
        
        } else if (item0 instanceof BsStockpileSaleDetail) {
            LinkHelper.link(this.archives, targets, "entity.buyerForcastDeliverDetailId");
        
        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        Map<String, Object> map = new HashMap<>();

        if (ids != null && ids.size() != 0)
            map.put("ids", ids);
        else if (buyerBatchOrderDetails != null && buyerBatchOrderDetails.size() != 0)
            map.put("buyerBatchOrderDetails", buyerBatchOrderDetails);
        else if (buyerBatchOrders != null && buyerBatchOrders.size() != 0)
            map.put("buyerBatchOrders", buyerBatchOrders);
        // 设置允许DEL_FLG=true
        if (allowDelete)
            map.put("delFlg", true);
        else
            map.put("delFlg", false);

        // 查询数据库
        BuyerForcastDeliverDetailDao dao = getDao(BuyerForcastDeliverDetailDao.class);
        List<BuyerForcastDeliverDetailEntity> entities = dao.findAll(map);
        if (entities == null || entities.isEmpty())
            return;

        // 设置查询条件
        map.clear();
        List<Long> ids = new ArrayList<>();
        for (BuyerForcastDeliverDetailEntity entity : entities) 
            ids.add(entity.getBuyerForcastDeliverDetailId());
        map.put("ids", ids);

        // 设置允许DEL_FLG=true
        if (allowDelete)
            map.put("delFlg", true);
        else
            map.put("delFlg", false);

        BuyerForcastDeliverDetailAttachedDao attachedDao = getDao(BuyerForcastDeliverDetailAttachedDao.class);
        List<BuyerForcastDeliverDetailAttachedEntity> attachedEntities = attachedDao.findAll(map);
        if (attachedEntities == null || attachedEntities.isEmpty())
            return;

        for (BuyerForcastDeliverDetailEntity entity : entities) {
            for (BuyerForcastDeliverDetailAttachedEntity attachedEntity : attachedEntities) {
                if (entity.getBuyerForcastDeliverDetailId().equals(attachedEntity.getBuyerForcastDeliverDetailId())) {
                    BuyerForcastDeliverDetail archive = BuyerForcastDeliverDetail.build(getBlackboard()).forCreate(entity, attachedEntity);
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
        BuyerForcastDeliverDetailDao dao = getDao(BuyerForcastDeliverDetailDao.class);
        BuyerForcastDeliverDetailAttachedDao attachedDao = getDao(BuyerForcastDeliverDetailAttachedDao.class);

        // 一意制约检测

        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME, entities.size());
        // 设置ID
        for (int i = 0; i < entities.size(); i++) {
            BuyerForcastDeliverDetailEntity entity = entities.get(i);
            entity.setBuyerForcastDeliverDetailId(id);
            BuyerForcastDeliverDetailAttachedEntity attachedEntity = attachedEntities.get(i);
            attachedEntity.setBuyerForcastDeliverDetailId(id);
            id += 1;
        }

        // 设置待插入字段
        // TODO 对entity中待插入字段进行补全

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BuyerForcastDeliverDetailEntity entity = entities.get(i);
            insertCommon(entity);
            BuyerForcastDeliverDetailAttachedEntity attachedEntity = attachedEntities.get(i);
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
        for (BuyerForcastDeliverDetail archive : archives)
            archive.setHistory();
    }

    @Override
    public void modify() {
        logger.info(this + "#modify");
        Assert.notEmpty(entities);
        Assert.notEmpty(attachedEntities);

        // 获取Dao
        BuyerForcastDeliverDetailDao dao = getDao(BuyerForcastDeliverDetailDao.class);
        BuyerForcastDeliverDetailAttachedDao attachedDao = getDao(BuyerForcastDeliverDetailAttachedDao.class);

        // 设置待修改字段
        // TODO 对entity中待插入字段进行补全

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BuyerForcastDeliverDetailEntity entity = entities.get(i);
            updateCommon(entity);
            BuyerForcastDeliverDetailAttachedEntity attachedEntity = attachedEntities.get(i);
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
        BuyerForcastDeliverDetailDao dao = getDao(BuyerForcastDeliverDetailDao.class);
        BuyerForcastDeliverDetailAttachedDao attachedDao = getDao(BuyerForcastDeliverDetailAttachedDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BuyerForcastDeliverDetailEntity entity = entities.get(i);
            deleteCommon(entity);
            BuyerForcastDeliverDetailAttachedEntity attachedEntity = attachedEntities.get(i);
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
        List<BuyerForcastDeliverDetailHistoryEntity> historyEntities = new ArrayList<>();
        List<BuyerForcastDeliverDetailAttachedHistoryEntity> attachedHistoryEntities = new ArrayList<>();
        for (BuyerForcastDeliverDetail archive : archives) {
            historyEntities.add(archive.getHistoryEntity());
            attachedHistoryEntities.add(archive.getAttachedHistoryEntity());
        }
        // 获取Dao
        BuyerForcastDeliverDetailDao dao = getDao(BuyerForcastDeliverDetailDao.class);
        BuyerForcastDeliverDetailAttachedDao attachedDao = getDao(BuyerForcastDeliverDetailAttachedDao.class);

        // 获取Id
        Long historyId = getBlackboard().maxId(HISTORY_TABLE_NAME, archives.size());
        for (BuyerForcastDeliverDetail archive : archives) {
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
            for (BuyerForcastDeliverDetail archive : archives)
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
    public BuyerForcastDeliverDetailList forComplete(Long[] ids) {
        logger.info(this + "#forComplete");
        BuyerForcastDeliverDetailList build = new BuyerForcastDeliverDetailList(ids);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象列表，用于插入数据库，此对象列表必须使用create方法插入数据库
     *
     */
    public BuyerForcastDeliverDetailList forCreate(BuyerForcastDeliverDetail[] archives) {
        logger.info(this + "#forCreate");
        BuyerForcastDeliverDetailList build = new BuyerForcastDeliverDetailList(archives);
        build.setBlackboard(blackboard);

        return build;
    }

    /**
     * 创建对象列表，用于修改/删除数据，此对象列表必须使用modify/delete方法
     *
     */
    public BuyerForcastDeliverDetailList forUpdate(BuyerForcastDeliverDetail[] archives) {
        logger.info(this + "#forUpdate");
        BuyerForcastDeliverDetailList build = new BuyerForcastDeliverDetailList(archives);
        build.setBlackboard(blackboard);
        build.setDataSynced(true);

        return build;
    }

    /**
     * 创建对象，用于根据entity.buyerBatchOrderDetailId查询数据，此对象必须使用complete方法补全
     *
     */
    public BuyerForcastDeliverDetailList forComplete(BuyerBatchOrderDetail linkedArchive) {
        logger.info(this + "#forComplete");
        BuyerForcastDeliverDetailList build = new BuyerForcastDeliverDetailList(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于根据entity.buyerBatchOrderId查询数据，此对象必须使用complete方法补全
     *
     */
    public BuyerForcastDeliverDetailList forComplete(BuyerBatchOrder linkedArchive) {
        logger.info(this + "#forComplete");
        BuyerForcastDeliverDetailList build = new BuyerForcastDeliverDetailList(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    }


}