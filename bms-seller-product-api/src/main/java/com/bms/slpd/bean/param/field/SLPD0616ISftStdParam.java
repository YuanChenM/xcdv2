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
public class SLPD0616ISftStdParam implements Serializable {
    /** 序列号 */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "安全指标ID")
    private Long sftStdId;
    @ApiModelProperty(value = "安全指标类型")
    private String sftStdType;
    @ApiModelProperty(value = "品种ID")
    private Long breedId;
    @ApiModelProperty(value = "合格值")
    private String sftOkVal;
    @ApiModelProperty(value = "不合格值")
    private String sftNgVal;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "删除标识")
    private boolean delFlg;
    @ApiModelProperty(value = "版本号")
    private Integer version;

    public Long getSftStdId() {
        return sftStdId;
    }

    public void setSftStdId(Long sftStdId) {
        this.sftStdId = sftStdId;
    }

    public String getSftStdType() {
        return sftStdType;
    }

    public void setSftStdType(String sftStdType) {
        this.sftStdType = sftStdType;
    }

    public Long getBreedId() {
        return breedId;
    }

    public void setBreedId(Long breedId) {
        this.breedId = breedId;
    }

    public String getSftOkVal() {
        return sftOkVal;
    }

    public void setSftOkVal(String sftOkVal) {
        this.sftOkVal = sftOkVal;
    }

    public String getSftNgVal() {
        return sftNgVal;
    }

    public void setSftNgVal(String sftNgVal) {
        this.sftNgVal = sftNgVal;
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
