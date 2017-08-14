package com.framework.authority.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.framework.authority.bean.entity.TreeNodeDoc;
import com.framework.authority.bean.param.TreeNodeParam;
import com.framework.authority.service.TreeNodeService;
import com.framework.authority.validator.DelTreeNodeValidator;
import com.framework.authority.validator.SaveTreeNodeValidator;
import com.framework.authority.validator.UpdateTreeNodeValidator;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.i18n.util.MessageManager;
import com.framework.validator.annotation.Validator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Created by zhang_jian3 on 2016/10/26.
 */
@RestController
@Api(value = "treeNodePage-api",
    description = "权限树明细CRUD操作",
    tags = "TreeNodePageRestController")
public class TreeNodePageRestController extends BaseRestController {

    @Autowired
    TreeNodeService treeNodeService;

    private String apiName = "权限树明细";

    @ApiOperation(value = "树明细查询",
        notes = "树明细查询")
    @RequestMapping(value = "/authority/tree/node/_search",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public BaseRestPaginationResult<TreeNodeDoc> getTree(@RequestBody TreeNodeParam request) throws Exception {
        return treeNodeService.findList(request);
    }

    @ApiOperation(value = "树节点新增",
        notes = "树节点新增")
    @RequestMapping(value = "/authority/tree/node/_save",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = SaveTreeNodeValidator.class)
    public String getAddTree(@RequestBody TreeNodeDoc request) {
        boolean var = treeNodeService.save(request);
        return MessageManager.getMessage("auth.I00001", new String[] { apiName, var ? "成功" : "失败" });
    }

    @ApiOperation(value = "树节点修改",
        notes = "树节点修改")
    @RequestMapping(value = "/authority/tree/node/_update",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = UpdateTreeNodeValidator.class)
    public String getModifyTree(@RequestBody TreeNodeDoc request) {
        int writeResult = treeNodeService.update(request);
        return MessageManager.getMessage("auth.I00002", new String[] { apiName, String.valueOf(writeResult) });
    }

    @ApiOperation(value = "树节点删除",
        notes = "树节点删除")
    @RequestMapping(value = "/authority/tree/node/_delete",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = DelTreeNodeValidator.class)
    public String getDelTree(@RequestBody ArrayList<String> request) {
        int writeResult = treeNodeService.delete(request);
        return MessageManager.getMessage("auth.I00003", new String[] { apiName, String.valueOf(writeResult) });
    }

}
