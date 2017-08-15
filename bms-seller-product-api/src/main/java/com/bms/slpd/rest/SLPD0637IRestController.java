package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0637IParam;
import com.bms.slpd.bean.result.SLPD0637IResult;
import com.bms.slpd.services.SLPD0637IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0637IValidator;
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
@Api(description = "新增通用质量标准指标差异",
        tags = "SLPD0637IRestController")
public class SLPD0637IRestController extends BaseRestController {

    @Autowired
    private SLPD0637IService slpd0637IService;

    @ApiOperation(value = "新增通用质量标准指标差异",
            notes = "新增通用质量标准指标差异")
    @RequestMapping(value = "/products/universal/quality/standards/differences/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0637IValidator.class)
    public SLPD0637IResult addDifGnqStds(@RequestBody SLPD0637IParam param) {
        SLPD0637IResult slpd0637IResult = slpd0637IService.addDifGnqStds(param.getGnqDifStdParams());
        slpd0637IResult.setMessage(MessageUtils.getSuccessMessage());
        return slpd0637IResult;
    }

}
