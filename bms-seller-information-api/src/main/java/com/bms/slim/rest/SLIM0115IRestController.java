package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0115IParam;
import com.bms.slim.bean.result.SLIM0115IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0115IService;
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
@Api(description = "批量修改卖家制造商供应资质接口", tags = "SLIM0115IRestController")
public class SLIM0115IRestController extends BaseRestController {

    @Autowired
    private SLIM0115IService slim0115IService;

    @ApiOperation(value = "批量修改卖家制造商供应资质",
            notes = "传入参数:beans!批量修改卖家制造商供应资质")
    @RequestMapping(value = "/sellers/manufacturer/supply/qualifications/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLIM0115IResult modifyManufacturerSupplyQualification(@RequestBody SLIM0115IParam slim0115IParam) {
        SLIM0115IResult slim0115IResult = slim0115IService.updateManufacturerSupplyQualification(slim0115IParam);
        slim0115IResult.setMessage(new String[]{MessageConstant.SUCCESS, "修改卖家制造商供应资质成功"});
        return slim0115IResult;
    }

}
