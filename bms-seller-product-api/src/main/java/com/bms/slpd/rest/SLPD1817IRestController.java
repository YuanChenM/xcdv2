package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD1817IParam;
import com.bms.slpd.bean.result.SLPD1817IResult;
import com.bms.slpd.services.SLPD1817IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD1817IValidator;
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
@Api(description = "修改产品",
        tags = "SLPD1817IRestController")
public class SLPD1817IRestController extends BaseRestController {

    @Autowired
    private SLPD1817IService slpd1817IService;

    @ApiOperation(value = "修改产品",
            notes = "传入参数beans!修改产品")
    @RequestMapping(value = "/classes/machinings/breeds/items/properties/products/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD1817IValidator.class)
    public SLPD1817IResult modifyProducerProducts(@RequestBody SLPD1817IParam param) {
        SLPD1817IResult result = slpd1817IService.updateProducts(param);
        if(result.getCount() != null && result.getCount() > NumberConst.IntDef.INT_ZERO){
            result.setMessages(MessageUtils.getSuccessMessage());
        }
        return result;
    }

}