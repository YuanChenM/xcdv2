package com.bms.issue.rest;

import com.bms.issue.archive.impl.Operator;
import com.bms.issue.bean.param.ISSU0210IFilter;
import com.bms.issue.bean.result.ISSU0210IRestResult;
import com.bms.issue.common.rest.SearchRestParam;
import com.bms.issue.common.rest.SearchRestResult;
import com.bms.issue.service.ISSU0210IService;
import com.bms.issue.validator.ISSU0210IRestValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.validator.annotation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/2/20.
 */
@RestController
@Api(tags = { "ISSU0210IRestController" }, description = "问题查询接口")
public class ISSU0210IRestController extends BaseRestController {

    @Autowired
    private ISSU0210IService service;


    /**
     * 查询问题订单相关信息
     *
     * @param param
     *            BusinessRestParam
     * @return BusinessRestResult
     */
    @ApiOperation(value = "问题查询接口", notes = "查询问题相关信息")
    @Validator(validatorClass = ISSU0210IRestValidator.class)
    @RequestMapping(value = "/issue/question/_search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public SearchRestResult<ISSU0210IRestResult> execute(@RequestBody SearchRestParam<ISSU0210IFilter> param) {
        Operator operator = Operator.Builder.build(param.getOperator());

        SearchRestResult<ISSU0210IRestResult> result = service.execute(operator, param);


        return result;
    }
}
