/*
 * 2016/12/06 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.byim.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by yuan_zhifei on 2016/12/8.
 */
@ApiModel(value = "MarketingStatusRsParam", description = "买家上线状态参数")
public class MarketingStatusRsParam implements Serializable {
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
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;

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

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }
}

