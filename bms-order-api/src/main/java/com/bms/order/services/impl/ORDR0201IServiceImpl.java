package com.bms.order.services.impl;

import com.bms.order.archive.impl.*;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.*;
import com.bms.order.bean.param.ORDR0201IBeanParam;
import com.bms.order.constant.OrderConst;
import com.bms.order.constant.enumeration.BuyerBatchOrderStu;
import com.bms.order.constant.enumeration.BuyerOrderStu;
import com.bms.order.constant.enumeration.ForcastType;
import com.bms.order.constant.enumeration.SellSideType;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.*;
import com.bms.order.external.archive.Bs;
import com.bms.order.external.archive.Goods;
import com.bms.order.services.ORDR0201IService;
import com.bms.order.util.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DecimalUtils;
import com.framework.core.utils.NumberUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 订单分拆单创建接口Service
 *
 * @author li_huiqian
 */
@Service
public class ORDR0201IServiceImpl implements ORDR0201IService {

    @Autowired
    private BaseRedisDao redisDao;
    @Autowired
    private BuyerOrderDao buyerOrderDao;
    @Autowired
    private BuyerOrderAttachedDao buyerOrderAttachedDao;
    @Autowired
    private BuyerBatchOrderDao buyerBatchOrderDao;
    @Autowired
    private BuyerBatchOrderAttachedDao buyerBatchOrderAttachedDao;
    @Autowired
    private BuyerBatchOrderDetailDao buyerBatchOrderDetailDao;
    @Autowired
    private BuyerBatchOrderDetailAttachedDao buyerBatchOrderDetailAttachedDao;
    @Autowired
    private BuyerForcastDeliverDetailDao buyerForcastDeliverDetailDao;
    @Autowired
    private BuyerForcastDeliverDetailAttachedDao buyerForcastDeliverDetailAttachedDao;
    @Autowired
    private ORDR0201IDao dao;

