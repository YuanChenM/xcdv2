package com.bms.order.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.param.ORDR0605IFilterParam;
import com.bms.order.bean.result.ORDR0605IL1RestResult;
import com.bms.order.common.rest.SearchRestParam;
import com.bms.order.common.rest.SearchRestResult;
import com.bms.order.constant.enumeration.OperatorType;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.ORDR0605IDao;
import com.bms.order.services.ORDR0605IService;
import com.framework.base.bean.Pagination;
import com.framework.base.bean.Sort;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.db.DbUtils;
import com.framework.exception.BusinessException;

/**
 * 买手订单查询接口Service
 *
 * @author li_huiqian
 */
@Service
public class ORDR0605IServiceImpl extends BaseServiceImpl implements ORDR0605IService {

    @Autowired
    private ORDR0605IDao dao;

    /**
     * 买手/冻品管家/平台订单人员查询自己权限可以访问的买手订单
     *
     * @param operator
     *            操作者
     * @param param
     *            ORDR0605IRestParam
     */
    @Transactional
    @Override
    public SearchRestResult<ORDR0605IL1RestResult> execute(Operator operator,
            SearchRestParam<ORDR0605IFilterParam> param) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();
        SearchRestResult<ORDR0605IL1RestResult> result = new SearchRestResult<>();

        blackboard.setOperator(operator);
        map.put("param", param);
        map.put("blackboard", blackboard);
        map.put("result", result);

