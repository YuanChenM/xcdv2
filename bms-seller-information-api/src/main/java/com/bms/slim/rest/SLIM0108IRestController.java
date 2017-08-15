package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0108IParam;
import com.bms.slim.bean.result.SLIM0108IResult;
import com.bms.slim.bean.result.field.SLIM0108SellerManagementTeamResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0108IService;
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
@Api(description = "查询卖家经营团队接口", tags = "SLIM0108IRestController")
public class SLIM0108IRestController extends BaseRestController {

    @Autowired
    private SLIM0108IService slim0108IService;

    @ApiOperation(value = "查询卖家经营团队",
            notes = "根据smtIds,entitySellerIds,positionTypes,name,educationalLevel,delFlg查询对应的卖家经营团队信息")
    @RequestMapping(value = "/sellers/management/teams/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLIM0108IResult findSellerManagementTeams(@RequestBody SLIM0108IParam slim0108IParam) {
        BaseRestPaginationResult<SLIM0108SellerManagementTeamResult> results = slim0108IService.findSellerManagementTeams(slim0108IParam);
        SLIM0108IResult slim0108IResult = BeanUtils.toBean(results, SLIM0108IResult.class);
        slim0108IResult.setMessage(new String[]{MessageConstant.SUCCESS, "查询卖家生产商成功"});
        return slim0108IResult;
    }
}
