package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0625IParam;
import com.bms.slpd.bean.result.SLPD0625IResult;
import com.bms.slpd.services.SLPD0625IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0625IValidator;
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
@Api(description = "新增原种种源标准指标差异",
        tags = "SLPD0625IRestController")
public class SLPD0625IRestController extends BaseRestController {
    @Autowired
    private SLPD0625IService slpd0625IService;

    @ApiOperation(value = "新增原种种源标准指标差异",
            notes = "传入参数:beans!新增原种种源标准指标差异")
    @RequestMapping(value = "products/origin/standard/differences/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0625IValidator.class)
    public SLPD0625IResult addDifOrgStandards(@RequestBody SLPD0625IParam param) {
        SLPD0625IResult slpd0625IResult = slpd0625IService.saveOrgDifStds(param.getOrgDifStdParams());
        slpd0625IResult.setMessage(MessageUtils.getSuccessMessage());
        return slpd0625IResult;
    }

}
