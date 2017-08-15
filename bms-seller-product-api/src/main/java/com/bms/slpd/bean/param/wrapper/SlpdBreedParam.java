package com.bms.slpd.bean.param.wrapper;


import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;


public class SlpdBreedParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "品种Id")
    private Long breedId;
    @ApiModelProperty(value = "产品品种编码")
    private String breedCode;
    @ApiModelProperty(value = "品种标准市场销售名")
    private String breedSalesName;
    @ApiModelProperty(value = "品种学名")
    private String breedScientificName;
    @ApiModelProperty(value = "品种俗名")
    private String breedLocalName;
    @ApiModelProperty(value = "品种审核状态")
    private String breedAuditStu;

    @ApiModelProperty(value = "产品一级分类Id")
    private Long classesId;
    @ApiModelProperty(value = "产品一级分类名称")
    private String classesName;
    @ApiModelProperty(value = "产品一级分类编码")
    private String classesCode;
    @ApiModelProperty(value = "产品一级分类审核状态")
    private String classesAuditStu;

    @ApiModelProperty(value = "产品二级分类Id")
    private Long machiningId;
    @ApiModelProperty(value = "产品二级分类名称")
    private String machiningName;
    @ApiModelProperty(value = "产品二级分类编码")
    private String machiningCode;
    @ApiModelProperty(value = "产品二级分类审核状态")
    private String machiningAuditStu;

    @ApiModelProperty(value = "删除标识")
    private boolean delFlg;
    @ApiModelProperty(value = "版本号")
    private Integer version;

    @ApiModelProperty(value = "原种种源标准档案卡(false:不存在,true:存在)")
    private boolean orgStdFlg;
    @ApiModelProperty(value = "饲养标准档案卡(false:不存在,true:存在)")
    private boolean fedStdFlg;
    @ApiModelProperty(value = "加工技术标准档案卡(false:不存在,true:存在)")
    private boolean mctStdFlg;
    @ApiModelProperty(value = "加工质量标准档案卡(false:存在,true:存在)")
    private boolean tncStdFlg;
    @ApiModelProperty(value = "通用质量标准档案卡(false:不存在,true:存在)")
    private boolean gnqStdFlg;
    @ApiModelProperty(value = "安全标准档案卡(false:不存在,true:存在)")
    private boolean sftStdFlg;
    @ApiModelProperty(value = "存储运输标准档案卡(false:不存在,true:存在)")
    private boolean tspStdFlg;
    @ApiModelProperty(value = "包装标准档案卡(false:不存在,true:存在)")
    private boolean pkgStdFlg;


    public Long getBreedId() {
        return breedId;
    }

    public void setBreedId(Long breedId) {
        this.breedId = breedId;
    }

    public String getBreedSalesName() {
        return breedSalesName;
    }

    public void setBreedSalesName(String breedSalesName) {
        this.breedSalesName = breedSalesName;
    }

    public String getBreedScientificName() {
        return breedScientificName;
    }

    public void setBreedScientificName(String breedScientificName) {
        this.breedScientificName = breedScientificName;
    }

    public String getBreedLocalName() {
        return breedLocalName;
    }

    public void setBreedLocalName(String breedLocalName) {
        this.breedLocalName = breedLocalName;
    }

    public Long getClassesId() {
        return classesId;
    }

    public void setClassesId(Long classesId) {
        this.classesId = classesId;
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

    public String getMachiningName() {
        return machiningName;
    }

    public void setMachiningName(String machiningName) {
        this.machiningName = machiningName;
    }

    public boolean isOrgStdFlg() {
        return orgStdFlg;
    }

    public void setOrgStdFlg(boolean orgStdFlg) {
        this.orgStdFlg = orgStdFlg;
    }

    public boolean isFedStdFlg() {
        return fedStdFlg;
    }

    public void setFedStdFlg(boolean fedStdFlg) {
        this.fedStdFlg = fedStdFlg;
    }

    public boolean isMctStdFlg() {
        return mctStdFlg;
    }

    public void setMctStdFlg(boolean mctStdFlg) {
        this.mctStdFlg = mctStdFlg;
    }

    public boolean isTncStdFlg() {
        return tncStdFlg;
    }

    public void setTncStdFlg(boolean tncStdFlg) {
        this.tncStdFlg = tncStdFlg;
    }

    public boolean isGnqStdFlg() {
        return gnqStdFlg;
    }

    public void setGnqStdFlg(boolean gnqStdFlg) {
        this.gnqStdFlg = gnqStdFlg;
    }

    public boolean isSftStdFlg() {
        return sftStdFlg;
    }

    public void setSftStdFlg(boolean sftStdFlg) {
        this.sftStdFlg = sftStdFlg;
    }

    public boolean isTspStdFlg() {
        return tspStdFlg;
    }

    public void setTspStdFlg(boolean tspStdFlg) {
        this.tspStdFlg = tspStdFlg;
    }

    public boolean isPkgStdFlg() {
        return pkgStdFlg;
    }

    public void setPkgStdFlg(boolean pkgStdFlg) {
        this.pkgStdFlg = pkgStdFlg;
    }

    public String getBreedAuditStu() {
        return breedAuditStu;
    }

    public void setBreedAuditStu(String breedAuditStu) {
        this.breedAuditStu = breedAuditStu;
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

    public String getBreedCode() {
        return breedCode;
    }

    public void setBreedCode(String breedCode) {
        this.breedCode = breedCode;
    }

    public String getClassesCode() {
        return classesCode;
    }

    public void setClassesCode(String classesCode) {
        this.classesCode = classesCode;
    }

    public String getMachiningCode() {
        return machiningCode;
    }

    public void setMachiningCode(String machiningCode) {
        this.machiningCode = machiningCode;
    }
}
