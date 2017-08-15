package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0217IParam;
import com.bms.slim.bean.result.SLIM0217IResult;
import com.bms.slim.bean.result.field.SLIM0217FoodProductionLicenseResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0217IService;
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
@Api(description = "批量查询生产商生产资质-食品生产许可证接口", tags = "SLIM0217IRestController")
public class SLIM0217IRestController extends BaseRestController {

    @Autowired
    private SLIM0217IService slim0217IService;

    @ApiOperation(value = "批量查询生产商生产资质-食品生产许可证",
            notes = "fplIds,producerIds,delFlg查询对应的生产商生产资质-食品生产许可证信息")
    @RequestMapping(value = "/producers/production/qualifications/food/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLIM0217IResult findFoodProductionLicense(@RequestBody SLIM0217IParam slim0217IParam) {
        BaseRestPaginationResult<SLIM0217FoodProductionLicenseResult> results = slim0217IService.findFoodProductionLicense(slim0217IParam);
        SLIM0217IResult slim0217IResult = BeanUtils.toBean(results, SLIM0217IResult.class);
        slim0217IResult.setMessage(new String[]{MessageConstant.SUCCESS, "查询生产商生产资质-食品生产许可证成功"});
        return slim0217IResult;
    }
}
