package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0204IParam;
import com.bms.slim.bean.result.SLIM0204IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0204IService;
import com.bms.slim.validator.SLIM0204IValidator;
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
@Api(description = "新增生产商生产资质-动物防疫条件合格证接口", tags = "SLIM0204IRestController")
public class SLIM0204IRestController extends BaseRestController {

    @Autowired
    private SLIM0204IService slim0204IService;

    @ApiOperation(value = "新增生产商生产资质-动物防疫条件合格证",
            notes = "传入参数:beans!新增生产商生产资质-动物防疫条件合格证")
    @RequestMapping(value = "/producers/production/qualifications/animal/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
//    @Validator(validatorClass = SLIM0204IValidator.class)
    public SLIM0204IResult addAnimalEpidemicPreventionConditionCertificate(@RequestBody SLIM0204IParam slim0204IParam) {
        SLIM0204IResult slim0204IResult = slim0204IService.saveAnimalEpidemicPreventionConditionCertificates(slim0204IParam);
        slim0204IResult.setMessage(new String[]{MessageConstant.SUCCESS, "新增生产商生产资质-动物防疫条件合格证成功"});
        return slim0204IResult;
    }
}
