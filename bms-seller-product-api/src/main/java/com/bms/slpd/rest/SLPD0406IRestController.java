package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0406IParam;
import com.bms.slpd.bean.result.SLPD0406IResult;
import com.bms.slpd.services.SLPD0406IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0406IValidator;
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

/**
 * Created by ding_guangjian on 2016/12/8.
 */
@RestController
@Api(description = "修改品牌所有人",
        tags = "SLPD0406IRestController")
public class SLPD0406IRestController extends BaseRestController {
    @Autowired
    private SLPD0406IService slpd0406IService;

    @ApiOperation(value = "修改品牌所有人",
            notes = "beans传入参数,target为指定修改字段.根据beans和target修改品牌所有人")
    @RequestMapping(value = "/brands/owners/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0406IValidator.class)
    public SLPD0406IResult modifyBrandOwners(@RequestBody SLPD0406IParam param) {
        SLPD0406IResult slpd0406IResult = slpd0406IService.updateSlpdBrandOwners(param);

        slpd0406IResult.setMessage(MessageUtils.getSuccessMessage());
        return slpd0406IResult;
    }

}
