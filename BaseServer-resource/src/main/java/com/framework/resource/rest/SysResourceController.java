package com.framework.resource.rest;

import java.util.ArrayList;

import com.framework.base.bean.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.i18n.util.MessageManager;
import com.framework.resource.bean.entity.SysResourceDoc;
import com.framework.resource.bean.param.SysResourceParam;
import com.framework.resource.service.SysResourceService;
import com.framework.resource.validator.ValidatorDeleteSysResource;
import com.framework.resource.validator.ValidatorInsertSysResource;
import com.framework.resource.validator.ValidatorUpdateSysResource;
import com.framework.validator.annotation.Validator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Created by dai_youcheng on 2016-11-25.
 */
@RestController
@Api(value = "sys-api",
    description = "系统模块接口操作",
    tags = "SysResourceController")
public class SysResourceController extends BaseRestController {
    /* 系统模块 */
    @Autowired
    SysResourceService sysResourceService;

    private String apiName = "系统资源";

    @ApiOperation(value = "系统模块信息插入",
        notes = "系统模块信息插入")
    @RequestMapping(value = "/resource/system/_insert",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = ValidatorInsertSysResource.class)
    public String insert(@RequestBody SysResourceDoc restRequest) {
        boolean value = sysResourceService.insert(restRequest);
        return MessageManager.getMessage("res.I00001", new String[] { apiName, value ? "成功" : "失败" });
    }

    @ApiOperation(value = "系统模块信息查询",
        notes = "系统模块信息查询")
    @RequestMapping(value = "/resource/system/_search",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public BaseRestPaginationResult<SysResourceDoc> findList(@RequestBody SysResourceParam restRequest) {
        Sort sort =new Sort();
        sort.setSortField("sysSort");
        restRequest.setSort(new Sort[]{sort});
        return sysResourceService.findList(restRequest);
    }

    @ApiOperation(value = "系统模块信息删除",
        notes = "系统模块信息删除")
    @RequestMapping(value = "/resource/system/_delete",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = ValidatorDeleteSysResource.class)
    public String delete(@RequestBody ArrayList<String> restRequest) {
        int count = sysResourceService.delete(restRequest);
        return MessageManager.getMessage("res.I00003", new String[] { apiName, String.valueOf(count) });
    }

    @ApiOperation(value = "系统模块信息更新",
        notes = "系统模块信息更新")
    @RequestMapping(value = "/resource/system/_update",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = ValidatorUpdateSysResource.class)
    public String update(@RequestBody SysResourceParam restRequest) {
        int count = sysResourceService.update(restRequest);
        return MessageManager.getMessage("res.I00002", new String[] { apiName, String.valueOf(count) });
    }
}
