package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0111IParam;
import com.bms.slim.bean.result.SLIM0111IResult;
import com.bms.slim.bean.result.field.SLIM0111AgentSupplyQualificationResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0111IService;
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
@Api(description = "批量查询卖家代理商供应资质接口", tags = "SLIM0111IRestController")
public class SLIM0111IRestController extends BaseRestController {

    @Autowired
    private SLIM0111IService slim0111IService;

    @ApiOperation(value = "批量查询卖家代理商供应资质",
            notes = "asqIds,entitySellerIds,delFlg查询对应的卖家代理商供应资质信息")
    @RequestMapping(value = "/sellers/agent/supply/qualifications/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLIM0111IResult findAgentSupplyQualification(@RequestBody SLIM0111IParam slim0111IParam) {
        BaseRestPaginationResult<SLIM0111AgentSupplyQualificationResult> results = slim0111IService.findAgentSupplyQualification(slim0111IParam);
        SLIM0111IResult slim0111IResult = BeanUtils.toBean(results, SLIM0111IResult.class);
        slim0111IResult.setMessage(new String[]{MessageConstant.SUCCESS, "查询卖家代理商供应资质成功"});
        return slim0111IResult;
    }
}
