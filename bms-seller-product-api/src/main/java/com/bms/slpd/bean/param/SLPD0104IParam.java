package com.bms.slpd.bean.param;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0104IParam", description = "查询二级分类接口入参")
public class SLPD0104IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "产品一级分类Id集合")
    private List<Long> classesIds;
    @ApiModelProperty(value = "产品一级分类编码集合")
    private List<String> classesCodes;
    @ApiModelProperty(value = "产品一级分类名称")
    private String classesName;
    @ApiModelProperty(value = "一级分类审核状态")
    private Boolean classesAuditStu;

    @ApiModelProperty(value = "产品二级分类Id集合")
    private List<Long> machiningIds;
    @ApiModelProperty(value = "产品二级分类Code集合")
    private List<String> machiningCodes;
    @ApiModelProperty(value = "产品二级分类名称")
    private String machiningName;
    @ApiModelProperty(value = "二级分类审核状态")
    private Boolean machiningAuditStu;
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;


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

    public List<Long> getMachiningIds() {
        return machiningIds;
    }

    public void setMachiningIds(List<Long> machiningIds) {
        this.machiningIds = machiningIds;
    }

    public List<String> getMachiningCodes() {
        return machiningCodes;
    }

    public void setMachiningCodes(List<String> machiningCodes) {
        this.machiningCodes = machiningCodes;
    }

    public String getMachiningName() {
        return machiningName;
    }

    public void setMachiningName(String machiningName) {
        this.machiningName = machiningName;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    public Boolean getClassesAuditStu() {
        return classesAuditStu;
    }

    public void setClassesAuditStu(Boolean classesAuditStu) {
        this.classesAuditStu = classesAuditStu;
    }

    public Boolean getMachiningAuditStu() {
        return machiningAuditStu;
    }

    public void setMachiningAuditStu(Boolean machiningAuditStu) {
        this.machiningAuditStu = machiningAuditStu;
    }
}
