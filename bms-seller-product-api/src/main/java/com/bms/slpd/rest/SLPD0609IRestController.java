package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0609IParam;
import com.bms.slpd.bean.result.SLPD0609IResult;
import com.bms.slpd.services.SLPD0609IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0609IValidator;
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
@Api(description = "修改加工技术标准指标",
        tags = "SLPD0609IRestController")
public class SLPD0609IRestController extends BaseRestController {
    @Autowired
    private SLPD0609IService slpd0609IService;

    @ApiOperation(value = "修改加工技术标准指标",
            notes = "传入参数beans!修改加工技术标准指标")
    @RequestMapping(value = "/products/process/technology/standards/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0609IValidator.class)
    public SLPD0609IResult modifyMctStandards(@RequestBody SLPD0609IParam restRequest) {
        SLPD0609IResult result = slpd0609IService.updateMctStds(restRequest);
        result.setMessage(MessageUtils.getSuccessMessage());
        return result;
    }
}