    /**
     * 订单系统/平台订单人员对已确认的订单的分批订单进行分拆
     *
     * @param operator 操作者
     * @param param    ORDR0201IRestParam
     */
    @Transactional
    @Override
    public List<Long> execute(Operator operator, ORDR0201IBeanParam param) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();
        blackboard.setOperator(operator);
        map.put("param", param);
        map.put("blackboard", blackboard);
        List<BuyerForcastDeliverDetail> buyerForcastDeliverDetailList = new ArrayList<>();
        List<BuyerBatchOrderDetail> buyerBatchOrderDetails = param.getBuyerBatchOrderDetails(blackboard);
        for (BuyerBatchOrderDetail buyerBatchOrderDetail : buyerBatchOrderDetails) {
            map.put("buyerBatchOrderDetail", buyerBatchOrderDetail);
            pre(map);
            process(map);
            post(map);
            buyerForcastDeliverDetailList.addAll((List<BuyerForcastDeliverDetail>) map.get("buyerForcastDeliverDetailList"));
        }
        List<Long> list = new ArrayList<>();
        for (BuyerForcastDeliverDetail buyerForcastDeliverDetail : buyerForcastDeliverDetailList) {
            Long buyerForcastDeliverDetailId = buyerForcastDeliverDetail.getEntity().getBuyerForcastDeliverDetailId();
            list.add(buyerForcastDeliverDetailId);
        }
        return list;
    }

    /**
     * 准备
     *
     * @param map HashMap
     */
    private void pre(HashMap<String, Object> map) {
        // 获取参数
        @SuppressWarnings("unused")
        ORDR0201IBeanParam beanParam = (ORDR0201IBeanParam) map.get("param");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        BuyerBatchOrderDetail buyerBatchOrderDetail = (BuyerBatchOrderDetail) map.get("buyerBatchOrderDetail");
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
        // 操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);

        this.checkQtyAndMoney(beanParam, buyerBatchOrderDetail);
        List<BuyerForcastDeliverDetail> buyerForcastDeliverDetailList = beanParam.getBuyerForcastDeliverDetailList(buyerBatchOrderDetail.getEntity().getBuyerBatchOrderDetailId());
        /**
         * 业务验证
         */
        if (CollectionUtils.isNotEmpty(buyerForcastDeliverDetailList)) {
            BuyerForcastDeliverDetailEntity buyerForcastDeliverDetailEntity = buyerForcastDeliverDetailList.get(0).getEntity();
            Long buyerBatchOrderDetailId = buyerForcastDeliverDetailEntity.getBuyerBatchOrderDetailId();
            Long buyerBatchOrderId = buyerForcastDeliverDetailEntity.getBuyerBatchOrderId();
            for (BuyerForcastDeliverDetail buyerForcastDeliverDetail : buyerForcastDeliverDetailList) {
                buyerForcastDeliverDetail.setBlackboard(blackboard);
                BuyerForcastDeliverDetailEntity forcastDeliverDetailEntity = buyerForcastDeliverDetail.getEntity();
                Long batchOrderDetailId = forcastDeliverDetailEntity.getBuyerBatchOrderDetailId();
                if (!buyerBatchOrderDetailId.equals(batchOrderDetailId)) {

                }
                Long batchOrderId = forcastDeliverDetailEntity.getBuyerBatchOrderId();
                if (!buyerBatchOrderId.equals(batchOrderId)) {

                }
                BigDecimal planSendQuantity = buyerForcastDeliverDetail.getEntity().getPlanSendQuantity();
                if (DecimalUtils.le(planSendQuantity, new BigDecimal(0))) {
                    throw new BusinessException(ModuleCode.ORDR, ErrorCode.E020104);
                }
                String sellSideType = buyerForcastDeliverDetail.getEntity().getSellSideType();
                if (!(SellSideType.PLATFORM_TYPE.getCode().equals(sellSideType)
                        || SellSideType.AGENT_TYPE.getCode().equals(sellSideType))) {
                    throw new BusinessException(ModuleCode.ORDR, ErrorCode.E020105);
                }

                BuyerBatchOrderDetailEntity buyerBatchOrderDetailEntity = buyerBatchOrderDetail.getEntity();
                Long buyBatchOrderId = buyerBatchOrderDetailEntity.getBuyerBatchOrderId();
                if (buyBatchOrderId.longValue() != buyerForcastDeliverDetail.getEntity().getBuyerBatchOrderId()) {
                    throw new BusinessException(ModuleCode.ORDR, ErrorCode.E020107);
                }
                BuyerBatchOrder buyerBatchOrder = buyerBatchOrderDetail.getBuyerBatchOrder();
                if (buyerBatchOrder == null) {
                    throw new BusinessException(ModuleCode.ORDR, ErrorCode.E020107);
                }
                BuyerBatchOrderEntity buyerBatchOrderEntity = buyerBatchOrder.getEntity();
                String buyerBatchOrderStu = buyerBatchOrderEntity.getBuyerBatchOrderStu();
                if (!(BuyerBatchOrderStu.TO_SPLIT.getCode().equals(buyerBatchOrderStu)
                        || BuyerBatchOrderStu.SPLIT_CONFIRM.getCode().equals(buyerBatchOrderStu))) {
                    throw new BusinessException(ModuleCode.ORDR, ErrorCode.E020108);
                }
                this.externalCall(buyerForcastDeliverDetail);// 调用外部接口
                buyerBatchOrderDetailEntity.setManualSplitFlg(true);// 手动拆分
                buyerBatchOrderDetailEntity.setSplitFlg(true);// 拆分完成
                BuyerForcastDeliverDetailEntity entity = buyerForcastDeliverDetail.getEntity();
                buyerForcastDeliverDetail.link(buyerBatchOrderDetail);// 绑定分批订单明细
                buyerForcastDeliverDetail.buyerBatchOrderDetailLinked();// 关联完毕

                entity.setForcastType(ForcastType.STANDARD_SPLIT_DISTRIBUTION.getCode());// 设置 正常分拆预配送
                entity.setReturnQuantity(new BigDecimal(0));// 退货数量
                entity.setDelayQuantity(new BigDecimal(0));// 迟收数量
                entity.setRejectQuantity(new BigDecimal(0));// 拒收数量
                entity.setReceiveQuantity(new BigDecimal(0));// 收货数量
                entity.setRealSendQuantity(new BigDecimal(0));// 实际发货数量
            }
        }

        // 返回参数
        map.put("buyerForcastDeliverDetailList", buyerForcastDeliverDetailList);

    }

    /**
     * 执行
     *
     * @param map HashMap
     */
    private void process(HashMap<String, Object> map) {
        // 获取参数
        List<BuyerForcastDeliverDetail> buyerForcastDeliverDetailList = (List<BuyerForcastDeliverDetail>) map
                .get("buyerForcastDeliverDetailList");
        createBuyerForcastDeliverDetailList(buyerForcastDeliverDetailList);

        // 返回参数

    }

    /**
     * 收尾
     *
     * @param map HashMap
     */
    private void post(HashMap<String, Object> map) {
        // 获取参数

        // 返回参数

    }

    /**
     * 调用外部接口 补全 实体的信息
     *
     * @param buyerForcastDeliverDetail
     */
    private void externalCall(BuyerForcastDeliverDetail buyerForcastDeliverDetail) {
        BuyerForcastDeliverDetailEntity buyerForcastDeliverDetailEntity = buyerForcastDeliverDetail.getEntity();
        BuyerForcastDeliverDetailAttachedEntity attachedEntity = buyerForcastDeliverDetail.getAttachedEntity();
        String sellSideType = buyerForcastDeliverDetailEntity.getSellSideType();
        String sellSideId = buyerForcastDeliverDetailEntity.getSellSideId();
        // 供货主体 判断 获取名称 编码 平台 买手
        if (SellSideType.AGENT_TYPE.getCode().equals(sellSideType)) {// 买手
            Bs bs = Bs.getBsById(sellSideId);
            if (bs != null) {
                attachedEntity.setSellSideCode(bs.getEntity().getBsCode());
                attachedEntity.setSellSideName(bs.getEntity().getBsName());
            } else {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000002, "通过买手ID查找不到买手");
            }
        } else if (SellSideType.PLATFORM_TYPE.getCode().equals(sellSideType)) {// 平台
            if (!OrderConst.PLATFORM_ID.equals(sellSideId)) {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E020109);
            }
            attachedEntity.setSellSideCode(OrderConst.PLATFORM_CODE);
            attachedEntity.setSellSideName(OrderConst.PLATFORM_NAME);
        }

        /**
         * 2.2 根据商品ID，查询卖家产品，补足商品信息 2.3 根据卖家ID，查询补足卖家信息 2.4 根据生产商ID，查询补足生产商信息
         *
         */
        Goods goods = Goods.findBy3Id(buyerForcastDeliverDetailEntity.getGoodsId(),
                buyerForcastDeliverDetailEntity.getSellerId(), buyerForcastDeliverDetailEntity.getManufacturerId());
        BeanUtils.copyProperties(goods.getEntity(), attachedEntity);
    }

    /**
     * 验证  数量，钱
     *
     * @param
     */
    public BuyerBatchOrderDetail checkQtyAndMoney(ORDR0201IBeanParam param, BuyerBatchOrderDetail buyerBatchOrderDetail) {
        List<ORDR0201IBeanParam.ORDR0201SpiltDetail> spiltDetails = param.getSpiltDetails(buyerBatchOrderDetail.getEntity().getBuyerBatchOrderDetailId());
        BigDecimal totalPlanQty = this.getTotalPlanQty(spiltDetails);
        //线上订单款项未结清时，分拆单接口可以执行成功
        BigDecimal goodsQty = buyerBatchOrderDetail.getEntity().getGoodsQuantity();
        if (!DecimalUtils.eq(totalPlanQty, goodsQty)) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E020101);
        }
        BuyerOrder buyerOrder = buyerBatchOrderDetail.getBuyerOrder();
        BuyerOrderEntity buyerOrderEntity = buyerOrder.getEntity();
        BigDecimal receiveAmount = buyerOrderEntity.getReceiveAmount();// 已收金额
        BigDecimal advancePaymentAmount = buyerOrderEntity.getAdvancePaymentAmount();//应预付金额
        BigDecimal earnestAmount = buyerOrderEntity.getEarnestAmount();
        if (DecimalUtils.lt(receiveAmount, DecimalUtils.add(advancePaymentAmount, earnestAmount))) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E020102);
        }
        return buyerBatchOrderDetail;
    }

    /**
     * 获取总的的计划量
     *
     * @param spiltDetails
     * @return
     */
    private BigDecimal getTotalPlanQty(List<ORDR0201IBeanParam.ORDR0201SpiltDetail> spiltDetails) {
        BigDecimal totalPlanQty = null;
        for (ORDR0201IBeanParam.ORDR0201SpiltDetail spiltDetail : spiltDetails) {
            BigDecimal planSendQuantity = spiltDetail.getPlanSendQuantity();
            totalPlanQty = DecimalUtils.add(planSendQuantity, totalPlanQty);
        }
        return totalPlanQty;
    }

    private void createBuyerForcastDeliverDetailList(List<BuyerForcastDeliverDetail> buyerForcastDeliverDetailList) {
        if (CollectionUtils.isNotEmpty(buyerForcastDeliverDetailList)) {
            for (BuyerForcastDeliverDetail deliverDetail : buyerForcastDeliverDetailList) {
                deliverDetail.create();
            }
            // 修改状态
            BuyerForcastDeliverDetail deliverDetail = buyerForcastDeliverDetailList.get(0);
            BuyerBatchOrderDetail buyerBatchOrderDetail = deliverDetail.getBuyerBatchOrderDetail();
            buyerBatchOrderDetail.modify();// 修改
            Boolean splitFlg = buyerBatchOrderDetail.getEntity().getSplitFlg();
            if (splitFlg == null) {
                splitFlg = false;
            }
            if (splitFlg) {
                BuyerBatchOrder buyerBatchOrder = deliverDetail.getBuyerBatchOrder();// 更改分批订单状态
                List<BuyerBatchOrderDetail> buyerBatchOrderDetails = buyerBatchOrder.getBuyerBatchOrderDetails();
                Boolean flg = false;
                for (BuyerBatchOrderDetail orderDetail : buyerBatchOrderDetails) {
                    if (orderDetail.getEntity().getSplitFlg() == null || !orderDetail.getEntity().getSplitFlg()) {
                        flg = true;
                        break;
                    }
                }
                if (flg) {
                    // 部分分拆
                    buyerBatchOrder.getEntity().setBuyerBatchOrderStu(BuyerBatchOrderStu.PART_SPLIT.getCode());
                } else {
                    // 首单判断 整个订单有符合首单条件，分批即为待确认
                    Integer count = dao.getOtherOrderCount(buyerBatchOrder.getBuyerOrder().getEntity());
                    if (count > NumberUtils.INTEGER_ZERO) {
                        buyerBatchOrder.getEntity().setBuyerBatchOrderStu(BuyerBatchOrderStu.SPLIT_CONFIRM.getCode());
                    } else {
                        buyerBatchOrder.getEntity().setBuyerBatchOrderStu(BuyerBatchOrderStu.CONFIRMED.getCode());
                    }
                }
                buyerBatchOrder.modify();
            }
            BuyerOrder buyerOrder = deliverDetail.getBuyerBatchOrder().getBuyerOrder();// 更改订单状态
            buyerOrder.getEntity().setBuyerOrderStu(BuyerOrderStu.NOT_COMPLETED.getCode());
            buyerOrder.modify();
        }
    }
}
