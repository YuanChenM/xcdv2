package com.zuul.bean.param;

import java.io.Serializable;

/**
 * Created by mao_yejun on 2017/3/9.
 */
public class UpdateInterfaceParam implements Serializable {
    private long interfaceDetailId;
    private String interfaceName;
    private String interfaceUrl;
    private String moduleId;

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public long getInterfaceDetailId() {
        return interfaceDetailId;
    }

    public void setInterfaceDetailId(long interfaceDetailId) {
        this.interfaceDetailId = interfaceDetailId;
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
