package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD1811IParam;
import com.bms.slpd.bean.param.SLPD1811IParam;
import com.bms.slpd.bean.result.SLPD1811IResult;
import com.bms.slpd.services.SLPD1811IService;
import com.bms.slpd.validator.SLPD1811IValidator;
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
@Api(tags = "SLPD1811RestController", description = "删除代理商单品品牌规格生产商API")
public class SLPD1811RestController extends BaseRestController {

    @Autowired
    private SLPD1811IService slpd1811IService;

    @ApiOperation(value = "删除代理商单品品牌规格生产商",
            notes = "删除代理商单品品牌规格生产商")
    @RequestMapping(value = "/classes/machinings/breeds/brands/items/properties/agent/supply/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD1811IValidator.class)
    public SLPD1811IResult findProducts(@RequestBody SLPD1811IParam slpd1811IParam) {

        return slpd1811IService.deleteAgentProducts(slpd1811IParam);
    }

}
