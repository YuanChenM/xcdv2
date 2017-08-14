package com.framework.core.file.excel;

import org.apache.poi.ss.usermodel.Row;

/**
 * 读取excel接口
 * @author liu_tao2
 * @version 1.0
 */
public interface ExcelRead<T> {
    T read(Row row, Class entity) throws Exception;
}
