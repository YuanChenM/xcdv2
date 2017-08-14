package com.bms.issue.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.bms.issue.constant.i18n.ErrorCode;
import com.bms.issue.constant.i18n.ModuleCode;
import com.bms.issue.dao.ISSU0105IDao;
import com.framework.base.bean.Sort;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.core.db.DbUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.issue.archive.impl.Operator;
import com.bms.issue.bean.Blackboard;
import com.bms.issue.bean.param.ISSU0105IFilter;
import com.bms.issue.bean.result.ISSU0105IRestResult;
import com.bms.issue.common.rest.SearchRestParam;
import com.bms.issue.common.rest.SearchRestResult;
import com.bms.issue.service.ISSU0105IService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;

/**
 * 问题订单查询接口Service
 * 
 * @author li_huiqian
 */
@Service
public class ISSU0105IServiceImpl extends BaseServiceImpl implements ISSU0105IService {

     @Autowired
     private ISSU0105IDao dao;

    /**
     * 查询问题订单相关信息
     * 
     * @param operator 操作者
     * @param param
     *
     */
    @Override
    public SearchRestResult<ISSU0105IRestResult> execute(Operator operator, SearchRestParam<ISSU0105IFilter> param) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();
        SearchRestResult<ISSU0105IRestResult> result = new SearchRestResult<>();
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
        SearchRestParam<ISSU0105IFilter> param = (SearchRestParam<ISSU0105IFilter>) map.get("param");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        ISSU0105IFilter filter = param.getFilter();

        // 操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);

        // 数据权限验证
        checkDataAuthority(operator, filter);

        // 处理filter
        if(null != filter){
            processFilter(filter);
        }

        // 处理sort
        processSort(param.getSort());

    }

    /**
     * 执行
     * 
     * @param map HashMap
     */
    private void process(HashMap<String, Object> map) {
        SearchRestParam<ISSU0105IFilter> param = (SearchRestParam<ISSU0105IFilter>) map.get("param");
        BaseRestPaginationResult<ISSU0105IRestResult> restResult = super.findPageList(param);
        SearchRestResult<ISSU0105IRestResult> result = (SearchRestResult<ISSU0105IRestResult>) map.get("result");
        result.setData(restResult.getData());
        result.setTotal(restResult.getTotal());
    }

    /**
     * 收尾
     * 
     * @param map HashMap
     */
    private void post(HashMap<String, Object> map) {

    }

    private void checkDataAuthority(Operator operator,ISSU0105IFilter filter){
        //目前没有
    }

    /**
     *
     * @param filter
     */
    private void processFilter(ISSU0105IFilter filter){
        // 移除空字符串
        removeBlank(filter);

        // 移除空数组
        removeEmpty(filter);

        // 设置模糊检索
        setSearchCondition(filter);
    }

    /**
     * 移除空字符串
     * @param filter
     */
    private void removeBlank(ISSU0105IFilter filter){
        filter.setIssueCode(strRemoveBlank(filter.getIssueCode()));
        filter.setInitiatorName(strRemoveBlank(filter.getInitiatorName()));
        filter.setInitiatorTimeFrom(strRemoveBlank(filter.getInitiatorTimeFrom()));
        filter.setInitiatorTimeTo(strRemoveBlank(filter.getInitiatorTimeTo()));
        filter.setCloseTimeFrom(strRemoveBlank(filter.getCloseTimeFrom()));
        filter.setCloseTimeTo(strRemoveBlank(filter.getCloseTimeTo()));
        filter.setIssueDesc(strRemoveBlank(filter.getIssueDesc()));
        filter.setOrderCode(strRemoveBlank(filter.getOrderCode()));
        filter.setBuyerCode(strRemoveBlank(filter.getBuyerCode()));
        filter.setBuyerName(strRemoveBlank(filter.getBuyerName()));
    }

    /**
     * 移除空数组
     * @param filter
     */
    private void removeEmpty(ISSU0105IFilter filter){

        if (filter.getInitiatorType() != null && filter.getInitiatorType().length == 0)
            filter.setInitiatorType(null);

        if (filter.getIssueId() != null && filter.getIssueId().length == 0)
            filter.setIssueId(null);

        if (filter.getIssueStatus() != null && filter.getIssueStatus().length == 0)
            filter.setIssueStatus(null);

        if (filter.getOrderId() != null && filter.getOrderId().length == 0)
            filter.setOrderId(null);

        if (filter.getBuyerId() != null && filter.getBuyerId().length == 0)
            filter.setBuyerId(null);

        if (filter.getLogisticsZoneId() != null && filter.getLogisticsZoneId().length == 0)
            filter.setLogisticsZoneId(null);
    }

    /**
     * 设置模糊检索
     * @param filter
     */
    private void setSearchCondition(ISSU0105IFilter filter){

        filter.setInitiatorName(
                likeCondition(filter.getInitiatorName(), DbUtils.LikeMode.FRONT));

        filter.setBuyerCode(
                likeCondition(filter.getBuyerCode(), DbUtils.LikeMode.FRONT));

        filter.setIssueDesc(likeCondition(filter.getIssueDesc(), DbUtils.LikeMode.FRONT));

        filter.setOrderCode(likeCondition(filter.getOrderCode(), DbUtils.LikeMode.FRONT));
    }


    /**
     * trim
     *
     * @param str
     * @return
     */
    private String strRemoveBlank(String str) {
        if (str == null)
            return null;
        str = str.trim();
        return str.equals("") ? null : str.trim();
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
                throw new BusinessException(ModuleCode.ISSU, ErrorCode.E000011, inputField);
            sort.setSortField(dbField);
        }
    }

    private Map<String, String> initSortMap() {
        Map<String, String> sortMap = new HashMap<>();
        sortMap.put("issueId","issueId");
        sortMap.put("issueCode","issueCode");
        sortMap.put("orderId","orderId");
        sortMap.put("orderCode","orderCode");
        sortMap.put("orderType","orderType");
        sortMap.put("logisticsZoneCode","logisticsZoneCode");
        sortMap.put("logisticsZoneName","logisticsZoneName");
        sortMap.put("logisticsZoneId","logisticsZoneId");
        sortMap.put("buyerId","buyerId");
        sortMap.put("buyerCode","buyerCode");
        sortMap.put("buyerName","buyerName");
        sortMap.put("initiatorType","initiatorType");
        sortMap.put("initiatorId","initiatorId");
        sortMap.put("initiatorName","initiatorName");
        sortMap.put("initiateTime","initiateTime");
        sortMap.put("issueDesc","issueDesc");
        sortMap.put("issueResult","issueResult");
        sortMap.put("issueDecision","issueDecision");
        sortMap.put("closeUid","closeUid");
        sortMap.put("closeUname","closeUname");
        sortMap.put("closeTime","closeTime");
        sortMap.put("issueStatus","issueStatus");
        return sortMap;
    }

    @Override
    public BaseDao getBaseDao() {
        return dao;
    }
}
