package com.zuul.bean.param;

import com.zuul.bean.PageParam;

/**
 * Created by mao_yejun on 2017/2/28.
 */
public class UserSearchParam extends PageParam {
    private String companyName;
    private String contacts;

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
}
