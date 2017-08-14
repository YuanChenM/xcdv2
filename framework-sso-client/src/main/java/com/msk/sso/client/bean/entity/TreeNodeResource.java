package com.msk.sso.client.bean.entity;

import java.io.Serializable;
import java.util.List;

public class TreeNodeResource implements Serializable {

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


}
