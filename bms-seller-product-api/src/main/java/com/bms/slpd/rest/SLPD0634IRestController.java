package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0634IParam;
import com.bms.slpd.bean.result.SLPD0634IResult;
import com.bms.slpd.services.SLPD0634IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0634IValidator;
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
@Api(description = "新增加工质量标准差异",
        tags = "SLPD0634IRestController")
public class SLPD0634IRestController extends BaseRestController {
    @Autowired
    private SLPD0634IService slpd0634IService;

    @ApiOperation(value = "新增加工质量标准差异",
            notes = "传入参数:beans!新增加工质量标准差异")
    @RequestMapping(value = "/products/process/quality/standards/differences/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0634IValidator.class)
    public SLPD0634IResult addTncDifStandards(@RequestBody SLPD0634IParam param) throws Exception {
        SLPD0634IResult slpd0634IResult = slpd0634IService.saveTncDifStds(param.getTncDifStdParams());
        slpd0634IResult.setMessage(MessageUtils.getSuccessMessage());
        return slpd0634IResult;
    }
}
