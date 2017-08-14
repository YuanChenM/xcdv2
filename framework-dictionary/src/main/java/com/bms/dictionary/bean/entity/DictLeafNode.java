/*
 * 2016/12/02 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.dictionary.bean.entity;


import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表dict_leaf_node对应的实体DictLeafNode</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class DictLeafNode extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** DICT_ID */
    private Long dictId;
    /** DICT_CODE */
    private String dictCode;
    /** PARENT_ID */
    private Long parentId;
    /** IS_ROOT */
    private boolean isRoot;
    /** FULLPATH */
    private String fullpath;
    /** DICT_EN */
    private String dictEn;
    /** DICT_CN */
    private String dictCn;

    /**
     * <p>默认构造函数</p>
     */
    public DictLeafNode() {
    }

    /**
     * <p>DICT_ID</p>
     *
     * @return DICT_ID
     */
    public Long getDictId() {
        return dictId;
    }

    /**
     * <p>DICT_ID</p>
     *
     * @param dictId DICT_ID
     */
    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }
    /**
     * <p>DICT_CODE</p>
     *
     * @return DICT_CODE
     */
    public String getDictCode() {
        return dictCode;
    }

    /**
     * <p>DICT_CODE</p>
     *
     * @param dictCode DICT_CODE
     */
    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public boolean isRoot() {
        return isRoot;
    }

    public void setRoot(boolean isRoot) {
        this.isRoot = isRoot;
    }

    /**
     * <p>FULLPATH</p>
     *
     * @return FULLPATH
     */
    public String getFullpath() {
        return fullpath;
    }

    /**
     * <p>FULLPATH</p>
     *
     * @param fullpath FULLPATH
     */
    public void setFullpath(String fullpath) {
        this.fullpath = fullpath;
    }
    /**
     * <p>DICT_EN</p>
     *
     * @return DICT_EN
     */
    public String getDictEn() {
        return dictEn;
    }

    /**
     * <p>DICT_EN</p>
     *
     * @param dictEn DICT_EN
     */
    public void setDictEn(String dictEn) {
        this.dictEn = dictEn;
    }
    /**
     * <p>DICT_CN</p>
     *
     * @return DICT_CN
     */
    public String getDictCn() {
        return dictCn;
    }

    /**
     * <p>DICT_CN</p>
     *
     * @param dictCn DICT_CN
     */
    public void setDictCn(String dictCn) {
        this.dictCn = dictCn;
    }

}
