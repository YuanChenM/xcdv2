package com.bms.region.rest;

import com.bms.region.bean.param.BaseBean;
import com.bms.region.bean.param.RegnLogDemesnePageParam;
import com.bms.region.bean.param.RegnLogDemesneParam;
import com.bms.region.bean.result.LogisticsDemesneRsResult;
import com.bms.region.services.RegnLogisticsDemesneService;
import com.bms.region.validator.LogisticsDemesneAddValidator;
import com.bms.region.validator.LogisticsDemesneUpdateValidator;
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
 * Created by guan_zhongheng on 2017/2/20.
 */
@RestController
@Api(value = "bms-region-api",
        description = "领地信息操作",
        position = 1,
        tags = "LogisticsDemesneController")
public class LogisticsDemesneController extends BaseRestController{

    @Autowired
    private RegnLogisticsDemesneService regnLogisticsDemesneService;

    @ApiOperation(value = "searchRegionLogisticsCity",
            notes = "物流区划领地信息查询操作",
            position = 5)
    @RequestMapping(value = "/region/demesne/_search",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public BaseRestPaginationResult<LogisticsDemesneRsResult> search(@RequestBody RegnLogDemesnePageParam requestParam) {

        if (StringUtils.isNotEmpty(requestParam.getLgcsAreaName())) {
            requestParam.setLgcsAreaName(DbUtils.buildLikeCondition(requestParam.getLgcsAreaName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(requestParam.getZoneName())) {
            requestParam.setZoneName(DbUtils.buildLikeCondition(requestParam.getZoneName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(requestParam.getDistributionName())) {
            requestParam.setDistributionName(DbUtils.buildLikeCondition(requestParam.getDistributionName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(requestParam.getAuthorizedAgent())) {
            requestParam.setAuthorizedAgent(DbUtils.buildLikeCondition(requestParam.getAuthorizedAgent(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(requestParam.getDemesneName())) {
            requestParam.setDemesneName(DbUtils.buildLikeCondition(requestParam.getDemesneName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(requestParam.getAuthorizedPartner())) {
            requestParam.setAuthorizedPartner(DbUtils.buildLikeCondition(requestParam.getAuthorizedPartner(), DbUtils.LikeMode.PARTIAL));
        }
        BaseRestPaginationResult<LogisticsDemesneRsResult> list = regnLogisticsDemesneService.findPageList(requestParam);
        return list;
    }

    @ApiOperation(value = "addRegionLogisticsCity",
            notes = "物流领地信息新增",
            position = 5)
    @RequestMapping(value = "/region/demesne/_add",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = LogisticsDemesneAddValidator.class)
    public Integer add(@RequestBody RegnLogDemesneParam requestParam) {
        int res = regnLogisticsDemesneService.add(requestParam);
        return res;
    }

    @ApiOperation(value = "updteRegionLogisticsCity",
            notes = "物流领地信息修改",
            position = 5)
    @RequestMapping(value = "/region/demesne/_update",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = LogisticsDemesneUpdateValidator.class)
    public void update(
            @RequestBody BaseBean<RegnLogDemesneParam, RegnLogDemesneParam> requestParam) {
        regnLogisticsDemesneService.update(requestParam);
    }
}
