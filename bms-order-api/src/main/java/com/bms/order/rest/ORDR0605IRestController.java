package com.bms.order.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0605IFilterParam;
import com.bms.order.bean.result.ORDR0605IL1RestResult;
import com.bms.order.common.rest.SearchRestParam;
import com.bms.order.common.rest.SearchRestResult;
import com.bms.order.services.ORDR0605IService;
import com.bms.order.validator.ORDR0605IRestValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.validator.annotation.Validator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 买手订单查询接口Controller
 *
 * @author li_huiqian
 */
@RestController
@Api(tags = { "ORDR0605IRestController" }, description = "买手订单查询接口")
public class ORDR0605IRestController extends BaseRestController {

    @Autowired
    private ORDR0605IService service;

    /**
     * 买手/冻品管家/平台订单人员查询自己权限可以访问的买手订单
     *
     * ORDR0605IRestParam
     * 
     * @return ORDR0605IRestResult
     */
    @ApiOperation(value = "买手订单查询接口", notes = "买手/冻品管家/平台订单人员查询自己权限可以访问的买手订单")
    @Validator(validatorClass = ORDR0605IRestValidator.class)
    @RequestMapping(value = "/order/bs/_search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public SearchRestResult<ORDR0605IL1RestResult> execute(@RequestBody SearchRestParam<ORDR0605IFilterParam> param) {
        Operator operator = Operator.Builder.build(param.getOperator());
        if (null != param.getPagination()) {
            int startPos = (param.getPagination().getStartPos() - 1) * param.getPagination().getPageSize();
            param.getPagination().setStartPos(startPos);
        }
        SearchRestResult<ORDR0605IL1RestResult> result = service.execute(operator, param);

        return result;
    }

}
