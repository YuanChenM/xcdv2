package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ApiModel(value = "SLPD0501IProductResult", description = "产品")
public class SLPD0501IProductResult implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "产品ID")
	private String productId;
	@ApiModelProperty(value = "质量等级，1：A1，2：A2，3：A3")
	private String qualityGradeType;
	@ApiModelProperty(value = "质量等级")
	private String qualityGradeTypeStr;
	@ApiModelProperty(value = "审核状态，0：未注册，1：审核中，2：试销，3：正式，4：禁止准入，5：黑名单")
	private String auditStu;
	@ApiModelProperty(value = "审核状态")
	private String auditStuStr;
	@ApiModelProperty(value = "审核备注")
	private String auditRemark;
	@ApiModelProperty(value = "审核履历，格式：0,未注册,admin,2017-01-25;")
	private String auditHistory;

	@ApiModelProperty(value = "删除标识")
	private Boolean delFlg;
	@ApiModelProperty(value = "新建人ID")
	private String crtId;
	@ApiModelProperty(value = "新建时间")
	private Date crtTime;
	@ApiModelProperty(value = "修改人ID")
	private String updId;
	@ApiModelProperty(value = "修改时间")
	private Date updTime;
	@ApiModelProperty(value = "版本")
	private Integer version;

	@ApiModelProperty(value = "单品品牌规格")
	private SLPD0501IBrandItemPropertyResult brandItemProperty;

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
	@ApiModelProperty(value = "包装标准指标集合")
	private List<SLPD0201IPkgStdResult> pkgStdList;

	@ApiModelProperty(value = "原种种源标准指标差异集合")
	private List<SLPD0501IDifOrgStdResult> difOrgStdList;
	@ApiModelProperty(value = "饲养标准指标差异集合")
	private List<SLPD0501IDifFedStdResult> difFedStdList;
	@ApiModelProperty(value = "加工技术标准指标差异集合")
	private List<SLPD0501IDifMctStdResult> difMctStdList;
	@ApiModelProperty(value = "加工质量标准指标差异集合")
	private List<SLPD0501IDifTncStdResult> difTncStdList;
	@ApiModelProperty(value = "通用质量标准指标差异集合")
	private List<SLPD0501IDifGnqStdResult> difGnqStdList;
	@ApiModelProperty(value = "安全标准指标差异集合")
	private List<SLPD0501IDifSftStdResult> difSftStdList;
	@ApiModelProperty(value = "储存运输标准指标差异集合")
	private List<SLPD0501IDifTspStdResult> difTspStdList;
	@ApiModelProperty(value = "包装标准指标差异集合")
	private List<SLPD0501IDifPkgStdResult> difPkgStdList;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getQualityGradeType() {
		return qualityGradeType;
	}

	public void setQualityGradeType(String qualityGradeType) {
		this.qualityGradeType = qualityGradeType;
	}

	public String getQualityGradeTypeStr() {
		return qualityGradeTypeStr;
	}

	public void setQualityGradeTypeStr(String qualityGradeTypeStr) {
		this.qualityGradeTypeStr = qualityGradeTypeStr;
	}

	public String getAuditStu() {
		return auditStu;
	}

	public void setAuditStu(String auditStu) {
		this.auditStu = auditStu;
	}

	public String getAuditStuStr() {
		return auditStuStr;
	}

	public void setAuditStuStr(String auditStuStr) {
		this.auditStuStr = auditStuStr;
	}

	public String getAuditRemark() {
		return auditRemark;
	}

	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}

	public String getAuditHistory() {
		return auditHistory;
	}

	public void setAuditHistory(String auditHistory) {
		this.auditHistory = auditHistory;
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

	public SLPD0501IBrandItemPropertyResult getBrandItemProperty() {
		return brandItemProperty;
	}

	public void setBrandItemProperty(SLPD0501IBrandItemPropertyResult brandItemProperty) {
		this.brandItemProperty = brandItemProperty;
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

	public List<SLPD0201IPkgStdResult> getPkgStdList() {
		return pkgStdList;
	}

	public void setPkgStdList(List<SLPD0201IPkgStdResult> pkgStdList) {
		this.pkgStdList = pkgStdList;
	}

	public List<SLPD0501IDifOrgStdResult> getDifOrgStdList() {
		return difOrgStdList;
	}

	public void setDifOrgStdList(List<SLPD0501IDifOrgStdResult> difOrgStdList) {
		this.difOrgStdList = difOrgStdList;
	}

	public List<SLPD0501IDifFedStdResult> getDifFedStdList() {
		return difFedStdList;
	}

	public void setDifFedStdList(List<SLPD0501IDifFedStdResult> difFedStdList) {
		this.difFedStdList = difFedStdList;
	}

	public List<SLPD0501IDifMctStdResult> getDifMctStdList() {
		return difMctStdList;
	}

	public void setDifMctStdList(List<SLPD0501IDifMctStdResult> difMctStdList) {
		this.difMctStdList = difMctStdList;
	}

	public List<SLPD0501IDifTncStdResult> getDifTncStdList() {
		return difTncStdList;
	}

	public void setDifTncStdList(List<SLPD0501IDifTncStdResult> difTncStdList) {
		this.difTncStdList = difTncStdList;
	}

	public List<SLPD0501IDifGnqStdResult> getDifGnqStdList() {
		return difGnqStdList;
	}

	public void setDifGnqStdList(List<SLPD0501IDifGnqStdResult> difGnqStdList) {
		this.difGnqStdList = difGnqStdList;
	}

	public List<SLPD0501IDifSftStdResult> getDifSftStdList() {
		return difSftStdList;
	}

	public void setDifSftStdList(List<SLPD0501IDifSftStdResult> difSftStdList) {
		this.difSftStdList = difSftStdList;
	}

	public List<SLPD0501IDifTspStdResult> getDifTspStdList() {
		return difTspStdList;
	}

	public void setDifTspStdList(List<SLPD0501IDifTspStdResult> difTspStdList) {
		this.difTspStdList = difTspStdList;
	}

	public List<SLPD0501IDifPkgStdResult> getDifPkgStdList() {
		return difPkgStdList;
	}

	public void setDifPkgStdList(List<SLPD0501IDifPkgStdResult> difPkgStdList) {
		this.difPkgStdList = difPkgStdList;
	}
}
