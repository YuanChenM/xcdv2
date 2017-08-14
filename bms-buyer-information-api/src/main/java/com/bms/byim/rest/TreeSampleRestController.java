package com.bms.byim.rest;

import com.bms.byim.bean.param.TreeRsParam;
import com.bms.byim.bean.result.TreeRsResult;
import com.bms.byim.services.TreeSampleService;
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
 * Created by Marshall on 2016/12/27.
 */
@RestController
@Api(value = "bms-byim-api",
        description = "树形例子接口类",
        position = 1,
        tags = "TreeSampleRestController")
public class TreeSampleRestController extends BaseRestController {

    @Autowired
    private TreeSampleService treeSampleService;

    @ApiOperation(value = "查询列表结构", notes = "查询列表结构")
    @RequestMapping(value = "/buyers/treeSample/list/_search",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public TreeRsResult searchForList(@RequestBody TreeRsParam paramRequest) {
        return this.treeSampleService.findItemList(paramRequest);
    }

    @ApiOperation(value = "查询树形结构", notes = "查询树形结构")
    @RequestMapping(value = "/buyers/treeSample/tree/_search",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public TreeRsResult searchForTree(@RequestBody TreeRsParam paramRequest) {
        return this.treeSampleService.findItemTree(paramRequest);
    }


}
