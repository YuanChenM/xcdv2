package com.bms.order.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0105IFilterParam;
import com.bms.order.bean.result.ORDR0105IL1RestResult;
import com.bms.order.common.rest.SearchRestParam;
import com.bms.order.common.rest.SearchRestResult;
import com.bms.order.services.ORDR0105IService;
import com.bms.order.validator.ORDR0105IRestValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.validator.annotation.Validator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 买家订单查询接口Controller
 *
 * @author li_huiqian
 */
@RestController
@Api(tags = { "ORDR0105IRestController" }, description = "买家订单查询接口")
public class ORDR0105IRestController extends BaseRestController {

    @Autowired
    private ORDR0105IService service;

    /**
     * 买家/平台订单人员/管家/买手查询自己权限可以访问的订单
     *
     * @param param
     *            BusinessRestParam
     * @return BusinessRestResult
     */
    @ApiOperation(value = "买家订单查询接口", notes = "买家/平台订单人员/管家/买手查询自己权限可以访问的订单")
    @Validator(validatorClass = ORDR0105IRestValidator.class)
    @RequestMapping(value = "/order/by/_search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public SearchRestResult<ORDR0105IL1RestResult> execute(@RequestBody SearchRestParam<ORDR0105IFilterParam> param) {
        Operator operator = Operator.Builder.build(param.getOperator());
        if(null != param.getPagination()){
            int startPos = (param.getPagination().getStartPos() - 1)*param.getPagination().getPageSize();
            param.getPagination().setStartPos(startPos);
        }
        SearchRestResult<ORDR0105IL1RestResult> result = service.execute(operator, param);

        return result;
    }
}
