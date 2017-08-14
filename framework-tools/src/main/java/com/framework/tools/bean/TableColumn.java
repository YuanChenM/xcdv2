package com.framework.tools.bean;

import java.io.Serializable;

/**
 * 列
 * @author yuan_chen
 */
public class TableColumn implements Serializable{
	private static final long serialVersionUID = 1L;
	private String columnName;
	private boolean identity;
	private boolean pk;
	private String dataType;
	private String defaultValue;
	
	/**字段描述*/
	private String columnDescription;
	
	public String getColumnDescription() {
		return columnDescription;
	}
	public void setColumnDescription(String columnDescription) {
		this.columnDescription = columnDescription;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public boolean isIdentity() {
		return identity;
	}
	public void setIdentity(boolean identity) {
		this.identity = identity;
	}
	
	public boolean isPk() {
		return pk;
	}
	public void setPk(boolean pk) {
		this.pk = pk;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String value) {
		this.defaultValue = value;
	}
	
}
