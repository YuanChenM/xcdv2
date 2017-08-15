package com.bms.order.services.impl;

import java.math.BigDecimal;
import java.util.*;

import com.bms.order.bean.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.order.archive.impl.BuyerBatchOrder;
import com.bms.order.archive.impl.BuyerBatchOrderDetail;
import com.bms.order.archive.impl.BuyerForcastDeliverDetail;
import com.bms.order.archive.impl.BuyerOrder;
import com.bms.order.archive.impl.BuyerReturn;
import com.bms.order.archive.impl.BuyerReturnDetail;
import com.bms.order.archive.impl.DistributionNotification;
import com.bms.order.archive.impl.DistributionNotificationDetail;
import com.bms.order.archive.impl.Operator;
import com.bms.order.archive.impl.ReceiveNotification;
import com.bms.order.archive.impl.ReceiveNotificationDetail;
import com.bms.order.archive.impl.ReturnReason;
import com.bms.order.archive.impl.SendNotification;
import com.bms.order.archive.impl.SendNotificationDetail;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.param.ORDR0803IBean;
import com.bms.order.bean.param.ORDR0803ProductBean;
import com.bms.order.bean.param.ORDR0803ShipIBean;
import com.bms.order.constant.enumeration.ApplyObject;
import com.bms.order.constant.enumeration.BuyerBatchOrderStu;
import com.bms.order.constant.enumeration.BuyerReturnApplyerType;
import com.bms.order.constant.enumeration.BuyerReturnMode;
import com.bms.order.constant.enumeration.BuyerReturnSource;
import com.bms.order.constant.enumeration.BuyerReturnStu;
import com.bms.order.constant.enumeration.BuyerReturnType;
import com.bms.order.constant.enumeration.DistributionNotificationStu;
import com.bms.order.constant.enumeration.ForcastType;
import com.bms.order.constant.enumeration.OperatorType;
import com.bms.order.constant.enumeration.PaymentStu;
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
import com.bms.order.dao.BuyerReturnDao;
import com.bms.order.dao.BuyerReturnDetailDao;
import com.bms.order.dao.DistributionNotificationDao;
import com.bms.order.dao.DistributionNotificationDetailDao;
import com.bms.order.dao.ReceiveNotificationDao;
import com.bms.order.dao.ReceiveNotificationDetailDao;
import com.bms.order.dao.ReturnReasonDao;
import com.bms.order.dao.SendNotificationDao;
import com.bms.order.dao.SendNotificationDetailDao;
import com.bms.order.services.ORDR0803IService;
import com.bms.order.util.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.DecimalUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;

/**
 * 买家迟收退货数据接收接口Service
 *
 * @author li_huiqian
 */
@Service
public class ORDR0803IServiceImpl implements ORDR0803IService {

    @Autowired
    private BaseRedisDao redisDao;
    @Autowired
    private BuyerOrderDao buyerOrderDao;// 订单
    @Autowired
    private BuyerOrderAttachedDao buyerOrderAttachedDao;
    @Autowired
    private BuyerBatchOrderDao buyerBatchOrderDao;// 分配订单
    @Autowired
    private BuyerBatchOrderAttachedDao buyerBatchOrderAttachedDao;
    @Autowired
    private BuyerBatchOrderDetailDao buyerBatchOrderDetailDao;// 分配订单明细
    @Autowired
    private BuyerBatchOrderDetailAttachedDao buyerBatchOrderDetailAttachedDao;
    @Autowired
    private BuyerForcastDeliverDetailDao buyerForcastDeliverDetailDao;// 预配送明细
    @Autowired
    private BuyerForcastDeliverDetailAttachedDao buyerForcastDeliverDetailAttachedDao;// 预配送明细附表
    @Autowired
    private DistributionNotificationDao distributionNotificationDao;// 配送通知单
    @Autowired
    private DistributionNotificationDetailDao distributionNotificationDetailDao;// 配送通知单明细
    @Autowired
    private SendNotificationDao sendNotificationDao;// 发货通知单
    @Autowired
    private SendNotificationDetailDao sendNotificationDetailDao;//发货通知单明细
    @Autowired
    private ReceiveNotificationDao receiveNotificationDao;// 收货
    @Autowired
    private ReceiveNotificationDetailDao receiveNotificationDetailDao;// 收货明细
    @Autowired
    private BuyerReturnDao buyerReturnDao;// 退货
    @Autowired
    private BuyerReturnDetailDao buyerReturnDetailDao;// 退货明细
    @Autowired
    private ReturnReasonDao returnReasonDao;// 退货原因

