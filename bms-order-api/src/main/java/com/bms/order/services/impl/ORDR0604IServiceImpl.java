package com.bms.order.services.impl;

import com.bms.order.archive.impl.BsOrder;
import com.bms.order.archive.impl.BsOrderDetail;
import com.bms.order.archive.impl.BsStockpileSplitDetail;
import com.bms.order.archive.impl.Operator;
import com.bms.order.archive.impl.list.BsStockpileSplitDetailList;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.BsOrderDetailAttachedEntity;
import com.bms.order.bean.entity.BsOrderDetailEntity;
import com.bms.order.bean.entity.BsStockpileSplitDetailAttachedEntity;
import com.bms.order.bean.entity.BsStockpileSplitDetailEntity;
import com.bms.order.bean.param.ORDR0604IBeanParam;
import com.bms.order.bean.param.ORDR0607IFilterParam;
import com.bms.order.bean.param.ORDR0701IBeanParam;
import com.bms.order.constant.OrderConst;
import com.bms.order.constant.enumeration.*;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.*;
import com.bms.order.external.archive.Seller;
import com.bms.order.external.archive.Stock;
import com.bms.order.external.bean.entity.StockEntity;
import com.bms.order.external.bean.param.LinvRestParam;
import com.bms.order.services.ORDR0604IService;
import com.bms.order.services.ORDR0607IService;
import com.bms.order.services.ORDR0701IService;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 买手订单确认接口Service
 *
 * @author li_huiqian
 */
@Service
public class ORDR0604IServiceImpl implements ORDR0604IService {

    private static Logger logger = LoggerFactory.getLogger(ORDR0604IServiceImpl.class);

    @Autowired
    private BaseRedisDao baseRedisDao;

    @Autowired
    private BsOrderDao bsOrderDao;

    @Autowired
    private BsOrderAttachedDao bsOrderAttachedDao;

    @Autowired
    private BsOrderDetailDao bsOrderDetailDao;

    @Autowired
    private BsOrderDetailAttachedDao bsOrderDetailAttachedDao;

    @Autowired
    private BsStockpileSplitDetailDao bsStockpileSplitDetailDao;

    @Autowired
    private BsStockpileSplitDetailAttachedDao bsStockpileSplitDetailAttachedDao;

    @Autowired
    private ORDR0701IService ordr0701IService;

    @Autowired
    private ORDR0607IService ordr0607IService;
    /**
     * 订单系统/平台订单人员确认买手订单，占用库存，生成记账凭证
     *
     * @param operator 操作者
     * @param param    ORDR0604IBeanParam
     */
    @Override
    public void execute(Operator operator, ORDR0604IBeanParam param) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();
        blackboard.setOperator(operator);
        map.put("param", param);
        map.put("blackboard", blackboard);
        pre(map);
        process(map);
        post(map);
    }

    /**
     * 准备
     *
     * @param map HashMap
     */
    private void pre(HashMap<String, Object> map) {
        // 获取参数
        ORDR0604IBeanParam param = (ORDR0604IBeanParam) map.get("param");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 设置DAO
        blackboard.setBaseRedisDao(baseRedisDao);
        blackboard.putBaseDao(bsOrderDao);
        blackboard.putBaseDao(bsOrderDetailDao);
        blackboard.putBaseDao(bsOrderDetailAttachedDao);
        blackboard.putBaseDao(bsStockpileSplitDetailDao);
        blackboard.putBaseDao(bsStockpileSplitDetailAttachedDao);
        blackboard.putBaseDao(bsOrderAttachedDao);


        //操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);
        // 获取角色-后台
        checkBackground(operator);
        BsOrder bsOrder = param.generateBsOrder();
        bsOrder.setBlackboard(blackboard);

        map.put("bsOrder", bsOrder);
    }

    /**
     * 执行
     *
     * @param map HashMap
     */
    private void process(HashMap<String, Object> map) {
        // 获取参数
        BsOrder bsOrder = (BsOrder) map.get("bsOrder");
        confirmBsOrder(bsOrder);
        // 买手订单创建默认付款
        ORDR0701IBeanParam ordr0701IBeanParam = new ORDR0701IBeanParam();
        ordr0701IBeanParam.setOrderId(bsOrder.getEntity().getBsOrderId());
        ordr0701IBeanParam.setOrderType("002");
        ordr0701IBeanParam.setPaymentAmount(bsOrder.getEntity().getOrderAmount());
        ordr0701IBeanParam.setPaymentWay(PaymentWay.Membership_Card.getCode());
        ordr0701IBeanParam.setPaymentSubject(PaymentSubject.Deposit.getCode());
        Operator I0701Operator = new Operator();
        I0701Operator.setOperatorType(OperatorType.CASH_POOL.getCode());
        I0701Operator.setOperatorId(OperatorType.CASH_POOL.getCode());
        ordr0701IService.execute(I0701Operator, ordr0701IBeanParam);

        // 0607I买手囤货接口
        ORDR0607IFilterParam ordr0607IFilterParam = new ORDR0607IFilterParam();
        ordr0607IFilterParam.setBsOrderId(bsOrder.getEntity().getBsOrderId());
        Operator I0607Operator = new Operator();
        I0607Operator.setOperatorType(OperatorType.MANAGER.getCode());
        I0607Operator.setOperatorId(OperatorType.MANAGER.getCode());
        ordr0607IService.execute(I0607Operator, ordr0607IFilterParam);
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


    private void confirmBsOrder(BsOrder bsOrder) {
        // 验证买手订单是否存在
        bsOrder.complete(false);
        if (!bsOrder.isDataSynced()) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060401, StringUtils.toStr(bsOrder.getEntity().getBsOrderId()));
        }

        // 验证买手订单是否可以进行确认操作
        if (!bsOrder.getEntity().getBsOrderStu().equals(BsOrderStu.IN_CONFIRMATION.getCode())) {
            throw new BusinessException(ModuleCode.ORDR,
                    ErrorCode.E060402, StringUtils.toStr(bsOrder.getEntity().getBsOrderId()));
        }

        // 查询买手订单明细
        List<BsOrderDetail> bsOrderDetails = bsOrder.getBsOrderDetails();

