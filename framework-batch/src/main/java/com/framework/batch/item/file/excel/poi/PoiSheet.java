package com.framework.batch.item.file.excel.poi;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.framework.batch.item.file.excel.Sheet;

/**
 * <p>包装Apache POI的Excel实现。</p>
 *
 * @author xia_xiaojie
 * @date 2016/11/11
 * @version 1.0.0
 */
public class PoiSheet implements Sheet {
	private final org.apache.poi.ss.usermodel.Sheet delegate;

    /**
     * <p>包装Apache POI的Sheet。</p>
     * 
     * @param delegate the apache POI sheet
     */
	public PoiSheet(org.apache.poi.ss.usermodel.Sheet delegate) {
        this.delegate = delegate;
    }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return this.delegate.getSheetName();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("deprecation")
	@Override
	public String[] getCellValues(int rowNum) {
		if (rowNum > this.delegate.getLastRowNum()) {
			return null;
		}
		Row row = this.delegate.getRow(rowNum);
		if (row == null) {
			return null;
		}
		
		List<String> cells = new LinkedList<String>();
		Iterator<Cell> iterator = row.iterator();
		while (iterator.hasNext()) {
			Cell cell = iterator.next();
			switch (cell.getCellType()) {
				case Cell.CELL_TYPE_NUMERIC:
					cell.setCellType(Cell.CELL_TYPE_STRING);
					cells.add(cell.getStringCellValue());
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					cells.add(String.valueOf(cell.getBooleanCellValue()));
					break;
				case Cell.CELL_TYPE_STRING:
				case Cell.CELL_TYPE_BLANK:
					cells.add(cell.getStringCellValue());
					break;
				default:
					throw new IllegalArgumentException("Cannot handle cells of type " + cell.getCellType());
			}
		}
		return cells.toArray(new String[cells.size()]);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getNumberOfRows() {
		return this.delegate.getLastRowNum() + 1;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getLastRowNum() {
		return this.delegate.getLastRowNum();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getNumberOfColumns() {
		String[] columns = this.getCellValues(0);
		if (columns != null) {
			return columns.length;
		}
		return 0;
	}


}
