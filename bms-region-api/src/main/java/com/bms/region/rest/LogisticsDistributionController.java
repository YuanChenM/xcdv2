package com.bms.region.rest;

import com.bms.region.bean.param.BaseBean;
import com.bms.region.bean.param.RegnLogDistributionPageParm;
import com.bms.region.bean.param.RegnLogDistributionParam;
import com.bms.region.bean.result.LogisticsDistributionRsResult;
import com.bms.region.services.RegnLogisticsDistributionService;
import com.bms.region.validator.LogisticsDistributionAddValidator;
import com.bms.region.validator.LogisticsDistributionUpdateValidator;
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
    description = "配送站信息操作",
    position = 1,
    tags = "LogisticsDistributionController")
public class LogisticsDistributionController extends BaseRestController {

    @Autowired
    private RegnLogisticsDistributionService regnLogisticsDistributionService;

    @ApiOperation(value = "物流区划配送站信息查询操作",
        notes = "物流区划配送站信息查询操作",
        position = 5)
    @RequestMapping(value = "/region/distribution/_search",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public BaseRestPaginationResult<LogisticsDistributionRsResult> search(
        @RequestBody RegnLogDistributionPageParm requestParam) {
            if (StringUtils.isNotEmpty(requestParam.getLgcsAreaName())) {
                requestParam.setLgcsAreaName(DbUtils.buildLikeCondition(requestParam.getLgcsAreaName(), DbUtils.LikeMode.PARTIAL));
            }
            if (StringUtils.isNotEmpty(requestParam.getZoneName())) {
                requestParam.setZoneName(DbUtils.buildLikeCondition(requestParam.getZoneName(), DbUtils.LikeMode.PARTIAL));
            }
            if (StringUtils.isNotEmpty(requestParam.getAuthorizedPartner())) {
                requestParam.setAuthorizedPartner(DbUtils.buildLikeCondition(requestParam.getAuthorizedPartner(), DbUtils.LikeMode.PARTIAL));
            }
            BaseRestPaginationResult<LogisticsDistributionRsResult> list = regnLogisticsDistributionService
                .findPageList(requestParam);
        return list;
    }

    @ApiOperation(value = "物流配送站信息新增",
        notes = "物流配送站信息新增",
        position = 5)
    @RequestMapping(value = "/region/distribution/_add",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
     @Validator(validatorClass = LogisticsDistributionAddValidator.class)
    public Integer add(@RequestBody RegnLogDistributionParam requestParam) {
        int res = regnLogisticsDistributionService.add(requestParam);
        return res;
    }

    @ApiOperation(value = "物流配送站信息修改",
        notes = "物流配送站信息修改",
        position = 5)
    @RequestMapping(value = "/region/distribution/_update",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
     @Validator(validatorClass = LogisticsDistributionUpdateValidator.class)
    public void update(@RequestBody BaseBean<RegnLogDistributionParam, RegnLogDistributionParam> requestParam) {
        regnLogisticsDistributionService.update(requestParam);
    }
}
