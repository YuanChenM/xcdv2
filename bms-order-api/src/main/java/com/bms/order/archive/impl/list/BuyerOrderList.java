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
import com.bms.order.archive.impl.BuyerOrder;
import com.bms.order.archive.impl.DistributionNotification;
import com.bms.order.archive.impl.PriceChannelNotification;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.BuyerOrderAttachedEntity;
import com.bms.order.bean.entity.BuyerOrderAttachedHistoryEntity;
import com.bms.order.bean.entity.BuyerOrderEntity;
import com.bms.order.bean.entity.BuyerOrderHistoryEntity;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.BuyerOrderAttachedDao;
import com.bms.order.dao.BuyerOrderDao;
import com.bms.order.util.LinkHelper;
import com.framework.exception.BusinessException;

/**
 *
 * 订单主表列表辅助类

 * @author li_huiqian

 */
public class BuyerOrderList extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(BuyerOrderList.class);

    private static final String TABLE_NAME = "ORDR_BUYER_ORDER";

    private static final String HISTORY_TABLE_NAME = "ORDR_BUYER_ORDER_HISTORY";

    /** 买家订单Entity */
    private List<BuyerOrderEntity> entities;

    /** 买家订单附表Entity */
    private List<BuyerOrderAttachedEntity> attachedEntities;


    /** 订单主表列表辅助类 */
    private List<BuyerOrder> archives;

    public List<BuyerOrder> getArchives() {
        logger.info(this + "#getArchives");
        return archives;
    }


    private List<Long> ids;

    private List<String> codes;


    /**
     * 构造函数
     *
     */
    public  BuyerOrderList(Long[] ids) {
        logger.info(this + "#BuyerOrderList");
        Assert.notEmpty(ids);
        this.ids = new ArrayList<>();
        for (Long id : ids)
            this.ids.add(id);
    }

    /**
     * 构造函数
     *
     */
    public  BuyerOrderList(String[] codes) {
        logger.info(this + "#BuyerOrderList");
        Assert.notEmpty(codes);
        this.codes = new ArrayList<>();
        for (String code : codes)
            this.codes.add(code);
    }

    /**
     * 构造函数
     *
     */
    public  BuyerOrderList(List<BuyerOrderEntity> entities, List<BuyerOrderAttachedEntity> attachedEntities) {
        logger.info(this + "#BuyerOrderList");
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
    public  BuyerOrderList(BuyerOrder[] archives) {
        logger.info(this + "#BuyerOrderList");
        Assert.notEmpty(archives);
        for (BuyerOrder archive : archives) {
            Assert.notNull(archive.getEntity());
            Assert.notNull(archive.getAttachedEntity());
        }

        this.archives = new ArrayList<>();
        this.entities = new ArrayList<>();
        this.attachedEntities = new ArrayList<>();
        for (BuyerOrder archive : archives) {
            this.archives.add(archive);
            this.entities.add(archive.getEntity());
            this.attachedEntities.add(archive.getAttachedEntity());
        }

        setDataSynced(false);
    }


    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof BuyerBatchOrderDetail) {
            LinkHelper.link(this.archives, target, "entity.buyerOrderId");
        
        } else if (target instanceof BuyerBatchOrder) {
            LinkHelper.link(this.archives, target, "entity.buyerOrderId");
        
        } else if (target instanceof DistributionNotification) {
            LinkHelper.link(this.archives, target, "entity.buyerOrderId");
        
        } else if (target instanceof PriceChannelNotification) {
            LinkHelper.link(this.archives, target, "entity.buyerOrderId");
        
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
            LinkHelper.link(this.archives, targets, "entity.buyerOrderId");
        
        } else if (item0 instanceof BuyerBatchOrder) {
            LinkHelper.link(this.archives, targets, "entity.buyerOrderId");
        
        } else if (item0 instanceof DistributionNotification) {
            LinkHelper.link(this.archives, targets, "entity.buyerOrderId");
        
        } else if (item0 instanceof PriceChannelNotification) {
            LinkHelper.link(this.archives, targets, "entity.buyerOrderId");
        
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
        // 设置允许DEL_FLG=true
        if (allowDelete)
            map.put("delFlg", true);
        else
            map.put("delFlg", false);

        // 查询数据库
        BuyerOrderDao dao = getDao(BuyerOrderDao.class);
        List<BuyerOrderEntity> entities = dao.findAll(map);
        if (entities == null || entities.isEmpty())
            return;

        // 设置查询条件
        map.clear();
        List<Long> ids = new ArrayList<>();
        for (BuyerOrderEntity entity : entities) 
            ids.add(entity.getBuyerOrderId());
        map.put("ids", ids);

        // 设置允许DEL_FLG=true
        if (allowDelete)
            map.put("delFlg", true);
        else
            map.put("delFlg", false);

        BuyerOrderAttachedDao attachedDao = getDao(BuyerOrderAttachedDao.class);
        List<BuyerOrderAttachedEntity> attachedEntities = attachedDao.findAll(map);
        if (attachedEntities == null || attachedEntities.isEmpty())
            return;

        for (BuyerOrderEntity entity : entities) {
            for (BuyerOrderAttachedEntity attachedEntity : attachedEntities) {
                if (entity.getBuyerOrderId().equals(attachedEntity.getBuyerOrderId())) {
                    BuyerOrder archive = BuyerOrder.build(getBlackboard()).forCreate(entity, attachedEntity);
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
        BuyerOrderDao dao = getDao(BuyerOrderDao.class);
        BuyerOrderAttachedDao attachedDao = getDao(BuyerOrderAttachedDao.class);

        // 生成编码
        for (BuyerOrder archive : archives)
            archive.generateCode();

        // 一意制约检测
        String[] codes = new String[entities.size()];
        for (int i = 0; i < entities.size(); i++) {
            codes[i] = entities.get(i).getBuyerOrderCode();
        }
        
        
        BuyerOrderList unique = new BuyerOrderList(codes);
        unique.setBlackboard(getBlackboard());
        unique.complete(false);
        if (unique.isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000004);

        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME, entities.size());
        // 设置ID
        for (int i = 0; i < entities.size(); i++) {
            BuyerOrderEntity entity = entities.get(i);
            entity.setBuyerOrderId(id);
            BuyerOrderAttachedEntity attachedEntity = attachedEntities.get(i);
            attachedEntity.setBuyerOrderId(id);
            id += 1;
        }

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BuyerOrderEntity entity = entities.get(i);
            insertCommon(entity);
            BuyerOrderAttachedEntity attachedEntity = attachedEntities.get(i);
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
        for (BuyerOrder archive : archives)
            archive.setHistory();
    }

    @Override
    public void modify() {
        logger.info(this + "#modify");
        Assert.notEmpty(entities);
        Assert.notEmpty(attachedEntities);

        // 获取Dao
        BuyerOrderDao dao = getDao(BuyerOrderDao.class);
        BuyerOrderAttachedDao attachedDao = getDao(BuyerOrderAttachedDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BuyerOrderEntity entity = entities.get(i);
            updateCommon(entity);
            BuyerOrderAttachedEntity attachedEntity = attachedEntities.get(i);
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
        BuyerOrderDao dao = getDao(BuyerOrderDao.class);
        BuyerOrderAttachedDao attachedDao = getDao(BuyerOrderAttachedDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BuyerOrderEntity entity = entities.get(i);
            deleteCommon(entity);
            BuyerOrderAttachedEntity attachedEntity = attachedEntities.get(i);
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
        List<BuyerOrderHistoryEntity> historyEntities = new ArrayList<>();
        List<BuyerOrderAttachedHistoryEntity> attachedHistoryEntities = new ArrayList<>();
        for (BuyerOrder archive : archives) {
            historyEntities.add(archive.getHistoryEntity());
            attachedHistoryEntities.add(archive.getAttachedHistoryEntity());
        }
        // 获取Dao
        BuyerOrderDao dao = getDao(BuyerOrderDao.class);
        BuyerOrderAttachedDao attachedDao = getDao(BuyerOrderAttachedDao.class);

        // 获取Id
        Long historyId = getBlackboard().maxId(HISTORY_TABLE_NAME, archives.size());
        for (BuyerOrder archive : archives) {
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
            for (BuyerOrder archive : archives)
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
    public BuyerOrderList forComplete(Long[] ids) {
        logger.info(this + "#forComplete");
        BuyerOrderList build = new BuyerOrderList(ids);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象列表，用于根据code查询数据，此对象列表必须使用complete方法补全
     *
     */
    public BuyerOrderList forComplete(String[] codes) {
        logger.info(this + "#forComplete");
        BuyerOrderList build = new BuyerOrderList(codes);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象列表，用于插入数据库，此对象列表必须使用create方法插入数据库
     *
     */
    public BuyerOrderList forCreate(BuyerOrder[] archives) {
        logger.info(this + "#forCreate");
        BuyerOrderList build = new BuyerOrderList(archives);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象列表，用于修改/删除数据，此对象列表必须使用modify/delete方法
     *
     */
    public BuyerOrderList forUpdate(BuyerOrder[] archives) {
        logger.info(this + "#forUpdate");
        BuyerOrderList build = new BuyerOrderList(archives);
        build.setBlackboard(blackboard);
        build.setDataSynced(true);

        return build;
    }

    }


}