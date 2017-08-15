package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0203IParam;
import com.bms.slim.bean.result.SLIM0203IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0203IService;
import com.bms.slim.validator.SLIM0203IValidator;
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
@Api(description = "修改卖家生产商接口", tags = "SLIM0203IRestController")
public class SLIM0203IRestController extends BaseRestController {

    @Autowired
    private SLIM0203IService slim0203IService;

    @ApiOperation(value = "修改卖家生产商",
            notes = "传入参数:beans!修改卖家生产商")
    @RequestMapping(value = "/sellers/producers/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLIM0203IValidator.class)
    public SLIM0203IResult modifySellerProducer(@RequestBody SLIM0203IParam slim0203IParam) {
        SLIM0203IResult slim0203IResult = slim0203IService.updateSellerProducers(slim0203IParam);
        slim0203IResult.setMessage(new String[]{MessageConstant.SUCCESS, "修改卖家生产商成功"});
        return slim0203IResult;
    }

}
