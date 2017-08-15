package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0231IParam;
import com.bms.slim.bean.result.SLIM0231IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0231IService;
import com.bms.slim.validator.SLIM0231IValidator;
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
@Api(description = "批量新增生产商库容接口", tags = "SLIM0231IRestController")
public class SLIM0231IRestController extends BaseRestController {

    @Autowired
    private SLIM0231IService slim0231IService;

    @ApiOperation(value = "批量新增生产商库容",
            notes = "传入参数:beans!批量新增生产商库容")
    @RequestMapping(value = "/producers/storage/capacities/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLIM0231IValidator.class)
    public SLIM0231IResult addProducerStorageCapacities(@RequestBody SLIM0231IParam slim0231IParam) {
        SLIM0231IResult slim0231IResult = slim0231IService.addProducerStorageCapacities(slim0231IParam);
        slim0231IResult.setMessage(new String[]{MessageConstant.SUCCESS, "新增生产商库容成功"});
        return slim0231IResult;
    }
}
