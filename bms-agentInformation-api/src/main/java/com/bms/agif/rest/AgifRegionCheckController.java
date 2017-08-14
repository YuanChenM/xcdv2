package com.bms.agif.rest;

import com.bms.agif.bean.param.AgentDemesneParam;
import com.bms.agif.bean.param.AgentParam;
import com.bms.agif.service.AgifRegionCheckService;
import com.framework.boot.base.BaseRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by guan_zhongheng on 2017/4/12.
 */
@RestController
@Api(value = "bms-agif-api", description = "区划信息校验接口", position = 1, tags = "AgifRegionCheckController")
public class AgifRegionCheckController extends BaseRestController {

    @Autowired
    private AgifRegionCheckService agifRegionCheckService;


    @ApiOperation(value = "买手基础信息查询操作",
            notes = "买手基础信息查询操作",
            position = 5)
    @RequestMapping(value = "/agif/lgcsRegion/_check",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public Integer lgcsRegionCheck(@RequestBody AgentDemesneParam param){
        return agifRegionCheckService.checkLgcsRegionNum(param);
    }


    @ApiOperation(value = "买手基础信息查询操作",
            notes = "买手基础信息查询操作",
            position = 5)
    @RequestMapping(value = "/agif/region/_check",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public Integer RegionCheck(@RequestBody AgentParam param){
        return agifRegionCheckService.checkRegionNum(param);
    }
}
