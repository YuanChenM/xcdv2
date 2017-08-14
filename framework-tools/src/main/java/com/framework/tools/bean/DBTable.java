package com.framework.tools.bean;

import java.io.Serializable;
import java.util.List;
/**
 * 表
 * @author yuan_chen
 */
public class DBTable implements Serializable{
	private static final long serialVersionUID = 1L;
	/**表名*/
	private String tableName;
	/**表描述*/
	private String tableDescription;
	private List<TableColumn> tableColumnList;
	
	public String getTableDescription() {
		return tableDescription;
	}
	public void setTableDescription(String tableDescription) {
		this.tableDescription = tableDescription;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public List<TableColumn> getTableColumnList() {
		return tableColumnList;
	}
	public void setTableColumnList(List<TableColumn> tableColumnList) {
		this.tableColumnList = tableColumnList;
	}
	
}
