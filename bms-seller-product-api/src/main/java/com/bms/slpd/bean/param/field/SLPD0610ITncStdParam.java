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
 *加工质量标准指标标准档案卡
 * @version 1.0.0
 */
public class SLPD0610ITncStdParam implements Serializable {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "加工质量ID")
    private Long tncStdId;
    @ApiModelProperty(value = "加工质量类型")
    private Long tncStdType;
    @ApiModelProperty(value = "品种ID")
    private Long breedId;
    @ApiModelProperty(value = "A1级质量标准")
    private String tncStdValA;
    @ApiModelProperty(value = "A2级质量标准")
    private String tncStdValB;
    @ApiModelProperty(value = "A3级质量标准")
    private String tncStdValC;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "删除标识")
    private boolean delFlg;
    @ApiModelProperty(value = "版本号")
    private Integer version;

    public Long getTncStdId() {
        return tncStdId;
    }

    public void setTncStdId(Long tncStdId) {
        this.tncStdId = tncStdId;
    }

    public Long getTncStdType() {
        return tncStdType;
    }

    public void setTncStdType(Long tncStdType) {
        this.tncStdType = tncStdType;
    }

    public Long getBreedId() {
        return breedId;
    }

    public void setBreedId(Long breedId) {
        this.breedId = breedId;
    }

    public String getTncStdValA() {
        return tncStdValA;
    }

    public void setTncStdValA(String tncStdValA) {
        this.tncStdValA = tncStdValA;
    }

    public String getTncStdValB() {
        return tncStdValB;
    }

    public void setTncStdValB(String tncStdValB) {
        this.tncStdValB = tncStdValB;
    }

    public String getTncStdValC() {
        return tncStdValC;
    }

    public void setTncStdValC(String tncStdValC) {
        this.tncStdValC = tncStdValC;
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
