package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0631IParam;
import com.bms.slpd.bean.result.SLPD0631IResult;
import com.bms.slpd.services.SLPD0631IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0631IValidator;
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
@Api(description = "新增加工技术标准指标差异",
        tags = "SLPD0631IRestController")
public class SLPD0631IRestController extends BaseRestController {
    @Autowired
    private SLPD0631IService slpd0631IService;

    @ApiOperation(value = "新增加工技术标准指标差异",
            notes = "bean传入List参数,新增数据")
    @Validator(validatorClass = SLPD0631IValidator.class)
    @RequestMapping(value = "/products/process/technology/standards/differences/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLPD0631IResult addDifMctStandards(@RequestBody SLPD0631IParam param) {
        SLPD0631IResult slpd0631Result = slpd0631IService.saveDifMctStandards(param.getMctDifStdParams());
        slpd0631Result.setMessage(MessageUtils.getSuccessMessage());
        return slpd0631Result;
    }

}
