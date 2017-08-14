package com.bms.byim.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by yuan_zhifei on 2017/3/21.
 */
@ApiModel(value = "GradeRsParam", description = "买家定性评级信息参数")
public class GradeRsParam extends BaseRestPaginationParam {
    @ApiModelProperty(value = "定性评级ID")
    private Long gradeId;
    @ApiModelProperty(value = "买家ID")
    private String buyerId;
    @ApiModelProperty(value = "买家编码")
    private String buyerCode;
    @ApiModelProperty(value = "定性评级")
    private String grade;
    @ApiModelProperty(value = "任一单品量级")
    private String singelAmount;
    @ApiModelProperty(value = "所有单品量级")
    private String allAmount;
    @ApiModelProperty(value = "日期")
    private Date crtTime;

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerCode() {
        return buyerCode;
    }

    public void setBuyerCode(String buyerCode) {
        this.buyerCode = buyerCode;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSingelAmount() {
        return singelAmount;
    }

    public void setSingelAmount(String singelAmount) {
        this.singelAmount = singelAmount;
    }

    public String getAllAmount() {
        return allAmount;
    }

    public void setAllAmount(String allAmount) {
        this.allAmount = allAmount;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }
}
