package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0207IParam;
import com.bms.slim.bean.result.SLIM0207IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0207IService;
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
@Api(description = "新增生产商生产资质-定点屠宰许可证接口", tags = "SLIM0207IRestController")
public class SLIM0207IRestController extends BaseRestController {

    @Autowired
    private SLIM0207IService slim0207IService;

    @ApiOperation(value = "新增生产商生产资质-定点屠宰许可证",
            notes = "传入参数:beans!新增生产商生产资质-定点屠宰许可证")
    @RequestMapping(value = "/producers/production/qualifications/designat/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
//    @Validator(validatorClass = SLIM0204IValidator.class)
    public SLIM0207IResult addDesignatSlaughterPermits(@RequestBody SLIM0207IParam slim0207IParam) {
        SLIM0207IResult slim0207IResult = slim0207IService.saveDesignatSlaughterPermits(slim0207IParam);
        slim0207IResult.setMessage(new String[]{MessageConstant.SUCCESS, "新增生产商生产资质-定点屠宰许可证成功"});
        return slim0207IResult;
    }
}
