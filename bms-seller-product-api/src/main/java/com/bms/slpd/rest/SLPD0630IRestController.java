package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0630IParam;
import com.bms.slpd.bean.result.SLPD0630IResult;
import com.bms.slpd.services.SLPD0630IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0630IValidator;
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
@Api(description = "修改饲养标准指标差异",
        tags = "SLPD0630IRestController")
public class SLPD0630IRestController extends BaseRestController {

    @Autowired
    private SLPD0630IService slpd0630IService;

    @ApiOperation(value = "修改饲养标准指标差异",
            notes = "修改饲养标准指标差异")
    @RequestMapping(value = "/products/feed/standard/differences/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0630IValidator.class)
    public SLPD0630IResult modifyDifFedStds(@RequestBody SLPD0630IParam slpd0630IParam) {
        SLPD0630IResult slpd0630IResult = slpd0630IService.modifyDifFedStds(slpd0630IParam);
        slpd0630IResult.setMessage(MessageUtils.getSuccessMessage());
        return slpd0630IResult;
    }

}
