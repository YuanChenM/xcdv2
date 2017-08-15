package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0234IParam;
import com.bms.slim.bean.result.SLIM0234IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0234IService;
import com.bms.slim.validator.SLIM0234IValidator;
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
@Api(description = "批量新增生产商实验室接口", tags = "SLIM0234IRestController")
public class SLIM0234IRestController extends BaseRestController {

    @Autowired
    private SLIM0234IService slim0234IService;

    @ApiOperation(value = "批量新增生产商实验室",
            notes = "传入参数:beans!批量新增生产商实验室")
    @RequestMapping(value = "/producers/laboratories/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLIM0234IValidator.class)
    public SLIM0234IResult addProducerLaboratories(@RequestBody SLIM0234IParam slim0234IParam) {
        SLIM0234IResult slim0234IResult = slim0234IService.addProducerLaboratories(slim0234IParam);
        slim0234IResult.setMessage(new String[]{MessageConstant.SUCCESS, "新增生产商实验室成功"});
        return slim0234IResult;
    }
}
