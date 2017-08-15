package com.bms.slpd.rest;

import com.bms.fms.notice.FmsNotice;
import com.bms.slpd.bean.param.SLPD0507IParam;
import com.bms.slpd.bean.result.SLPD0507IResult;
import com.bms.slpd.services.SLPD0507IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0507IValidator;
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

import java.util.List;

@Api(tags = "SLPD0507IRestController", description = "批量审核产品API")
@RestController
public class SLPD0507IRestController extends BaseRestController {
//    @Autowired
//    private FmsNotice fmsNotice;

    @Autowired
    private SLPD0507IService slpd0507iService;

    @ApiOperation(value = "批量审核产品URL",
            notes = "批量审核产品、品牌单品规格、品牌单品、品牌、单品、品种、二级分类、一级分类")
    @RequestMapping(value = "/classes/machinings/breeds/brands/items/properties/products/_audit",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0507IValidator.class)
    public SLPD0507IResult auditProducts(@RequestBody SLPD0507IParam slpd0507iParam) {
        List<String> productIds = this.slpd0507iService.auditProducts(slpd0507iParam);
//        if (CollectionUtils.isNotEmpty(productIds)) {
//            for (String productId : productIds)
//                fmsNotice.sendProduct(productId);
//        }
        SLPD0507IResult slpd0507IResult = new SLPD0507IResult();
        slpd0507IResult.setCount(productIds.size());
        slpd0507IResult.setMessages(MessageUtils.getSuccessMessage());
        return slpd0507IResult;
    }

}
