package com.framework.base.service.impl;

import com.framework.base.bean.UploadParam;
import com.framework.base.service.IUploadFileProcess;

import java.util.List;

/**
 * @author shi_yuxi
 */
public abstract class UploadFileProcessImpl implements IUploadFileProcess {

    /**
     * 处理文件中数据
     *
     * @param data 文件中数据
     * @param param 前台参数
     * @param <T> 泛型
     */
    public abstract  <T> void toProcessData(List<T> data, UploadParam param);

    @Override
    public <T> void processData(List<T> data, UploadParam param) {
        this.toProcessData(data,param);
    }
}
