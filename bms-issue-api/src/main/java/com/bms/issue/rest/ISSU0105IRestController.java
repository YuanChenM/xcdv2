package com.bms.issue.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bms.issue.archive.impl.Operator;
import com.bms.issue.bean.param.ISSU0105IFilter;
import com.bms.issue.bean.result.ISSU0105IRestResult;
import com.bms.issue.common.rest.SearchRestParam;
import com.bms.issue.common.rest.SearchRestResult;
import com.bms.issue.service.ISSU0105IService;
import com.bms.issue.validator.ISSU0105IRestValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.validator.annotation.Validator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 问题订单查询接口Controller
 *
 * @author li_huiqian
 */
@RestController
@Api(tags = { "ISSU0105IRestController" }, description = "问题订单查询接口")
public class ISSU0105IRestController extends BaseRestController {

    @Autowired
    private ISSU0105IService service;

    /**
     * 查询问题订单相关信息
     *
     * @param param
     *            BusinessRestParam
     * @return BusinessRestResult
     */
    @ApiOperation(value = "问题订单查询接口", notes = "查询问题订单相关信息")
    @Validator(validatorClass = ISSU0105IRestValidator.class)
    @RequestMapping(value = "/issue/_search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public SearchRestResult<ISSU0105IRestResult> execute(@RequestBody SearchRestParam<ISSU0105IFilter> param) {
        Operator operator = Operator.Builder.build(param.getOperator());

        SearchRestResult<ISSU0105IRestResult> result = service.execute(operator, param);


        return result;
    }
}
