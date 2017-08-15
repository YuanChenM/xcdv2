package com.bms.order.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ch.qos.logback.core.joran.spi.ElementSelector;
import com.bms.order.bean.entity.BuyerOrderAttachedEntity;
import com.bms.order.bean.entity.BuyerOrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bms.order.archive.impl.BuyerBatchOrder;
import com.bms.order.archive.impl.BuyerBatchOrderDetail;
import com.bms.order.archive.impl.BuyerForcastDeliverDetail;
import com.bms.order.archive.impl.BuyerOrder;
import com.bms.order.archive.impl.Operator;
import com.bms.order.archive.impl.list.BuyerBatchOrderDetailList;
import com.bms.order.archive.impl.list.BuyerBatchOrderList;
import com.bms.order.archive.impl.list.BuyerForcastDeliverDetailList;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.BuyerBatchOrderDetailSummary;
import com.bms.order.bean.param.ORDR0102IBean;
import com.bms.order.constant.enumeration.BuyerBatchOrderStu;
import com.bms.order.constant.enumeration.BuyerOrderStu;
import com.bms.order.constant.enumeration.GoodsUnit;
import com.bms.order.constant.enumeration.OperatorType;
//import com.bms.order.constant.enumeration.TargetType;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.BuyerBatchOrderAttachedDao;
import com.bms.order.dao.BuyerBatchOrderDao;
import com.bms.order.dao.BuyerBatchOrderDetailAttachedDao;
import com.bms.order.dao.BuyerBatchOrderDetailDao;
import com.bms.order.dao.BuyerForcastDeliverDetailAttachedDao;
import com.bms.order.dao.BuyerForcastDeliverDetailDao;
import com.bms.order.dao.BuyerOrderAttachedDao;
import com.bms.order.dao.BuyerOrderDao;
import com.bms.order.dao.DistributionNotificationDao;
import com.bms.order.external.archive.Buyer;
import com.bms.order.external.archive.Goods;
import com.bms.order.external.archive.Stock;
import com.bms.order.external.bean.param.StockRestParam;
import com.bms.order.services.ORDR0102IService;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.DecimalUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;

/**
 * 买家订单修改接口Service
 *
 * @author li_huiqian
 */
@Service
public class ORDR0102IServiceImpl implements ORDR0102IService {
    @Autowired
    private BaseRedisDao redisDao;
    @Autowired
    private BuyerOrderDao buyerOrderDao;
    @Autowired
    private BuyerOrderAttachedDao buyerOrderAttachedDao;
    @Autowired
    private BuyerBatchOrderDetailDao buyerBatchOrderDetailDao;
    @Autowired
    private BuyerBatchOrderDao buyerBatchOrderDao;
    @Autowired
    private BuyerBatchOrderAttachedDao buyerBatchOrderAttachedDao;
    @Autowired
    private BuyerBatchOrderDetailAttachedDao buyerBatchOrderDetailAttachedDao;
    @Autowired
    private DistributionNotificationDao distributionNotificationDao;
    @Autowired
    private BuyerForcastDeliverDetailDao buyerForcastDeliverDetailDao;

    @Autowired
    private BuyerForcastDeliverDetailAttachedDao buyerForcastDeliverDetailAttachedDao;

    /**
     * 订单配送通知单发送给美迪福之前，对订单基本信息进行修改
     *
     * @param operator
     *            操作者
     * @param bean
     *            ORDR0102IRestParam
     */
    @Transactional
    @Override
    public void execute(Operator operator, ORDR0102IBean bean, int step) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();
        blackboard.setOperator(operator);
        map.put("bean", bean);
        map.put("blackboard", blackboard);

