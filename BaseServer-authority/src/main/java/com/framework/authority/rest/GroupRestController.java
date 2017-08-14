package com.framework.authority.rest;

import java.util.ArrayList;
import java.util.List;

import com.framework.authority.bean.result.GroupInUserResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.framework.authority.bean.entity.GroupDoc;
import com.framework.authority.bean.param.GroupParam;
import com.framework.authority.service.GroupService;
import com.framework.authority.validator.DelGroupValidator;
import com.framework.authority.validator.SaveGroupValidator;
import com.framework.authority.validator.SearchGroupValidator;
import com.framework.authority.validator.UpdateGroupValidator;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.i18n.util.MessageManager;
import com.framework.validator.annotation.Validator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 组相关接口
 * Created by rong_ting on 2016/11/15.
 */
@RestController
@Api(value = "groupPage-api",
    description = "组信息CRUD操作",
    tags = "GroupRestController")
public class GroupRestController extends BaseRestController {

    /**
     * 组服务
     */
    @Autowired
    GroupService groupService;

    private String apiName = "组信息";

    /**
     * 查询组的相关信息
     *
     * @return
     */
    @ApiOperation(value = "组查询",
        notes = "查询组的相关信息")
    @RequestMapping(value = "/authority/group/_search",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = SearchGroupValidator.class)
    public BaseRestPaginationResult<GroupDoc> search(@RequestBody GroupParam request) throws Exception {
        return groupService.findList(request);
    }

    /**
     * 更新组的相关信息
     *
     * @return
     */
    @ApiOperation(value = "组更新",
        notes = "更新组的相关信息")
    @RequestMapping(value = "/authority/group/_update",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = UpdateGroupValidator.class)
    public String update(@RequestBody GroupDoc request) {
        request.setGroupCode("");
        int writeResult = groupService.update(request);
        return MessageManager.getMessage("auth.I00002", new String[] { apiName, String.valueOf(writeResult) });
    }

    /**
     * 保存组的相关信息
     *
     * @return
     */
    @ApiOperation(value = "组保存",
        notes = "保存组的相关信息")
    @RequestMapping(value = "/authority/group/_save",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = SaveGroupValidator.class)
    public String save(@RequestBody GroupDoc request) {
        boolean flag = groupService.save(request);
        String var = flag ? "成功" : "失败";
        return MessageManager.getMessage("auth.I00001", new String[] { apiName, var });
    }

    /**
     * 删除组的相关信息
     *
     * @return
     */
    @ApiOperation(value = "组删除",
        notes = "删除组的相关信息")
    @RequestMapping(value = "/authority/group/_delete",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = DelGroupValidator.class)
    public String delete(@RequestBody ArrayList<String> request) {
        int writeResult = groupService.delete(request);
        return MessageManager.getMessage("auth.I00003", new String[] { apiName, String.valueOf(writeResult) });
    }

    @ApiOperation(value = "查询组内成员",
            notes = "查询组内成员")
    @RequestMapping(value = "/authority/group/user/_search",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<GroupInUserResult> searchGroupInUser(@RequestBody ArrayList<String> request) {
        List<GroupInUserResult> list= groupService.searchGroupInUser(request);
        return list;
    }

}
