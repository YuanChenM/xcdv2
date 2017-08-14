package com.framework.base.service.impl;

import com.framework.base.bean.UploadParam;
import com.framework.base.service.IUploadFileRead;
import com.framework.exception.SystemException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author shi_yuxi
 */
public abstract class UploadExcelReadImpl implements IUploadFileRead {

    /**
     * 读取操作
     *
     * @param workBook workbook
     * @param param 前台参数
     * @param <T> 泛型
     * @return 文件中数据
     */
    public abstract <T> List<T> toRead(Workbook workBook, UploadParam param);

    @Override
    public <T> List<T> read(InputStream file, UploadParam param) throws IOException {
        Workbook workbook = createWorkbook(file, param.getFileSuffix());
        return this.toRead(workbook, param);
    }

    /**
     * 创建workbook
     *
     * @param inputStream 文件流
     * @param excelType   excel后缀
     * @return workbook
     * @throws IOException 异常
     */
    private Workbook createWorkbook(InputStream inputStream, String excelType) throws IOException {
        if ("xls".equals(excelType)) {
            return new HSSFWorkbook(inputStream);
        } else if ("xlsx".equals(excelType)) {
            return new XSSFWorkbook(inputStream);
        } else {
            throw new SystemException("");
        }
    }
}
