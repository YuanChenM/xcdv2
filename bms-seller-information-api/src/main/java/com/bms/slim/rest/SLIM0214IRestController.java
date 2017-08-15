package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0214IParam;
import com.bms.slim.bean.result.SLIM0214IResult;
import com.bms.slim.bean.result.field.SLIM0214ShBjTjRegistrationResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0214IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.utils.BeanUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "批量查询生产商生产资质-进沪(京、津)登记信息接口", tags = "SLIM0214IRestController")
public class SLIM0214IRestController extends BaseRestController {

    @Autowired
    private SLIM0214IService slim0214IService;

    @ApiOperation(value = "批量查询生产商生产资质-进沪(京、津)登记信息",
            notes = "sbtRegIds,producerIds,delFlg查询对应的生产商生产资质-进沪(京、津)登记信息信息")
    @RequestMapping(value = "/producers/production/qualifications/registration/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLIM0214IResult findShBjTjRegistration(@RequestBody SLIM0214IParam slim0214IParam) {
        BaseRestPaginationResult<SLIM0214ShBjTjRegistrationResult> results = slim0214IService.findShBjTjRegistration(slim0214IParam);
        SLIM0214IResult slim0214IResult = BeanUtils.toBean(results, SLIM0214IResult.class);
        slim0214IResult.setMessage(new String[]{MessageConstant.SUCCESS, "查询生产商生产资质-进沪(京、津)登记信息成功"});
        return slim0214IResult;
    }
}
