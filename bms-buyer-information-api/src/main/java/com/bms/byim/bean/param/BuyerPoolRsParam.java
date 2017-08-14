package com.bms.byim.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author zhou_yajun
 * @version 1.0
 */
@ApiModel(value = "BuyerPoolRsParam", description = "物流区分类买家池JavaBean")
public class BuyerPoolRsParam extends BaseRestPaginationParam {
    @ApiModelProperty(value = "买家池ID")
    private Long buyerPoolId;
    @ApiModelProperty(value = "物流区编码")
    private String lgcsAreaCode;
    @ApiModelProperty(value = "物流区名称")
    private String lgcsAreaName;
    @ApiModelProperty(value = "买家类型")
    private String buyerType;
    @ApiModelProperty(value = "买家类型名称")
    private String buyerTypeName;
    @ApiModelProperty(value = "买家一级分类")
    private String buyerFirstCategory;
    @ApiModelProperty(value = "买家一级分类名称")
    private String buyerFirstCategoryName;
    @ApiModelProperty(value = "买家二级分类")
    private String buyerSubCategory;
    @ApiModelProperty(value = "买家二级分类名称")
    private String buyerSubCategoryName;
    @ApiModelProperty(value = "买家池编码")
    private String buyerPoolCode;
    @ApiModelProperty(value = "买家池名称")
    private String buyerPoolName;
    private boolean delFlg;
    private String crtId;
    private Date crtTime;
    private String updId;
    private Date updTime;
    private Integer version;
    @ApiModelProperty(value = "判断checkBox是否选中")
    private String checkedFlag;

    public String getCheckedFlag() {
        return checkedFlag;
    }

    public void setCheckedFlag(String checkedFlag) {
        this.checkedFlag = checkedFlag;
    }

    public Long getBuyerPoolId() {
        return buyerPoolId;
    }

    public void setBuyerPoolId(Long buyerPoolId) {
        this.buyerPoolId = buyerPoolId;
    }

    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }

    public String getBuyerType() {
        return buyerType;
    }

    public void setBuyerType(String buyerType) {
        this.buyerType = buyerType;
    }

    public String getBuyerFirstCategory() {
        return buyerFirstCategory;
    }

    public void setBuyerFirstCategory(String buyerFirstCategory) {
        this.buyerFirstCategory = buyerFirstCategory;
    }

    public String getBuyerSubCategory() {
        return buyerSubCategory;
    }

    public void setBuyerSubCategory(String buyerSubCategory) {
        this.buyerSubCategory = buyerSubCategory;
    }

    public String getBuyerPoolCode() {
        return buyerPoolCode;
    }

    public void setBuyerPoolCode(String buyerPoolCode) {
        this.buyerPoolCode = buyerPoolCode;
    }

    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

    public void setLgcsAreaName(String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }

    public String getBuyerFirstCategoryName() {
        return buyerFirstCategoryName;
    }

    public void setBuyerFirstCategoryName(String buyerFirstCategoryName) {
        this.buyerFirstCategoryName = buyerFirstCategoryName;
    }

    public String getBuyerSubCategoryName() {
        return buyerSubCategoryName;
    }

    public void setBuyerSubCategoryName(String buyerSubCategoryName) {
        this.buyerSubCategoryName = buyerSubCategoryName;
    }

    public String getBuyerPoolName() {
        return buyerPoolName;
    }

    public void setBuyerPoolName(String buyerPoolName) {
        this.buyerPoolName = buyerPoolName;
    }

    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
        this.delFlg = delFlg;
    }

    public String getCrtId() {
        return crtId;
    }

    public void setCrtId(String crtId) {
        this.crtId = crtId;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public String getUpdId() {
        return updId;
    }

    public void setUpdId(String updId) {
        this.updId = updId;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getBuyerTypeName() {
        return buyerTypeName;
    }

    public void setBuyerTypeName(String buyerTypeName) {
        this.buyerTypeName = buyerTypeName;
    }
}
