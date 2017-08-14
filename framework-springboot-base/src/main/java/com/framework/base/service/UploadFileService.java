package com.framework.base.service;

import com.framework.base.bean.UploadParam;

import java.io.InputStream;

/**
 * @author shi_yuxi
 */
public abstract class  UploadFileService {
    public abstract void process(UploadParam uploadParam, InputStream file);

}
