package com.bms.slpd.bean.param.field;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 *加工技术标准指标标准差异卡
 * @version 1.0.0
 */
public class SLPD0634ITncDifStdParam implements Serializable {
    /** 序列号 */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "加工质量ID")
    private Long tncDifStdId;
    @ApiModelProperty(value = "加工质量类型")
    private Long tncStdType;
    @ApiModelProperty(value = "品种ID")
    private Long breedId;
    @ApiModelProperty(value = "产品ID")
    private String productId;
    @ApiModelProperty(value = "A1级质量标准差异值")
    private String tncStdDifValA;
    @ApiModelProperty(value = "A2级质量标准差异值")
    private String tncStdDifValB;
    @ApiModelProperty(value = "A3级质量标准差异值")
    private String tncStdDifValC;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "删除标识")
    private boolean delFlg;
    @ApiModelProperty(value = "版本号")
    private Integer version;


    public Long getTncDifStdId() {
        return tncDifStdId;
    }

    public void setTncDifStdId(Long tncDifStdId) {
        this.tncDifStdId = tncDifStdId;
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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTncStdDifValA() {
        return tncStdDifValA;
    }

    public void setTncStdDifValA(String tncStdDifValA) {
        this.tncStdDifValA = tncStdDifValA;
    }

    public String getTncStdDifValB() {
        return tncStdDifValB;
    }

    public void setTncStdDifValB(String tncStdDifValB) {
        this.tncStdDifValB = tncStdDifValB;
    }

    public String getTncStdDifValC() {
        return tncStdDifValC;
    }

    public void setTncStdDifValC(String tncStdDifValC) {
        this.tncStdDifValC = tncStdDifValC;
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
