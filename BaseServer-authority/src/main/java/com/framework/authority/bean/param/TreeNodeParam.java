package com.framework.authority.bean.param;

import java.util.List;

import com.framework.authority.bean.entity.ResourceBean;
import com.framework.base.rest.param.BaseRestPaginationParam;

/**
 * Created by zhang_jian3 on 2016/11/18.
 */
public class TreeNodeParam extends BaseRestPaginationParam {

    private String nodeId;

    private String treeId;

    private String nodeCode;

    private String nodeName;

    private String nodeDesc;

    private Integer nodeSort;

    private String path;

    private String fullPath;

    private List<ResourceBean> resource;

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeCode() {
        return nodeCode;
    }

    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeDesc() {
        return nodeDesc;
    }

    public void setNodeDesc(String nodeDesc) {
        this.nodeDesc = nodeDesc;
    }

    public Integer getNodeSort() {
        return nodeSort;
    }

    public void setNodeSort(Integer nodeSort) {
        this.nodeSort = nodeSort;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    public String getTreeId() {
        return treeId;
    }

    public void setTreeId(String treeId) {
        this.treeId = treeId;
    }

    public List<ResourceBean> getResource() {
        return resource;
    }

    public void setResource(List<ResourceBean> resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        return "TreeNodeParam{" + "nodeId='" + nodeId + '\'' + ", treeId='" + treeId + '\'' + ", nodeCode='" + nodeCode
                + '\'' + ", nodeName='" + nodeName + '\'' + ", nodeDesc='" + nodeDesc + '\'' + ", nodeSort=" + nodeSort
                + ", path='" + path + '\'' + ", fullPath='" + fullPath + '\'' + ", resource=" + resource + '}';
    }
}
