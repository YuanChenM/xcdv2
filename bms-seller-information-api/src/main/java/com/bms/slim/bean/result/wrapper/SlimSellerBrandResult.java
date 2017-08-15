/*
 * 2017/01/12 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slim.bean.result.wrapper;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>表SLIM_SELLER_BRAND对应的实体SlimSellerBrand</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlimSellerBrandResult implements Serializable {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "卖家品牌ID")
    private Long sellerBrandId;
    @ApiModelProperty(value = "实体卖家ID")
    private Long entitySellerId;
    @ApiModelProperty(value = "品牌ID")
    private Long brandId;
    @ApiModelProperty(value = "品牌版权类型，1：自有品牌，2：代理品牌")
    private String copyrightType;
    @ApiModelProperty(value = "代理及分销授权合同号")
    private String agcyDistAuzContNo;
    @ApiModelProperty(value = "代理及分销授权合同URL")
    private String agcyDistAuzContUrl;
    @ApiModelProperty(value = "授权期开始时间")
    private Date startAuzDate;
    @ApiModelProperty(value = "授权期结束时间")
    private Date endAuzDate;
    @ApiModelProperty(value = "删除标识")
    private boolean delFlg;
    @ApiModelProperty(value = "创建Id")
    private String crtId;
    @ApiModelProperty(value = "创建时间")
    private Date crtTime;
    @ApiModelProperty(value = "更新Id")
    private String updId;
    @ApiModelProperty(value = "更新时间")
    private Date updTime;
    @ApiModelProperty(value = "版本号")
    private Integer version;


    /**
     * <p>默认构造函数</p>
     */
    public SlimSellerBrandResult() {
    }

    public Long getSellerBrandId() {
        return sellerBrandId;
    }

    public void setSellerBrandId(Long sellerBrandId) {
        this.sellerBrandId = sellerBrandId;
    }

    public Long getEntitySellerId() {
        return entitySellerId;
    }

    public void setEntitySellerId(Long entitySellerId) {
        this.entitySellerId = entitySellerId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
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

    public String getCopyrightType() {
        return copyrightType;
    }

    public void setCopyrightType(String copyrightType) {
        this.copyrightType = copyrightType;
    }

    public String getAgcyDistAuzContNo() {
        return agcyDistAuzContNo;
    }

    public void setAgcyDistAuzContNo(String agcyDistAuzContNo) {
        this.agcyDistAuzContNo = agcyDistAuzContNo;
    }

    public String getAgcyDistAuzContUrl() {
        return agcyDistAuzContUrl;
    }

    public void setAgcyDistAuzContUrl(String agcyDistAuzContUrl) {
        this.agcyDistAuzContUrl = agcyDistAuzContUrl;
    }

    public Date getStartAuzDate() {
        return startAuzDate;
    }

    public void setStartAuzDate(Date startAuzDate) {
        this.startAuzDate = startAuzDate;
    }

    public Date getEndAuzDate() {
        return endAuzDate;
    }

    public void setEndAuzDate(Date endAuzDate) {
        this.endAuzDate = endAuzDate;
    }
}
