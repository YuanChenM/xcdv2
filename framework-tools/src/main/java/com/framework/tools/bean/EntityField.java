package com.framework.tools.bean;

import java.io.Serializable;

/**
 * EntityField
 * @author yuan_chen
 */
public class EntityField implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String type;
	private String methodAppend;
	private String comment;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMethodAppend() {
		return methodAppend;
	}
	public void setMethodAppend(String methodAppend) {
		this.methodAppend = methodAppend;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
