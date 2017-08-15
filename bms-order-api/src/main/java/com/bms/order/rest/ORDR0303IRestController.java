package com.bms.order.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0303IFilterParam;
import com.bms.order.bean.result.ORDR0303IL1RestResult;
import com.bms.order.common.rest.SearchRestParam;
import com.bms.order.common.rest.SearchRestResult;
import com.bms.order.services.ORDR0303IService;
import com.bms.order.validator.ORDR0303IRestValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.validator.annotation.Validator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 配送通知单查询接口Controller
 *
 * @author li_huiqian
 */
@RestController
@Api(tags = { "ORDR0303IRestController" }, description = "配送通知单查询接口")
public class ORDR0303IRestController extends BaseRestController {

    @Autowired
    private ORDR0303IService service;

    /**
     * 平台订单人员查询自己权限可以访问的配送通知单
     *
     * @param param
     *            BusinessRestParam
     * @return BusinessRestResult
     */
    @ApiOperation(value = "配送通知单查询接口", notes = "平台订单人员查询自己权限可以访问的配送通知单")
    @Validator(validatorClass = ORDR0303IRestValidator.class)
    @RequestMapping(value = "/order/delivery/notification/_search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public SearchRestResult<ORDR0303IL1RestResult> execute(@RequestBody SearchRestParam<ORDR0303IFilterParam> param) {
        Operator operator = Operator.Builder.build(param.getOperator());

        SearchRestResult<ORDR0303IL1RestResult> result = service.execute(operator, param);

        return result;
    }
}



