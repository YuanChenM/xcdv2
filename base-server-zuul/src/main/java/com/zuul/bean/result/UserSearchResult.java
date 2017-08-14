package com.zuul.bean.result;

import java.io.Serializable;

/**
 * Created by mao_yejun on 2017/2/28.
 */
public class UserSearchResult implements Serializable {
    private long userId;
    private long userInfoId;
    private String companyName;
    private String contacts;
    private String phone;
    private String mail;
    private String weChat;
    private String qq;
    private String companyWebAdd;
    private String loginId;
    private String password;
    private boolean allFlg;

    public boolean isAllFlg() {
        return allFlg;
    }

    public void setAllFlg(boolean allFlg) {
        this.allFlg = allFlg;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(long userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getCompanyWebAdd() {
        return companyWebAdd;
    }

    public void setCompanyWebAdd(String companyWebAdd) {
        this.companyWebAdd = companyWebAdd;
    }
}
