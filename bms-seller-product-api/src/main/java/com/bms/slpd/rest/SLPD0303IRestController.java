package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0303IParam;
import com.bms.slpd.bean.result.SLPD0303IResult;
import com.bms.slpd.services.SLPD0303IService;
import com.bms.slpd.validator.SLPD0303IValidator;
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
@Api(description = "修改单品",
        tags = "SLPD0303IRestController")
public class SLPD0303IRestController extends BaseRestController {
    @Autowired
    private SLPD0303IService slpd0303IService;

    @ApiOperation(value = "修改单品",
            notes = "beans传入参数,target为指定修改字段.根据beans和target修改单品")
    @RequestMapping(value = "/classes/machinings/breeds/items/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0303IValidator.class)
    public SLPD0303IResult modifyItems(@RequestBody SLPD0303IParam restRequest) {
        SLPD0303IResult result = slpd0303IService.updateFeature(restRequest);

        return result;
    }


}
