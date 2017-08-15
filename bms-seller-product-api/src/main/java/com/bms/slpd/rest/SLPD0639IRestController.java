package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0639IParam;
import com.bms.slpd.bean.result.SLPD0639IResult;
import com.bms.slpd.services.SLPD0639IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0639IValidator;
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
@Api(description = "修改通用质量标准指标差异",
        tags = "SLPD0639IRestController")
public class SLPD0639IRestController extends BaseRestController {

    @Autowired
    private SLPD0639IService slpd0639IService;

    @ApiOperation(value = "修改通用质量标准指标差异",
            notes = "修改通用质量标准指标差异")
    @RequestMapping(value = "/products/universal/quality/standards/differences/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0639IValidator.class)
    public SLPD0639IResult modifyDifGnqStds(@RequestBody SLPD0639IParam slpd0639IParam) {
        SLPD0639IResult slpd0639IResult = slpd0639IService.modifyDifGnqStds(slpd0639IParam);
        slpd0639IResult.setMessage(MessageUtils.getSuccessMessage());
        return slpd0639IResult;
    }

}
