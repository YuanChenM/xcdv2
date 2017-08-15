package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0201IParam;
import com.bms.slim.bean.result.SLIM0201IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0201IService;
import com.bms.slim.validator.SLIM0201IValidator;
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
@Api(description = "新增卖家生产商接口", tags = "SLIM0201IRestController")
public class SLIM0201IRestController extends BaseRestController {

    @Autowired
    private SLIM0201IService slim0201IService;

    @ApiOperation(value = "新增卖家生产商",
            notes = "传入参数:beans!新增卖家生产商")
    @RequestMapping(value = "/sellers/producers/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLIM0201IValidator.class)
    public SLIM0201IResult addSellerProducers(@RequestBody SLIM0201IParam slim0201IParam) {
        SLIM0201IResult slim0201IResult = slim0201IService.saveSellerProducers(slim0201IParam);
        slim0201IResult.setMessage(new String[]{MessageConstant.SUCCESS, "新增卖家生产商成功"});
        return slim0201IResult;
    }
}
