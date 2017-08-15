package com.bms.slim.bean.result.field;

import com.bms.slim.bean.entity.SlimContact;
import com.bms.slim.bean.entity.SlimSeller;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ApiModel(value = "SLIM0102IEntitySellerResult", description = "实体卖家")
public class SLIM0102IEntitySellerResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "实体卖家ID")
    private Long entitySellerId;
	@ApiModelProperty(value = "实体卖家显示Code")
	private String entitySellerDisplayCode;
	@ApiModelProperty(value = "实体卖家Code")
	private String entitySellerCode;
    @ApiModelProperty(value = "卖家全称")
    private String fullName;
    @ApiModelProperty(value = "卖家简称")
    private String shortName;
    @ApiModelProperty(value = "账号")
    private String account;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "国家编码")
    private String countryCode;
    @ApiModelProperty(value = "国家")
    private String countryName;
    @ApiModelProperty(value = "省编码")
    private String provinceCode;
    @ApiModelProperty(value = "省")
    private String provinceName;
    @ApiModelProperty(value = "市编码")
    private String cityCode;
    @ApiModelProperty(value = "市")
    private String cityName;
    @ApiModelProperty(value = "固定电话")
    private String tel;
    @ApiModelProperty(value = "传真号")
    private String fax;
    @ApiModelProperty(value = "网站及微信公众号")
    private String mediaPlatform;
	@ApiModelProperty(value = "详细地址")
	private String address;
    @ApiModelProperty(value = "品牌必需标识，0：选填，1：必填")
    private Boolean brandRequiredFlg;
    @ApiModelProperty(value = "品牌注册标识，0：未注册，1：已注册")
    private Boolean brandRegFlg;
    @ApiModelProperty(value = "生产商必需标识，0：选填，1：必填")
    private Boolean producerRequiredFlg;
    @ApiModelProperty(value = "生产商注册标识，0：未注册，1：已注册")
    private Boolean producerRegFlg;
    @ApiModelProperty(value = "经营资质必需标识，0：选填，1：必填")
    private Boolean bizQualRequiredFlg;
    @ApiModelProperty(value = "经营资质注册标识，0：未注册，1：已注册")
    private Boolean bizQualRegFlg;
    @ApiModelProperty(value = "供应资质必需标识，0：选填，1：必填")
    private Boolean supQualRequiredFlg;
    @ApiModelProperty(value = "供应资质注册标识，0：未注册，1：已注册")
    private Boolean supQualRegFlg;
    @ApiModelProperty(value = "电商团队必需标识，0：选填，1：必填")
    private Boolean bizTeamRequiredFlg;
    @ApiModelProperty(value = "电商团队注册标识，0：未注册，1：已注册")
    private Boolean bizTeamRegFlg;
    @ApiModelProperty(value = "管理团队必需标识，0：选填，1：必填")
    private Boolean mgtTeamRequiredFlg;
    @ApiModelProperty(value = "管理团队注册标识，0：未注册，1：已注册")
    private Boolean mgtTeamRegFlg;
    @ApiModelProperty(value = "合同信息必需标识，0：选填，1：必填")
    private Boolean contractRequiredFlg;
    @ApiModelProperty(value = "合同信息注册标识，0：未注册，1：已注册")
    private Boolean contractRegFlg;
    @ApiModelProperty(value = "审核状态，0： 待审核，1：正式")
    private String auditStu;
    @ApiModelProperty(value = "审核备注")
    private String auditRemark;
    @ApiModelProperty(value = "审核履历，格式：0,未注册,admin,2017-01-25;")
    private String auditHistory;
    @ApiModelProperty(value = "删除标识，true：已删除，false：未删除")
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

    @ApiModelProperty(value = "卖家联系人集合")
    private List<SlimContact> contactList;

	public String getEntitySellerDisplayCode() {
		return entitySellerDisplayCode;
	}

	public void setEntitySellerDisplayCode(String entitySellerDisplayCode) {
		this.entitySellerDisplayCode = entitySellerDisplayCode;
	}

	public String getEntitySellerCode() {
		return entitySellerCode;
	}

	public void setEntitySellerCode(String entitySellerCode) {
		this.entitySellerCode = entitySellerCode;
	}

	public Long getEntitySellerId() {
		return entitySellerId;
	}

	public void setEntitySellerId(Long entitySellerId) {
		this.entitySellerId = entitySellerId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getMediaPlatform() {
		return mediaPlatform;
	}

	public void setMediaPlatform(String mediaPlatform) {
		this.mediaPlatform = mediaPlatform;
	}

	public Boolean getBrandRequiredFlg() {
		return brandRequiredFlg;
	}

	public void setBrandRequiredFlg(Boolean brandRequiredFlg) {
		this.brandRequiredFlg = brandRequiredFlg;
	}

	public Boolean getBrandRegFlg() {
		return brandRegFlg;
	}

	public void setBrandRegFlg(Boolean brandRegFlg) {
		this.brandRegFlg = brandRegFlg;
	}

	public Boolean getProducerRequiredFlg() {
		return producerRequiredFlg;
	}

	public void setProducerRequiredFlg(Boolean producerRequiredFlg) {
		this.producerRequiredFlg = producerRequiredFlg;
	}

	public Boolean getProducerRegFlg() {
		return producerRegFlg;
	}

	public void setProducerRegFlg(Boolean producerRegFlg) {
		this.producerRegFlg = producerRegFlg;
	}

	public Boolean getBizQualRequiredFlg() {
		return bizQualRequiredFlg;
	}

	public void setBizQualRequiredFlg(Boolean bizQualRequiredFlg) {
		this.bizQualRequiredFlg = bizQualRequiredFlg;
	}

	public Boolean getBizQualRegFlg() {
		return bizQualRegFlg;
	}

	public void setBizQualRegFlg(Boolean bizQualRegFlg) {
		this.bizQualRegFlg = bizQualRegFlg;
	}

	public Boolean getSupQualRequiredFlg() {
		return supQualRequiredFlg;
	}

	public void setSupQualRequiredFlg(Boolean supQualRequiredFlg) {
		this.supQualRequiredFlg = supQualRequiredFlg;
	}

	public Boolean getSupQualRegFlg() {
		return supQualRegFlg;
	}

	public void setSupQualRegFlg(Boolean supQualRegFlg) {
		this.supQualRegFlg = supQualRegFlg;
	}

	public Boolean getBizTeamRequiredFlg() {
		return bizTeamRequiredFlg;
	}

	public void setBizTeamRequiredFlg(Boolean bizTeamRequiredFlg) {
		this.bizTeamRequiredFlg = bizTeamRequiredFlg;
	}

	public Boolean getBizTeamRegFlg() {
		return bizTeamRegFlg;
	}

	public void setBizTeamRegFlg(Boolean bizTeamRegFlg) {
		this.bizTeamRegFlg = bizTeamRegFlg;
	}

	public Boolean getMgtTeamRequiredFlg() {
		return mgtTeamRequiredFlg;
	}

	public void setMgtTeamRequiredFlg(Boolean mgtTeamRequiredFlg) {
		this.mgtTeamRequiredFlg = mgtTeamRequiredFlg;
	}

	public Boolean getMgtTeamRegFlg() {
		return mgtTeamRegFlg;
	}

	public void setMgtTeamRegFlg(Boolean mgtTeamRegFlg) {
		this.mgtTeamRegFlg = mgtTeamRegFlg;
	}

	public Boolean getContractRequiredFlg() {
		return contractRequiredFlg;
	}

	public void setContractRequiredFlg(Boolean contractRequiredFlg) {
		this.contractRequiredFlg = contractRequiredFlg;
	}

	public Boolean getContractRegFlg() {
		return contractRegFlg;
	}

	public void setContractRegFlg(Boolean contractRegFlg) {
		this.contractRegFlg = contractRegFlg;
	}

	public String getAuditStu() {
		return auditStu;
	}

	public void setAuditStu(String auditStu) {
		this.auditStu = auditStu;
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

	public List<SlimContact> getContactList() {
		return contactList;
	}

	public void setContactList(List<SlimContact> contactList) {
		this.contactList = contactList;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
