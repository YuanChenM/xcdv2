package com.zuul.bean.param;

import java.io.Serializable;

/**
 * Created by mao_yejun on 2017/2/27.
 */
public class ModuleCreateParam implements Serializable{
    private String moduleName;
    private String moduleCode;

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }
}
