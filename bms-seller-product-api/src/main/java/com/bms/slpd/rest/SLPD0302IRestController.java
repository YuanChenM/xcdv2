package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0302IParam;
import com.bms.slpd.bean.result.SLPD0302IResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.services.SLPD0302IService;
import com.bms.slpd.validator.SLPD0302IValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.core.utils.CollectionUtils;
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
@Api(description = "新增单品",
        tags = "SLPD0302IRestController")
public class SLPD0302IRestController extends BaseRestController {

    @Autowired
    private SLPD0302IService slpd0302IService;

    @ApiOperation(value = "新增单品",
            notes = "传入参数:beans!新增单品")
    @RequestMapping(value = "/classes/machinings/breeds/items/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0302IValidator.class)
    public SLPD0302IResult addItems(@RequestBody SLPD0302IParam requestParam) {
        SLPD0302IResult slpd0302IResult = slpd0302IService.saveItems(requestParam.getItemParams());

        if (CollectionUtils.isNotEmpty(slpd0302IResult.getItemIds())) {
            slpd0302IResult.setMessage(new String[]{MessageConstant.SUCCESS});
        }

        return slpd0302IResult;
    }
}
