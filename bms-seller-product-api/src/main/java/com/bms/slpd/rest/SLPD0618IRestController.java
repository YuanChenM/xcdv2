package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0618IParam;
import com.bms.slpd.bean.result.SLPD0618IResult;
import com.bms.slpd.services.SLPD0618IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0618IValidator;
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
@Api(description = "修改安全标准指标",tags = "SLPD0618IRestController")
public class SLPD0618IRestController extends BaseRestController {
    @Autowired
    private SLPD0618IService slpd0618IService;

    @ApiOperation(value = "修改安全标准指标",
            notes = "传入参数:beans!修改安全标准指标")
    @Validator(validatorClass = SLPD0618IValidator.class)
    @RequestMapping(value = "/products/safety/standards/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLPD0618IResult modifySftStandards(@RequestBody SLPD0618IParam restRequest) {
        SLPD0618IResult result = slpd0618IService.updateMctStds(restRequest);
        result.setMessage(MessageUtils.getSuccessMessage());
        return result;
    }
}