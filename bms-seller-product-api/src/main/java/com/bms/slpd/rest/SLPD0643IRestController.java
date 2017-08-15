package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0643IParam;
import com.bms.slpd.bean.result.SLPD0643IResult;
import com.bms.slpd.services.SLPD0643IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0643IValidator;
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
@Api(description = "新增存储运输标准指标差异",
        tags = "SLPD0643IRestController")
public class SLPD0643IRestController extends BaseRestController {
    @Autowired
    private SLPD0643IService slpd0643IService;

    @ApiOperation(value = "新增存储运输标准指标差异",
            notes = "传入参数:beans!新增存储运输标准指标差异")
    @RequestMapping(value = "/products/storage/transportation/standards/differences/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0643IValidator.class)
    public SLPD0643IResult addTspStandards(@RequestBody SLPD0643IParam param) {
        SLPD0643IResult slpd0643IResult = slpd0643IService.saveTspDifStds(param.getTspDifStdParams());
        slpd0643IResult.setMessage(MessageUtils.getSuccessMessage());
        return slpd0643IResult;
    }

}
