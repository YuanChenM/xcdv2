package com.bms.bypo.rest;

import com.bms.bypo.bean.param.BuyerPoolAndProductRsParam;
import com.bms.bypo.services.BypoBuyerPoolAndProductService;
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
 * Created by tao_zhifa on 2017/5/25.
 */
@RestController
@Api(value = "bms-bypo-api", description = "物流区分类买家池产品管理", position = 1, tags = "BuyerPoolAndStandardProductRestController")
public class BuyerPoolAndProductRestController  extends BaseRestController {

    @Autowired
    private BypoBuyerPoolAndProductService bypoBuyerPoolAndProductService;

    @ApiOperation(value = "物流区分类买家和分类买家产品池查询", notes = "物流区分类买家和分类买家标产品池查询")
    @RequestMapping(value = "/buyerPoolAndProduct/_search", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<BuyerPoolAndProductRsParam> search(@RequestBody BuyerPoolAndProductRsParam param) {
        BaseRestPaginationResult<BuyerPoolAndProductRsParam> searchResult = bypoBuyerPoolAndProductService.findPageList(param);
        return searchResult;
    }
}
