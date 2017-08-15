package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0622IParam;
import com.bms.slpd.bean.result.SLPD0622IResult;
import com.bms.slpd.services.SLPD0622IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0621IValidator;
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
@Api(description = "新增包装标准指标",tags = "SLPD0622IRestController")
public class SLPD0622IRestController extends BaseRestController {

    @Autowired
    private SLPD0622IService slpd0622IService;

    @ApiOperation(value = "新增包装标准指标",
            notes = "新增包装标准指标")
    @RequestMapping(value = "/products/package/standard/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0621IValidator.class)
    public SLPD0622IResult addPkgStds(@RequestBody SLPD0622IParam param) {
        SLPD0622IResult slpd0622IResult = slpd0622IService.addPkgStds(param.getPkgStdParams());
        slpd0622IResult.setMessage(MessageUtils.getSuccessMessage());
        return slpd0622IResult;
    }

}
