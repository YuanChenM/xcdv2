package com.zuul.bean.param;

import java.io.Serializable;

/**
 * Created by mao_yejun on 2017/2/28.
 */
public class InterfaceCreateParam implements Serializable{
    private long moduleId;
    private String interfaceCode;
    private String interfaceName;
    private String interfaceUrl;

    public void setModuleId(long moduleId) {
        this.moduleId = moduleId;
    }

    public long getModuleId() {
        return moduleId;
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
}
