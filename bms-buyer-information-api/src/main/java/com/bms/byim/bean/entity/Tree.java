/*
 * 2016/12/06 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.byim.bean.entity;


import com.framework.base.rest.entity.BaseEntity;

/**
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class Tree extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** itemId */
    private Long itemId;
    /** PARENT_ID */
    private Long parentId;
    /** NODE_PATH */
    private String nodePath;
    /** MARKETING_STATUS_NAME */
    private String itemName;
    /** MARKETING_STATUS_CODE */
    private String itemCode;

    /**
     * <p>默认构造函数</p>
     */
    public Tree() {
    }

    /**
     * Getter method for property <tt>itemCode</tt>.
     *
     * @return property value of itemCode
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * Setter method for property <tt>itemCode</tt>.
     *
     * @param itemCode value to be assigned to property itemCode
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * Getter method for property <tt>itemId</tt>.
     *
     * @return property value of itemId
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * Setter method for property <tt>itemId</tt>.
     *
     * @param itemId value to be assigned to property itemId
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    /**
     * Getter method for property <tt>parentId</tt>.
     *
     * @return property value of parentId
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * Setter method for property <tt>parentId</tt>.
     *
     * @param parentId value to be assigned to property parentId
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * Getter method for property <tt>nodePath</tt>.
     *
     * @return property value of nodePath
     */
    public String getNodePath() {
        return nodePath;
    }

    /**
     * Setter method for property <tt>nodePath</tt>.
     *
     * @param nodePath value to be assigned to property nodePath
     */
    public void setNodePath(String nodePath) {
        this.nodePath = nodePath;
    }

    /**
     * Getter method for property <tt>itemName</tt>.
     *
     * @return property value of itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Setter method for property <tt>itemName</tt>.
     *
     * @param itemName value to be assigned to property itemName
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
