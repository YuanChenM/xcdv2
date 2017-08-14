package com.framework.authority.rest;

/**
 * Created by dai_youcheng on 2016-11-15.
 */

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.framework.authority.bean.entity.TreeNodeDoc;
import com.framework.authority.bean.entity.UserDoc;
import com.framework.authority.bean.param.UserParam;
import com.framework.authority.service.UserService;
import com.framework.authority.validator.DelUserValidator;
import com.framework.authority.validator.SaveUserValidator;
import com.framework.authority.validator.SearchUserValidator;
import com.framework.authority.validator.UpdateUserValidator;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.i18n.util.MessageManager;
import com.framework.validator.annotation.Validator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "user-api",
    description = "用户操作",
    tags = "UserRestController")
public class UserPageRestController extends BaseRestController {
    @Autowired
    UserService userService;

    @ApiOperation(value = "用户保存",
        notes = "用户信息保存")
    @RequestMapping(value = "/authority/user/_save",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = SaveUserValidator.class)
    public String saveUserDoc(@RequestBody UserDoc request) {
        boolean var = userService.save(request);
        return MessageManager.getMessage("auth.I00001", new String[] { "用户", var ? "成功" : "失败" });
    }

    @ApiOperation(value = "用户删除",
        notes = "用户信息删除")
    @RequestMapping(value = "/authority/user/_delete",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = DelUserValidator.class)
    public String deleteUserDoc(@RequestBody ArrayList<String> request) {
        int writeResult = userService.delete(request);
        return MessageManager.getMessage("auth.I00003", new String[] { "用户", String.valueOf(writeResult) });
    }

    @ApiOperation(value = "用户更新",
        notes = "用户信息更新")
    @RequestMapping(value = "/authority/user/_update",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = UpdateUserValidator.class)
    public String updateUserDoc(@RequestBody UserDoc request) {
        int Result = userService.update(request);
        return MessageManager.getMessage("auth.I00002", new String[] { "用户", String.valueOf(Result) });
    }

    @ApiOperation(value = "用户取得",
        notes = "用户信息取得")
    @RequestMapping(value = "/authority/user/_search",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = SearchUserValidator.class)
    public BaseRestPaginationResult<UserDoc> searchUserDoc(@RequestBody UserParam request) {
        return userService.findList(request);
    }

    @ApiOperation(value = "用户权限取得",
        notes = "用户权限取得集合")
    @RequestMapping(value = "/authority/user/permission/_search",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<TreeNodeDoc> searchUserPermissionSet(@RequestBody UserParam request) {
        return userService.findUserPermissionList(request);
    }
}
