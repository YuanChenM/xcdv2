package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0211IParam;
import com.bms.slim.bean.result.SLIM0211IResult;
import com.bms.slim.bean.result.field.SLIM0211HalalFoodProductionOperationLicenseResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0211IService;
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
@Api(description = "批量查询生产商生产资质-清真食品生产经营许可证接口", tags = "SLIM0211IRestController")
public class SLIM0211IRestController extends BaseRestController {

    @Autowired
    private SLIM0211IService slim0211IService;

    @ApiOperation(value = "批量查询生产商生产资质-清真食品生产经营许可证",
            notes = "hfpolIds,producerIds,delFlg查询对应的生产商生产资质-清真食品生产经营许可证信息")
    @RequestMapping(value = "/producers/production/qualifications/halal/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLIM0211IResult findHalalFoodProductionOperationLicense(@RequestBody SLIM0211IParam slim0211IParam) {
        BaseRestPaginationResult<SLIM0211HalalFoodProductionOperationLicenseResult> results = slim0211IService.findHalalFoodProductionOperationLicense(slim0211IParam);
        SLIM0211IResult slim0211IResult = BeanUtils.toBean(results, SLIM0211IResult.class);
        slim0211IResult.setMessage(new String[]{MessageConstant.SUCCESS, "查询生产商生产资质-清真食品生产经营许可证成功"});
        return slim0211IResult;
    }
}
