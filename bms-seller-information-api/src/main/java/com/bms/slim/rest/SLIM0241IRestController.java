package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0241IParam;
import com.bms.slim.bean.result.SLIM0241IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0241IService;
import com.bms.slim.validator.SLIM0241IValidator;
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
@Api(description = "新增平台生产商接口", tags = "SLIM0241IRestController")
public class SLIM0241IRestController extends BaseRestController {

    @Autowired
    private SLIM0241IService slim0241IService;

    @ApiOperation(value = "新增平台生产商",
            notes = "传入参数:beans!新增平台生产商")
    @RequestMapping(value = "/producers/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLIM0241IValidator.class)
    public SLIM0241IResult addSellerProducers(@RequestBody SLIM0241IParam slim0241IParam) {
        SLIM0241IResult slim0241IResult = slim0241IService.saveProducers(slim0241IParam);
        slim0241IResult.setMessage(new String[]{MessageConstant.SUCCESS, "新增平台生产商成功"});
        return slim0241IResult;
    }

}
