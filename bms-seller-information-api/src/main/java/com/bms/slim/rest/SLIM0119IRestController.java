package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0119IParam;
import com.bms.slim.bean.result.SLIM0119IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0119IService;
import com.bms.slim.validator.SLIM0119IValidator;
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

@RestController
@Api(description = "批量新增卖家电商经营团队接口", tags = "SLIM0119IRestController")
public class SLIM0119IRestController extends BaseRestController {

    @Autowired
    private SLIM0119IService slim0119IService;

    @ApiOperation(value = "批量新增卖家电商经营团队",
            notes = "传入参数:beans!批量新增卖家电商经营团队")
    @RequestMapping(value = "/sellers/business/teams/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLIM0119IValidator.class)
    public SLIM0119IResult addSellerBusinessTeams(@RequestBody SLIM0119IParam slim0119IParam) {
        SLIM0119IResult slim0119IResult = slim0119IService.addSellerBusinessTeams(slim0119IParam);
        slim0119IResult.setMessage(new String[]{MessageConstant.SUCCESS, "新增卖家电商经营团队成功"});
        return slim0119IResult;
    }
}
