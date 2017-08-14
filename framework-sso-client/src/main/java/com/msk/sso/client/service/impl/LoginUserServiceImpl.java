package com.msk.sso.client.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.TypeReference;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.msk.sso.client.bean.User;
import com.msk.sso.client.bean.entity.TreeNodeResource;
import com.msk.sso.client.bean.param.NewLoginParam;
import com.msk.sso.client.constant.SSORelevanceDefine;
import com.msk.sso.client.service.LoginUserService;
import com.msk.sso.client.utils.RestNewClientUtil;

/**
 * Created by zhangjian3 on 16/12/16.
 */
public class LoginUserServiceImpl implements LoginUserService {
    @Override
    public User getLoginUser(String employCode) {
        User user = new User();
        List<User> list = new ArrayList<>();
        String url = SSORelevanceDefine.getLoginUserInfoServerUrl();
        User loginUserParam = new User();
        loginUserParam.setUserLogin(employCode);
        BaseRestPaginationResult<User> responseBody = RestNewClientUtil.post(url, loginUserParam,
            new TypeReference<BaseRestPaginationResult<User>>() {});
        if (null != responseBody && null != responseBody.getData() && responseBody.getData().size() > 0) {
            list = responseBody.getData();
            user = list.get(0);
        }
        return user;
    }

    @Override
    public List<TreeNodeResource> getLoginUserAuth(String employCode) {
        String url = SSORelevanceDefine.getLoginUserAuthServerUrl();
        NewLoginParam loginUserParam = new NewLoginParam();
        loginUserParam.setUserLogin(employCode);
        List<TreeNodeResource> responseBody = RestNewClientUtil.post(url, loginUserParam,
            new TypeReference<List<TreeNodeResource>>() {});
        List<TreeNodeResource> list = responseBody;
        return list;
    }

}
