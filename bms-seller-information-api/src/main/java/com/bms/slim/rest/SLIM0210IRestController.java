package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0210IParam;
import com.bms.slim.bean.result.SLIM0210IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0210IService;
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
@Api(description = "新增生产商生产资质-清真食品生产经营许可证接口", tags = "SLIM0210IRestController")
public class SLIM0210IRestController extends BaseRestController {

    @Autowired
    private SLIM0210IService slim0210IService;

    @ApiOperation(value = "新增生产商生产资质-清真食品生产经营许可证",
            notes = "传入参数:beans!新增生产商生产资质-清真食品生产经营许可证")
    @RequestMapping(value = "/producers/production/qualifications/halal/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
//    @Validator(validatorClass = SLIM0204IValidator.class)
    public SLIM0210IResult addHalalFoodProductionOperationLicenses(@RequestBody SLIM0210IParam slim0210IParam) {
        SLIM0210IResult slim0210IResult = slim0210IService.saveHalalFoodProductionOperationLicenses(slim0210IParam);
        slim0210IResult.setMessage(new String[]{MessageConstant.SUCCESS, "新增生产商生产资质-清真食品生产经营许可证成功"});
        return slim0210IResult;
    }
}
