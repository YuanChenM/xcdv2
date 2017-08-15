package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0112IParam;
import com.bms.slim.bean.result.SLIM0112IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0112IService;
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
@Api(description = "批量修改卖家代理商供应资质接口", tags = "SLIM0112IRestController")
public class SLIM0112IRestController extends BaseRestController {

    @Autowired
    private SLIM0112IService slim0112IService;

    @ApiOperation(value = "批量修改卖家代理商供应资质",
            notes = "传入参数:beans!批量修改卖家代理商供应资质")
    @RequestMapping(value = "/sellers/agent/supply/qualifications/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLIM0112IResult modifyAgentSupplyQualification(@RequestBody SLIM0112IParam slim0112IParam) {
        SLIM0112IResult slim0112IResult = slim0112IService.updateAgentSupplyQualification(slim0112IParam);
        slim0112IResult.setMessage(new String[]{MessageConstant.SUCCESS, "修改卖家代理商供应资质成功"});
        return slim0112IResult;
    }

}
