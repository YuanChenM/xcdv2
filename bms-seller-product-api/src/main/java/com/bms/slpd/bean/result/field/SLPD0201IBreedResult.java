package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ApiModel(value = "SLPD0201IBreedResult", description = "品种")
public class SLPD0201IBreedResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "品种ID")
    private Long breedId;
    @ApiModelProperty(value = "品种编码")
    private String breedCode;
    @ApiModelProperty(value = "品种SKU")
    private String breedSku;
    @ApiModelProperty(value = "品种标准市场销售名")
    private String breedSalesName;
    @ApiModelProperty(value = "品种学名")
    private String breedScientificName;
    @ApiModelProperty(value = "品种俗名")
    private String breedLocalName;
    @ApiModelProperty(value = "审核状态")
    private Boolean auditStu;

    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;
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

    @ApiModelProperty(value = "二级分类ID")
    private Long machiningId;
    @ApiModelProperty(value = "二级分类编码")
    private String machiningCode;
    @ApiModelProperty(value = "二级分类名称")
    private String machiningName;

    @ApiModelProperty(value = "一级分类ID")
    private Long classesId;
    @ApiModelProperty(value = "一级分类编码")
    private String classesCode;
    @ApiModelProperty(value = "一级分类名称")
    private String classesName;

    @ApiModelProperty(value = "原种种源标准指标集合")
    private List<SLPD0201IOrgStdResult> orgStdList;
    @ApiModelProperty(value = "饲养标准指标集合")
    private List<SLPD0201IFedStdResult> fedStdList;
    @ApiModelProperty(value = "加工技术标准指标集合")
    private List<SLPD0201IMctStdResult> mctStdList;
    @ApiModelProperty(value = "加工质量标准指标集合")
    private List<SLPD0201ITncStdResult> tncStdList;
    @ApiModelProperty(value = "通用质量标准指标集合")
    private List<SLPD0201IGnqStdResult> gnqStdList;
    @ApiModelProperty(value = "安全标准指标集合")
    private List<SLPD0201ISftStdResult> sftStdList;
    @ApiModelProperty(value = "存储运输标准指标集合")
    private List<SLPD0201ITspStdResult> tspStdList;

    public Long getBreedId() {
        return breedId;
    }

    public void setBreedId(Long breedId) {
        this.breedId = breedId;
    }

    public String getBreedCode() {
        return breedCode;
    }

    public void setBreedCode(String breedCode) {
        this.breedCode = breedCode;
    }

    public String getBreedSku() {
        return breedSku;
    }

    public void setBreedSku(String breedSku) {
        this.breedSku = breedSku;
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

    public Boolean getAuditStu() {
        return auditStu;
    }

    public void setAuditStu(Boolean auditStu) {
        this.auditStu = auditStu;
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

    public List<SLPD0201IOrgStdResult> getOrgStdList() {
        return orgStdList;
    }

    public void setOrgStdList(List<SLPD0201IOrgStdResult> orgStdList) {
        this.orgStdList = orgStdList;
    }

    public List<SLPD0201IFedStdResult> getFedStdList() {
        return fedStdList;
    }

    public void setFedStdList(List<SLPD0201IFedStdResult> fedStdList) {
        this.fedStdList = fedStdList;
    }

    public List<SLPD0201IMctStdResult> getMctStdList() {
        return mctStdList;
    }

    public void setMctStdList(List<SLPD0201IMctStdResult> mctStdList) {
        this.mctStdList = mctStdList;
    }

    public List<SLPD0201ITncStdResult> getTncStdList() {
        return tncStdList;
    }

    public void setTncStdList(List<SLPD0201ITncStdResult> tncStdList) {
        this.tncStdList = tncStdList;
    }

    public List<SLPD0201IGnqStdResult> getGnqStdList() {
        return gnqStdList;
    }

    public void setGnqStdList(List<SLPD0201IGnqStdResult> gnqStdList) {
        this.gnqStdList = gnqStdList;
    }

    public List<SLPD0201ISftStdResult> getSftStdList() {
        return sftStdList;
    }

    public void setSftStdList(List<SLPD0201ISftStdResult> sftStdList) {
        this.sftStdList = sftStdList;
    }

    public List<SLPD0201ITspStdResult> getTspStdList() {
        return tspStdList;
    }

    public void setTspStdList(List<SLPD0201ITspStdResult> tspStdList) {
        this.tspStdList = tspStdList;
    }
}
