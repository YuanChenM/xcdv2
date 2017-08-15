package com.bms.order.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0904IFilter;
import com.bms.order.bean.result.ORDR0904IRestResult;
import com.bms.order.common.rest.SearchRestParam;
import com.bms.order.common.rest.SearchRestResult;
import com.bms.order.services.ORDR0904IService;
import com.bms.order.validator.ORDR0904IRestValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.validator.annotation.Validator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 买手退货信息查询接口Controller
 *
 * @author li_huiqian
 */
@RestController
@Api(tags = { "ORDR0904IRestController" }, description = "买手退货信息查询接口")
public class ORDR0904IRestController extends BaseRestController {

    @Autowired
    private ORDR0904IService service;

    /**
     * 查询买手退货相关信息
     *
     * @param param
     *            BusinessRestParam
     * @return BusinessRestResult
     */
    @ApiOperation(value = "买手退货信息查询接口", notes = "查询买手退货相关信息")
    @Validator(validatorClass = ORDR0904IRestValidator.class)
    @RequestMapping(value = "/order/bs/return/_search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public SearchRestResult<ORDR0904IRestResult> execute(@RequestBody SearchRestParam<ORDR0904IFilter> param) {
        Operator operator = Operator.Builder.build(param.getOperator());

        if(null != param.getPagination()){
            int startPos = (param.getPagination().getStartPos() - 1)*param.getPagination().getPageSize();
            param.getPagination().setStartPos(startPos);
        }

        SearchRestResult<ORDR0904IRestResult> result = service.execute(operator, param);

        return result;
    }
}
