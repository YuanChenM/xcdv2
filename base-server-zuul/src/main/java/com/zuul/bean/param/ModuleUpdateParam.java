package com.zuul.bean.param;

import java.io.Serializable;

/**
 * Created by mao_yejun on 2017/3/9.
 */
public class ModuleUpdateParam implements Serializable {
    private long moduleId;
    private String moduleCode;
    private String moduleName;

    public long getModuleId() {
        return moduleId;
    }

    public void setModuleId(long moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
}
