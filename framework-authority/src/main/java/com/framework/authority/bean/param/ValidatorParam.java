package com.framework.authority.bean.param;

import com.framework.base.bean.param.page.BasePageParam;

/**
 * Created by liutao on 2016/11/1.
 */
public class ValidatorParam extends BasePageParam {
    private String name;

    private String nowDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNowDate() {
        return nowDate;
    }

    public void setNowDate(String nowDate) {
        this.nowDate = nowDate;
    }
}
