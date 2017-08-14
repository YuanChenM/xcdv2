package com.bms.como.rest;

import com.bms.como.bean.param.ComoAddOffShelfInfoRsParam;
import com.bms.como.bean.result.ComoAddOffShelfInfoRsResult;
import com.bms.como.service.ComoAddOffShelfInfoService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhang_jian4 on 2017/4/5.
 */
@RestController
@Api(description = "商品销售上下架信息查询", tags = "ComoAddOffShelfInfoRestController")
public class ComoAddOffShelfInfoRestController extends BaseRestController {
    @Autowired
    private ComoAddOffShelfInfoService addOffShelfInfoService;


    @ApiOperation(value = "商品销售上下架信息查询接口", notes = "商品销售上下架信息查询接口", position = 1)
    @RequestMapping(value = "/commodity/shelflist/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<ComoAddOffShelfInfoRsResult> searchAddOffShelfInfo(@RequestBody ComoAddOffShelfInfoRsParam addOffShelfInfoRsParam) {
       return addOffShelfInfoService.searchAddOffShelfInfo(addOffShelfInfoRsParam);
    }

}
