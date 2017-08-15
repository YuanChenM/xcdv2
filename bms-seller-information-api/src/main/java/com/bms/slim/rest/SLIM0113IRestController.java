package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0113IParam;
import com.bms.slim.bean.result.SLIM0113IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0113IService;
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
@Api(description = "新增卖家制造商供应资质接口", tags = "SLIM0113IRestController")
public class SLIM0113IRestController extends BaseRestController {

    @Autowired
    private SLIM0113IService slim0113IService;

    @ApiOperation(value = "新增卖家制造商供应资质",
            notes = "传入参数:beans!新增卖家制造商供应资质")
    @RequestMapping(value = "/sellers/manufacturer/supply/qualifications/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
//    @Validator(validatorClass = SLIM0113IValidator.class)
    public SLIM0113IResult addManufacturerSupplyQualification(@RequestBody SLIM0113IParam slim0113IParam) {
        SLIM0113IResult slim0113IResult = slim0113IService.saveManufacturerSupplyQualification(slim0113IParam);
        slim0113IResult.setMessage(new String[]{MessageConstant.SUCCESS, "新增卖家制造商供应资质成功"});
        return slim0113IResult;
    }
}
