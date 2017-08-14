package com.framework.authority.bean.result;

import java.util.List;

import com.framework.authority.bean.entity.TreeNodeBean;

/**
 * Created by zhang_jian3 on 2016/12/16.
 */
public class GroupResult {
    /** 组ID */
    public String groupId;

    /** 组编号 */
    public String groupCode;

    /** 组名称 */
    public String groupName;

    /** 组描述 */
    public String groupDesc;

    /** 组排序 */
    public Integer groupSort;

    /** 勾选权限值 */
    public List<TreeNodeBean> treeNode;

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
