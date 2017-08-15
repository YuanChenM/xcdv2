package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0114IParam;
import com.bms.slim.bean.result.SLIM0114IResult;
import com.bms.slim.bean.result.field.SLIM0114ManufacturerSupplyQualificationResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0114IService;
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
@Api(description = "批量查询卖家制造商供应资质接口", tags = "SLIM0114IRestController")
public class SLIM0114IRestController extends BaseRestController {

    @Autowired
    private SLIM0114IService slim0114IService;

    @ApiOperation(value = "批量查询卖家制造商供应资质",
            notes = "msqIds,entitySellerIds,delFlg查询对应的卖家制造商供应资质信息")
    @RequestMapping(value = "/sellers/manufacturer/supply/qualifications/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLIM0114IResult findManufacturerSupplyQualification(@RequestBody SLIM0114IParam slim0114IParam) {
        BaseRestPaginationResult<SLIM0114ManufacturerSupplyQualificationResult> results = slim0114IService.findManufacturerSupplyQualification(slim0114IParam);
        SLIM0114IResult slim0114IResult = BeanUtils.toBean(results, SLIM0114IResult.class);
        slim0114IResult.setMessage(new String[]{MessageConstant.SUCCESS, "查询卖家制造商供应资质成功"});
        return slim0114IResult;
    }
}
