package com.framework.batch.item.file.excel;

/**
 * <p>包装不同的Excel实现，如JExcel、JXL或Apache POI。</p>
 *
 * @author xia_xiaojie
 * @date 2016/11/11
 * @version 1.0.0
 */
public interface Sheet {
	
	/**
	 * <p>获得Sheet的名称。</p>
	 * 
	 * @return Sheet名称
	 */
    String getName();

    /**
     * <p>获得一行每个单元格的数据，返回字符串数组，若行不存在，则返回null。</p>
     * 
     * @param rowNum 行号
     * @return 字符串数组或null
     */
	String[] getCellValues(int rowNum);

	/**
	 * <p>获得Sheet的行数。</p>
	 * 
	 * @return 行数
	 */
	int getNumberOfRows();
	
	/**
	 * <p>获得Sheet最后一行的行号。</p>
	 * 
	 * @return 最后一行的行号
	 */
	int getLastRowNum();

	/**
	 * <p>获得Sheet的列数。</p>
	 * 
	 * @return 列数
	 */
	int getNumberOfColumns();

}
