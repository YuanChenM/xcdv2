package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0222IParam;
import com.bms.slim.bean.param.SLIM0231IParam;
import com.bms.slim.bean.result.SLIM0222IResult;
import com.bms.slim.bean.result.SLIM0231IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0222IService;
import com.bms.slim.services.SLIM0231IService;
import com.bms.slim.validator.SLIM0231IValidator;
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
@Api(description = "批量新增生产商荣誉证书接口", tags = "SLIM0222IRestController")
public class SLIM0222IRestController extends BaseRestController {

    @Autowired
    private SLIM0222IService slim0222IService;

    @ApiOperation(value = "批量新增生产商荣誉证书",
            notes = "传入参数:beans!批量新增生产商荣誉证书")
    @RequestMapping(value = "/producers/honor/certificates/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
//    @Validator(validatorClass = SLIM0231IValidator.class)
    public SLIM0222IResult addProducerHonorCertificates(@RequestBody SLIM0222IParam slim0222IParam) {
        SLIM0222IResult slim0222IResult = slim0222IService.addProducerHonorCertificate(slim0222IParam);
        slim0222IResult.setMessage(new String[]{MessageConstant.SUCCESS, "新增生产商荣誉证书成功"});
        return slim0222IResult;
    }
}
