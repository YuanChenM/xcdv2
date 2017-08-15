package com.bms.order.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bms.order.common.rest.BaseSearchRestParam;
import com.bms.order.constant.enumeration.ApplyObject;
import com.bms.order.constant.enumeration.OperatorType;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.ORDR0806IDao;
import com.framework.base.bean.Sort;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.param.ORDR0806IFilter;
import com.bms.order.bean.result.ORDR0806IRestResult;
import com.bms.order.common.rest.SearchRestResult;
import com.bms.order.services.ORDR0806IService;

/**
 * 买家退货原因查询接口Service
 * 
 * @author li_huiqian
 */
@Service
public class ORDR0806IServiceImpl extends BaseServiceImpl implements ORDR0806IService {

    @Autowired
    private ORDR0806IDao ordr0806IDao;

    /**
     * 买家退货原因查询接口,分Json版和Xml版
     * 
     * @param operator
     *            操作者
     * @param param ORDR0806IBean
     *
     */
    @Override
    public SearchRestResult<ORDR0806IRestResult> execute(Operator operator, BaseSearchRestParam<ORDR0806IFilter> param) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();
        SearchRestResult<ORDR0806IRestResult> result = new SearchRestResult<>();

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
        BaseSearchRestParam<ORDR0806IFilter> param = (BaseSearchRestParam<ORDR0806IFilter>) map.get("param");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        ORDR0806IFilter filter = param.getFilter();
        // 操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);

        // 处理filter
        processFilter(map);
        // 数据权限验证
        checkDataAuthority(operator, filter);

    }

    /**
     * 执行
     * 
     * @param map HashMap
     *
     */
    private void process(HashMap<String, Object> map) {
        BaseSearchRestParam<ORDR0806IFilter> param = (BaseSearchRestParam<ORDR0806IFilter>) map.get("param");
        Sort[] sorts = (Sort[]) map.get("sort");
        List<ORDR0806IRestResult> restResultList = super.findList(param,sorts);
        SearchRestResult<ORDR0806IRestResult> result = (SearchRestResult<ORDR0806IRestResult>) map.get("result");
        result.setData(restResultList);
        result.setTotal(restResultList.size());
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

    private void checkDataAuthority(Operator operator,ORDR0806IFilter filter){
        OperatorType operatorType = OperatorType.getInstance(operator.getOperatorType());
        if(operatorType == OperatorType.BUYER){

        }else if(operatorType == OperatorType.MANAGER){

        }else {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000001,operatorType.getName());
        }
        if(null != filter){
            if(null != filter.getApplyObject()
                    && !ApplyObject.BUYER.getCode().equals(filter.getApplyObject()))
            throw new BusinessException(ModuleCode.ORDR,ErrorCode.E080601);
        }
    }


    /**
     *
     * @param map
     */
    private void processFilter(HashMap<String, Object> map){
        BaseSearchRestParam<ORDR0806IFilter> param = (BaseSearchRestParam<ORDR0806IFilter>) map.get("param");
        ORDR0806IFilter filter = param.getFilter();
        if(null == filter){
            filter = new ORDR0806IFilter();
            filter.setApplyObject(ApplyObject.BUYER.getCode());
            param.setFilter(filter);
        }else if(null == filter.getApplyObject()){
            filter.setApplyObject(ApplyObject.BUYER.getCode());
        }
        // 处理sort
        processSort(filter.getSort());
        map.put("sort",filter.getSort());

        // 移除空字符串
        removeBlank(filter);

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

    /**
     * 移除空字符串
     * @param filter
     */
    private void removeBlank(ORDR0806IFilter filter){
        filter.setApplyType(strRemoveBlank(filter.getApplyType()));
        filter.setReasonName(strRemoveBlank(filter.getReasonName()));
        filter.setApplyObject(strRemoveBlank(filter.getApplyObject()));
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
        return ordr0806IDao;
    }
}
