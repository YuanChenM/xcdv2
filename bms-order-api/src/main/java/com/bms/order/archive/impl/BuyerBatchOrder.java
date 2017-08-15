package com.bms.order.archive.impl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.bms.order.archive.AbstractArchive;
import com.bms.order.archive.Codeable;
import com.bms.order.archive.Completable;
import com.bms.order.archive.Createable;
import com.bms.order.archive.Deletable;
import com.bms.order.archive.Linkable;
import com.bms.order.archive.Modifiable;
import com.bms.order.archive.impl.list.BuyerBatchOrderDetailList;
import com.bms.order.archive.impl.list.BuyerForcastDeliverDetailList;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.BuyerBatchOrderAttachedEntity;
import com.bms.order.bean.entity.BuyerBatchOrderAttachedHistoryEntity;
import com.bms.order.bean.entity.BuyerBatchOrderEntity;
import com.bms.order.bean.entity.BuyerBatchOrderHistoryEntity;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.BuyerBatchOrderAttachedDao;
import com.bms.order.dao.BuyerBatchOrderDao;
import com.bms.order.util.CodeRule;
import com.bms.order.util.LinkHelper;
import com.framework.core.utils.DecimalUtils;
import com.framework.exception.BusinessException;

/**
 * 分批订单表/子订单表
 *
 * @author li_huiqian
 */
