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

@ApiModel(value = "ButlerExpTrainingRsParam", description = "买手培训经历")
public class ButlerExpTrainingRsParam extends BaseRestPaginationParam {
    @ApiModelProperty(value = "序列号 ")
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "TRAINING_EXP_ID")
    private Long trainingExpId;
    @ApiModelProperty(value = "BUTLER_ID")
    private String butlerId;
    @ApiModelProperty(value = "管家编码")
    private String butlerCode;
    @ApiModelProperty(value = "EXP_START")
    private java.util.Date expStart;
    @ApiModelProperty(value = "EXP_END")
    private java.util.Date expEnd;
    @ApiModelProperty(value = "ORGANIZATION")
    private String organization;
    @ApiModelProperty(value = "CERTIFICATE")
    private String certificate;
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

    public Long getTrainingExpId() {
        return trainingExpId;
    }

    public void setTrainingExpId(Long trainingExpId) {
        this.trainingExpId = trainingExpId;
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

    public String getOrganization() {
        return organization;
    }

    public String getButlerCode() {
        return butlerCode;
    }

    public void setButlerCode(String butlerCode) {
        this.butlerCode = butlerCode;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
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
