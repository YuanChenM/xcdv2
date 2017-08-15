package com.bms.order.archive.impl;

import com.bms.order.archive.*;
import com.bms.order.archive.impl.list.BuyerBatchOrderDetailList;
import com.bms.order.archive.impl.list.BuyerBatchOrderList;
import com.bms.order.archive.impl.list.DistributionNotificationList;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.BuyerBatchOrderDetailSummary;
import com.bms.order.bean.entity.*;
import com.bms.order.constant.enumeration.*;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.BuyerOrderAttachedDao;
import com.bms.order.dao.BuyerOrderDao;
import com.bms.order.external.archive.Price;
import com.bms.order.external.bean.entity.PriceEntity;
import com.bms.order.external.bean.param.PriceRestParam;
import com.bms.order.util.CodeRule;
import com.bms.order.util.LinkHelper;
import com.framework.core.utils.DecimalUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.number.generate.NumberGenerateManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.*;

/**
 * 订单主表
 *
 * @author li_huiqian
 */
public class BuyerOrder extends AbstractArchive
        implements Completable, Createable, Linkable, Modifiable, Deletable, Codeable {

    private static Logger logger = LoggerFactory.getLogger(BuyerOrder.class);

    private static final String TABLE_NAME = "ORDR_BUYER_ORDER";
    private static final String HISTORY_TABLE_NAME = "ORDR_BUYER_ORDER_HISTORY";

    /**
     * 买家订单Entity
     */
    private BuyerOrderEntity entity;

    public BuyerOrderEntity getEntity() {
        logger.info(this + "#getEntity");
        return entity;
    }

    /**
     * 买家订单履历表Entity
     */
    private BuyerOrderHistoryEntity historyEntity;

    public BuyerOrderHistoryEntity getHistoryEntity() {
        logger.info(this + "#getHistoryEntity");
        return historyEntity;
    }

    /**
     * 买家订单附表Entity
     */
    private BuyerOrderAttachedEntity attachedEntity;

    public BuyerOrderAttachedEntity getAttachedEntity() {
        logger.info(this + "#getAttachedEntity");
        return attachedEntity;
    }

    /**
     * 买家订单附表履历表Entity
     */
    private BuyerOrderAttachedHistoryEntity attachedHistoryEntity;

    public BuyerOrderAttachedHistoryEntity getAttachedHistoryEntity() {
        logger.info(this + "#getAttachedHistoryEntity");
        return attachedHistoryEntity;
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
                    item.buyerOrderLinked();
            }
        }

        return buyerBatchOrderDetails;
    }

    /**
     * 分批订单表/子订单表
     */
    private List<BuyerBatchOrder> buyerBatchOrders;

    private boolean isBuyerBatchOrdersComplete = false;

    /**
     * 关联完毕后调用
     */
    public void buyerBatchOrdersLinked() {
        logger.info(this + "#buyerBatchOrdersLinked");
        isBuyerBatchOrdersComplete = true;
    }

    /**
     * 重新取数据时用
     */
    public void buyerBatchOrdersUnlink() {
        logger.info(this + "#buyerBatchOrdersUnlink");
        isBuyerBatchOrdersComplete = false;
    }

    public List<BuyerBatchOrder> getBuyerBatchOrders() {
        logger.info(this + "#getBuyerBatchOrders");
        if (!isDataSynced())
            return buyerBatchOrders;

        if (buyerBatchOrders == null || !isBuyerBatchOrdersComplete) {
            BuyerBatchOrderList list = new BuyerBatchOrderList(this);
            list.setBlackboard(getBlackboard());
            list.complete(false);
            isBuyerBatchOrdersComplete = true;
            buyerBatchOrders = null;
            if (list.isDataSynced()) {
                link(list.getArchives());
                for (BuyerBatchOrder item : buyerBatchOrders)
                    item.buyerOrderLinked();
            }
        }

        return buyerBatchOrders;
    }

    /**
     * 配送通知单表
     */
    private List<DistributionNotification> distributionNotifications;

    private boolean isDistributionNotificationsComplete = false;

    /**
     * 关联完毕后调用
     */
    public void distributionNotificationsLinked() {
        logger.info(this + "#distributionNotificationsLinked");
        isDistributionNotificationsComplete = true;
    }

    /**
     * 重新取数据时用
     */
    public void distributionNotificationsUnlink() {
        logger.info(this + "#distributionNotificationsUnlink");
        isDistributionNotificationsComplete = false;
    }

    public List<DistributionNotification> getDistributionNotifications() {
        logger.info(this + "#getDistributionNotifications");
        if (!isDataSynced())
            return distributionNotifications;

        if (distributionNotifications == null || !isDistributionNotificationsComplete) {
            DistributionNotificationList list = new DistributionNotificationList(this);
            list.setBlackboard(getBlackboard());
            list.complete(false);
            isDistributionNotificationsComplete = true;
            distributionNotifications = null;
            if (list.isDataSynced()) {
                link(list.getArchives());
                for (DistributionNotification item : distributionNotifications)
                    item.buyerOrderLinked();
            }
        }

        return distributionNotifications;
    }

    /**
     * 价格通道通知单
     */
    private PriceChannelNotification priceChannelNotification;

    private boolean isPriceChannelNotificationComplete = false;

    /**
     * 关联完毕后调用
     */
    public void priceChannelNotificationLinked() {
        logger.info(this + "#priceChannelNotificationLinked");
        isPriceChannelNotificationComplete = true;
    }

    /**
     * 重新取数据时用
     */
    public void priceChannelNotificationUnlink() {
        logger.info(this + "#priceChannelNotificationUnlink");
        isPriceChannelNotificationComplete = false;
    }

    public PriceChannelNotification getPriceChannelNotification() {
        logger.info(this + "#getPriceChannelNotification");
        if (!isDataSynced())
            return priceChannelNotification;

        if (priceChannelNotification == null || !isPriceChannelNotificationComplete) {
            PriceChannelNotification priceChannelNotification = new PriceChannelNotification(this);
            priceChannelNotification.setBlackboard(getBlackboard());
            priceChannelNotification.complete(false);
            isPriceChannelNotificationComplete = true;
            this.priceChannelNotification = null;
            if (priceChannelNotification.isDataSynced())
                link(priceChannelNotification);
            priceChannelNotification.buyerOrderLinked();
        }

        return priceChannelNotification;
    }

    /**
     * 构造函数，已过时，请使用BuyerOrder.build(blackboard).forComplete(id)
     */
    
    public BuyerOrder(Long id) {
        logger.info(this + "#BuyerOrder");
        Assert.notNull(id);
        entity = new BuyerOrderEntity();
        entity.setBuyerOrderId(id);
    }

    /**
     * 构造函数，已过时，请使用BuyerOrder.build(blackboard).forComplete(code)
     */
    
    public BuyerOrder(String code) {
        logger.info(this + "#BuyerOrder");
        Assert.notNull(code);
        entity = new BuyerOrderEntity();
        entity.setBuyerOrderCode(code);
    }

    /**
     * 构造函数，已过时，请使用BuyerOrder.build(blackboard).forCreate(entity,,BuyerOrderAttachedEntity)
     */
    
    public BuyerOrder(BuyerOrderEntity entity, BuyerOrderAttachedEntity attachedEntity) {
        logger.info(this + "#BuyerOrder");
        Assert.notNull(entity);
        Assert.notNull(attachedEntity);
        this.entity = entity;
        this.attachedEntity = attachedEntity;
        setDataSynced(false);
    }

    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof BuyerBatchOrderDetail) {
            LinkHelper.link(this, target, "entity.buyerOrderId");

        } else if (target instanceof BuyerBatchOrder) {
            LinkHelper.link(this, target, "entity.buyerOrderId");

        } else if (target instanceof DistributionNotification) {
            LinkHelper.link(this, target, "entity.buyerOrderId");

        } else if (target instanceof PriceChannelNotification) {
            LinkHelper.link(this, target, "entity.buyerOrderId");

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
            LinkHelper.link(this, targets, "entity.buyerOrderId");

        } else if (item0 instanceof BuyerBatchOrder) {
            LinkHelper.link(this, targets, "entity.buyerOrderId");

        } else if (item0 instanceof DistributionNotification) {
            LinkHelper.link(this, targets, "entity.buyerOrderId");

        } else if (item0 instanceof PriceChannelNotification) {
            LinkHelper.link(this, targets, "entity.buyerOrderId");

        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        // 判断是否是最新
        if (isDataSynced()) {
            return;
        }

        if (entity.getBuyerOrderId() != null) {
            BuyerOrderEntity entity = new BuyerOrderEntity();
            entity.setBuyerOrderId(this.entity.getBuyerOrderId());
            this.entity = entity;
        } else if (entity.getBuyerOrderCode() != null) {
            BuyerOrderEntity entity = new BuyerOrderEntity();
            entity.setBuyerOrderCode(this.entity.getBuyerOrderCode());
            this.entity = entity;
        } else if(entity.getBackNo() != null){
            BuyerOrderEntity entity = new BuyerOrderEntity();
            entity.setBackNo(this.entity.getBackNo());
            this.entity = entity;
        }

        // 设置允许DEL_FLG=true
        if (allowDelete)
            this.entity.setDelFlg(true);
        else
            this.entity.setDelFlg(false);

        // 查询数据库
        BuyerOrderDao dao = getDao(BuyerOrderDao.class);
        BuyerOrderEntity entity = dao.findOne(this.entity);
        if (entity == null)
            return;
        this.entity = entity;

        BuyerOrderAttachedDao attachedDao = getDao(BuyerOrderAttachedDao.class);
        BuyerOrderAttachedEntity attachedEntity = attachedDao.findOne(this.entity);
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
        BuyerOrderDao dao = getDao(BuyerOrderDao.class);
        BuyerOrderAttachedDao attachedDao = getDao(BuyerOrderAttachedDao.class);

        // 设置编码
        generateCode();

        // 一意制约检测
        BuyerOrder unique = new BuyerOrder(entity.getBuyerOrderCode());
        unique.setBlackboard(getBlackboard());
        unique.complete(false);
        if (unique.isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000004);
        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME);
        // 设置ID
        this.entity.setBuyerOrderId(id);
        this.attachedEntity.setBuyerOrderId(id);

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
        historyEntity = new BuyerOrderHistoryEntity(entity);
        attachedHistoryEntity = new BuyerOrderAttachedHistoryEntity(attachedEntity);
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
        BuyerOrderDao dao = getDao(BuyerOrderDao.class);
        BuyerOrderAttachedDao attachedDao = getDao(BuyerOrderAttachedDao.class);

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
        BuyerOrderDao dao = getDao(BuyerOrderDao.class);
        BuyerOrderAttachedDao attachedDao = getDao(BuyerOrderAttachedDao.class);

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
        BuyerOrderDao dao = getDao(BuyerOrderDao.class);
        BuyerOrderAttachedDao attachedDao = getDao(BuyerOrderAttachedDao.class);

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
            return this.getClass().getName() + this.entity.getBuyerOrderId();
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
        public BuyerOrder forComplete(Long id) {
            logger.info(this + "#forComplete");
            BuyerOrder build = new BuyerOrder(id);
            build.setBlackboard(blackboard);
            return build;
        }

        /**
         * 创建对象，用于根据code查询数据，此对象必须使用complete方法补全
         */
        public BuyerOrder forComplete(String code) {
            logger.info(this + "#forComplete");
            BuyerOrder build = new BuyerOrder(code);
            build.setBlackboard(blackboard);
            return build;
        }

        /**
         * 创建对象，用于插入数据库，此对象必须使用create方法插入数据库
         */
        public BuyerOrder forCreate(BuyerOrderEntity entity, BuyerOrderAttachedEntity attachedEntity) {
            logger.info(this + "#forCreate");
            BuyerOrder build = new BuyerOrder(entity, attachedEntity);
            build.setBlackboard(blackboard);
            return build;
        }

    }

    /**
     * 获取支付状态
     *
     * @return
     */
    public String getBuyerOrderPaySate() {
        String state = PaymentStu.NOT_PAYMENT.getCode();// 未支付
        BuyerOrderDao dao = getDao(BuyerOrderDao.class);
        BuyerOrderEntity entity = dao.findOne(this.entity);
        if (entity != null) {
            BigDecimal receiveAmount = entity.getReceiveAmount();// 已付金额
            BigDecimal orderAmount = entity.getOrderAmount();// 订单金额；
            BigDecimal earnestAmount = entity.getEarnestAmount();// 定金应付金额
            BigDecimal advancePaymentAmount = entity.getAdvancePaymentAmount();// 应预付金额
            if (DecimalUtils.le(orderAmount, receiveAmount)) {// 订单金额 <=已付金额
                state = PaymentStu.ALL_PAYMENT.getCode();// 全部支付
            } else if (DecimalUtils.le(earnestAmount, receiveAmount)
                    || DecimalUtils.le(advancePaymentAmount, receiveAmount)) {// 已付金额>=定金应付金额 或是 已付金额 >=应预付金额
                state = PaymentStu.PART_PAYMENT.getCode();// 部分支付
            }
        }
        return state;
    }

    /**
     * 生成买家订单编码
     *
     * @return
     */
    public String createBuyerOrderCode() {
        // 单据特征码未定
        String featureCode = "";
        // 买家编码主码
        String buyerCode = attachedEntity.getBuyerCode();

        // 订单编码 = 单据特征码（0） + 买家编码主码（16） + 下单次数自然顺序号（8）
        String buyerOrderCode = NumberGenerateManager.sequences(featureCode + buyerCode, 8);

        return buyerOrderCode;
    }

    /**
     * 判断订单是否在配送中
     *
     * @return
     */
    public boolean isOnDistribute() {
        Assert.isTrue(isDataSynced(), "Please complete before check is on distribute.");
        // 配送通知单列表
        List<DistributionNotification> distributionNotifications = this.getDistributionNotifications();

        // 如果不存在配送通知单，则 订单不在配送中
        if (distributionNotifications == null)
            return false;

        // 如果存在配送通知单，并且配送通知单的状态不是取消，则订单在配送中
        for (DistributionNotification distributionNotification : distributionNotifications) {
            String stu = distributionNotification.getEntity().getDistributionNotificationStu();
            if (!DistributionNotificationStu.CANCEL.getCode().equals(stu) ) {
                return true;
            }
        }

        return false;
    }

    /**
     * 更新所有商品的价格信息
     */
    public void updateGoodsPrice() {
        List<BuyerBatchOrderDetail> details = this.getBuyerBatchOrderDetails();
        if (null != details && details.size() > 0) {
            BuyerBatchOrderDetailList detailList = BuyerBatchOrderDetailList.build(getBlackboard())
                    .forCreate(details.toArray(new BuyerBatchOrderDetail[details.size()]));
            String lgcsAreaCode = this.getAttachedEntity().getLogisticsZoneCode();

            // 按照商品集计商品数量
            Map<String, PriceRestParam> goodsQtyMap = new HashMap<>();
            ArrayList<PriceRestParam> paramList = new ArrayList<>();
            for (BuyerBatchOrderDetail detail : detailList.getArchives()) {
                if (goodsQtyMap.containsKey(detail.getEntity().getGoodsId())) {
                    PriceRestParam param = goodsQtyMap.get(detail.getEntity().getGoodsId());
                    // 下单数量-取消数量
                    BigDecimal goodsQty = DecimalUtils.subtract(detail.getEntity().getGoodsQuantity(),
                            detail.getEntity().getCancelQuantity());
                    BigDecimal qty = DecimalUtils.add(param.getQty(), goodsQty);
                    param.setQty(qty);
                } else {
                    PriceRestParam param = new PriceRestParam();
                    // 区域
                    param.setLgcsAreaCode(lgcsAreaCode);
                    // 商品ID
                    param.setGoodId(detail.getEntity().getGoodsId());
                    // 用户类型
                    Boolean netBuyerFlg = this.entity.getNetBuyerFlg();
                    if (netBuyerFlg != null && netBuyerFlg) {
                        param.setUserType(PriceUserType.PERIOD_USER.getCode());
                    } else {
                        param.setUserType(PriceUserType.STANDARD_USER.getCode());
                    }
                    // 买家等级
                    if (StringUtils.isEmpty(this.entity.getFrequenterLevelCode())){
                        param.setBuyerLevel(PriceBuyerLevel.LEVEL_STANDARD.getCode());
                    } else {
                        param.setBuyerLevel(this.entity.getFrequenterLevelCode());
                    }

                    // 比较查询时间
                    param.setCompareTimeOne(detail.getEntity().getPriceCreateTime());
                    // 下单数量-取消数量
                    BigDecimal goodsQty = DecimalUtils.subtract(detail.getEntity().getGoodsQuantity(),
                            detail.getEntity().getCancelQuantity());
                    // 数量
                    param.setQty(goodsQty);
                    // 返回类型
                    param.setReturnType(PriceReturnType.ALL_PRICE.getCode());
                    goodsQtyMap.put(detail.getEntity().getGoodsId(), param);
                    paramList.add(param);
                }
            }

            List<PriceEntity> priceList = Price.queryPricePlate(paramList);
            Map<String, PriceEntity> goodsPriceMap = new HashMap<>();
            if (null != priceList && priceList.size() > 0) {
                for (PriceEntity priceEntity : priceList) {
                    goodsPriceMap.put(priceEntity.getGoodId(), priceEntity);
                }
            }

            for (BuyerBatchOrderDetail detail : detailList.getArchives()) {

                if (goodsPriceMap.get(detail.getEntity().getGoodsId()) == null) {
                    throw new BusinessException(ModuleCode.ORDR, ErrorCode.E010107, detail.getEntity().getGoodsId());
                }
                BigDecimal unitPrice = goodsPriceMap.get(detail.getEntity().getGoodsId()).getUnitPrice();
                if (unitPrice != null) {
                    detail.getEntity().setOrderCreateUnitPrice(unitPrice);// 箱
                    detail.getEntity().setRealUnitPrice(unitPrice);
                }
                BigDecimal kgPrice = goodsPriceMap.get(detail.getEntity().getGoodsId()).getPrice();
                if (kgPrice != null) {
                    detail.getEntity().setOrderCreateKgPrice(kgPrice);// KG
                    detail.getEntity().setRealKgPrice(kgPrice);
                }
                String priceWay = goodsPriceMap.get(detail.getEntity().getGoodsId()).getWayDesc();
                if (priceWay != null) {
                    detail.getEntity().setPriceWay(priceWay);
                }
            }
        }
    }

    /**
     * 计算订单金额（分批订单的订单金额的集计）
     *
     * @return
     */
    public BigDecimal calculateOrderAmount() {
        BigDecimal orderAmount = new BigDecimal(0);
        List<BuyerBatchOrder> batchOrderList = this.getBuyerBatchOrders();
        if (null != batchOrderList && batchOrderList.size() > 0) {
            for (BuyerBatchOrder batchOrder : batchOrderList) {
                if (!BuyerBatchOrderStu.CANCEL.getCode().equals(batchOrder.getEntity().getBuyerBatchOrderStu())){
                    BigDecimal batchOrderAmount = batchOrder.calculateOrderAmount();
                    orderAmount = DecimalUtils.add(orderAmount, batchOrderAmount);
                }
            }
        }
        return orderAmount;
    }

    /**
     * 合计分批订单明细信息
     */
    public List<BuyerBatchOrderDetailSummary> summaryBuyerBatchOrderDetails() {
        List<BuyerBatchOrderDetailSummary> detailSummaries = new ArrayList<>();
        Map<String, BuyerBatchOrderDetailSummary> detailMap = new HashMap<String, BuyerBatchOrderDetailSummary>();
        List<BuyerBatchOrderDetail> details = this.getBuyerBatchOrderDetails();
        for (BuyerBatchOrderDetail detail : details) {
            String goodsId = detail.getEntity().getGoodsId();
            BigDecimal orderCreateUnitPrice = detail.getEntity().getOrderCreateUnitPrice();
            BigDecimal orderCreateKgPrice = detail.getEntity().getOrderCreateKgPrice();
            BigDecimal realUnitPrice = detail.getEntity().getRealUnitPrice();
            BigDecimal realKgPrice = detail.getEntity().getRealKgPrice();
            Date priceCreateTime = detail.getEntity().getPriceCreateTime();
            String priceWay = detail.getEntity().getPriceWay();
            BigDecimal cancelQuantity = detail.getEntity().getCancelQuantity();
            BigDecimal goodsQuantity = detail.getEntity().getGoodsQuantity();
            String goodsUnit = detail.getEntity().getGoodsUnit();
            BuyerBatchOrderDetailSummary detailSummary = detailMap.get(goodsId);
            if (null != detailSummary) {
                detailSummary.setCancelQuantity(DecimalUtils.add(detailSummary.getCancelQuantity(), cancelQuantity));
                detailSummary.setGoodsQuantity(DecimalUtils.add(detailSummary.getGoodsQuantity(), goodsQuantity));
            } else {
                detailSummary = new BuyerBatchOrderDetailSummary();
                detailSummary.setGoodsId(goodsId);
                detailSummary.setOrderCreateUnitPrice(orderCreateUnitPrice);
                detailSummary.setOrderCreateKgPrice(orderCreateKgPrice);
                detailSummary.setRealUnitPrice(realUnitPrice);
                detailSummary.setRealKgPrice(realKgPrice);
                detailSummary.setPriceCreateTime(priceCreateTime);
                detailSummary.setPriceWay(priceWay);
                detailSummary.setCancelQuantity(cancelQuantity);
                detailSummary.setGoodsQuantity(goodsQuantity);
                detailSummary.setGoodsUnit(goodsUnit);
                detailMap.put(goodsId, detailSummary);
            }
        }
        for (Map.Entry<String, BuyerBatchOrderDetailSummary> entry : detailMap.entrySet()) {
            detailSummaries.add(entry.getValue());
        }
        return detailSummaries;
    }

    @Override
    public void generateCode() {
        String buyerCode = attachedEntity.getBuyerCode();
        entity.setBuyerOrderCode(CodeRule.orderRule("MJDD", buyerCode));
    }

    public BuyerSellerDetail generateBuyerSellerDetail(){
        BuyerSellerDetailEntity entity = new BuyerSellerDetailEntity();
        BuyerSellerDetail buyerSellerDetail= BuyerSellerDetail.build(null).forCreate(entity);
        return buyerSellerDetail;
    }

}