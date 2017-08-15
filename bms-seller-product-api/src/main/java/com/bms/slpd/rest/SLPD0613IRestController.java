package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0613IParam;
import com.bms.slpd.bean.result.SLPD0613IResult;
import com.bms.slpd.services.SLPD0613IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0613IValidator;
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
@Api(description = "新增通用质量标准指标",tags = "Slpd0613IRestController")
public class SLPD0613IRestController extends BaseRestController {
    @Autowired
    private SLPD0613IService slpd0613IService;

    @ApiOperation(value = "新增通用质量质量标准指标",
            notes = "bean传入List参数,新增数据")
    @Validator(validatorClass = SLPD0613IValidator.class)
    @RequestMapping(value = "/products/universal/quality/standards/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLPD0613IResult addGnqStandards(@RequestBody SLPD0613IParam param) {
        SLPD0613IResult slpd0613Result = slpd0613IService.saveGnqStandards(param.getGnqStdParams());
        slpd0613Result.setMessage(MessageUtils.getSuccessMessage());
        return slpd0613Result;
    }

}
