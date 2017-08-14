package com.framework.authority.bean.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import com.framework.authority.base.entity.BaseEntity;


/**
 * Created by zhang_jian3 on 2016/11/17.
 */
@Document(collection = "treeDoc")
public class TreeDoc extends BaseEntity {

    private String treeId;

    private String treeCode;

    private String treeName;

    private String treeDesc;

    private Boolean isMultiple;

    private Boolean isParent;

    private Boolean isChildren;

    private Boolean isNotParent;

    private Boolean isNotChildren;

    public String getTreeId() {
        return treeId;
    }

    public void setTreeId(String treeId) {
        this.treeId = treeId;
    }

    public String getTreeCode() {
        return treeCode;
    }

    public void setTreeCode(String treeCode) {
        this.treeCode = treeCode;
    }

    public String getTreeName() {
        return treeName;
    }

    public void setTreeName(String treeName) {
        this.treeName = treeName;
    }

    public String getTreeDesc() {
        return treeDesc;
    }

    public void setTreeDesc(String treeDesc) {
        this.treeDesc = treeDesc;
    }

    public Boolean getIsMultiple() {
        return isMultiple;
    }

    public void setIsMultiple(Boolean isMultiple) {
        this.isMultiple = isMultiple;
    }

    public Boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }

    public Boolean getIsChildren() {
        return isChildren;
    }

    public void setIsChildren(Boolean isChildren) {
        this.isChildren = isChildren;
    }

    public Boolean getIsNotParent() {
        return isNotParent;
    }

    public void setIsNotParent(Boolean isNotParent) {
        this.isNotParent = isNotParent;
    }

    public Boolean getIsNotChildren() {
        return isNotChildren;
    }

    public void setIsNotChildren(Boolean isNotChildren) {
        this.isNotChildren = isNotChildren;
    }
}
