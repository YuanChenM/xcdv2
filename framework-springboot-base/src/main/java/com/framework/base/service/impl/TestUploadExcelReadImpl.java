package com.framework.base.service.impl;

import com.framework.base.bean.UploadParam;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shi_yuxi on 2016/11/3.
 */
@Service("uploadRead")
public class TestUploadExcelReadImpl extends UploadExcelReadImpl{
    @Override
    public <T> List<T> toRead(Workbook workBook, UploadParam param) {

        return new ArrayList<>();
    }
}
