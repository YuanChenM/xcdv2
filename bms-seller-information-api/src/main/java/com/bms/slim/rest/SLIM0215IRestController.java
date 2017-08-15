package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0215IParam;
import com.bms.slim.bean.result.SLIM0215IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0215IService;
import com.framework.boot.base.BaseRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "批量修改生产商生产资质-进沪(京、津)登记信息接口", tags = "SLIM0215IRestController")
public class SLIM0215IRestController extends BaseRestController {

    @Autowired
    private SLIM0215IService slim0215IService;

    @ApiOperation(value = "批量修改生产商生产资质-进沪(京、津)登记信息",
            notes = "传入参数:beans!批量修改生产商生产资质-进沪(京、津)登记信息")
    @RequestMapping(value = "/producers/production/qualifications/registration/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
//    @Validator(validatorClass = SLIM0215IValidator.class)
    public SLIM0215IResult modifyShBjTjRegistrations(@RequestBody SLIM0215IParam slim0215IParam) {
        SLIM0215IResult slim0215IResult = slim0215IService.updateShBjTjRegistrations(slim0215IParam);
        slim0215IResult.setMessage(new String[]{MessageConstant.SUCCESS, "修改生产商生产资质-进沪(京、津)登记信息成功"});
        return slim0215IResult;
    }

}