//        Map<String, StockEntity> stocks = getOwnerInfo(bsOrder);
        Seller seller = Seller.getSellerByCode(Seller.SELLER_CODE);

        List<BsStockpileSplitDetail> splitDetails = new ArrayList<BsStockpileSplitDetail>();

        // 遍历买手订单明细，对买手订单明细进行拆分
        for (BsOrderDetail detail : bsOrderDetails) {
            List<BsStockpileSplitDetail> splitBsOrderDetail = splitBsOrderDetail(detail, bsOrder, seller);
            if (splitBsOrderDetail == null)
                continue;
            splitDetails.addAll(splitBsOrderDetail);
        }

        // 将拆分结果插入数据库
        BsStockpileSplitDetailList saveList = BsStockpileSplitDetailList.build(bsOrder.getBlackboard())
                .forCreate(splitDetails.toArray(new BsStockpileSplitDetail[0]));
        saveList.create();
        saveList.link(bsOrderDetails);
        saveList.link(bsOrder);


        // 占用库存
        allocateOwCommInv(bsOrder, seller);

        // 资金池记账
        // TODO qiuwenting 调用资金池记账接口
        logger.info("调用资金池记账接口");

        // 更新订单状态
        bsOrder.getEntity().setBsOrderStu(BsOrderStu.CONFIRMED.getCode());
        bsOrder.modify();

    }

    public Map<String, StockEntity> getOwnerInfo(BsOrder bsOrder) {
        Map<String, T> tempMap = new HashMap<>();
        String[] goods = null;
        for(BsOrderDetail bsOrderDetail : bsOrder.getBsOrderDetails()) {
            tempMap.put(bsOrderDetail.getEntity().getGoodsId(), null);
        }
        goods = tempMap.keySet().toArray(new String[0]);
//        Map<String, StockEntity> stocks = Stock.QueryOwCommInv(StringUtils.toStr(bsOrder.getEntity().getLogisticsZoneId()), goods);

        return  null;
    }

    public void allocateOwCommInv(BsOrder bsOrder, Seller seller) {
        // 查询买手订单明细
        List<BsOrderDetail> bsOrderDetails = bsOrder.getBsOrderDetails();

        if (CollectionUtils.isEmpty(bsOrderDetails))
            return;

        ArrayList<LinvRestParam> paramList = new ArrayList<>();
        for (BsOrderDetail detail : bsOrderDetails) {
            List<BsStockpileSplitDetail> splitDetails = detail.getBsStockpileSplitDetails();

            if (CollectionUtils.isEmpty(splitDetails))
                continue;

            for (BsStockpileSplitDetail splitDetail : splitDetails) {
                LinvRestParam param = new LinvRestParam();
                param.setLogicAreaId(bsOrder.getEntity().getLogisticsZoneId());
                param.setOwnerId(seller.getEntity().getSellerId().toString());
                param.setOwnerCode(seller.getEntity().getSellerCode());
                param.setOwnerType(OwnerType.Seller.getCode());
                param.setCommodityId(detail.getEntity().getGoodsId());
                if (bsOrder.getEntity().getOrderType().equals(BsOrderType.BS_A_STOCKPILING_ORDER.getCode())) {
                    param.setComoIvType(ComoIvType.Actual.getCode());
                    param.setBizType(BizType.ActualStore.getCode());
                } else if (bsOrder.getEntity().getOrderType().equals(BsOrderType.BS_B_STOCKPILING_ORDER.getCode())) {
                    param.setComoIvType(ComoIvType.Virtual.getCode());
                    param.setBizType(BizType.VirtualStore.getCode());
                } else if (bsOrder.getEntity().getOrderType().equals(BsOrderType.BS_SHORT_SELLING_ORDER.getCode())){
                    param.setComoIvType(ComoIvType.Actual.getCode());
                    param.setBizType(BizType.AlgorithmicStore.getCode());
                }
                param.setRefNo(bsOrder.getEntity().getBsOrderCode());
                param.setTransactionId(bsOrder.getEntity().getBsOrderId());
                param.setTransactionNo(bsOrder.getEntity().getBsOrderCode());
                param.setTransactionDetailId(splitDetail.getEntity().getBsStockpileSplitDetailId());
                param.setTransactionSequence(NumberConst.IntDef.INT_ONE);//初次占用传1
                param.setAllocatedQty(detail.getEntity().getGoodsQuantity());
                param.setTargetId(bsOrder.getEntity().getBsId());
                param.setTargetCode(bsOrder.getAttachedEntity().getBsCode());
                param.setTargetType(OwnerType.Agent.getCode());
                paramList.add(param);
            }
        }
        logger.info("调用库存占用接口");
        // A类囤实物调用库存占用
        if (bsOrder.getEntity().getOrderType().equals(BsOrderType.BS_A_STOCKPILING_ORDER.getCode())) {
            Stock.AllocateOwCommInv(paramList);
        }
    }

    /**
     * 拆分
     *
     * @param bsOrderDetail
     * @param bsOrder
     * @return
     */
    public List<BsStockpileSplitDetail> splitBsOrderDetail(BsOrderDetail bsOrderDetail, BsOrder bsOrder, Seller seller) {

        List<BsStockpileSplitDetail> result = new ArrayList<>();

        BsOrderDetailEntity bsOrderDetailEntity = bsOrderDetail.getEntity();
        BsOrderDetailAttachedEntity bsOrderDetailAttachedEntity = bsOrderDetail.getAttachedEntity();

        // A类拆分规则
        if (BsOrderType.BS_A_STOCKPILING_ORDER.getCode().equals(bsOrder.getEntity().getOrderType())) {
            BsStockpileSplitDetailEntity bsStockpileSplitDetailEntity = new BsStockpileSplitDetailEntity();
            BsStockpileSplitDetailAttachedEntity bsStockpileSplitDetailAttachedEntity = new BsStockpileSplitDetailAttachedEntity();
            // 买后分拆明细
            createStockpileSplitDetail(bsOrderDetailEntity, bsStockpileSplitDetailEntity);
            // 买手分拆明细附表
            createStockpileSplitDetailAttached(bsOrderDetailAttachedEntity,
                    bsStockpileSplitDetailAttachedEntity);

            bsStockpileSplitDetailEntity.setSellerId(seller.getEntity().getSellerId().toString());
            bsStockpileSplitDetailAttachedEntity.setSellerCode(seller.getEntity().getSellerCode());
            bsStockpileSplitDetailAttachedEntity.setSellerName(seller.getEntity().getSellerName());
            BsStockpileSplitDetail splitDetail = BsStockpileSplitDetail.build(bsOrder.getBlackboard())
                    .forCreate(bsStockpileSplitDetailEntity, bsStockpileSplitDetailAttachedEntity);
            result.add(splitDetail);
        }
        // B类拆分规则
        else if (BsOrderType.BS_B_STOCKPILING_ORDER.getCode().equals(bsOrder.getEntity().getOrderType())) {
            BsStockpileSplitDetailEntity bsStockpileSplitDetailEntity = new BsStockpileSplitDetailEntity();
            BsStockpileSplitDetailAttachedEntity bsStockpileSplitDetailAttachedEntity = new BsStockpileSplitDetailAttachedEntity();
            // 买后分拆明细
            createStockpileSplitDetail(bsOrderDetailEntity, bsStockpileSplitDetailEntity);
            bsStockpileSplitDetailEntity.setSellerId(seller.getEntity().getSellerId().toString());
            bsStockpileSplitDetailAttachedEntity.setSellerCode(seller.getEntity().getSellerCode());
            bsStockpileSplitDetailAttachedEntity.setSellerName(seller.getEntity().getSellerName());
            // 买手分拆明细附表
            createStockpileSplitDetailAttached(bsOrderDetailAttachedEntity,
                    bsStockpileSplitDetailAttachedEntity);
            BsStockpileSplitDetail splitDetail = BsStockpileSplitDetail.build(bsOrder.getBlackboard())
                    .forCreate(bsStockpileSplitDetailEntity, bsStockpileSplitDetailAttachedEntity);
            result.add(splitDetail);
        }

        return result;
    }

    /**
     * 设置分拆明细数据
     *
     * @param bsOrderDetailEntity
     * @param bsStockpileSplitDetailEntity
     */
    private void createStockpileSplitDetail(BsOrderDetailEntity bsOrderDetailEntity, BsStockpileSplitDetailEntity bsStockpileSplitDetailEntity) {

        bsStockpileSplitDetailEntity.setBsOrderDetailId(bsOrderDetailEntity.getBsOrderDetailId());
        bsStockpileSplitDetailEntity.setSellSideId(OrderConst.PLATFORM_ID);
        bsStockpileSplitDetailEntity.setGoodsId(bsOrderDetailEntity.getGoodsId());
        bsStockpileSplitDetailEntity.setProductId(bsOrderDetailEntity.getProductId());
        bsStockpileSplitDetailEntity.setManufacturerId(bsOrderDetailEntity.getManufacturerId());
        bsStockpileSplitDetailEntity.setGoodsQuantity(bsOrderDetailEntity.getGoodsQuantity());
        bsStockpileSplitDetailEntity.setSaleLabelId(bsOrderDetailEntity.getSaleLabelId());
        bsStockpileSplitDetailEntity.setBatchId(bsOrderDetailEntity.getBatchId());
    }

    /**
     * 设置分拆明细附表数据
     *
     * @param bsOrderDetailAttachedEntity
     * @param bsStockpileSplitDetailAttachedEntity
     */
    private void createStockpileSplitDetailAttached(BsOrderDetailAttachedEntity bsOrderDetailAttachedEntity, BsStockpileSplitDetailAttachedEntity bsStockpileSplitDetailAttachedEntity) {

        bsStockpileSplitDetailAttachedEntity.setSellSideCode(OrderConst.PLATFORM_CODE);
        bsStockpileSplitDetailAttachedEntity.setSellSideName(OrderConst.PLATFORM_NAME);
        bsStockpileSplitDetailAttachedEntity.setItemCode(bsOrderDetailAttachedEntity.getItemCode());
        bsStockpileSplitDetailAttachedEntity.setItemName(bsOrderDetailAttachedEntity.getItemName());
        bsStockpileSplitDetailAttachedEntity.setBrandCode(bsOrderDetailAttachedEntity.getBrandCode());
        bsStockpileSplitDetailAttachedEntity.setBrandName(bsOrderDetailAttachedEntity.getBrandName());
        bsStockpileSplitDetailAttachedEntity.setItemBrandCode(bsOrderDetailAttachedEntity.getItemBrandCode());
        bsStockpileSplitDetailAttachedEntity.setManufacturerCode(bsOrderDetailAttachedEntity.getManufacturerCode());
        bsStockpileSplitDetailAttachedEntity.setManufacturerName(bsOrderDetailAttachedEntity.getManufacturerName());
        bsStockpileSplitDetailAttachedEntity.setSaleLabelCode(bsOrderDetailAttachedEntity.getSaleLabelCode());
        bsStockpileSplitDetailAttachedEntity.setSaleLabelName(bsOrderDetailAttachedEntity.getSaleLabelName());
        bsStockpileSplitDetailAttachedEntity.setGoodsCode(bsOrderDetailAttachedEntity.getGoodsCode());
        bsStockpileSplitDetailAttachedEntity.setGoodsName(bsOrderDetailAttachedEntity.getGoodsName());
        bsStockpileSplitDetailAttachedEntity.setBatchCode(bsOrderDetailAttachedEntity.getBatchCode());
        bsStockpileSplitDetailAttachedEntity.setSmallPackageFeature(bsOrderDetailAttachedEntity.getSmallPackageFeature());
        bsStockpileSplitDetailAttachedEntity.setQuantityPerPackage(bsOrderDetailAttachedEntity.getQuantityPerPackage());
        bsStockpileSplitDetailAttachedEntity.setNetWeight(bsOrderDetailAttachedEntity.getNetWeight());
        bsStockpileSplitDetailAttachedEntity.setGrossWeight(bsOrderDetailAttachedEntity.getGrossWeight());
        bsStockpileSplitDetailAttachedEntity.setCartonSize(bsOrderDetailAttachedEntity.getCartonSize());
        bsStockpileSplitDetailAttachedEntity.setProductLevel(bsOrderDetailAttachedEntity.getProductLevel());
        bsStockpileSplitDetailAttachedEntity.setPalletStandardStackQuantity(bsOrderDetailAttachedEntity.getPalletStandardStackQuantity());
    }


    /**
     * 获取 角色-后台（平台订单人员）
     *
     * @param operator
     * @return
     */
    private void checkBackground(Operator operator) {
        Assert.notNull(operator);
        if (operator.isStaff()) {
        } else if (operator.isOrderSystem()) {
        } else {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060403);
        }
    }
}
