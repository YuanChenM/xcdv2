package com.bms.order.rest;

import com.bms.order.common.rest.RestRequest;
import com.bms.order.common.rest.RsResponse;
import com.bms.order.common.rest.param.RestOperator;
import com.bms.order.constant.enumeration.OperatorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0402IFilterParam;
import com.bms.order.bean.result.ORDR0402IRestResult;
import com.bms.order.services.ORDR0402IService;
import com.bms.order.validator.ORDR0402IRestValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.validator.annotation.Validator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 订单信息及对应价盘查询接口Controller
 *
 * @author li_huiqian
 */
@RestController
@Api(tags = { "ORDR0402IRestController" }, description = "订单信息及对应价盘查询接口")
public class ORDR0402IRestController extends BaseRestController {

    @Autowired
    private ORDR0402IService service;

    /**
     * 美迪福调用，获取最终的价盘通道
     *
     * @param request
     *            BusinessRestParam
     * @return BusinessRestResult
     */
    @ApiOperation(value = "订单信息及对应价盘查询接口", notes = "美迪福调用，获取最终的价盘通道")
    @Validator(validatorClass = ORDR0402IRestValidator.class)
    @RequestMapping(value = "/order/price/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_XML_VALUE})
    public RsResponse<ORDR0402IRestResult> execute(@RequestBody RestRequest<ORDR0402IFilterParam> request) {
        RsResponse<ORDR0402IRestResult> response = new RsResponse<ORDR0402IRestResult>();
        RestOperator restOperator = new RestOperator();
        restOperator.setOperatorId(request.getLoginId());
        restOperator.setOperatorType(OperatorType.MADE_4_NET.getCode());
        Operator operator = Operator.Builder.build(restOperator);

        ORDR0402IRestResult result = service.execute(operator, request.getParam());
        response.setResult(result);
        response.setStatus("S");
        response.setMessage("订单明细及价盘通道查询接口查询成功");
        return response;
    }
}
