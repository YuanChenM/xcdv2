package com.framework.base.bean;

import java.io.Serializable;
import java.util.Map;

/**
 * @author shi_yuxi
 */
public class UploadParam implements Serializable {
    /**
     * service名称
     */
    private String serviceName;
    /**
     * 文件服务器文件id
     */
    private String fid;

    /**
     * redis的key值
     */
    private String taskId;

    /**
     * 前台参数
     */
    private Map<String,String> param;

    /**
     * 文件后缀
     */
    private String fileSuffix;

    public String getFileSuffix() {
        return fileSuffix;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Map<String, String> getParam() {
        return param;
    }

    public void setParam(Map<String, String> param) {
        this.param = param;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }
}
