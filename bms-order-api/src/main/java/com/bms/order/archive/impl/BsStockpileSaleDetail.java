package com.bms.order.archive.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.bms.order.archive.AbstractArchive;
import com.bms.order.archive.Completable;
import com.bms.order.archive.Createable;
import com.bms.order.archive.Deletable;
import com.bms.order.archive.Linkable;
import com.bms.order.archive.Modifiable;
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
 * 买手囤货销售明细

 * @author li_huiqian

 */
public class BsStockpileSaleDetail extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(BsStockpileSaleDetail.class);

    private static final String TABLE_NAME = "ORDR_BS_STOCKPILE_SALE_DETAIL";
    private static final String HISTORY_TABLE_NAME = "ORDR_BS_STOCKPILE_SALE_DETAIL_HISTORY";

    /** 买手囤货销售明细Entity */
    private BsStockpileSaleDetailEntity entity;

    public BsStockpileSaleDetailEntity getEntity() {
        logger.info(this + "#getEntity");
        return entity;
    }

    /** 买手囤货销售明细履历表Entity */
    private BsStockpileSaleDetailHistoryEntity historyEntity;

    public BsStockpileSaleDetailHistoryEntity getHistoryEntity() {
        logger.info(this + "#getHistoryEntity");
        return historyEntity;
    }


    /** 买家订单预配送明细表 */
    private BuyerForcastDeliverDetail buyerForcastDeliverDetail;

    private boolean isBuyerForcastDeliverDetailComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void buyerForcastDeliverDetailLinked() {
        logger.info(this + "#buyerForcastDeliverDetailLinked");
        isBuyerForcastDeliverDetailComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void buyerForcastDeliverDetailUnlink() {
        logger.info(this + "#buyerForcastDeliverDetailUnlink");
        isBuyerForcastDeliverDetailComplete = false;
    }

    public BuyerForcastDeliverDetail getBuyerForcastDeliverDetail() {
        logger.info(this + "#getBuyerForcastDeliverDetail");
        if (!isDataSynced())
            return buyerForcastDeliverDetail;

        if (buyerForcastDeliverDetail == null || !isBuyerForcastDeliverDetailComplete) {
            BuyerForcastDeliverDetail buyerForcastDeliverDetail = new BuyerForcastDeliverDetail(entity.getBuyerForcastDeliverDetailId());
            buyerForcastDeliverDetail.setBlackboard(getBlackboard());
            buyerForcastDeliverDetail.complete(false);
            isBuyerForcastDeliverDetailComplete = true;
            this.buyerForcastDeliverDetail = null;
            if(buyerForcastDeliverDetail.isDataSynced())
                link(buyerForcastDeliverDetail);
        }

        return buyerForcastDeliverDetail;
    }
    /** 买手囤货分拆单明细 */
    private BsStockpileSplitDetail bsStockpileSplitDetail;

    private boolean isBsStockpileSplitDetailComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void bsStockpileSplitDetailLinked() {
        logger.info(this + "#bsStockpileSplitDetailLinked");
        isBsStockpileSplitDetailComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void bsStockpileSplitDetailUnlink() {
        logger.info(this + "#bsStockpileSplitDetailUnlink");
        isBsStockpileSplitDetailComplete = false;
    }

    public BsStockpileSplitDetail getBsStockpileSplitDetail() {
        logger.info(this + "#getBsStockpileSplitDetail");
        if (!isDataSynced())
            return bsStockpileSplitDetail;

        if (bsStockpileSplitDetail == null || !isBsStockpileSplitDetailComplete) {
            BsStockpileSplitDetail bsStockpileSplitDetail = new BsStockpileSplitDetail(entity.getBsStockpileSplitDetailId());
            bsStockpileSplitDetail.setBlackboard(getBlackboard());
            bsStockpileSplitDetail.complete(false);
            isBsStockpileSplitDetailComplete = true;
            this.bsStockpileSplitDetail = null;
            if(bsStockpileSplitDetail.isDataSynced())
                link(bsStockpileSplitDetail);
        }

        return bsStockpileSplitDetail;
    }

    /**
     * 构造函数，已过时，请使用BsStockpileSaleDetail.build(blackboard).forComplete(id)
     *
     */
    public  BsStockpileSaleDetail(Long id) {
        logger.info(this + "#BsStockpileSaleDetail");
        Assert.notNull(id);
        entity = new BsStockpileSaleDetailEntity();
        entity.setStockpileSaleDetailId(id);
    }

    /**
     * 构造函数，已过时，请使用BsStockpileSaleDetail.build(blackboard).forCreate(entity,)
     *
     */
    public  BsStockpileSaleDetail(BsStockpileSaleDetailEntity entity) {
        logger.info(this + "#BsStockpileSaleDetail");
        Assert.notNull(entity);
        this.entity = entity;
        setDataSynced(false);
    }

    /**
     * 构造函数，已过时，请使用BsStockpileSaleDetail.build(blackboard).forComplete(linkedArchive)
     *
     */
    public  BsStockpileSaleDetail(BuyerForcastDeliverDetail linkedArchive) {
        logger.info(this + "#BsStockpileSaleDetail");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getBuyerForcastDeliverDetailId());
        entity = new BsStockpileSaleDetailEntity();
        entity.setBuyerForcastDeliverDetailId(linkedArchive.getEntity().getBuyerForcastDeliverDetailId());
    }
    /**
     * 构造函数，已过时，请使用BsStockpileSaleDetail.build(blackboard).forComplete(linkedArchive)
     *
     */
    public  BsStockpileSaleDetail(BsStockpileSplitDetail linkedArchive) {
        logger.info(this + "#BsStockpileSaleDetail");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getBsStockpileSplitDetailId());
        entity = new BsStockpileSaleDetailEntity();
        entity.setBsStockpileSplitDetailId(linkedArchive.getEntity().getBsStockpileSplitDetailId());
    }

    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof BuyerForcastDeliverDetail) {
            LinkHelper.link(this, target, "entity.buyerForcastDeliverDetailId");
        
        } else if (target instanceof BsStockpileSplitDetail) {
            LinkHelper.link(this, target, "entity.bsStockpileSplitDetailId");
        
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
            LinkHelper.link(this, targets, "entity.buyerForcastDeliverDetailId");
        
        } else if (item0 instanceof BsStockpileSplitDetail) {
            LinkHelper.link(this, targets, "entity.bsStockpileSplitDetailId");
        
        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        // 判断是否是最新
        if (isDataSynced()) {
            return;
        }

        if (entity.getStockpileSaleDetailId() != null) {
            BsStockpileSaleDetailEntity entity = new BsStockpileSaleDetailEntity();
            entity.setStockpileSaleDetailId(this.entity.getStockpileSaleDetailId());
            this.entity = entity;
        } else if (entity.getBuyerForcastDeliverDetailId() != null) {
            BsStockpileSaleDetailEntity entity = new BsStockpileSaleDetailEntity();
            entity.setBuyerForcastDeliverDetailId(this.entity.getBuyerForcastDeliverDetailId());
            this.entity = entity;
        } else if (entity.getBsStockpileSplitDetailId() != null) {
            BsStockpileSaleDetailEntity entity = new BsStockpileSaleDetailEntity();
            entity.setBsStockpileSplitDetailId(this.entity.getBsStockpileSplitDetailId());
            this.entity = entity;
        }

        // 设置允许DEL_FLG=true
        if (allowDelete)
            this.entity.setDelFlg(true);
        else
            this.entity.setDelFlg(false);

        // 查询数据库
        BsStockpileSaleDetailDao dao = getDao(BsStockpileSaleDetailDao.class);
        BsStockpileSaleDetailEntity entity = dao.findOne(this.entity);
        if (entity == null)
            return;
        this.entity = entity;

        setDataSynced(true);

        // 设置历史数据
        setHistory();
    }

    @Override
    public void create() {
        logger.info(this + "#create");
        Assert.notNull(entity);

        // 判断是否需要创建
        if (isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000003);

        // 获取Dao
        BsStockpileSaleDetailDao dao = getDao(BsStockpileSaleDetailDao.class);

        // 一意制约检测
        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME);
        // 设置ID
        this.entity.setStockpileSaleDetailId(id);

        // 设置共通字段
        insertCommon(this.entity);

        // 插入数据库
        int count = dao.save(this.entity);
        if (count != 1)
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
        Assert.isTrue(isDataSynced(), "must create or complete before set history.");
        Assert.notNull(entity);
        historyEntity = new BsStockpileSaleDetailHistoryEntity(entity);
    }

    @Override
    public void modify() {
        logger.info(this + "#modify");
        Assert.notNull(entity);

        // 判断是否需要修改
        if (!isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000006);

        // 获取Dao
        BsStockpileSaleDetailDao dao = getDao(BsStockpileSaleDetailDao.class);

        // 设置共通字段
        updateCommon(this.entity);

        // 更新数据库带排他检测
        int count = dao.modify(this.entity);
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
        Assert.notNull(entity);

        // 判断是否需要删除
        if (!isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000008);

        // 获取Dao
        BsStockpileSaleDetailDao dao = getDao(BsStockpileSaleDetailDao.class);

        // 设置共通字段
        deleteCommon(this.entity);

        // 删除数据库带排他检测
        int count = dao.delete(this.entity);
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
        Assert.notNull(historyEntity, "no history entity found.");
        // 获取Dao
        BsStockpileSaleDetailDao dao = getDao(BsStockpileSaleDetailDao.class);

        // 获取Id
        Long historyId = getBlackboard().maxId(HISTORY_TABLE_NAME);
        historyEntity.setHistoryId(historyId);
        int count = dao.saveHistory(historyEntity);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000010);
    }

    @Override
    public String toString() {
        if (entity != null)
            return this.getClass().getName() + this.entity.getStockpileSaleDetailId();
        else
            return this.getClass().getName();
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
     * 创建对象，用于根据id查询数据，此对象必须使用complete方法补全
     *
     */
    public BsStockpileSaleDetail forComplete(Long id) {
        logger.info(this + "#forComplete");
        BsStockpileSaleDetail build = new BsStockpileSaleDetail(id);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于插入数据库，此对象必须使用create方法插入数据库
     *
     */
    public BsStockpileSaleDetail forCreate(BsStockpileSaleDetailEntity entity) {
        logger.info(this + "#forCreate");
        BsStockpileSaleDetail build = new BsStockpileSaleDetail(entity);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于根据entity.buyerForcastDeliverDetailId查询数据，此对象必须使用complete方法补全
     *
     */
    public BsStockpileSaleDetail forComplete(BuyerForcastDeliverDetail linkedArchive) {
        logger.info(this + "#forComplete");
        BsStockpileSaleDetail build = new BsStockpileSaleDetail(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于根据entity.bsStockpileSplitDetailId查询数据，此对象必须使用complete方法补全
     *
     */
    public BsStockpileSaleDetail forComplete(BsStockpileSplitDetail linkedArchive) {
        logger.info(this + "#forComplete");
        BsStockpileSaleDetail build = new BsStockpileSaleDetail(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    }


}