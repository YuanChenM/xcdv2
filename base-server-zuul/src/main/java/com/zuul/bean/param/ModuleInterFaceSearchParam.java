package com.zuul.bean.param;


import com.zuul.bean.PageParam;

/**
 * Created by mao_yejun on 2017/3/9.
 */
public class ModuleInterFaceSearchParam extends PageParam {

    private long moduleId;
    private String interfaceUrl;
    private String interfaceName;

    public String getInterfaceUrl() {
        return interfaceUrl;
    }

    public void setInterfaceUrl(String interfaceUrl) {
        this.interfaceUrl = interfaceUrl;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public long getModuleId() {
        return moduleId;
    }

    public void setModuleId(long moduleId) {
        this.moduleId = moduleId;
    }
}
