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
 *通用指标标准指标标准档案卡
 * @version 1.0.0
 */
public class SLPD0613IGnqStdParam implements Serializable {
    /** 序列号 */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "通用指标ID")
    private Long gnqStdId;
    @ApiModelProperty(value = "通用指标类型")
    private String gnqStdType;
    @ApiModelProperty(value = "品种ID")
    private Long breedId;
    @ApiModelProperty(value = "合格值")
    private String gnqOkVal;
    @ApiModelProperty(value = "不合格值")
    private String gnqNgVal;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "删除标识")
    private boolean delFlg;
    @ApiModelProperty(value = "版本号")
    private Integer version;

    public Long getGnqStdId() {
        return gnqStdId;
    }

    public void setGnqStdId(Long gnqStdId) {
        this.gnqStdId = gnqStdId;
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

    public String getGnqOkVal() {
        return gnqOkVal;
    }

    public void setGnqOkVal(String gnqOkVal) {
        this.gnqOkVal = gnqOkVal;
    }

    public String getGnqNgVal() {
        return gnqNgVal;
    }

    public void setGnqNgVal(String gnqNgVal) {
        this.gnqNgVal = gnqNgVal;
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
