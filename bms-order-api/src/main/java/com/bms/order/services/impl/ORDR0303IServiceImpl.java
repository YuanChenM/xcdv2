package com.bms.order.services.impl;

import java.util.HashMap;
import java.util.Map;

import com.framework.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.param.ORDR0303IFilterParam;
import com.bms.order.bean.result.ORDR0303IL1RestResult;
import com.bms.order.common.rest.SearchRestParam;
import com.bms.order.common.rest.SearchRestResult;
import com.bms.order.constant.enumeration.OperatorType;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.ORDR0303IDao;
import com.bms.order.services.ORDR0303IService;
import com.framework.base.bean.Pagination;
import com.framework.base.bean.Sort;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.db.DbUtils;
import com.framework.exception.BusinessException;

/**
 * 配送通知单查询接口Service
 *
 * @author li_huiqian
 */
@Service
public class ORDR0303IServiceImpl extends BaseServiceImpl implements ORDR0303IService {

    @Autowired
    private ORDR0303IDao dao;

    /**
     * 平台订单人员查询自己权限可以访问的配送通知单
     *
     * @param operator 操作者
     * @param param    ORDR0303IRestParam
     */
    @Override
    public SearchRestResult<ORDR0303IL1RestResult> execute(Operator operator,
                                                           SearchRestParam<ORDR0303IFilterParam> param) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();
        SearchRestResult<ORDR0303IL1RestResult> result = new SearchRestResult<>();

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
     * @param map HashMap
     */
    private void pre(HashMap<String, Object> map) {
        // 获取参数
        @SuppressWarnings("unchecked")
        SearchRestParam<ORDR0303IFilterParam> param = (SearchRestParam<ORDR0303IFilterParam>) map.get("param");
        ORDR0303IFilterParam filter = param.getFilter();

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
    private void checkDataAuthority(Operator operator, ORDR0303IFilterParam filter) {
        OperatorType operatorType = OperatorType.getInstance(operator.getOperatorType());
        // 买家：自己名下的订单信息
        if (operatorType == OperatorType.BUYER) {
            // 订单.买家ID = 操作者ID
            String[] buyerIds = filter.getBuyerId();

            if (buyerIds != null && buyerIds.length > 0) {
                // 如果查询条件中有买家ID，查询条件中的买家ID只能为自己
                if (buyerIds.length > 1 || !buyerIds[0].equals(operator.getOperatorId()))
                    throw new BusinessException(ModuleCode.ORDR, ErrorCode.E030301);
            }

            // 重新设置查询条件
            filter.setBuyerId(new String[]{operator.getOperatorId()});
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
                    throw new BusinessException(ModuleCode.ORDR, ErrorCode.E030302);
            }

            filter.setSaId(new String[]{String.valueOf(operator.getOperatorId())});
        }

        // 其他情况：报异常
        else {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000001, operatorType.getName());
        }
    }

    /**
     * 计算分页/查询层级
     */
    private void calculateLevel(SearchRestParam<ORDR0303IFilterParam> param) {
        Integer pagingLevel = param.getPagingLevel();
        Pagination pagination = param.getPagination();
        @SuppressWarnings("unused")
        ORDR0303IFilterParam filter = param.getFilter();
        int searchLevel = 0;

        int level1 = 1; // NOTIFICATION
        int level2 = 2; // DETAIL
        int levelAll = 99; // ALL

        // 如果不需要分页
        if (pagination == null) { // && pagingLevel == null
            // 分页层级最高 查询层级2
            pagingLevel = levelAll;
            searchLevel = pagingLevel;
            param.setSearchLevel(searchLevel);
            param.setPagingLevel(pagingLevel);
            return;
        }

        // 计算查询层级
        // 不需要计算，查询条件全为第一层
        searchLevel = level1;

        if (param.getSort() != null) {
            int sortLevel = level1;
            for (Sort sort : param.getSort()) {
                String field = sort.getSortField();
                if (field.startsWith("L2") && sortLevel < level2)
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
    private void processFilter(ORDR0303IFilterParam filter) {
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
    private void removeBlank(ORDR0303IFilterParam filter) {
        // 配送单号
        filter.setDistributionNotificationCode(removeBlank(filter.getDistributionNotificationCode()));

        // 买家订单编码
        filter.setBuyerOrderCode(removeBlank(filter.getBuyerOrderCode()));

        // 买家编码
        filter.setBuyerCode(removeBlank(filter.getBuyerCode()));

        // 买家名称
        filter.setBuyerName(removeBlank(filter.getBuyerName()));

        // 买家类型编码
        filter.setBuyerType(removeBlank(filter.getBuyerType()));

        // 买家类型名称
        filter.setBuyerTypeName(removeBlank(filter.getBuyerTypeName()));
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
    private void removeEmpty(ORDR0303IFilterParam filter) {
        // 配送单ID
        if (filter.getDistributionNotificationId() != null && filter.getDistributionNotificationId().length == 0)
            filter.setDistributionNotificationId(null);

        // 买家订单ID
        if (filter.getBuyerOrderId() != null && filter.getBuyerOrderId().length == 0)
            filter.setBuyerOrderId(null);

        // 买家ID
        if (filter.getBuyerId() != null && filter.getBuyerId().length == 0)
            filter.setBuyerId(null);

        // 配送通知单状态
        if (filter.getDistributionNotificationStu() != null && filter.getDistributionNotificationStu().length == 0)
            filter.setDistributionNotificationStu(null);
    }

    /**
     * 设置检索条件
     *
     * @param filter
     */
    private void setSearchCondition(ORDR0303IFilterParam filter) {
        // 配送单号
        String distributionNotificationCode = filter.getDistributionNotificationCode();
        if (StringUtils.isNotEmpty(distributionNotificationCode)) {
            filter.setDistributionNotificationCode(distributionNotificationCode+"%");
        }

        // 买家订单编码
        filter.setBuyerOrderCode(likeCondition(filter.getBuyerOrderCode(), DbUtils.LikeMode.FRONT));

        // 买家编码
        filter.setBuyerCode(likeCondition(filter.getBuyerCode(), DbUtils.LikeMode.FRONT));

        // 买家名称
        filter.setBuyerName(likeCondition(filter.getBuyerName(), DbUtils.LikeMode.FRONT));

        // 买家类型编码
        filter.setBuyerType(likeCondition(filter.getBuyerType(), DbUtils.LikeMode.FRONT));

        // 买家类型名称
        filter.setBuyerTypeName(likeCondition(filter.getBuyerTypeName(), DbUtils.LikeMode.FRONT));
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
     * @param map HashMap
     */
    private void process(HashMap<String, Object> map) {
        // 获取参数
        @SuppressWarnings("unchecked")
        SearchRestParam<ORDR0303IFilterParam> param = (SearchRestParam<ORDR0303IFilterParam>) map.get("param");

        // 查询
        BaseRestPaginationResult<ORDR0303IL1RestResult> list = findPageList(param);

        map.put("list", list);
    }

    /**
     * 收尾
     *
     * @param map HashMap
     */
    @SuppressWarnings("unchecked")
    private void post(HashMap<String, Object> map) {
        // 获取检索结果
        BaseRestPaginationResult<ORDR0303IL1RestResult> list = (BaseRestPaginationResult<ORDR0303IL1RestResult>) map
                .get("list");
        // 获取结果集
        SearchRestResult<ORDR0303IL1RestResult> result = (SearchRestResult<ORDR0303IL1RestResult>) map.get("result");

        result.setTotal(list.getTotal());
        result.setData(list.getData());
    }

    private Map<String, String> initSortMap() {
        Map<String, String> sortMap = new HashMap<>();
        sortMap.put("distributionNotificationId", "L1_distributionNotificationId");
        sortMap.put("distributionNotificationCode", "L1_distributionNotificationCode");
        sortMap.put("buyerOrderId", "L1_buyerOrderId");
        sortMap.put("buyerOrderCode", "L1_buyerOrderCode");
        sortMap.put("orderType", "L1_orderType");
        sortMap.put("buyerId", "L1_buyerId");
        sortMap.put("buyerType", "L1_buyerType");
        sortMap.put("buyerTypeName", "L1_buyerTypeName");
        sortMap.put("buyerCode", "L1_buyerCode");
        sortMap.put("buyerName", "L1_buyerName");
        sortMap.put("paymentType", "L1_paymentType");
        sortMap.put("receiverName", "L1_receiverName");
        sortMap.put("receiverPhone", "L1_receiverPhone");
        sortMap.put("receiverQq", "L1_receiverQq");
        sortMap.put("receiverWechat", "L1_receiverWechat");
        sortMap.put("receiverMail", "L1_receiverMail");
        sortMap.put("receiverProvince", "L1_receiverProvince");
        sortMap.put("receiverCity", "L1_receiverCity");
        sortMap.put("receiverDistrict", "L1_receiverDistrict");
        sortMap.put("receiverAddress", "L1_receiverAddress");
        sortMap.put("receiverAssistAddress", "L1_receiverAssistAddress");
        sortMap.put("deliveryArea", "L1_deliveryArea");
        sortMap.put("passTrafficModel", "L1_deliveryArea");
        sortMap.put("distributionType", "L1_distributionType");
        sortMap.put("receivePeriod", "L1_receivePeriod");
        sortMap.put("receiveEarliest", "L1_receiveEarliest");
        sortMap.put("receiveLatest", "L1_receiveLatest");
        sortMap.put("receiveWaitHour", "L1_receiveWaitHour");
        sortMap.put("advancedNotificationHour", "L1_advancedNotificationHour");
        sortMap.put("animalQuarantineCertificationFlg", "L1_animalQuarantineCertificationFlg");
        sortMap.put("stevedoreRequirement", "L1_stevedoreRequirement");
        sortMap.put("packageRequirement", "L1_packageRequirement");
        sortMap.put("nearestParkingDistance", "L1_nearestParkingDistance");
        sortMap.put("remark", "L1_remark");
        sortMap.put("expectedSendDatetime", "L1_expectedSendDatetime");
        sortMap.put("expectedArrivalDatetime", "L1_expectedArrivalDatetime");
        sortMap.put("distributionNotificationStu", "L1_distributionNotificationStu");
        sortMap.put("version", "L1_version");
        sortMap.put("details.distributionNotificationDetailId", "L2_distributionNotificationDetailId");
        sortMap.put("details.distributionNotificationId", "L2_distributionNotificationId");
        sortMap.put("details.buyerForcastDeliverDetailId", "L2_buyerForcastDeliverDetailId");
        sortMap.put("details.goodsId", "L2_goodsId");
        sortMap.put("details.sku", "L2_sku");
        sortMap.put("details.batchCode", "L2_batchCode");
        sortMap.put("details.goodsUnit", "L2_goodsUnit");
        sortMap.put("details.sellerCode", "L2_sellerCode");
        sortMap.put("details.distributionQuantity", "L2_distributionQuantity");
        sortMap.put("details.sellSideCode", "L2_sellSideCode");
        sortMap.put("details.logisticsZoneName", "L2_logisticsZoneName");
        sortMap.put("details.version", "L2_version");
        sortMap.put("whCode", "L1_whCode");
        sortMap.put("whName", "L1_whName");
        return sortMap;
    }

    @Override
    public BaseDao getBaseDao() {
        return dao;
    }

}
