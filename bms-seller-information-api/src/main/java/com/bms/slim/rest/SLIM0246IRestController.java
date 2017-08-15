package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0246IParam;
import com.bms.slim.bean.param.SLIM0246IParam;
import com.bms.slim.bean.result.SLIM0246IResult;
import com.bms.slim.services.SLIM0246IService;
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
@Api(tags = "SLIM0246IRestController", description = "修改联系人信息")
public class SLIM0246IRestController extends BaseRestController {

    @Autowired
    private SLIM0246IService slim0246IService;

    @ApiOperation(value = "修改联系人信息",
            notes = "根据contactId修改联系人信息")
    @RequestMapping(value = "/contacts/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
//    @Validator(validatorClass = SLIM0246IValidator.class)
    public SLIM0246IResult updateContacts(@RequestBody SLIM0246IParam slim0246IParam) {
        return slim0246IService.updateContact(slim0246IParam);
    }
}
