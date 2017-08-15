package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0242IParam;
import com.bms.slim.bean.result.SLIM0242IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0242IService;
import com.bms.slim.validator.SLIM0242IValidator;
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
@Api(description = "修改平台生产商接口", tags = "SLIM0242IRestController")
public class SLIM0242IRestController extends BaseRestController {

    @Autowired
    private SLIM0242IService slim0242IService;

    @ApiOperation(value = "修改平台生产商",
            notes = "传入参数:beans!修改平台生产商")
    @RequestMapping(value = "/producers/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLIM0242IValidator.class)
    public SLIM0242IResult modifySellerProducer(@RequestBody SLIM0242IParam slim0242IParam) {
        SLIM0242IResult slim0242IResult = slim0242IService.updateProducers(slim0242IParam);
        slim0242IResult.setMessage(new String[]{MessageConstant.SUCCESS, "修改平台生产商成功"});
        return slim0242IResult;
    }

}
