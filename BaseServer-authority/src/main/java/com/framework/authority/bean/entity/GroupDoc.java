package com.framework.authority.bean.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.framework.authority.base.entity.BaseEntity;

/**
 * 权限组DOC
 * Created by rong_ting on 2016/11/15.
 */
@Document(collection = "groupDoc")
public class GroupDoc extends BaseEntity {

    /** 组ID */
    private String groupId;

    /** 组编号 */
    private String groupCode;

    /** 组名称 */
    private String groupName;

    /** 组描述 */
    private String groupDesc;

    /** 组排序 */
    private Integer groupSort;

    /** 勾选权限值 */
    private List<TreeNodeBean> treeNode;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    public Integer getGroupSort() {
        return groupSort;
    }

    public void setGroupSort(Integer groupSort) {
        this.groupSort = groupSort;
    }

    public List<TreeNodeBean> getTreeNode() {
        return treeNode;
    }

    public void setTreeNode(List<TreeNodeBean> treeNode) {
        this.treeNode = treeNode;
    }

}
