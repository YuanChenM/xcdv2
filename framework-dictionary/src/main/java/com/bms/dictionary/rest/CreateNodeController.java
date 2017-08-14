package com.bms.dictionary.rest;

import com.bms.dictionary.bean.param.CreateDataParam;
import com.bms.dictionary.bean.param.CreateDictParam;
import com.bms.dictionary.service.LoadNodeService;
import com.bms.dictionary.service.NodeValueService;
import com.bms.dictionary.validator.CreateCatalogNodeValidator;
import com.bms.dictionary.validator.CreateDataNodeValidator;
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
 * Created by mao_yejun on 2016/11/2.
 */
@RestController
@Api(value = "node-api",
        description = "创建节点值接口")
@RequestMapping(value = "/api")
public class CreateNodeController {
    @Autowired
    private LoadNodeService loadNodeService;
    @Autowired
    private NodeValueService nodeValueService;

    @RequestMapping(value = "/dict/catalog/_create",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "新建字典目录")
    @Validator(validatorClass = CreateCatalogNodeValidator.class)
    public String createCatalogNode(@RequestBody CreateDictParam param) {
        return loadNodeService.createDictLeafNode(param);
    }

    @RequestMapping(value = "/dict/data/_create",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "目录数据新增")
    @Validator(validatorClass = CreateDataNodeValidator.class)
    public Boolean createDataNode(@RequestBody CreateDataParam param) {
        return nodeValueService.createDataNode(param);
    }
}
