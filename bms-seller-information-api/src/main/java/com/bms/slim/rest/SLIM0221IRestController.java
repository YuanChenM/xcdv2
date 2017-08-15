package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0221IParam;
import com.bms.slim.bean.result.SLIM0221IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0221IService;
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
@Api(description = "批量修改生产商生产资质-管理体系认证证书接口", tags = "SLIM0221IRestController")
public class SLIM0221IRestController extends BaseRestController {

    @Autowired
    private SLIM0221IService slim0221IService;

    @ApiOperation(value = "批量修改生产商生产资质-管理体系认证证书",
            notes = "传入参数:beans!批量修改生产商生产资质-管理体系认证证书")
    @RequestMapping(value = "/producers/production/qualifications/iso/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
//    @Validator(validatorClass = SLIM0221IValidator.class)
    public SLIM0221IResult modifyIsoManagementSystemCertification(@RequestBody SLIM0221IParam slim0221IParam) {
        SLIM0221IResult slim0221IResult = slim0221IService.updateIsoManagementSystemCertification(slim0221IParam);
        slim0221IResult.setMessage(new String[]{MessageConstant.SUCCESS, "修改生产商生产资质-管理体系认证证书成功"});
        return slim0221IResult;
    }

}
