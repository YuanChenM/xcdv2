package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0606IParam;
import com.bms.slpd.bean.result.SLPD0606IResult;
import com.bms.slpd.services.SLPD0606IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0606IValidator;
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
@Api(description = "修改饲养标准指标",
        tags = "Slpd0606IRestController")
public class SLPD0606IRestController extends BaseRestController {
    @Autowired
    private SLPD0606IService slpd0606IService;

    @ApiOperation(value = "修改饲养标准指标",
            notes = "beans传入参数,target为指定修改字段.根据beans和target修改饲养标准指标")
    @Validator(validatorClass = SLPD0606IValidator.class)
    @RequestMapping(value = "/products/feed/standards/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLPD0606IResult modifyFedStandards(@RequestBody SLPD0606IParam param) {
        SLPD0606IResult slpd0606IResult = slpd0606IService.updateFedStandards(param);
        slpd0606IResult.setMessage(MessageUtils.getSuccessMessage());
        return slpd0606IResult;
    }

}
