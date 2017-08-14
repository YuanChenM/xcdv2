package com.framework.core.file.excel.poi;

import com.framework.base.consts.DateFormatDef;
import com.framework.base.consts.NumberConst;
import com.framework.base.consts.StringConst;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.NumberUtils;
import com.framework.exception.SystemException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.NumberToTextConverter;

/**
 * Poi共同方法
 *
 * @author liu_tao2
 * @version 1.0
 */
public final class PoiUtils {
    /**
     * 获得Excel的行信息
     *
     * @param sheet Excel Sheet
     * @param row   行号
     * @return 行信息
     */
    public static Row getRow(Sheet sheet, int row) {
        if (!checkExcelRow(sheet, row)) {
            throw new SystemException("system.poi.error");
        }
        return sheet.getRow(row);
    }

    /**
     * 获得Excel Sheet中Row的Cell。
     *
     * @param sheet    Excel Sheet
     * @param rowIndex 行号
     * @param column   列号
     * @return Cell
     */
    public static Cell getCell(Sheet sheet, int rowIndex, int column) {
        if (!checkExcelColumn(sheet, rowIndex, column)) {
            throw new SystemException("system.poi.error");
        }
        Row row = getRow(sheet, rowIndex);
        Cell cell = row.getCell(column);
        return cell;
    }

    /**
     * 获得Excel Sheet中Row的Cell。
     *
     * @param row    Excel Row
     * @param column 列号
     * @return Cell
     */
    public static Cell getCell(Row row, int column) {
        Cell cell = row.getCell(column);
        return cell;
    }

    /**
     * 获得Excel Cell.<br/>
     * 如果Cell不存在,则创建一个新的Cell
     *
     * @param sheet    Excel Sheet
     * @param rowIndex Excel Sheet Row Index
     * @param column   Excel Sheet Row Column
     * @return The Excel Cell
     */
    public static Cell loadCell(Sheet sheet, int rowIndex, int column) {
        if (!checkExcelColumn(sheet, rowIndex, column)) {
            throw new SystemException("system.poi.error");
        }
        Row row = loadRow(sheet, rowIndex);
        Cell cell = loadCell(row, column);
        return cell;
    }

    /**
     * 获得Excel Row<br/>
     * 如果Row不存在,则创建一个新的Row
     *
     * @param sheet    Excel Sheet Row
     * @param rowIndex Excel Sheet Row Index
     * @return The Create Row。
     */
    public static Row loadRow(Sheet sheet, int rowIndex) {
        Row row = getRow(sheet, rowIndex);
        if (null == row) {
            row = sheet.createRow(rowIndex);
        }
        return row;
    }

    /**
     * 获得Excel Cell.<br/>
     * 如果Cell不存在,则创建一个新的Cell.
     *
     * @param row    The Excel Row
     * @param column The Column.
     * @return The Excel Cell.
     */
    public static Cell loadCell(Row row, int column) {
        Cell cell = row.getCell(column);
        if (null == cell) {
            cell = row.createCell(column);
        }
        return cell;
    }

    public static String getCellValue(Cell cell) {
        if (cell == null) {
            return StringConst.EMPTY;
        }
        String value = StringConst.EMPTY;
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:// 字符串类型
                value = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_BOOLEAN:// Boolean类型
                if (cell.getBooleanCellValue()) {
                    value = String.valueOf(Boolean.TRUE);
                } else {
                    value = String.valueOf(Boolean.FALSE);
                }
                break;
            case Cell.CELL_TYPE_NUMERIC:// Number类型
                if (DateUtil.isCellDateFormatted(cell)) {// 时间格式返回类型为YYYYMMDD
                    value = DateUtils.format(DateFormatDef.FORMAT_YYYYMMDD, cell.getDateCellValue());
                } else {
                    value = NumberToTextConverter.toText(cell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_FORMULA:// 格式化类型
                value = getCellTypeFormulaValue(cell);
                break;
            default:
                break;
        }
        return value;

    }

    /**
     * 获得Excel Row Cell 值.全部返还字符串.
     *
     * @param sheet  Excel Sheet
     * @param row    Excel Sheet Row
     * @param column Excel Sheet Row Column
     * @return Cell 值
     */
    public static String getCellValue(Sheet sheet, int row, int column) {
        Cell cell = getCell(sheet, row, column);
        if (null == cell) {
            return StringConst.EMPTY;
        }
        return getCellValue(cell);
    }

    /**
     * 获得Double类型的Cell Value.
     *
     * @param sheet  The Excel Sheet.
     * @param row    The Excel Row.
     * @param column The Excel Column
     * @return The Double.
     */
    public static double getNumericCellValue(Sheet sheet, int row, int column) {
        return NumberUtils.toDouble(getCellValue(sheet, row, column));
    }

    /**
     * 获得Cell Type Formula Value.
     *
     * @param cell The Excel Cell
     * @return The Cell Value.
     */
    private static String getCellTypeFormulaValue(Cell cell) {
        if (cell.getCachedFormulaResultType() == Cell.CELL_TYPE_NUMERIC) {
            return String.valueOf(cell.getNumericCellValue());
        } else if (cell.getCachedFormulaResultType() == Cell.CELL_TYPE_STRING) {
            return cell.getStringCellValue();
        }
        return StringConst.EMPTY;
    }

    /**
     * 判断Excel Row是否达到最大.
     *
     * @param sheet Excel Sheet
     * @param row   Excel Row
     * @return Boolean:true is Row,false is not Row
     */
    public static boolean checkExcelRow(Sheet sheet, int row) {
        // 判断Excel版本
        // Excel 2003
        if (sheet instanceof HSSFSheet) {
            if (row < NumberConst.IntDef.INT_ZERO || row > NumberConst.ExcelMaxRowCount.EXCEL_2003_MAX_ROW_COUNT) {
                return Boolean.FALSE;
            }
        } else {// Excel 2003以外的
            if (row < NumberConst.IntDef.INT_ZERO || row > NumberConst.ExcelMaxRowCount.EXCEL_2007_MAX_ROW_COUNT) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    /**
     * 判断Excel Row里面的Column
     *
     * @param sheet  Excel Sheet
     * @param row    Excel Sheet Row
     * @param column Excel Sheet Row Column
     * @return Boolean:True is column,false is not Column
     */
    public static boolean checkExcelColumn(Sheet sheet, int row, int column) {
        if (!checkExcelRow(sheet, row)) {
            return Boolean.FALSE;
        }
        if (sheet instanceof HSSFSheet) {
            if (column < NumberConst.IntDef.INT_ZERO
                    || column > NumberConst.ExcelMaxColumnCount.EXCEL_2003_MAX_COLUMN_COUNT) {
                return Boolean.FALSE;
            }
        } else {// Excel 2003以外的
            if (column < NumberConst.IntDef.INT_ZERO
                    || column > NumberConst.ExcelMaxColumnCount.EXCEL_2007_MAX_COLUMN_COUNT) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
}
