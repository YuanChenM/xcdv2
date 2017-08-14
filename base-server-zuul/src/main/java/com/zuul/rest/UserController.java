package com.zuul.rest;

import com.zuul.bean.PageResult;
import com.zuul.bean.param.*;
import com.zuul.bean.result.UserAuthResult;
import com.zuul.bean.result.UserSearchResult;
import com.zuul.entity.UserAuthorityEntity;
import com.zuul.entity.UserEntity;
import com.zuul.logic.UserLogic;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by mao_yejun on 2017/2/27.
 */
@RestController
@Api(value = "node-api",
        description = "用户接口")
@RequestMapping(value = "/api")
public class UserController {
    @Autowired
    private UserLogic userLogic;

    @RequestMapping(value = "/user/_register",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "登陆接口")
    public Boolean registerUser(@RequestBody UserRegisterParam pram) {

        userLogic.userRegister(pram);
        return true;
    }

    @RequestMapping(value = "user/_search",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PageResult<UserSearchResult> searchUser(@RequestBody UserSearchParam param) {
        return userLogic.searchUser(param);
    }

    @RequestMapping(value = "user/_delete",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteUser(@RequestBody List<Long> param) {
        return userLogic.deleteUser(param);
    }

    @RequestMapping(value = "user/detail/_search",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UserSearchResult searchUserDetail(@RequestBody Long userId) {
        return userLogic.searchUserDetail(userId);
    }

    @RequestMapping(value = "user/detail/_update",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateUserDetail(@RequestBody UserUpdateParam pram) {
        userLogic.updateUserDetail(pram);
        return true;
    }

    @RequestMapping(value = "/user/auth/_search",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "查询权限接口")
    public PageResult<UserAuthResult> searchAuthByUser(@RequestBody UserAuthSearchParam param) {
        return userLogic.searchAuthByUser(param);
    }
    @RequestMapping(value = "/user/auth/_delete",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "创建新的模块")
    public boolean deleteAuthByUser(@RequestBody List<Long> param) {
        return userLogic.deleteAuthByIds(param);
    }
    @RequestMapping(value = "/user/auth/_save",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "创建新的模块")
    public boolean saveAuthByUser(@RequestBody AuthSaveParam param) {
        return userLogic.saveAuthByUser(param);
    }



}
