package com.zuul.rest;

import com.zuul.bean.PageResult;
import com.zuul.bean.param.ModuleCreateParam;
import com.zuul.bean.param.ModuleInterFaceSearchParam;
import com.zuul.bean.param.ModuleSearchParam;
import com.zuul.bean.param.ModuleUpdateParam;
import com.zuul.bean.result.ModuleSearchResult;
import com.zuul.entity.InterfaceEntity;
import com.zuul.logic.ModuleLogic;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by mao_yejun on 2017/2/27.
 */
@RestController
@Api(value = "module-api",
        description = "模块-api")
@RequestMapping(value = "/api")
public class ModuleRestController {
    @Autowired
    private ModuleLogic moduleLogic;

    @RequestMapping(value = "/module/_create",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "创建新的模块")
    public boolean createModule(@RequestBody ModuleCreateParam param) {
        moduleLogic.createModule(param);
        return true;
    }

    @RequestMapping(value = "/module/_delete",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "删除模块")
    public boolean deleteModule(@RequestBody ArrayList<Long> param) {

        return moduleLogic.deleteModule(param);
    }

    @RequestMapping(value = "/module/_search",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "删除模块")
    public PageResult<ModuleSearchResult> searchModule(@RequestBody ModuleSearchParam param) {

        return moduleLogic.searchModule(param);
    }

    @RequestMapping(value = "module/detail/_search",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ModuleSearchResult searchModuleDetail(@RequestBody Long moduleId) {
        return moduleLogic.searchModuleDetail(moduleId);
    }
    @RequestMapping(value = "module/_update",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateModuleDetail(@RequestBody ModuleUpdateParam param) {
        return moduleLogic.updateModuleDetail(param);
    }

    @RequestMapping(value = "module/interface/_search",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PageResult<InterfaceEntity> searchModuleInterface(@RequestBody ModuleInterFaceSearchParam param) {
        return moduleLogic.searchModuleInterface(param);
    }

}
