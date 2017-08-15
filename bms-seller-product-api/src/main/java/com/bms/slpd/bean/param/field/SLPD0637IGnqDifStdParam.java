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
 *通用指标标准指标差异卡
 * @version 1.0.0
 */
public class SLPD0637IGnqDifStdParam implements Serializable {
    /** 序列号 */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "通用指标ID")
    private Long gnqDifStdId;
    @ApiModelProperty(value = "通用指标类型ID")
    private String gnqStdType;
    @ApiModelProperty(value = "品种ID")
    private Long breedId;
    @ApiModelProperty(value = "产品ID")
    private String productId;
    @ApiModelProperty(value = "合格差异值")
    private String gnqOkDifVal;
    @ApiModelProperty(value = "不合格差异值")
    private String gnqNgDifVal;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "删除标识")
    private boolean delFlg;
    @ApiModelProperty(value = "版本号")
    private Integer version;


    public Long getGnqDifStdId() {
        return gnqDifStdId;
    }

    public void setGnqDifStdId(Long gnqDifStdId) {
        this.gnqDifStdId = gnqDifStdId;
    }

    public String getGnqStdType() {
        return gnqStdType;
    }

    public void setGnqStdType(String gnqStdType) {
        this.gnqStdType = gnqStdType;
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

    public String getGnqOkDifVal() {
        return gnqOkDifVal;
    }

    public void setGnqOkDifVal(String gnqOkDifVal) {
        this.gnqOkDifVal = gnqOkDifVal;
    }

    public String getGnqNgDifVal() {
        return gnqNgDifVal;
    }

    public void setGnqNgDifVal(String gnqNgDifVal) {
        this.gnqNgDifVal = gnqNgDifVal;
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
