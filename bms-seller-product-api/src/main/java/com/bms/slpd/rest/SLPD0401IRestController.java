package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0401IParam;
import com.bms.slpd.bean.result.SLPD0401IResult;
import com.bms.slpd.services.SLPD0401IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0401IValidator;
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
@Api(value = "批量新增品牌",
        description = "批量新增品牌",
        tags = "SLPD0401IRestController")
public class SLPD0401IRestController extends BaseRestController {
    @Autowired
    private SLPD0401IService slpd0401IService;

    @ApiOperation(value = "批量新增品牌",
            notes = "传入bean参数列表,新增数据")
    @RequestMapping(value = "/brands/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0401IValidator.class)
    public SLPD0401IResult addBrandStandards(@RequestBody SLPD0401IParam slpd0401IParam) {
        SLPD0401IResult slpd0401Result = slpd0401IService.saveBrandStandards(slpd0401IParam.getBeans());

        slpd0401Result.setMessage(MessageUtils.getSuccessMessage());
        return slpd0401Result;
    }

}
