package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0220IParam;
import com.bms.slim.bean.result.SLIM0220IResult;
import com.bms.slim.bean.result.field.SLIM0220IsoManagementSystemCertificationResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0220IService;
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
@Api(description = "批量查询生产商生产资质-管理体系认证证书接口", tags = "SLIM0220IRestController")
public class SLIM0220IRestController extends BaseRestController {

    @Autowired
    private SLIM0220IService slim0220IService;

    @ApiOperation(value = "批量查询生产商生产资质-管理体系认证证书",
            notes = "isoMscIds,producerIds,delFlg查询对应的生产商生产资质-管理体系认证证书信息")
    @RequestMapping(value = "/producers/production/qualifications/iso/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLIM0220IResult findIsoManagementSystemCertification(@RequestBody SLIM0220IParam slim0220IParam) {
        BaseRestPaginationResult<SLIM0220IsoManagementSystemCertificationResult> results = slim0220IService.findIsoManagementSystemCertification(slim0220IParam);
        SLIM0220IResult slim0220IResult = BeanUtils.toBean(results, SLIM0220IResult.class);
        slim0220IResult.setMessage(new String[]{MessageConstant.SUCCESS, "查询生产商生产资质-管理体系认证证书成功"});
        return slim0220IResult;
    }
}
