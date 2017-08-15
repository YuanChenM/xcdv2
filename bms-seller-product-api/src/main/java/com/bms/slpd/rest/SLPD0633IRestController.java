package com.bms.slpd.rest;


import com.bms.slpd.bean.param.SLPD0633IParam;
import com.bms.slpd.bean.result.SLPD0633IResult;
import com.bms.slpd.services.SLPD0633IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0633IValidator;
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
@Api(description = "修改加工技术标准指标差异",
        tags = "SLPD0633IRestController")
public class SLPD0633IRestController extends BaseRestController {
    @Autowired
    private SLPD0633IService slpd0633IService;

    @ApiOperation(value = "修改加工技术标准指标差异",
            notes = "beans传入参数,target为指定修改字段.根据beans和target修改加工技术标准指标差异")
    @Validator(validatorClass = SLPD0633IValidator.class)
    @RequestMapping(value = "/products/process/technology/standards/differences/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLPD0633IResult modifyDifMctStandards(@RequestBody SLPD0633IParam param) {
        SLPD0633IResult slpd0633IResult = slpd0633IService.updateDifMctStandards(param);
        slpd0633IResult.setMessage(MessageUtils.getSuccessMessage());
        return slpd0633IResult;
    }
}