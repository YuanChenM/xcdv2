package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ApiModel(value = "SLPD0301IItemResult", description = "单品")
public class SLPD0301IItemResult implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "单品ID")
	private Long itemId;
	@ApiModelProperty(value = "单品编码")
	private String itemCode;
	@ApiModelProperty(value = "单品SKU")
	private String itemSku;
	@ApiModelProperty(value = "单品名称")
	private String itemName;
	@ApiModelProperty(value = "规格")
	private String specification;
	@ApiModelProperty(value = "加工方式")
	private String processingMethod;
	@ApiModelProperty(value = "口味")
	private String taste;
	@ApiModelProperty(value = "审核状态")
	private Boolean auditStu;

	@ApiModelProperty(value = "删除标识")
	private Boolean delFlg;
	@ApiModelProperty(value = "创建ID")
	private String crtId;
	@ApiModelProperty(value = "创建时间")
	private Date crtTime;
	@ApiModelProperty(value = "更新ID")
	private String updId;
	@ApiModelProperty(value = "更新时间")
	private Date updTime;
	@ApiModelProperty(value = "版本")
	private Integer version;

	@ApiModelProperty(value = "品种")
	private SLPD0301IBreedResult breed;

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

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemSku() {
		return itemSku;
	}

	public void setItemSku(String itemSku) {
		this.itemSku = itemSku;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getProcessingMethod() {
		return processingMethod;
	}

	public void setProcessingMethod(String processingMethod) {
		this.processingMethod = processingMethod;
	}

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
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

	public SLPD0301IBreedResult getBreed() {
		return breed;
	}

	public void setBreed(SLPD0301IBreedResult breed) {
		this.breed = breed;
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
}
