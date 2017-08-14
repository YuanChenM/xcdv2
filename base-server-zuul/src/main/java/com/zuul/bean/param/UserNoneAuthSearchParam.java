package com.zuul.bean.param;

import com.zuul.bean.PageParam;

/**
 * Created by mao_yejun on 2017/3/14.
 */
public class UserNoneAuthSearchParam extends PageParam {
    private Long userId;
    private Long moduleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }
}
