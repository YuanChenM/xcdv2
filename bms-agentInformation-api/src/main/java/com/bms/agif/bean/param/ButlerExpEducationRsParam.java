/*
 * 2017/03/01 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.agif.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "ButlerExpEducationRsParam", description = "买手教育经历参数类")
public class ButlerExpEducationRsParam extends BaseRestPaginationParam {
    @ApiModelProperty(value = " 序列号 ")
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = " EDUCATION_EXP_ID ")
    private Long educationExpId;
    @ApiModelProperty(value = " BUTLER_ID ")
    private String butlerId;
    @ApiModelProperty(value = "管家编码")
    private String butlerCode;
    @ApiModelProperty(value = " EXP_START ")
    private java.util.Date expStart;
    @ApiModelProperty(value = " EXP_END ")
    private java.util.Date expEnd;
    @ApiModelProperty(value = " SCHOOL ")
    private String school;
    @ApiModelProperty(value = " EDUCATION ")
    private String education;
    @ApiModelProperty(value = " DEGREE ")
    private String degree;
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

    public Long getEducationExpId() {
        return educationExpId;
    }

    public void setEducationExpId(Long educationExpId) {
        this.educationExpId = educationExpId;
    }

    public String getButlerId() {
        return butlerId;
    }

    public void setButlerId(String butlerId) {
        this.butlerId = butlerId;
    }

    public Date getExpStart() {
        return expStart;
    }

    public void setExpStart(Date expStart) {
        this.expStart = expStart;
    }

    public Date getExpEnd() {
        return expEnd;
    }

    public void setExpEnd(Date expEnd) {
        this.expEnd = expEnd;
    }

    public String getSchool() {
        return school;
    }

    public String getButlerCode() {
        return butlerCode;
    }

    public void setButlerCode(String butlerCode) {
        this.butlerCode = butlerCode;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
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
