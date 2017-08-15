package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0120IParam;
import com.bms.slim.bean.result.SLIM0120IResult;
import com.bms.slim.bean.result.field.SLIM0120SellerBusinessTeamResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0120IService;
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
@Api(description = "查询卖家电商经营团队接口", tags = "SLIM0120IRestController")
public class SLIM0120IRestController extends BaseRestController {

    @Autowired
    private SLIM0120IService slim0120IService;

    @ApiOperation(value = "查询卖家电商经营团队",
            notes = "根据sbtIds,entitySellerIds,positionTypes,name,educationalLevel,delFlg查询对应的卖家电商经营团队信息")
    @RequestMapping(value = "/sellers/business/teams/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLIM0120IResult findSellerBusinessTeams(@RequestBody SLIM0120IParam slim0120IParam) {
        BaseRestPaginationResult<SLIM0120SellerBusinessTeamResult> results = slim0120IService.findSellerBusinessTeams(slim0120IParam);
        SLIM0120IResult slim0120IResult = BeanUtils.toBean(results, SLIM0120IResult.class);
        slim0120IResult.setMessage(new String[]{MessageConstant.SUCCESS, "查询卖家电商经营团队成功"});
        return slim0120IResult;
    }
}
