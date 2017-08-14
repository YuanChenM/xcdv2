package com.framework.authority.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.framework.authority.bean.entity.TreeDoc;
import com.framework.authority.bean.param.TreeParam;
import com.framework.authority.service.TreeService;
import com.framework.authority.validator.DelTreeValidator;
import com.framework.authority.validator.SaveTreeValidator;
import com.framework.authority.validator.SearchTreeValidator;
import com.framework.authority.validator.UpdateTreeValidator;
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
@Api(value = "treePage-api",
    description = "权限树基本属性CRUD操作",
    tags = "TreePageRestController")
public class TreePageRestController extends BaseRestController {

    @Autowired
    TreeService treeService;

    private String apiName = "权限树信息";

    @ApiOperation(value = "树基本属性查询",
        notes = "树基本属性查询")
    @RequestMapping(value = "/authority/tree/_search",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = SearchTreeValidator.class)
    public BaseRestPaginationResult<TreeDoc> getTree(@RequestBody TreeParam request) {
        return treeService.findList(request);
    }

    @ApiOperation(value = "树基本属性新增",
        notes = "树基本属性新增")
    @RequestMapping(value = "/authority/tree/_save",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = SaveTreeValidator.class)
    public String getAddTree(@RequestBody TreeDoc request) {
        boolean var = treeService.save(request);
        return MessageManager.getMessage("auth.I00001", new String[] { apiName, var ? "成功" : "失败" });
    }

    @ApiOperation(value = "树基本属性修改",
        notes = "树基本属性修改")
    @RequestMapping(value = "/authority/tree/_update",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = UpdateTreeValidator.class)
    public String getModifyTree(@RequestBody TreeDoc request) {
        int updateMessage = treeService.update(request);
        return MessageManager.getMessage("auth.I00002", new String[] { apiName, String.valueOf(updateMessage) });
    }

    @ApiOperation(value = "树基本属性删除",
        notes = "树基本属性删除")
    @RequestMapping(value = "/authority/tree/_delete",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = DelTreeValidator.class)
    public String getDelTree(@RequestBody ArrayList<String> request) {
        int delMessage = treeService.delete(request);
        return MessageManager.getMessage("auth.I00003", new String[] { apiName, String.valueOf(delMessage) });
    }

}
