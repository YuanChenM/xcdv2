package com.bms.byim.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by tao_zhifa on 2016/12/30.
 */

@ApiModel(value = "EmployeeRsParam", description = "买家雇员信息")
public class EmployeeRsParam extends BaseRestPaginationParam {

    @ApiModelProperty(value = "雇员ID")
    private Long employeeId;
    @ApiModelProperty(value = "买家ID")
    private String buyerId;
    @ApiModelProperty(value = "买家编码")
    private String buyerCode;
    @ApiModelProperty(value = "店铺ID")
    private Long storeId;
    @ApiModelProperty(value = "雇员姓名")
    private String employeeName;
    @ApiModelProperty(value = "雇员类型")
    private String employeeType;
    @ApiModelProperty(value = "雇员手机")
    private String employeeTel;
    @ApiModelProperty(value = "雇员QQ")
    private String employeeQq;
    @ApiModelProperty(value = "雇员微信")
    private String employeeWechat;
    @ApiModelProperty(value = "有无名片照")
    private Boolean employeeCardFlg;
    @ApiModelProperty(value = "雇员名片照")
    private String employeeCardPic;
    @ApiModelProperty(value = "是否联络人")
    private Boolean isContactPerson;
    @ApiModelProperty(value = "是否采购人")
    private Boolean isPurchase;
    @ApiModelProperty(value = "是否收货人")
    private Boolean isReceivePerson;
    @ApiModelProperty(value = "是否默认老板")
    private Boolean isNewestBoss;
    @ApiModelProperty(value = "逻辑删除")
    private boolean delFlg;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerCode() {
        return buyerCode;
    }

    public void setBuyerCode(String buyerCode) {
        this.buyerCode = buyerCode;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getEmployeeTel() {
        return employeeTel;
    }

    public void setEmployeeTel(String employeeTel) {
        this.employeeTel = employeeTel;
    }

    public String getEmployeeQq() {
        return employeeQq;
    }

    public void setEmployeeQq(String employeeQq) {
        this.employeeQq = employeeQq;
    }

    public String getEmployeeWechat() {
        return employeeWechat;
    }

    public void setEmployeeWechat(String employeeWechat) {
        this.employeeWechat = employeeWechat;
    }

    public Boolean getEmployeeCardFlg() {
        return employeeCardFlg;
    }

    public void setEmployeeCardFlg(Boolean employeeCardFlg) {
        this.employeeCardFlg = employeeCardFlg;
    }

    public String getEmployeeCardPic() {
        return employeeCardPic;
    }

    public void setEmployeeCardPic(String employeeCardPic) {
        this.employeeCardPic = employeeCardPic;
    }

    public Boolean getIsContactPerson() {
        return isContactPerson;
    }

    public void setIsContactPerson(Boolean isContactPerson) {
        this.isContactPerson = isContactPerson;
    }

    public Boolean getIsPurchase() {
        return isPurchase;
    }

    public void setIsPurchase(Boolean isPurchase) {
        this.isPurchase = isPurchase;
    }

    public Boolean getIsReceivePerson() {
        return isReceivePerson;
    }

    public void setIsReceivePerson(Boolean isReceivePerson) {
        this.isReceivePerson = isReceivePerson;
    }

    public Boolean getIsNewestBoss() {
        return isNewestBoss;
    }

    public void setIsNewestBoss(Boolean isNewestBoss) {
        this.isNewestBoss = isNewestBoss;
    }

    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
        this.delFlg = delFlg;
    }
}
