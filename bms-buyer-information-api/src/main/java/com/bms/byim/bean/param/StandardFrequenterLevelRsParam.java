package com.bms.byim.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author zhao_chen
 * @version 1.0
 */
@ApiModel(value = "StandardFrequenterLevelRsParam", description = "常客买家定级标准接口参数")
public class StandardFrequenterLevelRsParam extends BaseRestPaginationParam {
    @ApiModelProperty(value = " 序列号")
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = " LEVEL_STANDARD_ID")
    private Long levelStandardId;
    @ApiModelProperty(value = " LEVEL_STANDARD ")
    private String levelStandard;
    @ApiModelProperty(value = " 单位：单 ")
    private Integer minFrequency;
    @ApiModelProperty(value = " 单位：单 ")
    private Integer maxFrequency;
    @ApiModelProperty(value = " 单位：箱 ")
    private Integer minAmount;
    @ApiModelProperty(value = " 单位：箱")
    private Integer maxAmount;
    @ApiModelProperty(value = "删除标志")
    private Boolean delFlg;
    @ApiModelProperty(value = "创建者")
    private String crtId;
    @ApiModelProperty(value = "创建时间")
    private Date crtTime;
    @ApiModelProperty(value = "更新着")
    private String updId;
    @ApiModelProperty(value = "更新时间")
    private Date updTime;
    @ApiModelProperty(value = "版本号")
    private Integer version;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getLevelStandardId() {
        return levelStandardId;
    }

    public void setLevelStandardId(Long levelStandardId) {
        this.levelStandardId = levelStandardId;
    }

    public String getLevelStandard() {
        return levelStandard;
    }

    public void setLevelStandard(String levelStandard) {
        this.levelStandard = levelStandard;
    }

    public Integer getMinFrequency() {
        return minFrequency;
    }

    public void setMinFrequency(Integer minFrequency) {
        this.minFrequency = minFrequency;
    }

    public Integer getMaxFrequency() {
        return maxFrequency;
    }

    public void setMaxFrequency(Integer maxFrequency) {
        this.maxFrequency = maxFrequency;
    }

    public Integer getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Integer minAmount) {
        this.minAmount = minAmount;
    }

    public Integer getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Integer maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    public String getCrtId() {
        return crtId;
    }

    public void setCrtId(String crtId) {
        this.crtId = crtId;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public String getUpdId() {
        return updId;
    }

    public void setUpdId(String updId) {
        this.updId = updId;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
