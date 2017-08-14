package com.bms.dictionary.rest;

import com.bms.dictionary.service.LoadNodeService;
import com.bms.dictionary.service.NodeValueService;
import com.bms.dictionary.validator.DeleteNodeValidator;
import com.bms.dictionary.validator.DeleteSubNodeValidator;
import com.framework.validator.annotation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by mao_yejun on 2016/11/2.
 */
@RestController
@Api(value = "node-api",
        description = "删除节点值接口")
@RequestMapping(value = "/api")
public class DeleteNodeController {
    @Autowired
    private LoadNodeService loadNodeService;
    @Autowired
    private NodeValueService nodeValueService;

    @RequestMapping(value = "/dict/catalog/_delete",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "删除目录")
    @Validator(validatorClass = DeleteNodeValidator.class)
    public int deleteLeafNode(@RequestBody ArrayList<String> param) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("dictIds",param);
        map.put("updId",loadNodeService.getLoginUserId());
        map.put("updTime",new Date());
        return loadNodeService.deleteLeafNode(map);
    }

    @RequestMapping(value = "/dict/data/_delete",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "删除目录数据")
    @Validator(validatorClass = DeleteSubNodeValidator.class)
    public int deleteNode(@RequestBody  ArrayList<String> param) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("dataIds",param);
        map.put("updId",nodeValueService.getLoginUserId());
        map.put("updTime",new Date());
        return nodeValueService.remove(map);
    }


}
