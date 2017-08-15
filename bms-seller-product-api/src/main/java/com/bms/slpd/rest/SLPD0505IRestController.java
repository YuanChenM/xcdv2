package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0505IParam;
import com.bms.slpd.bean.result.SLPD0505IResult;
import com.bms.slpd.services.SLPD0505IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0505IValidator;
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

@RestController
@Api(description = "修改单品规格",
        tags = "SLPD0505IRestController")
public class SLPD0505IRestController extends BaseRestController {

    @Autowired
    private SLPD0505IService slpd0505IService;

    @ApiOperation(value = "修改单品规格",
            notes = "beans传入参数,target为指定修改字段")
    @Validator(validatorClass = SLPD0505IValidator.class)
    @RequestMapping(value = "/products/classes/machinings/breeds/brands/items/properties/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLPD0505IResult modifyItemProperties(@RequestBody SLPD0505IParam slpd0505IParam) {
        SLPD0505IResult slpd0505IResult = slpd0505IService.updateItemProperties(slpd0505IParam);
        if (CollectionUtils.isNotEmpty(slpd0505IResult.getItemPropertyIds())) {
            String[] messages = new String[]{"修改单品规格成功"};
            slpd0505IResult.setMessage(messages);
        }
        return slpd0505IResult;
    }

}
