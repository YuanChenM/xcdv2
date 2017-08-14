package com.bms.como.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by yuan_zhifei on 2017/3/27.
 */
@ApiModel(value = "SaleStatusRsParam", description = "销售状态信息参数")
public class SaleStatusRsParam extends BaseRestPaginationParam {
    @ApiModelProperty(value = "销售状态ID")
    private Long saleStatusId;
    @ApiModelProperty(value = "销售状态编码")
    private String saleStatusCode;
    @ApiModelProperty(value = "销售状态名称")
    private String saleStatusName;
    @ApiModelProperty(value = "是否默认")
    private boolean isDefault;
    @ApiModelProperty(value = "是否有效")
    private boolean isValid;
    @ApiModelProperty(value = "删除标识")
    private boolean delFlg;
    @ApiModelProperty(value = "版本号")
    private Integer version;
    @ApiModelProperty(value = "销售状态ID数组")
    private Long[] saleStatusIds;
    @ApiModelProperty(value = "创建者ID")
    private String crtId;
    @ApiModelProperty(value = "创建日时")
    private Date crtTime;
    @ApiModelProperty(value = "更新者ID")
    private String updId;
    @ApiModelProperty(value = "更新日时")
    private Date updTime;
    @ApiModelProperty(value = "check返回参数(-1:销售状态编码已存在！-2:销售状态名称已存在！)")
    private int result;

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

    public Long getSaleStatusId() {
        return saleStatusId;
    }

    public void setSaleStatusId(Long saleStatusId) {
        this.saleStatusId = saleStatusId;
    }

    public String getSaleStatusCode() {
        return saleStatusCode;
    }

    public void setSaleStatusCode(String saleStatusCode) {
        this.saleStatusCode = saleStatusCode;
    }

    public String getSaleStatusName() {
        return saleStatusName;
    }

    public void setSaleStatusName(String saleStatusName) {
        this.saleStatusName = saleStatusName;
    }

    public boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }

    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
        this.delFlg = delFlg;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Long[] getSaleStatusIds() {
        return saleStatusIds;
    }

    public void setSaleStatusIds(Long[] saleStatusIds) {
        this.saleStatusIds = saleStatusIds;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
