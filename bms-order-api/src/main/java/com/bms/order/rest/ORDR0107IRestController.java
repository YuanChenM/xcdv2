package com.bms.order.rest;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0107IFilterParam;
import com.bms.order.bean.result.ORDR0107IRestResult;
import com.bms.order.common.rest.BaseSearchRestParam;
import com.bms.order.common.rest.SearchRestResult;
import com.bms.order.services.ORDR0107IService;
import com.framework.boot.base.BaseRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品销量查询接口
 * Created by ni_shaotang on 2017/3/29.
 */
@RestController
@Api(tags = { "ORDR0107IRestController" }, description = "商品销量查询接口")
public class ORDR0107IRestController extends BaseRestController {

    @Autowired
    private ORDR0107IService service;
    /**
     * 商品销量查询接口
     * @param param
     *            BusinessRestParam
     * @return BusinessRestResult
     */
    @ApiOperation(value = "商品销量查询接口", notes = "商品销量查询接口")
    @RequestMapping(value = "/order/salevolumn/_search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public SearchRestResult<ORDR0107IRestResult> execute(@RequestBody BaseSearchRestParam<ORDR0107IFilterParam> param) {
        Operator operator = Operator.Builder.build(param.getOperator());
        SearchRestResult<ORDR0107IRestResult> result = service.execute(operator, param);

        return result;
    }
}
