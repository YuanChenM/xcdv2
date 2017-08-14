package com.msk.sso.client.service;

import java.util.List;

import com.msk.sso.client.bean.User;
import com.msk.sso.client.bean.entity.TreeNodeResource;

public interface LoginUserService {

    User getLoginUser(String employCode);

    List<TreeNodeResource> getLoginUserAuth(String employCode);

}
