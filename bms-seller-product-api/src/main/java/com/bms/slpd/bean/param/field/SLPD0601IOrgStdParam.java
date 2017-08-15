
package com.bms.slpd.bean.param.field;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class SLPD0601IOrgStdParam implements Serializable {
    /** 序列号 */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "原种种源ID")
    private Long orgStdId;
    @ApiModelProperty(value = "原种种源类型ID")
    private Long orgStdType;
    @ApiModelProperty(value = "品种ID")
    private Long breedId;
    @ApiModelProperty(value = "优良值")
    private String orgGoodVal;
    @ApiModelProperty(value = "一般值")
    private String orgNormalVal;
    @ApiModelProperty(value = "合格")
    private String orgOkVal;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "删除标识")
    private boolean delFlg;
    @ApiModelProperty(value = "版本号")
    private Integer version;


    public Long getOrgStdId() {
        return orgStdId;
    }

    public void setOrgStdId(Long orgStdId) {
        this.orgStdId = orgStdId;
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

    public String getOrgGoodVal() {
        return orgGoodVal;
    }

    public void setOrgGoodVal(String orgGoodVal) {
        this.orgGoodVal = orgGoodVal;
    }

    public String getOrgNormalVal() {
        return orgNormalVal;
    }

    public void setOrgNormalVal(String orgNormalVal) {
        this.orgNormalVal = orgNormalVal;
    }

    public String getOrgOkVal() {
        return orgOkVal;
    }

    public void setOrgOkVal(String orgOkVal) {
        this.orgOkVal = orgOkVal;
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
