package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0107IParam;
import com.bms.slim.bean.result.SLIM0107IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0107IService;
import com.bms.slim.validator.SLIM0107IValidator;
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
@Api(description = "批量新增卖家经营团队接口", tags = "SLIM0107IRestController")
public class SLIM0107IRestController extends BaseRestController {

    @Autowired
    private SLIM0107IService slim0107IService;

    @ApiOperation(value = "批量新增卖家经营团队",
            notes = "传入参数:beans!批量新增卖家经营团队")
    @RequestMapping(value = "/sellers/management/teams/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLIM0107IValidator.class)
    public SLIM0107IResult addSellerManagementTeams(@RequestBody SLIM0107IParam slim0107IParam) {
        SLIM0107IResult slim0107IResult = slim0107IService.addSellerManagementTeams(slim0107IParam);
        slim0107IResult.setMessage(new String[]{MessageConstant.SUCCESS, "新增卖家经营团队成功"});
        return slim0107IResult;
    }
}
