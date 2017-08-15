package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0702IParam;
import com.bms.slpd.bean.result.SLPD0702IResult;
import com.bms.slpd.services.SLPD0702IService;
import com.bms.slpd.validator.SLPD0702IValidator;
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
@Api(description = "新增单品品牌(规格)生产商", tags = "SLPD0702IRestController")
public class SLPD0702IRestController extends BaseRestController {

    @Autowired
    private SLPD0702IService slpd0702IService;

    @ApiOperation(value = "新增单品品牌(规格)生产商",
            notes = "新增单品品牌(规格)生产商")
    @RequestMapping(value = "/products/producers/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0702IValidator.class)
    public SLPD0702IResult addItems(@RequestBody SLPD0702IParam requestParam) {
        SLPD0702IResult slpd0702IResult = slpd0702IService.saveProducerProducts(requestParam.getProductProducerList());
        //slpd0702IResult.setMessage(new String[]{message});
        return slpd0702IResult;
    }
}
