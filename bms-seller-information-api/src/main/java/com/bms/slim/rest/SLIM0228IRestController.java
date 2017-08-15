package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0228IParam;
import com.bms.slim.bean.result.SLIM0228IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0228IService;
import com.bms.slim.validator.SLIM0228IValidator;
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
@Api(description = "批量新增生产商车间接口", tags = "SLIM0228IRestController")
public class SLIM0228IRestController extends BaseRestController {

    @Autowired
    private SLIM0228IService slim0228IService;

    @ApiOperation(value = "批量新增生产商车间",
            notes = "传入参数:beans!批量新增生产商车间")
    @RequestMapping(value = "/producers/workshops/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLIM0228IValidator.class)
    public SLIM0228IResult addProducerWorkShops(@RequestBody SLIM0228IParam slim0228IParam) {
        SLIM0228IResult slim0228IResult = slim0228IService.addProducerWorkShops(slim0228IParam);
        slim0228IResult.setMessage(new String[]{MessageConstant.SUCCESS, "新增生产商车间成功"});
        return slim0228IResult;
    }
}
