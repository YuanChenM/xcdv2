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
import com.bms.order.archive.impl.BsOrderDetail;
import com.bms.order.archive.impl.BsStockpileSaleDetail;
import com.bms.order.archive.impl.BsStockpileSplitDetail;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.BsStockpileSplitDetailAttachedEntity;
import com.bms.order.bean.entity.BsStockpileSplitDetailAttachedHistoryEntity;
import com.bms.order.bean.entity.BsStockpileSplitDetailEntity;
import com.bms.order.bean.entity.BsStockpileSplitDetailHistoryEntity;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.BsStockpileSplitDetailAttachedDao;
import com.bms.order.dao.BsStockpileSplitDetailDao;
import com.bms.order.util.LinkHelper;
import com.framework.exception.BusinessException;

/**
 *
 * 买手囤货分拆单明细列表辅助类

 * @author li_huiqian

 */
public class BsStockpileSplitDetailList extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(BsStockpileSplitDetailList.class);

    private static final String TABLE_NAME = "ORDR_BS_STOCKPILE_SPLIT_DETAIL";

    private static final String HISTORY_TABLE_NAME = "ORDR_BS_STOCKPILE_SPLIT_DETAIL_HISTORY";

    /** 买手囤货分拆单明细Entity */
    private List<BsStockpileSplitDetailEntity> entities;

    /** 买手囤货分拆单明细附表Entity */
    private List<BsStockpileSplitDetailAttachedEntity> attachedEntities;


    /** 买手囤货分拆单明细列表辅助类 */
    private List<BsStockpileSplitDetail> archives;

    public List<BsStockpileSplitDetail> getArchives() {
        logger.info(this + "#getArchives");
        return archives;
    }

    /** 买手订单明细 */
    private List<BsOrderDetail> bsOrderDetails;


    private List<Long> ids;


    /**
     * 构造函数
     *
     */
    public  BsStockpileSplitDetailList(Long[] ids) {
        logger.info(this + "#BsStockpileSplitDetailList");
        Assert.notEmpty(ids);
        this.ids = new ArrayList<>();
        for (Long id : ids)
            this.ids.add(id);
    }

    /**
     * 构造函数
     *
     */
    public  BsStockpileSplitDetailList(List<BsStockpileSplitDetailEntity> entities, List<BsStockpileSplitDetailAttachedEntity> attachedEntities) {
        logger.info(this + "#BsStockpileSplitDetailList");
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
    public  BsStockpileSplitDetailList(BsStockpileSplitDetail[] archives) {
        logger.info(this + "#BsStockpileSplitDetailList");
        Assert.notEmpty(archives);
        for (BsStockpileSplitDetail archive : archives) {
            Assert.notNull(archive.getEntity());
            Assert.notNull(archive.getAttachedEntity());
        }

        this.archives = new ArrayList<>();
        this.entities = new ArrayList<>();
        this.attachedEntities = new ArrayList<>();
        for (BsStockpileSplitDetail archive : archives) {
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
    public  BsStockpileSplitDetailList(BsOrderDetail linkedArchive) {
        logger.info(this + "#BsStockpileSplitDetailList");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getBsOrderDetailId());
        this.bsOrderDetails = new ArrayList<>();
        this.bsOrderDetails.add(linkedArchive);
    }

    /**
     * 构造函数
     *
     */
    public  BsStockpileSplitDetailList(BsOrderDetail[] linkedArchives) {
        logger.info(this + "#BsStockpileSplitDetailList");
        Assert.notEmpty(linkedArchives);
        this.bsOrderDetails = new ArrayList<>();
        for (BsOrderDetail linkedArchive : linkedArchives) {
            Assert.notNull(linkedArchive.getEntity());
            Assert.notNull(linkedArchive.getEntity().getBsOrderDetailId());
            this.bsOrderDetails.add(linkedArchive);
        }
    }


    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof BsOrderDetail) {
            LinkHelper.link(this.archives, target, "entity.bsOrderDetailId");
        
        } else if (target instanceof BsStockpileSaleDetail) {
            LinkHelper.link(this.archives, target, "entity.bsStockpileSplitDetailId");
        
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

        if (item0 instanceof BsOrderDetail) {
            LinkHelper.link(this.archives, targets, "entity.bsOrderDetailId");
        
        } else if (item0 instanceof BsStockpileSaleDetail) {
            LinkHelper.link(this.archives, targets, "entity.bsStockpileSplitDetailId");
        
        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        Map<String, Object> map = new HashMap<>();

        if (ids != null && ids.size() != 0)
            map.put("ids", ids);
        else if (bsOrderDetails != null && bsOrderDetails.size() != 0)
            map.put("bsOrderDetails", bsOrderDetails);
        // 设置允许DEL_FLG=true
        if (allowDelete)
            map.put("delFlg", true);
        else
            map.put("delFlg", false);

        // 查询数据库
        BsStockpileSplitDetailDao dao = getDao(BsStockpileSplitDetailDao.class);
        List<BsStockpileSplitDetailEntity> entities = dao.findAll(map);
        if (entities == null || entities.isEmpty())
            return;

        // 设置查询条件
        map.clear();
        List<Long> ids = new ArrayList<>();
        for (BsStockpileSplitDetailEntity entity : entities) 
            ids.add(entity.getBsStockpileSplitDetailId());
        map.put("ids", ids);

        // 设置允许DEL_FLG=true
        if (allowDelete)
            map.put("delFlg", true);
        else
            map.put("delFlg", false);

        BsStockpileSplitDetailAttachedDao attachedDao = getDao(BsStockpileSplitDetailAttachedDao.class);
        List<BsStockpileSplitDetailAttachedEntity> attachedEntities = attachedDao.findAll(map);
        if (attachedEntities == null || attachedEntities.isEmpty())
            return;

        for (BsStockpileSplitDetailEntity entity : entities) {
            for (BsStockpileSplitDetailAttachedEntity attachedEntity : attachedEntities) {
                if (entity.getBsStockpileSplitDetailId().equals(attachedEntity.getBsStockpileSplitDetailId())) {
                    BsStockpileSplitDetail archive = BsStockpileSplitDetail.build(getBlackboard()).forCreate(entity, attachedEntity);
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
        BsStockpileSplitDetailDao dao = getDao(BsStockpileSplitDetailDao.class);
        BsStockpileSplitDetailAttachedDao attachedDao = getDao(BsStockpileSplitDetailAttachedDao.class);

        // 一意制约检测

        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME, entities.size());
        // 设置ID
        for (int i = 0; i < entities.size(); i++) {
            BsStockpileSplitDetailEntity entity = entities.get(i);
            entity.setBsStockpileSplitDetailId(id);
            BsStockpileSplitDetailAttachedEntity attachedEntity = attachedEntities.get(i);
            attachedEntity.setBsStockpileSplitDetailId(id);
            id += 1;
        }

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BsStockpileSplitDetailEntity entity = entities.get(i);
            insertCommon(entity);
            BsStockpileSplitDetailAttachedEntity attachedEntity = attachedEntities.get(i);
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
        for (BsStockpileSplitDetail archive : archives)
            archive.setHistory();
    }

    @Override
    public void modify() {
        logger.info(this + "#modify");
        Assert.notEmpty(entities);
        Assert.notEmpty(attachedEntities);

        // 获取Dao
        BsStockpileSplitDetailDao dao = getDao(BsStockpileSplitDetailDao.class);
        BsStockpileSplitDetailAttachedDao attachedDao = getDao(BsStockpileSplitDetailAttachedDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BsStockpileSplitDetailEntity entity = entities.get(i);
            updateCommon(entity);
            BsStockpileSplitDetailAttachedEntity attachedEntity = attachedEntities.get(i);
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
        BsStockpileSplitDetailDao dao = getDao(BsStockpileSplitDetailDao.class);
        BsStockpileSplitDetailAttachedDao attachedDao = getDao(BsStockpileSplitDetailAttachedDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BsStockpileSplitDetailEntity entity = entities.get(i);
            deleteCommon(entity);
            BsStockpileSplitDetailAttachedEntity attachedEntity = attachedEntities.get(i);
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
        List<BsStockpileSplitDetailHistoryEntity> historyEntities = new ArrayList<>();
        List<BsStockpileSplitDetailAttachedHistoryEntity> attachedHistoryEntities = new ArrayList<>();
        for (BsStockpileSplitDetail archive : archives) {
            historyEntities.add(archive.getHistoryEntity());
            attachedHistoryEntities.add(archive.getAttachedHistoryEntity());
        }
        // 获取Dao
        BsStockpileSplitDetailDao dao = getDao(BsStockpileSplitDetailDao.class);
        BsStockpileSplitDetailAttachedDao attachedDao = getDao(BsStockpileSplitDetailAttachedDao.class);

        // 获取Id
        Long historyId = getBlackboard().maxId(HISTORY_TABLE_NAME, archives.size());
        for (BsStockpileSplitDetail archive : archives) {
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
            for (BsStockpileSplitDetail archive : archives)
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
    public BsStockpileSplitDetailList forComplete(Long[] ids) {
        logger.info(this + "#forComplete");
        BsStockpileSplitDetailList build = new BsStockpileSplitDetailList(ids);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象列表，用于插入数据库，此对象列表必须使用create方法插入数据库
     *
     */
    public BsStockpileSplitDetailList forCreate(BsStockpileSplitDetail[] archives) {
        logger.info(this + "#forCreate");
        BsStockpileSplitDetailList build = new BsStockpileSplitDetailList(archives);
        build.setBlackboard(blackboard);

        return build;
    }

    /**
     * 创建对象列表，用于修改/删除数据，此对象列表必须使用modify/delete方法
     *
     */
    public BsStockpileSplitDetailList forUpdate(BsStockpileSplitDetail[] archives) {
        logger.info(this + "#forUpdate");
        BsStockpileSplitDetailList build = new BsStockpileSplitDetailList(archives);
        build.setBlackboard(blackboard);
        build.setDataSynced(true);

        return build;
    }

    /**
     * 创建对象，用于根据entity.bsOrderDetailId查询数据，此对象必须使用complete方法补全
     *
     */
    public BsStockpileSplitDetailList forComplete(BsOrderDetail linkedArchive) {
        logger.info(this + "#forComplete");
        BsStockpileSplitDetailList build = new BsStockpileSplitDetailList(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    }


}