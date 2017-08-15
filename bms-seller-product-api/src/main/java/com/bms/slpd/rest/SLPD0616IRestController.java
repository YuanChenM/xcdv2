package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0616IParam;
import com.bms.slpd.bean.result.SLPD0616IResult;
import com.bms.slpd.services.SLPD0616IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0616IValidator;
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
@Api(description = "新增安全标准指标",tags = "SLPD0616IRestController")
public class SLPD0616IRestController extends BaseRestController {
    @Autowired
    private SLPD0616IService slpd0616IService;

    @ApiOperation(value = "新增安全标准指标",
            notes = "传入参数:beans!新增安全标准指标")
    @Validator(validatorClass = SLPD0616IValidator.class)
    @RequestMapping(value = "/products/safety/standards/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLPD0616IResult addSftStandards(@RequestBody SLPD0616IParam param) {
        SLPD0616IResult slpd0616IResult = slpd0616IService.saveSftStds(param.getSftStdParams());
        slpd0616IResult.setMessage(MessageUtils.getSuccessMessage());
        return slpd0616IResult;
    }
}
