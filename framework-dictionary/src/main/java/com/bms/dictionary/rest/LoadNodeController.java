package com.bms.dictionary.rest;

import com.bms.dictionary.bean.param.SubNodeLoadParam;
import com.bms.dictionary.bean.result.LoadNodeResult;
import com.bms.dictionary.service.LoadNodeService;
import com.bms.dictionary.service.NodeValueService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mao_yejun on 2016/11/2.
 */
@RestController
@Api(value = "node-api",
        description = "查询节点值接口")
@RequestMapping(value = "/api")
public class LoadNodeController {

    @Autowired
    private LoadNodeService loadNodeService;
    @Autowired
    private NodeValueService nodeValueService;

    @RequestMapping(value = "/dict/catalog/sub/_load",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "加载子目录")
    public BaseRestPaginationResult<LoadNodeResult> loadSubNode(@RequestBody SubNodeLoadParam param) {
        return loadNodeService.findPageList(param);
    }

    @RequestMapping(value = "/dict/catalog/_load",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "加载目录节点属性")
    public BaseRestPaginationResult<LoadNodeResult> loadNode(@RequestBody SubNodeLoadParam param) {
        return nodeValueService.findPageList(param);
    }
}
