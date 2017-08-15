package com.bms.order.services.impl;

import com.bms.order.archive.impl.BsOrder;
import com.bms.order.archive.impl.BsOrderDetail;
import com.bms.order.archive.impl.Operator;
import com.bms.order.archive.impl.list.BsOrderDetailList;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.param.ORDR0606IBeanParam;
import com.bms.order.constant.OrderConst;
import com.bms.order.constant.enumeration.BsOrderStu;
import com.bms.order.constant.enumeration.OperatorType;
import com.bms.order.constant.enumeration.OrderPlacerType;
import com.bms.order.constant.enumeration.PaymentStu;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.BsOrderAttachedDao;
import com.bms.order.dao.BsOrderDao;
import com.bms.order.dao.BsOrderDetailAttachedDao;
import com.bms.order.dao.BsOrderDetailDao;
import com.bms.order.external.archive.Bs;
import com.bms.order.external.archive.Goods;
import com.bms.order.services.ORDR0606IService;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.DecimalUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 买手订单创建接口Service
 *
 * @author li_huiqian
 */
@Service
public class ORDR0606IServiceImpl implements ORDR0606IService {

    @Autowired
    private BaseRedisDao redisDao;
    @Autowired
    private BsOrderDao bsOrderDao;
    @Autowired
    private BsOrderAttachedDao bsOrderAttachedDao;
    @Autowired
    private BsOrderDetailDao bsOrderDetailDao;
    @Autowired
    private BsOrderDetailAttachedDao bsOrderDetailAttachedDao;

