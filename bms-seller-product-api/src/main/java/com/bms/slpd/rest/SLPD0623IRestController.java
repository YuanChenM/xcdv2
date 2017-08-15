package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0623IParam;
import com.bms.slpd.bean.result.SLPD0623IResult;
import com.bms.slpd.services.SLPD0623IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0623IValidator;
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
@Api(description = "修改包装标准指标",tags = "SLPD0623IRestController")
public class SLPD0623IRestController extends BaseRestController {

    @Autowired
    private SLPD0623IService slpd0623IService;

    @ApiOperation(value = "修改包装标准指标",
            notes = "修改包装标准指标")
    @RequestMapping(value = "/products/package/standard/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0623IValidator.class)
    public SLPD0623IResult modifyPkgStds(@RequestBody SLPD0623IParam slpd0623IParam) {
        SLPD0623IResult slpd0623IResult = slpd0623IService.modifyPkgStds(slpd0623IParam);
        slpd0623IResult.setMessage(MessageUtils.getSuccessMessage());
        return slpd0623IResult;
    }

}
