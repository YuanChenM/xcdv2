package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0607IParam;
import com.bms.slpd.bean.result.SLPD0607IResult;
import com.bms.slpd.services.SLPD0607IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0607IValidator;
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
@Api(description = "新增加工技术标准指标",
        tags = "SLPD0607IRestController")
public class SLPD0607IRestController extends BaseRestController {
    @Autowired
    private SLPD0607IService slpd0607IService;

    @ApiOperation(value = "新增加工技术标准指标",notes = "传入参数:beans!新增加工技术标准指标")
    @RequestMapping(value = "/products/process/technology/standards/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0607IValidator.class)
    public SLPD0607IResult addMctStandards(@RequestBody SLPD0607IParam param) {
        SLPD0607IResult slpd0607IResult = slpd0607IService.saveMctStds(param.getMctStdParams());
        slpd0607IResult.setMessage(MessageUtils.getSuccessMessage());
        return slpd0607IResult;
    }
}
