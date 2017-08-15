package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0104IParam;
import com.bms.slim.bean.result.SLIM0104IResult;
import com.bms.slim.services.SLIM0104IService;
import com.bms.slim.validator.SLIM0104IValidator;
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
@Api(tags = "SLIM0104IRestController", description = "新增卖家经营资质")
public class SLIM0104IRestController extends BaseRestController {

    @Autowired
    private SLIM0104IService slim0104IService;

    @ApiOperation(value = "新增卖家经营资质",
            notes = "新增卖家经营资质，返回卖家经营资质ID")
    @RequestMapping(value = "/sellers/business/qualifications/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
//    @Validator(validatorClass = SLIM0104IValidator.class)
    public SLIM0104IResult addSBQs(@RequestBody SLIM0104IParam slim0104IParam) {
        return slim0104IService.addSellerBusinessQualifications(slim0104IParam);
    }
}
