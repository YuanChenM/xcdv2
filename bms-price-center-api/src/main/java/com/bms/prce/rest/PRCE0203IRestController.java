package com.bms.prce.rest;

/**
 *
 * 价盘营销状态查询
 * @author zhou_ling
 * @Time 2017/1/11
 * @version 1.0
 *
 */

import com.bms.prce.bean.param.PRCE0203IParam;
import com.bms.prce.bean.result.PRCE0203IResult;
import com.bms.prce.service.PrceMarketingStatusService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.db.DbUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "价盘营销状态查询",
    tags = "PRCE0203IRestController", value = "PRCE0204I", position = 0)
public class PRCE0203IRestController extends BaseRestController{

    /** 价盘营销状态 */
    @Autowired
    private PrceMarketingStatusService prceMarketingStatusService;

    /**
     * 营销状态查询
     * @Param prce0203IParam
     * @return  营销状态查询结果
     *
     */
    @ApiOperation(value = "价盘营销状态查询接口", notes = "价盘营销状态查询")
    @RequestMapping(value = "/prce/marketing/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})

    public BaseRestPaginationResult<PRCE0203IResult> PrceMarketingSearch(@RequestBody PRCE0203IParam prce0203IParam){
        prce0203IParam.setMarketingStatusName(DbUtils.buildLikeCondition(prce0203IParam.getMarketingStatusName()));
        BaseRestPaginationResult<PRCE0203IResult> results = prceMarketingStatusService.findPageList(prce0203IParam);
        return results;

    }

}
