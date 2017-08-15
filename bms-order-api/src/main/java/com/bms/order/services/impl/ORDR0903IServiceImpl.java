package com.bms.order.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bms.order.constant.enumeration.ApplyObject;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.ORDR0903IDao;
import com.framework.base.bean.Sort;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.param.ORDR0903IFilter;
import com.bms.order.bean.result.ORDR0903IRestResult;
import com.bms.order.common.rest.BaseSearchRestParam;
import com.bms.order.common.rest.SearchRestResult;
import com.bms.order.services.ORDR0903IService;

/**
 * 买手退货原因查询接口Service
 * 
 * @author li_huiqian
 */
@Service
public class ORDR0903IServiceImpl extends BaseServiceImpl implements ORDR0903IService {

    @Autowired
    private ORDR0903IDao ordr0903IDao;

    /**
     * 买手退货原因查询接口
     * 
     * @param operator
     *            操作者
     * @param param ORDR0903IBean
     *
     */
    @Override
    public SearchRestResult<ORDR0903IRestResult> execute(Operator operator, BaseSearchRestParam<ORDR0903IFilter> param) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();
        SearchRestResult<ORDR0903IRestResult> result = new SearchRestResult<>();

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
        BaseSearchRestParam<ORDR0903IFilter> param = (BaseSearchRestParam<ORDR0903IFilter>) map.get("param");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        ORDR0903IFilter filter = param.getFilter();

        // 操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);

        // 数据权限验证
        if(null == filter){
            filter = new ORDR0903IFilter();
            filter.setApplyObject(ApplyObject.BS.getCode());
            param.setFilter(filter);
        }
        checkDataAuthority(operator, filter);

        // 处理filter

        if(null != filter){
            processFilter(filter);
        }

        // 处理sort
        processSort(filter.getSort());

    }

    /**
     * 执行
     * 
     * @param map HashMap
     *
     */
    private void process(HashMap<String, Object> map) {
        BaseSearchRestParam<ORDR0903IFilter> param = (BaseSearchRestParam<ORDR0903IFilter>) map.get("param");
        List<ORDR0903IRestResult> restResults = super.findList(param);
        SearchRestResult<ORDR0903IRestResult> result = (SearchRestResult<ORDR0903IRestResult>) map.get("result");
        result.setData(restResults);
        result.setTotal(restResults.size());

    }

    /**
     * 收尾
     * 
     * @param map
     *            HashMap
     */
    private void post(HashMap<String, Object> map) {
        // 获取参数

        // 执行操作

    }

    private void checkDataAuthority(Operator operator,ORDR0903IFilter filter){
        if(null != filter && null == filter.getApplyObject()){
            filter.setApplyObject(ApplyObject.BS.getCode());
        }
        if(null != filter && !ApplyObject.BS.getCode().equals(filter.getApplyObject())){
            throw new BusinessException(ModuleCode.ORDR,ErrorCode.E090301);
        }

    }

    /**
     *
     * @param filter
     */
    private void processFilter(ORDR0903IFilter filter){
        // 移除空字符串
        removeBlank(filter);

    }

    /**
     * 移除空字符串
     * @param filter
     */
    private void removeBlank(ORDR0903IFilter filter){
        filter.setApplyType(strRemoveBlank(filter.getApplyType()));
        filter.setReasonName(strRemoveBlank(filter.getReasonName()));
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

    private Map<String, String> initSortMap() {
        Map<String, String> sortMap = new HashMap<>();
        sortMap.put("reasonId","reasonId");
        sortMap.put("reasonName","reasonName");
        sortMap.put("applyType","applyType");
        sortMap.put("applyObject","applyObject");
        return sortMap;
    }

    @Override
    public BaseDao getBaseDao() {
        return ordr0903IDao;
    }
}