        pre(map);
        process(map);
        post(map);
        return result;
    }

    /**
     * 准备
     *
     * @param map
     *            HashMap
     */
    private void pre(HashMap<String, Object> map) {
        // 获取参数
        @SuppressWarnings("unchecked")
        SearchRestParam<ORDR0605IFilterParam> param = (SearchRestParam<ORDR0605IFilterParam>) map.get("param");
        ORDR0605IFilterParam filter = param.getFilter();

        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);

        // 数据权限验证
        checkDataAuthority(operator, filter);

        // 处理filter
        processFilter(filter);

        // 处理sort
        processSort(param.getSort());

        // 计算分页/查询层级
        calculateLevel(param);
    }

    /**
     * 数据权限验证
     * 
     * @param
     */
    private void checkDataAuthority(Operator operator, ORDR0605IFilterParam filter) {
        OperatorType operatorType = OperatorType.getInstance(operator.getOperatorType());

        // 平台人员：平台下所有买手订单信息
        if (operatorType == OperatorType.MANAGER) {
            // ALL
        }

        // 管家：管家所管理的所有买手订单信息
        else if (operatorType == OperatorType.SA) {
            // 订单.管家ID = 操作者ID
            String[] saIds = filter.getSaId();

            if (saIds != null && saIds.length > 0) {
                // 如果查询条件中有管家ID，查询条件中的管家ID只能为自己
                if (saIds.length > 1 || !saIds[0].equals(operator.getOperatorId()))
                    throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060501);
            }

            filter.setSaId(new String[] { String.valueOf(operator.getOperatorId()) });
        }

        // 买手：只能自己的买手订单
        else if (operatorType == OperatorType.BS) {
            // 订单.买手ID = 操作者ID
            String[] bsIds = filter.getBsId();

            if (bsIds != null && bsIds.length > 0) {
                if (bsIds.length > 1 || !bsIds[0].equals(operator.getOperatorId()))
                    throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060502);
            }

            // 重新设置查询条件
            filter.setBsId(new String[] { operator.getOperatorId() });
        }

        // 其他情况：报异常
        else {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000001, operatorType.getName());
        }
    }

    /**
     * 计算分页/查询层级
     */
    private void calculateLevel(SearchRestParam<ORDR0605IFilterParam> param) {
        Integer pagingLevel = param.getPagingLevel();
        Pagination pagination = param.getPagination();
        ORDR0605IFilterParam filter = param.getFilter();
        int searchLevel = 0;

        int level1 = 1; // ORDER
        int level2 = 2; // DETAIL
        int level3 = 3; // SPLIT
        int levelAll = 99; // ALL

        // 如果不需要分页
        if (pagination == null) { // && pagingLevel == null
            // 分页层级ALL 查询层级ALL
            pagingLevel = levelAll;
            searchLevel = pagingLevel;
            param.setSearchLevel(searchLevel);
            param.setPagingLevel(pagingLevel);
            return;
        }

        // 计算查询层级
        if (null != filter.getManufacturerId() || null != filter.getManufacturerCode()
                || null != filter.getManufacturerName() || null != filter.getSellerId()
                || null != filter.getSellerCode() || null != filter.getSellerName() || null != filter.getSellSideId()
                || null != filter.getSellSideCode() || null != filter.getSellSideName()) {
            searchLevel = level3;
        } else if (null != filter.getGoodsId() || null != filter.getGoodsCode() || null != filter.getGoodsName()
                || null != filter.getSaleLabelId() || null != filter.getSaleLabelCode()
                || null != filter.getSaleLabelName() || null != filter.getSku()) {
            searchLevel = level2;
        } else if (null != filter.getBsId() || null != filter.getBsOrderCode() || null != filter.getOrderType()
                || null != filter.getSalePlatformType() || null != filter.getOrderSourceType()
                || null != filter.getLogisticsZoneId() || null != filter.getLogisticsZoneCode()
                || null != filter.getLogisticsZoneName() || null != filter.getBsId() || null != filter.getBsCode()
                || null != filter.getBsName() || null != filter.getBsType() || null != filter.getOrderPlacerId()
                || null != filter.getOrderPlacerCode() || null != filter.getOrderPlacerName()
                || null != filter.getOrderPlacerType() || null != filter.getInvoiceFlg()
                || null != filter.getBsOrderStatus() || null != filter.getPaymentStatus()
                || null != filter.getOrderPlaceDateTimeFrom() || null != filter.getOrderPlaceDateTimeTo()) {
            searchLevel = level1;
        }

        if (param.getSort() != null) {
            int sortLevel = level1;
            for (Sort sort : param.getSort()) {
                String field = sort.getSortField();
                if (field.startsWith("L3") && sortLevel < level3)
                    sortLevel = level3;
                else if (field.startsWith("L2") && sortLevel < level2)
                    sortLevel = level2;
                else if (field.startsWith("L1") && sortLevel < level1)
                    sortLevel = level1;
            }
            if (sortLevel > pagingLevel)
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000012);
        }

        // 如果查询层级比分页层级浅，查询层级=分页层级
        if (searchLevel < pagingLevel)
            searchLevel = pagingLevel;

        // 设置层级
        param.setSearchLevel(searchLevel);
        param.setPagingLevel(pagingLevel);
    }

    /**
     * 处理过滤器
     * 
     * @param filter
     */
    private void processFilter(ORDR0605IFilterParam filter) {
        // 移除空字符串
        removeBlank(filter);

        // 移除空数组
        removeEmpty(filter);

        // 设置模糊检索
        setSearchCondition(filter);
    }

    /**
     * 移除空字符串（trim后）
     * 
     * @param filter
     */
    private void removeBlank(ORDR0605IFilterParam filter) {
        // 买手订单编码
        filter.setBsOrderCode(removeBlank(filter.getBsOrderCode()));

        // 订单：参考号
        filter.setBackNo(removeBlank(filter.getBackNo()));

        // 物流区编码
        filter.setLogisticsZoneCode(removeBlank(filter.getLogisticsZoneCode()));

        // 物流区名称
        filter.setLogisticsZoneName(removeBlank(filter.getLogisticsZoneName()));

        // 买手编码
        filter.setBsCode(removeBlank(filter.getBsCode()));

        // 买手名称
        filter.setBsName(removeBlank(filter.getBsName()));

        // 下单员编码
        filter.setOrderPlacerCode(removeBlank(filter.getOrderPlacerCode()));

        // 下单员名称
        filter.setOrderPlacerName(removeBlank(filter.getOrderPlacerName()));

        // 商品编码
        filter.setGoodsCode(removeBlank(filter.getGoodsCode()));

        // 商品名称
        filter.setGoodsName(removeBlank(filter.getGoodsName()));

        // 销售标签编码
        filter.setSaleLabelCode(removeBlank(filter.getSaleLabelCode()));

        // 销售标签名称
        filter.setSaleLabelName(removeBlank(filter.getSaleLabelName()));

        // 商品SKU
        filter.setSku(removeBlank(filter.getSku()));

        // 生产商编码
        filter.setManufacturerCode(removeBlank(filter.getManufacturerCode()));

        // 生产商名称
        filter.setManufacturerName(removeBlank(filter.getManufacturerName()));

        // 卖家编码
        filter.setSellerCode(removeBlank(filter.getSellerCode()));

        // 卖家名称
        filter.setSellerName(removeBlank(filter.getSellerName()));

        // 销售方编码
        filter.setSellSideCode(removeBlank(filter.getSellSideCode()));

        // 销售方名称
        filter.setSellSideName(removeBlank(filter.getSellSideName()));
    }

    /**
     * trim
     * 
     * @param str
     * @return
     */
    private String removeBlank(String str) {
        if (str == null)
            return null;
        str = str.trim();
        return str.equals("") ? null : str.trim();
    }

    /**
     * 移除空数组
     * 
     * @param filter
     */
    private void removeEmpty(ORDR0605IFilterParam filter) {
        // 买手订单ID
        if (filter.getBsOrderId() != null && filter.getBsOrderId().length == 0)
            filter.setBsOrderId(null);

        // 买手订单类型
        if (filter.getOrderType() != null && filter.getOrderType().length == 0)
            filter.setOrderType(null);

        // 销售平台
        if (filter.getSalePlatformType() != null && filter.getSalePlatformType().length == 0)
            filter.setSalePlatformType(null);

        // 订单来源
        if (filter.getOrderSourceType() != null && filter.getOrderSourceType().length == 0)
            filter.setOrderSourceType(null);

        // 物流区ID
        if (filter.getLogisticsZoneId() != null && filter.getLogisticsZoneId().length == 0)
            filter.setLogisticsZoneId(null);

        // 买手ID
        if (filter.getBsId() != null && filter.getBsId().length == 0)
            filter.setBsId(null);

        // 买手类型
        if (filter.getBsType() != null && filter.getBsType().length == 0)
            filter.setBsType(null);

        // 下单员ID
        if (filter.getOrderPlacerId() != null && filter.getOrderPlacerId().length == 0)
            filter.setOrderPlacerId(null);

        // 下单员类型
        if (filter.getOrderPlacerType() != null && filter.getOrderPlacerType().length == 0)
            filter.setOrderPlacerType(null);

        // 买手订单状态
        if (filter.getBsOrderStatus() != null && filter.getBsOrderStatus().length == 0)
            filter.setBsOrderStatus(null);

        // 支付状态
        if (filter.getPaymentStatus() != null && filter.getPaymentStatus().length == 0)
            filter.setPaymentStatus(null);

        // 商品ID
        if (filter.getGoodsId() != null && filter.getGoodsId().length == 0)
            filter.setGoodsId(null);

        // 销售标签ID
        if (filter.getSaleLabelId() != null && filter.getSaleLabelId().length == 0)
            filter.setSaleLabelId(null);

        // 生产商Id
        if (filter.getManufacturerId() != null && filter.getManufacturerId().length == 0)
            filter.setManufacturerId(null);

        // 卖家Id
        if (filter.getSellerId() != null && filter.getSellerId().length == 0)
            filter.setSellerId(null);

        // 销售方ID
        if (filter.getSellSideId() != null && filter.getSellSideId().length == 0)
            filter.setSellSideId(null);

    }

    /**
     * 模糊检索设置
     * 
     * @param filter
     */
    private void setSearchCondition(ORDR0605IFilterParam filter) {
        // 买手订单编码
        filter.setBsOrderCode(likeCondition(filter.getBsOrderCode(), DbUtils.LikeMode.FRONT));

        // 订单:参考号
        filter.setBackNo(likeCondition(filter.getBackNo(), DbUtils.LikeMode.FRONT));

        // 物流区编码
        filter.setLogisticsZoneCode(likeCondition(filter.getLogisticsZoneCode(), DbUtils.LikeMode.FRONT));

        // 物流区名称
        filter.setLogisticsZoneName(likeCondition(filter.getLogisticsZoneName(), DbUtils.LikeMode.FRONT));

        // 买手编码
        filter.setBsCode(likeCondition(filter.getBsCode(), DbUtils.LikeMode.FRONT));

        // 买手名称
        filter.setBsName(likeCondition(filter.getBsName(), DbUtils.LikeMode.FRONT));

        // 下单员编码
        filter.setOrderPlacerCode(likeCondition(filter.getOrderPlacerCode(), DbUtils.LikeMode.FRONT));

        // 下单员名称
        filter.setOrderPlacerName(likeCondition(filter.getOrderPlacerName(), DbUtils.LikeMode.FRONT));

        // 商品编码
        filter.setGoodsCode(likeCondition(filter.getGoodsCode(), DbUtils.LikeMode.FRONT));

        // 商品名称
        filter.setGoodsName(likeCondition(filter.getGoodsName(), DbUtils.LikeMode.FRONT));

        // 销售标签编码
        filter.setSaleLabelCode(likeCondition(filter.getSaleLabelCode(), DbUtils.LikeMode.FRONT));

        // 销售标签名称
        filter.setSaleLabelName(likeCondition(filter.getSaleLabelName(), DbUtils.LikeMode.FRONT));

        // 商品SKU
        filter.setSku(likeCondition(filter.getSku(), DbUtils.LikeMode.FRONT));

        // 生产商编码
        filter.setManufacturerCode(likeCondition(filter.getManufacturerCode(), DbUtils.LikeMode.FRONT));

        // 生产商名称
        filter.setManufacturerName(likeCondition(filter.getManufacturerName(), DbUtils.LikeMode.FRONT));

        // 卖家编码
        filter.setSellerCode(likeCondition(filter.getSellerCode(), DbUtils.LikeMode.FRONT));

        // 卖家名称
        filter.setSellerName(likeCondition(filter.getSellerName(), DbUtils.LikeMode.FRONT));

        // 销售方编码
        filter.setSellSideCode(likeCondition(filter.getSellSideCode(), DbUtils.LikeMode.FRONT));

        // 销售方名称
        filter.setSellSideName(likeCondition(filter.getSellSideName(), DbUtils.LikeMode.FRONT));
    }

    /**
     * 获取模糊检索字符串
     * 
     * @param condition
     * @param likeMode
     * @return
     */
    private String likeCondition(String condition, DbUtils.LikeMode likeMode) {
        return condition == null ? null : DbUtils.buildLikeCondition(condition, likeMode);
    }

    /**
     * 处理排序字段
     * 
     * @param sorts
     */
    private void processSort(Sort[] sorts) {
        if (sorts == null || sorts.length == 0)
            return;

        // 创建映射
        Map<String, String> sortMap = initSortMap();

        for (Sort sort : sorts) {
            // 映射
            String inputField = sort.getSortField();
            String dbField = sortMap.get(inputField);
            if (dbField == null)
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000011, inputField);
            sort.setSortField(dbField);
        }
    }

    /**
     * 执行
     *
     * @param map
     *            HashMap
     */
    private void process(HashMap<String, Object> map) {
        // 获取参数
        @SuppressWarnings("unchecked")
        SearchRestParam<ORDR0605IFilterParam> param = (SearchRestParam<ORDR0605IFilterParam>) map.get("param");
        SearchRestResult<ORDR0605IL1RestResult> result = (SearchRestResult<ORDR0605IL1RestResult>)map.get("result");
        // 查询
        List<ORDR0605IL1RestResult> list = dao.findBsOrdersInfo(param);
        int count = list.size();
        if (param.getPagination() != null)
            count = dao.getCount(param);
        result.setData(list);
        result.setTotal(count);
    }

    /**
     * 收尾
     *
     * @param map
     *            HashMap
     */
    @SuppressWarnings("unchecked")
    private void post(HashMap<String, Object> map) {

    }

    private Map<String, String> initSortMap() {
        Map<String, String> sortMap = new HashMap<>();
        sortMap.put("bsOrderId", "L1_bsOrderId");
        sortMap.put("bsOrderCode", "L1_bsOrderCode");
        sortMap.put("orderType", "L1_orderType");
        sortMap.put("salePlatformType", "L1_salePlatformType");
        sortMap.put("orderSourceType", "L1_orderSourceType");
        sortMap.put("orderPlacerId", "L1_orderPlacerId");
        sortMap.put("orderPlacerType", "L1_orderPlacerType");
        sortMap.put("orderPlaceDatetime", "L1_orderPlaceDatetime");
        sortMap.put("logisticsZoneId", "L1_logisticsZoneId");
        sortMap.put("bsId", "L1_bsId");
        sortMap.put("paymentStu", "L1_paymentStu");
        sortMap.put("invoiceFlg", "L1_invoiceFlg");
        sortMap.put("useNetFlg", "L1_useNetFlg");
        sortMap.put("orderAmount", "L1_orderAmount");
        sortMap.put("preferentialAmount", "L1_preferentialAmount");
        sortMap.put("receiveAmount", "L1_receiveAmount");
        sortMap.put("earnestPercent", "L1_earnestPercent");
        sortMap.put("earnestAmount", "L1_earnestAmount");
        sortMap.put("advancePaymentPercent", "L1_advancePaymentPercent");
        sortMap.put("advancePaymentAmount", "L1_advancePaymentAmount");
        sortMap.put("bsOrderStu", "L1_bsOrderStu");
        sortMap.put("version", "L1_version");
        sortMap.put("orderPlacerCode", "L1A_orderPlacerCode");
        sortMap.put("orderPlacerName", "L1A_orderPlacerName");
        sortMap.put("logisticsZoneCode", "L1A_logisticsZoneCode");
        sortMap.put("logisticsZoneName", "L1A_logisticsZoneName");
        sortMap.put("countryId", "L1A_countryId");
        sortMap.put("countryName", "L1A_countryName");
        sortMap.put("cityId", "L1A_cityId");
        sortMap.put("cityName", "L1A_cityName");
        sortMap.put("bsCode", "L1A_bsCode");
        sortMap.put("bsName", "L1A_bsName");
        sortMap.put("bsType", "L1A_bsType");
        sortMap.put("bsOrderDetails.bsOrderDetailId", "L2_bsOrderDetailId");
        sortMap.put("bsOrderDetails.bsOrderId", "L2_bsOrderId");
        sortMap.put("bsOrderDetails.goodsUnit", "L2_goodsUnit");
        sortMap.put("bsOrderDetails.goodsQuantity", "L2_goodsQuantity");
        sortMap.put("bsOrderDetails.cancelQuantity", "L2_cancelQuantity");
        sortMap.put("bsOrderDetails.realUnitPrice", "L2_realUnitPrice");
        sortMap.put("bsOrderDetails.goodsId", "L2_goodsId");
        sortMap.put("bsOrderDetails.productId", "L2_productId");
        sortMap.put("bsOrderDetails.manufacturerId", "L2_manufacturerId");
        sortMap.put("bsOrderDetails.sellerId", "L2_sellerId");
        sortMap.put("bsOrderDetails.batchId", "L2_batchId");
        sortMap.put("bsOrderDetails.saleLabelId", "L2_saleLabelId");
        sortMap.put("bsOrderDetails.version", "L2_version");
        sortMap.put("bsOrderDetails.itemCode", "L2A_itemCode");
        sortMap.put("bsOrderDetails.itemName", "L2A_itemName");
        sortMap.put("bsOrderDetails.brandCode", "L2A_brandCode");
        sortMap.put("bsOrderDetails.brandName", "L2A_brandName");
        sortMap.put("bsOrderDetails.itemBrandCode", "L2A_itemBrandCode");
        sortMap.put("bsOrderDetails.manufacturerCode", "L2A_manufacturerCode");
        sortMap.put("bsOrderDetails.manufacturerName", "L2A_manufacturerName");
        sortMap.put("bsOrderDetails.sellerCode", "L2A_sellerCode");
        sortMap.put("bsOrderDetails.sellerName", "L2A_sellerName");
        sortMap.put("bsOrderDetails.batchCode", "L2A_batchCode");
        sortMap.put("bsOrderDetails.saleLabelCode", "L2A_saleLabelCode");
        sortMap.put("bsOrderDetails.saleLabelName", "L2A_saleLabelName");
        sortMap.put("bsOrderDetails.smallPackageFeature", "L2A_smallPackageFeature");
        sortMap.put("bsOrderDetails.quantityPerPackage", "L2A_quantityPerPackage");
        sortMap.put("bsOrderDetails.netWeight", "L2A_netWeight");
        sortMap.put("bsOrderDetails.grossWeight", "L2A_grossWeight");
        sortMap.put("bsOrderDetails.cartonSize", "L2A_cartonSize");
        sortMap.put("bsOrderDetails.productLevel", "L2A_productLevel");
        sortMap.put("bsOrderDetails.palletStandardStackQuantity", "L2A_palletStandardStackQuantity");
        sortMap.put("bsOrderDetails.bsStockpileSplitDetails.bsStockpileSplitDetailId", "L3_bsStockpileSplitDetailId");
        sortMap.put("bsOrderDetails.bsStockpileSplitDetails.bsOrderDetailId", "L3_bsOrderDetailId");
        sortMap.put("bsOrderDetails.bsStockpileSplitDetails.sellSideId", "L3_sellSideId");
        sortMap.put("bsOrderDetails.bsStockpileSplitDetails.goodsId", "L3_goodsId");
        sortMap.put("bsOrderDetails.bsStockpileSplitDetails.productId", "L3_productId");
        sortMap.put("bsOrderDetails.bsStockpileSplitDetails.manufacturerId", "L3_manufacturerId");
        sortMap.put("bsOrderDetails.bsStockpileSplitDetails.sellerId", "L3_sellerId");
        sortMap.put("bsOrderDetails.bsStockpileSplitDetails.sku", "L3_sku");
        sortMap.put("bsOrderDetails.bsStockpileSplitDetails.batchId", "L3_batchId");
        sortMap.put("bsOrderDetails.bsStockpileSplitDetails.saleLabelId", "L3_saleLabelId");
        sortMap.put("bsOrderDetails.bsStockpileSplitDetails.planSendQuantity", "L3_planSendQuantity");
        sortMap.put("bsOrderDetails.bsStockpileSplitDetails.returnQuantity", "L3_returnQuantity");
        sortMap.put("bsOrderDetails.bsStockpileSplitDetails.version", "L3_version");
        sortMap.put("bsOrderDetails.bsStockpileSplitDetails.sellSideName", "L3A_sellSideName");
        sortMap.put("bsOrderDetails.bsStockpileSplitDetails.sellSideCode", "L3A_sellSideCode");
        sortMap.put("bsOrderDetails.bsStockpileSplitDetails.itemCode", "L3A_itemCode");
        sortMap.put("bsOrderDetails.bsStockpileSplitDetails.itemName", "L3A_itemName");
        sortMap.put("bsOrderDetails.bsStockpileSplitDetails.brandCode", "L3A_brandCode");
        sortMap.put("bsOrderDetails.bsStockpileSplitDetails.brandName", "L3A_brandName");
        sortMap.put("bsOrderDetails.bsStockpileSplitDetails.itemBrandCode", "L3A_itemBrandCode");
        sortMap.put("bsOrderDetails.bsStockpileSplitDetails.manufacturerCode", "L3A_manufacturerCode");
        sortMap.put("bsOrderDetails.bsStockpileSplitDetails.manufacturerName", "L3A_manufacturerName");
        sortMap.put("bsOrderDetails.bsStockpileSplitDetails.sellerCode", "L3A_sellerCode");
        sortMap.put("bsOrderDetails.bsStockpileSplitDetails.sellerName", "L3A_sellerName");
        sortMap.put("bsOrderDetails.bsStockpileSplitDetails.batchCode", "L3A_batchCode");
        sortMap.put("bsOrderDetails.bsStockpileSplitDetails.saleLabelCode", "L3A_saleLabelCode");
        sortMap.put("bsOrderDetails.bsStockpileSplitDetails.saleLabelName", "L3A_saleLabelName");
        sortMap.put("bsOrderDetails.bsStockpileSplitDetails.smallPackageFeature", "L3A_smallPackageFeature");
        sortMap.put("bsOrderDetails.bsStockpileSplitDetails.quantityPerPackage", "L3A_quantityPerPackage");
        sortMap.put("bsOrderDetails.bsStockpileSplitDetails.netWeight", "L3A_netWeight");
        sortMap.put("bsOrderDetails.bsStockpileSplitDetails.grossWeight", "L3A_grossWeight");
        sortMap.put("bsOrderDetails.bsStockpileSplitDetails.cartonSize", "L3A_cartonSize");
        sortMap.put("bsOrderDetails.bsStockpileSplitDetails.productLevel", "L3A_productLevel");
        sortMap.put("bsOrderDetails.bsStockpileSplitDetails.palletStandardStackQuantity",
                "L3A_palletStandardStackQuantity");
        return sortMap;
    }

    @Override
    public BaseDao getBaseDao() {
        return dao;
    }
}
