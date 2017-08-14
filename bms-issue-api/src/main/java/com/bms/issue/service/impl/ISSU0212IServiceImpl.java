package com.bms.issue.service.impl;

import com.bms.issue.archive.impl.Operator;
import com.bms.issue.bean.Blackboard;
import com.bms.issue.bean.param.ISSU0212IFilter;
import com.bms.issue.bean.result.ISSU0212IRestResult;
import com.bms.issue.common.rest.SearchRestParam;
import com.bms.issue.common.rest.SearchRestResult;
import com.bms.issue.constant.i18n.ErrorCode;
import com.bms.issue.constant.i18n.ModuleCode;
import com.bms.issue.dao.ISSU0212IDao;
import com.bms.issue.service.ISSU0212IService;
import com.framework.base.bean.Sort;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.db.DbUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/21.
 */
@Service
public class ISSU0212IServiceImpl extends BaseServiceImpl implements ISSU0212IService {

    @Autowired
    private ISSU0212IDao issu0212IDao;

    @Override
    public SearchRestResult<ISSU0212IRestResult> execute(Operator operator, SearchRestParam<ISSU0212IFilter> param) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();
        SearchRestResult<ISSU0212IRestResult> result = new SearchRestResult<>();
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
        SearchRestParam<ISSU0212IFilter> param = (SearchRestParam<ISSU0212IFilter>) map.get("param");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        ISSU0212IFilter filter = param.getFilter();

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
        SearchRestParam<ISSU0212IFilter> param = (SearchRestParam<ISSU0212IFilter>) map.get("param");
        BaseRestPaginationResult<ISSU0212IRestResult> restResult = super.findPageList(param);
        SearchRestResult<ISSU0212IRestResult> result = (SearchRestResult<ISSU0212IRestResult>) map.get("result");
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

    private void checkDataAuthority(Operator operator,ISSU0212IFilter filter){
        //目前没有
    }

    /**
     *
     * @param filter
     */
    private void processFilter(ISSU0212IFilter filter){
        // 移除空字符串
        removeBlank(filter);

        // 移除空数组
        removeEmpty(filter);

        // 设置模糊检索
        setSearchCondition(filter);
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

    /**
     * 移除空字符串
     * @param filter
     */
    private void removeBlank(ISSU0212IFilter filter){
        filter.setHandlingContent(strRemoveBlank(filter.getHandlingContent()));
        filter.setHandlingTimeFrom(strRemoveBlank(filter.getHandlingTimeFrom()));
        filter.setHandlingTimeTo(strRemoveBlank(filter.getHandlingTimeTo()));
        filter.setHandlingUname(strRemoveBlank(filter.getHandlingUname()));
        filter.setHandlingResult(strRemoveBlank(filter.getHandlingResult()));
        filter.setHandlingResultReason(strRemoveBlank(filter.getHandlingResultReason()));
    }

    /**
     * 移除空数组
     * @param filter
     */
    private void removeEmpty(ISSU0212IFilter filter){

        if (filter.getQuestionId() != null && filter.getQuestionId().length == 0)
            filter.setQuestionId(null);

        if (filter.getHandlingId() != null && filter.getHandlingId().length == 0)
            filter.setHandlingId(null);

        if (filter.getHandlingType() != null && filter.getHandlingType().length == 0)
            filter.setHandlingType(null);

        if (filter.getHandlingUid() != null && filter.getHandlingUid().length == 0)
            filter.setHandlingUid(null);

    }

    /**
     * 设置模糊检索
     * @param filter
     */
    private void setSearchCondition(ISSU0212IFilter filter){

        filter.setHandlingContent(
                likeCondition(filter.getHandlingContent(), DbUtils.LikeMode.FRONT));

        filter.setHandlingUname(
                likeCondition(filter.getHandlingUname(), DbUtils.LikeMode.FRONT));

        filter.setHandlingResult(
                likeCondition(filter.getHandlingResult(), DbUtils.LikeMode.FRONT));

        filter.setHandlingResultReason(
                likeCondition(filter.getHandlingResultReason(), DbUtils.LikeMode.FRONT));
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

    private Map<String, String> initSortMap() {
        Map<String, String> sortMap = new HashMap<>();
        sortMap.put("questionId","questionId");
        sortMap.put("handlingId","handlingId");
        sortMap.put("handlingType","handlingType");
        sortMap.put("handlingContent","handlingContent");
        sortMap.put("handlingTime","handlingTime");
        sortMap.put("handlingUid","handlingUid");
        sortMap.put("handlingUname","handlingUname");
        sortMap.put("handlingResult","handlingResult");
        sortMap.put("handlingResultReason","handlingResultReason");
        return sortMap;
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
    
    @Override
    public BaseDao getBaseDao() {
        return issu0212IDao;
    }
}
