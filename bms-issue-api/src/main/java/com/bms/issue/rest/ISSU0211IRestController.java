package com.bms.issue.rest;

import com.bms.issue.archive.impl.Operator;
import com.bms.issue.bean.param.ISSU0211IFilter;
import com.bms.issue.bean.result.ISSU0211IRestResult;
import com.bms.issue.common.rest.SearchRestParam;
import com.bms.issue.common.rest.SearchRestResult;
import com.bms.issue.service.ISSU0211IService;
import com.bms.issue.validator.ISSU0211IRestValidator;
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
 * Created by Administrator on 2017/2/21.
 */
@RestController
@Api(tags = { "ISSU0211IRestController" }, description = "问题点查询接口")
public class ISSU0211IRestController extends BaseRestController {

    @Autowired
    private ISSU0211IService service;


    /**
     * 查询问题订单相关信息
     *
     * @param param
     *            BusinessRestParam
     * @return BusinessRestResult
     */
    @ApiOperation(value = "问题点查询接口", notes = "查询问题点相关信息")
    @Validator(validatorClass = ISSU0211IRestValidator.class)
    @RequestMapping(value = "/issue/question/item/_search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public SearchRestResult<ISSU0211IRestResult> execute(@RequestBody SearchRestParam<ISSU0211IFilter> param) {
        Operator operator = Operator.Builder.build(param.getOperator());

        SearchRestResult<ISSU0211IRestResult> result = service.execute(operator, param);


        return result;
    }
}
