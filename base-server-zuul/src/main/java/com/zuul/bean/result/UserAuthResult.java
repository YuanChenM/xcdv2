package com.zuul.bean.result;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by mao_yejun on 2017/3/2.
 */
public class UserAuthResult implements Serializable {
    private String interfaceDetailId;
    private String interfaceCode;
    private String interfaceName;
    private String interfaceUrl;
    private String moduleCode;
    private String moduleName;

    public String getInterfaceDetailId() {
        return interfaceDetailId;
    }

    public void setInterfaceDetailId(String interfaceDetailId) {
        this.interfaceDetailId = interfaceDetailId;
    }

    public String getInterfaceCode() {
        return interfaceCode;
    }

    public void setInterfaceCode(String interfaceCode) {
        this.interfaceCode = interfaceCode;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getInterfaceUrl() {
        return interfaceUrl;
    }

    public void setInterfaceUrl(String interfaceUrl) {
        this.interfaceUrl = interfaceUrl;
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
