package com.framework.authority.bean.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.framework.authority.base.entity.BaseEntity;

/**
 * Created by zhang_jian3 on 2016/11/15.
 */
@Document(collection = "userDoc")
public class UserDoc extends BaseEntity {

    private String userId;

    private String userCode;

    private String userName;

    private String userType;

    private String userPhone;

    private String userEmail;

    private String userLogin;

    private String userPwd;

    private Date startDate;

    private Date endDate;

    private String pid;

    private String fullpath;

    private List<String> group;

    private List<TreeNodeBean> treeNode;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<String> getGroup() {
        return group;
    }

    public void setGroup(List<String> group) {
        this.group = group;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getFullpath() {
        return fullpath;
    }

    public void setFullpath(String fullpath) {
        this.fullpath = fullpath;
    }

    public List<TreeNodeBean> getTreeNode() {
        return treeNode;
    }

    public void setTreeNode(List<TreeNodeBean> treeNode) {
        this.treeNode = treeNode;
    }

    @Override
    public String toString() {
        return "UserDoc{" + "userId='" + userId + '\'' + ", userCode='" + userCode + '\'' + ", userName='" + userName
                + '\'' + ", userType='" + userType + '\'' + ", userPhone='" + userPhone + '\'' + ", userEmail='"
                + userEmail + '\'' + ", userLogin='" + userLogin + '\'' + ", userPwd='" + userPwd + '\''
                + ", startDate=" + startDate + ", endDate=" + endDate + ", pid='" + pid + '\'' + ", fullpath='"
                + fullpath + '\'' + ", group=" + group + ", treeNode=" + treeNode + '}';
    }
}
