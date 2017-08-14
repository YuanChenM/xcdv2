package com.bms.byim.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yuan_zhifei on 2016/1/10.
 */
@ApiModel(value = "MarketingStatusTreeRsResult", description = "返回集合")
public class MarketingStatusTreeRsResult implements Serializable {
    @ApiModelProperty(value = "输出参数list")
    private List<MarketingStatusTreeRsResult> itemList;
    @ApiModelProperty(value = "hasChild")
    public boolean hasChild;
    @ApiModelProperty(value = "买家上线状态ID")
    private Long marketingStatusId;
    @ApiModelProperty(value = "父节点ID")
    private Long parentId;
    @ApiModelProperty(value = "节点地址")
    private String nodePath;
    @ApiModelProperty(value = "上线状态名称")
    private String marketingStatusName;
    @ApiModelProperty(value = "上线状态编码")
    private String marketingStatusCode;

    public List<MarketingStatusTreeRsResult> getItemList() {
        return itemList;
    }

    public void setItemList(List<MarketingStatusTreeRsResult> itemList) {
        this.itemList = itemList;
    }

    public boolean isHasChild() {
        return hasChild;
    }

    public void setHasChild(boolean hasChild) {
        this.hasChild = hasChild;
    }

    public Long getMarketingStatusId() {
        return marketingStatusId;
    }

    public void setMarketingStatusId(Long marketingStatusId) {
        this.marketingStatusId = marketingStatusId;
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

    public String getMarketingStatusName() {
        return marketingStatusName;
    }

    public void setMarketingStatusName(String marketingStatusName) {
        this.marketingStatusName = marketingStatusName;
    }

    public String getMarketingStatusCode() {
        return marketingStatusCode;
    }

    public void setMarketingStatusCode(String marketingStatusCode) {
        this.marketingStatusCode = marketingStatusCode;
    }
}
