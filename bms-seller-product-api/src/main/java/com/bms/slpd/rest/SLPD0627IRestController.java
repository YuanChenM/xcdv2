package com.bms.slpd.rest;


import com.bms.slpd.bean.param.SLPD0627IParam;
import com.bms.slpd.bean.result.SLPD0627IResult;
import com.bms.slpd.services.SLPD0627IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0627IValidator;
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
@Api(description = "修改原种种源标准指标差异",
        tags = "SLPD0627IRestController")
public class SLPD0627IRestController extends BaseRestController {
    @Autowired
    private SLPD0627IService slpd0627IService;

    @ApiOperation(value = "修改原种种源标准指标差异",
            notes = "传入参数:beans!修改原种种源标准指标差异")
    @RequestMapping(value = "products/origin/standard/differences/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0627IValidator.class)
    public SLPD0627IResult modifyDifOrgStandards(@RequestBody SLPD0627IParam slpd0627IParam) {
        SLPD0627IResult result = slpd0627IService.updateOrgDifStds(slpd0627IParam);
        result.setMessage(MessageUtils.getSuccessMessage());
        return result;
    }
}