package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0640IParam;
import com.bms.slpd.bean.result.SLPD0640IResult;
import com.bms.slpd.services.SLPD0640IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0640IValidator;
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
@Api(description = "新增安全标准指标差异",
        tags = "SLPD0640IRestController")
public class SLPD0640IRestController extends BaseRestController {
    @Autowired
    private SLPD0640IService slpd0640IService;

    @ApiOperation(value = "新增安全标准指标差异",
            notes = "bean传入List参数,新增数据")
    @Validator(validatorClass = SLPD0640IValidator.class)
    @RequestMapping(value = "/products/safety/standards/differences/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLPD0640IResult addDifSftStandards(@RequestBody SLPD0640IParam param) {
        SLPD0640IResult slpd0640Result = slpd0640IService.saveDifSftStandards(param.getSftDifStdParams());
        slpd0640Result.setMessage(MessageUtils.getSuccessMessage());
        return slpd0640Result;
    }

}
