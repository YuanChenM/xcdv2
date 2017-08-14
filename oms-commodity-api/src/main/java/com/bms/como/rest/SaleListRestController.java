package com.bms.como.rest;

import com.bms.como.bean.param.SaleListRsParam;
import com.bms.como.bean.result.SaleListRsResult;
import com.bms.como.service.ComoSaleListService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
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
 * Created by zhang_jian4 on 2017/3/24.
 */
@RestController
@Api(description = "查询销售商品数据接口",
        tags = "COMO0307IRestController")
public class SaleListRestController extends BaseRestController {

    @Autowired
    private ComoSaleListService comoSaleListService;


    @ApiOperation(value = "查询销售商品数据",
            notes = "传入销售商品数据入参查询品牌信息")
    @RequestMapping(value = "/commodity/salelist/_search",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseRestPaginationResult<SaleListRsResult> findCommodity(@RequestBody SaleListRsParam saleListRsParam) {
        BaseRestPaginationResult<SaleListRsResult> pagingResult = comoSaleListService.findCommodity(saleListRsParam);
        return pagingResult;
    }

}
