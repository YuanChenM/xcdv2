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
public class SLPD0643ITspDifStdParam implements Serializable {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键ID")
    private Long tspDifStdId;
    @ApiModelProperty(value = "存储运输类型")
    private String tspStdType;
    @ApiModelProperty(value = "品种ID")
    private Long breedId;
    @ApiModelProperty(value = "产品ID")
    private String productId;
    @ApiModelProperty(value = "合格差异值")
    private String tspOkDifVal;
    @ApiModelProperty(value = "不合格差异值")
    private String tspNgDifVal;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "删除标识")
    private boolean delFlg;
    @ApiModelProperty(value = "版本号")
    private Integer version;

    public Long getTspDifStdId() {
        return tspDifStdId;
    }

    public void setTspDifStdId(Long tspDifStdId) {
        this.tspDifStdId = tspDifStdId;
    }

    public String getTspStdType() {
        return tspStdType;
    }

    public void setTspStdType(String tspStdType) {
        this.tspStdType = tspStdType;
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

    public String getTspOkDifVal() {
        return tspOkDifVal;
    }

    public void setTspOkDifVal(String tspOkDifVal) {
        this.tspOkDifVal = tspOkDifVal;
    }

    public String getTspNgDifVal() {
        return tspNgDifVal;
    }

    public void setTspNgDifVal(String tspNgDifVal) {
        this.tspNgDifVal = tspNgDifVal;
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
