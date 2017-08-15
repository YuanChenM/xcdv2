package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0230IParam;
import com.bms.slim.bean.result.SLIM0230IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0230IService;
import com.bms.slim.validator.SLIM0230IValidator;
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
@Api(description = "批量修改生产商车间接口", tags = "SLIM0230IRestController")
public class SLIM0230IRestController extends BaseRestController {

    @Autowired
    private SLIM0230IService slim0230IService;

    @ApiOperation(value = "批量修改生产商车间",
            notes = "传入参数:beans!批量修改生产商车间")
    @RequestMapping(value = "/producers/workshops/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLIM0230IValidator.class)
    public SLIM0230IResult modifyProducerWorkShops(@RequestBody SLIM0230IParam slim0230IParam) {
        SLIM0230IResult slim0230IResult = slim0230IService.updateProducerWorkShops(slim0230IParam);
        slim0230IResult.setMessage(new String[]{MessageConstant.SUCCESS, "修改生产商车间成功"});
        return slim0230IResult;
    }

}
