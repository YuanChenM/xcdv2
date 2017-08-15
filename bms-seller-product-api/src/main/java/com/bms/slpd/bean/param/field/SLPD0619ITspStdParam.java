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
public class SLPD0619ITspStdParam implements Serializable {
    /** 序列号 */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "存储运输ID")
    private Long tspStdId;
    @ApiModelProperty(value = "存储运输类型")
    private String tspStdType;
    @ApiModelProperty(value = "品种ID")
    private Long breedId;
    @ApiModelProperty(value = "合格值")
    private String tspOkVal;
    @ApiModelProperty(value = "不合格值")
    private String tspNgVal;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "删除标识")
    private boolean delFlg;
    @ApiModelProperty(value = "版本号")
    private Integer version;


    public Long getTspStdId() {
        return tspStdId;
    }

    public void setTspStdId(Long tspStdId) {
        this.tspStdId = tspStdId;
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

    public String getTspOkVal() {
        return tspOkVal;
    }

    public void setTspOkVal(String tspOkVal) {
        this.tspOkVal = tspOkVal;
    }

    public String getTspNgVal() {
        return tspNgVal;
    }

    public void setTspNgVal(String tspNgVal) {
        this.tspNgVal = tspNgVal;
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
