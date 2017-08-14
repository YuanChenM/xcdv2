package com.framework.resource.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.i18n.util.MessageManager;
import com.framework.resource.bean.entity.ActionResourceDoc;
import com.framework.resource.bean.param.ActionResourceParam;
import com.framework.resource.service.ActionResourceService;
import com.framework.resource.validator.ValidatorActionResourceDelete;
import com.framework.resource.validator.ValidatorActionResourceSave;
import com.framework.resource.validator.ValidatorActionResourceSearch;
import com.framework.resource.validator.ValidatorActionResourceUpdate;
import com.framework.validator.annotation.Validator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Created by zhang_jian3 on 2016/11/25.
 */
@RestController
@Api(value = "action-api",
    description = "按钮资源相关接口操作",
    tags = "ActionResourcreRestController")
public class ActionResourcreRestController extends BaseRestController {
    @Autowired
    private ActionResourceService actionResourceService;

    private String apiName = "按钮资源";

    /**
     * 查询资源
     * 
     * @param request
     * @return
     */
    @ApiOperation(value = "按钮资源查询",
        notes = "查询按钮资源的相关信息")
    @RequestMapping(value = "/resource/action/_search",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = ValidatorActionResourceSearch.class)
    public BaseRestPaginationResult<ActionResourceDoc> search(@RequestBody ActionResourceParam request) {
        return actionResourceService.findList(request);
    }

    /**
     * 新增资源
     * 
     * @param request
     * @return
     */
    @ApiOperation(value = "按钮资源新增",
        notes = "新增按钮资源的相关信息")
    @RequestMapping(value = "/resource/action/_insert",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = ValidatorActionResourceSave.class)
    public String insert(@RequestBody ActionResourceDoc request) {
        actionResourceService.save(request);
        return MessageManager.getMessage("res.I00001", new String[] { apiName });
    }

    /**
     * 更新资源
     * 
     * @param request
     * @return
     */
    @ApiOperation(value = "按钮资源更新",
        notes = "更新按钮资源的相关信息")
    @RequestMapping(value = "/resource/action/_update",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = ValidatorActionResourceUpdate.class)
    public String update(@RequestBody ActionResourceDoc request) {
        int i = actionResourceService.update(request);
        return MessageManager.getMessage("res.I00002", new String[] { apiName, String.valueOf(i) });
    }

    /**
     * 删除资源
     * 
     * @param request
     * @return
     */
    @ApiOperation(value = "按钮资源删除",
        notes = "删除按钮资源的相关信息")
    @RequestMapping(value = "/resource/action/_delete",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = ValidatorActionResourceDelete.class)
    public String delete(@RequestBody ArrayList<String> request) {
        int i = actionResourceService.delete(request);
        return MessageManager.getMessage("res.I00003", new String[] { apiName, String.valueOf(i) });
    }

}
