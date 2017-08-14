package com.msk.bean;


import com.framework.base.rest.entity.BaseEntity;

import java.util.List;

/**
 * Created by mao_yejun on 2016/10/13.
 */
public class DeleteMessRelBean extends BaseEntity {
    private List<String> ids;
    private String userCode;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }
}