    /**
     * 买手囤实物订单和买手囤货权订单创建
     *
     * @param operator 操作者
     * @param param    ORDR0606IRestParam
     */
    @Transactional
    @Override
    public Long execute(Operator operator, ORDR0606IBeanParam param) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();
        blackboard.setOperator(operator);
        map.put("param", param);
        map.put("blackboard", blackboard);
//        pre(map);
//        process(map);
//        post(map);
        BsOrder bsOrder = (BsOrder) map.get("bsOrder");
//        return bsOrder.getEntity().getBsOrderId();
        return null;
    }

    /**
     * 准备
     *
     * @param map HashMap
     */
    private void pre(HashMap<String, Object> map) {
        // 获取参数
        ORDR0606IBeanParam param = (ORDR0606IBeanParam) map.get("param");
        Blackboard blackboard = (Blackboard) map.get("blackboard");

        // 设置DAO
        blackboard.setBaseRedisDao(redisDao);
        blackboard.putBaseDao(bsOrderDao);
        blackboard.putBaseDao(bsOrderAttachedDao);
        blackboard.putBaseDao(bsOrderDetailDao);
        blackboard.putBaseDao(bsOrderDetailAttachedDao);

        // 操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);

        // 获取买手订单
        BsOrder bsOrder = param.getBsOrder();
        bsOrder.setBlackboard(blackboard);

        // 获取买手信息
        Bs bsEntity = Bs.getBsInfoById(bsOrder.getEntity().getBsId());
        if (null == bsEntity) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060107, bsOrder.getEntity().getBsId());
        }
        // 数据权限验证
        checkDataAuthority(operator);

        // 验证买手订单的有效性
        checkBsOrder(bsOrder);

        // 返回参数
        map.put("bsOrder", bsOrder);
        map.put("bsEntity", bsEntity);
    }

    /**
     * 数据权限验证
     *
     * @param operator
     */
    private void checkDataAuthority(Operator operator) {
        // 数据权限验证
        OperatorType operatorType = OperatorType.getInstance(operator.getOperatorType());
        // 只有买手和平台人员能够创建买手订单
        if (operatorType != OperatorType.BS && operatorType != OperatorType.MANAGER) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060101);
        }
    }

    /**
     * 验证买手订单
     *
     * @param bsOrder
     */
    private void checkBsOrder(BsOrder bsOrder) {
        // 下单员类型必须为买手或平台管理人员
        OrderPlacerType orderPlacerType = OrderPlacerType.getInstance(bsOrder.getEntity().getOrderPlacerType());// 下单员类型
        if (orderPlacerType != OrderPlacerType.BS && orderPlacerType != OrderPlacerType.MANAGER) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060102, orderPlacerType.getName());
        }

        //TODO qiuwenting 买手囤货权和囤实物的校验买手处暂未提供
       /* 不用验证订单类型
       // 订单类型验证
        BsOrderType orderType = BsOrderType.getInstance(bsOrder.getEntity().getOrderType());
        if (agentEntity.getIsStoreGoods()) {// 囤实物
            if (BsOrderType.BS_A_STOCKPILING_ORDER != orderType) {// 不是 A 类
                throw new BusinessException(ModuleCode.ORDR,  ErrorCode.E060103);
            }
        } else {// 囤货权
            if (BsOrderType.BS_B_STOCKPILING_ORDER != orderType) {
                throw new BusinessException(ModuleCode.ORDR,  ErrorCode.E060104);
            }
        }*/
    }

    /**
     * 执行
     *
     * @param map HashMap
     */
    private void process(HashMap<String, Object> map) {
        // 获取参数
        BsOrder bsOrder = (BsOrder) map.get("bsOrder");
        Bs bsEntity = (Bs) map.get("bsEntity");

        // 更新价格创建时间
        updatePriceCreateTime(bsOrder);

        // 设置区域信息
        setLogistics(bsOrder, bsEntity);

        // 更新所有商品价格信息
        bsOrder.updateGoodsPrice();

        // 创建买手订单
        createBsOrder(bsOrder, bsEntity);

        // 创建买手订单明细
        createBsOrderDetail(bsOrder);
    }

    /**
     * 更新价格创建时间
     *
     * @param bsOrder
     */
    private void updatePriceCreateTime(BsOrder bsOrder) {
        for (BsOrderDetail detail : bsOrder.getBsOrderDetails()) {
            detail.getEntity().setPriceCreateTime(DateUtils.getCurrent());
        }
    }

    /**
     * 设置区域信息
     *
     * @param bsOrder
     * @param bs
     */
    private void setLogistics (BsOrder bsOrder, Bs bs) {
        // 设置区域信息
        bsOrder.getEntity().setLogisticsZoneId(bs.getEntity().getLgcsAreaId());
        bsOrder.getAttachedEntity().setLogisticsZoneCode(bs.getEntity().getLgcsAreaCode());
        bsOrder.getAttachedEntity().setLogisticsZoneName(bs.getEntity().getLgcsAreaName());
        bsOrder.getAttachedEntity().setCityId(bs.getEntity().getCityId());
        bsOrder.getAttachedEntity().setCityCode(bs.getEntity().getCityCode());
        bsOrder.getAttachedEntity().setCityName(bs.getEntity().getCityName());
        bsOrder.getAttachedEntity().setCountryId(bs.getEntity().getDistrictId());
        bsOrder.getAttachedEntity().setCountryCode(bs.getEntity().getDistrictCode());
        bsOrder.getAttachedEntity().setCountryName(bs.getEntity().getDistrictName());
    }

    /**
     * 创建买手订单
     *
     * @param bsOrder
     */
    private void createBsOrder(BsOrder bsOrder, Bs bs) {
        // 设置支付状态
        bsOrder.getEntity().setPaymentStu(PaymentStu.NOT_PAYMENT.getCode());

        // 是否开具发票
        if (bsOrder.getEntity().getInvoiceFlg() == null)
            bsOrder.getEntity().setInvoiceFlg(false); // 默认false

        // 是否使用账期
        if (bsOrder.getEntity().getUseNetFlg() == null)
            bsOrder.getEntity().setUseNetFlg(false);// 预留 默认false
        BigDecimal orderAmount = bsOrder.calculateOrderAmount();
        // 设置订单金额
        bsOrder.getEntity().setOrderAmount(orderAmount);

        // 设置优惠金额
        BigDecimal preferentialAmount = bsOrder.getEntity().getPreferentialAmount();
        if (preferentialAmount == null) {
            preferentialAmount = BigDecimal.ZERO;
        } else if (DecimalUtils.gt(preferentialAmount, orderAmount)) {//  验证 优惠金额要小于订单金额
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060105);
        }
        bsOrder.getEntity().setPreferentialAmount(preferentialAmount);


        // 设置已收金额
        bsOrder.getEntity().setReceiveAmount(BigDecimal.ZERO);

        // 设置定金应付金额
        if (bsOrder.getEntity().getEarnestAmount() == null)
            bsOrder.getEntity().setEarnestAmount(BigDecimal.ZERO);
        // 设置定金应付比例，单位%
        bsOrder.getEntity()
                .setEarnestPercent(DecimalUtils.divideAndRound(
                        DecimalUtils.multiply(bsOrder.getEntity().getEarnestAmount(), new BigDecimal(100)),
                bsOrder.getEntity().getOrderAmount(), OrderConst.MAX_D_PERCENT));

        // 设置预付金应付金额
        if (bsOrder.getEntity().getAdvancePaymentAmount() == null)
            bsOrder.getEntity().setAdvancePaymentAmount(BigDecimal.ZERO);
        // 设置预付金应付比例
        bsOrder.getEntity()
                .setAdvancePaymentPercent(DecimalUtils.divideAndRound(
                        DecimalUtils.multiply(bsOrder.getEntity().getAdvancePaymentAmount(), new BigDecimal(100)),
                        bsOrder.getEntity().getOrderAmount(), OrderConst.MAX_D_PERCENT));

        // 设置买手订单状态 确认中
        bsOrder.getEntity().setBsOrderStu(BsOrderStu.IN_CONFIRMATION.getCode());

        // 设置买手信息
        bsOrder.getAttachedEntity().setBsCode(bs.getEntity().getBsCode());
        bsOrder.getAttachedEntity().setBsType(bs.getEntity().getCategorycode());
        bsOrder.getAttachedEntity().setBsName(bs.getEntity().getBsName());

        // 设置下单员信息
        OrderPlacerType orderPlacerType = OrderPlacerType.getInstance(bsOrder.getEntity().getOrderPlacerType());
        if (OrderPlacerType.BS == orderPlacerType) {// 买手
            bsOrder.getAttachedEntity().setOrderPlacerCode(bs.getEntity().getBsCode());// 下单员编码
            bsOrder.getAttachedEntity().setOrderPlacerName(bs.getEntity().getBsName());// 下单员名称
        }

        bsOrder.create();
    }

    /**
     * @param bsOrder
     */
    private void createBsOrderDetail(BsOrder bsOrder) {
        List<BsOrderDetail> bsOrderDetails = bsOrder.getBsOrderDetails();
        List<String> goodsIds = new ArrayList<>();
        Map<String, Goods> goodsMap = new HashMap<>();

        for (BsOrderDetail bsOrderDetail : bsOrderDetails) {
            goodsIds.add(bsOrderDetail.getEntity().getGoodsId());
        }

        // 获取商品信息
        List<Goods> goodsList = Goods.findByIds(goodsIds, bsOrder.getEntity().getLogisticsZoneId());
        if (null != goodsList && goodsList.size() > 0) {
            for (Goods goods : goodsList) {
                goodsMap.put(goods.getEntity().getGoodsId(), goods);
            }
        }

        for (BsOrderDetail bsOrderDetail : bsOrderDetails) {
            // 设置买手订单ID
            bsOrderDetail.getEntity().setBsOrderId(bsOrder.getEntity().getBsOrderId());

            // 设置取消数量
            bsOrderDetail.getEntity().setCancelQuantity(BigDecimal.ZERO);

            // 设置商品信息
            Goods goods = goodsMap.get(bsOrderDetail.getEntity().getGoodsId().toString());
            if (goods == null) {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060106, bsOrderDetail.getEntity().getGoodsId().toString());
            }

            _createBsOrderDetail(bsOrderDetail, goods);
        }

        BsOrderDetailList list = BsOrderDetailList.build(bsOrder.getBlackboard())
                .forCreate(bsOrderDetails.toArray(new BsOrderDetail[0]));
        list.create();
    }

    /**
     * 创建买手订单明细
     *
     * @param bsOrderDetail
     * @param goods
     */
    private void _createBsOrderDetail(BsOrderDetail bsOrderDetail, Goods goods) {
        bsOrderDetail.getEntity().setProductId(goods.getEntity().getProductId());
        bsOrderDetail.getEntity().setManufacturerId(goods.getEntity().getManufacturerId());
        bsOrderDetail.getEntity().setSellerId(goods.getEntity().getSellerId());
        bsOrderDetail.getEntity().setTransactionSequence(NumberConst.IntDef.INT_ONE);
        bsOrderDetail.getAttachedEntity().setItemCode(goods.getEntity().getItemCode());
        bsOrderDetail.getAttachedEntity().setItemName(goods.getEntity().getItemName());
        bsOrderDetail.getAttachedEntity().setBrandCode(goods.getEntity().getBrandCode());
        bsOrderDetail.getAttachedEntity().setBrandName(goods.getEntity().getBrandName());
        bsOrderDetail.getAttachedEntity().setItemBrandCode(goods.getEntity().getItemBrandCode());
        bsOrderDetail.getAttachedEntity().setManufacturerCode(goods.getEntity().getManufacturerCode());
        bsOrderDetail.getAttachedEntity().setManufacturerName(goods.getEntity().getManufacturerName());
        bsOrderDetail.getAttachedEntity().setSellerCode(goods.getEntity().getSellerCode());
        bsOrderDetail.getAttachedEntity().setSellerName(goods.getEntity().getSellerName());
        bsOrderDetail.getAttachedEntity().setBatchCode(goods.getEntity().getBatchCode());
        bsOrderDetail.getAttachedEntity().setSaleLabelCode(goods.getEntity().getSaleLabelCode());
        bsOrderDetail.getAttachedEntity().setSaleLabelName(goods.getEntity().getSaleLabelName());
        bsOrderDetail.getAttachedEntity().setSmallPackageFeature(goods.getEntity().getSmallPackageFeature());
        bsOrderDetail.getAttachedEntity().setQuantityPerPackage(goods.getEntity().getQuantityPerPackage());
        bsOrderDetail.getAttachedEntity().setNetWeight(goods.getEntity().getNetWeight());
        bsOrderDetail.getAttachedEntity().setGrossWeight(goods.getEntity().getGrossWeight());
        bsOrderDetail.getAttachedEntity().setCartonSize(goods.getEntity().getCartonSize());
        bsOrderDetail.getAttachedEntity().setProductLevel(goods.getEntity().getProductLevel());
        bsOrderDetail.getAttachedEntity().setPalletStandardStackQuantity(goods.getEntity().getPalletStandardStackQuantity());
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

}
