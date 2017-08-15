package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0619IParam;
import com.bms.slpd.bean.result.SLPD0619IResult;
import com.bms.slpd.services.SLPD0619IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0619IValidator;
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
@Api(description = "新增储存运输标准指标",
        tags = "SLPD0619IRestController")
public class SLPD0619IRestController extends BaseRestController {

    @Autowired
    private SLPD0619IService slpd0619IService;

    @ApiOperation(value = "新增储存运输标准指标",
            notes = "新增储存运输标准指标")
    @RequestMapping(value = "/products/storage/transportation/standards/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0619IValidator.class)
    public SLPD0619IResult addTspStds(@RequestBody SLPD0619IParam param) {
        SLPD0619IResult slpd0619IResult = slpd0619IService.addTspStds(param.getTspStdParams());
        slpd0619IResult.setMessage(MessageUtils.getSuccessMessage());
        return slpd0619IResult;
    }

}
