package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0603IParam;
import com.bms.slpd.bean.result.SLPD0603IResult;
import com.bms.slpd.services.SLPD0603IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0603IValidator;
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
@Api(description = "修改原种种源标准指标",
        tags = "SLPD0603IRestController")
public class SLPD0603IRestController extends BaseRestController {

    @Autowired
    private SLPD0603IService slpd0603IService;

    @ApiOperation(value = "修改原种种源标准指标",
            notes = "修改原种种源标准指标")
    @RequestMapping(value = "/products/origin/standards/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0603IValidator.class)
    public SLPD0603IResult modifyOrgStds(@RequestBody SLPD0603IParam slpd0603IParam) {
        SLPD0603IResult slpd0603IResult = slpd0603IService.modifyOrgStds(slpd0603IParam);
        slpd0603IResult.setMessage(MessageUtils.getSuccessMessage());
        return slpd0603IResult;
    }

}
