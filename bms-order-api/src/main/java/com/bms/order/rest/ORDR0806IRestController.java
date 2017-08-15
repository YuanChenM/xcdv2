package com.bms.order.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0806IFilter;
import com.bms.order.bean.result.ORDR0806IRestResult;
import com.bms.order.common.rest.BaseSearchRestParam;
import com.bms.order.common.rest.SearchRestResult;
import com.bms.order.services.ORDR0806IService;
import com.bms.order.validator.ORDR0806IRestValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.validator.annotation.Validator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 买家退货原因查询接口Controller
 *
 * @author li_huiqian
 */
@RestController
@Api(tags = { "ORDR0806IRestController" }, description = "买家退货原因查询接口")
public class ORDR0806IRestController extends BaseRestController {

    @Autowired
    private ORDR0806IService service;

    /**
     * 买家退货原因查询接口,分Json版和Xml版
     *
     * @param param
     *            BusinessRestParam
     * @return BusinessRestResult
     */
    @ApiOperation(value = "买家退货原因查询接口", notes = "买家退货原因查询接口,分Json版和Xml版")
    @Validator(validatorClass = ORDR0806IRestValidator.class)
    @RequestMapping(value = "/order/buyer/return/reason/_search", method = RequestMethod.POST, produces = {
            MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE })
    public SearchRestResult<ORDR0806IRestResult> execute(@RequestBody BaseSearchRestParam<ORDR0806IFilter> param) {
        Operator operator = Operator.Builder.build(param.getOperator());

        SearchRestResult<ORDR0806IRestResult> result = service.execute(operator, param);

        return result;
    }

    /**
     * 买家退货原因查询接口,分Json版和Xml版
     *
     * @param param
     *            BusinessRestParam
     * @return BusinessRestResult
     */
    @ApiOperation(value = "买家退货原因查询接口", notes = "买家退货原因查询接口,分Json版和Xml版")
    @Validator(validatorClass = ORDR0806IRestValidator.class)
    @RequestMapping(value = "/order/buyer/return/reason/json/_search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public SearchRestResult<ORDR0806IRestResult> executeJSON(@RequestBody BaseSearchRestParam<ORDR0806IFilter> param) {
        Operator operator = Operator.Builder.build(param.getOperator());

        SearchRestResult<ORDR0806IRestResult> result = service.execute(operator, param);

        return result;
    }
}
