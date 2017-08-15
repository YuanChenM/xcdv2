package com.bms.order.services.impl;

import java.util.*;

import com.bms.order.archive.impl.BuyerForcastDeliverDetail;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.param.ORDR0105IFilterParam;
import com.bms.order.bean.result.ORDR0105IL1RestResult;
import com.bms.order.common.rest.SearchRestParam;
import com.bms.order.common.rest.SearchRestResult;
import com.bms.order.constant.enumeration.OperatorType;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.ORDR0105IDao;
import com.bms.order.services.ORDR0105IService;
import com.framework.base.bean.Pagination;
import com.framework.base.bean.Sort;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.db.DbUtils;
import com.framework.exception.BusinessException;

/**
 * 买家订单查询接口Service
 *
 * @author li_huiqian
 */
@Service
public class ORDR0105IServiceImpl extends BaseServiceImpl implements ORDR0105IService {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(ORDR0105IServiceImpl.class);

    @Autowired
    private ORDR0105IDao dao;

    /**
     * 买家/平台订单人员/管家/买手查询自己权限可以访问的订单
     *
     * @param operator
     *            操作者
     * @param param
     *            ORDR0105IRestParam
     */
    @Override
    public SearchRestResult<ORDR0105IL1RestResult> execute(Operator operator,
            SearchRestParam<ORDR0105IFilterParam> param) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();
        SearchRestResult<ORDR0105IL1RestResult> result = new SearchRestResult<ORDR0105IL1RestResult>();
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
        SearchRestParam<ORDR0105IFilterParam> param = (SearchRestParam<ORDR0105IFilterParam>) map.get("param");
        ORDR0105IFilterParam filter = param.getFilter();

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
     * @param filter
     */
    private void checkDataAuthority(Operator operator, ORDR0105IFilterParam filter) {
        logger.info("验证权限开始");
        OperatorType operatorType = OperatorType.getInstance(operator.getOperatorType());
        // 买家：自己名下的订单信息
        if (operatorType == OperatorType.BUYER) {
            // 订单.买家ID = 操作者ID
            String[] buyerIds = filter.getBuyerId();

            if (buyerIds != null && buyerIds.length > 0) {
                // 如果查询条件中有买家ID，查询条件中的买家ID只能为自己
                if (buyerIds.length > 1 || !buyerIds[0].equals(operator.getOperatorId()))
                    throw new BusinessException(ModuleCode.ORDR, ErrorCode.E010501);
            }

            // 重新设置查询条件
            filter.setBuyerId(new String[] { operator.getOperatorId() });
        }

        // 平台人员：平台下所有买家订单信息
        else if (operatorType == OperatorType.MANAGER) {
            // ALL
        }

        // 管家：管家所管理的所有买家订单信息
        else if (operatorType == OperatorType.SA) {
            // 订单.管家ID = 操作者ID
            String[] saIds = filter.getSaId();

            if (saIds != null && saIds.length > 0) {
                // 如果查询条件中有管家ID，查询条件中的管家ID只能为自己
                if (saIds.length > 1 || !saIds[0].equals(operator.getOperatorId()))
                    throw new BusinessException(ModuleCode.ORDR, ErrorCode.E010502);
            }

            filter.setSaId(new String[] { String.valueOf(operator.getOperatorId()) });
        }

        // 买手：只能查询供货主体、销售方为自己的订单
        else if (operatorType == OperatorType.BS) {
            // 供货主体
            // TODO 待定
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E010503);
        }

