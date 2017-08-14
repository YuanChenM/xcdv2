package com.framework.base.service.impl;

import com.framework.base.bean.UploadParam;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shi_yuxi on 2016/11/3.
 */
@Service("uploadWrite")
public class TestUploadExcelWriteImpl extends UploadExcelWriteImpl {
    @Override
    public <T> void toWriteData(List<T> data, UploadParam param) {

    }
}
