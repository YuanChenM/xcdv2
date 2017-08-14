package com.bms.byim.bean.param;


import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by tao_zhifa on 2016/12/6.
 */
@ApiModel(value = "categoryRsParam", description = "查询列表结构买家分类Param")
public class CategoryRsParam extends BaseRestPaginationParam {

    @ApiModelProperty(value = "买家分类ID")
    /** CATEGORY_ID */
    private Long categoryId;
    @ApiModelProperty(value = "父节点ID")
    /** PARENT_ID */
    private Long parentId;
    @ApiModelProperty(value = "节点地址")
    /** NODE_PATH */
    private String nodePath;
    @ApiModelProperty(value = "节点地址Like用")
    private String nodePathLike;
    @ApiModelProperty(value = "分类名称")
    /** CATEGORY_NAME */
    private String categoryName;
    @ApiModelProperty(value = "分类编码")
    /** CATEGORY_CODE */
    private String categoryCode;
    @ApiModelProperty(value = "逻辑删除")
    private boolean delFlg;
    @ApiModelProperty(value = "子节点数量")
    private Integer  childCount;
    @ApiModelProperty(value = "子节点是否存在")
    private Boolean  hasChild;

    @ApiModelProperty(value = "list")
    private List<CategoryRsParam> categoryList;

    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
        this.delFlg = delFlg;
    }

    public Integer getChildCount() {
        return childCount;
    }

    public Boolean getHasChild() {
        return hasChild;
    }

    public void setHasChild(Boolean hasChild) {
        this.hasChild = hasChild;
    }

    public void setChildCount(Integer childCount) {
        this.childCount = childCount;
    }

    public List<CategoryRsParam> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<CategoryRsParam> categoryList) {
        this.categoryList = categoryList;
    }

    public String getNodePathLike() {
        return nodePathLike;
    }

    public void setNodePathLike(String nodePathLike) {
        this.nodePathLike = nodePathLike;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getNodePath() {
        return nodePath;
    }

    public void setNodePath(String nodePath) {
        this.nodePath = nodePath;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }
}
