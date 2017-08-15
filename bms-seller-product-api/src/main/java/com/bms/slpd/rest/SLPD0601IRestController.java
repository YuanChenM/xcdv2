package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0601IParam;
import com.bms.slpd.bean.result.SLPD0601IResult;
import com.bms.slpd.services.SLPD0601IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0601IValidator;
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
@Api(description = "新增原种种源标准指标",
        tags = "SLPD0601IRestController")
public class SLPD0601IRestController extends BaseRestController {

    @Autowired
    private SLPD0601IService slpd0601IService;

    @ApiOperation(value = "新增原种种源标准指标",
            notes = "新增原种种源标准指标")
    @RequestMapping(value = "/products/origin/standards/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0601IValidator.class)
    public SLPD0601IResult addOrgStds(@RequestBody SLPD0601IParam param) {
        SLPD0601IResult slpd0601IResult = slpd0601IService.addOrgStds(param.getOrgStdParams());
        slpd0601IResult.setMessage(MessageUtils.getSuccessMessage());
        return slpd0601IResult;
    }

}
