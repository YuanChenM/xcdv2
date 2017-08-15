package com.bms.order.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bms.order.bean.entity.BsOrderAttachedEntity;
import com.bms.order.bean.entity.BsOrderEntity;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bms.order.archive.impl.BsOrder;
import com.bms.order.archive.impl.BsOrderDetail;
import com.bms.order.archive.impl.BsStockpileSplitDetail;
import com.bms.order.archive.impl.Operator;
import com.bms.order.archive.impl.list.BsOrderDetailList;
import com.bms.order.archive.impl.list.BsStockpileSplitDetailList;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.param.ORDR0602IBeanParam;
import com.bms.order.bean.param.ORDR0604IBeanParam;
import com.bms.order.constant.OrderConst;
import com.bms.order.constant.enumeration.BsOrderStu;
import com.bms.order.constant.enumeration.BsOrderType;
import com.bms.order.constant.enumeration.OperatorType;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.BsOrderAttachedDao;
import com.bms.order.dao.BsOrderDao;
import com.bms.order.dao.BsOrderDetailAttachedDao;
import com.bms.order.dao.BsOrderDetailDao;
import com.bms.order.dao.BsStockpileSplitDetailAttachedDao;
import com.bms.order.dao.BsStockpileSplitDetailDao;
import com.bms.order.external.archive.Goods;
import com.bms.order.external.archive.Stock;
import com.bms.order.external.bean.param.StockRestParam;
import com.bms.order.services.ORDR0602IService;
import com.bms.order.services.ORDR0604IService;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.DecimalUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;

/**
 * 买手订单修改接口Service
 *
 * @author li_huiqian
 */
@Service
public class ORDR0602IServiceImpl implements ORDR0602IService {

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

    @Autowired
    private BsStockpileSplitDetailDao bsStockpileSplitDetailDao;

    @Autowired
    private BsStockpileSplitDetailAttachedDao bsStockpileSplitDetailAttachedDao;

    @Autowired
    private ORDR0604IService ordr0604IService;// 买手订单确认

    /**
     * 买手囤货完成前，对订单基本信息进行修改
     *
     * @param operator 操作者
     * @param param    ORDR0602IRestParam
     */
    @Transactional
    @Override
    public void execute(Operator operator, ORDR0602IBeanParam param, int step) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();

        blackboard.setOperator(operator);

        BsOrder bsOrderParam = param.generateBSOrder();

