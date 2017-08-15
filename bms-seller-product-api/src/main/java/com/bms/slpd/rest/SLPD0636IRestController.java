package com.bms.slpd.rest;


import com.bms.slpd.bean.param.SLPD0636IParam;
import com.bms.slpd.bean.result.SLPD0636IResult;
import com.bms.slpd.services.SLPD0636IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0636IValidator;
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
@Api(description = "修改加工质量标准差异",
        tags = "SLPD0636IRestController")
public class SLPD0636IRestController extends BaseRestController {
    @Autowired
    private SLPD0636IService slpd0636IService;

    @ApiOperation(value = "修改加工质量标准差异",
            notes = "传入参数:beans!修改加工质量标准差异")
    @RequestMapping(value = "/products/process/quality/standards/differences/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0636IValidator.class)
    public SLPD0636IResult modifyDifTncStandards(@RequestBody SLPD0636IParam restRequest) {
        SLPD0636IResult result = slpd0636IService.updateTncDifStds(restRequest);
        result.setMessage(MessageUtils.getSuccessMessage());
        return result;
    }
}