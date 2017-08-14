package com.zuul.bean.param;

import com.zuul.bean.PageParam;

/**
 * Created by mao_yejun on 2017/3/8.
 */
public class ModuleSearchParam extends PageParam{
    private String moduleName;

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
}
