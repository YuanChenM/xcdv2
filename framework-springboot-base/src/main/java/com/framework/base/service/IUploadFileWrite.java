package com.framework.base.service;

import com.framework.base.bean.UploadParam;

import java.util.List;

/**
 * @author shi_yuxi
 */
public interface IUploadFileWrite {
    /**
     * 写入数据
     * @param data 数据
     * @param param 前台上传的参数
     * @param <T> 泛型
     */
    <T> void writeData(List<T> data, UploadParam param);
}
