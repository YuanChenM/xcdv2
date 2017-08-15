package com.bms.slpd.rest;


import com.bms.slpd.bean.param.SLPD0642IParam;
import com.bms.slpd.bean.result.SLPD0642IResult;
import com.bms.slpd.services.SLPD0642IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0642IValidator;
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
@Api(description = "修改安全标准指标差异",
        tags = "SLPD0642IRestController")
public class SLPD0642IRestController extends BaseRestController {
    @Autowired
    private SLPD0642IService slpd0642IService;

    @ApiOperation(value = "修改安全标准指标差异",
            notes = "beans传入参数,target为指定修改字段.根据beans和target修改安全标准指标差异")
    @Validator(validatorClass = SLPD0642IValidator.class)
    @RequestMapping(value = "/products/safety/standards/differences/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLPD0642IResult modifyDifSftStandards(@RequestBody SLPD0642IParam param) {
        SLPD0642IResult slpd0642IResult = slpd0642IService.updateDifSftStandards(param);
        slpd0642IResult.setMessage(MessageUtils.getSuccessMessage());
        return slpd0642IResult;
    }
}