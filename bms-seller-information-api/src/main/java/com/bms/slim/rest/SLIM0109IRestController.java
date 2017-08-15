package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0109IParam;
import com.bms.slim.bean.result.SLIM0109IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0109IService;
import com.bms.slim.validator.SLIM0109IValidator;
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
@Api(description = "修改卖家经营团队接口", tags = "SLIM0109IRestController")
public class SLIM0109IRestController extends BaseRestController {

    @Autowired
    private SLIM0109IService slim0109IService;

    @ApiOperation(value = "修改卖家经营团队",
            notes = "传入参数:beans!修改卖家经营团队")
    @RequestMapping(value = "/sellers/management/teams/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLIM0109IValidator.class)
    public SLIM0109IResult modifySellerManagementTeams(@RequestBody SLIM0109IParam slim0109IParam) {
        SLIM0109IResult slim0109IResult = slim0109IService.updateSellerManagementTeams(slim0109IParam);
        slim0109IResult.setMessage(new String[]{MessageConstant.SUCCESS, "修改卖家经营团队成功"});
        return slim0109IResult;
    }

}
