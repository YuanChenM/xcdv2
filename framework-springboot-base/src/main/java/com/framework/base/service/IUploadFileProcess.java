package com.framework.base.service;

import com.framework.base.bean.UploadParam;

import java.util.List;

/**
 * @author shi_yuxi
 */
public interface IUploadFileProcess {

    /**
     * 处理文件中数据
     *
     * @param data  数据
     * @param param 上传参数
     * @param <T> 泛型
     */
    <T> void processData(List<T> data, UploadParam param);
}