    /**
     * 接收配送PDA系统的迟收再配送信息，创建退货单，创建完成的退货即为已确认状态，由于是在现场发起的退货，即认为是已经确认的退货
     *
     * @param operator 操作者
     * @param bean     ORDR0803IBean
     */
    @Override
    public BuyerReturnEntity execute(Operator operator, ORDR0803IBean bean) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();
        String operatorType = operator.getOperatorType();
        if (!(OperatorType.MADE_4_NET.getCode().equals(operatorType) || OperatorType.MANAGER.getCode().equals(operatorType))) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080314);
        }
        blackboard.setOperator(operator);
        map.put("bean", bean);
        map.put("blackboard", blackboard);
        pre(map);
        process(map);
        post(map);
        BuyerReturn buyerReturn = (BuyerReturn) map.get("buyerReturn");
        return buyerReturn.getEntity();
    }

    /**
     * 准备
     *
     * @param map HashMap
     */
    private void pre(HashMap<String, Object> map) {
        // 获取参数
        ORDR0803IBean param = (ORDR0803IBean) map.get("bean");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 设置DAO
        blackboard.setBaseRedisDao(redisDao);
        blackboard.putBaseDao(buyerOrderDao);
        blackboard.putBaseDao(buyerOrderAttachedDao);
        blackboard.putBaseDao(buyerBatchOrderDao);
        blackboard.putBaseDao(buyerBatchOrderAttachedDao);
        blackboard.putBaseDao(buyerBatchOrderDetailDao);
        blackboard.putBaseDao(buyerBatchOrderDetailAttachedDao);
        blackboard.putBaseDao(buyerForcastDeliverDetailDao);
        blackboard.putBaseDao(buyerForcastDeliverDetailAttachedDao);
        blackboard.putBaseDao(distributionNotificationDao);
        blackboard.putBaseDao(distributionNotificationDetailDao);
        blackboard.putBaseDao(sendNotificationDao);
        blackboard.putBaseDao(sendNotificationDetailDao);
        blackboard.putBaseDao(receiveNotificationDao);
        blackboard.putBaseDao(receiveNotificationDetailDao);
        blackboard.putBaseDao(buyerReturnDao);
        blackboard.putBaseDao(buyerReturnDetailDao);
        blackboard.putBaseDao(returnReasonDao);


        //renturnMode  check
        Integer returnMode = param.getReturnMode();
        if (!(returnMode.toString().equals(BuyerReturnMode.ALL.getCode()) || returnMode.toString().equals(BuyerReturnMode.PART.getCode()))) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080301);
        }

        DistributionNotification distributionNotification = this.checkDistributionNotification(param, blackboard);
        this.checkIsAlreadyReceived(distributionNotification);// 需要先收货
        this.checkIsPay(distributionNotification, param); // check 支付   完成
        this.checkDeliverCodeAndReturnQty(param, distributionNotification);
        BuyerReturn buyerReturn = this.getOrderBuyerReturn(param, distributionNotification);// 退货主表
        List<BuyerForcastDeliverDetail> buyerForcastDeliverDetailList = this.getBuyerForcastDeliverDetailList(distributionNotification, param);//预配送明细
        Map<String, Object> objectMap = this.getReceiveNotificationList(distributionNotification, param);// 收货 退货金额
        List<ReceiveNotification> receiveNotificationList = (List<ReceiveNotification>) objectMap.get("receiveNotificationList");
        BigDecimal returnAmount = (BigDecimal) objectMap.get("returnAmount");
        //操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);
        // 返回参数
        map.put("buyerReturn", buyerReturn);
        map.put("returnAmount", returnAmount);
        map.put("receiveNotificationList", receiveNotificationList);
        map.put("distributionNotification", distributionNotification);
        map.put("buyerForcastDeliverDetailList", buyerForcastDeliverDetailList);

    }

    /**
     * 是否是第一次收货
     *
     * @param distributionNotification
     */
    public void checkIsAlreadyReceived(DistributionNotification distributionNotification) {
        List<ReceiveNotification> receiveNotificationList = distributionNotification.getReceiveNotifications();
        if (CollectionUtils.isEmpty(receiveNotificationList)) {// 先收货再迟收
            throw new BusinessException(ModuleCode.ORDR, "需要先调用收货");
        }
    }

    /**
     * 执行
     *
     * @param map HashMap
     */
    private void process(HashMap<String, Object> map) {
        // 获取参数
        // 退货
        BuyerReturn buyerReturn = (BuyerReturn) map.get("buyerReturn");
        BigDecimal returnAmount = (BigDecimal) map.get("returnAmount");
        buyerReturn.getEntity().setReturnAmount(returnAmount);// 退货金额
        buyerReturn.create();
        buyerReturn.complete(false);
        Long returnId = buyerReturn.getEntity().getReturnId();// 退货单id

        List<ReceiveNotification> receiveNotificationList = (List<ReceiveNotification>) map.get("receiveNotificationList");             // 收货
        for (ReceiveNotification receiveNotification : receiveNotificationList) {
            Long receiveNotificationId = receiveNotification.getEntity().getReceiveNotificationId();
            if (receiveNotificationId != null) {
                // receiveNotification.modify();
            } else {
                receiveNotification.create();
                receiveNotificationId = receiveNotification.getEntity().getReceiveNotificationId();
            }
            List<ReceiveNotificationDetail> receiveNotificationDetailList = receiveNotification.getReceiveNotificationDetails();
            for (ReceiveNotificationDetail receiveNotificationDetail : receiveNotificationDetailList) {
                Long receiveNotificationDetailId = receiveNotificationDetail.getEntity().getReceiveNotificationDetailId();
                if (receiveNotificationDetailId != null) {
                    receiveNotificationDetail.modify();

                } else {
                    receiveNotificationDetail.getEntity().setReceiveNotificationId(receiveNotificationId);
                    receiveNotificationDetail.create();
                    receiveNotificationDetailId = receiveNotificationDetail.getEntity().getReceiveNotificationDetailId();

                }
                //  生成对应的 退货明细：收货明细=1:1  在迟收 拒收中
                List<BuyerReturnDetail> buyerReturnDetailList = receiveNotificationDetail.getBuyerReturnDetails();
                if (CollectionUtils.isNotEmpty(buyerReturnDetailList)) {
                    for (BuyerReturnDetail buyerReturnDetail : buyerReturnDetailList) {
                        BuyerReturnDetailEntity buyerReturnDetailEntity = buyerReturnDetail.getEntity();
                        Long detailId = buyerReturnDetailEntity.getDetailId();
                        if (detailId == null) {
                            buyerReturnDetailEntity.setReturnId(returnId);//  退货单id
                            buyerReturnDetailEntity.setReceiveNotificationId(receiveNotificationId);// 收货id
                            buyerReturnDetailEntity.setReceiveNotificationDetailId(receiveNotificationDetailId);// 收货明细id
                            buyerReturnDetail.create();
                        }
                    }
                }

            }
        }

        //  预配送
        List<BuyerForcastDeliverDetail> buyerForcastDeliverDetailList = (List<BuyerForcastDeliverDetail>) map.get("buyerForcastDeliverDetailList");
        List<Long> buyerForcastDeliverDetailIdList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(buyerForcastDeliverDetailList)) {
            for (BuyerForcastDeliverDetail buyerForcastDeliverDetail : buyerForcastDeliverDetailList) {
                Long buyerForcastDeliverDetailId = buyerForcastDeliverDetail.getEntity().getBuyerForcastDeliverDetailId();
                if (buyerForcastDeliverDetailId != null) {
                    buyerForcastDeliverDetail.modify();
                } else {
                    buyerForcastDeliverDetail.create();
                    Long newBuyerForcastDeliverDetailId = buyerForcastDeliverDetail.getEntity().getBuyerForcastDeliverDetailId();
                    buyerForcastDeliverDetailIdList.add(newBuyerForcastDeliverDetailId);
                }
            }
        }
        // 配送
        DistributionNotification dbDistributionNotification = (DistributionNotification) map.get("distributionNotification");
        DistributionNotification distributionNotification = this.getDistributionNotification(dbDistributionNotification);
        distributionNotification.modify();
        // 分批订单
        Collection<BuyerBatchOrder> buyerBatchOrderList = this.getBatchBuyerOrderList(distributionNotification, buyerForcastDeliverDetailIdList);
        if (CollectionUtils.isNotEmpty(buyerBatchOrderList)) {
            for (BuyerBatchOrder buyerBatchOrder : buyerBatchOrderList) {
                buyerBatchOrder.modify();//  修改
            }
        }
        // 执行操作


    }

    /**
     * 收尾
     *
     * @param map HashMap
     */
    private void post(HashMap<String, Object> map) {
        // 获取参数

        // 执行操作

    }


    /**
     * 1配送状态只能为“配送中”或“部分收货”
     * buyerId,buyerCode
     *
     * @param param
     * @param blackboard
     * @return
     */
    public DistributionNotification checkDistributionNotification(ORDR0803IBean param, Blackboard blackboard) {
        Long shipIdOfLong = null;
        try {
            shipIdOfLong = Long.parseLong(param.getShipId());
        } catch (Exception e) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080302);
        }
        DistributionNotification distributionNotification = new DistributionNotification(shipIdOfLong);
        distributionNotification.setBlackboard(blackboard);
        distributionNotification.complete(false);
        if (!distributionNotification.isDataSynced()) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080302);
        }
        DistributionNotificationEntity distributionNotificationEntity = distributionNotification.getEntity();
        String stu = distributionNotificationEntity.getDistributionNotificationStu();

        if (!(DistributionNotificationStu.IN_DISTRIBUTION.getCode().equals(stu) || DistributionNotificationStu.PARTIAL_RECEIPT.getCode().equals(stu))) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080303);
        }
        // 判断 buyer  buyerId  buyerCode
        BuyerOrder buyerOrder = distributionNotification.getBuyerOrder();
        buyerOrder.complete(false);
        String dbBuyerId = buyerOrder.getEntity().getBuyerId();
        if (!param.getBuyerId().equals(dbBuyerId)) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080304);
        }
        String dbBuyerCode = buyerOrder.getAttachedEntity().getBuyerCode();
        if (!param.getBuyerCode().equals(dbBuyerCode)) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080305);
        }
        return distributionNotification;
    }


    /**
     * 查询对应的配送信息，退货迟收数量必须小于等于 配送明细表中发货数量 - 收货明细中收货数量合计 - 收货明细拒收数量合计 - 收货明细退货数量合计
     * 对于传入的SKU也需要和配送单明细中SKU进行验证
     *
     * @param bean                     入参
     * @param distributionNotification 配送通知单
     * @return
     */
    public void checkDeliverCodeAndReturnQty(ORDR0803IBean bean, DistributionNotification distributionNotification) {
        Blackboard blackboard = distributionNotification.getBlackboard();
        this.checkReturnReason(bean.getReturnReasonID(), blackboard);
        List<ORDR0803ShipIBean> shipList = bean.getShipList();
        if (CollectionUtils.isNotEmpty(shipList)) {
            Map<String, String> map = new HashMap<>();
            for (ORDR0803ShipIBean ship : shipList) {
                String diverCode = ship.getDeliverCode();//WMS配送单号
                List<ORDR0803ProductBean> productList = ship.getProductList();
                if (CollectionUtils.isNotEmpty(productList)) {
                    for (ORDR0803ProductBean product : productList) {
                        this.checkCanReturnQtyAndSkuByProduct(diverCode, product, blackboard, map);
                    }
                }
            }
        }
    }


    /**
     * 已收≥订单总额，才可进行下一步
     *
     * @param distributionNotification
     */
    public void checkIsPay(DistributionNotification distributionNotification, ORDR0803IBean param) {
        BuyerOrder buyerOrder = distributionNotification.getBuyerOrder();
        String paymentStu = buyerOrder.getEntity().getPaymentStu();
        if (!PaymentStu.ALL_PAYMENT.getCode().equals(paymentStu)) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080315);
        }
        List<DistributionNotification> distributionNotificationList = buyerOrder.getDistributionNotifications();
        DistributionNotification distribution = this.getFirstDistributionNotification(distributionNotificationList);
        Long distributionNotificationId = distribution.getEntity().getDistributionNotificationId();
        String shipId = param.getShipId();
        if (new Long(shipId).equals(distributionNotificationId)) {// 第一次收货
            Map<Long, BigDecimal> map = new HashMap<>();
            List<ORDR0803ShipIBean> shipList = param.getShipList();
            for (ORDR0803ShipIBean ship : shipList) {
                List<ORDR0803ProductBean> productList = ship.getProductList();
                for (ORDR0803ProductBean product : productList) {
                    map.put(product.getShipDetailId(), product.getReturnQty());
                }
            }
            BigDecimal delayMoney = null;
            BigDecimal payedAmount = buyerOrder.getEntity().getReceiveAmount();
            List<ReceiveNotification> receiveNotificationList = distribution.getReceiveNotifications();
            for (ReceiveNotification receiveNotification : receiveNotificationList) {
                List<ReceiveNotificationDetail> receiveNotificationDetailList = receiveNotification.getReceiveNotificationDetails();
                if (CollectionUtils.isNotEmpty(receiveNotificationDetailList)) {
                    for (ReceiveNotificationDetail receiveNotificationDetail : receiveNotificationDetailList) {
                        ReceiveNotificationDetailEntity receiveNotificationDetailEntity = receiveNotificationDetail.getEntity();
                        BigDecimal price = receiveNotificationDetailEntity.getPricePlateUnitPrice();
                        Long distributionNotificationDetailId = receiveNotificationDetailEntity.getDistributionNotificationDetailId();
                        BigDecimal delayQty = map.get(distributionNotificationDetailId);// 将要迟收
                        delayMoney = DecimalUtils.add(delayMoney, DecimalUtils.multiply(delayQty, price));
                    }
                }
            }

            BigDecimal otherShipMoney = this.getOtherShipMoney(distributionNotification, distributionNotificationList);
            BigDecimal shouldPayMoney = DecimalUtils.add(otherShipMoney, delayMoney);
            if (DecimalUtils.lt(payedAmount, shouldPayMoney)) { //  判读该订单 已收金额 >= （收获数量 + 迟收数量） * 单价
                throw new BusinessException(ModuleCode.ORDR, "付款不足，不能迟收");
            }
        }

    }


    /**
     * 获取第一个配送单
     *
     * @param distributionNotificationList
     * @return
     */
    public DistributionNotification getFirstDistributionNotification(List<DistributionNotification> distributionNotificationList) {
        DistributionNotification distributionNotification = null;
        Map<Long, DistributionNotification> map = new HashMap<>();
        Long[] array = new Long[distributionNotificationList.size()];
        int index = 0;
        for (DistributionNotification distribution : distributionNotificationList) {
            Long distributionNotificationId = distribution.getEntity().getDistributionNotificationId();
            map.put(distributionNotificationId, distribution);
            array[index] = distributionNotificationId;
            index++;
        }
        Arrays.sort(array);
        Long id = array[0];
        distributionNotification = map.get(id);
        return distributionNotification;

    }


    /**
     * @param distributionNotification
     * @return
     */
    public BigDecimal getOtherShipMoney(DistributionNotification distributionNotification, List<DistributionNotification> distributionNotificationList) {
        BigDecimal otherShipMoney = null;
        Long distributionNotificationId = distributionNotification.getEntity().getDistributionNotificationId();
        for (DistributionNotification distribution : distributionNotificationList) {
            Long dbDistributionNotificationId = distribution.getEntity().getDistributionNotificationId();
            if (!dbDistributionNotificationId.equals(distributionNotificationId)) {
                List<DistributionNotificationDetail> distributionNotificationDetailList = distribution.getDistributionNotificationDetails();
                for (DistributionNotificationDetail distributionNotificationDetail : distributionNotificationDetailList) {
                    BuyerForcastDeliverDetail buyerForcastDeliverDetail = distributionNotificationDetail.getBuyerForcastDeliverDetail();
                    BuyerBatchOrderDetailEntity buyerBatchOrderDetailEntity = buyerForcastDeliverDetail.getBuyerBatchOrderDetail().getEntity();
                    BigDecimal price = buyerBatchOrderDetailEntity.getRealUnitPrice();
                    BigDecimal qty = DecimalUtils.subtract(distributionNotificationDetail.getEntity().getDistributionQuantity(),distributionNotificationDetail.getEntity().getCancelQuantity());
                    BigDecimal amount = DecimalUtils.multiply(price, qty);
                    otherShipMoney = DecimalUtils.add(otherShipMoney, amount);
                }
            }

        }
        return otherShipMoney;
    }


    /**
     * 2 查询对应的配送信息，退货迟收数量必须小于等于 配送明细表中发货数量 - 收货明细中收货数量合计 - 收货明细拒收数量合计 - 收货明细退货数量合计
     * 3 对于传入的SKU也需要和配送单明细中SKU进行验证
     *
     * @param diverCode  发货单中的配送单号
     * @param product
     * @param blackboard
     */
    public void checkCanReturnQtyAndSkuByProduct(String diverCode, ORDR0803ProductBean product, Blackboard blackboard, Map<String, String> map) {
        Long shipDetailId = product.getShipDetailId();//原发货明细ID
        String key = diverCode.trim() + shipDetailId;
        String productSkuCode = product.getSkuCode();
        String value = map.get(key);
        if (StringUtils.isNotEmpty(value)) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080313);
        }
        map.put(key, productSkuCode);
        Long detailReasonId = product.getDetailReasonID();
        if (detailReasonId != null) {
            this.checkReturnReason(detailReasonId, blackboard);
        }
        DistributionNotificationDetail distributionNotificationDetail = new DistributionNotificationDetail(shipDetailId);
        distributionNotificationDetail.setBlackboard(blackboard);
        distributionNotificationDetail.complete(false);
        if (!distributionNotificationDetail.isDataSynced()) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080306, shipDetailId.toString());
        }

        List<SendNotificationDetail> sendNotificationDetailList = distributionNotificationDetail.getSendNotificationDetails();
        if (CollectionUtils.isEmpty(sendNotificationDetailList)) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080306, shipDetailId.toString());
        }
        SendNotificationDetail sendNotificationDetail = sendNotificationDetailList.get(0);
        SendNotification sendNotification = sendNotificationDetail.getSendNotification();
        if (!diverCode.equals(sendNotification.getEntity().getSendNotificationCode())) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080307);
        }
        // 验证发货明细
        BuyerForcastDeliverDetail buyerForcastDeliverDetail = distributionNotificationDetail.getBuyerForcastDeliverDetail();
        if (!buyerForcastDeliverDetail.isDataSynced()) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080308);
        }
        BuyerForcastDeliverDetailEntity buyerForcastDeliverDetailEntity = buyerForcastDeliverDetail.getEntity();
        BigDecimal realSendQuantity = buyerForcastDeliverDetailEntity.getRealSendQuantity();//实际发货数量
        BigDecimal receiveQuantity = buyerForcastDeliverDetailEntity.getReceiveQuantity();//收货数量
        BigDecimal rejectQuantity = buyerForcastDeliverDetailEntity.getRejectQuantity();// 拒收数量
        BigDecimal returnQuantity = buyerForcastDeliverDetailEntity.getReturnQuantity();// 退货数量
        BigDecimal delayQuantity = buyerForcastDeliverDetailEntity.getDelayQuantity();// 迟收数量

        BigDecimal sum = DecimalUtils.add(receiveQuantity, rejectQuantity);
        sum = DecimalUtils.add(sum, returnQuantity);
        sum = DecimalUtils.add(sum, delayQuantity);
        BigDecimal canReturnQty = DecimalUtils.subtract(realSendQuantity, sum);

        BigDecimal preReturnQty = product.getReturnQty();// 准备退货的数量
        if (DecimalUtils.lt(canReturnQty, preReturnQty)) {//  可退的小于 准备退得
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080309);
        }
        String dbSku = buyerForcastDeliverDetailEntity.getSku();

        if (!productSkuCode.equals(dbSku)) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080310);
        }
    }

    /**
     * 1	买家退货主表数据，退货类型为：迟收退货
     * 获取 退货单
     *
     * @param param
     * @return
     */
    public BuyerReturn getOrderBuyerReturn(ORDR0803IBean param, DistributionNotification distributionNotification) {
        BuyerOrder buyerOrder = distributionNotification.getBuyerOrder();
        //  迟收退货单
        BuyerReturnEntity buyerReturnEntity = new BuyerReturnEntity();
        buyerReturnEntity.setOrderId(buyerOrder.getEntity().getBuyerOrderId());// 订单id
        buyerReturnEntity.setBuyerId(buyerOrder.getEntity().getBuyerId());
        buyerReturnEntity.setBuyerCode(buyerOrder.getAttachedEntity().getBuyerCode());// 买家编码
        buyerReturnEntity.setBuyerName(buyerOrder.getAttachedEntity().getBuyerName());//设置买家名称 [买家名称，冗余]
        buyerReturnEntity.setApplyRemark(param.getApplyRemark());
        buyerReturnEntity.setApplyTime(DateUtils.parseDateTime(param.getApplyTime()));

        buyerReturnEntity.setApplyUid(null);//退货申请人ID
        buyerReturnEntity.setApplyUname(param.getApplyMan());// 申请人姓名
        buyerReturnEntity.setBuyerApplyUserType(BuyerReturnApplyerType.BUYER.getCode());//设置买家退货申请人类型 [退货申请人类型]
        buyerReturnEntity.setBuyerReturnSource(BuyerReturnSource.DISTRIBUTION_SYSTEM.getCode());//设置买家退货单来源 [退货单系统来源-CodeMaster  * 1-司机PDA，2-云冻品平台，3-云冻品B2B平台]  todo 常量
        buyerReturnEntity.setBuyerReturnStatus(BuyerReturnStu.CONFIRMED.getCode());// 退货单状态  已确认
        buyerReturnEntity.setBuyerReturnType(BuyerReturnType.DELAY_RETURN.getCode());// 设置买家退货类型 [买家退货类型-CodeMaster * 1-迟收；2-拒收；3-退货]
        buyerReturnEntity.setImage1(param.getImage1());
        buyerReturnEntity.setImage2(param.getImage2());
        buyerReturnEntity.setImage3(param.getImage3());
        buyerReturnEntity.setImage4(param.getImage4());
        buyerReturnEntity.setImage5(param.getImage5());
        buyerReturnEntity.setReturnReasonId(param.getReturnReasonID());
        BuyerReturn buyerReturn = new BuyerReturn(buyerReturnEntity);
        buyerReturn.setBlackboard(distributionNotification.getBlackboard());
        return buyerReturn;
    }


    /**
     * 获取 预配送明细
     *
     * @param distributionNotification
     * @param param
     * @return
     */
    public List<BuyerForcastDeliverDetail> getBuyerForcastDeliverDetailList(DistributionNotification distributionNotification, ORDR0803IBean param) {
        List<BuyerForcastDeliverDetail> buyerForcastDeliverDetailList = new ArrayList<>();//预配送明细
        Blackboard blackboard = distributionNotification.getBlackboard();
        if (param.getReturnMode().toString().equals(BuyerReturnMode.ALL.getCode())) {// 全部  迟收模式：1-全部，整单发货单SHIPID全部迟收，无需关注ShipList部分【2016/10/11】，2-部分
            List<DistributionNotificationDetail> distributionNotificationDetailList = distributionNotification.getDistributionNotificationDetails();
            if (CollectionUtils.isNotEmpty(distributionNotificationDetailList)) {
                for (DistributionNotificationDetail distributionNotificationDetail : distributionNotificationDetailList) {//  配送明细:退货明细=1:1
                    BigDecimal newDelayQty = DecimalUtils.subtract(distributionNotificationDetail.getEntity().getDistributionQuantity(),distributionNotificationDetail.getEntity().getCancelQuantity());
                    this.addBuyerForcastDeliverDetail(buyerForcastDeliverDetailList, distributionNotificationDetail, blackboard, param.getReceiptDate(), newDelayQty);
                }
            }
        } else if (param.getReturnMode().toString().equals(BuyerReturnMode.PART.getCode())) {// 部分
            List<ORDR0803ShipIBean> shipList = param.getShipList();//  发货单
            if (CollectionUtils.isNotEmpty(shipList)) {
                for (ORDR0803ShipIBean shipIBean : shipList) {
                    List<ORDR0803ProductBean> productBeanLis = shipIBean.getProductList();// 商品
                    if (CollectionUtils.isNotEmpty(productBeanLis)) {
                        for (ORDR0803ProductBean productBean : productBeanLis) {
                            Long shipDetailId = productBean.getShipDetailId();
                            DistributionNotificationDetail distributionNotificationDetail = new DistributionNotificationDetail(shipDetailId);
                            distributionNotificationDetail.setBlackboard(blackboard);
                            distributionNotificationDetail.complete(false);
                            this.addBuyerForcastDeliverDetail(buyerForcastDeliverDetailList, distributionNotificationDetail, blackboard, param.getReceiptDate(), productBean.getReturnQty());
                        }
                    }
                }
            }
        }
        return buyerForcastDeliverDetailList;
    }

    /**
     * 添加预配送明细
     *
     * @param buyerForcastDeliverDetailList
     * @param distributionNotificationDetail
     * @param blackboard
     */
    public void addBuyerForcastDeliverDetail(List<BuyerForcastDeliverDetail> buyerForcastDeliverDetailList, DistributionNotificationDetail distributionNotificationDetail, Blackboard blackboard, String receiptDate, BigDecimal newDelayQty) {
        BuyerForcastDeliverDetail buyerForcastDeliverDetail = distributionNotificationDetail.getBuyerForcastDeliverDetail(); //预配送明细
        BuyerForcastDeliverDetailEntity buyerForcastDeliverDetailEntity = buyerForcastDeliverDetail.getEntity();
        BigDecimal oldDelayedQty = buyerForcastDeliverDetailEntity.getDelayQuantity();
        BigDecimal sum = DecimalUtils.add(oldDelayedQty, newDelayQty);
        buyerForcastDeliverDetailEntity.setDelayQuantity(sum);
        buyerForcastDeliverDetail.setBlackboard(blackboard);
        buyerForcastDeliverDetailList.add(buyerForcastDeliverDetail);// 修改
        if (DecimalUtils.gt(newDelayQty, new BigDecimal(0))) {// 生成新的预配送明细
            BuyerForcastDeliverDetailAttachedEntity buyerForcastDeliverDetailAttachedEntity = buyerForcastDeliverDetail.getAttachedEntity();
            BuyerForcastDeliverDetailEntity new_buyerForcastDeliverDetailEntity = new BuyerForcastDeliverDetailEntity();// 主表
            BuyerForcastDeliverDetailAttachedEntity new_buyerForcastDeliverDetailAttachedEntity = new BuyerForcastDeliverDetailAttachedEntity();// 附表
            BeanUtils.copyProperties(buyerForcastDeliverDetailEntity, new_buyerForcastDeliverDetailEntity);
            BeanUtils.copyProperties(buyerForcastDeliverDetailAttachedEntity, new_buyerForcastDeliverDetailAttachedEntity);

            new_buyerForcastDeliverDetailEntity.setBuyerForcastDeliverDetailId(null);
            new_buyerForcastDeliverDetailEntity.setReceiveQuantity(null);// 收货
            new_buyerForcastDeliverDetailEntity.setDelayQuantity(null);// 迟收
            new_buyerForcastDeliverDetailEntity.setRejectQuantity(null);// 拒收
            new_buyerForcastDeliverDetailEntity.setRealSendQuantity(null);
            new_buyerForcastDeliverDetailEntity.setCrtId(null);
            new_buyerForcastDeliverDetailEntity.setCrtTime(null);
            new_buyerForcastDeliverDetailEntity.setUpdId(null);
            new_buyerForcastDeliverDetailEntity.setUpdTime(null);
            new_buyerForcastDeliverDetailEntity.setVersion(0);
            new_buyerForcastDeliverDetailEntity.setRedistributionDate(DateUtils.parseDate(receiptDate));
            new_buyerForcastDeliverDetailEntity.setPlanSendQuantity(newDelayQty);// 计划发货
            new_buyerForcastDeliverDetailEntity.setForcastType(ForcastType.LATE_DISTRIBUTION.getCode());//迟收再配送

            new_buyerForcastDeliverDetailAttachedEntity.setBuyerForcastDeliverDetailId(null);
            new_buyerForcastDeliverDetailAttachedEntity.setCrtId(null);
            new_buyerForcastDeliverDetailAttachedEntity.setCrtTime(null);
            new_buyerForcastDeliverDetailAttachedEntity.setUpdId(null);
            new_buyerForcastDeliverDetailAttachedEntity.setUpdTime(null);
            new_buyerForcastDeliverDetailAttachedEntity.setVersion(0);

            BuyerForcastDeliverDetail new_buyerForcastDeliverDetail = new BuyerForcastDeliverDetail(new_buyerForcastDeliverDetailEntity, new_buyerForcastDeliverDetailAttachedEntity);
            new_buyerForcastDeliverDetail.setBlackboard(blackboard);
            buyerForcastDeliverDetailList.add(new_buyerForcastDeliverDetail);// 新增
        }
    }


    /**
     * 根据迟收退货的数量与对应配送通知明细中数量、分批订单明细的数量进行对比判定，若全部迟收，对应的配送单、分批订单需要更新状态为全部迟收
     * 配送通知单状态
     *
     * @param distributionNotification
     * @return
     */
    public DistributionNotification getDistributionNotification(DistributionNotification distributionNotification) {
        DistributionNotificationEntity distributionNotificationEntity = distributionNotification.getEntity();
        List<DistributionNotificationDetail> distributionNotificationDetailList = distributionNotification.getDistributionNotificationDetails();
        BigDecimal allDistributionQuantity = null;// 所有配送数量
        for (DistributionNotificationDetail distributionNotificationDetail : distributionNotificationDetailList) {
            DistributionNotificationDetailEntity distributionNotificationDetailEntity = distributionNotificationDetail.getEntity();
            BigDecimal distributionQuantity = DecimalUtils.subtract(distributionNotificationDetailEntity.getDistributionQuantity(),distributionNotificationDetailEntity.getCancelQuantity());
            allDistributionQuantity = DecimalUtils.add(allDistributionQuantity, distributionQuantity);
        }
        BigDecimal allReceiveQty = null;
        BigDecimal allDelayQty = null;
        BigDecimal allRejectQty = null;
        List<ReceiveNotification> receiveNotificationList = distributionNotification.getReceiveNotifications();
        for (ReceiveNotification receiveNotification : receiveNotificationList) {
            List<ReceiveNotificationDetail> receiveNotificationDetailList = receiveNotification.getReceiveNotificationDetails();
            for (ReceiveNotificationDetail receiveNotificationDetail : receiveNotificationDetailList) {
                ReceiveNotificationDetailEntity receiveNotificationDetailEntity = receiveNotificationDetail.getEntity();
                BigDecimal receiveQuantity = receiveNotificationDetailEntity.getReceiveQuantity();
                BigDecimal delayQty = receiveNotificationDetailEntity.getDelayQuantity();
                BigDecimal rejectQty = receiveNotificationDetailEntity.getRejectQuantity();
                allReceiveQty = DecimalUtils.add(allReceiveQty, receiveQuantity);
                allDelayQty = DecimalUtils.add(allDelayQty, delayQty);
                allRejectQty = DecimalUtils.add(allRejectQty, rejectQty);
            }
        }
        BigDecimal realReceiveQty = DecimalUtils.add(DecimalUtils.add(allReceiveQty, allRejectQty), allDelayQty);
        if (DecimalUtils.eq(allDelayQty, allDistributionQuantity)) {// 全部迟收
            distributionNotificationEntity.setDistributionNotificationStu(DistributionNotificationStu.ALL_LATE_RECEIPT.getCode());
        } else if (DecimalUtils.lt(realReceiveQty, allDistributionQuantity)) { // 收货<配送数量  部分收货
            distributionNotificationEntity.setDistributionNotificationStu(DistributionNotificationStu.PARTIAL_RECEIPT.getCode());
        } else if (DecimalUtils.eq(realReceiveQty, allDistributionQuantity)) { // 收货数量+迟收=配送数量  完成
            distributionNotificationEntity.setDistributionNotificationStu(DistributionNotificationStu.RECEIPT_FINISH.getCode());
        }
        return distributionNotification;
    }

    /**
     * 判断 分配订单的状态
     *
     * @param distributionNotification
     * @return
     */
    public Collection<BuyerBatchOrder> getBatchBuyerOrderList(DistributionNotification distributionNotification, List<Long> buyerForcastDeliverDetailIdList) {
        Map<Long, BuyerBatchOrder> buyerBatchOrderMap = new HashMap<>();
        List<DistributionNotificationDetail> distributionNotificationDetails = distributionNotification
                .getDistributionNotificationDetails();
        for (DistributionNotificationDetail distributionNotificationDetail : distributionNotificationDetails) {
            BuyerBatchOrder buyerBatchOrder = distributionNotificationDetail.getBuyerForcastDeliverDetail()
                    .getBuyerBatchOrder();
            Long buyerBatchOrderId = buyerBatchOrder.getEntity().getBuyerBatchOrderId();
            BuyerBatchOrder mapOfBuyerBatchOrder = buyerBatchOrderMap.get(buyerBatchOrderId);
            if (mapOfBuyerBatchOrder == null) {
                buyerBatchOrderMap.put(buyerBatchOrderId, buyerBatchOrder);
            }
        }
        Collection<BuyerBatchOrder> buyerBatchOrderList = buyerBatchOrderMap.values();
        for (BuyerBatchOrder buyerBatchOrder : buyerBatchOrderList) {
            BigDecimal batchOrderPRealSendQuantity = BigDecimal.ZERO; // 应该发货数量
            BigDecimal batchOrderReceiveQuantity = BigDecimal.ZERO;  // 收货数量
            BigDecimal batchOrderRejectQuantity = BigDecimal.ZERO;  // 拒收数量
            BigDecimal batchOrderDelayQuantity = BigDecimal.ZERO;  // 迟收数量
            List<BuyerForcastDeliverDetail> forcastDeliverDetails = buyerBatchOrder.getBuyerForcastDeliverDetails();
            for (BuyerForcastDeliverDetail buyerForcastDeliverDetail : forcastDeliverDetails) {  //预配送明细 为判断单位
                BuyerForcastDeliverDetailEntity buyerForcastDeliverDetailEntity = buyerForcastDeliverDetail.getEntity();
                Long buyerForcastDeliverDetailId = buyerForcastDeliverDetailEntity.getBuyerForcastDeliverDetailId();
                BigDecimal realSendQuantity = buyerForcastDeliverDetailEntity.getRealSendQuantity();
                BigDecimal receiveQuantity = buyerForcastDeliverDetailEntity.getReceiveQuantity();
                BigDecimal rejectQuantity = buyerForcastDeliverDetailEntity.getRejectQuantity();
                BigDecimal delayQuantity = buyerForcastDeliverDetailEntity.getDelayQuantity();
                if (!buyerBatchOrderList.contains(buyerForcastDeliverDetailId)) {// 不是新生成的
                    batchOrderPRealSendQuantity = DecimalUtils.add(batchOrderPRealSendQuantity, realSendQuantity);
                    batchOrderReceiveQuantity = DecimalUtils.add(batchOrderReceiveQuantity, receiveQuantity);
                    batchOrderRejectQuantity = DecimalUtils.add(batchOrderRejectQuantity, rejectQuantity);
                    batchOrderDelayQuantity = DecimalUtils.add(batchOrderDelayQuantity, delayQuantity);
                }
            }
            if (DecimalUtils.gt(batchOrderDelayQuantity, BigDecimal.ZERO) && DecimalUtils.eq(batchOrderPRealSendQuantity, batchOrderDelayQuantity)) {
                buyerBatchOrder.getEntity().setBuyerBatchOrderStu(BuyerBatchOrderStu.ALL_LATE_RECEIPT.getCode());   // 全部迟收
            } else if (DecimalUtils.gt(batchOrderReceiveQuantity, BigDecimal.ZERO) && DecimalUtils.gt(batchOrderPRealSendQuantity, batchOrderDelayQuantity)) {// 有收货 有迟收
                buyerBatchOrder.getEntity().setBuyerBatchOrderStu(BuyerBatchOrderStu.PARTIAL_RECEIPT.getCode());   // 部分收货
            }
        }

        return buyerBatchOrderList;
    }


    /**
     * @param returnReasonId
     * @param blackboard
     */
    public void checkReturnReason(Long returnReasonId, Blackboard blackboard) {
        ReturnReason returnReason = new ReturnReason(returnReasonId);
        returnReason.setBlackboard(blackboard);
        returnReason.complete(false);
        if (!returnReason.isDataSynced()) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080311);
        }
        ReturnReasonEntity returnReasonEntity = returnReason.getEntity();
        String applyObject = returnReasonEntity.getApplyObject();//适用对象 [使用对象,001-买家，002-买手]
        String applyType = returnReasonEntity.getApplyType();//获取适用类型 [以逗号分隔的退货类型]
        if (!(applyObject != null && applyObject.contains(ApplyObject.BUYER.getCode()))) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080312);
        }
        if (!(applyType != null && applyType.contains(BuyerReturnType.DELAY_RETURN.getCode()))) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080312);
        }
    }


    /**
     * 获取对应的 收货和收货明细
     *
     * @param distributionNotification
     * @param param
     * @return
     */
    public Map<String, Object> getReceiveNotificationList(DistributionNotification distributionNotification, ORDR0803IBean param) {
        Map<String, Object> map = new HashMap<>();
        BigDecimal returnAmount = BigDecimal.ZERO;
        List<ReceiveNotification> receiveNotificationList = new ArrayList<>();
        String distributionNotificationCode = distributionNotification.getEntity().getDistributionNotificationCode();
        if (param.getReturnMode().toString().equals(BuyerReturnMode.ALL.getCode())) {// 全部
            List<SendNotification> sendNotifications = distributionNotification.getSendNotifications();
            for (SendNotification sendNotification : sendNotifications) {// 发货单：收货单  1:1
                SendNotificationEntity sendNotificationEntity = sendNotification.getEntity();
                ReceiveNotification receiveNotification = this.getReceiveNotificationByDeliverCodeAndDistributionNotificationCode(distributionNotification.getReceiveNotifications(), sendNotificationEntity.getSendNotificationCode(), distributionNotificationCode);
                if (receiveNotification == null) {// 没有生成收货单
                    ReceiveNotificationEntity receiveNotificationEntity = new ReceiveNotificationEntity();// 新建
                    receiveNotificationEntity.setDistributionNotificationCode(distributionNotification.getEntity().getDistributionNotificationCode());// 配送单
                    receiveNotificationEntity.setDistributionNotificationId(new Long(param.getShipId()));// 配送单id
                    receiveNotificationEntity.setSendNotificationCode(sendNotification.getEntity().getSendNotificationCode());// 发货单id
                    receiveNotificationEntity.setSendNotificationId(sendNotification.getEntity().getSendNotificationId());// 发货单编码
                    receiveNotification = new ReceiveNotification(receiveNotificationEntity);
                    receiveNotification.setBlackboard(distributionNotification.getBlackboard());
                }
                List<SendNotificationDetail> sendNotificationDetails = sendNotification.getSendNotificationDetails();
                List<ReceiveNotificationDetail> receiveNotificationDetails = new ArrayList<>();
                for (SendNotificationDetail sendNotificationDetail : sendNotificationDetails) {
                    DistributionNotificationDetail distributionNotificationDetail = sendNotificationDetail.getDistributionNotificationDetail();
                    DistributionNotificationDetailEntity distributionNotificationDetailEntity = distributionNotificationDetail.getEntity();
                    Long distributionNotificationDetailId = distributionNotificationDetailEntity.getDistributionNotificationDetailId();
                    BuyerBatchOrderDetail buyerBatchOrderDetail = distributionNotificationDetail.getBuyerForcastDeliverDetail().getBuyerBatchOrderDetail();
                    BigDecimal realUnitPrice = buyerBatchOrderDetail.getEntity().getRealUnitPrice();// 迟收单价
                    ReceiveNotificationDetail receiveNotificationDetail = this.getReceiveNotificationDetailByDistributionNotificationDetailId(receiveNotification, distributionNotificationDetailId);
                    if (receiveNotificationDetail != null) {// 已经生成
                        ReceiveNotificationDetailEntity receiveNotificationDetailEntity = receiveNotificationDetail.getEntity();
                        receiveNotificationDetailEntity.setDelayQuantity(sendNotificationDetail.getEntity().getRealSendQuantity());// 累加迟收
                        receiveNotificationDetailEntity.setPricePlateUnitPrice(realUnitPrice);
                        BuyerReturnDetailEntity buyerReturnDetailEntity = new BuyerReturnDetailEntity();
                        buyerReturnDetailEntity.setDistributionNotificationId(distributionNotificationDetailEntity.getDistributionNotificationId());//配送单ID
                        buyerReturnDetailEntity.setDistributionNotificationDetailId(distributionNotificationDetailEntity.getDistributionNotificationDetailId());//配送明细ID
                        buyerReturnDetailEntity.setGoodsId(distributionNotificationDetailEntity.getGoodsId());//商品ID
                        buyerReturnDetailEntity.setSalesUnit(distributionNotificationDetailEntity.getGoodsUnit());//销售单位
                        buyerReturnDetailEntity.setReturnQty(DecimalUtils.subtract(distributionNotificationDetailEntity.getDistributionQuantity(),distributionNotificationDetailEntity.getCancelQuantity()));//退货数量
                        buyerReturnDetailEntity.setReceiveNotificationDetailId(receiveNotificationDetailEntity.getReceiveNotificationDetailId());
                        BuyerReturnDetail buyerReturnDetail = new BuyerReturnDetail(buyerReturnDetailEntity);
                        buyerReturnDetail.setBlackboard(distributionNotification.getBlackboard());
                        List<BuyerReturnDetail> buyerReturnDetailList = new ArrayList<>();
                        buyerReturnDetailList.add(buyerReturnDetail);
                        receiveNotificationDetail.link(buyerReturnDetailList);                                    // 绑定配送明细
                        receiveNotificationDetail.buyerReturnDetailsLinked();
                    } else {// 没有生成
                        ReceiveNotificationDetailEntity receiveNotificationDetailEntity = new ReceiveNotificationDetailEntity();
                        receiveNotificationDetailEntity.setReceiveNotificationId(receiveNotification.getEntity().getReceiveNotificationId());
                        receiveNotificationDetailEntity.setDistributionNotificationDetailId(distributionNotificationDetailEntity.getDistributionNotificationDetailId());//配送明细ID
                        receiveNotificationDetailEntity.setGoodsId(distributionNotificationDetailEntity.getGoodsId());//商品ID
                        receiveNotificationDetailEntity.setSku(distributionNotificationDetailEntity.getSku());//
                        receiveNotificationDetailEntity.setBatch(distributionNotificationDetailEntity.getBatchCode());//批次	BATCH
                        receiveNotificationDetailEntity.setDelayQuantity(DecimalUtils.subtract(distributionNotificationDetailEntity.getDistributionQuantity(), distributionNotificationDetailEntity.getCancelQuantity()));
                        receiveNotificationDetailEntity.setPricePlateUnitPrice(realUnitPrice);// 价盘单价
                        receiveNotificationDetail = new ReceiveNotificationDetail(receiveNotificationDetailEntity);
                        receiveNotificationDetail.setBlackboard(distributionNotification.getBlackboard());
                        BuyerReturnDetailEntity buyerReturnDetailEntity = new BuyerReturnDetailEntity();
                        buyerReturnDetailEntity.setDistributionNotificationId(distributionNotificationDetailEntity.getDistributionNotificationId());//配送单ID
                        buyerReturnDetailEntity.setDistributionNotificationDetailId(distributionNotificationDetailEntity.getDistributionNotificationDetailId());//配送明细ID
                        buyerReturnDetailEntity.setGoodsId(distributionNotificationDetailEntity.getGoodsId());//商品ID
                        buyerReturnDetailEntity.setSalesUnit(distributionNotificationDetailEntity.getGoodsUnit());//销售单位
                        buyerReturnDetailEntity.setReturnQty(DecimalUtils.subtract(distributionNotificationDetailEntity.getDistributionQuantity(), distributionNotificationDetailEntity.getCancelQuantity()));//退货数量
                        BuyerReturnDetail buyerReturnDetail = new BuyerReturnDetail(buyerReturnDetailEntity);
                        buyerReturnDetail.setBlackboard(distributionNotification.getBlackboard());
                        List<BuyerReturnDetail> buyerReturnDetailList = new ArrayList<>();
                        buyerReturnDetailList.add(buyerReturnDetail);
                        receiveNotificationDetail.link(buyerReturnDetailList);                                    // 绑定配送明细
                        receiveNotificationDetail.buyerReturnDetailsLinked();


                    }
                    receiveNotificationDetails.add(receiveNotificationDetail);
                    BigDecimal returnDetailAmount = DecimalUtils.multiply(realUnitPrice, DecimalUtils.subtract(distributionNotificationDetailEntity.getDistributionQuantity(), distributionNotificationDetailEntity.getCancelQuantity()));// 单个明细 退货金额
                    returnAmount = DecimalUtils.add(returnAmount, returnDetailAmount);//  累加
                }
                receiveNotification.link(receiveNotificationDetails);
                receiveNotification.receiveNotificationDetailsLinked();
                receiveNotificationList.add(receiveNotification);
            }
        } else if (param.getReturnMode().toString().equals(BuyerReturnMode.PART.getCode())) {// 部分
            List<SendNotification> sendNotificationList = distributionNotification.getSendNotifications();
            List<ORDR0803ShipIBean> shipList = param.getShipList();
            for (ORDR0803ShipIBean ship : shipList) {
                String deliverCode = ship.getDeliverCode();// 发货单编码
                SendNotification sendNotification = this.getSendNotificationByDeliverCode(sendNotificationList, deliverCode);// 发货单
                ReceiveNotification receiveNotification = this.getReceiveNotificationByDeliverCodeAndDistributionNotificationCode(distributionNotification.getReceiveNotifications(), deliverCode, distributionNotificationCode);
                if (receiveNotification == null) {// 数据库不存在
                    ReceiveNotificationEntity receiveNotificationEntity = new ReceiveNotificationEntity();// 新建
                    receiveNotificationEntity.setDistributionNotificationCode(distributionNotification.getEntity().getDistributionNotificationCode());// 配送单
                    receiveNotificationEntity.setDistributionNotificationId(new Long(param.getShipId()));// 配送单id
                    receiveNotificationEntity.setSendNotificationCode(sendNotification.getEntity().getSendNotificationCode());// 发货单id
                    receiveNotificationEntity.setSendNotificationId(sendNotification.getEntity().getSendNotificationId());// 发货单编码
                    receiveNotification = new ReceiveNotification(receiveNotificationEntity);
                    receiveNotification.setBlackboard(distributionNotification.getBlackboard());
                }
                List<ORDR0803ProductBean> productList = ship.getProductList();
                List<ReceiveNotificationDetail> receiveNotificationDetails = new ArrayList<>();
                for (ORDR0803ProductBean product : productList) {// 对应的发货明细
                    Long shipDetailId = product.getShipDetailId();
                    DistributionNotificationDetail distributionNotificationDetail = new DistributionNotificationDetail(shipDetailId);// 配送明细
                    distributionNotificationDetail.setBlackboard(distributionNotification.getBlackboard());
                    distributionNotificationDetail.complete(false);
                    DistributionNotificationDetailEntity distributionNotificationDetailEntity = distributionNotificationDetail.getEntity();
                    Long distributionNotificationDetailId = distributionNotificationDetailEntity.getDistributionNotificationDetailId();
                    ReceiveNotificationDetail receiveNotificationDetail = this.getReceiveNotificationDetailByDistributionNotificationDetailId(receiveNotification, distributionNotificationDetailEntity.getDistributionNotificationDetailId());
                    BuyerBatchOrderDetail buyerBatchOrderDetail = distributionNotificationDetail.getBuyerForcastDeliverDetail().getBuyerBatchOrderDetail();
                    BigDecimal realUnitPrice = buyerBatchOrderDetail.getEntity().getRealUnitPrice();// 迟收单价
                    BigDecimal qty = product.getReturnQty();
                    if (receiveNotificationDetail != null) {
                        ReceiveNotificationDetailEntity receiveNotificationDetailEntity = receiveNotificationDetail.getEntity();
                        BigDecimal delayQty = receiveNotificationDetailEntity.getDelayQuantity();// 已经迟收
                        receiveNotificationDetailEntity.setDelayQuantity(DecimalUtils.add(delayQty, qty));// 累加迟收
                        receiveNotificationDetailEntity.setPricePlateUnitPrice(realUnitPrice);
                        BuyerReturnDetailEntity buyerReturnDetailEntity = new BuyerReturnDetailEntity();
                        buyerReturnDetailEntity.setReceiveNotificationDetailId(receiveNotificationDetailEntity.getReceiveNotificationDetailId());
                        buyerReturnDetailEntity.setDistributionNotificationId(distributionNotificationDetailEntity.getDistributionNotificationId());//配送单ID
                        buyerReturnDetailEntity.setDistributionNotificationDetailId(distributionNotificationDetailEntity.getDistributionNotificationDetailId());//配送明细ID
                        buyerReturnDetailEntity.setGoodsId(distributionNotificationDetailEntity.getGoodsId());//商品ID
                        buyerReturnDetailEntity.setSalesUnit(distributionNotificationDetailEntity.getGoodsUnit());//销售单位
                        buyerReturnDetailEntity.setReturnQty(product.getReturnQty());//退货数量
                        buyerReturnDetailEntity.setReasonId(product.getDetailReasonID());// 原因id
                        BuyerReturnDetail buyerReturnDetail = new BuyerReturnDetail(buyerReturnDetailEntity);
                        buyerReturnDetail.setBlackboard(distributionNotification.getBlackboard());
                        List<BuyerReturnDetail> buyerReturnDetailList = new ArrayList<>();
                        buyerReturnDetailList.add(buyerReturnDetail);
                        receiveNotificationDetail.link(buyerReturnDetailList);                                    // 绑定配送明细
                        receiveNotificationDetail.buyerReturnDetailsLinked();
                    } else {
                        ReceiveNotificationDetailEntity receiveNotificationDetailEntity = new ReceiveNotificationDetailEntity();
                        receiveNotificationDetailEntity.setReceiveNotificationId(receiveNotification.getEntity().getReceiveNotificationId());
                        receiveNotificationDetailEntity.setDistributionNotificationDetailId(distributionNotificationDetailId);//配送明细ID
                        receiveNotificationDetailEntity.setGoodsId(distributionNotificationDetailEntity.getGoodsId());//商品ID
                        receiveNotificationDetailEntity.setSku(distributionNotificationDetailEntity.getSku());//
                        receiveNotificationDetailEntity.setBatch(distributionNotificationDetailEntity.getBatchCode());//批次	BATCH
                        receiveNotificationDetailEntity.setDelayQuantity(product.getReturnQty());// 设置迟收数量
                        receiveNotificationDetailEntity.setPricePlateUnitPrice(realUnitPrice);// 价盘单价
                        receiveNotificationDetail = new ReceiveNotificationDetail(receiveNotificationDetailEntity);
                        receiveNotificationDetail.setBlackboard(distributionNotification.getBlackboard());
                        BuyerReturnDetailEntity buyerReturnDetailEntity = new BuyerReturnDetailEntity();
                        buyerReturnDetailEntity.setDistributionNotificationId(distributionNotificationDetailEntity.getDistributionNotificationId());//配送单ID
                        buyerReturnDetailEntity.setDistributionNotificationDetailId(distributionNotificationDetailEntity.getDistributionNotificationDetailId());//配送明细ID
                        buyerReturnDetailEntity.setGoodsId(distributionNotificationDetailEntity.getGoodsId());//商品ID
                        buyerReturnDetailEntity.setSalesUnit(distributionNotificationDetailEntity.getGoodsUnit());//销售单位
                        buyerReturnDetailEntity.setReturnQty(product.getReturnQty());//退货数量
                        buyerReturnDetailEntity.setReasonId(product.getDetailReasonID());// 原因id
                        BuyerReturnDetail buyerReturnDetail = new BuyerReturnDetail(buyerReturnDetailEntity);
                        buyerReturnDetail.setBlackboard(distributionNotification.getBlackboard());
                        List<BuyerReturnDetail> buyerReturnDetailList = new ArrayList<>();
                        buyerReturnDetailList.add(buyerReturnDetail);
                        receiveNotificationDetail.link(buyerReturnDetailList);                                    // 绑定配送明细
                        receiveNotificationDetail.buyerReturnDetailsLinked();
                    }
                    receiveNotificationDetails.add(receiveNotificationDetail);
                    BigDecimal returnDetailAmount = DecimalUtils.multiply(realUnitPrice, product.getReturnQty());// 单个明细 退货金额
                    returnAmount = DecimalUtils.add(returnAmount, returnDetailAmount);//  累加
                }
                receiveNotification.link(receiveNotificationDetails);
                receiveNotification.receiveNotificationDetailsLinked();
                receiveNotificationList.add(receiveNotification);
            }
        }
        map.put("receiveNotificationList", receiveNotificationList);
        map.put("returnAmount", returnAmount);
        return map;
    }


    /**
     * 获取数据库中的收货
     *
     * @param receiveNotificationList
     * @param deliverCode
     * @return
     */
    public ReceiveNotification getReceiveNotificationByDeliverCodeAndDistributionNotificationCode(List<ReceiveNotification> receiveNotificationList, String deliverCode, String distributionNotificationCode) {
        ReceiveNotification receiveNotification = null;
        if (CollectionUtils.isNotEmpty(receiveNotificationList)) {
            for (ReceiveNotification receive : receiveNotificationList) {
                ReceiveNotificationEntity receiveNotificationEntity = receive.getEntity();
                String dbistributionNotificationCode = receiveNotificationEntity.getDistributionNotificationCode();
                String dbSendNotificationCode = receiveNotificationEntity.getSendNotificationCode();
                if (deliverCode.equals(dbSendNotificationCode) && distributionNotificationCode.equals(dbistributionNotificationCode)) {
                    receiveNotification = receive;
                    break;
                }
            }
        }
        return receiveNotification;
    }

    /**
     * 获取发货单 根据发货单code
     *
     * @param sendNotificationList
     * @param deliverCode
     * @return
     */
    public SendNotification getSendNotificationByDeliverCode(List<SendNotification> sendNotificationList, String deliverCode) {
        SendNotification sendNotification = null;
        for (SendNotification send : sendNotificationList) {
            String sendNotificationCode = send.getEntity().getSendNotificationCode();
            if (deliverCode.equals(sendNotificationCode)) {
                sendNotification = send;
                break;
            }
        }
        return sendNotification;
    }


    /**
     * 根据配送明细获取
     *
     * @param receiveNotification
     * @param distributionNotificationDetailId
     * @return
     */
    public ReceiveNotificationDetail getReceiveNotificationDetailByDistributionNotificationDetailId(ReceiveNotification receiveNotification, Long distributionNotificationDetailId) {
        List<ReceiveNotificationDetail> receiveNotificationDetailList = receiveNotification.getReceiveNotificationDetails();
        if (CollectionUtils.isNotEmpty(receiveNotificationDetailList)) {
            for (ReceiveNotificationDetail receiveNotificationDetail : receiveNotificationDetailList) {
                Long dbDistributionNotificationDetailId = receiveNotificationDetail.getEntity().getDistributionNotificationDetailId();
                if (dbDistributionNotificationDetailId.equals(distributionNotificationDetailId)) {
                    return receiveNotificationDetail;
                }
            }
        }
        return null;
    }


}
