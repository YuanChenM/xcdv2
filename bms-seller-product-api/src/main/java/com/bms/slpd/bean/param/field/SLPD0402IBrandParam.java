/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.param.field;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
public class SLPD0402IBrandParam implements Serializable {
    /** 序列号 */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "品牌ID")
    private Long brandId;
    @ApiModelProperty(value = "品牌编码")
    private String brandCode;
    @ApiModelProperty(value = "品牌名称")
    private String brandName;
    @ApiModelProperty(value = "品牌类型")
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
    @ApiModelProperty(value = "审核状态，0：待审核，1：正式")
    private Boolean auditStu;
    @ApiModelProperty(value = "删除标志")
    private boolean delFlg;
    @ApiModelProperty(value = "版本号")
    private Integer version;


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

    public Boolean getAuditStu() {
        return auditStu;
    }

    public void setAuditStu(Boolean auditStu) {
        this.auditStu = auditStu;
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
}
