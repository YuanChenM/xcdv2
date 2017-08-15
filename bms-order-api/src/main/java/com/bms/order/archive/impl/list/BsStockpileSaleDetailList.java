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
import com.bms.order.archive.impl.BsStockpileSaleDetail;
import com.bms.order.archive.impl.BsStockpileSplitDetail;
import com.bms.order.archive.impl.BuyerForcastDeliverDetail;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.BsStockpileSaleDetailEntity;
import com.bms.order.bean.entity.BsStockpileSaleDetailHistoryEntity;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.BsStockpileSaleDetailDao;
import com.bms.order.util.LinkHelper;
import com.framework.exception.BusinessException;

/**
 *
 * 买手囤货销售明细列表辅助类

 * @author li_huiqian

 */
public class BsStockpileSaleDetailList extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(BsStockpileSaleDetailList.class);

    private static final String TABLE_NAME = "ORDR_BS_STOCKPILE_SALE_DETAIL";

    private static final String HISTORY_TABLE_NAME = "ORDR_BS_STOCKPILE_SALE_DETAIL_HISTORY";

    /** 买手囤货销售明细Entity */
    private List<BsStockpileSaleDetailEntity> entities;


    /** 买手囤货销售明细列表辅助类 */
    private List<BsStockpileSaleDetail> archives;

    public List<BsStockpileSaleDetail> getArchives() {
        logger.info(this + "#getArchives");
        return archives;
    }

    /** 买家订单预配送明细表 */
    private List<BuyerForcastDeliverDetail> buyerForcastDeliverDetails;

    /** 买手囤货分拆单明细 */
    private List<BsStockpileSplitDetail> bsStockpileSplitDetails;


    private List<Long> ids;


    /**
     * 构造函数
     *
     */
    public  BsStockpileSaleDetailList(Long[] ids) {
        logger.info(this + "#BsStockpileSaleDetailList");
        Assert.notEmpty(ids);
        this.ids = new ArrayList<>();
        for (Long id : ids)
            this.ids.add(id);
    }

    /**
     * 构造函数
     *
     */
    public  BsStockpileSaleDetailList(List<BsStockpileSaleDetailEntity> entities) {
        logger.info(this + "#BsStockpileSaleDetailList");
        Assert.notEmpty(entities);
        this.entities = entities;
        setDataSynced(false);
    }

    /**
     * 构造函数
     *
     */
    public  BsStockpileSaleDetailList(BsStockpileSaleDetail[] archives) {
        logger.info(this + "#BsStockpileSaleDetailList");
        Assert.notEmpty(archives);
        for (BsStockpileSaleDetail archive : archives) {
            Assert.notNull(archive.getEntity());
        }

        this.archives = new ArrayList<>();
        this.entities = new ArrayList<>();
        for (BsStockpileSaleDetail archive : archives) {
            this.archives.add(archive);
            this.entities.add(archive.getEntity());
        }

        setDataSynced(false);
    }

    /**
     * 构造函数
     *
     */
    public  BsStockpileSaleDetailList(BuyerForcastDeliverDetail linkedArchive) {
        logger.info(this + "#BsStockpileSaleDetailList");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getBuyerForcastDeliverDetailId());
        this.buyerForcastDeliverDetails = new ArrayList<>();
        this.buyerForcastDeliverDetails.add(linkedArchive);
    }

    /**
     * 构造函数
     *
     */
    public  BsStockpileSaleDetailList(BuyerForcastDeliverDetail[] linkedArchives) {
        logger.info(this + "#BsStockpileSaleDetailList");
        Assert.notEmpty(linkedArchives);
        this.buyerForcastDeliverDetails = new ArrayList<>();
        for (BuyerForcastDeliverDetail linkedArchive : linkedArchives) {
            Assert.notNull(linkedArchive.getEntity());
            Assert.notNull(linkedArchive.getEntity().getBuyerForcastDeliverDetailId());
            this.buyerForcastDeliverDetails.add(linkedArchive);
        }
    }

    /**
     * 构造函数
     *
     */
    public  BsStockpileSaleDetailList(BsStockpileSplitDetail linkedArchive) {
        logger.info(this + "#BsStockpileSaleDetailList");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getBsStockpileSplitDetailId());
        this.bsStockpileSplitDetails = new ArrayList<>();
        this.bsStockpileSplitDetails.add(linkedArchive);
    }

    /**
     * 构造函数
     *
     */
    public  BsStockpileSaleDetailList(BsStockpileSplitDetail[] linkedArchives) {
        logger.info(this + "#BsStockpileSaleDetailList");
        Assert.notEmpty(linkedArchives);
        this.bsStockpileSplitDetails = new ArrayList<>();
        for (BsStockpileSplitDetail linkedArchive : linkedArchives) {
            Assert.notNull(linkedArchive.getEntity());
            Assert.notNull(linkedArchive.getEntity().getBsStockpileSplitDetailId());
            this.bsStockpileSplitDetails.add(linkedArchive);
        }
    }


    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof BuyerForcastDeliverDetail) {
            LinkHelper.link(this.archives, target, "entity.buyerForcastDeliverDetailId");
        
        } else if (target instanceof BsStockpileSplitDetail) {
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

        if (item0 instanceof BuyerForcastDeliverDetail) {
            LinkHelper.link(this.archives, targets, "entity.buyerForcastDeliverDetailId");
        
        } else if (item0 instanceof BsStockpileSplitDetail) {
            LinkHelper.link(this.archives, targets, "entity.bsStockpileSplitDetailId");
        
        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        Map<String, Object> map = new HashMap<>();

        if (ids != null && ids.size() != 0)
            map.put("ids", ids);
        else if (buyerForcastDeliverDetails != null && buyerForcastDeliverDetails.size() != 0)
            map.put("buyerForcastDeliverDetails", buyerForcastDeliverDetails);
        else if (bsStockpileSplitDetails != null && bsStockpileSplitDetails.size() != 0)
            map.put("bsStockpileSplitDetails", bsStockpileSplitDetails);
        // 设置允许DEL_FLG=true
        if (allowDelete)
            map.put("delFlg", true);
        else
            map.put("delFlg", false);

        // 查询数据库
        BsStockpileSaleDetailDao dao = getDao(BsStockpileSaleDetailDao.class);
        List<BsStockpileSaleDetailEntity> entities = dao.findAll(map);
        if (entities == null || entities.isEmpty())
            return;

        for (BsStockpileSaleDetailEntity entity : entities) {
            BsStockpileSaleDetail archive = BsStockpileSaleDetail.build(getBlackboard()).forCreate(entity);
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
        BsStockpileSaleDetailDao dao = getDao(BsStockpileSaleDetailDao.class);

        // 一意制约检测

        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME, entities.size());
        // 设置ID
        for (int i = 0; i < entities.size(); i++) {
            BsStockpileSaleDetailEntity entity = entities.get(i);
            entity.setStockpileSaleDetailId(id);
            id += 1;
        }

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BsStockpileSaleDetailEntity entity = entities.get(i);
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
        for (BsStockpileSaleDetail archive : archives)
            archive.setHistory();
    }

    @Override
    public void modify() {
        logger.info(this + "#modify");
        Assert.notEmpty(entities);

        // 获取Dao
        BsStockpileSaleDetailDao dao = getDao(BsStockpileSaleDetailDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BsStockpileSaleDetailEntity entity = entities.get(i);
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
        BsStockpileSaleDetailDao dao = getDao(BsStockpileSaleDetailDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BsStockpileSaleDetailEntity entity = entities.get(i);
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
        List<BsStockpileSaleDetailHistoryEntity> historyEntities = new ArrayList<>();
        for (BsStockpileSaleDetail archive : archives) {
            historyEntities.add(archive.getHistoryEntity());
        }
        // 获取Dao
        BsStockpileSaleDetailDao dao = getDao(BsStockpileSaleDetailDao.class);

        // 获取Id
        Long historyId = getBlackboard().maxId(HISTORY_TABLE_NAME, archives.size());
        for (BsStockpileSaleDetail archive : archives) {
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
            for (BsStockpileSaleDetail archive : archives)
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
    public BsStockpileSaleDetailList forComplete(Long[] ids) {
        logger.info(this + "#forComplete");
        BsStockpileSaleDetailList build = new BsStockpileSaleDetailList(ids);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象列表，用于插入数据库，此对象列表必须使用create方法插入数据库
     *
     */
    public BsStockpileSaleDetailList forCreate(BsStockpileSaleDetail[] archives) {
        logger.info(this + "#forCreate");
        BsStockpileSaleDetailList build = new BsStockpileSaleDetailList(archives);
        build.setBlackboard(blackboard);

        return build;
    }

    /**
     * 创建对象列表，用于修改/删除数据，此对象列表必须使用modify/delete方法
     *
     */
    public BsStockpileSaleDetailList forUpdate(BsStockpileSaleDetail[] archives) {
        logger.info(this + "#forUpdate");
        BsStockpileSaleDetailList build = new BsStockpileSaleDetailList(archives);
        build.setBlackboard(blackboard);
        build.setDataSynced(true);

        return build;
    }

    /**
     * 创建对象，用于根据entity.buyerForcastDeliverDetailId查询数据，此对象必须使用complete方法补全
     *
     */
    public BsStockpileSaleDetailList forComplete(BuyerForcastDeliverDetail linkedArchive) {
        logger.info(this + "#forComplete");
        BsStockpileSaleDetailList build = new BsStockpileSaleDetailList(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于根据entity.bsStockpileSplitDetailId查询数据，此对象必须使用complete方法补全
     *
     */
    public BsStockpileSaleDetailList forComplete(BsStockpileSplitDetail linkedArchive) {
        logger.info(this + "#forComplete");
        BsStockpileSaleDetailList build = new BsStockpileSaleDetailList(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    }


}