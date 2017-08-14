package com.bms.region.rest;

import com.bms.region.bean.param.BaseBean;
import com.bms.region.bean.param.CityLogRsParam;
import com.bms.region.bean.param.RegnLogisticsRelationParam;
import com.bms.region.services.RegnDistrictService;
import com.bms.region.services.RegnRelationService;
import com.framework.boot.base.BaseRestController;
import com.framework.core.db.DbUtils;
import com.framework.core.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by guan_zhongheng on 2017/2/20.
 */
@RestController
@Api(value = "bms-region-api",
        description = "物流区划行政区划关联信息操作",
        position = 1,
        tags = "RegnRelationController")
public class RegnRelationController extends BaseRestController {

    @Autowired
    private RegnRelationService regnRelationService;

    @Autowired
    private RegnDistrictService regnDistrictService;

    /**
     * 区域信息查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "物流区域与区划区域关联信息查询 涉及物流区、地区、城市、区县",
            notes = "物流区域与区划区域关联信息查询 涉及物流区、地区、城市、区县")
    @RequestMapping(value = "/region/zone/district/_search",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<CityLogRsParam> search(@RequestBody CityLogRsParam param) {
        if (StringUtils.isNotEmpty(param.getLgcsAreaName())) {
            param.setLgcsAreaName(DbUtils.buildLikeCondition(param.getLgcsAreaName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getZoneName())) {
            param.setZoneName(DbUtils.buildLikeCondition(param.getZoneName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getDistrictName())) {
            param.setDistrictName(DbUtils.buildLikeCondition(param.getDistrictName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getCityName())) {
            param.setCityName(DbUtils.buildLikeCondition(param.getCityName(), DbUtils.LikeMode.PARTIAL));
        }
        List<CityLogRsParam> restResults = regnDistrictService.findLogDistrictList(param);
        return restResults;
    }

    @ApiOperation(value = "物流区域与区划区域对应查询",
            notes = "物流区域与区划区域对应查询")
    @RequestMapping(value = "/region/relation/_search",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })

    public List<CityLogRsParam> searchForRelation(@RequestBody CityLogRsParam param) {
        if (StringUtils.isNotEmpty(param.getLgcsAreaName())) {
            param.setLgcsAreaName(DbUtils.buildLikeCondition(param.getLgcsAreaName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getZoneName())) {
            param.setZoneName(DbUtils.buildLikeCondition(param.getZoneName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getDistrictName())) {
            param.setDistrictName(DbUtils.buildLikeCondition(param.getDistrictName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getCityName())) {
            param.setCityName(DbUtils.buildLikeCondition(param.getCityName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getProvinceName())) {
            param.setProvinceName(DbUtils.buildLikeCondition(param.getProvinceName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getDistributionName())) {
            param.setDistributionName(DbUtils.buildLikeCondition(param.getDistributionName(), DbUtils.LikeMode.PARTIAL));
        }
        List<CityLogRsParam> restResults = regnRelationService.findList(param);
        return restResults;
    }



    @ApiOperation(value = "物流区划行政区划关联信息新增",
            notes = "物流区划行政区划关联信息新增",
            position = 5)
    @RequestMapping(value = "/region/Logistics/relation/_add",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    // @Validator(validatorClass = Object.class)
    public Integer add(@RequestBody RegnLogisticsRelationParam requestParam) {
        int res = regnRelationService.add(requestParam);
        return res;
    }

    @ApiOperation(value = "物流区划行政区划关联信息修改",
            notes = "物流区划行政区划关联信息修改",
            position = 5)
    @RequestMapping(value = "/region/Logistics/relation/_update",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public void update(@RequestBody BaseBean<RegnLogisticsRelationParam, RegnLogisticsRelationParam> requestParam) {
        regnRelationService.update(requestParam);
    }

    @ApiOperation(value = "获取区划不同阶级最大CODE编码",
            notes = "1.codeType：1、省 2、城市 3、区县 4、街道 11、物流区 12、地区 13、配送站 14、领地 " +
                    "2.codeType为3,4 分别传cityId,districtId" +
                    "3.codeType为13,14 分别传zoneId,distributionId",
            position = 5)
    @RequestMapping(value = "/region/maxCode/_find",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public Map<String,Object> getMaxCode(@RequestBody Map<String,Object> mapParam) {
        if(mapParam.get("codeType") != null){
            return regnRelationService.checkMaxCode(mapParam);
        }
        return null;
    }

}
