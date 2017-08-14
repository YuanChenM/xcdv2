package com.framework.base.service.impl;

import com.framework.base.bean.UploadParam;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shi_yuxi on 2016/11/3.
 */
@Service("uploadProcess")
public class TestUploadExcelProcessImpl extends UploadFileProcessImpl {
    @Override
    public <T> void toProcessData(List<T> data, UploadParam param) {

    }
}
