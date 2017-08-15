package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0628IParam;
import com.bms.slpd.bean.result.SLPD0628IResult;
import com.bms.slpd.services.SLPD0628IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0628IValidator;
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
@Api(description = "新增饲养标准指标差异",
        tags = "SLPD0628IRestController")
public class SLPD0628IRestController extends BaseRestController {

    @Autowired
    private SLPD0628IService slpd0628IService;

    @ApiOperation(value = "新增饲养标准指标差异",
            notes = "新增饲养标准指标差异")
    @RequestMapping(value = "/products/feed/standard/differences/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0628IValidator.class)
    public SLPD0628IResult addDifFedStds(@RequestBody SLPD0628IParam param) {
        SLPD0628IResult slpd0628IResult = slpd0628IService.addDifFedStds(param.getFedDifStdParams());
        slpd0628IResult.setMessage(MessageUtils.getSuccessMessage());
        return slpd0628IResult;
    }

}
