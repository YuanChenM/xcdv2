package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0224IParam;
import com.bms.slim.bean.param.SLIM0230IParam;
import com.bms.slim.bean.result.SLIM0224IResult;
import com.bms.slim.bean.result.SLIM0230IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0224IService;
import com.bms.slim.services.SLIM0230IService;
import com.bms.slim.validator.SLIM0230IValidator;
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
@Api(description = "批量修改生产商荣誉证书接口", tags = "SLIM0224IRestController")
public class SLIM0224IRestController extends BaseRestController {

    @Autowired
    private SLIM0224IService slim0224IService;

    @ApiOperation(value = "批量修改生产商荣誉证书",
            notes = "传入参数:beans!批量修改生产商荣誉证书")
    @RequestMapping(value = "/producers/honor/certificates/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
//    @Validator(validatorClass = SLIM0224IValidator.class)
    public SLIM0224IResult modifyProducerHonorCertificate(@RequestBody SLIM0224IParam slim0224IParam) {
        SLIM0224IResult slim0224IResult = slim0224IService.updateProducerHonorCertificate(slim0224IParam);
        slim0224IResult.setMessage(new String[]{MessageConstant.SUCCESS, "修改生产商荣誉证书成功"});
        return slim0224IResult;
    }

}
