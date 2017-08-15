package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0604IParam;
import com.bms.slpd.bean.result.SLPD0604IResult;
import com.bms.slpd.services.SLPD0604IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0604IValidator;
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
@Api(description = "新增饲养标准指标",tags = "SLPD0604IRestController")
public class SLPD0604IRestController extends BaseRestController {
    @Autowired
    private SLPD0604IService slpd0604IService;

    @ApiOperation(value = "新增饲养标准指标",
            notes = "bean传入List参数,新增数据")
    @Validator(validatorClass = SLPD0604IValidator.class)
    @RequestMapping(value = "/products/feed/standards/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLPD0604IResult addFedStandards(@RequestBody SLPD0604IParam param) {
        SLPD0604IResult slpd0604Result = slpd0604IService.saveFedStandards(param.getFedStdParams());
        slpd0604Result.setMessage(MessageUtils.getSuccessMessage());
        return slpd0604Result;
    }

}
