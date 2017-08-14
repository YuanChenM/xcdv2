/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.common.bean;
/**
 * <p>表comm_constant对应的CommConstant。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class CommConstant{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 常量ID */
    private Long id;
    /** 分CodeMaster和Status */
    private String constantType;
    /** 常量类型名称 */
    private String constantTypeName;
    /** 常量定义名称 */
    private String constantName;
    /** 常量定义值 */
    private String constantValue;
    /**
     * <p>默认构造函数。</p>
     */
    public CommConstant() {

    }

    /**
     * <p>常量ID。</p>
     *
     * @return the 常量ID
     */
    public Long getId() {
        return id;
    }

    /**
     * <p>常量ID。</p>
     *
     * @param id 常量ID。
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <p>分CodeMaster和Status。</p>
     *
     * @return the 分CodeMaster和Status
     */
    public String getConstantType() {
        return constantType;
    }

    /**
     * <p>分CodeMaster和Status。</p>
     *
     * @param constantType 分CodeMaster和Status。
     */
    public void setConstantType(String constantType) {
        this.constantType = constantType;
    }

    /**
     * <p>常量类型名称。</p>
     *
     * @return the 常量类型名称
     */
    public String getConstantTypeName() {
        return constantTypeName;
    }

    /**
     * <p>常量类型名称。</p>
     *
     * @param constantTypeName 常量类型名称。
     */
    public void setConstantTypeName(String constantTypeName) {
        this.constantTypeName = constantTypeName;
    }

    /**
     * <p>常量定义名称。</p>
     *
     * @return the 常量定义名称
     */
    public String getConstantName() {
        return constantName;
    }

    /**
     * <p>常量定义名称。</p>
     *
     * @param constantName 常量定义名称。
     */
    public void setConstantName(String constantName) {
        this.constantName = constantName;
    }

    /**
     * <p>常量定义值。</p>
     *
     * @return the 常量定义值
     */
    public String getConstantValue() {
        return constantValue;
    }

    /**
     * <p>常量定义值。</p>
     *
     * @param constantValue 常量定义值。
     */
    public void setConstantValue(String constantValue) {
        this.constantValue = constantValue;
    }

}
