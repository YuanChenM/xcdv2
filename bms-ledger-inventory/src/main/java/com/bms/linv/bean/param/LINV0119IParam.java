package com.bms.linv.bean.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zheng_xu on 2017/5/18.
 */
public class LINV0119IParam implements Serializable {
    public static String TRANSACTION_TYPE = "119";
    @ApiModelProperty(value = "物流区Id")
    private Long lgcsId;
    @ApiModelProperty(value = "物流区编码")
    private String lgcsCode;
    @ApiModelProperty(value = "货权人Id")
    private String ownerId;
    @ApiModelProperty(value = "货权人编码")
    private String ownerCode;
    @ApiModelProperty(value = "货权人类型")
    private String ownerType;
    @ApiModelProperty(value = "调整时间")
    private String adjustDate;
    @ApiModelProperty(value = "调整操作人")
    private String adjustPerson;
    @ApiModelProperty(value = "调整备注")
    private String adjustRemark;
    @ApiModelProperty(value = "商品列表")
    private List<LINV0119ICommodityParam> commodityList;

    public Long getLgcsId() {
        return lgcsId;
    }

    public void setLgcsId(Long lgcsId) {
        this.lgcsId = lgcsId;
    }

    public String getLgcsCode() {
        return lgcsCode;
    }

    public void setLgcsCode(String lgcsCode) {
        this.lgcsCode = lgcsCode;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerCode() {
        return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public String getAdjustDate() {
        return adjustDate;
    }

    public void setAdjustDate(String adjustDate) {
        this.adjustDate = adjustDate;
    }

    public String getAdjustPerson() {
        return adjustPerson;
    }

    public void setAdjustPerson(String adjustPerson) {
        this.adjustPerson = adjustPerson;
    }

    public String getAdjustRemark() {
        return adjustRemark;
    }

    public void setAdjustRemark(String adjustRemark) {
        this.adjustRemark = adjustRemark;
    }

    public List<LINV0119ICommodityParam> getCommodityList() {
        return commodityList;
    }

    public void setCommodityList(List<LINV0119ICommodityParam> commodityList) {
        this.commodityList = commodityList;
    }
}
