package com.bms.slpd.bean.result.wrapper;


import com.bms.slpd.bean.entity.SlpdBrandOwner;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 品牌
 */
@ApiModel(value = "SlpdBrandResult",
        description = "品牌")
public class SlpdBrandResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "品牌ID")
    private Long brandId;
    @ApiModelProperty(value = "品牌编码")
    private String brandCode;
    @ApiModelProperty(value = "品牌名称")
    private String brandName;
    @ApiModelProperty(value = "品牌分类")
    private String brandType;
    @ApiModelProperty(value = "商标注册证号")
    private String trademarkRegNo;
    @ApiModelProperty(value = "有效期开始时间")
    private Date startValidDate;
    @ApiModelProperty(value = "有效期结束时间")
    private Date endValidDate;
    @ApiModelProperty(value = "品牌证书URL")
    private String brandCertUrl;
    @ApiModelProperty(value = "产品包装URL")
    private String productPackageUrl;
    @ApiModelProperty(value = "荣誉证书编号")
    private String honorCertNo;
    @ApiModelProperty(value = "荣誉证书发证日期")
    private Date honorCertDate;
    @ApiModelProperty(value = "荣誉证书发证单位")
    private String honorCertUnit;
    @ApiModelProperty(value = "荣誉证书URL")
    private String honorCertUrl;
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
    @ApiModelProperty(value = "审核状态，0：待审核，1：正式")
    private String auditStu;
    @ApiModelProperty(value = "审核备注")
    private String auditRemark;
    @ApiModelProperty(value = "审核履历，格式：0,未注册,admin,2017-01-25")
    private String auditHistory;
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

    @ApiModelProperty(value = "品牌所有人名称")
    private String ownersName;
    @ApiModelProperty(value = "品牌所有人集合")
    private List<SlpdBrandOwner> brandOwnerList;

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandType() {
        return brandType;
    }

    public void setBrandType(String brandType) {
        this.brandType = brandType;
    }

    public String getTrademarkRegNo() {
        return trademarkRegNo;
    }

    public void setTrademarkRegNo(String trademarkRegNo) {
        this.trademarkRegNo = trademarkRegNo;
    }

    public Date getStartValidDate() {
        return startValidDate;
    }

    public void setStartValidDate(Date startValidDate) {
        this.startValidDate = startValidDate;
    }

    public Date getEndValidDate() {
        return endValidDate;
    }

    public void setEndValidDate(Date endValidDate) {
        this.endValidDate = endValidDate;
    }

    public String getBrandCertUrl() {
        return brandCertUrl;
    }

    public void setBrandCertUrl(String brandCertUrl) {
        this.brandCertUrl = brandCertUrl;
    }

    public String getProductPackageUrl() {
        return productPackageUrl;
    }

    public void setProductPackageUrl(String productPackageUrl) {
        this.productPackageUrl = productPackageUrl;
    }

    public String getHonorCertNo() {
        return honorCertNo;
    }

    public void setHonorCertNo(String honorCertNo) {
        this.honorCertNo = honorCertNo;
    }

    public Date getHonorCertDate() {
        return honorCertDate;
    }

    public void setHonorCertDate(Date honorCertDate) {
        this.honorCertDate = honorCertDate;
    }

    public String getHonorCertUnit() {
        return honorCertUnit;
    }

    public void setHonorCertUnit(String honorCertUnit) {
        this.honorCertUnit = honorCertUnit;
    }

    public String getHonorCertUrl() {
        return honorCertUrl;
    }

    public void setHonorCertUrl(String honorCertUrl) {
        this.honorCertUrl = honorCertUrl;
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

    public String getAuditStu() {
        return auditStu;
    }

    public void setAuditStu(String auditStu) {
        this.auditStu = auditStu;
    }

    public String getAuditRemark() {
        return auditRemark;
    }

    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark;
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

    public String getOwnersName() {
        return ownersName;
    }

    public void setOwnersName(String ownersName) {
        this.ownersName = ownersName;
    }

    public List<SlpdBrandOwner> getBrandOwnerList() {
        return brandOwnerList;
    }

    public void setBrandOwnerList(List<SlpdBrandOwner> brandOwnerList) {
        this.brandOwnerList = brandOwnerList;
    }

    public String getAuditHistory() {
        return auditHistory;
    }

    public void setAuditHistory(String auditHistory) {
        this.auditHistory = auditHistory;
    }
}
