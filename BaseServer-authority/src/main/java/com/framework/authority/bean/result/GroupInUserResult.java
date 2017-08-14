package com.framework.authority.bean.result;

import java.util.ArrayList;
import java.util.List;

import com.framework.authority.bean.entity.UserDoc;

/**
 * Created by zhang_jian3 on 2017/3/1.
 */
public class GroupInUserResult {

    private String id;

    private String code;

    private String name;

    private String userLogin;

    private String userType;

    private List<GroupInUserResult> children = new ArrayList<>();

    public void addChildren(GroupInUserResult groupInUserResult) {
        children.add(groupInUserResult);
    }

    public void removeChildren(GroupInUserResult groupInUserResult) {
        children.remove(groupInUserResult);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public List<GroupInUserResult> getChildren() {
        return children;
    }

    public void setChildren(List<GroupInUserResult> children) {
        this.children = children;
    }
}
