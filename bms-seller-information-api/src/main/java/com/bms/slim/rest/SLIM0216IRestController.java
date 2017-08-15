package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0216IParam;
import com.bms.slim.bean.result.SLIM0216IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0216IService;
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
@Api(description = "新增生产商生产资质-食品生产许可证接口", tags = "SLIM0216IRestController")
public class SLIM0216IRestController extends BaseRestController {

    @Autowired
    private SLIM0216IService slim0216IService;

    @ApiOperation(value = "新增生产商生产资质-食品生产许可证",
            notes = "传入参数:beans!新增生产商生产资质-食品生产许可证")
    @RequestMapping(value = "/producers/production/qualifications/food/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
//    @Validator(validatorClass = SLIM0204IValidator.class)
    public SLIM0216IResult addFoodProductionLicense(@RequestBody SLIM0216IParam slim0216IParam) {
        SLIM0216IResult slim0216IResult = slim0216IService.saveFoodProductionLicense(slim0216IParam);
        slim0216IResult.setMessage(new String[]{MessageConstant.SUCCESS, "新增生产商生产资质-食品生产许可证成功"});
        return slim0216IResult;
    }
}
