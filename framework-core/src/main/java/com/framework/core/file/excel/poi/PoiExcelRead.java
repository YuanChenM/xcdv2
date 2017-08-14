package com.framework.core.file.excel.poi;

import com.framework.core.file.excel.ExcelRead;
import com.framework.core.utils.BeanUtils;
import com.framework.exception.SystemException;
import org.apache.commons.collections.map.HashedMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 读取excelPoi
 *
 * @param <T>需要返回的对象类型
 * @author liu_tao2
 * @version 1.0
 */
public class PoiExcelRead<T> implements ExcelRead<T> {
    /**
     * 读取Excel开始行数
     */
    private int startRow;
    /**
     * Excel Sheet
     */
    private int sheetIndex;
    /**
     * Excel Workbook
     */
    private Workbook workbook;
    /**
     * Excel字段对应名称
     */
    private String[] fieldName;

    private T entity;

    /**
     * 默认构造函数
     *
     * @param startRow    开始行数
     * @param sheetIndex  Excel Sheet Index
     * @param inputStream Excel输入流
     * @throws IOException
     */
    public PoiExcelRead(int startRow, int sheetIndex, InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return;
        }
//        this.workbook = new XSSFWorkbook(inputStream);
        this.sheetIndex = sheetIndex;
        this.startRow = startRow;
    }

    /**
     * 得到需要返回的excel中的固定sheet的所有数据
     *
     * @return 所有数据集合
     */
    public List<T> readList(Class entityClass) throws Exception {
        List<T> entityList = new ArrayList<>();
        Sheet sheet = this.workbook.getSheetAt(sheetIndex);
        int lastRowNum = sheet.getLastRowNum();
        for (int rowIndex = startRow; rowIndex < lastRowNum; rowIndex++) {
            Row row = sheet.getRow(rowIndex);
            T entity = read(row, entityClass);
            entityList.add(entity);
        }
        return entityList;
    }

    /**
     * 读取每行的数据
     *
     * @param row 每行的数据
     * @return
     */
    @Override
    public T read(Row row, Class entityClass) throws Exception {
        int lastCellNum = row.getLastCellNum();
        if (lastCellNum > fieldName.length) {
            throw new SystemException("system.error.poi");
        }

        Map<String,Object> map = new HashedMap();
        Field[] fs = entityClass.getDeclaredFields();
        T objectCopy = (T) entityClass.getConstructor(new Class[]{}).newInstance(new Object[]{});
        for (int column = 0; column < lastCellNum; column++) {
            Cell cell = PoiUtils.getCell(row, column);
            for (Field f : fs) {
                String valueName = f.getName();
                if (valueName.equals(fieldName[column])) {
                    String cellValue = PoiUtils.getCellValue(cell);
                    map.put(valueName,cellValue);
                }
            }
        }
        BeanUtils.copyProperties(objectCopy,map);
        return objectCopy;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public void setFieldName(String[] fieldName) {
        this.fieldName = fieldName;
    }

}