public class BuyerBatchOrder extends AbstractArchive
        implements Completable, Createable, Linkable, Modifiable, Deletable, Codeable {

    private static Logger logger = LoggerFactory.getLogger(BuyerBatchOrder.class);

    private static final String TABLE_NAME = "ORDR_BUYER_BATCH_ORDER";
    private static final String HISTORY_TABLE_NAME = "ORDR_BUYER_BATCH_ORDER_HISTORY";

    /**
     * 买家分批订单Entity
     */
    private BuyerBatchOrderEntity entity;

    public BuyerBatchOrderEntity getEntity() {
        logger.info(this + "#getEntity");
        return entity;
    }

    /**
     * 买家分批订单履历表Entity
     */
    private BuyerBatchOrderHistoryEntity historyEntity;

    public BuyerBatchOrderHistoryEntity getHistoryEntity() {
        logger.info(this + "#getHistoryEntity");
        return historyEntity;
    }

    /**
     * 买家分批订单附表Entity
     */
    private BuyerBatchOrderAttachedEntity attachedEntity;

    public BuyerBatchOrderAttachedEntity getAttachedEntity() {
        logger.info(this + "#getAttachedEntity");
        return attachedEntity;
    }

    /**
     * 买家分批订单附表履历表Entity
     */
    private BuyerBatchOrderAttachedHistoryEntity attachedHistoryEntity;

    public BuyerBatchOrderAttachedHistoryEntity getAttachedHistoryEntity() {
        logger.info(this + "#getAttachedHistoryEntity");
        return attachedHistoryEntity;
    }

    /**
     * 订单主表
     */
    private BuyerOrder buyerOrder;

    private boolean isBuyerOrderComplete = false;

    /**
     * 关联完毕后调用
     */
    public void buyerOrderLinked() {
        logger.info(this + "#buyerOrderLinked");
        isBuyerOrderComplete = true;
    }

    /**
     * 重新取数据时用
     */
    public void buyerOrderUnlink() {
        logger.info(this + "#buyerOrderUnlink");
        isBuyerOrderComplete = false;
    }

    public BuyerOrder getBuyerOrder() {
        logger.info(this + "#getBuyerOrder");
        if (!isDataSynced())
            return buyerOrder;

        if (buyerOrder == null || !isBuyerOrderComplete) {
            BuyerOrder buyerOrder = new BuyerOrder(entity.getBuyerOrderId());
            buyerOrder.setBlackboard(getBlackboard());
            buyerOrder.complete(false);
            isBuyerOrderComplete = true;
            this.buyerOrder = null;
            if (buyerOrder.isDataSynced())
                link(buyerOrder);
        }

        return buyerOrder;
    }

    /**
     * 订单明细表，订单的原始信息，与客户提交的订单保持一致
     */
    private List<BuyerBatchOrderDetail> buyerBatchOrderDetails;

    private boolean isBuyerBatchOrderDetailsComplete = false;

    /**
     * 关联完毕后调用
     */
    public void buyerBatchOrderDetailsLinked() {
        logger.info(this + "#buyerBatchOrderDetailsLinked");
        isBuyerBatchOrderDetailsComplete = true;
    }

    /**
     * 重新取数据时用
     */
    public void buyerBatchOrderDetailsUnlink() {
        logger.info(this + "#buyerBatchOrderDetailsUnlink");
        isBuyerBatchOrderDetailsComplete = false;
    }

    public List<BuyerBatchOrderDetail> getBuyerBatchOrderDetails() {
        logger.info(this + "#getBuyerBatchOrderDetails");
        if (!isDataSynced())
            return buyerBatchOrderDetails;

        if (buyerBatchOrderDetails == null || !isBuyerBatchOrderDetailsComplete) {
            BuyerBatchOrderDetailList list = new BuyerBatchOrderDetailList(this);
            list.setBlackboard(getBlackboard());
            list.complete(false);
            isBuyerBatchOrderDetailsComplete = true;
            buyerBatchOrderDetails = null;
            if (list.isDataSynced()) {
                link(list.getArchives());
                for (BuyerBatchOrderDetail item : buyerBatchOrderDetails)
                    item.buyerBatchOrderLinked();
            }
        }

        return buyerBatchOrderDetails;
    }

    /**
     * 买家订单预配送明细表
     */
    private List<BuyerForcastDeliverDetail> buyerForcastDeliverDetails;

    private boolean isBuyerForcastDeliverDetailsComplete = false;

    /**
     * 关联完毕后调用
     */
    public void buyerForcastDeliverDetailsLinked() {
        logger.info(this + "#buyerForcastDeliverDetailsLinked");
        isBuyerForcastDeliverDetailsComplete = true;
    }

    /**
     * 重新取数据时用
     */
    public void buyerForcastDeliverDetailsUnlink() {
        logger.info(this + "#buyerForcastDeliverDetailsUnlink");
        isBuyerForcastDeliverDetailsComplete = false;
    }

    public List<BuyerForcastDeliverDetail> getBuyerForcastDeliverDetails() {
        logger.info(this + "#getBuyerForcastDeliverDetails");
        if (!isDataSynced())
            return buyerForcastDeliverDetails;

        if (buyerForcastDeliverDetails == null || !isBuyerForcastDeliverDetailsComplete) {
            BuyerForcastDeliverDetailList list = new BuyerForcastDeliverDetailList(this);
            list.setBlackboard(getBlackboard());
            list.complete(false);
            isBuyerForcastDeliverDetailsComplete = true;
            buyerForcastDeliverDetails = null;
            if (list.isDataSynced()) {
                link(list.getArchives());
                for (BuyerForcastDeliverDetail item : buyerForcastDeliverDetails)
                    item.buyerBatchOrderLinked();
            }
        }

        return buyerForcastDeliverDetails;
    }

    /**
     * 构造函数，已过时，请使用BuyerBatchOrder.build(blackboard).forComplete(id)
     */
    
    public BuyerBatchOrder(Long id) {
        logger.info(this + "#BuyerBatchOrder");
        Assert.notNull(id);
        entity = new BuyerBatchOrderEntity();
        entity.setBuyerBatchOrderId(id);
    }

    /**
     * 构造函数，已过时，请使用BuyerBatchOrder.build(blackboard).forComplete(code)
     */
    
    public BuyerBatchOrder(String code) {
        logger.info(this + "#BuyerBatchOrder");
        Assert.notNull(code);
        entity = new BuyerBatchOrderEntity();
        entity.setBuyerBatchOrderCode(code);
    }

    /**
     * 构造函数，已过时，请使用BuyerBatchOrder.build(blackboard).forCreate(entity,,BuyerBatchOrderAttachedEntity)
     */
    
    public BuyerBatchOrder(BuyerBatchOrderEntity entity, BuyerBatchOrderAttachedEntity attachedEntity) {
        logger.info(this + "#BuyerBatchOrder");
        Assert.notNull(entity);
        Assert.notNull(attachedEntity);
        this.entity = entity;
        this.attachedEntity = attachedEntity;
        setDataSynced(false);
    }

    /**
     * 构造函数，已过时，请使用BuyerBatchOrder.build(blackboard).forComplete(linkedArchive)
     */
    
    public BuyerBatchOrder(BuyerOrder linkedArchive) {
        logger.info(this + "#BuyerBatchOrder");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getBuyerOrderId());
        entity = new BuyerBatchOrderEntity();
        entity.setBuyerOrderId(linkedArchive.getEntity().getBuyerOrderId());
    }

    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof BuyerOrder) {
            LinkHelper.link(this, target, "entity.buyerOrderId");

        } else if (target instanceof BuyerBatchOrderDetail) {
            LinkHelper.link(this, target, "entity.buyerBatchOrderId");

        } else if (target instanceof BuyerForcastDeliverDetail) {
            LinkHelper.link(this, target, "entity.buyerBatchOrderId");

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
            LinkHelper.link(this, targets, "entity.buyerOrderId");

        } else if (item0 instanceof BuyerBatchOrderDetail) {
            LinkHelper.link(this, targets, "entity.buyerBatchOrderId");

        } else if (item0 instanceof BuyerForcastDeliverDetail) {
            LinkHelper.link(this, targets, "entity.buyerBatchOrderId");

        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        // 判断是否是最新
        if (isDataSynced()) {
            return;
        }

        if (entity.getBuyerBatchOrderId() != null) {
            BuyerBatchOrderEntity entity = new BuyerBatchOrderEntity();
            entity.setBuyerBatchOrderId(this.entity.getBuyerBatchOrderId());
            this.entity = entity;
        } else if (entity.getBuyerBatchOrderCode() != null) {
            BuyerBatchOrderEntity entity = new BuyerBatchOrderEntity();
            entity.setBuyerBatchOrderCode(this.entity.getBuyerBatchOrderCode());
            this.entity = entity;
        } else if (entity.getBuyerOrderId() != null) {
            BuyerBatchOrderEntity entity = new BuyerBatchOrderEntity();
            entity.setBuyerOrderId(this.entity.getBuyerOrderId());
            this.entity = entity;
        }

        // 设置允许DEL_FLG=true
        if (allowDelete)
            this.entity.setDelFlg(true);
        else
            this.entity.setDelFlg(false);

        // 查询数据库
        BuyerBatchOrderDao dao = getDao(BuyerBatchOrderDao.class);
        BuyerBatchOrderEntity entity = dao.findOne(this.entity);
        if (entity == null)
            return;
        this.entity = entity;

        BuyerBatchOrderAttachedDao attachedDao = getDao(BuyerBatchOrderAttachedDao.class);
        BuyerBatchOrderAttachedEntity attachedEntity = attachedDao.findOne(this.entity);
        if (attachedEntity == null)
            return;
        this.attachedEntity = attachedEntity;

        setDataSynced(true);

        // 设置历史数据
        setHistory();
    }

    @Override
    public void create() {
        logger.info(this + "#create");
        Assert.notNull(entity);
        Assert.notNull(attachedEntity);

        // 判断是否需要创建
        if (isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000003);

        // 获取Dao
        BuyerBatchOrderDao dao = getDao(BuyerBatchOrderDao.class);
        BuyerBatchOrderAttachedDao attachedDao = getDao(BuyerBatchOrderAttachedDao.class);

        // 生成编码
        generateCode();

        // 一意制约检测
        BuyerBatchOrder unique = new BuyerBatchOrder(entity.getBuyerBatchOrderCode());
        unique.setBlackboard(getBlackboard());
        unique.complete(false);
        if (unique.isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000004);
        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME);
        // 设置ID
        this.entity.setBuyerBatchOrderId(id);
        this.attachedEntity.setBuyerBatchOrderId(id);

        // 设置共通字段
        insertCommon(this.entity);
        insertCommon(this.attachedEntity);

        // 插入数据库
        int count = dao.save(this.entity);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000005);
        count = attachedDao.save(this.attachedEntity);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000005);

        setDataSynced(true);

        // 设置历史数据
        setHistory();
    }

    /**
     * 为以此时的entity建立历史Entity，此时的数据必须从数据库查出来，这一步不插入数据库
     */
    public void setHistory() {
        logger.info(this + "#setHistory");
        Assert.isTrue(isDataSynced(), "must create or complete before set history.");
        Assert.notNull(entity);
        Assert.notNull(attachedEntity);
        historyEntity = new BuyerBatchOrderHistoryEntity(entity);
        attachedHistoryEntity = new BuyerBatchOrderAttachedHistoryEntity(attachedEntity);
    }

    @Override
    public void modify() {
        logger.info(this + "#modify");
        Assert.notNull(entity);
        Assert.notNull(attachedEntity);

        // 判断是否需要修改
        if (!isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000006);

        // 获取Dao
        BuyerBatchOrderDao dao = getDao(BuyerBatchOrderDao.class);
        BuyerBatchOrderAttachedDao attachedDao = getDao(BuyerBatchOrderAttachedDao.class);

        // 设置共通字段
        updateCommon(this.entity);
        updateCommon(this.attachedEntity);

        // 更新数据库带排他检测
        int count = dao.modify(this.entity);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000007);
        count = attachedDao.modify(this.attachedEntity);
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
        Assert.notNull(attachedEntity);

        // 判断是否需要删除
        if (!isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000008);

        // 获取Dao
        BuyerBatchOrderDao dao = getDao(BuyerBatchOrderDao.class);
        BuyerBatchOrderAttachedDao attachedDao = getDao(BuyerBatchOrderAttachedDao.class);

        // 设置共通字段
        deleteCommon(this.entity);
        deleteCommon(this.attachedEntity);

        // 删除数据库带排他检测
        int count = dao.delete(this.entity);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000009);
        count = attachedDao.modify(this.attachedEntity);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000009);

        // 插入历史数据
        saveHistory();
        // 设置历史数据
        setHistory();
    }

    /**
     * 保存历史数据，在修改或删除之后调用
     */
    private void saveHistory() {
        logger.info(this + "#saveHistory");
        Assert.notNull(historyEntity, "no history entity found.");
        Assert.notNull(attachedHistoryEntity, "no attached history entity found.");
        // 获取Dao
        BuyerBatchOrderDao dao = getDao(BuyerBatchOrderDao.class);
        BuyerBatchOrderAttachedDao attachedDao = getDao(BuyerBatchOrderAttachedDao.class);

        // 获取Id
        Long historyId = getBlackboard().maxId(HISTORY_TABLE_NAME);
        historyEntity.setHistoryId(historyId);
        int count = dao.saveHistory(historyEntity);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000010);
        attachedHistoryEntity.setHistoryId(historyId);
        count = attachedDao.saveHistory(attachedHistoryEntity);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000010);
    }

    @Override
    public String toString() {
        if (entity != null)
            return this.getClass().getName() + this.entity.getBuyerBatchOrderId();
        else
            return this.getClass().getName();
    }

    public static Builder build(Blackboard blackboard) {
        return new Builder(blackboard);
    }

    public static class Builder {

        private Blackboard blackboard;

        public Builder(Blackboard blackboard) {
            logger.info(this + "#Builder");
            this.blackboard = blackboard;
        }

        /**
         * 创建对象，用于根据id查询数据，此对象必须使用complete方法补全
         */
        public BuyerBatchOrder forComplete(Long id) {
            logger.info(this + "#forComplete");
            BuyerBatchOrder build = new BuyerBatchOrder(id);
            build.setBlackboard(blackboard);
            return build;
        }

        /**
         * 创建对象，用于根据code查询数据，此对象必须使用complete方法补全
         */
        public BuyerBatchOrder forComplete(String code) {
            logger.info(this + "#forComplete");
            BuyerBatchOrder build = new BuyerBatchOrder(code);
            build.setBlackboard(blackboard);
            return build;
        }

        /**
         * 创建对象，用于插入数据库，此对象必须使用create方法插入数据库
         */
        public BuyerBatchOrder forCreate(BuyerBatchOrderEntity entity, BuyerBatchOrderAttachedEntity attachedEntity) {
            logger.info(this + "#forCreate");
            BuyerBatchOrder build = new BuyerBatchOrder(entity, attachedEntity);
            build.setBlackboard(blackboard);
            return build;
        }

        /**
         * 创建对象，用于根据entity.buyerOrderId查询数据，此对象必须使用complete方法补全
         */
        public BuyerBatchOrder forComplete(BuyerOrder linkedArchive) {
            logger.info(this + "#forComplete");
            BuyerBatchOrder build = new BuyerBatchOrder(linkedArchive);
            build.setBlackboard(blackboard);
            return build;
        }

    }

    /**
     * 生成买家分批订单编码
     *
     * @return
     */
    public String createBuyerBatchOrderCode() {
        String bsOrderCode = null;
        // bsOrderCode-yyyy-mm-dd-0001
        String s = UUID.randomUUID().toString();
        // 去掉“-”符号
        bsOrderCode = s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23)
                + s.substring(24);
        return bsOrderCode;
    }

    /**
     * 计算订单金额（分批订单中所有商品的总额）
     *
     * @return
     */
    public BigDecimal calculateOrderAmount() {
        BigDecimal orderAmount = new BigDecimal(0);
        List<BuyerBatchOrderDetail> detailList = this.getBuyerBatchOrderDetails();
        if (null != detailList && detailList.size() > 0) {
            for (BuyerBatchOrderDetail detail : detailList) {
                BigDecimal realUnitPrice = detail.getEntity().getRealUnitPrice();
                BigDecimal goodsQuantity = detail.getEntity().getGoodsQuantity();
                BigDecimal cancelQuantity = detail.getEntity().getCancelQuantity();
                BigDecimal goodsNum = DecimalUtils.subtract(goodsQuantity, cancelQuantity);
                orderAmount = DecimalUtils.add(orderAmount, DecimalUtils.multiply(realUnitPrice, goodsNum));
            }
        }
        DecimalFormat df = new DecimalFormat("#.00");
        orderAmount = new BigDecimal(df.format(orderAmount));
        return orderAmount;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (!(obj instanceof BuyerBatchOrder)) {
            return false;
        }
        BuyerBatchOrder target = (BuyerBatchOrder) obj;
        Long thisId = null;
        if (this.entity != null)
            thisId = this.entity.getBuyerBatchOrderId();
        Long objId = null;
        if (target.getEntity() != null)
            objId = target.getEntity().getBuyerBatchOrderId();
        if (thisId == null || objId == null)
            return false;
        return thisId == objId;
    }

    @Override
    public void generateCode() {
        entity.setBuyerBatchOrderCode(CodeRule.batchOrderRule(getBuyerOrder().getEntity().getBuyerOrderCode()));
    }
}