package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0402IParam;
import com.bms.slpd.bean.result.SLPD0402IResult;
import com.bms.slpd.services.SLPD0402IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0402IValidator;
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
@Api(description = "批量修改品牌",
        tags = "SLPD0402IRestController")
public class SLPD0402IRestController extends BaseRestController {
    @Autowired
    private SLPD0402IService slpd0402IService;

    @ApiOperation(value = "批量修改品牌",
            notes = "beans传入参数,target为指定修改字段.根据beans和target修改品牌")
    @RequestMapping(value = "/brands/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0402IValidator.class)
    public SLPD0402IResult modifyBrandStandards(@RequestBody SLPD0402IParam restRequest) {
        SLPD0402IResult slpd0402IResult = slpd0402IService.updateBrands(restRequest);
        slpd0402IResult.setMessage(MessageUtils.getSuccessMessage());
        return slpd0402IResult;
    }

}
