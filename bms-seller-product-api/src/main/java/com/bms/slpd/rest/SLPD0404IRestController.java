package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0404IParam;
import com.bms.slpd.bean.result.SLPD0404IResult;
import com.bms.slpd.services.SLPD0404IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0404IValidator;
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
@Api(description = "新增品牌所有人",
        tags = "SLPD0404IRestController")
public class SLPD0404IRestController extends BaseRestController {
    @Autowired
    private SLPD0404IService slpd0404IService;

    @ApiOperation(value = "新增品牌所有人",
            notes = "传入bean参数列表,新增数据")
    @Validator(validatorClass = SLPD0404IValidator.class)
    @RequestMapping(value = "/brands/owners/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLPD0404IResult addBrandOwners(@RequestBody SLPD0404IParam param) {
        SLPD0404IResult slpd0404Result = slpd0404IService.saveSlpdBrandOwners(param.getBeans());
        slpd0404Result.setMessage(MessageUtils.getSuccessMessage());
        return slpd0404Result;
    }

}
