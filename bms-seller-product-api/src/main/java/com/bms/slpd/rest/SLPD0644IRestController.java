package com.bms.slpd.rest;


import com.bms.slpd.bean.param.SLPD0644IParam;
import com.bms.slpd.bean.result.SLPD0644IResult;
import com.bms.slpd.services.SLPD0644IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0644IValidator;
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
@Api(description = "修改储存运输标准指标差异",
        tags = "SLPD0644IRestController")
public class SLPD0644IRestController extends BaseRestController {
    @Autowired
    private SLPD0644IService slpd0644IService;

    @ApiOperation(value = "修改储存运输标准指标差异",
            notes = "传入参数:beans!修改储存运输标准指标差异")
    @RequestMapping(value = "/products/storage/transportation/standards/differences/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0644IValidator.class)
    public SLPD0644IResult modifyDifTspStandards(@RequestBody SLPD0644IParam slpd0644IParam) {
        SLPD0644IResult result = slpd0644IService.updateTspDifStds(slpd0644IParam);
        result.setMessage(MessageUtils.getSuccessMessage());
        return result;
    }
}