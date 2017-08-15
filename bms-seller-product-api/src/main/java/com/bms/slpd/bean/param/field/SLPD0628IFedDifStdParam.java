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
 *原种饲养标准指标标准档案卡
 * @version 1.0.0
 */
public class SLPD0628IFedDifStdParam implements Serializable {
    /** 序列号 */
    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "饲养ID")
    private Long fedDifStdId;
    @ApiModelProperty(value = "饲养类型")
    private Long fedStdType;
    @ApiModelProperty(value = "品种ID")
    private Long breedId;
    @ApiModelProperty(value = "产品Id")
    private String productId;
    @ApiModelProperty(value = "优良差异值")
    private String fedGoodDifVal;
    @ApiModelProperty(value = "一般差异值")
    private String fedNormalDifVal;
    @ApiModelProperty(value = "合格差异值")
    private String fedOkDifVal;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "删除标识")
    private boolean delFlg;
    @ApiModelProperty(value = "版本号")
    private Integer version;


    public Long getFedDifStdId() {
        return fedDifStdId;
    }

    public void setFedDifStdId(Long fedDifStdId) {
        this.fedDifStdId = fedDifStdId;
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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getFedGoodDifVal() {
        return fedGoodDifVal;
    }

    public void setFedGoodDifVal(String fedGoodDifVal) {
        this.fedGoodDifVal = fedGoodDifVal;
    }

    public String getFedNormalDifVal() {
        return fedNormalDifVal;
    }

    public void setFedNormalDifVal(String fedNormalDifVal) {
        this.fedNormalDifVal = fedNormalDifVal;
    }

    public String getFedOkDifVal() {
        return fedOkDifVal;
    }

    public void setFedOkDifVal(String fedOkDifVal) {
        this.fedOkDifVal = fedOkDifVal;
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
