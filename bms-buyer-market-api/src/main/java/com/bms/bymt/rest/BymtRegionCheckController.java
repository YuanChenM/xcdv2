package com.bms.bymt.rest;

import com.bms.bymt.bean.param.MarketFoodModuleBasicRsParam;
import com.bms.bymt.services.BymtRegionCheckService;
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
 * Created by guan_zhongheng on 2017/4/13.
 */
@RestController
@Api(value = "bms-bymt-api", description = "区划信息校验接口", position = 1, tags = "BymtRegionCheckController")
public class BymtRegionCheckController extends BaseRestController {


    @Autowired
    private BymtRegionCheckService bymtRegionCheckService;

    @ApiOperation(value = "批发市场物流区信息校验存在",
            notes = "批发市场物流区信息校验存在",
            position = 5)
    @RequestMapping(value = "/bymt/region/_check",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public Integer lgcsRegionCheck(@RequestBody MarketFoodModuleBasicRsParam param){
        return bymtRegionCheckService.checkRegionNum(param);
    };
}
