package com.bms.region.rest;

import com.bms.region.bean.param.BaseBean;
import com.bms.region.bean.param.RegnLogisticsZonePageParam;
import com.bms.region.bean.param.RegnLogisticsZoneParam;
import com.bms.region.bean.result.LogisticsZoneRestResult;
import com.bms.region.services.RegnLogisticsZoneService;
import com.bms.region.validator.LogisticsZoneAddValidator;
import com.bms.region.validator.LogisticsZoneUpdateValidator;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.db.DbUtils;
import com.framework.core.utils.StringUtils;
import com.framework.validator.annotation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by guan_zhongheng on 2017/2/17.
 */
@RestController
@Api(value = "bms-region-api",
    description = "地区信息操作",
    position = 1,
    tags = "LogisticsCityRestController")
public class LogisticsZoneRestController extends BaseRestController {

    @Autowired
    private RegnLogisticsZoneService regnLogisticsZoneService;

    @ApiOperation(value = "searchRegionLogisticsZone",
        notes = "物流区划地区信息查询操作",
        position = 5)
    @RequestMapping(value = "/region/zone/_search",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public BaseRestPaginationResult<LogisticsZoneRestResult> searchRegionLogisticsZone(
        @RequestBody RegnLogisticsZonePageParam requestParam) {
        if (StringUtils.isNotEmpty(requestParam.getLgcsAreaName())) {
            requestParam.setLgcsAreaName(DbUtils.buildLikeCondition(requestParam.getLgcsAreaName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(requestParam.getZoneName())) {
            requestParam.setZoneName(DbUtils.buildLikeCondition(requestParam.getZoneName(), DbUtils.LikeMode.PARTIAL));
        }
        BaseRestPaginationResult<LogisticsZoneRestResult> list = regnLogisticsZoneService.findPageList(requestParam);
        return list;
    }

    @ApiOperation(value = "addRegionLogisticsZone",
        notes = "物流区域信息新增",
        position = 5)
    @RequestMapping(value = "/region/zone/_add",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
     @Validator(validatorClass = LogisticsZoneAddValidator.class)
    public Integer addRegionLogisticsZone(@RequestBody RegnLogisticsZoneParam logisticsCityParam) {
        Integer resp = regnLogisticsZoneService.addLogisticsCity(logisticsCityParam);
        return resp;
    }

    @ApiOperation(value = "updteRegionLogisticsZone",
        notes = "物流区域信息修改",
        position = 5)
    @RequestMapping(value = "/region/zone/_update",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
     @Validator(validatorClass = LogisticsZoneUpdateValidator.class)
    public void updteRegionLogisticsZone(
        @RequestBody BaseBean<RegnLogisticsZoneParam, RegnLogisticsZoneParam> regnLogisticsCityParam) {
        regnLogisticsZoneService.updateLogisticsCity(regnLogisticsCityParam);
    }
}
