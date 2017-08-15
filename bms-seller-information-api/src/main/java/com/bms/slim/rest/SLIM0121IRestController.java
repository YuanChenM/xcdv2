package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0121IParam;
import com.bms.slim.bean.result.SLIM0121IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0121IService;
import com.bms.slim.validator.SLIM0121IValidator;
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
@Api(description = "修改卖家电商经营团队接口", tags = "SLIM0121IRestController")
public class SLIM0121IRestController extends BaseRestController {

    @Autowired
    private SLIM0121IService slim0121IService;

    @ApiOperation(value = "修改卖家电商经营团队",
            notes = "传入参数:beans!修改卖家电商经营团队")
    @RequestMapping(value = "/sellers/business/teams/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLIM0121IValidator.class)
    public SLIM0121IResult modifySellerBusinessTeams(@RequestBody SLIM0121IParam slim0121IParam) {
        SLIM0121IResult slim0121IResult = slim0121IService.updateSellerBusinessTeams(slim0121IParam);
        slim0121IResult.setMessage(new String[]{MessageConstant.SUCCESS, "修改卖家电商经营团队成功"});
        return slim0121IResult;
    }

}
