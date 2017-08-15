package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0227IParam;
import com.bms.slim.bean.result.SLIM0227IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0227IService;
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
@Api(description = "批量修改生产商工厂接口", tags = "SLIM0227IRestController")
public class SLIM0227IRestController extends BaseRestController {

    @Autowired
    private SLIM0227IService slim0227IService;

    @ApiOperation(value = "批量修改生产商工厂",
            notes = "传入参数:beans!批量修改生产商工厂")
    @RequestMapping(value = "/producers/factories/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
//    @Validator(validatorClass = SLIM0227IValidator.class)
    public SLIM0227IResult modifyProducerFactory(@RequestBody SLIM0227IParam slim0227IParam) {
        SLIM0227IResult slim0227IResult = slim0227IService.updateProducerFactory(slim0227IParam);
        slim0227IResult.setMessage(new String[]{MessageConstant.SUCCESS, "修改生产商工厂成功"});
        return slim0227IResult;
    }

}
