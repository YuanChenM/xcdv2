package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0502IParam;
import com.bms.slpd.bean.result.SLPD0502IResult;
import com.bms.slpd.services.SLPD0502IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0502IValidator;
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
@Api(description = "新增品牌单品", tags = "SLPD0502IRestController")
public class SLPD0502IRestController extends BaseRestController {

    @Autowired
    private SLPD0502IService slpd0502IService;

    @ApiOperation(value = "新增品牌单品",
            notes = "新增品牌单品")
    @RequestMapping(value = "/products/classes/machinings/breeds/brands/items/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0502IValidator.class)
    public SLPD0502IResult addBrandItems(@RequestBody SLPD0502IParam param) {
        SLPD0502IResult slpd0502IResult = slpd0502IService.addBrandItems(param.getItemBrandList());
        slpd0502IResult.setMessage(MessageUtils.getSuccessMessage());
        return slpd0502IResult;
    }

}
