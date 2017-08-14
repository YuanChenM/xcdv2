package com.msk.bean.param;


import java.io.Serializable;

/**
 * Created by mao_yejun on 2016/10/14.
 */
public class DeleteNoticeByEmployParam  implements Serializable{
    private String userCode;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
