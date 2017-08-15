package com.bms.slpd.bean.param.field;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class SLPD0601IFedStdParam implements Serializable {
    /** 序列号 */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "饲养标准ID")
    private Long fedStdId;
    @ApiModelProperty(value = "饲养类型")
    private Long fedStdType;
    @ApiModelProperty(value = "品种ID")
    private Long breedId;
    @ApiModelProperty(value = "优良值")
    private String fedGoodVal;
    @ApiModelProperty(value = "一般值")
    private String fedNormalVal;
    @ApiModelProperty(value = "合格")
    private String fedOkVal;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "删除标识")
    private boolean delFlg;
    @ApiModelProperty(value = "版本号")
    private Integer version;

    public Long getFedStdId() {
        return fedStdId;
    }

    public void setFedStdId(Long fedStdId) {
        this.fedStdId = fedStdId;
    }

    public Long getFedStdType() {
        return fedStdType;
    }

    public void setFedStdType(Long fedStdType) {
        this.fedStdType = fedStdType;
    }

    public Long getBreedId() {
        return breedId;
    }

    public void setBreedId(Long breedId) {
        this.breedId = breedId;
    }

    public String getFedGoodVal() {
        return fedGoodVal;
    }

    public void setFedGoodVal(String fedGoodVal) {
        this.fedGoodVal = fedGoodVal;
    }

    public String getFedNormalVal() {
        return fedNormalVal;
    }

    public void setFedNormalVal(String fedNormalVal) {
        this.fedNormalVal = fedNormalVal;
    }

    public String getFedOkVal() {
        return fedOkVal;
    }

    public void setFedOkVal(String fedOkVal) {
        this.fedOkVal = fedOkVal;
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
