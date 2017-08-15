package com.bms.slpd.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0101IParam", description = "查询一级分类接口入参")
public class SLPD0101IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "产品一级分类Id集合")
    private List<Long> classesIds;
    @ApiModelProperty(value = "产品一级分类编码集合")
    private List<String> classesCodes;
    @ApiModelProperty(value = "产品一级分类名称")
    private String classesName;
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;
    @ApiModelProperty(value = "审核状态")
    private Boolean auditStu;

    public List<Long> getClassesIds() {
        return classesIds;
    }

    public void setClassesIds(List<Long> classesIds) {
        this.classesIds = classesIds;
    }

    public List<String> getClassesCodes() {
        return classesCodes;
    }

    public void setClassesCodes(List<String> classesCodes) {
        this.classesCodes = classesCodes;
    }

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    public Boolean getAuditStu() {
        return auditStu;
    }

    public void setAuditStu(Boolean auditStu) {
        this.auditStu = auditStu;
    }
}
