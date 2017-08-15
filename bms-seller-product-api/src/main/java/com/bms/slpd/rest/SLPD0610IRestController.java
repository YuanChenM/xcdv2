package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0610IParam;
import com.bms.slpd.bean.result.SLPD0610IResult;
import com.bms.slpd.services.SLPD0610IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0610IValidator;
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
@Api(description = "新增加工质量标准",
        tags = "SLPD0610IRestController")
public class SLPD0610IRestController extends BaseRestController {

    @Autowired
    private SLPD0610IService slpd0610IService;

    @ApiOperation(value = "新增加工质量标准",
            notes = "新增加工质量标准")
    @RequestMapping(value = "/products/process/quality/standards/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0610IValidator.class)
    public SLPD0610IResult addTncStds(@RequestBody SLPD0610IParam param) {
        SLPD0610IResult slpd0610IResult = slpd0610IService.addTncStds(param.getTncStdParams());
        slpd0610IResult.setMessage(MessageUtils.getSuccessMessage());
        return slpd0610IResult;
    }

}
