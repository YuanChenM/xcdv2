package com.bms.order.rest;

import com.bms.order.common.rest.BaseSearchRestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0903IFilter;
import com.bms.order.bean.result.ORDR0903IRestResult;
import com.bms.order.common.rest.SearchRestParam;
import com.bms.order.common.rest.SearchRestResult;
import com.bms.order.services.ORDR0903IService;
import com.bms.order.validator.ORDR0903IRestValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.validator.annotation.Validator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 买手退货原因查询接口Controller
 *
 * @author li_huiqian
 */
@RestController
@Api(tags = { "ORDR0903IRestController" }, description = "买手退货原因查询接口")
public class ORDR0903IRestController extends BaseRestController {

    @Autowired
    private ORDR0903IService service;

    /**
     * 买手退货原因查询接口
     *
     * @param param
     *            BusinessRestParam
     * @return BusinessRestResult
     */
    @ApiOperation(value = "买手退货原因查询接口", notes = "买手退货原因查询接口")
    @Validator(validatorClass = ORDR0903IRestValidator.class)
    @RequestMapping(value = "/order/bs/return/reason/_search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public SearchRestResult<ORDR0903IRestResult> execute(@RequestBody BaseSearchRestParam<ORDR0903IFilter> param) {
        Operator operator = Operator.Builder.build(param.getOperator());

        SearchRestResult<ORDR0903IRestResult> result = service.execute(operator, param);

        return result;
    }
}
