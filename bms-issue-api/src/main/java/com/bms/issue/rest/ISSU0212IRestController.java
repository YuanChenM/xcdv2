package com.bms.issue.rest;

import com.bms.issue.bean.param.ISSU0212IFilter;
import com.bms.issue.bean.result.ISSU0212IRestResult;
import com.bms.issue.common.rest.SearchRestParam;
import com.bms.issue.common.rest.SearchRestResult;
import com.bms.issue.service.ISSU0212IService;
import com.bms.issue.validator.ISSU0212IRestValidator;
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
import com.bms.issue.archive.impl.Operator;

/**
 * Created by Administrator on 2017/2/21.
 */
@RestController
@Api(tags = { "ISSU0212IRestController" }, description = "问题管理信息查询接口")
public class ISSU0212IRestController extends BaseRestController {

    @Autowired
    private ISSU0212IService service;
    /**
     * 查询问题订单相关信息
     *
     * @param param
     *            BusinessRestParam
     * @return BusinessRestResult
     */
    @ApiOperation(value = "问题管理信息查询接口", notes = "查询问题管理相关信息")
    @Validator(validatorClass = ISSU0212IRestValidator.class)
    @RequestMapping(value = "/issue/question/handling/_search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public SearchRestResult<ISSU0212IRestResult> execute(@RequestBody SearchRestParam<ISSU0212IFilter> param) {
        Operator operator = Operator.Builder.build(param.getOperator());

        SearchRestResult<ISSU0212IRestResult> result = service.execute(operator, param);


        return result;
    }
}
