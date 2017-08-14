package com.bms.dictionary.rest;

import com.bms.dictionary.bean.entity.DictLeafNode;
import com.bms.dictionary.bean.entity.DictNodeValue;
import com.bms.dictionary.bean.param.FindNodeParam;
import com.bms.dictionary.bean.param.FindSubNodeParam;
import com.bms.dictionary.bean.result.FindNodeResult;
import com.bms.dictionary.service.LoadNodeService;
import com.bms.dictionary.validator.FindNodeValidator;
import com.bms.dictionary.validator.FindSubNodeValidator;
import com.framework.validator.annotation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mao_yejun on 2016/11/2.
 */
@RestController
@Api(value = "node-api",
        description = "查询节点值接口")
@RequestMapping(value = "/api")
public class DictNodeController {
    @Autowired
    private LoadNodeService loadNodeService;
    @RequestMapping(value = "/dict/catalog/sub/_find",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "根据编码查询子目录")
    @Validator(validatorClass = FindSubNodeValidator.class)
    public HashMap<String, List<DictNodeValue>> findSubNode(@RequestBody FindSubNodeParam param, HttpServletRequest request) {
        return loadNodeService.getSubNode(param);
    }

    @RequestMapping(value = "/dict/catalog/_find",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "根据编码查询目录属性")
    @Validator(validatorClass = FindNodeValidator.class)
    public FindNodeResult findNode(@RequestBody FindNodeParam param) {
        return loadNodeService.getNode(param);
    }

    /**
     * 查询所有目录
     * @param param
     * @return
     */
    @RequestMapping(value = "/dict/allCatalog/_find",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "查询所有根目录")
    public  List<DictLeafNode> findAllNode(@RequestBody FindNodeParam param) {
        return loadNodeService.findList(param);
    }

}
