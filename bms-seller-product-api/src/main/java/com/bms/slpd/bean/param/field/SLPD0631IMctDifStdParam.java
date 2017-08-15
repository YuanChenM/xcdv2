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
 *加工技术标准指标标准差异卡
 * @version 1.0.0
 */
public class SLPD0631IMctDifStdParam implements Serializable {
    /** 序列号 */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "加工技术标准指标表ID")
    private Long mctDifStdId;
    @ApiModelProperty(value = "加工技术标准类型")
    private Long mctStdType;
    @ApiModelProperty(value = "品种ID")
    private Long breedId;
    @ApiModelProperty(value = "产品ID")
    private String productId;
    @ApiModelProperty(value = "合格差异值")
    private String mctOkDifVal;
    @ApiModelProperty(value = "不合格差异值")
    private String mctNgDifVal;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "删除标志")
    private boolean delFlg;
    @ApiModelProperty(value = "版本号")
    private Integer version;


    public Long getMctDifStdId() {
        return mctDifStdId;
    }

    public void setMctDifStdId(Long mctDifStdId) {
        this.mctDifStdId = mctDifStdId;
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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getMctOkDifVal() {
        return mctOkDifVal;
    }

    public void setMctOkDifVal(String mctOkDifVal) {
        this.mctOkDifVal = mctOkDifVal;
    }

    public String getMctNgDifVal() {
        return mctNgDifVal;
    }

    public void setMctNgDifVal(String mctNgDifVal) {
        this.mctNgDifVal = mctNgDifVal;
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
