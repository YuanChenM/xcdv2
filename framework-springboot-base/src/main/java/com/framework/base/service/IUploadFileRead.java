package com.framework.base.service;

import com.framework.base.bean.UploadParam;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author shi_yuxi
 */
public interface IUploadFileRead {
    /**
     * 读取文件中数据
     * @param file 文件服务器下载的流
     * @param param 前台上传参数
     * @param <T> 泛型
     * @return 读取文件中数据
     * @throws IOException 异常
     */
    <T> List<T> read(InputStream file, UploadParam param) throws IOException;
}
