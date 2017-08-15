package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0612IParam;
import com.bms.slpd.bean.result.SLPD0612IResult;
import com.bms.slpd.services.SLPD0612IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0612IValidator;
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
@Api(description = "修改加工质量标准",
        tags = "SLPD0612IRestController")
public class SLPD0612IRestController extends BaseRestController {

    @Autowired
    private SLPD0612IService slpd0612IService;

    @ApiOperation(value = "修改加工质量标准",
            notes = "修改加工质量标准")
    @RequestMapping(value = "/products/process/quality/standards/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0612IValidator.class)
    public SLPD0612IResult modifyTncStds(@RequestBody SLPD0612IParam slpd0612IParam) {
        SLPD0612IResult slpd0612IResult = slpd0612IService.modifyTncStds(slpd0612IParam);
        slpd0612IResult.setMessage(MessageUtils.getSuccessMessage());
        return slpd0612IResult;
    }

}