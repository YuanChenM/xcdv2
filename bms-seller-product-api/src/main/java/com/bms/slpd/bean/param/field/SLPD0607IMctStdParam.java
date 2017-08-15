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
 *加工技术标准指标标准档案卡
 * @version 1.0.0
 */
public class SLPD0607IMctStdParam implements Serializable {
    /** 序列号 */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "加工技术ID")
    private Long mctStdId;
    @ApiModelProperty(value = "加工技术类型")
    private Long mctStdType;
    @ApiModelProperty(value = "品种ID")
    private Long breedId;
    @ApiModelProperty(value = "合格值")
    private String mctOkVal;
    @ApiModelProperty(value = "不合格值")
    private String mctNgVal;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "删除标识")
    private boolean delFlg;
    @ApiModelProperty(value = "版本号")
    private Integer version;

    public Long getMctStdId() {
        return mctStdId;
    }

    public void setMctStdId(Long mctStdId) {
        this.mctStdId = mctStdId;
    }

    public Long getMctStdType() {
        return mctStdType;
    }

    public void setMctStdType(Long mctStdType) {
        this.mctStdType = mctStdType;
    }

    public Long getBreedId() {
        return breedId;
    }

    public void setBreedId(Long breedId) {
        this.breedId = breedId;
    }

    public String getMctOkVal() {
        return mctOkVal;
    }

    public void setMctOkVal(String mctOkVal) {
        this.mctOkVal = mctOkVal;
    }

    public String getMctNgVal() {
        return mctNgVal;
    }

    public void setMctNgVal(String mctNgVal) {
        this.mctNgVal = mctNgVal;
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
