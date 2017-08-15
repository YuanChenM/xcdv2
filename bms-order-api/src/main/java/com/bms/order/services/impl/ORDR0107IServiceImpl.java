package com.bms.order.services.impl;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.param.ORDR0107IFilterParam;
import com.bms.order.bean.result.ORDR0107IRestResult;
import com.bms.order.common.rest.BaseSearchRestParam;
import com.bms.order.common.rest.SearchRestResult;
import com.bms.order.dao.ORDR0107IDao;
import com.bms.order.services.ORDR0107IService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ni_shaotang on 2017/3/29.
 */
@Service
public class ORDR0107IServiceImpl extends BaseServiceImpl implements ORDR0107IService {
    @Autowired
    private ORDR0107IDao dao;

    @Override
    public BaseDao getBaseDao() {
        return dao;
    }

    @Override
    public SearchRestResult<ORDR0107IRestResult> execute(Operator operator, BaseSearchRestParam<ORDR0107IFilterParam> param) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();
        SearchRestResult<ORDR0107IRestResult> result = new SearchRestResult<ORDR0107IRestResult>();
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
    }
    /**
     * 执行
     *
     * @param map
     *            HashMap
     */
    private void process(HashMap<String, Object> map) {
        BaseSearchRestParam<ORDR0107IFilterParam> param = (BaseSearchRestParam<ORDR0107IFilterParam>) map.get("param");
        ORDR0107IFilterParam filterParam = param.getFilter();
        List<ORDR0107IRestResult> restResultList = dao.findSalesVolumes(filterParam);
        SearchRestResult<ORDR0107IRestResult> result = (SearchRestResult<ORDR0107IRestResult>) map.get("result");
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
}
