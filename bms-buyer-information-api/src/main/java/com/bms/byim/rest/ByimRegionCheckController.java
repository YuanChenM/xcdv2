package com.bms.byim.rest;

import com.bms.byim.bean.param.BuyerAllRsParam;
import com.bms.byim.services.ByimRegionCheckService;
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
@Api(value = "bms-byim-api", description = "买家区划信息校验", position = 1, tags = "ByimRegionCheckController")
public class ByimRegionCheckController extends BaseRestController {

    @Autowired
    private ByimRegionCheckService byimRegionCheckService;


    @ApiOperation(value = "买家物流区信息校验存在",
            notes = "买家物流区信息校验存在",
            position = 5)
    @RequestMapping(value = "/byim/lgcsRegion/_check",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public Integer lgcsRegionCheck(@RequestBody BuyerAllRsParam param){
        return byimRegionCheckService.checkLgcsRegionNum(param);
    };


    @ApiOperation(value = "买家区划信息校验存在",
            notes = "买家区划信息校验存在",
            position = 5)
    @RequestMapping(value = "/byim/region/_check",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public Integer RegionCheck(@RequestBody BuyerAllRsParam param){
        return byimRegionCheckService.checkRegionNum(param);
    }
}
