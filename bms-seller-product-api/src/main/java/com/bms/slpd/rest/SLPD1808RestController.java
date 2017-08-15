package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD1808IParam;
import com.bms.slpd.bean.result.SLPD1808IResult;
import com.bms.slpd.services.SLPD1808IService;
import com.bms.slpd.validator.SLPD1808IValidator;
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
@Api(tags = "SLPD1808RestController", description = "删除制造商单品品牌规格生产商API")
public class SLPD1808RestController extends BaseRestController {

    @Autowired
    private SLPD1808IService slpd1808IService;

    @ApiOperation(value = "删除制造商单品品牌规格生产商",
            notes = "删除制造商单品品牌规格生产商")
    @RequestMapping(value = "/classes/machinings/breeds/brands/items/properties/manufacturer/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD1808IValidator.class)
    public SLPD1808IResult findProducts(@RequestBody SLPD1808IParam slpd1808iParam) {

        return slpd1808IService.deleteManufacturerProducts(slpd1808iParam);
    }

}