        pre(map);
        if (step == 1) {
            processStep1(map);
        } else if (step == 2) {
            processStep2(map);
        }
        post(map);
    }

    /**
     * 准备
     *
     * @param map
     *            HashMap
     */
    private void pre(HashMap<String, Object> map) {
        // 获取参数
        ORDR0102IBean param = (ORDR0102IBean) map.get("bean");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 设置DAO
        blackboard.putBaseDao(buyerOrderDao);
        blackboard.putBaseDao(buyerOrderAttachedDao);
        blackboard.putBaseDao(buyerBatchOrderDetailDao);
        blackboard.putBaseDao(buyerBatchOrderDao);
        blackboard.putBaseDao(buyerBatchOrderAttachedDao);
        blackboard.putBaseDao(buyerBatchOrderDetailAttachedDao);
        blackboard.putBaseDao(distributionNotificationDao);
        blackboard.putBaseDao(buyerForcastDeliverDetailDao);
        blackboard.putBaseDao(buyerForcastDeliverDetailAttachedDao);
        blackboard.setBaseRedisDao(redisDao);

        // 操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);

        // 获取完整操作者
        operator.complete(false);

        // 获取订单
        BuyerOrder buyerOrder = null;
        if (null != param.getBuyerOrderId()) {// 订单id不为空时，用id查询
            buyerOrder = new BuyerOrder(param.getBuyerOrderId());
        } else if (!StringUtils.isEmpty(param.getBackNo()) && null == param.getBuyerOrderId()) {// 用参考号查询，则id必须为空
            BuyerOrderEntity buyerOrderEntity = new BuyerOrderEntity();
            BuyerOrderAttachedEntity attachedEntity = new BuyerOrderAttachedEntity();
            buyerOrderEntity.setBackNo(param.getBackNo());
            buyerOrder = new BuyerOrder(buyerOrderEntity,attachedEntity);
        }else {// 订单id与参考同时为空，报错
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000002, "订单id，订单：参考号不能同时为空");
        }
            buyerOrder.setBlackboard(blackboard);
            // 验证买家订单
            buyerOrderCheck(buyerOrder);
            // 获取修改后的订单
            BuyerOrder modifiedBuyerOrder = param.modifiedBuyerOrder();
            modifiedBuyerOrder.setBlackboard(blackboard);
            modifiedBuyerOrderCheck(modifiedBuyerOrder);
            // 获取买家信息
            Buyer buyer = Buyer.findById(buyerOrder.getEntity().getBuyerId());
            if (buyer == null) {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E010106, buyerOrder.getEntity().getBuyerId());
            }
            // 是否可以使用账期的验证
            if (modifiedBuyerOrder.getEntity().getUseNetFlg() != null)
                checkNetUse(modifiedBuyerOrder, buyer);
            // 数据权限验证
            dataAuthorityCheck(operator, buyerOrder);
            map.put("buyerOrder", buyerOrder);
            map.put("modifiedBuyerOrder", modifiedBuyerOrder);
    }

    /**
     * 买家订单验证
     * 
     * @param buyerOrder
     */
    private void buyerOrderCheck(BuyerOrder buyerOrder) {
        buyerOrder.complete(false);

        // 买家订单存在性check
        if (!buyerOrder.isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E010202);

        // 买家订单完整性check，不通过则说明有脏数据
        List<BuyerBatchOrder> buyerBatchOrders = buyerOrder.getBuyerBatchOrders();
        if (buyerBatchOrders == null || buyerBatchOrders.size() == 0)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000002, "买家订单没有分批订单");
        List<BuyerBatchOrderDetail> buyerBatchOrderDetails = buyerOrder.getBuyerBatchOrderDetails();
        if (buyerBatchOrderDetails == null || buyerBatchOrderDetails.size() == 0)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000002, "买家订单没有分批订单明细");
        if (null != buyerBatchOrders && buyerBatchOrders.size() > 0) {
            for (BuyerBatchOrder buyerBatchOrder : buyerBatchOrders) {
                buyerBatchOrder.link(buyerBatchOrderDetails);
                buyerBatchOrder.buyerBatchOrderDetailsLinked();
            }
        }
        List<BuyerBatchOrderDetail> linkedDetails = new ArrayList<>();
        for (BuyerBatchOrder buyerBatchOrder : buyerBatchOrders) {
            linkedDetails.addAll(buyerBatchOrder.getBuyerBatchOrderDetails());
        }
        if (buyerBatchOrderDetails.size() != linkedDetails.size())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000002, "存在分批订单明细，没有对应的分批订单");

        // 验证买家订单是否在配送中
        if (buyerOrder.isOnDistribute()) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E010203);
        }
    }

    /**
     * 修改后的买家订单check
     * 
     * @param modifiedBuyerOrder
     */
    private void modifiedBuyerOrderCheck(BuyerOrder modifiedBuyerOrder) {
        // 分批订单版本号验证
        if(null != modifiedBuyerOrder.getEntity().getBuyerOrderId()){
        BuyerOrder buyerOrder = BuyerOrder.build(modifiedBuyerOrder.getBlackboard())
                .forComplete(modifiedBuyerOrder.getEntity().getBuyerOrderId());
        buyerOrder.complete(false);
        if (!buyerOrder.getEntity().getVersion().equals(modifiedBuyerOrder.getEntity().getVersion()))
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000007);
        }else if(!StringUtils.isEmpty(modifiedBuyerOrder.getEntity().getBackNo()) && null == modifiedBuyerOrder.getEntity().getBuyerOrderId()){
            BuyerOrderEntity entity = new BuyerOrderEntity();
            BuyerOrderAttachedEntity attachedEntity = new BuyerOrderAttachedEntity();
            entity.setBackNo(modifiedBuyerOrder.getEntity().getBackNo());
            BuyerOrder buyerOrder = BuyerOrder.build(modifiedBuyerOrder.getBlackboard())
                    .forCreate(entity,attachedEntity);
            buyerOrder.complete(false);
            if (!buyerOrder.getEntity().getVersion().equals(modifiedBuyerOrder.getEntity().getVersion()))
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000007);
        }


        // 分批订单存在性及版本号验证
        List<BuyerBatchOrder> buyerBatchOrders = modifiedBuyerOrder.getBuyerBatchOrders();
        Map<Long, BuyerBatchOrder> buyerBatchOrderMap = new HashMap<>();
        if (buyerBatchOrders != null && buyerBatchOrders.size() > 0) {
            for (BuyerBatchOrder buyerBatchOrder : buyerBatchOrders) {
                if (buyerBatchOrder.getEntity().getBuyerBatchOrderId() != null)
                    buyerBatchOrderMap.put(buyerBatchOrder.getEntity().getBuyerBatchOrderId(), buyerBatchOrder);
            }
            if (buyerBatchOrderMap.size() > 0) {
                BuyerBatchOrderList list = BuyerBatchOrderList.build(modifiedBuyerOrder.getBlackboard())
                        .forComplete(buyerBatchOrderMap.keySet().toArray(new Long[0]));
                list.complete(false);
                if (list.getArchives().size() != buyerBatchOrderMap.size())
                    throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000002, "传入的分批订单在数据库中不存在");
                for (BuyerBatchOrder searchedBatchOrder : list.getArchives()) {
                    BuyerBatchOrder batchOrder = buyerBatchOrderMap
                            .get(searchedBatchOrder.getEntity().getBuyerBatchOrderId());
                    if (!searchedBatchOrder.getEntity().getVersion().equals(batchOrder.getEntity().getVersion()))
                        throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000007);
                }
            }
        }

        // 分批订单明细数据的存在性、商品ID、版本号验证
        List<BuyerBatchOrderDetail> buyerBatchOrderDetails = modifiedBuyerOrder.getBuyerBatchOrderDetails();
        Map<Long, BuyerBatchOrderDetail> buyerBatchOrderDetailMap = new HashMap<>();
        if (buyerBatchOrderDetails != null && buyerBatchOrderDetails.size() > 0) {
            for (BuyerBatchOrderDetail detail : buyerBatchOrderDetails) {
                if (detail.getEntity().getBuyerBatchOrderDetailId() != null) {
                    buyerBatchOrderDetailMap.put(detail.getEntity().getBuyerBatchOrderDetailId(), detail);
                }
            }
            if (buyerBatchOrderDetailMap.size() > 0) {
                BuyerBatchOrderDetailList list = BuyerBatchOrderDetailList.build(modifiedBuyerOrder.getBlackboard())
                        .forComplete(buyerBatchOrderDetailMap.keySet().toArray(new Long[0]));
                list.complete(false);
                if (list.getArchives().size() != buyerBatchOrderDetailMap.size())
                    throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000002, "传入的分批订单明细在数据库中不存在");
                for (BuyerBatchOrderDetail searchedDetail : list.getArchives()) {
                    BuyerBatchOrderDetail detail = buyerBatchOrderDetailMap
                            .get(searchedDetail.getEntity().getBuyerBatchOrderDetailId());
                    if (!searchedDetail.getEntity().getVersion().equals(detail.getEntity().getVersion()))
                        throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000007);
                    if (detail.getEntity().getGoodsId() != null
                            && !searchedDetail.getEntity().getGoodsId().equals(detail.getEntity().getGoodsId()))
                        throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000002, "传入的分批订单明细与商品ID不对应");
                }
            }
        }
    }

    /**
     * 数据权限验证
     *
     * @param buyerOrder
     * @param operator
     */
    private void dataAuthorityCheck(Operator operator, BuyerOrder buyerOrder) {
        OperatorType operatorType = OperatorType.getInstance(operator.getOperatorType());
        switch (operatorType) {
        case BS:
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000001, operatorType.getName());
        case BUYER:
            if (!operator.getOperatorId().equals(buyerOrder.getEntity().getBuyerId())) {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E010204);
            }
            break;
        case SA:
            if (!operator.getOperatorId().equals(buyerOrder.getAttachedEntity().getSaId())) {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E010204);
            }
            break;
        case MANAGER:
            break;
        default:
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000001, operatorType.getName());
        }
    }

    /**
     * 执行步骤1，删除预配送明细
     * 
     * @param map
     */
    private void processStep1(HashMap<String, Object> map) {
        BuyerOrder buyerOrder = (BuyerOrder) map.get("buyerOrder");
        BuyerOrder modifiedBuyerOrder = (BuyerOrder) map.get("modifiedBuyerOrder");
        Blackboard blackboard = (Blackboard) map.get("blackboard");

        // 1. 判断是否修改到分批订单明细，如果没有修改到分批订单明细，或者分批订单明细没有变化，则不删除预配送明细
        List<BuyerBatchOrderDetail> buyerBatchOrderDetails = buyerOrder.getBuyerBatchOrderDetails();
        List<BuyerBatchOrderDetail> modifiedBuyerBatchOrderDetails = modifiedBuyerOrder.getBuyerBatchOrderDetails();
        if (!isBuyerBatchOrderDetailModified(buyerBatchOrderDetails, modifiedBuyerBatchOrderDetails))
            return;

        // 2. 获取预配送明细列表
        List<BuyerForcastDeliverDetail> buyerForcastDeliverDetails = summaryBuyerForcastDeliverDetails(buyerOrder);

        if (buyerForcastDeliverDetails != null && buyerForcastDeliverDetails.size() != 0) {
            // 3. 删除预配送明细
            removeBuyerForcastDeliverDetails(buyerForcastDeliverDetails, blackboard);

            // 4. 改变分批明细状态
            for (BuyerBatchOrderDetail buyerBatchOrderDetail : buyerBatchOrderDetails) {
                buyerBatchOrderDetail.getEntity().setSplitFlg(false);
            }

            // 5. 改变分批状态
            List<BuyerBatchOrder> buyerBatchOrders = buyerOrder.getBuyerBatchOrders();
            for (BuyerBatchOrder buyerBatchOrder : buyerBatchOrders) {
                buyerBatchOrder.getEntity().setBuyerBatchOrderStu(BuyerBatchOrderStu.SPLIT_CONFIRM.getCode());
            }

            // 6. 取消库存占用
            List<StockRestParam> params = new ArrayList<>();
            for (BuyerForcastDeliverDetail buyerForcastDeliverDetail : buyerForcastDeliverDetails) {
                StockRestParam param = new StockRestParam();
                params.add(param);
                param.setTransactionId(buyerOrder.getEntity().getBuyerOrderId());
                param.setTransactionNo(buyerOrder.getEntity().getBuyerOrderCode());
                param.setTransactionDetailId(buyerForcastDeliverDetail.getEntity().getBuyerForcastDeliverDetailId());
                param.setTransactionSequence(null);
                param.setCancelQty(buyerForcastDeliverDetail.getEntity().getPlanSendQuantity());
                param.setAlocType(Stock.ALOC_TYPE_NORMAL);
            }
            Stock.ReleaseAllocation(params);
        }
    }

    /**
     * 买家分批订单明细是否修改
     * 
     * @param buyerBatchOrderDetails
     * @param modifiedBuyerBatchOrderDetails
     * @return
     */
    private boolean isBuyerBatchOrderDetailModified(List<BuyerBatchOrderDetail> buyerBatchOrderDetails,
            List<BuyerBatchOrderDetail> modifiedBuyerBatchOrderDetails) {
        // 没有传入分批订单明细
        if (modifiedBuyerBatchOrderDetails == null || modifiedBuyerBatchOrderDetails.size() == 0)
            return false;

        // 没有修改分批订单明细
        boolean modified = false;
        if (buyerBatchOrderDetails.size() != modifiedBuyerBatchOrderDetails.size())
            modified = true;
        if (!modified) {
            for (BuyerBatchOrderDetail buyerBatchOrderDetail : buyerBatchOrderDetails) {
                BuyerBatchOrderDetail find = null;
                for (BuyerBatchOrderDetail modifiedBuyerBatchOrderDetail : modifiedBuyerBatchOrderDetails) {
                    if (buyerBatchOrderDetail.getEntity().getBuyerBatchOrderDetailId()
                            .equals(modifiedBuyerBatchOrderDetail.getEntity().getBuyerBatchOrderDetailId())) {
                        find = modifiedBuyerBatchOrderDetail;
                        break;
                    }
                }
                if (find == null)
                    modified = true;
                else if (find.getEntity().getGoodsQuantity() != null && !DecimalUtils
                        .eq(buyerBatchOrderDetail.getEntity().getGoodsQuantity(), find.getEntity().getGoodsQuantity()))
                    modified = true;
            }
        }
        return modified;
    }

    /**
     * 执行步骤2，修改订单
     *
     * @param map
     *            HashMap
     */
    private void processStep2(HashMap<String, Object> map) {
        // 获取参数
        // 获取订单
        BuyerOrder buyerOrder = (BuyerOrder) map.get("buyerOrder");
        // 获取修改后的订单
        BuyerOrder modifiedBuyerOrder = (BuyerOrder) map.get("modifiedBuyerOrder");
        Blackboard blackboard = (Blackboard) map.get("blackboard");

        // 修改订单数据
        modifyBuyerOrder(buyerOrder, modifiedBuyerOrder);
        if (null != modifiedBuyerOrder.getBuyerBatchOrders() && modifiedBuyerOrder.getBuyerBatchOrders().size() > 0) {
            // 修改分批订单数据
            modifyBuyerBatchOrders(buyerOrder, modifiedBuyerOrder, blackboard);
            if (null != modifiedBuyerOrder.getBuyerBatchOrderDetails()
                    && modifiedBuyerOrder.getBuyerBatchOrderDetails().size() > 0 && isBuyerBatchOrderDetailModified(
                            buyerOrder.getBuyerBatchOrderDetails(), modifiedBuyerOrder.getBuyerBatchOrderDetails())) {
                // 修改分批订单明细数据
                ArrayList<StockRestParam> stockRestParams = modifyBuyerBatchOrderDetails(buyerOrder, modifiedBuyerOrder,
                        blackboard);

                // 查询修改后的订单
                BuyerOrder newBuyerOrder = BuyerOrder.build(buyerOrder.getBlackboard())
                        .forComplete(buyerOrder.getEntity().getBuyerOrderId());
                newBuyerOrder.complete(false);
                // 将分批订单和分批订单明细关联
                List<BuyerBatchOrder> newBuyerBatchOrders = newBuyerOrder.getBuyerBatchOrders();
                List<BuyerBatchOrderDetail> newBuyerBatchOrderDetails = newBuyerOrder.getBuyerBatchOrderDetails();
                for (BuyerBatchOrder newBuyerBatchOrder : newBuyerBatchOrders) {
                    newBuyerBatchOrder.link(newBuyerBatchOrderDetails);
                    newBuyerBatchOrder.buyerBatchOrderDetailsLinked();
                }

                // 统计原始商品及其数量
                List<BuyerBatchOrderDetailSummary> oldSummaries = buyerOrder.summaryBuyerBatchOrderDetails();
                // 更新修改后订单中商品的单价
                updatePriceCreateTime(newBuyerOrder, oldSummaries);
                newBuyerOrder.updateGoodsPrice();

                // 更新分批订单中的订单金额（合计）
                List<BuyerBatchOrder> batchOrders = newBuyerOrder.getBuyerBatchOrders();
                for (BuyerBatchOrder batchOrder : batchOrders) {
                    BigDecimal orderAmount = batchOrder.calculateOrderAmount();
                    batchOrder.getEntity().setOrderAmount(orderAmount);
                }
                BuyerBatchOrderList buyerBatchOrderList = BuyerBatchOrderList.build(blackboard)
                        .forUpdate(batchOrders.toArray(new BuyerBatchOrder[batchOrders.size()]));
                buyerBatchOrderList.modify();
                // 更新订单中的订单金额（合计）
                BigDecimal orderAmout = newBuyerOrder.calculateOrderAmount();
                newBuyerOrder.getEntity().setOrderAmount(orderAmout);

                modifyBuyerOrder(newBuyerOrder);

                // 重新占用库存
                Stock.AllocateCommInv(stockRestParams);
            }

        }
    }

    /**
     * 获取订单的所有分拆单明细
     *
     * @param buyerOrder
     * @return
     */
    private List<BuyerForcastDeliverDetail> summaryBuyerForcastDeliverDetails(BuyerOrder buyerOrder) {
        List<BuyerForcastDeliverDetail> deliverDetails = new ArrayList<BuyerForcastDeliverDetail>();
        List<BuyerBatchOrderDetail> detailList = buyerOrder.getBuyerBatchOrderDetails();
        if (null != detailList && detailList.size() > 0) {
            for (BuyerBatchOrderDetail detail : detailList) {
                if (null != detail.getBuyerForcastDeliverDetails()
                        && detail.getBuyerForcastDeliverDetails().size() > 0) {
                    deliverDetails.addAll(detail.getBuyerForcastDeliverDetails());
                }
            }
        }
        return deliverDetails;
    }

    /**
     * 修改订单数据
     *
     * @param buyerOrder
     * @param modifiedBuyerOrder
     */
    private void modifyBuyerOrder(BuyerOrder buyerOrder, BuyerOrder modifiedBuyerOrder) {
        // 订单状态【确认中】才能修改的项目：是否开具发票、是否使用账期、定金应付金额、 预付应付金额
        Boolean modifiedInvoiceFlg = modifiedBuyerOrder.getEntity().getInvoiceFlg();
        Boolean modifiedUseNetFlg = modifiedBuyerOrder.getEntity().getUseNetFlg();
        BigDecimal modifiedEarnestAmount = modifiedBuyerOrder.getEntity().getEarnestAmount();
        BigDecimal modifiedAdvancePaymentAmount = modifiedBuyerOrder.getEntity().getAdvancePaymentAmount();
        if (BuyerOrderStu.IN_CONFIRMATION.getCode().equals(buyerOrder.getEntity().getBuyerOrderStu())) {
            // 如果订单状态是确认中，修改上述项目
            if (modifiedInvoiceFlg != null)
                buyerOrder.getEntity().setInvoiceFlg(modifiedInvoiceFlg);
            if (modifiedUseNetFlg != null) {
                buyerOrder.getEntity().setUseNetFlg(modifiedUseNetFlg);
            }
            if (modifiedEarnestAmount != null)
                buyerOrder.getEntity().setEarnestAmount(modifiedEarnestAmount);
            if (modifiedAdvancePaymentAmount != null)
                buyerOrder.getEntity().setAdvancePaymentAmount(modifiedAdvancePaymentAmount);
        } else if (modifiedInvoiceFlg != null || modifiedUseNetFlg != null || modifiedEarnestAmount != null
                || modifiedAdvancePaymentAmount != null) {
            // 如果订单状态不是确认中，并且上述项目被修改，报错
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E010201);
        }

        // 修改运费金额、优惠金额、买家联系电话、买家微信号、买家QQ、买家邮箱
        BigDecimal freight = modifiedBuyerOrder.getEntity().getFreight();
        BigDecimal modifiedPreferentialAmount = modifiedBuyerOrder.getEntity().getPreferentialAmount();
        if (freight != null)
            buyerOrder.getEntity().setFreight(freight);
        if (modifiedPreferentialAmount != null)
            buyerOrder.getEntity().setPreferentialAmount(modifiedPreferentialAmount);
        String modifiedBuyerPhone = modifiedBuyerOrder.getAttachedEntity().getBuyerPhone();
        if (modifiedBuyerPhone != null)
            buyerOrder.getAttachedEntity().setBuyerPhone(modifiedBuyerPhone);
        String modifiedBuyerWechat = modifiedBuyerOrder.getAttachedEntity().getBuyerWechat();
        if (modifiedBuyerWechat != null)
            buyerOrder.getAttachedEntity().setBuyerWechat(modifiedBuyerWechat);
        String modifiedBuyerQq = modifiedBuyerOrder.getAttachedEntity().getBuyerQq();
        if (modifiedBuyerQq != null)
            buyerOrder.getAttachedEntity().setBuyerQq(modifiedBuyerQq);
        String modifiedBuyerMail = modifiedBuyerOrder.getAttachedEntity().getBuyerMail();
        if (modifiedBuyerMail != null)
            buyerOrder.getAttachedEntity().setBuyerMail(modifiedBuyerMail);

        // 将买家订单数据的修改反应到数据库
        buyerOrder.modify();
    }

    /**
     * 修改买家分批订单数据
     *
     * @param buyerOrder
     * @param modifiedBuyerOrder
     */
    private void modifyBuyerBatchOrders(BuyerOrder buyerOrder, BuyerOrder modifiedBuyerOrder, Blackboard blackboard) {
        // 获取修改前的分批订单列表
        List<BuyerBatchOrder> buyerBatchOrders = buyerOrder.getBuyerBatchOrders();
        // 获取修改后的分批订单列表
        modifiedBuyerOrder.getEntity().setBuyerOrderCode(buyerOrder.getEntity().getBuyerOrderCode()); // #bug 1973
                                                                                                      // 将查询到的买家订单编码赋值到此对象中，用于此对象关联的分批订单编码的创建
        List<BuyerBatchOrder> modifiedBuyerBatchOrders = modifiedBuyerOrder.getBuyerBatchOrders();

        // 移除分批订单数据
        removeBuyerBatchOrders(buyerBatchOrders, modifiedBuyerBatchOrders, blackboard);

        // 更新分批订单数据
        updateBuyerBatchOrders(buyerBatchOrders, modifiedBuyerBatchOrders, blackboard);

        // 新增分批订单数据
        addBuyerBatchOrders(buyerOrder, buyerBatchOrders, modifiedBuyerBatchOrders, blackboard);
    }

    /**
     * 移除分批订单数据
     *
     * @param buyerBatchOrders
     * @param modifiedBuyerBatchOrders
     */
    private void removeBuyerBatchOrders(List<BuyerBatchOrder> buyerBatchOrders,
            List<BuyerBatchOrder> modifiedBuyerBatchOrders, Blackboard blackboard) {
        List<BuyerBatchOrderDetail> detailDelList = new ArrayList<BuyerBatchOrderDetail>();
        List<BuyerBatchOrder> batchDelList = new ArrayList<BuyerBatchOrder>();
        if (null != buyerBatchOrders && buyerBatchOrders.size() > 0 && null != modifiedBuyerBatchOrders
                && modifiedBuyerBatchOrders.size() > 0) {
            // 找出需要移除的分批订单
            for (BuyerBatchOrder batchOrderEntity : buyerBatchOrders) {
                Boolean isDel = true;
                for (BuyerBatchOrder batchOrder : modifiedBuyerBatchOrders) {
                    if (null != batchOrder.getEntity().getBuyerBatchOrderId() && batchOrder.getEntity()
                            .getBuyerBatchOrderId().equals(batchOrderEntity.getEntity().getBuyerBatchOrderId())) {
                        isDel = false;
                    }
                }
                if (isDel) {
                    batchDelList.add(batchOrderEntity);
                    if (null != batchOrderEntity.getBuyerBatchOrderDetails()
                            && batchOrderEntity.getBuyerBatchOrderDetails().size() > 0) {
                        detailDelList.addAll(batchOrderEntity.getBuyerBatchOrderDetails());
                    }
                }
            }
            // 批量移除找出的分批订单的分批订单明细
            if (null != detailDelList && detailDelList.size() > 0) {
                BuyerBatchOrderDetailList detailList = BuyerBatchOrderDetailList.build(blackboard)
                        .forUpdate(detailDelList.toArray(new BuyerBatchOrderDetail[detailDelList.size()]));
                detailList.delete();
            }
            // 批量移除找出的分批订单
            if (null != batchDelList && batchDelList.size() > 0) {
                BuyerBatchOrderList batchOrderList = BuyerBatchOrderList.build(blackboard)
                        .forUpdate(batchDelList.toArray(new BuyerBatchOrder[batchDelList.size()]));
                batchOrderList.delete();
            }
        }
    }

    /**
     * 更新分批订单数据
     *
     * @param buyerBatchOrders
     * @param modifiedBuyerBatchOrders
     */
    private void updateBuyerBatchOrders(List<BuyerBatchOrder> buyerBatchOrders,
            List<BuyerBatchOrder> modifiedBuyerBatchOrders, Blackboard blackboard) {
        // 找出需要更新的分批订单
        List<BuyerBatchOrder> batchUpdateList = new ArrayList<BuyerBatchOrder>();
        if (null != buyerBatchOrders && buyerBatchOrders.size() > 0 && null != modifiedBuyerBatchOrders
                && modifiedBuyerBatchOrders.size() > 0) {
            // 找出需要移除的分批订单
            for (BuyerBatchOrder batchOrderEntity : buyerBatchOrders) {
                Boolean isUpdate = false;
                for (BuyerBatchOrder batchOrder : modifiedBuyerBatchOrders) {
                    if (null != batchOrder.getEntity().getBuyerBatchOrderId() && batchOrder.getEntity()
                            .getBuyerBatchOrderId().equals(batchOrderEntity.getEntity().getBuyerBatchOrderId())) {
                        isUpdate = true;
                        if (null != batchOrder.getEntity().getRequiredDistributionDate()) {
                            batchOrderEntity.getEntity()
                                    .setRequiredDistributionDate(batchOrder.getEntity().getRequiredDistributionDate());
                        }
                        if (null != batchOrder.getEntity().getExpectedSendDatetime()) {
                            batchOrderEntity.getEntity()
                                    .setExpectedSendDatetime(batchOrder.getEntity().getExpectedSendDatetime());
                        }
                        if (null != batchOrder.getEntity().getExpectedArrivalDatetime()) {
                            batchOrderEntity.getEntity()
                                    .setExpectedArrivalDatetime(batchOrder.getEntity().getExpectedArrivalDatetime());
                        }
                        if (null != batchOrder.getEntity().getPreferentialAmount()) {
                            batchOrderEntity.getEntity()
                                    .setPreferentialAmount(batchOrder.getEntity().getPreferentialAmount());
                        }
                        if (StringUtils.isNotEmpty(batchOrder.getAttachedEntity().getReceiverName())) {
                            batchOrderEntity.getAttachedEntity()
                                    .setReceiverName(batchOrder.getAttachedEntity().getReceiverName());
                        }
                        if (StringUtils.isNotEmpty(batchOrder.getAttachedEntity().getReceiverPhone())) {
                            batchOrderEntity.getAttachedEntity()
                                    .setReceiverPhone(batchOrder.getAttachedEntity().getReceiverPhone());
                        }
                        if (StringUtils.isNotEmpty(batchOrder.getAttachedEntity().getReceiverQq())) {
                            batchOrderEntity.getAttachedEntity()
                                    .setReceiverQq(batchOrder.getAttachedEntity().getReceiverQq());
                        }
                        if (StringUtils.isNotEmpty(batchOrder.getAttachedEntity().getReceiverWechat())) {
                            batchOrderEntity.getAttachedEntity()
                                    .setReceiverWechat(batchOrder.getAttachedEntity().getReceiverWechat());
                        }
                        if (StringUtils.isNotEmpty(batchOrder.getAttachedEntity().getReceiverMail())) {
                            batchOrderEntity.getAttachedEntity()
                                    .setReceiverMail(batchOrder.getAttachedEntity().getReceiverMail());
                        }
                        if (StringUtils.isNotEmpty(batchOrder.getAttachedEntity().getReceiverProvince())) {
                            batchOrderEntity.getAttachedEntity()
                                    .setReceiverProvince(batchOrder.getAttachedEntity().getReceiverProvince());
                        }
                        if (StringUtils.isNotEmpty(batchOrder.getAttachedEntity().getReceiverCity())) {
                            batchOrderEntity.getAttachedEntity()
                                    .setReceiverCity(batchOrder.getAttachedEntity().getReceiverCity());
                        }
                        if (StringUtils.isNotEmpty(batchOrder.getAttachedEntity().getReceiverDistrict())) {
                            batchOrderEntity.getAttachedEntity()
                                    .setReceiverDistrict(batchOrder.getAttachedEntity().getReceiverDistrict());
                        }
                        if (StringUtils.isNotEmpty(batchOrder.getAttachedEntity().getReceiverAddress())) {
                            batchOrderEntity.getAttachedEntity()
                                    .setReceiverAddress(batchOrder.getAttachedEntity().getReceiverAddress());
                        }
                        if (StringUtils.isNotEmpty(batchOrder.getAttachedEntity().getReceiverAssistAddress())) {
                            batchOrderEntity.getAttachedEntity().setReceiverAssistAddress(
                                    batchOrder.getAttachedEntity().getReceiverAssistAddress());
                        }
                        if (StringUtils.isNotEmpty(batchOrder.getAttachedEntity().getDeliveryArea())) {
                            batchOrderEntity.getAttachedEntity()
                                    .setDeliveryArea(batchOrder.getAttachedEntity().getDeliveryArea());
                        }
                        if (StringUtils.isNotEmpty(batchOrder.getAttachedEntity().getPassTrafficModel())) {
                            batchOrderEntity.getAttachedEntity()
                                    .setPassTrafficModel(batchOrder.getAttachedEntity().getPassTrafficModel());
                        }
                        if (StringUtils.isNotEmpty(batchOrder.getAttachedEntity().getReceivePeriod())) {
                            batchOrderEntity.getAttachedEntity()
                                    .setReceivePeriod(batchOrder.getAttachedEntity().getReceivePeriod());
                        }
                        if (StringUtils.isNotEmpty(batchOrder.getAttachedEntity().getReceiveEarliest())) {
                            batchOrderEntity.getAttachedEntity()
                                    .setReceiveEarliest(batchOrder.getAttachedEntity().getReceiveEarliest());
                        }
                        if (StringUtils.isNotEmpty(batchOrder.getAttachedEntity().getReceiveLatest())) {
                            batchOrderEntity.getAttachedEntity()
                                    .setReceiveLatest(batchOrder.getAttachedEntity().getReceiveLatest());
                        }
                        if (StringUtils.isNotEmpty(batchOrder.getAttachedEntity().getReceiveWaitHour())) {
                            batchOrderEntity.getAttachedEntity()
                                    .setReceiveWaitHour(batchOrder.getAttachedEntity().getReceiveWaitHour());
                        }
                        if (StringUtils.isNotEmpty(batchOrder.getAttachedEntity().getAdvancedNotificationHour())) {
                            batchOrderEntity.getAttachedEntity().setAdvancedNotificationHour(
                                    batchOrder.getAttachedEntity().getAdvancedNotificationHour());
                        }
                        if (null != batchOrder.getAttachedEntity().getAnimalQuarantineCertificationFlg()) {
                            batchOrderEntity.getAttachedEntity().setAnimalQuarantineCertificationFlg(
                                    batchOrder.getAttachedEntity().getAnimalQuarantineCertificationFlg());
                        }
                        if (StringUtils.isNotEmpty(batchOrder.getAttachedEntity().getStevedoreRequirement())) {
                            batchOrderEntity.getAttachedEntity()
                                    .setStevedoreRequirement(batchOrder.getAttachedEntity().getStevedoreRequirement());
                        }
                        if (StringUtils.isNotEmpty(batchOrder.getAttachedEntity().getPackageRequirement())) {
                            batchOrderEntity.getAttachedEntity()
                                    .setPackageRequirement(batchOrder.getAttachedEntity().getPackageRequirement());
                        }
                        if (StringUtils.isNotEmpty(batchOrder.getAttachedEntity().getRemark())) {
                            batchOrderEntity.getAttachedEntity().setRemark(batchOrder.getAttachedEntity().getRemark());
                        }
                        if (null != batchOrder.getAttachedEntity().getNearestParkingDistance()) {
                            batchOrderEntity.getAttachedEntity().setNearestParkingDistance(
                                    batchOrder.getAttachedEntity().getNearestParkingDistance());
                        }
                    }
                }
                if (isUpdate) {
                    if (null == batchOrderEntity.getEntity().getEarnestAmount()) {
                        batchOrderEntity.getEntity().setEarnestAmount(new BigDecimal(0));
                    }
                    if (null == batchOrderEntity.getEntity().getAdvancePaymentAmount()) {
                        batchOrderEntity.getEntity().setAdvancePaymentAmount(new BigDecimal(0));
                    }
                    batchUpdateList.add(batchOrderEntity);
                }
            }
            if (null != batchUpdateList && batchUpdateList.size() > 0) {
                // 批量更新找出的分批订单
                BuyerBatchOrderList batchOrderList = BuyerBatchOrderList.build(blackboard)
                        .forUpdate(batchUpdateList.toArray(new BuyerBatchOrder[batchUpdateList.size()]));
                batchOrderList.modify();
            }
        }
    }

    /**
     * 新增分批订单数据
     *
     * @param buyerBatchOrders
     * @param modifiedBuyerBatchOrders
     */
    private void addBuyerBatchOrders(BuyerOrder buyerOrder, List<BuyerBatchOrder> buyerBatchOrders,
            List<BuyerBatchOrder> modifiedBuyerBatchOrders, Blackboard blackboard) {
        List<BuyerBatchOrder> batchAddList = new ArrayList<BuyerBatchOrder>();
        // 找出需要新增的分批订单
        if (null != modifiedBuyerBatchOrders && modifiedBuyerBatchOrders.size() > 0) {
            for (BuyerBatchOrder batchOrder : modifiedBuyerBatchOrders) {
                Boolean isAdd = true;
                if (null != buyerBatchOrders && buyerBatchOrders.size() > 0) {
                    for (BuyerBatchOrder batchOrderEntity : buyerBatchOrders) {
                        if (null != batchOrder.getEntity().getBuyerBatchOrderId() && batchOrder.getEntity()
                                .getBuyerBatchOrderId().equals(batchOrderEntity.getEntity().getBuyerBatchOrderId())) {
                            isAdd = false;
                        }
                    }
                }
                if (isAdd) {
                    batchOrder.getEntity().setBuyerOrderId(buyerOrder.getEntity().getBuyerOrderId());
                    if (null == batchOrder.getEntity().getEarnestAmount()) {
                        batchOrder.getEntity().setEarnestAmount(new BigDecimal(0));
                    }
                    if (null == batchOrder.getEntity().getAdvancePaymentAmount()) {
                        batchOrder.getEntity().setAdvancePaymentAmount(new BigDecimal(0));
                    }
                    if (CollectionUtils.isEmpty(batchOrder.getBuyerBatchOrderDetails())) {
                        throw new BusinessException(ModuleCode.ORDR, ErrorCode.E010205);
                    }
                    _completeBuyerBatchOrder(batchOrder);
                    batchAddList.add(batchOrder);
                }
            }
            // 批量新增找出的分批订单
            if (null != batchAddList && batchAddList.size() > 0) {
                BuyerBatchOrderList batchOrderList = BuyerBatchOrderList.build(blackboard)
                        .forCreate(batchAddList.toArray(new BuyerBatchOrder[batchAddList.size()]));
                batchOrderList.create();
                // 设置找出的分批订单（modifiedBuyerBatchOrders）的分批订单明细的分批订单ID
                for (BuyerBatchOrder batchOrder : batchOrderList.getArchives()) {
                    batchOrder.setBlackboard(blackboard);
                    if (null != batchOrder.getBuyerBatchOrderDetails()
                            && batchOrder.getBuyerBatchOrderDetails().size() > 0) {
                        for (BuyerBatchOrderDetail detail : batchOrder.getBuyerBatchOrderDetails()) {
                            detail.getEntity().setBuyerBatchOrderId(batchOrder.getEntity().getBuyerBatchOrderId());
                            detail.getEntity().setBuyerOrderId(batchOrder.getEntity().getBuyerOrderId());
                        }
                    }
                }
            }
        }
    }

    /**
     * 修改买家分批订单明细数据
     *
     * @param buyerOrder
     * @param modifiedBuyerOrder
     */
    private ArrayList<StockRestParam> modifyBuyerBatchOrderDetails(BuyerOrder buyerOrder, BuyerOrder modifiedBuyerOrder,
            Blackboard blackboard) {

        // 修改前的分批订单明细数据
        List<BuyerBatchOrderDetail> buyerBatchOrderDetails = buyerOrder.getBuyerBatchOrderDetails();
        // 修改后的分批订单明细数据
        List<BuyerBatchOrderDetail> modifiedBuyerBatchOrderDetails = modifiedBuyerOrder.getBuyerBatchOrderDetails();

        Map<String, Goods> goodsMap = new HashMap<>();
        List<String> goodsTemp = new ArrayList<>();
        for (BuyerBatchOrderDetail batchOrderDetail : modifiedBuyerBatchOrderDetails) {
            String goodsId = batchOrderDetail.getEntity().getGoodsId();
            if (StringUtils.isNotEmpty(goodsId)) {
                goodsTemp.add(goodsId);
            }
        }
        List<Goods> goodsList = Goods.findByIds(goodsTemp, buyerOrder.getEntity().getLogisticsZoneId());
        if (null != goodsList && goodsList.size() > 0) {
            for (Goods goods : goodsList) {
                goodsMap.put(goods.getEntity().getGoodsId(), goods);
            }
        }
        for (BuyerBatchOrderDetail batchOrderDetail : modifiedBuyerBatchOrderDetails) {
            _completeBuyerBatchOrderDetail(batchOrderDetail, goodsMap);
        }
        ArrayList<StockRestParam> paramList = new ArrayList<>();
        // 移除分批订单明细数据
        removeBuyerBatchOrderDetails(buyerOrder, buyerBatchOrderDetails, modifiedBuyerBatchOrderDetails, blackboard,
                paramList);

        // 更新分批订单明细数据
        updateBuyerBatchOrderDetails(buyerOrder, buyerBatchOrderDetails, modifiedBuyerBatchOrderDetails, blackboard,
                paramList);

        // 新增分批订单明细数据
        addBuyerBatchOrderDetails(buyerOrder, buyerBatchOrderDetails, modifiedBuyerBatchOrderDetails, blackboard,
                paramList);

        return paramList;
    }

    /**
     * 移除分批订单明细数据
     *
     * @param buyerBatchOrderDetails
     * @param modifiedBuyerBatchOrderDetails
     */
    private void removeBuyerBatchOrderDetails(BuyerOrder buyerOrder, List<BuyerBatchOrderDetail> buyerBatchOrderDetails,
            List<BuyerBatchOrderDetail> modifiedBuyerBatchOrderDetails, Blackboard blackboard,
            ArrayList<StockRestParam> paramList) {
        List<BuyerBatchOrderDetail> list = new ArrayList<>();
        StockRestParam param = new StockRestParam();
        // 找出需要移除的分批订单明细
        if (null != buyerBatchOrderDetails && buyerBatchOrderDetails.size() > 0
                && null != modifiedBuyerBatchOrderDetails && modifiedBuyerBatchOrderDetails.size() > 0) {
            for (BuyerBatchOrderDetail detailEntity : buyerBatchOrderDetails) {
                Boolean isDel = true;
                for (BuyerBatchOrderDetail detail : modifiedBuyerBatchOrderDetails) {
                    if (null != detail.getEntity().getBuyerBatchOrderDetailId()
                            && detail.getEntity().getBuyerBatchOrderDetailId()
                                    .equals(detailEntity.getEntity().getBuyerBatchOrderDetailId())) {
                        isDel = false;
                    }
                }
                if (isDel) {
                    // 组装占用库存数据
                    detailEntity.getEntity()
                            .setTransactionSequence(detailEntity.getEntity().getTransactionSequence() + 1);
                    param = new StockRestParam();
                    param.setLogicAreaId(buyerOrder.getEntity().getLogisticsZoneId());
                    param.setGoodsId(detailEntity.getEntity().getGoodsId());
                    param.setRefNo(buyerOrder.getEntity().getBuyerOrderCode());
                    param.setTransactionId(buyerOrder.getEntity().getBuyerOrderId());
                    param.setTransactionNo(buyerOrder.getEntity().getBuyerOrderCode());
                    param.setTransactionDetailId(detailEntity.getEntity().getBuyerBatchOrderDetailId());
                    param.setTransactionSequence(detailEntity.getEntity().getTransactionSequence());
                    param.setAllocatedQty(DecimalUtils.getBigDecimal(NumberConst.IntDef.INT_ZERO));// 删除占用占用库存为0
                    param.setTargetId(buyerOrder.getEntity().getBuyerId());
                    param.setTargetCode(buyerOrder.getAttachedEntity().getBuyerCode());
//                    param.setTargetType(TargetType.BUYER.getCode());
                    paramList.add(param);
                    list.add(detailEntity);
                }
            }
        }
        // 批量移除找出的分批订单明细
        if (null != list && list.size() > 0) {
            BuyerBatchOrderDetailList detailList = BuyerBatchOrderDetailList.build(blackboard)
                    .forUpdate(list.toArray(new BuyerBatchOrderDetail[list.size()]));
            detailList.delete();
        }
    }

    /**
     * 更新分批订单明细数据
     *
     * @param buyerBatchOrderDetails
     * @param modifiedBuyerBatchOrderDetails
     */
    private void updateBuyerBatchOrderDetails(BuyerOrder buyerOrder, List<BuyerBatchOrderDetail> buyerBatchOrderDetails,
            List<BuyerBatchOrderDetail> modifiedBuyerBatchOrderDetails, Blackboard blackboard,
            ArrayList<StockRestParam> paramList) {
        List<BuyerBatchOrderDetail> list = new ArrayList<>();
        StockRestParam param = new StockRestParam();
        // 找出需要更新的分批订单明细
        if (null != buyerBatchOrderDetails && buyerBatchOrderDetails.size() > 0
                && null != modifiedBuyerBatchOrderDetails && modifiedBuyerBatchOrderDetails.size() > 0) {

            for (BuyerBatchOrderDetail detailEntity : buyerBatchOrderDetails) {
                Boolean isUpdate = false;
                for (BuyerBatchOrderDetail detail : modifiedBuyerBatchOrderDetails) {
                    if (null != detail.getEntity().getBuyerBatchOrderDetailId()
                            && detail.getEntity().getBuyerBatchOrderDetailId()
                                    .equals(detailEntity.getEntity().getBuyerBatchOrderDetailId())) {
                        isUpdate = true;
                        if (null != detail.getEntity().getGoodsQuantity()) {
                            detailEntity.getEntity().setGoodsQuantity(detail.getEntity().getGoodsQuantity());
                        }
                        if (null != detail.getEntity().getGoodsId()) {
                            detailEntity.getEntity().setGoodsId(detail.getEntity().getGoodsId());
                        }

                        detailEntity.getEntity()
                                .setTransactionSequence(detailEntity.getEntity().getTransactionSequence() + 1);
                        // 组装占用库存数据
                        param = new StockRestParam();
                        param.setLogicAreaId(buyerOrder.getEntity().getLogisticsZoneId());
                        param.setGoodsId(detailEntity.getEntity().getGoodsId());
                        param.setRefNo(buyerOrder.getEntity().getBuyerOrderCode());
                        param.setTransactionId(buyerOrder.getEntity().getBuyerOrderId());
                        param.setTransactionNo(buyerOrder.getEntity().getBuyerOrderCode());
                        param.setTransactionDetailId(detailEntity.getEntity().getBuyerBatchOrderDetailId());
                        param.setTransactionSequence(detailEntity.getEntity().getTransactionSequence());
                        param.setAllocatedQty(detail.getEntity().getGoodsQuantity());
                        param.setTargetId(buyerOrder.getEntity().getBuyerId());
                        param.setTargetCode(buyerOrder.getAttachedEntity().getBuyerCode());
//                        param.setTargetType(TargetType.BUYER.getCode());
                        paramList.add(param);
                    }
                }
                if (isUpdate) {
                    detailEntity.getEntity().setManualSplitFlg(false);
                    list.add(detailEntity);
                }
            }
        }
        // 批量更新找出的分批订单明细
        if (null != list && list.size() > 0) {
            BuyerBatchOrderDetailList detailList = BuyerBatchOrderDetailList.build(blackboard)
                    .forUpdate(list.toArray(new BuyerBatchOrderDetail[list.size()]));
            detailList.modify();
        }
    }

    /**
     * 新增分批订单明细数据
     *
     * @param buyerBatchOrderDetails
     * @param modifiedBuyerBatchOrderDetails
     */
    private void addBuyerBatchOrderDetails(BuyerOrder buyerOrder, List<BuyerBatchOrderDetail> buyerBatchOrderDetails,
            List<BuyerBatchOrderDetail> modifiedBuyerBatchOrderDetails, Blackboard blackboard,
            ArrayList<StockRestParam> paramList) { // paramList 没用到
        List<BuyerBatchOrderDetail> list = new ArrayList<>();
        StockRestParam param = new StockRestParam();
        // 找出需要新增的分批订单明细
        if (null != modifiedBuyerBatchOrderDetails && modifiedBuyerBatchOrderDetails.size() > 0) {
            for (BuyerBatchOrderDetail detail : modifiedBuyerBatchOrderDetails) {
                Boolean isAdd = true;
                if (null != buyerBatchOrderDetails && buyerBatchOrderDetails.size() > 0) {
                    for (BuyerBatchOrderDetail detailEntity : buyerBatchOrderDetails) {
                        if (null != detail.getEntity().getBuyerBatchOrderDetailId()
                                && detail.getEntity().getBuyerBatchOrderDetailId()
                                        .equals(detailEntity.getEntity().getBuyerBatchOrderDetailId())) {
                            isAdd = false;
                        }
                    }
                }
                if (isAdd) {
                    detail.getEntity().setPriceCreateTime(DateUtils.getCurrent());
                    list.add(detail);
                }
            }
        }

        // 批量新增找出的分批订单明细
        if (null != list && list.size() > 0) {
            for (BuyerBatchOrderDetail detail : list) {
                detail.getEntity().setTransactionSequence(1);
                detail.getEntity().setManualSplitFlg(false);
            }
            BuyerBatchOrderDetailList detailList = BuyerBatchOrderDetailList.build(blackboard)
                    .forCreate(list.toArray(new BuyerBatchOrderDetail[list.size()]));
            detailList.create();
            for (BuyerBatchOrderDetail detail : list) {
                // 组装占用库存数据
                param = new StockRestParam();
                param.setLogicAreaId(buyerOrder.getEntity().getLogisticsZoneId());
                param.setGoodsId(detail.getEntity().getGoodsId());
                param.setRefNo(buyerOrder.getEntity().getBuyerOrderCode());
                param.setTransactionId(buyerOrder.getEntity().getBuyerOrderId());
                param.setTransactionNo(buyerOrder.getEntity().getBuyerOrderCode());
                param.setTransactionDetailId(detail.getEntity().getBuyerBatchOrderDetailId());
                param.setTransactionSequence(detail.getEntity().getTransactionSequence());
                param.setAllocatedQty(detail.getEntity().getGoodsQuantity());
                param.setTargetId(buyerOrder.getEntity().getBuyerId());
                param.setTargetCode(buyerOrder.getAttachedEntity().getBuyerCode());
//                param.setTargetType(TargetType.BUYER.getCode());
                paramList.add(param);
            }
        }
    }

    /**
     * 更新价盘信息
     * 
     * @param summaries
     * @param newSummaries
     */
    private void updatePriceCreateTime(BuyerOrder buyerOrder, List<BuyerBatchOrderDetailSummary> oldSummaries) {
        List<BuyerBatchOrderDetailSummary> newSummaries = buyerOrder.summaryBuyerBatchOrderDetails();
        for (BuyerBatchOrderDetailSummary newSummary : newSummaries) {
            boolean isNew = true;
            for (BuyerBatchOrderDetailSummary oldSummary : oldSummaries) {
                if (oldSummary.getGoodsId().equals(newSummary.getGoodsId())) {
                    if (newSummary.getPriceCreateTime() == null)
                        newSummary.setPriceCreateTime(oldSummary.getPriceCreateTime());
                    isNew = false;
                    break;
                }
            }
            if (isNew)
                newSummary.setPriceCreateTime(DateUtils.getCurrent());
        }

        for (BuyerBatchOrderDetail detail : buyerOrder.getBuyerBatchOrderDetails()) {
            for (BuyerBatchOrderDetailSummary newSummary : newSummaries) {
                if (newSummary.getGoodsId().equals(detail.getEntity().getGoodsId())) {
                    detail.getEntity().setPriceCreateTime(newSummary.getPriceCreateTime());
                }
            }
        }
    }

    /**
     * 移除原始分拆信息
     *
     * @param buyerForcastDeliverDetails
     */
    private void removeBuyerForcastDeliverDetails(List<BuyerForcastDeliverDetail> buyerForcastDeliverDetails,
            Blackboard blackboard) {
        BuyerForcastDeliverDetailList forcastDeliverDetailList = BuyerForcastDeliverDetailList.build(blackboard)
                .forUpdate(buyerForcastDeliverDetails
                        .toArray(new BuyerForcastDeliverDetail[buyerForcastDeliverDetails.size()]));
        forcastDeliverDetailList.delete();
    }

    /**
     * 收尾
     *
     * @param map
     *            HashMap
     */
    private void post(HashMap<String, Object> map) {

    }

    /**
     * 补充买家分批订单信息
     *
     * @param buyerBatchOrder
     */
    private void _completeBuyerBatchOrder(BuyerBatchOrder buyerBatchOrder) {
        // 计算订单金额
        buyerBatchOrder.getEntity().setOrderAmount(buyerBatchOrder.calculateOrderAmount());

        // 设置预留金额
        buyerBatchOrder.getEntity().setFreight(BigDecimal.ZERO);
        buyerBatchOrder.getEntity().setPreferentialAmount(BigDecimal.ZERO);
        buyerBatchOrder.getEntity().setReceiveAmount(BigDecimal.ZERO);
        buyerBatchOrder.getEntity().setEarnestPercent(BigDecimal.ZERO);
        buyerBatchOrder.getEntity().setEarnestAmount(BigDecimal.ZERO);
        buyerBatchOrder.getEntity().setAdvancePaymentPercent(BigDecimal.ZERO);
        buyerBatchOrder.getEntity().setAdvancePaymentAmount(BigDecimal.ZERO);

        // 设置买家分批订单状态
        buyerBatchOrder.getEntity().setBuyerBatchOrderStu(BuyerBatchOrderStu.TO_SPLIT.getCode());
    }

    /**
     * 补充买家分批订单明细信息
     */
    private void _completeBuyerBatchOrderDetail(BuyerBatchOrderDetail buyerBatchOrderDetail,
            Map<String, Goods> goodsMap) {

        buyerBatchOrderDetail.getEntity().setGoodsUnit(GoodsUnit.PACKAGE.getCode());
        // 设置取消数量
        buyerBatchOrderDetail.getEntity().setCancelQuantity(BigDecimal.ZERO);

        // 设置是否分拆完成
        buyerBatchOrderDetail.getEntity().setSplitFlg(false);

        // 获取商品信息
        Goods goods = goodsMap.get(buyerBatchOrderDetail.getEntity().getGoodsId().toString());
        if (goods == null)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E010105,
                    buyerBatchOrderDetail.getEntity().getGoodsId().toString());

        buyerBatchOrderDetail.getEntity().setProductId(goods.getEntity().getProductId());
        buyerBatchOrderDetail.getEntity().setManufacturerId(goods.getEntity().getManufacturerId());
        buyerBatchOrderDetail.getEntity().setSellerId(goods.getEntity().getSellerId());
        buyerBatchOrderDetail.getEntity().setBatchId(goods.getEntity().getBatchId());
        buyerBatchOrderDetail.getEntity().setSaleLabelId(goods.getEntity().getSaleLabelId());

        buyerBatchOrderDetail.getAttachedEntity().setItemCode(goods.getEntity().getItemCode());
        buyerBatchOrderDetail.getAttachedEntity().setItemName(goods.getEntity().getItemName());
        buyerBatchOrderDetail.getAttachedEntity().setBrandCode(goods.getEntity().getBrandCode());
        buyerBatchOrderDetail.getAttachedEntity().setBrandName(goods.getEntity().getBrandName());
        buyerBatchOrderDetail.getAttachedEntity().setItemBrandCode(goods.getEntity().getItemBrandCode());
        buyerBatchOrderDetail.getAttachedEntity().setManufacturerCode(goods.getEntity().getManufacturerCode());
        buyerBatchOrderDetail.getAttachedEntity().setManufacturerName(goods.getEntity().getManufacturerName());
        buyerBatchOrderDetail.getAttachedEntity().setSellerCode(goods.getEntity().getSellerCode());
        buyerBatchOrderDetail.getAttachedEntity().setSellerName(goods.getEntity().getSellerName());
        buyerBatchOrderDetail.getAttachedEntity().setBatchCode(goods.getEntity().getBatchCode());
        buyerBatchOrderDetail.getAttachedEntity().setSaleLabelCode(goods.getEntity().getSaleLabelCode());
        buyerBatchOrderDetail.getAttachedEntity().setSaleLabelName(goods.getEntity().getSaleLabelName());
        buyerBatchOrderDetail.getAttachedEntity().setSmallPackageFeature(goods.getEntity().getSmallPackageFeature());
        buyerBatchOrderDetail.getAttachedEntity().setQuantityPerPackage(goods.getEntity().getQuantityPerPackage());
        buyerBatchOrderDetail.getAttachedEntity().setNetWeight(goods.getEntity().getNetWeight());
        buyerBatchOrderDetail.getAttachedEntity().setGrossWeight(goods.getEntity().getGrossWeight());
        buyerBatchOrderDetail.getAttachedEntity().setCartonSize(goods.getEntity().getCartonSize());
        buyerBatchOrderDetail.getAttachedEntity().setProductLevel(goods.getEntity().getProductLevel());
        buyerBatchOrderDetail.getAttachedEntity()
                .setPalletStandardStackQuantity(goods.getEntity().getPalletStandardStackQuantity());
        buyerBatchOrderDetail.getAttachedEntity().setGoodsCode(goods.getEntity().getGoodsCode());
        buyerBatchOrderDetail.getAttachedEntity().setGoodsName(goods.getEntity().getGoodsName());

    }

    /**
     * 验证是否可以使用账期
     *
     * @param modifiedBuyerOrder
     */
    private void checkNetUse(BuyerOrder modifiedBuyerOrder, Buyer buyer) {
        // 是否是账期买家，买家模块的数据可能为空
        boolean netBuyerFlg = buyer.getEntity().getNetBuyerFlg() == null ? false : buyer.getEntity().getNetBuyerFlg();

        // 只有账期买家才能使用账期
        if (modifiedBuyerOrder.getEntity().getUseNetFlg() && !netBuyerFlg) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E010103);
        }
    }

    /**
     * 修改订单、分批订单、分批订单明细
     */
    private void modifyBuyerOrder(BuyerOrder buyerOrder) {
        buyerOrder.modify();

        BuyerBatchOrderList batchList = BuyerBatchOrderList.build(buyerOrder.getBlackboard())
                .forUpdate(buyerOrder.getBuyerBatchOrders().toArray(new BuyerBatchOrder[0]));
        batchList.modify();

        BuyerBatchOrderDetailList detailList = BuyerBatchOrderDetailList.build(buyerOrder.getBlackboard())
                .forUpdate(buyerOrder.getBuyerBatchOrderDetails().toArray(new BuyerBatchOrderDetail[0]));
        detailList.modify();
    }
}
