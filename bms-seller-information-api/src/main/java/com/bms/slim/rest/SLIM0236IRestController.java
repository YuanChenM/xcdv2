package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0236IParam;
import com.bms.slim.bean.result.SLIM0236IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0236IService;
import com.bms.slim.validator.SLIM0236IValidator;
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
@Api(description = "批量修改生产商实验室接口", tags = "SLIM0236IRestController")
public class SLIM0236IRestController extends BaseRestController {

    @Autowired
    private SLIM0236IService slim0236IService;

    @ApiOperation(value = "批量修改生产商实验室",
            notes = "传入参数:beans!批量修改生产商实验室")
    @RequestMapping(value = "/producers/laboratories/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLIM0236IValidator.class)
    public SLIM0236IResult modifyProducerLaboratories(@RequestBody SLIM0236IParam slim0236IParam) {
        SLIM0236IResult slim0236IResult = slim0236IService.updateProducerLaboratories(slim0236IParam);
        slim0236IResult.setMessage(new String[]{MessageConstant.SUCCESS, "修改生产商实验室成功"});
        return slim0236IResult;
    }

}