        map.put("param", bsOrderParam);
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
     * @param map HashMap
     */
    private void pre(HashMap<String, Object> map) {
        // 获取参数
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 设置DAO
        blackboard.setBaseRedisDao(redisDao);
        blackboard.putBaseDao(bsOrderDao);
        blackboard.putBaseDao(bsOrderAttachedDao);
        blackboard.putBaseDao(bsOrderDetailDao);
        blackboard.putBaseDao(bsOrderDetailAttachedDao);
        blackboard.putBaseDao(bsStockpileSplitDetailDao);
        blackboard.putBaseDao(bsStockpileSplitDetailAttachedDao);

        // 操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);

        // 查询订单是否存在
        // 订单id与订单：参考号不能同时为空，当两者都存在时，则以订单id为主
        BsOrder bsOrderParam = (BsOrder) map.get("param");
        BsOrder bsOrder = null;
        if (null != bsOrderParam.getEntity().getBsOrderId()) {
            bsOrder = BsOrder.build(blackboard).forComplete(bsOrderParam.getEntity().getBsOrderId());
        } else if (null == bsOrderParam.getEntity().getBsOrderId() && !StringUtils.isEmpty(bsOrderParam.getEntity().getBackNo())) {
            BsOrderEntity entity = new BsOrderEntity();
            entity.setBackNo(bsOrderParam.getEntity().getBackNo());
            BsOrderAttachedEntity attachedEntity = new BsOrderAttachedEntity();
            bsOrder = BsOrder.build(blackboard).forCreate(entity, attachedEntity);
        } else {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000002, "订单id与订单：参考号不能同时为空");
        }
            bsOrder.complete(false);
            if (!bsOrder.isDataSynced()) {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060201);
            }
            // 校验买手订单状态
            checkBsOrderStatus(bsOrder);

            // 校验 订单状态【确认中】才能修改的项目：定金应付金额，预付应付金额
            checkBsOrderAmount(bsOrder, bsOrderParam);
        map.put("bsOrder", bsOrder);
    }

    /**
     * 删除分拆明细
     *
     * @param map HashMap
     */
    private void processStep1(HashMap<String, Object> map) {
        // 获取参数
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        BsOrder bsOrder = (BsOrder) map.get("bsOrder");
        BsOrder bsOrderParam = (BsOrder) map.get("param");

        String orderType = bsOrder.getEntity().getOrderType();

        // 获取入参中的订单明细合集
        List<BsOrderDetail> detailList = bsOrder.getBsOrderDetails();
        if (CollectionUtils.isEmpty(detailList))
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000002, "买手订单没有订单明细");
        List<BsOrderDetail> modifiedDetails = bsOrderParam.getBsOrderDetails();
        // 如果明细没有传递或者明细没有变化，则不进行后续操作
        if (!isBsOrderDetailModified(detailList, modifiedDetails))
            return;

        List<BsStockpileSplitDetail> bsStockpileSplitDetails = new ArrayList<>();
        for (BsOrderDetail detail : detailList) {
            if (detail.getBsStockpileSplitDetails() != null)
                bsStockpileSplitDetails.addAll(detail.getBsStockpileSplitDetails());
        }

        // 如果没有分拆信息，不进行下面的步骤
        if (bsStockpileSplitDetails.size() == 0)
            return;

        // 删除分拆表信息
        BsStockpileSplitDetailList bsStockpileSplitDetailList = BsStockpileSplitDetailList.build(blackboard)
            .forUpdate(bsStockpileSplitDetails.toArray(new BsStockpileSplitDetail[bsStockpileSplitDetails.size()]));
        bsStockpileSplitDetailList.delete();

        // 更改订单状态
        bsOrder.getEntity().setBsOrderStu(BsOrderStu.IN_CONFIRMATION.getCode());
        bsOrder.modify();

        // 取消库存占用
        if (orderType.equals(BsOrderType.BS_B_STOCKPILING_ORDER.getCode()))
            return;

        List<StockRestParam> params = new ArrayList<>();
        for (BsStockpileSplitDetail splitDetail : bsStockpileSplitDetails) {
            StockRestParam param = new StockRestParam();
            params.add(param);
            param.setTransactionId(bsOrder.getEntity().getBsOrderId());
            param.setTransactionNo(bsOrder.getEntity().getBsOrderCode());
            param.setTransactionDetailId(splitDetail.getEntity().getBsStockpileSplitDetailId());
            param.setTransactionSequence(null);
            param.setCancelQty(splitDetail.getEntity().getGoodsQuantity());
            param.setAlocType(Stock.ALOC_TYPE_OWNER);
        }

        Stock.ReleaseAllocation(params);
    }

    /**
     * 买手订单明细
     * 
     * @param bsOrderDetails
     * @param modifiedBsOrderDetails
     * @return
     */
    private boolean isBsOrderDetailModified(List<BsOrderDetail> bsOrderDetails,
            List<BsOrderDetail> modifiedBsOrderDetails) {
        // 没有传入买手订单明细
        if (modifiedBsOrderDetails == null)
            return false;

        // 没有修改买手订单明细
        // 大小变更，则没有修改
        if (bsOrderDetails.size() != modifiedBsOrderDetails.size())
            return true;
        for (BsOrderDetail bsOrderDetail : bsOrderDetails) {
            BsOrderDetail find = null;
            for (BsOrderDetail modifiedBsOrderDetail : modifiedBsOrderDetails) {
                if (bsOrderDetail.getEntity().getBsOrderDetailId()
                        .equals(modifiedBsOrderDetail.getEntity().getBsOrderDetailId())) {
                    find = modifiedBsOrderDetail;
                    break;
                }
            }
            if (find == null)
                return true;
            if (find.getEntity().getGoodsQuantity() != null && !DecimalUtils
                    .eq(bsOrderDetail.getEntity().getGoodsQuantity(), find.getEntity().getGoodsQuantity()))
                return true;
        }
        return false;
    }

    /**
     * 执行
     *
     * @param map HashMap
     */
    private void processStep2(HashMap<String, Object> map) {
        // 获取参数
        BsOrder bsOrderParam = (BsOrder) map.get("param");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        BsOrder bsOrder = (BsOrder) map.get("bsOrder");
        Long bsOrderId = bsOrder.getEntity().getBsOrderId();

        // 获取入参中的订单明细合集
        List<BsOrderDetail> detailList = bsOrderParam.getBsOrderDetails();
        ArrayList<StockRestParam> paramList = new ArrayList<>();

        // 修改买手订单数据
        modifyBsOrder(bsOrder, bsOrderParam);

        // 注意这边不用判断size = 0，不为null且size = 0的数据校验时已经报错
        if (!isBsOrderDetailModified(bsOrder.getBsOrderDetails(), detailList))
            return;

        // 删除明细
        deleteBsOrderDetail(bsOrder, detailList, blackboard, paramList);

        // 修改明细
        updateBsOrderDetail(bsOrder, bsOrder.getBsOrderDetails(), bsOrderParam.getBsOrderDetails(), blackboard);

        // 新增明细

        // 处理新增和修改的明细
        for (BsOrderDetail detail : detailList) {
            if (detail.getEntity().getBsOrderDetailId() != null)
                continue;

            // 更新价格创建时间
            detail.getEntity().setPriceCreateTime(DateUtils.getCurrent());

            // 新增的明细调用接口设置产品信息
            setProductInfo(bsOrderParam, detail);

            // 补足买手订单明细详细信息
            detail.setBlackboard(bsOrder.getBlackboard());
            detail.getEntity().setBsOrderId(bsOrderId);
            detail.getEntity().setTransactionSequence(NumberConst.IntDef.INT_ONE);
            detail.create();
        }

        // 更新订单信息
        if(null != bsOrderParam.getEntity().getBsOrderId()){
        bsOrder = BsOrder.build(blackboard).forComplete(bsOrderParam.getEntity().getBsOrderId());
        bsOrder.complete(false);
        updateOrderPrice(bsOrder);
        updateOrderGoods(bsOrder);
        bsOrder.modify();
        }else if(!StringUtils.isEmpty(bsOrder.getEntity().getBackNo())&& null==bsOrderParam.getEntity().getBsOrderId()){
            BsOrderEntity entity = new BsOrderEntity();
            entity.setBackNo(bsOrder.getEntity().getBackNo());
            BsOrderAttachedEntity attachedEntity = new BsOrderAttachedEntity();
            bsOrder = BsOrder.build(blackboard).forCreate(entity,attachedEntity);
            bsOrder.complete(false);
            updateOrderPrice(bsOrder);
            updateOrderGoods(bsOrder);
            bsOrder.modify();
        }
        // 确认订单
        ORDR0604IBeanParam ordr0604IBeanParam = new ORDR0604IBeanParam();// 订单修改后 需要调用 自动确认功能
        ordr0604IBeanParam.setBsOrderId(bsOrderId);
        Operator newOperator = new Operator();
        newOperator.setOperatorType(OperatorType.MANAGER.getCode());
        newOperator.setOperatorId(OrderConst.PLATFORM_ID);
        this.ordr0604IService.execute(newOperator, ordr0604IBeanParam);

    }

    /**
     * 更新明细数据
     * 
     * @param bsOrder
     * @param bsOrderDetails
     * @param modifiedBsOrderDetails
     * @param blackboard
     */
    private void updateBsOrderDetail(BsOrder bsOrder, List<BsOrderDetail> bsOrderDetails,
            List<BsOrderDetail> modifiedBsOrderDetails, Blackboard blackboard) {
        // 找出需要更新的明细
        List<BsOrderDetail> updateList = new ArrayList<>();
        if (null != bsOrderDetails && bsOrderDetails.size() > 0 && null != modifiedBsOrderDetails
                && modifiedBsOrderDetails.size() > 0) {
            // 找出需要更新的明细
            for (BsOrderDetail bsOrderDetail : bsOrderDetails) {
                BsOrderDetail find = null;
                for (BsOrderDetail modifiedBsOrderDetail : modifiedBsOrderDetails) {
                    if (bsOrderDetail.getEntity().getBsOrderDetailId()
                            .equals(modifiedBsOrderDetail.getEntity().getBsOrderDetailId()))
                        find = modifiedBsOrderDetail;
                }
                if (find == null) // 这条数据没有变更
                    continue;
                if (find.getEntity().getGoodsQuantity() != null)
                    bsOrderDetail.getEntity().setGoodsQuantity(find.getEntity().getGoodsQuantity());
                if (find.getEntity().getGoodsUnit() != null)
                    bsOrderDetail.getEntity().setGoodsUnit(find.getEntity().getGoodsUnit());
                // 商品ID不能变更
                updateList.add(bsOrderDetail);
            }
            if (updateList.size() > 0) {
                BsOrderDetailList bsOrderDetailList = BsOrderDetailList.build(blackboard)
                        .forUpdate(updateList.toArray(new BsOrderDetail[0]));
                bsOrderDetailList.modify();
            }
        }
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
     * 订单状态是：确认中、已确认、 未完成 的订单才能修改。
     *
     * @param bsOrder
     */
    private void checkBsOrderStatus(BsOrder bsOrder) {

        String bsOrderStu = bsOrder.getEntity().getBsOrderStu();
        if (StringUtils.isEmpty(bsOrderStu)) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060203);
        }
        if (!bsOrderStu.equals(BsOrderStu.IN_CONFIRMATION.getCode())
                && !bsOrderStu.equals(BsOrderStu.CONFIRMED.getCode())) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060203);
        }

    }

    // 校验 订单状态【确认中】才能修改的项目：定金应付金额，预付应付金额
    private void checkBsOrderAmount(BsOrder bsOrder, BsOrder bsOrderParam) {
        String bsOrderStu = bsOrder.getEntity().getBsOrderStu();
        if (bsOrderStu.equals(BsOrderStu.IN_CONFIRMATION.getCode())) {
            if (bsOrderParam.getEntity().getEarnestAmount() != null) {
                bsOrder.getEntity().setEarnestAmount(bsOrderParam.getEntity().getEarnestAmount());
            }
            if (bsOrderParam.getEntity().getAdvancePaymentAmount() != null) {
                bsOrder.getEntity().setAdvancePaymentAmount(bsOrderParam.getEntity().getAdvancePaymentAmount());
            }
        } else {
            if ((bsOrderParam.getEntity().getEarnestAmount() != null && !DecimalUtils
                    .eq(bsOrderParam.getEntity().getEarnestAmount(), bsOrder.getEntity().getEarnestAmount()))
                    || (bsOrderParam.getEntity().getAdvancePaymentAmount() != null
                            && !DecimalUtils.eq(bsOrderParam.getEntity().getAdvancePaymentAmount(),
                                    bsOrder.getEntity().getAdvancePaymentAmount()))) {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060204);
            }
        }
        // 设置 优惠金额
        if (bsOrderParam.getEntity().getPreferentialAmount() != null) {
            bsOrder.getEntity().setPreferentialAmount(bsOrderParam.getEntity().getPreferentialAmount());
        }

    }

    /**
     * 修改订单数据
     * 
     * @param bsOrder
     * @param modifiedBsOrder
     */
    private void modifyBsOrder(BsOrder bsOrder, BsOrder modifiedBsOrder) {
        // 修改优惠金额
        BigDecimal modifiedPreferentialAmount = bsOrder.getEntity().getPreferentialAmount();
        if (modifiedPreferentialAmount != null) {
            bsOrder.getEntity().setPreferentialAmount(modifiedPreferentialAmount);
        }

        // 订单状态【确认中】才能修改的项目：定金应付金额、预付应付金额
        BigDecimal modifiedEarnestAmount = modifiedBsOrder.getEntity().getEarnestAmount();
        BigDecimal modifiedAdvancePaymentAmount = modifiedBsOrder.getEntity().getAdvancePaymentAmount();
        BsOrderStu bsOrderStu = BsOrderStu.getInstance(bsOrder.getEntity().getBsOrderStu());
        if (BsOrderStu.IN_CONFIRMATION == bsOrderStu) {
            if (modifiedEarnestAmount != null) {
                bsOrder.getEntity().setEarnestAmount(modifiedEarnestAmount);
            }
            if (modifiedAdvancePaymentAmount != null) {
                bsOrder.getEntity().setAdvancePaymentAmount(modifiedAdvancePaymentAmount);
            }
        }

        // 更新百分比
        BigDecimal orderAmount = bsOrder.getEntity().getOrderAmount();
        BigDecimal preferentialAmount = bsOrder.getEntity().getPreferentialAmount();
        bsOrder.getEntity()
            .setEarnestPercent(DecimalUtils.divide(DecimalUtils.multiply(modifiedEarnestAmount, new BigDecimal(100)),
                        DecimalUtils.subtract(orderAmount, preferentialAmount), 2, BigDecimal.ROUND_HALF_UP));
        bsOrder.getEntity().setAdvancePaymentPercent(
                DecimalUtils.divide(DecimalUtils.multiply(modifiedAdvancePaymentAmount, new BigDecimal(100)),
                        DecimalUtils.subtract(orderAmount, preferentialAmount), 2, BigDecimal.ROUND_HALF_UP));

        bsOrder.modify();
    }

    /**
     * 删除买手订单明细
     *
     * @param bsOrder
     * @param detailList
     * @param blackboard
     */
    private void deleteBsOrderDetail(BsOrder bsOrder, List<BsOrderDetail> detailList, Blackboard blackboard,
        ArrayList<StockRestParam> paramList) {
        List<BsOrderDetail> detailDBList = bsOrder.getBsOrderDetails();
        Map<Long, BsOrderDetail> deleteMap = new HashMap<>();
        List<BsOrderDetail> deleteIds = new ArrayList<>();// 删除
        // 删除买手订单明细
        for (BsOrderDetail detail : detailDBList) {
            if (null != detail.getEntity().getTransactionSequence()) {
                detail.getEntity().setTransactionSequence(detail.getEntity().getTransactionSequence() + 1);
            } else {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000002, "业务校验序列不存在");
            }
            deleteMap.put(detail.getEntity().getBsOrderDetailId(), detail);
        }
        // 移除掉不需要删除的明细
        for (BsOrderDetail detail : detailList) {
            deleteMap.remove(detail.getEntity().getBsOrderDetailId());
        }
        for (Long key : deleteMap.keySet()) {
            deleteIds.add(deleteMap.get(key));
        }

        if (CollectionUtils.isEmpty(deleteIds))
            return;

        // 删除订单明细
        BsOrderDetailList bsOrderDetailList = BsOrderDetailList.build(blackboard)
                .forUpdate(deleteIds.toArray(new BsOrderDetail[0]));
        bsOrderDetailList.delete();

    }

    /**
     * 调用产品接口新增补全产品信息
     *
     * @param bsOrderParam
     * @param product
     */
    private void setProductInfo(BsOrder bsOrderParam, BsOrderDetail product) {
        // 获取商品信息
        Map<String, Goods> goodsMap = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (BsOrderDetail bsOrderDetail : bsOrderParam.getBsOrderDetails()) {
            String goodsId = bsOrderDetail.getEntity().getGoodsId();
            if (com.framework.core.utils.StringUtils.isNotEmpty(goodsId)) {
                list.add(goodsId);
            }
        }
        List<Goods> goodsList = Goods.findByIds(list, bsOrderParam.getEntity().getLogisticsZoneId());
        if (null != goodsList && goodsList.size() > 0) {
            for (Goods goods : goodsList) {
                goodsMap.put(goods.getEntity().getGoodsId(), goods);
            }
        }

        if (goodsMap != null && goodsMap.size() > 0) {
            // 创建买手订单明细
            createBsOrderDetail(product, goodsMap);
        } else {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060205);
        }

    }

    /**
     * 创建买手订单明细
     *
     * @param bsOrderDetail
     * @param goodsMap
     */
    private void createBsOrderDetail(BsOrderDetail bsOrderDetail, Map<String, Goods> goodsMap) {
        // 设置取消数量
        bsOrderDetail.getEntity().setCancelQuantity(BigDecimal.ZERO);
        // 设置商品信息
        Goods Goods = goodsMap.get(bsOrderDetail.getEntity().getGoodsId().toString());
        if (Goods == null) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060206);
        }
        bsOrderDetail.getAttachedEntity().setItemCode(Goods.getEntity().getItemCode());
        bsOrderDetail.getAttachedEntity().setItemName(Goods.getEntity().getItemName());
        bsOrderDetail.getAttachedEntity().setBrandCode(Goods.getEntity().getBrandCode());
        bsOrderDetail.getAttachedEntity().setBrandName(Goods.getEntity().getBrandName());
        bsOrderDetail.getAttachedEntity().setItemBrandCode(Goods.getEntity().getItemBrandCode());
        bsOrderDetail.getAttachedEntity().setManufacturerCode(Goods.getEntity().getManufacturerCode());
        bsOrderDetail.getAttachedEntity().setManufacturerName(Goods.getEntity().getManufacturerName());
        bsOrderDetail.getAttachedEntity().setSellerCode(Goods.getEntity().getSellerCode());
        bsOrderDetail.getAttachedEntity().setSellerName(Goods.getEntity().getSellerName());
        bsOrderDetail.getAttachedEntity().setBatchCode(Goods.getEntity().getBatchCode());
        bsOrderDetail.getAttachedEntity().setSaleLabelCode(Goods.getEntity().getSaleLabelCode());
        bsOrderDetail.getAttachedEntity().setSaleLabelName(Goods.getEntity().getSaleLabelName());
        bsOrderDetail.getAttachedEntity().setSmallPackageFeature(Goods.getEntity().getSmallPackageFeature());
        bsOrderDetail.getAttachedEntity().setQuantityPerPackage(Goods.getEntity().getQuantityPerPackage());
        bsOrderDetail.getAttachedEntity().setNetWeight(Goods.getEntity().getNetWeight());
        bsOrderDetail.getAttachedEntity().setGrossWeight(Goods.getEntity().getGrossWeight());
        bsOrderDetail.getAttachedEntity().setCartonSize(Goods.getEntity().getCartonSize());
        bsOrderDetail.getAttachedEntity().setProductLevel(Goods.getEntity().getProductLevel());
        bsOrderDetail.getAttachedEntity()
                .setPalletStandardStackQuantity(Goods.getEntity().getPalletStandardStackQuantity());
    }

    /**
     * 更新订单金额，更新单价
     *
     * @param bsOrder
     */
    private void updateOrderPrice(BsOrder bsOrder) {
        bsOrder.updateGoodsPrice();// 更新单价
        BigDecimal orderAmount = bsOrder.calculateOrderAmount();
        bsOrder.getEntity().setOrderAmount(orderAmount);// 更新订单总金额
    }

    /**
     * 更新订单明细商品信息
     *
     * @param bsOrder
     */
    private void updateOrderGoods(BsOrder bsOrder) {
        // 获取商品信息
        Map<String, Goods> goodsMap = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (BsOrderDetail bsOrderDetail : bsOrder.getBsOrderDetails()) {
            String goodsId = bsOrderDetail.getEntity().getGoodsId();
            if (com.framework.core.utils.StringUtils.isNotEmpty(goodsId)) {
                list.add(goodsId);
            }
        }
        List<Goods> goodsList = Goods.findByIds(list, bsOrder.getEntity().getLogisticsZoneId());
        if (null != goodsList && goodsList.size() > 0) {
            for (Goods goods : goodsList) {
                goodsMap.put(goods.getEntity().getGoodsId(), goods);
            }
        }

        for (BsOrderDetail bsOrderDetail : bsOrder.getBsOrderDetails()) {
            // 设置商品信息
            Goods goods = goodsMap.get(bsOrderDetail.getEntity().getGoodsId().toString());
            if (goods == null) {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060109,
                    bsOrderDetail.getEntity().getGoodsId().toString());
            }
            bsOrderDetail.getEntity().setProductId(goods.getEntity().getProductId());
            bsOrderDetail.getEntity().setManufacturerId(goods.getEntity().getManufacturerId());
            bsOrderDetail.getEntity().setSellerId(goods.getEntity().getSellerId());
            bsOrderDetail.getEntity().setBatchId(goods.getEntity().getBatchId());
            bsOrderDetail.getEntity().setSaleLabelId(goods.getEntity().getSaleLabelId());

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
            bsOrderDetail.getAttachedEntity().setGoodsCode(goods.getEntity().getGoodsCode());
            bsOrderDetail.getAttachedEntity().setGoodsName(goods.getEntity().getGoodsName());

        }
        BsOrderDetailList detailList = BsOrderDetailList.build(bsOrder.getBlackboard())
            .forUpdate(bsOrder.getBsOrderDetails().toArray(new BsOrderDetail[0]));
        detailList.modify();
    }
}
