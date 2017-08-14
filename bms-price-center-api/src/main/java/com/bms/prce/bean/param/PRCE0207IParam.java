package com.bms.prce.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * 价盘一览查询
 * @author  zhou_ling
 * @version  1.0
 */
@ApiModel(value = "PRCE0207IParam",
        description = "价盘一览查询")
public class PRCE0207IParam extends BaseRestPaginationParam {

    @ApiModelProperty(value = "商品ID")
    private  String goodId;

    @ApiModelProperty(value = "商品编码")
    private  String commodityCode;

    @ApiModelProperty(value = "销售状态名称")
    private String saleStatusName;

    @ApiModelProperty(value = "物流区ID")
    private String lgcsAreaCode;

    @ApiModelProperty(value = "物流区名称")
    private String lgcsAreaName;

    @ApiModelProperty(value = "用户类型")
    private String userType;

    @ApiModelProperty(value = "买家等级")
    private String buyerLevel;

    @ApiModelProperty(value = "是否有价盘")
    private Boolean havePlate;

    @ApiModelProperty(value = "是否有待生效价盘")
    private  Boolean haveLaterPlate;

    @ApiModelProperty(value = "上下架状态")
    private  String shelfStu;

    @ApiModelProperty(value = "所有人类型")
    private String ownerType;

    @ApiModelProperty(value = "所有人ID")
    private Long ownerId;

    @ApiModelProperty(value = "所有人名称")
    private String ownerName;

    @ApiModelProperty(value = "单品名称")
    private String itemName;

    @ApiModelProperty(value = "价盘开始查询时间")
    private String searchStartTime;

    @ApiModelProperty(value = "价盘结束查询时间")
    private String searchEndTime;

    @ApiModelProperty(value = "一级分类名称")
    private String classesName;

    @ApiModelProperty(value = "二级分类名称")
    private String machiningName;

    @ApiModelProperty(value = "品种标准市场销售名")
    private String breedSalesName;

    @ApiModelProperty(value = "品牌")
    private String brandName;

    @ApiModelProperty(value = "规格")
    private String packageSpecification;

    @ApiModelProperty(value = "净重")
    private BigDecimal netWeight;

    @ApiModelProperty(value = "等级名称")
    private String qualityGradeTypeName;
    /**
     * Getter method for property <tt>goodId</tt>.
     *
     * @return property value of goodId
     */
    public String getGoodId() {
        return goodId;
    }

