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
import com.bms.order.bean.entity.BuyerBatchOrderAttachedEntity;
import com.bms.order.bean.entity.BuyerBatchOrderAttachedHistoryEntity;
import com.bms.order.bean.entity.BuyerBatchOrderEntity;
import com.bms.order.bean.entity.BuyerBatchOrderHistoryEntity;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.BuyerBatchOrderAttachedDao;
import com.bms.order.dao.BuyerBatchOrderDao;
import com.bms.order.util.LinkHelper;
import com.framework.exception.BusinessException;

/**
 *
 * 分批订单表/子订单表列表辅助类

 * @author li_huiqian

 */
public class BuyerBatchOrderList extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(BuyerBatchOrderList.class);

    private static final String TABLE_NAME = "ORDR_BUYER_BATCH_ORDER";

    private static final String HISTORY_TABLE_NAME = "ORDR_BUYER_BATCH_ORDER_HISTORY";

    /** 买家分批订单Entity */
    private List<BuyerBatchOrderEntity> entities;

    /** 买家分批订单附表Entity */
    private List<BuyerBatchOrderAttachedEntity> attachedEntities;


    /** 分批订单表/子订单表列表辅助类 */
    private List<BuyerBatchOrder> archives;

    public List<BuyerBatchOrder> getArchives() {
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
    public  BuyerBatchOrderList(Long[] ids) {
        logger.info(this + "#BuyerBatchOrderList");
        Assert.notEmpty(ids);
        this.ids = new ArrayList<>();
        for (Long id : ids)
            this.ids.add(id);
    }

    /**
     * 构造函数
     *
     */
    public  BuyerBatchOrderList(String[] codes) {
        logger.info(this + "#BuyerBatchOrderList");
        Assert.notEmpty(codes);
        this.codes = new ArrayList<>();
        for (String code : codes)
            this.codes.add(code);
    }

    /**
     * 构造函数
     *
     */
    public  BuyerBatchOrderList(List<BuyerBatchOrderEntity> entities, List<BuyerBatchOrderAttachedEntity> attachedEntities) {
        logger.info(this + "#BuyerBatchOrderList");
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
    public  BuyerBatchOrderList(BuyerBatchOrder[] archives) {
        logger.info(this + "#BuyerBatchOrderList");
        Assert.notEmpty(archives);
        for (BuyerBatchOrder archive : archives) {
            Assert.notNull(archive.getEntity());
            Assert.notNull(archive.getAttachedEntity());
        }

        this.archives = new ArrayList<>();
        this.entities = new ArrayList<>();
        this.attachedEntities = new ArrayList<>();
        for (BuyerBatchOrder archive : archives) {
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
    public  BuyerBatchOrderList(BuyerOrder linkedArchive) {
        logger.info(this + "#BuyerBatchOrderList");
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
    public  BuyerBatchOrderList(BuyerOrder[] linkedArchives) {
        logger.info(this + "#BuyerBatchOrderList");
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
        
        } else if (target instanceof BuyerBatchOrderDetail) {
            LinkHelper.link(this.archives, target, "entity.buyerBatchOrderId");
        
        } else if (target instanceof BuyerForcastDeliverDetail) {
            LinkHelper.link(this.archives, target, "entity.buyerBatchOrderId");
        
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
        
        } else if (item0 instanceof BuyerBatchOrderDetail) {
            LinkHelper.link(this.archives, targets, "entity.buyerBatchOrderId");
        
        } else if (item0 instanceof BuyerForcastDeliverDetail) {
            LinkHelper.link(this.archives, targets, "entity.buyerBatchOrderId");
        
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
        BuyerBatchOrderDao dao = getDao(BuyerBatchOrderDao.class);
        List<BuyerBatchOrderEntity> entities = dao.findAll(map);
        if (entities == null || entities.isEmpty())
            return;

        // 设置查询条件
        map.clear();
        List<Long> ids = new ArrayList<>();
        for (BuyerBatchOrderEntity entity : entities) 
            ids.add(entity.getBuyerBatchOrderId());
        map.put("ids", ids);

        // 设置允许DEL_FLG=true
        if (allowDelete)
            map.put("delFlg", true);
        else
            map.put("delFlg", false);

        BuyerBatchOrderAttachedDao attachedDao = getDao(BuyerBatchOrderAttachedDao.class);
        List<BuyerBatchOrderAttachedEntity> attachedEntities = attachedDao.findAll(map);
        if (attachedEntities == null || attachedEntities.isEmpty())
            return;

        for (BuyerBatchOrderEntity entity : entities) {
            for (BuyerBatchOrderAttachedEntity attachedEntity : attachedEntities) {
                if (entity.getBuyerBatchOrderId().equals(attachedEntity.getBuyerBatchOrderId())) {
                    BuyerBatchOrder archive = BuyerBatchOrder.build(getBlackboard()).forCreate(entity, attachedEntity);
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
        BuyerBatchOrderDao dao = getDao(BuyerBatchOrderDao.class);
        BuyerBatchOrderAttachedDao attachedDao = getDao(BuyerBatchOrderAttachedDao.class);

        // 生成编码
        for (BuyerBatchOrder archive : archives) {
            archive.generateCode();
        }

        // 一意制约检测
        String[] codes = new String[entities.size()];
        for (int i = 0; i < entities.size(); i++) {
            codes[i] = entities.get(i).getBuyerBatchOrderCode();
        }
        
        BuyerBatchOrderList unique = new BuyerBatchOrderList(codes);
        unique.setBlackboard(getBlackboard());
        unique.complete(false);
        if (unique.isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000004);

        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME, entities.size());
        // 设置ID
        for (int i = 0; i < entities.size(); i++) {
            BuyerBatchOrderEntity entity = entities.get(i);
            entity.setBuyerBatchOrderId(id);
            BuyerBatchOrderAttachedEntity attachedEntity = attachedEntities.get(i);
            attachedEntity.setBuyerBatchOrderId(id);
            id += 1;
        }

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BuyerBatchOrderEntity entity = entities.get(i);
            insertCommon(entity);
            BuyerBatchOrderAttachedEntity attachedEntity = attachedEntities.get(i);
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
        for (BuyerBatchOrder archive : archives)
            archive.setHistory();
    }

    @Override
    public void modify() {
        logger.info(this + "#modify");
        Assert.notEmpty(entities);
        Assert.notEmpty(attachedEntities);

        // 获取Dao
        BuyerBatchOrderDao dao = getDao(BuyerBatchOrderDao.class);
        BuyerBatchOrderAttachedDao attachedDao = getDao(BuyerBatchOrderAttachedDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BuyerBatchOrderEntity entity = entities.get(i);
            updateCommon(entity);
            BuyerBatchOrderAttachedEntity attachedEntity = attachedEntities.get(i);
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
        BuyerBatchOrderDao dao = getDao(BuyerBatchOrderDao.class);
        BuyerBatchOrderAttachedDao attachedDao = getDao(BuyerBatchOrderAttachedDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BuyerBatchOrderEntity entity = entities.get(i);
            deleteCommon(entity);
            BuyerBatchOrderAttachedEntity attachedEntity = attachedEntities.get(i);
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
        List<BuyerBatchOrderHistoryEntity> historyEntities = new ArrayList<>();
        List<BuyerBatchOrderAttachedHistoryEntity> attachedHistoryEntities = new ArrayList<>();
        for (BuyerBatchOrder archive : archives) {
            historyEntities.add(archive.getHistoryEntity());
            attachedHistoryEntities.add(archive.getAttachedHistoryEntity());
        }
        // 获取Dao
        BuyerBatchOrderDao dao = getDao(BuyerBatchOrderDao.class);
        BuyerBatchOrderAttachedDao attachedDao = getDao(BuyerBatchOrderAttachedDao.class);

        // 获取Id
        Long historyId = getBlackboard().maxId(HISTORY_TABLE_NAME, archives.size());
        for (BuyerBatchOrder archive : archives) {
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
            for (BuyerBatchOrder archive : archives)
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
    public BuyerBatchOrderList forComplete(Long[] ids) {
        logger.info(this + "#forComplete");
        BuyerBatchOrderList build = new BuyerBatchOrderList(ids);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象列表，用于根据code查询数据，此对象列表必须使用complete方法补全
     *
     */
    public BuyerBatchOrderList forComplete(String[] codes) {
        logger.info(this + "#forComplete");
        BuyerBatchOrderList build = new BuyerBatchOrderList(codes);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象列表，用于插入数据库，此对象列表必须使用create方法插入数据库
     *
     */
    public BuyerBatchOrderList forCreate(BuyerBatchOrder[] archives) {
        logger.info(this + "#forCreate");
        BuyerBatchOrderList build = new BuyerBatchOrderList(archives);
        build.setBlackboard(blackboard);

        return build;
    }

    /**
     * 创建对象列表，用于修改/删除数据，此对象列表必须使用modify/delete方法
     *
     */
    public BuyerBatchOrderList forUpdate(BuyerBatchOrder[] archives) {
        logger.info(this + "#forUpdate");
        BuyerBatchOrderList build = new BuyerBatchOrderList(archives);
        build.setBlackboard(blackboard);
        build.setDataSynced(true);

        return build;
    }

    /**
     * 创建对象，用于根据entity.buyerOrderId查询数据，此对象必须使用complete方法补全
     *
     */
    public BuyerBatchOrderList forComplete(BuyerOrder linkedArchive) {
        logger.info(this + "#forComplete");
        BuyerBatchOrderList build = new BuyerBatchOrderList(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    }


}