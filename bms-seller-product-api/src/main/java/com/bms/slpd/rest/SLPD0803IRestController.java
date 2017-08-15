package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0803IParam;
import com.bms.slpd.bean.result.SLPD0803IResult;
import com.bms.slpd.services.SLPD0803IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0803IValidator;
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
@Api(description = "修改(卖家)单品品牌(规格)生产商",
        tags = "SLPD0803IRestController")
public class SLPD0803IRestController extends BaseRestController {

    @Autowired
    private SLPD0803IService slpd0803IService;

    @ApiOperation(value = "修改(卖家)单品品牌(规格)生产商",
            notes = "修改(卖家)单品品牌(规格)生产商")
    @RequestMapping(value = "/products/producers/sellers/_modify",
            method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0803IValidator.class)
    public SLPD0803IResult modifySellerCommoditys(@RequestBody SLPD0803IParam slpd0803IParam) {
        SLPD0803IResult slpd0803IResult = slpd0803IService.modifySellerCommoditys(slpd0803IParam);
        slpd0803IResult.setMessage(MessageUtils.getSuccessMessage());
        return slpd0803IResult;
    }

}
