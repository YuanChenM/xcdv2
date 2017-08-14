package com.bms.byim.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author zhao_chen
 * @version 1.0
 */
@ApiModel(value = "StandardGradeRsParam", description = "买家定性评级标准接口参数")
public class StandardGradeRsParam extends BaseRestPaginationParam {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = " GRADE_STANDARD_ID")
    private Long gradeStandardId;
    @ApiModelProperty(value = " GRADE_STANDARD ")
    private String gradeStandard;
    @ApiModelProperty(value = " 任一单品量级 ")
    private Integer singelAmount;
    @ApiModelProperty(value = "所有单品量级")
    private Integer allAmount;
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

    public Long getGradeStandardId() {
        return gradeStandardId;
    }

    public void setGradeStandardId(Long gradeStandardId) {
        this.gradeStandardId = gradeStandardId;
    }

    public String getGradeStandard() {
        return gradeStandard;
    }

    public void setGradeStandard(String gradeStandard) {
        this.gradeStandard = gradeStandard;
    }

    public Integer getSingelAmount() {
        return singelAmount;
    }

    public void setSingelAmount(Integer singelAmount) {
        this.singelAmount = singelAmount;
    }

    public Integer getAllAmount() {
        return allAmount;
    }

    public void setAllAmount(Integer allAmount) {
        this.allAmount = allAmount;
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
