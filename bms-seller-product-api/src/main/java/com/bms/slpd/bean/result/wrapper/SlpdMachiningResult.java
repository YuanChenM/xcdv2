package com.bms.slpd.bean.result.wrapper;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "SlpdMachiningResult", description = "二级分类ResultModel")
public class SlpdMachiningResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "产品一级分类Id")
    private Long classesId;
    @ApiModelProperty(value = "产品一级分类编码")
    private String classesCode;
    @ApiModelProperty(value = "产品一级分类名称")
    private String classesName;
    @ApiModelProperty(value = "产品一级分类审核状态")
    private String classesAuditStu;

    @ApiModelProperty(value = "产品二级分类Id")
    private Long machiningId;
    @ApiModelProperty(value = "产品二级分类编码")
    private String machiningCode;
    @ApiModelProperty(value = "产品二级分类名称")
    private String machiningName;
    @ApiModelProperty(value = "产品二级分类审核状态")
    private String machiningAuditStu;
    @ApiModelProperty(value = "删除标识")
    private boolean delFlg;
    @ApiModelProperty(value = "创建Id")
    private String crtId;
    @ApiModelProperty(value = "创建时间")
    private Date crtTime;
    @ApiModelProperty(value = "更新Id")
    private String updId;
    @ApiModelProperty(value = "更新时间")
    private Date updTime;
    @ApiModelProperty(value = "版本号")
    private Integer version;

    public Long getClassesId() {
        return classesId;
    }

    public void setClassesId(Long classesId) {
        this.classesId = classesId;
    }

    public String getClassesCode() {
        return classesCode;
    }

    public void setClassesCode(String classesCode) {
        this.classesCode = classesCode;
    }

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    public Long getMachiningId() {
        return machiningId;
    }

    public void setMachiningId(Long machiningId) {
        this.machiningId = machiningId;
    }

    public String getMachiningCode() {
        return machiningCode;
    }

    public void setMachiningCode(String machiningCode) {
        this.machiningCode = machiningCode;
    }

    public String getMachiningName() {
        return machiningName;
    }

    public void setMachiningName(String machiningName) {
        this.machiningName = machiningName;
    }

    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
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

    public String getClassesAuditStu() {
        return classesAuditStu;
    }

    public void setClassesAuditStu(String classesAuditStu) {
        this.classesAuditStu = classesAuditStu;
    }

    public String getMachiningAuditStu() {
        return machiningAuditStu;
    }

    public void setMachiningAuditStu(String machiningAuditStu) {
        this.machiningAuditStu = machiningAuditStu;
    }
}
