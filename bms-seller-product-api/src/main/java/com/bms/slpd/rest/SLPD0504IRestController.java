package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0504IParam;
import com.bms.slpd.bean.result.SLPD0504IResult;
import com.bms.slpd.services.SLPD0504IService;
import com.bms.slpd.validator.SLPD0504IValidator;
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
@Api(description = "新增单品规格",
        tags = "SLPD0504IRestController")
public class SLPD0504IRestController extends BaseRestController {
    @Autowired
    private SLPD0504IService slpd0504IService;

    @ApiOperation(value = "新增单品规格",
            notes = "bean传入List参数,新增数据")
    @RequestMapping(value = "/products/classes/machinings/breeds/brands/items/properties/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0504IValidator.class)
    public SLPD0504IResult addItemProperties(@RequestBody SLPD0504IParam slpd0504IParam) {
        SLPD0504IResult slpd0504Result = slpd0504IService.saveItemProperties(slpd0504IParam);
        if (CollectionUtils.isNotEmpty(slpd0504Result.getItemPropertyIds())) {
            String[] messages = new String[]{"新增单品规格成功"};
            slpd0504Result.setMessage(messages);
        }
        return slpd0504Result;
    }

}
