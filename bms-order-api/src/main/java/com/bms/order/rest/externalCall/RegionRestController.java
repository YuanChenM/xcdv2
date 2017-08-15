package com.bms.order.rest.externalCall;

import com.bms.order.archive.impl.externalCall.region.Region;
import com.bms.order.bean.externalCall.region.result.RegionRestResult;
import com.bms.order.bean.externalCall.region.result.RegionalDistributionStationRestResult;
import com.framework.base.rest.RestResponse;
import com.framework.boot.base.BaseRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * Created by zhang_qiang1 on 2017/1/9.
 */

@RestController
@Api(tags = {"RegionRestController"}, description = "查询配送站")
public class RegionRestController extends BaseRestController {

    @ApiOperation(value = "查询配送站", notes = "查询配送站")
    @RequestMapping(value = "/distributionStation/_find", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RestResponse<RegionalDistributionStationRestResult> execute() {
        RestResponse restResponse = new RestResponse();
        RegionalDistributionStationRestResult restResult = new Region().findDistributionStations();
        restResponse.setResult(restResult);
        return restResponse;
    }


    @ApiOperation(value = "查询物流区信息", notes = "查询物流区信息")
    @RequestMapping(value = "/region/_find", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RestResponse<RegionalDistributionStationRestResult> execute2() {
        RestResponse restResponse = new RestResponse();
        RegionRestResult restResult = new Region().findAllRegions();
        restResponse.setResult(restResult);
        return restResponse;
    }




}
