package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0703IParam;
import com.bms.slpd.bean.result.SLPD0703IResult;
import com.bms.slpd.services.SLPD0703IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0703IValidator;
import com.framework.base.consts.NumberConst;
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
@Api(description = "修改单品品牌(规格)生产商",
        tags = "SLPD0703IRestController")
public class SLPD0703IRestController extends BaseRestController {

    @Autowired
    private SLPD0703IService slpd0703IService;

    @ApiOperation(value = "修改单品品牌(规格)生产商",
            notes = "传入参数beans!修改单品品牌(规格)生产商")
    @RequestMapping(value = "/products/producers/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0703IValidator.class)
    public SLPD0703IResult modifyProducerProducts(@RequestBody SLPD0703IParam param) {
        SLPD0703IResult result = slpd0703IService.updateProducerProducts(param);
        if(result.getCount() != null && result.getCount() > NumberConst.IntDef.INT_ZERO){
            result.setMessages(MessageUtils.getSuccessMessage());
        }
        return result;
    }

}