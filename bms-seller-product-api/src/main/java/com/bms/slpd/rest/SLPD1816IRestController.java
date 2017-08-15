package com.bms.slpd.rest;

import com.bms.fms.notice.FmsNotice;
import com.bms.slpd.bean.param.SLPD1816IParam;
import com.bms.slpd.bean.result.SLPD1816IResult;
import com.bms.slpd.services.SLPD1816IService;
import com.bms.slpd.validator.SLPD1816IValidator;
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
@Api(description = "新增产品",
        tags = "SLPD1816IRestController")
public class SLPD1816IRestController extends BaseRestController {
    @Autowired
    private FmsNotice fmsNotice;

    @Autowired
    private SLPD1816IService slpd1816IService;

    @ApiOperation(value = "新增产品",
            notes = "新增产品")
    @RequestMapping(value = "/classes/machinings/breeds/items/properties/products/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD1816IValidator.class)
    public SLPD1816IResult addProducts(@RequestBody SLPD1816IParam slpd1816IParam) {
        SLPD1816IResult slpd1816IResult = slpd1816IService.addProducts(slpd1816IParam);
        if (slpd1816IResult.getProductIds() != null) {
            String[] messages = new String[]{"新增产品成功"};
            slpd1816IResult.setMessage(messages);
            for (String productId : slpd1816IResult.getProductIds()) {
                fmsNotice.sendProduct(productId);
            }
        }
        return slpd1816IResult;
    }

}
