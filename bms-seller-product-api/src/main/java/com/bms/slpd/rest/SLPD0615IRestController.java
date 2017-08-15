package com.bms.slpd.rest;


import com.bms.slpd.bean.param.SLPD0615IParam;
import com.bms.slpd.bean.result.SLPD0615IResult;
import com.bms.slpd.services.SLPD0615IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0615IValidator;
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
@Api(description = "修改通用质量标准指标",
        tags = "SLPD0615IRestController")
public class SLPD0615IRestController extends BaseRestController {
    @Autowired
    private SLPD0615IService slpd0615IService;

    @ApiOperation(value = "修改通用质量标准指标",
            notes = "beans传入参数,target为指定修改字段.根据beans和target修改通用质量标准指标")
    @Validator(validatorClass = SLPD0615IValidator.class)
    @RequestMapping(value = "/products/universal/quality/standards/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLPD0615IResult modifyGnqStandards(@RequestBody SLPD0615IParam param) {
        SLPD0615IResult slpd0615IResult = slpd0615IService.updateGnqStandards(param);
        slpd0615IResult.setMessage(MessageUtils.getSuccessMessage());
        return slpd0615IResult;
    }
}