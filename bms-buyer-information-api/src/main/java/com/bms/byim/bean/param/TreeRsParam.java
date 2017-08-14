package com.bms.byim.bean.param;


import com.framework.base.rest.param.BaseRestParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by yuan_chen1 on 2016/12/26.
 *
 */
@ApiModel(value = "treeRsParam", description = "树形查询Param")
public class TreeRsParam extends BaseRestParam {

    @ApiModelProperty(value = "项目ID")
    private Long itemId;
    @ApiModelProperty(value = "父节点ID")
    private Long parentId;
    @ApiModelProperty(value = "节点地址")
    private String nodePath;
    @ApiModelProperty(value = "项目名称")
    private String itemName;
    @ApiModelProperty(value = "项目编码")
    private String itemCode;
    @ApiModelProperty(value = "删除标志")
    private boolean delFlg;

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

    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
        this.delFlg = delFlg;
    }
}
