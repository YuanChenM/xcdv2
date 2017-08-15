package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0233IParam;
import com.bms.slim.bean.result.SLIM0233IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0233IService;
import com.bms.slim.validator.SLIM0233IValidator;
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
@Api(description = "批量修改生产商库容接口", tags = "SLIM0233IRestController")
public class SLIM0233IRestController extends BaseRestController {

    @Autowired
    private SLIM0233IService slim0233IService;

    @ApiOperation(value = "批量修改生产商库容",
            notes = "传入参数:beans!批量修改生产商库容")
    @RequestMapping(value = "/producers/storage/capacities/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLIM0233IValidator.class)
    public SLIM0233IResult modifyProducerStorageCapacities(@RequestBody SLIM0233IParam slim0233IParam) {
        SLIM0233IResult slim0233IResult = slim0233IService.updateProducerStorageCapacities(slim0233IParam);
        slim0233IResult.setMessage(new String[]{MessageConstant.SUCCESS, "修改生产商库容成功"});
        return slim0233IResult;
    }

}
