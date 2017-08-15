package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0801IParam;
import com.bms.slpd.bean.result.SLPD0801IResult;
import com.bms.slpd.services.SLPD0801IService;
import com.bms.slpd.validator.SLPD0801IValidator;
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
@Api(description = "新增(卖家)单品品牌(规格)生产商",
        tags = "SLPD0801IRestController")
public class SLPD0801IRestController extends BaseRestController {

    @Autowired
    private SLPD0801IService slpd0801IService;

    @ApiOperation(value = "新增(卖家)单品品牌(规格)生产商",
            notes = "新增(卖家)单品品牌(规格)生产商")
    @RequestMapping(value = "/products/producers/sellers/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0801IValidator.class)
    public SLPD0801IResult addSellerCommodities(@RequestBody SLPD0801IParam slpd0801IParam) {
        SLPD0801IResult slpd0801IResult = slpd0801IService.addSellerCommodities(slpd0801IParam);
        if (slpd0801IResult.getSellerCommodityIds() != null) {
            String[] messages = new String[]{"新增(卖家)单品品牌(规格)生产商成功"};
            slpd0801IResult.setMessage(messages);
        }
        return slpd0801IResult;
    }

}
