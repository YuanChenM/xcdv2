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
import com.framework.resource.bean.entity.PageResourceDoc;
import com.framework.resource.bean.param.PageResourceDocParam;
import com.framework.resource.service.PageResourceService;
import com.framework.resource.validator.ValidatorPageResourceDelete;
import com.framework.resource.validator.ValidatorPageResourceSave;
import com.framework.resource.validator.ValidatorPageResourceSearch;
import com.framework.resource.validator.ValidatorPageResourceUpdate;
import com.framework.validator.annotation.Validator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Created by zhu_kai1 on 2016/11/25.
 */
@RestController
@Api(value = "page-api",
    description = "画面资源接口操作",
    tags = "PageResourceRestController")
public class PageResourceRestController extends BaseRestController {

    @Autowired
    private PageResourceService pageResourceService;

    private String apiName = "画面资源";

    /**
     * 查询画面资源
     * 
     * @param request
     * @return
     */
    @ApiOperation(value = "画面资源查询",
        notes = "查询画面资源的相关信息")
    @RequestMapping(value = "/resource/page/_search",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = ValidatorPageResourceSearch.class)
    public BaseRestPaginationResult<PageResourceDoc> search(@RequestBody PageResourceDocParam request) {
        return pageResourceService.findList(request);
    }

    /**
     * 新增资源
     * 
     * @param request
     * @return
     */
    @ApiOperation(value = "画面资源新增",
        notes = "新增画面资源的相关信息")
    @RequestMapping(value = "/resource/page/_insert",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = ValidatorPageResourceSave.class)
    public String insert(@RequestBody PageResourceDoc request) {
        pageResourceService.insert(request);
        return MessageManager.getMessage("res.I00001", new String[] { apiName });
    }

    /**
     * 更新资源
     * 
     * @param request
     * @return
     */
    @ApiOperation(value = "画面资源更新",
        notes = "更新画面资源的相关信息")
    @RequestMapping(value = "/resource/page/_update",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = ValidatorPageResourceUpdate.class)
    public String update(@RequestBody PageResourceDoc request) {
        int i = pageResourceService.update(request);
        return MessageManager.getMessage("res.I00002", new String[] { apiName, String.valueOf(i) });
    }

    /**
     * 删除画面资源
     * 
     * @param request
     * @return
     */
    @ApiOperation(value = "画面资源删除",
        notes = "删除画面资源的相关信息")
    @RequestMapping(value = "/resource/page/_delete",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = ValidatorPageResourceDelete.class)
    public String delete(@RequestBody ArrayList<String> request) {
        int i = pageResourceService.delete(request);
        return MessageManager.getMessage("res.I00003", new String[] { apiName, String.valueOf(i) });
    }
}
