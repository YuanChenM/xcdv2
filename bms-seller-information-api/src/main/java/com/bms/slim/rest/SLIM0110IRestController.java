package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0110IParam;
import com.bms.slim.bean.result.SLIM0110IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0110IService;
import com.framework.boot.base.BaseRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "新增卖家代理商供应资质接口", tags = "SLIM0110IRestController")
public class SLIM0110IRestController extends BaseRestController {

    @Autowired
    private SLIM0110IService slim0110IService;

    @ApiOperation(value = "新增卖家代理商供应资质",
            notes = "传入参数:beans!新增卖家代理商供应资质")
    @RequestMapping(value = "/sellers/agent/supply/qualifications/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
//    @Validator(validatorClass = SLIM0110IValidator.class)
    public SLIM0110IResult addAgentSupplyQualification(@RequestBody SLIM0110IParam slim0110IParam) {
        SLIM0110IResult slim0110IResult = slim0110IService.saveAgentSupplyQualification(slim0110IParam);
        slim0110IResult.setMessage(new String[]{MessageConstant.SUCCESS, "新增卖家代理商供应资质成功"});
        return slim0110IResult;
    }
}
