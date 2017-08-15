package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0620IParam;
import com.bms.slpd.bean.result.SLPD0620IResult;
import com.bms.slpd.services.SLPD0620IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0620IValidator;
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
@Api(description = "修改储存运输标准指标",tags = "SLPD0620IRestController")
public class SLPD0620IRestController extends BaseRestController {

    @Autowired
    private SLPD0620IService slpd0620IService;

    @ApiOperation(value = "修改储存运输标准指标",
            notes = "修改储存运输标准指标")
    @RequestMapping(value = "/products/storage/transportation/standards/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0620IValidator.class)
    public SLPD0620IResult modifyTspStds(@RequestBody SLPD0620IParam slpd0620IParam) {
        SLPD0620IResult slpd0620IResult = slpd0620IService.modifyTspStds(slpd0620IParam);
        slpd0620IResult.setMessage(MessageUtils.getSuccessMessage());
        return slpd0620IResult;
    }

}
