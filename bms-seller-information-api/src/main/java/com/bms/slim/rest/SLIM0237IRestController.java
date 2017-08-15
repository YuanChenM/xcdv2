package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0237IParam;
import com.bms.slim.bean.result.SLIM0237IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0237IService;
import com.bms.slim.validator.SLIM0237IValidator;
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
@Api(description = "批量新增生产商检测设备接口", tags = "SLIM0237IRestController")
public class SLIM0237IRestController extends BaseRestController {

    @Autowired
    private SLIM0237IService slim0237IService;

    @ApiOperation(value = "批量新增生产商检测设备",
            notes = "传入参数:beans!批量新增生产商检测设备")
    @RequestMapping(value = "/producers/test/equipments/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLIM0237IValidator.class)
    public SLIM0237IResult addProducerTestEquipments(@RequestBody SLIM0237IParam slim0237IParam) {
        SLIM0237IResult slim0237IResult = slim0237IService.addProducerTestEquipments(slim0237IParam);
        slim0237IResult.setMessage(new String[]{MessageConstant.SUCCESS, "新增生产商检测设备成功"});
        return slim0237IResult;
    }
}
