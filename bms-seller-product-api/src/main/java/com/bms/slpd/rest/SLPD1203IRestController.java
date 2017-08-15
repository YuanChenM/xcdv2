package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD1203IParam;
import com.bms.slpd.bean.result.SLPD1203IResult;
import com.bms.slpd.services.SLPD1203IService;
import com.bms.slpd.validator.SLPD1203IValidator;
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

@Api(tags = "SLPD1203IRestController", description = "物流区商品批量上下线API")
@RestController
public class SLPD1203IRestController extends BaseRestController {

    @Autowired
    private SLPD1203IService slpd1203IService;

    @ApiOperation(value = "物流区商品批量上下线",
            notes = "根据物流区商品Id批量上下线物流区商品")
    @RequestMapping(value = "/logistics/areas/products/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD1203IValidator.class)
    public SLPD1203IResult findLogisticsAreaCommodities(@RequestBody SLPD1203IParam slpd1203IParam) {
        return slpd1203IService.updateLgcsCommodities(slpd1203IParam);
    }

}
