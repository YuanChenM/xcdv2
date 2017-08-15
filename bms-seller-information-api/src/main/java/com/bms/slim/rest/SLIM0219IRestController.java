package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0219IParam;
import com.bms.slim.bean.result.SLIM0219IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0219IService;
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
@Api(description = "新增生产商生产资质-管理体系认证证书接口", tags = "SLIM0219IRestController")
public class SLIM0219IRestController extends BaseRestController {

    @Autowired
    private SLIM0219IService slim0219IService;

    @ApiOperation(value = "新增生产商生产资质-管理体系认证证书",
            notes = "传入参数:beans!新增生产商生产资质-管理体系认证证书")
    @RequestMapping(value = "/producers/production/qualifications/iso/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
//    @Validator(validatorClass = SLIM0204IValidator.class)
    public SLIM0219IResult addIsoManagementSystemCertification(@RequestBody SLIM0219IParam slim0219IParam) {
        SLIM0219IResult slim0219IResult = slim0219IService.saveIsoManagementSystemCertification(slim0219IParam);
        slim0219IResult.setMessage(new String[]{MessageConstant.SUCCESS, "新增生产商生产资质-管理体系认证证书成功"});
        return slim0219IResult;
    }
}
