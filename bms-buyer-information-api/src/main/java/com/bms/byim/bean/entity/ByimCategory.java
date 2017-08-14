/*
 * 2016/12/06 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.byim.bean.entity;


import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表BYIM_CATEGORY对应的实体ByimCategory</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class ByimCategory extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** CATEGORY_ID */
    private Long categoryId;
    /** PARENT_ID */
    private Long parentId;
    /** NODE_PATH */
    private String nodePath;
    /** CATEGORY_NAME */
    private String categoryName;
    /** CATEGORY_CODE */
    private String categoryCode;

    /**
     * <p>默认构造函数</p>
     */
    public ByimCategory() {
    }

    /**
     * <p>CATEGORY_ID</p>
     *
     * @return CATEGORY_ID
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * <p>CATEGORY_ID</p>
     *
     * @param categoryId CATEGORY_ID
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    /**
     * <p>PARENT_ID</p>
     *
     * @return PARENT_ID
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * <p>PARENT_ID</p>
     *
     * @param parentId PARENT_ID
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    /**
     * <p>NODE_PATH</p>
     *
     * @return NODE_PATH
     */
    public String getNodePath() {
        return nodePath;
    }

    /**
     * <p>NODE_PATH</p>
     *
     * @param nodePath NODE_PATH
     */
    public void setNodePath(String nodePath) {
        this.nodePath = nodePath;
    }
    /**
     * <p>CATEGORY_NAME</p>
     *
     * @return CATEGORY_NAME
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * <p>CATEGORY_NAME</p>
     *
     * @param categoryName CATEGORY_NAME
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    /**
     * <p>CATEGORY_CODE</p>
     *
     * @return CATEGORY_CODE
     */
    public String getCategoryCode() {
        return categoryCode;
    }

    /**
     * <p>CATEGORY_CODE</p>
     *
     * @param categoryCode CATEGORY_CODE
     */
    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

}
