package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0243IParam;
import com.bms.slim.bean.result.SLIM0243IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0243IService;
import com.bms.slim.validator.SLIM0243IValidator;
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
@Api(description = "新增卖家生产商关联接口", tags = "SLIM0243IRestController")
public class SLIM0243IRestController extends BaseRestController {

    @Autowired
    private SLIM0243IService slim0243IService;

    @ApiOperation(value = "新增卖家生产商关联",
            notes = "传入参数:beans!新增卖家生产商关联")
    @RequestMapping(value = "/sellers/producers/relations/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLIM0243IValidator.class)
    public SLIM0243IResult addSellerProducers(@RequestBody SLIM0243IParam slim0243IParam) {
        SLIM0243IResult slim0201IResult = slim0243IService.saveSellerProducers(slim0243IParam);
        slim0201IResult.setMessage(new String[]{MessageConstant.SUCCESS, "新增卖家生产商关联成功"});
        return slim0201IResult;
    }
}
