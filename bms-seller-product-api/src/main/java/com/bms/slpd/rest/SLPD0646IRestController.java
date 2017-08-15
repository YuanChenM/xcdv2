package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0646IParam;
import com.bms.slpd.bean.result.SLPD0646IResult;
import com.bms.slpd.services.SLPD0646IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0646IValidator;
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
@Api(description = "新增包装标准指标差异",
        tags = "SLPD0646IRestController")
public class SLPD0646IRestController extends BaseRestController {

    @Autowired
    private SLPD0646IService slpd0646IService;

    @ApiOperation(value = "新增包装标准指标差异",
            notes = "新增包装标准指标差异")
    @RequestMapping(value = "/products/package/standards/differences/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0646IValidator.class)
    public SLPD0646IResult addDifPkgStds(@RequestBody SLPD0646IParam param) {
        SLPD0646IResult slpd0646IResult = slpd0646IService.addDifPkgStds(param.getPkgDifStdParams());
        slpd0646IResult.setMessage(MessageUtils.getSuccessMessage());
        return slpd0646IResult;
    }

}
