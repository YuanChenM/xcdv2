package com.bms.byim.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yuan_chen1 on 2016/12/6.
 */

@ApiModel(value = "treeRsResult", description = "查询Result")
public class TreeRsResult implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 输出参数list
     */
    @ApiModelProperty(value = "itemList")
    private List<TreeRsResult> itemList;
    @ApiModelProperty(value = "hasChild")
    public boolean hasChild;

    /**
     * id
     */
    @ApiModelProperty(value = "项目ID")
    private Long itemId;
    /**
     * parentId
     */
    @ApiModelProperty(value = "父节点ID")
    private Long parentId;
    /**
     * nodePath
     */
    @ApiModelProperty(value = "节点地址")
    private String nodePath;
    /**
     * name
     */
    @ApiModelProperty(value = "项目名称")
    private String itemName;
    /**
     * code
     */
    @ApiModelProperty(value = "项目编码")
    private String itemCode;

    /**
     * Getter method for property <tt>itemList</tt>.
     *
     * @return property value of itemList
     */
    public List<TreeRsResult> getItemList() {
        return itemList;
    }

    /**
     * Setter method for property <tt>itemList</tt>.
     *
     * @param itemList value to be assigned to property itemList
     */
    public void setItemList(List<TreeRsResult> itemList) {
        this.itemList = itemList;
    }

    public boolean isHasChild() {
        return hasChild;
    }

    public void setHasChild(boolean hasChild) {
        this.hasChild = hasChild;
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
}
