package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0213IParam;
import com.bms.slim.bean.result.SLIM0213IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0213IService;
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
@Api(description = "新增生产商生产资质-进沪(京、津)登记信息接口", tags = "SLIM0213IRestController")
public class SLIM0213IRestController extends BaseRestController {

    @Autowired
    private SLIM0213IService slim0213IService;

    @ApiOperation(value = "新增生产商生产资质-进沪(京、津)登记信息",
            notes = "传入参数:beans!新增生产商生产资质-进沪(京、津)登记信息")
    @RequestMapping(value = "/producers/production/qualifications/registration/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
//    @Validator(validatorClass = SLIM0204IValidator.class)
    public SLIM0213IResult addShBjTjRegistrations(@RequestBody SLIM0213IParam slim0213IParam) {
        SLIM0213IResult slim0213IResult = slim0213IService.saveShBjTjRegistrations(slim0213IParam);
        slim0213IResult.setMessage(new String[]{MessageConstant.SUCCESS, "新增生产商生产资质-进沪(京、津)登记信息成功"});
        return slim0213IResult;
    }
}
