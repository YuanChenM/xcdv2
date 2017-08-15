package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0118IParam;
import com.bms.slim.bean.result.SLIM0118IResult;
import com.bms.slim.services.SLIM0118IService;
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
@Api(tags = "SLIM0118IRestController", description = "修改卖家合同信息准入")
public class SLIM0118IRestController extends BaseRestController {

    @Autowired
    private SLIM0118IService slim0118IService;

    @ApiOperation(value = "修改卖家合同信息准入",
            notes = "根据scpId修改卖家合同信息准入")
    @RequestMapping(value = "/sellers/contacts/permissions/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
//    @Validator(validatorClass = SLIM0118IValidator.class)
    public SLIM0118IResult addSBQs(@RequestBody SLIM0118IParam slim0118IParam) {
        return slim0118IService.updateSCP(slim0118IParam);
    }
}