    /**
     * Setter method for property <tt>goodId</tt>.
     *
     * @param goodId value to be assigned to property goodId
     */
    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    /**
     * Getter method for property <tt>lgcsAreaCode</tt>.
     *
     * @return property value of lgcsAreaCode
     */
    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    /**
     * Setter method for property <tt>lgcsAreaCode</tt>.
     *
     * @param lgcsAreaCode value to be assigned to property lgcsAreaCode
     */
    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }

    /**
     * Getter method for property <tt>lgcsAreaName</tt>.
     *
     * @return property value of lgcsAreaName
     */
    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

    /**
     * Setter method for property <tt>lgcsAreaName</tt>.
     *
     * @param lgcsAreaName value to be assigned to property lgcsAreaName
     */
    public void setLgcsAreaName(String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }

    /**
     * Getter method for property <tt>userType</tt>.
     *
     * @return property value of userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     * Setter method for property <tt>userType</tt>.
     *
     * @param userType value to be assigned to property userType
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * Getter method for property <tt>buyerLevel</tt>.
     *
     * @return property value of buyerLevel
     */
    public String getBuyerLevel() {
        return buyerLevel;
    }

    /**
     * Setter method for property <tt>buyerLevel</tt>.
     *
     * @param buyerLevel value to be assigned to property buyerLevel
     */
    public void setBuyerLevel(String buyerLevel) {
        this.buyerLevel = buyerLevel;
    }

    /**
     * Getter method for property <tt>havePlate</tt>.
     *
     * @return property value of havePlate
     */
    public Boolean getHavePlate() {
        return havePlate;
    }

    /**
     * Setter method for property <tt>havePlate</tt>.
     *
     * @param havePlate value to be assigned to property havePlate
     */
    public void setHavePlate(Boolean havePlate) {
        this.havePlate = havePlate;
    }

    /**
     * Getter method for property <tt>haveLaterPlate</tt>.
     *
     * @return property value of haveLaterPlate
     */
    public Boolean getHaveLaterPlate() {
        return haveLaterPlate;
    }

    /**
     * Setter method for property <tt>haveLaterPlate</tt>.
     *
     * @param haveLaterPlate value to be assigned to property haveLaterPlate
     */
    public void setHaveLaterPlate(Boolean haveLaterPlate) {
        this.haveLaterPlate = haveLaterPlate;
    }

    /**
     * Getter method for property <tt>shelfStu</tt>.
     *
     * @return property value of shelfStu
     */
    public String getShelfStu() {
        return shelfStu;
    }

    /**
     * Setter method for property <tt>shelfStu</tt>.
     *
     * @param shelfStu value to be assigned to property shelfStu
     */
    public void setShelfStu(String shelfStu) {
        this.shelfStu = shelfStu;
    }

    /**
     * Getter method for property <tt>ownerType</tt>.
     *
     * @return property value of ownerType
     */
    public String getOwnerType() {
        return ownerType;
    }

    /**
     * Setter method for property <tt>ownerType</tt>.
     *
     * @param ownerType value to be assigned to property ownerType
     */
    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    /**
     * Getter method for property <tt>ownerId</tt>.
     *
     * @return property value of ownerId
     */
    public Long getOwnerId() {
        return ownerId;
    }

    /**
     * Setter method for property <tt>ownerId</tt>.
     *
     * @param ownerId value to be assigned to property ownerId
     */
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * Getter method for property <tt>ownerName</tt>.
     *
     * @return property value of ownerName
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Setter method for property <tt>ownerName</tt>.
     *
     * @param ownerName value to be assigned to property ownerName
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    /**
     * Getter method for property <tt>searchStartTime</tt>.
     *
     * @return property value of searchStartTime
     */
    public String getSearchStartTime() {
        return searchStartTime;
    }

    /**
     * Setter method for property <tt>searchStartTime</tt>.
     *
     * @param searchStartTime value to be assigned to property searchStartTime
     */
    public void setSearchStartTime(String searchStartTime) {
        this.searchStartTime = searchStartTime;
    }

    /**
     * Getter method for property <tt>searchEndTime</tt>.
     *
     * @return property value of searchEndTime
     */
    public String getSearchEndTime() {
        return searchEndTime;
    }

    /**
     * Setter method for property <tt>searchEndTime</tt>.
     *
     * @param searchEndTime value to be assigned to property searchEndTime
     */
    public void setSearchEndTime(String searchEndTime) {
        this.searchEndTime = searchEndTime;
    }

    /**
     * Getter method for property <tt>classesName</tt>.
     *
     * @return property value of classesName
     */
    public String getClassesName() {
        return classesName;
    }

    /**
     * Setter method for property <tt>classesName</tt>.
     *
     * @param classesName value to be assigned to property classesName
     */
    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    /**
     * Getter method for property <tt>machiningName</tt>.
     *
     * @return property value of machiningName
     */
    public String getMachiningName() {
        return machiningName;
    }

    /**
     * Setter method for property <tt>machiningName</tt>.
     *
     * @param machiningName value to be assigned to property machiningName
     */
    public void setMachiningName(String machiningName) {
        this.machiningName = machiningName;
    }

    /**
     * Getter method for property <tt>breedSalesName</tt>.
     *
     * @return property value of breedSalesName
     */
    public String getBreedSalesName() {
        return breedSalesName;
    }

    /**
     * Setter method for property <tt>breedSalesName</tt>.
     *
     * @param breedSalesName value to be assigned to property breedSalesName
     */
    public void setBreedSalesName(String breedSalesName) {
        this.breedSalesName = breedSalesName;
    }

    /**
     * Getter method for property <tt>brandName</tt>.
     *
     * @return property value of brandName
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * Setter method for property <tt>brandName</tt>.
     *
     * @param brandName value to be assigned to property brandName
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getPackageSpecification() {
        return packageSpecification;
    }

    public void setPackageSpecification(String packageSpecification) {
        this.packageSpecification = packageSpecification;
    }

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    public String getSaleStatusName() {
        return saleStatusName;
    }

    public void setSaleStatusName(String saleStatusName) {
        this.saleStatusName = saleStatusName;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getQualityGradeTypeName() {
        return qualityGradeTypeName;
    }

    public void setQualityGradeTypeName(String qualityGradeTypeName) {
        this.qualityGradeTypeName = qualityGradeTypeName;
    }
}
