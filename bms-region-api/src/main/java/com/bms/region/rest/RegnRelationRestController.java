package com.bms.region.rest;

import com.bms.region.bean.param.RegnRelationParam;
import com.bms.region.bean.result.RegnRelationResult;
import com.bms.region.services.RegnProvinceToStreetService;
import com.framework.base.rest.result.BaseRestPaginationResult;
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

/**
 * Created by guan_zhongheng on 2017/2/15.
 */
@RestController
@Api(value = "bms-region-api",
        description = "行政区划关联关系",
        position = 1,
        tags = "RegnRelationRestController")
public class RegnRelationRestController extends BaseRestController {

    @Autowired
    private RegnProvinceToStreetService regnProvinceToStreetService;

    @ApiOperation(value = "searchProvinceStreetRelation",
            notes = "省到街道信息查询",
            position = 5)
    @RequestMapping(value = "/region/province/street/_search",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<RegnRelationResult> searchProvinceStreetRelation(
            @RequestBody RegnRelationParam param) {
        if (StringUtils.isNotEmpty(param.getProvinceName())) {
            param.setProvinceName(DbUtils.buildLikeCondition(param.getProvinceName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getCityName())) {
            param.setCityName(DbUtils.buildLikeCondition(param.getCityName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getDistrictName())) {
            param.setDistrictName(DbUtils.buildLikeCondition(param.getDistrictName(), DbUtils.LikeMode.PARTIAL));
        }
        BaseRestPaginationResult<RegnRelationResult> resultRestResponse = regnProvinceToStreetService.findPageList(param);
        return resultRestResponse;
    }


}
