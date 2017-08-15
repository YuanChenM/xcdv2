/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.param.field;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>表SLPD_ORG_STD对应的实体SlpdOrgStd</p>
 *
 * @version 1.0.0
 */
public class SLPD0625IOrgDifStdParam implements Serializable {
    /** 序列号 */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "原种种源ID")
    private Long orgDifStdId;
    @ApiModelProperty(value = "原种种源类型")
    private Long orgStdType;
    @ApiModelProperty(value = "品种ID")
    private Long breedId;
    @ApiModelProperty(value = "产品ID")
    private String productId;
    @ApiModelProperty(value = "优良差异值")
    private String orgGoodDifVal;
    @ApiModelProperty(value = "一般差异值")
    private String orgNormalDifVal;
    @ApiModelProperty(value = "合格差异值")
    private String orgOkDifVal;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "删除标识")
    private boolean delFlg;
    @ApiModelProperty(value = "版本号")
    private Integer version;


    public Long getOrgDifStdId() {
        return orgDifStdId;
    }

    public void setOrgDifStdId(Long orgDifStdId) {
        this.orgDifStdId = orgDifStdId;
    }

    public Long getOrgStdType() {
        return orgStdType;
    }

    public void setOrgStdType(Long orgStdType) {
        this.orgStdType = orgStdType;
    }

    public Long getBreedId() {
        return breedId;
    }

    public void setBreedId(Long breedId) {
        this.breedId = breedId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getOrgGoodDifVal() {
        return orgGoodDifVal;
    }

    public void setOrgGoodDifVal(String orgGoodDifVal) {
        this.orgGoodDifVal = orgGoodDifVal;
    }

    public String getOrgNormalDifVal() {
        return orgNormalDifVal;
    }

    public void setOrgNormalDifVal(String orgNormalDifVal) {
        this.orgNormalDifVal = orgNormalDifVal;
    }

    public String getOrgOkDifVal() {
        return orgOkDifVal;
    }

    public void setOrgOkDifVal(String orgOkDifVal) {
        this.orgOkDifVal = orgOkDifVal;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