        // 其他情况：报异常
        else {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E010504, operatorType.getName());
        }
        logger.info("验证权限结束");
    }

    /**
     * 计算分页/查询层级
     */
    private void calculateLevel(SearchRestParam<ORDR0105IFilterParam> param) {
        logger.info("计算分页/查询层级开始");
        Integer pagingLevel = param.getPagingLevel();
        Pagination pagination = param.getPagination();
        ORDR0105IFilterParam filter = param.getFilter();
        int searchLevel = 0;

        int level1 = 1; // ORDER
        int level2 = 2; // BATCH
        int level3 = 3; // DETAIL
        int level4 = 4; // SPLIT
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
        if (null != filter.getSellSideType() || null != filter.getSellSideId() || null != filter.getSellSideCode()
                || null != filter.getSellSideName() || null != filter.getForcastType()
                || null != filter.getSellSideType()) {
            searchLevel = level4;
        } else if (null != filter.getGoodsId() || null != filter.getBuyerBatchOrderDetailId()
                || null != filter.getGoodsCode() || null != filter.getGoodsName() || null != filter.getSaleLabelId()
                || null != filter.getSaleLabelCode() || null != filter.getSaleLabelName()
                || null != filter.getManufacturerId() || null != filter.getManufacturerCode()
                || null != filter.getManufacturerName() || null != filter.getSellerId()
                || null != filter.getSellerCode() || null != filter.getSellerName()) {
            searchLevel = level3;
        } else if (null != filter.getBatchOrderId() || null != filter.getBatchOrderCode()
                || null != filter.getRequiredDistributionDateFrom() || null != filter.getRequiredDistributionDateTo()
                || null != filter.getBuyerBatchOrderStu()) {
            searchLevel = level2;
        } else if (null != filter.getBuyerOrderId() || null != filter.getBuyerOrderCode() || null != filter.getBackNo()
                || null != filter.getOrderType() || null != filter.getBatchFlg() || null != filter.getOrderSourceType()
                || null != filter.getSalePlatformType() || null != filter.getBuyerOrderStu()
                || null != filter.getOrderPlaceType() || null != filter.getOrderPlacerType()
                || null != filter.getOrderPlacerId() || null != filter.getOrderPlacerCode()
                || null != filter.getOrderPlacerName() || null != filter.getOrderPlaceDateTimeFrom()
                || null != filter.getOrderPlaceDateTimeTo() || null != filter.getPaymentType()
                || null != filter.getInvoiceFlg() || null != filter.getUseNetFlg()
                || null != filter.getLogisticsZoneId() || null != filter.getLogisticsZoneCode()
                || null != filter.getLogisticsZoneName() || null != filter.getBuyerId() || null != filter.getBuyerCode()
                || null != filter.getBuyerName() || null != filter.getBuyerType() || null != filter.getBuyerTypeName()
                || null != filter.getNetBuyerFlg() || null != filter.getBsType() || null != filter.getBsId()
                || null != filter.getBsName() || null != filter.getBsType() || null != filter.getSaId()
                || null != filter.getSaName() || null != filter.getSaCode()) {
            searchLevel = level1;
        }

        if (param.getSort() != null) {
            int sortLevel = level1;
            for (Sort sort : param.getSort()) {
                String field = sort.getSortField();
                if (field.startsWith("L4") && sortLevel < level4)
                    sortLevel = level4;
                else if (field.startsWith("L3") && sortLevel < level3)
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
        logger.info("计算分页/查询层级结束");
    }

    /**
     * 处理过滤器
     * 
     * @param filter
     */
    private void processFilter(ORDR0105IFilterParam filter) {
        logger.info("处理filter开始");
        // 移除空字符串
        removeBlank(filter);

        // 移除空数组
        removeEmpty(filter);

        // 设置模糊检索
        setSearchCondition(filter);

        // 移除空数组
        if (filter.getBuyerOrderId() != null && filter.getBuyerOrderId().length == 0)
            filter.setBuyerOrderId(null);
        if (filter.getOrderType() != null && filter.getOrderType().length == 0)
            filter.setOrderType(null);
        if (filter.getOrderSourceType() != null && filter.getOrderSourceType().length == 0)
            filter.setOrderSourceType(null);
        if (filter.getSalePlatformType() != null && filter.getSalePlatformType().length == 0)
            filter.setSalePlatformType(null);
        if (filter.getBuyerOrderStu() != null && filter.getBuyerOrderStu().length == 0)
            filter.setBuyerOrderStu(null);
        if (filter.getOrderPlaceType() != null && filter.getOrderPlaceType().length == 0)
            filter.setOrderPlaceType(null);
        if (filter.getOrderPlacerType() != null && filter.getOrderPlacerType().length == 0)
            filter.setOrderPlacerType(null);
        if (filter.getOrderPlacerId() != null && filter.getOrderPlacerId().length == 0)
            filter.setOrderPlacerId(null);
        if (filter.getPaymentType() != null && filter.getPaymentType().length == 0)
            filter.setPaymentType(null);
        if (filter.getLogisticsZoneId() != null && filter.getLogisticsZoneId().length == 0)
            filter.setLogisticsZoneId(null);
        if (filter.getBatchOrderId() != null && filter.getBatchOrderId().length == 0)
            filter.setBatchOrderId(null);
        if (filter.getBuyerBatchOrderStu() != null && filter.getBuyerBatchOrderStu().length == 0)
            filter.setBuyerBatchOrderStu(null);
        if (filter.getBuyerBatchOrderDetailId() != null && filter.getBuyerBatchOrderDetailId().length == 0)
            filter.setBuyerBatchOrderDetailId(null);
        if (filter.getBuyerId() != null && filter.getBuyerId().length == 0)
            filter.setBuyerId(null);
        if (filter.getBsType() != null && filter.getBsType().length == 0)
            filter.setBsType(null);
        if (filter.getBsId() != null && filter.getBsId().length == 0)
            filter.setBsId(null);
        if (filter.getSaId() != null && filter.getSaId().length == 0)
            filter.setSaId(null);
        if (filter.getSellSideType() != null && filter.getSellSideType().length == 0)
            filter.setSellSideType(null);
        if (filter.getSellSideId() != null && filter.getSellSideId().length == 0)
            filter.setSellSideId(null);
        if (filter.getManufacturerId() != null && filter.getManufacturerId().length == 0)
            filter.setManufacturerId(null);
        if (filter.getSellerId() != null && filter.getSellerId().length == 0)
            filter.setSellerId(null);
        if (filter.getRegionalDistributionStation() != null && filter.getRegionalDistributionStation().length == 0)
            filter.setRegionalDistributionStation(null);
        logger.info("处理filter结束");
    }

    /**
     * 移除空字符串（trim后）
     * 
     * @param filter
     */
    private void removeBlank(ORDR0105IFilterParam filter) {
        // 订单编码
        filter.setBuyerOrderCode(removeBlank(filter.getBuyerOrderCode()));
        // 订单：参考号
        filter.setBackNo(removeBlank(filter.getBackNo()));
        // 下单员编码
        filter.setOrderPlacerCode(removeBlank(filter.getOrderPlacerCode()));
        // 下单员名称
        filter.setOrderPlacerName(removeBlank(filter.getOrderPlacerName()));
        // 物流区编码
        filter.setLogisticsZoneCode(removeBlank(filter.getLogisticsZoneCode()));
        // 物流区名称
        filter.setLogisticsZoneName(removeBlank(filter.getLogisticsZoneName()));
        // 分批订单编码
        filter.setBatchOrderCode(removeBlank(filter.getBatchOrderCode()));
        // 买家编码
        filter.setBuyerCode(removeBlank(filter.getBuyerCode()));
        // 买家类型编码
        filter.setBuyerTypeName(removeBlank(filter.getBuyerTypeName()));
        // 买家类型名称
        filter.setBuyerName(removeBlank(filter.getBuyerName()));
        // 买手名称
        filter.setBsName(removeBlank(filter.getBsName()));
        // 管家名称
        filter.setSaName(removeBlank(filter.getSaName()));
        // 管家编码
        filter.setSaCode(removeBlank(filter.getSaCode()));
        // 预配送类型
        filter.setForcastType(removeBlank(filter.getForcastType()));
        // 销售方编码
        filter.setSellSideCode(removeBlank(filter.getSellSideCode()));
        // 销售方名称
        filter.setSellSideName(removeBlank(filter.getSellSideName()));
        // 生产商编码
        filter.setManufacturerCode(removeBlank(filter.getManufacturerCode()));
        // 生产商名称
        filter.setManufacturerName(removeBlank(filter.getManufacturerName()));
        // 卖家编码
        filter.setSellerCode(removeBlank(filter.getSellerCode()));
        // 卖家名称
        filter.setSellerName(removeBlank(filter.getSellerName()));
        // 区域配送站编码
        filter.setRegionalDistributionStationCode(removeBlank(filter.getRegionalDistributionStationCode()));
        // 区域配送站名称
        filter.setRegionalDistributionStationName(removeBlank(filter.getRegionalDistributionStationName()));
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
    private void removeEmpty(ORDR0105IFilterParam filter) {
        // 订单ID
        if (filter.getBuyerOrderId() != null && filter.getBuyerOrderId().length == 0)
            filter.setBuyerOrderId(null);
        // 订单类型
        if (filter.getOrderType() != null && filter.getOrderType().length == 0)
            filter.setOrderType(null);
        // 买家类型
        if (filter.getBuyerType() != null && filter.getBuyerType().length == 0)
            filter.setBuyerType(null);
        // 订单来源
        if (filter.getOrderSourceType() != null && filter.getOrderSourceType().length == 0)
            filter.setOrderSourceType(null);
        // 销售平台
        if (filter.getSalePlatformType() != null && filter.getSalePlatformType().length == 0)
            filter.setSalePlatformType(null);
        // 订单状态
        if (filter.getBuyerOrderStu() != null && filter.getBuyerOrderStu().length == 0)
            filter.setBuyerOrderStu(null);
        // 下单类型
        if (filter.getOrderPlaceType() != null && filter.getOrderPlaceType().length == 0)
            filter.setOrderPlaceType(null);
        // 下单员类型
        if (filter.getOrderPlacerType() != null && filter.getOrderPlacerType().length == 0)
            filter.setOrderPlacerType(null);
        // 下单员ID
        if (filter.getOrderPlacerId() != null && filter.getOrderPlacerId().length == 0)
            filter.setOrderPlacerId(null);
        // 付款类型
        if (filter.getPaymentType() != null && filter.getPaymentType().length == 0)
            filter.setPaymentType(null);
        // 物流区ID
        if (filter.getLogisticsZoneId() != null && filter.getLogisticsZoneId().length == 0)
            filter.setLogisticsZoneId(null);
        // 分批订单ID
        if (filter.getBatchOrderId() != null && filter.getBatchOrderId().length == 0)
            filter.setBatchOrderId(null);
        // 分批订单状态
        if (filter.getBuyerBatchOrderStu() != null && filter.getBuyerBatchOrderStu().length == 0)
            filter.setBuyerBatchOrderStu(null);
        // 分批订单明细Id
        if (filter.getBuyerBatchOrderDetailId() != null && filter.getBuyerBatchOrderDetailId().length == 0)
            filter.setBuyerBatchOrderDetailId(null);
        // 买家ID
        if (filter.getBuyerId() != null && filter.getBuyerId().length == 0)
            filter.setBuyerId(null);
        // 买手类型
        if (filter.getBsType() != null && filter.getBsType().length == 0)
            filter.setBsType(null);
        // 专属买手ID
        if (filter.getBsId() != null && filter.getBsId().length == 0)
            filter.setBsId(null);
        // 管家ID
        if (filter.getSaId() != null && filter.getSaId().length == 0)
            filter.setSaId(null);
        // 供货主体
        if (filter.getSellSideType() != null && filter.getSellSideType().length == 0)
            filter.setSellSideType(null);
        // 销售方ID
        if (filter.getSellSideId() != null && filter.getSellSideId().length == 0)
            filter.setSellSideId(null);
        // 生产商Id
        if (filter.getManufacturerId() != null && filter.getManufacturerId().length == 0)
            filter.setManufacturerId(null);
        // 卖家Id
        if (filter.getSellerId() != null && filter.getSellerId().length == 0)
            filter.setSellerId(null);
        // 区域配送站ID
        if (filter.getRegionalDistributionStation() != null && filter.getRegionalDistributionStation().length == 0)
            filter.setRegionalDistributionStation(null);
    }

    /**
     * 模糊检索设置
     * 
     * @param filter
     */
    private void setSearchCondition(ORDR0105IFilterParam filter) {
        // 订单编码
        filter.setBuyerOrderCode(likeCondition(filter.getBuyerOrderCode(), DbUtils.LikeMode.FRONT));
        // 订单:参考号
        filter.setBackNo(likeCondition(filter.getBackNo(), DbUtils.LikeMode.FRONT));
        // 下单员编码
        filter.setOrderPlacerCode(likeCondition(filter.getOrderPlacerCode(), DbUtils.LikeMode.FRONT));
        // 下单员名称
        filter.setOrderPlacerName(likeCondition(filter.getOrderPlacerName(), DbUtils.LikeMode.FRONT));
        // 物流区编码
        filter.setLogisticsZoneCode(likeCondition(filter.getLogisticsZoneCode(), DbUtils.LikeMode.FRONT));
        // 物流区名称
        filter.setLogisticsZoneName(likeCondition(filter.getLogisticsZoneName(), DbUtils.LikeMode.FRONT));
        // 分批订单编码
        filter.setBatchOrderCode(likeCondition(filter.getBatchOrderCode(), DbUtils.LikeMode.FRONT));
        // 买家编码
        filter.setBuyerCode(likeCondition(filter.getBuyerCode(), DbUtils.LikeMode.FRONT));
        // 买家类型名称
        filter.setBuyerTypeName(likeCondition(filter.getBuyerTypeName(), DbUtils.LikeMode.FRONT));
        // 买家名称
        filter.setBuyerName(likeCondition(filter.getBuyerName(), DbUtils.LikeMode.FRONT));
        // 买手名称
        filter.setBsName(likeCondition(filter.getBsName(), DbUtils.LikeMode.FRONT));
        // 管家名称
        filter.setSaName(likeCondition(filter.getSaName(), DbUtils.LikeMode.FRONT));
        // 管家编码
        filter.setSaCode(likeCondition(filter.getSaCode(), DbUtils.LikeMode.FRONT));
        // 销售方编码
        filter.setSellSideCode(likeCondition(filter.getSellSideCode(), DbUtils.LikeMode.FRONT));
        // 销售方名称
        filter.setSellSideName(likeCondition(filter.getSellSideName(), DbUtils.LikeMode.FRONT));
        // 生产商编码
        filter.setManufacturerCode(likeCondition(filter.getManufacturerCode(), DbUtils.LikeMode.FRONT));
        // 生产商名称
        filter.setManufacturerName(likeCondition(filter.getManufacturerName(), DbUtils.LikeMode.FRONT));
        // 卖家编码
        filter.setSellerCode(likeCondition(filter.getSellerCode(), DbUtils.LikeMode.FRONT));
        // 卖家名称
        filter.setSellerName(likeCondition(filter.getSellerName(), DbUtils.LikeMode.FRONT));
        // 商品编码
        filter.setGoodsCode(likeCondition(filter.getGoodsCode(), DbUtils.LikeMode.FRONT));
        // 商品名称
        filter.setGoodsName(likeCondition(filter.getGoodsName(), DbUtils.LikeMode.FRONT));
        // 销售标签编码
        filter.setSaleLabelCode(likeCondition(filter.getSaleLabelCode(), DbUtils.LikeMode.FRONT));
        // 销售标签名称
        filter.setSaleLabelName(likeCondition(filter.getSaleLabelName(), DbUtils.LikeMode.FRONT));
        // 区域配送站编码
        filter.setRegionalDistributionStationCode(
                likeCondition(filter.getRegionalDistributionStationCode(), DbUtils.LikeMode.FRONT));
        // 区域配送站名称
        filter.setRegionalDistributionStationName(
                likeCondition(filter.getRegionalDistributionStationName(), DbUtils.LikeMode.FRONT));
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
        logger.info("处理sort开始");
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
        logger.info("处理sort结束");
    }

    /**
     * 执行
     *
     * @param map
     *            HashMap
     */
    private void process(HashMap<String, Object> map) {
        @SuppressWarnings("unchecked")
        SearchRestParam<ORDR0105IFilterParam> param = (SearchRestParam<ORDR0105IFilterParam>) map.get("param");
        // 获取参数
        logger.info("Sql执行开始");
        BaseRestPaginationResult<ORDR0105IL1RestResult> list = new BaseRestPaginationResult<ORDR0105IL1RestResult>();
        List<ORDR0105IL1RestResult> restResults = dao.findOrdersInfo(param);
        int count = restResults.size();
        if (param.getPagination() != null)
            count = dao.getCount(param);
        list.setTotal(count);
        list.setData(restResults);
        map.put("list", list);
        logger.info("Sql执行结束");
        // 返回参数
    }

    /**
     * 收尾
     *
     * @param map
     *            HashMap
     */
    @SuppressWarnings("unchecked")
    private void post(HashMap<String, Object> map) {
        // 获取检索结果
        logger.info("数据封装开始");
        BaseRestPaginationResult<ORDR0105IL1RestResult> list = (BaseRestPaginationResult<ORDR0105IL1RestResult>) map.get("list");
        // 获取结果
        SearchRestResult<ORDR0105IL1RestResult> result = (SearchRestResult<ORDR0105IL1RestResult>) map.get("result");
        result.setTotal(list.getTotal());
        result.setData(list.getData());
        logger.info("数据封装结束");
    }

    private Map<String, String> initSortMap() {
        Map<String, String> sortMap = new HashMap<>();
        sortMap.put("buyerOrderId", "L1_buyerOrderId");
        sortMap.put("buyerOrderCode", "L1_buyerOrderCode");
        sortMap.put("orderType", "L1_orderType");
        sortMap.put("salePlatformType", "L1_salePlatformType");
        sortMap.put("orderSourceType", "L1_orderSourceType");
        sortMap.put("batchFlg", "L1_batchFlg");
        sortMap.put("orderSplitType", "L1_orderSplitType");
        sortMap.put("orderPlacerId", "L1_orderPlacerId");
        sortMap.put("orderPlacerType", "L1_orderPlacerType");
        sortMap.put("orderPlaceDatetime", "L1_orderPlaceDatetime");
        sortMap.put("orderPlaceType", "L1_orderPlaceType");
        sortMap.put("logisticsZoneId", "L1_logisticsZoneId");
        sortMap.put("buyerType", "L1_buyerType");
        sortMap.put("buyerTypeName", "L1_buyerTypeName");
        sortMap.put("buyerId", "L1_buyerId");
        sortMap.put("bsType", "L1_bsType");
        sortMap.put("bsId", "L1_bsId");
        sortMap.put("invoiceFlg", "L1_invoiceFlg");
        sortMap.put("netBuyerFlg", "L1_netBuyerFlg");
        sortMap.put("useNetFlg", "L1_useNetFlg");
        sortMap.put("paymentType", "L1_paymentType");
        sortMap.put("paymentStu", "L1_paymentStu");
        sortMap.put("orderAmount", "L1_orderAmount");
        sortMap.put("freight", "L1_freight");
        sortMap.put("preferentialAmount", "L1_preferentialAmount");
        sortMap.put("receiveAmount", "L1_receiveAmount");
        sortMap.put("earnestPercent", "L1_earnestPercent");
        sortMap.put("earnestAmount", "L1_earnestAmount");
        sortMap.put("advancePaymentPercent", "L1_advancePaymentPercent");
        sortMap.put("advancePaymentAmount", "L1_advancePaymentAmount");
        sortMap.put("buyerOrderStu", "L1_buyerOrderStu");
        sortMap.put("version", "L1_version");
        sortMap.put("orderPlacerCode", "L1A_orderPlacerCode");
        sortMap.put("orderPlacerName", "L1A_orderPlacerName");
        sortMap.put("logisticsZoneCode", "L1A_logisticsZoneCode");
        sortMap.put("logisticsZoneName", "L1A_logisticsZoneName");
        sortMap.put("cityId", "L1A_cityId");
        sortMap.put("cityName", "L1A_cityName");
        sortMap.put("countryId", "L1A_countryId");
        sortMap.put("countryName", "L1A_countryName");
        sortMap.put("regionalDistributionStation", "L1A_regionalDistributionStation");
        sortMap.put("regionalDistributionStationCode", "L1A_regionalDistributionStationCode");
        sortMap.put("regionalDistributionStationName", "L1A_regionalDistributionStationName");
        sortMap.put("buyerCode", "L1A_buyerCode");
        sortMap.put("buyerName", "L1A_buyerName");
        sortMap.put("buyerPhone", "L1A_buyerPhone");
        sortMap.put("buyerWechat", "L1A_buyerWechat");
        sortMap.put("buyerQq", "L1A_buyerQq");
        sortMap.put("buyerMail", "L1A_buyerMail");
        sortMap.put("regionalBsId", "L1A_regionalBsId");
        sortMap.put("regionalBsCode", "L1A_regionalBsCode");
        sortMap.put("regionalBsName", "L1A_regionalBsName");
        sortMap.put("nonRegionalBsId", "L1A_nonRegionalBsId");
        sortMap.put("nonRegionalBsCode", "L1A_nonRegionalBsCode");
        sortMap.put("nonRegionalBsName", "L1A_nonRegionalBsName");
        sortMap.put("regionalDistributionBsId", "L1A_regionalDistributionBsId");
        sortMap.put("regionalDistributionBsCode", "L1A_regionalDistributionBsCode");
        sortMap.put("regionalDistributionBsName", "L1A_regionalDistributionBsName");
        sortMap.put("netUserBsId", "L1A_netUserBsId");
        sortMap.put("netUserBsCode", "L1A_netUserBsCode");
        sortMap.put("netUserBsName", "L1A_netUserBsName");
        sortMap.put("saId", "L1A_saId");
        sortMap.put("saCode", "L1A_saCode");
        sortMap.put("saName", "L1A_saName");
        sortMap.put("cancelModelType", "L1C_cancelModelType");
        sortMap.put("cancelModelId", "L1C_cancelModelId");
        sortMap.put("cancelType", "L1C_cancelType");
        sortMap.put("cancelPersonType", "L1C_cancelPersonType");
        sortMap.put("cancelPersonId", "L1C_cancelPersonId");
        sortMap.put("cancelPersonCode", "L1C_cancelPersonCode");
        sortMap.put("cancelPersonName", "L1C_cancelPersonName");
        sortMap.put("cancelDatetime", "L1C_cancelDatetime");
        sortMap.put("cancelReason", "L1C_cancelReason");
        sortMap.put("batchOrders.buyerBatchOrderId", "L2_buyerBatchOrderId");
        sortMap.put("batchOrders.buyerBatchOrderCode", "L2_buyerBatchOrderCode");
        sortMap.put("batchOrders.buyerOrderId", "L2_buyerOrderId");
        sortMap.put("batchOrders.requiredDistributionDate", "L2_requiredDistributionDate");
        sortMap.put("batchOrders.expectedSendDatetime", "L2_expectedSendDatetime");
        sortMap.put("batchOrders.expectedArrivalDatetime", "L2_expectedArrivalDatetime");
        sortMap.put("batchOrders.orderAmount", "L2_orderAmount");
        sortMap.put("batchOrders.freight", "L2_freight");
        sortMap.put("batchOrders.preferentialAmount", "L2_preferentialAmount");
        sortMap.put("batchOrders.receiveAmount", "L2_receiveAmount");
        sortMap.put("batchOrders.earnestPercent", "L2_earnestPercent");
        sortMap.put("batchOrders.earnestAmount", "L2_earnestAmount");
        sortMap.put("batchOrders.advancePaymentPercent", "L2_advancePaymentPercent");
        sortMap.put("batchOrders.advancePaymentAmount", "L2_advancePaymentAmount");
        sortMap.put("batchOrders.buyerBatchOrderStu", "L2_buyerBatchOrderStu");
        sortMap.put("batchOrders.version", "L2_version");
        sortMap.put("batchOrders.receiverName", "L2A_receiverName");
        sortMap.put("batchOrders.receiverPhone", "L2A_receiverPhone");
        sortMap.put("batchOrders.receiverQq", "L2A_receiverQq");
        sortMap.put("batchOrders.receiverWechat", "L2A_receiverWechat");
        sortMap.put("batchOrders.receiverMail", "L2A_receiverMail");
        sortMap.put("batchOrders.receiverProvince", "L2A_receiverProvince");
        sortMap.put("batchOrders.receiverCity", "L2A_receiverCity");
        sortMap.put("batchOrders.receiverDistrict", "L2A_receiverDistrict");
        sortMap.put("batchOrders.receiverAddress", "L2A_receiverAddress");
        sortMap.put("batchOrders.receiverAssistAddress", "L2A_receiverAssistAddress");
        sortMap.put("batchOrders.deliveryArea", "L2A_deliveryArea");
        sortMap.put("batchOrders.passTrafficModel", "L2A_passTrafficModel");
        sortMap.put("batchOrders.distributionType", "L2A_distributionType");
        sortMap.put("batchOrders.receivePeriod", "L2A_receivePeriod");
        sortMap.put("batchOrders.receiveEarliest", "L2A_receiveEarliest");
        sortMap.put("batchOrders.receiveLatest", "L2A_receiveLatest");
        sortMap.put("batchOrders.receiveWaitHour", "L2A_receiveWaitHour");
        sortMap.put("batchOrders.advancedNotificationHour", "L2A_advancedNotificationHour");
        sortMap.put("batchOrders.animalQuarantineCertificationFlg", "L2A_animalQuarantineCertificationFlg");
        sortMap.put("batchOrders.stevedoreRequirement", "L2A_stevedoreRequirement");
        sortMap.put("batchOrders.packageRequirement", "L2A_packageRequirement");
        sortMap.put("batchOrders.nearestParkingDistance", "L2A_nearestParkingDistance");
        sortMap.put("batchOrders.remark", "L2A_remark");
        sortMap.put("batchOrders.batchOrderDetails.buyerBatchOrderDetailId", "L3_buyerBatchOrderDetailId");
        sortMap.put("batchOrders.batchOrderDetails.buyerOrderId", "L3_buyerOrderId");
        sortMap.put("batchOrders.batchOrderDetails.buyerBatchOrderId", "L3_buyerBatchOrderId");
        sortMap.put("batchOrders.batchOrderDetails.goodsUnit", "L3_goodsUnit");
        sortMap.put("batchOrders.batchOrderDetails.goodsQuantity", "L3_goodsQuantity");
        sortMap.put("batchOrders.batchOrderDetails.cancelQuantity", "L3_cancelQuantity");
        sortMap.put("batchOrders.batchOrderDetails.orderCreatePrice", "L3_orderCreatePrice");
        sortMap.put("batchOrders.batchOrderDetails.realUnitPrice", "L3_realUnitPrice");
        sortMap.put("batchOrders.batchOrderDetails.goodsId", "L3_goodsId");
        sortMap.put("batchOrders.batchOrderDetails.productId", "L3_productId");
        sortMap.put("batchOrders.batchOrderDetails.manufacturerId", "L3_manufacturerId");
        sortMap.put("batchOrders.batchOrderDetails.sellerId", "L3_sellerId");
        sortMap.put("batchOrders.batchOrderDetails.batchId", "L3_batchId");
        sortMap.put("batchOrders.batchOrderDetails.saleLabelId", "L3_saleLabelId");
        sortMap.put("batchOrders.batchOrderDetails.splitFlg", "L3_splitFlg");
        sortMap.put("batchOrders.batchOrderDetails.manualSplitFlg", "L3_manualSplitFlg");
        sortMap.put("batchOrders.batchOrderDetails.version", "L3_version");
        sortMap.put("batchOrders.batchOrderDetails.itemCode", "L3A_itemCode");
        sortMap.put("batchOrders.batchOrderDetails.itemName", "L3A_itemName");
        sortMap.put("batchOrders.batchOrderDetails.brandCode", "L3A_brandCode");
        sortMap.put("batchOrders.batchOrderDetails.brandName", "L3A_brandName");
        sortMap.put("batchOrders.batchOrderDetails.itemBrandCode", "L3A_itemBrandCode");
        sortMap.put("batchOrders.batchOrderDetails.manufacturerCode", "L3A_manufacturerCode");
        sortMap.put("batchOrders.batchOrderDetails.manufacturerName", "L3A_manufacturerName");
        sortMap.put("batchOrders.batchOrderDetails.sellerCode", "L3A_sellerCode");
        sortMap.put("batchOrders.batchOrderDetails.sellerName", "L3A_sellerName");
        sortMap.put("batchOrders.batchOrderDetails.batchCode", "L3A_batchCode");
        sortMap.put("batchOrders.batchOrderDetails.saleLabelCode", "L3A_saleLabelCode");
        sortMap.put("batchOrders.batchOrderDetails.saleLabelName", "L3A_saleLabelName");
        sortMap.put("batchOrders.batchOrderDetails.smallPackageFeature", "L3A_smallPackageFeature");
        sortMap.put("batchOrders.batchOrderDetails.quantityPerPackage", "L3A_quantityPerPackage");
        sortMap.put("batchOrders.batchOrderDetails.netWeight", "L3A_netWeight");
        sortMap.put("batchOrders.batchOrderDetails.grossWeight", "L3A_grossWeight");
        sortMap.put("batchOrders.batchOrderDetails.cartonSize", "L3A_cartonSize");
        sortMap.put("batchOrders.batchOrderDetails.productLevel", "L3A_productLevel");
        sortMap.put("batchOrders.batchOrderDetails.palletStandardStackQuantity", "L3A_palletStandardStackQuantity");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.buyerForcastDeliverDetailId",
                "L4_buyerForcastDeliverDetailId");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.buyerBatchOrderId",
                "L4_buyerBatchOrderId");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.buyerBatchOrderDetailId",
                "L4_buyerBatchOrderDetailId");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.forcastType", "L4_forcastType");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.sellSideType", "L4_sellSideType");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.sellSideId", "L4_sellSideId");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.goodsId", "L4_goodsId");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.productId", "L4_productId");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.manufacturerId", "L4_manufacturerId");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.sellerId", "L4_sellerId");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.sku", "L4_sku");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.batchId", "L4_batchId");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.saleLabelId", "L4_saleLabelId");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.planSendQuantity",
                "L4_planSendQuantity");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.realSendQuantity",
                "L4_realSendQuantity");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.receiveQuantity",
                "L4_receiveQuantity");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.rejectQuantity", "L4_rejectQuantity");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.delayQuantity", "L4_delayQuantity");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.redistributionDate",
                "L4_redistributionDate");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.returnQuantity", "L4_returnQuantity");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.version", "L4_version");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.sellSideCode", "L4A_sellSideCode");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.sellSideName", "L4A_sellSideName");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.itemCode", "L4A_itemCode");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.itemName", "L4A_itemName");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.brandCode", "L4A_brandCode");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.brandName", "L4A_brandName");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.itemBrandCode", "L4A_itemBrandCode");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.manufacturerCode",
                "L4A_manufacturerCode");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.manufacturerName",
                "L4A_manufacturerName");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.sellerCode", "L4A_sellerCode");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.sellerName", "L4A_sellerName");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.batchCode", "L4A_batchCode");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.saleLabelCode", "L4A_saleLabelCode");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.saleLabelName", "L4A_saleLabelName");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.smallPackageFeature",
                "L4A_smallPackageFeature");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.quantityPerPackage",
                "L4A_quantityPerPackage");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.netWeight", "L4A_netWeight");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.grossWeight", "L4A_grossWeight");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.cartonSize", "L4A_cartonSize");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.productLevel", "L4A_productLevel");
        sortMap.put("batchOrders.batchOrderDetails.orderBuyerForcastDeliverDetail.palletStandardStackQuantity",
                "L4A_palletStandardStackQuantity");
        return sortMap;
    }

    @Override
    public BaseDao getBaseDao() {
        return dao;
    }
}
