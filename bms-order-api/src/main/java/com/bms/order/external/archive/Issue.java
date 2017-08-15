package com.bms.order.external.archive;

import com.alibaba.fastjson.TypeReference;
import com.bms.order.common.rest.SearchRestParam;
import com.bms.order.common.rest.param.RestOperator;
import com.bms.order.constant.UrlConst;
import com.bms.order.constant.enumeration.OperatorType;
import com.bms.order.external.bean.param.ISSU0105IFilter;
import com.bms.order.external.bean.result.ISSU0105IRestResult;
import com.framework.base.rest.result.BaseRestPaginationResult;

/**
 * Created by ni_shaotang on 2017/3/1.
 */
public class Issue extends AbstractExternalArchive {
    private Issue() {
    }

    /**
     * 查询问题订单
     *
     * @param filter
     * @return
     */
    public static BaseRestPaginationResult<ISSU0105IRestResult> queryIssueOrder(ISSU0105IFilter filter) {
        SearchRestParam<ISSU0105IFilter> param = new SearchRestParam<>();
        RestOperator operator = new RestOperator();
        operator.setOperatorId(OperatorType.MANAGER.getCode());
        operator.setOperatorType(OperatorType.MANAGER.getCode());
        param.setOperator(operator);
        param.setFilter(filter);

        String url = UrlConst.API_ISSUE_URL + UrlConst.ACTION_ISSUE0105I;
        TypeReference<BaseRestPaginationResult<ISSU0105IRestResult>> typeReference = new TypeReference<BaseRestPaginationResult<ISSU0105IRestResult>>() {
        };
        Issue issue = new Issue();
        // 调用接口（使用关联对象的rest client）
        BaseRestPaginationResult<ISSU0105IRestResult> paginationResult = issue.getRestClient().post(url, param, typeReference);
        return paginationResult;
    }
}
