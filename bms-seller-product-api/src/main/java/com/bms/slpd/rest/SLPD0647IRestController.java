package com.bms.slpd.rest;


import com.bms.slpd.bean.param.SLPD0647IParam;
import com.bms.slpd.bean.result.SLPD0647IResult;
import com.bms.slpd.services.SLPD0647IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0647IValidator;
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
@Api(description = "修改包装标准指标差异",
        tags = "SLPD0647IRestController")
public class SLPD0647IRestController extends BaseRestController {
    @Autowired
    private SLPD0647IService slpd0647IService;

    @ApiOperation(value = "修改包装标准指标差异",
            notes = "beans传入参数,target为指定修改字段.根据beans和target修改包装标准指标差异")
    @Validator(validatorClass = SLPD0647IValidator.class)
    @RequestMapping(value = "/products/package/standards/differences/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLPD0647IResult modifyDifPkgStandards(@RequestBody SLPD0647IParam param) {
        SLPD0647IResult slpd0647IResult = slpd0647IService.updateDifPkgStandards(param);
        slpd0647IResult.setMessage(MessageUtils.getSuccessMessage());
        return slpd0647IResult;
    }
}