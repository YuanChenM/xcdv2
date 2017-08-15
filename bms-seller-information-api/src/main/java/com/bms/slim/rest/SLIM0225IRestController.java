package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0225IParam;
import com.bms.slim.bean.result.SLIM0225IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0225IService;
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
@Api(description = "批量新增生产商工厂接口", tags = "SLIM0225IRestController")
public class SLIM0225IRestController extends BaseRestController {

    @Autowired
    private SLIM0225IService slim0225IService;

    @ApiOperation(value = "批量新增生产商工厂",
            notes = "传入参数:beans!批量新增生产商工厂")
    @RequestMapping(value = "/producers/factories/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
//    @Validator(validatorClass = SLIM0231IValidator.class)
    public SLIM0225IResult addProducerFactory(@RequestBody SLIM0225IParam slim0225IParam) {
        SLIM0225IResult slim0225IResult = slim0225IService.addProducerFactory(slim0225IParam);
        slim0225IResult.setMessage(new String[]{MessageConstant.SUCCESS, "新增生产商工厂成功"});

        return slim0225IResult;
    }
}
