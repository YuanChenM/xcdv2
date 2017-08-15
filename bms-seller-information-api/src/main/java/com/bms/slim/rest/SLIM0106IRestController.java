package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0106IParam;
import com.bms.slim.bean.result.SLIM0106IResult;
import com.bms.slim.services.SLIM0106IService;
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
@Api(tags = "SLIM0106IRestController", description = "修改卖家经营资质")
public class SLIM0106IRestController extends BaseRestController {

    @Autowired
    private SLIM0106IService slim0106IService;

    @ApiOperation(value = "修改卖家经营资质",
            notes = "根据entitySellerId修改卖家经营资质")
    @RequestMapping(value = "/sellers/business/qualifications/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
//    @Validator(validatorClass = SLIM0106IValidator.class)
    public SLIM0106IResult addSBQs(@RequestBody SLIM0106IParam slim0106IParam) {
        return slim0106IService.updateSBQ(slim0106IParam);
    }
}
