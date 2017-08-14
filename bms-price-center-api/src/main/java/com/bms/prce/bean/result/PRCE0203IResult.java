package com.bms.prce.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 价盘营销状态查询
 * @author  zhou_ling
 * @Time  2017/01/11
 * @version  1.0
 */
@ApiModel(value = "PRCE0203IResult", description = "价盘营销状态Result")
public class PRCE0203IResult implements Serializable {

    @ApiModelProperty(value = "营销状态ID")
    private Long marketingStatusId;

    @ApiModelProperty(value = "营销状态名称")
    private String marketingStatusName;

    @ApiModelProperty(value = "单位")
    private String uom;

    @ApiModelProperty(value = "所有人ID")
    private Long ownerId;

    @ApiModelProperty(value = "所有人名称")
    private String ownerName;

    @ApiModelProperty(value = "版本号")
    private Integer version;

    /**
     * Getter method for property <tt>marketingStatusId</tt>.
     *
     * @return property value of marketingStatusId
     */
    public Long getMarketingStatusId() {
        return marketingStatusId;
    }

    /**
     * Setter method for property <tt>marketingStatusId</tt>.
     *
     * @param marketingStatusId value to be assigned to property marketingStatusId
     */
    public void setMarketingStatusId(Long marketingStatusId) {
        this.marketingStatusId = marketingStatusId;
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
     * Getter method for property <tt>marketingStatusName</tt>.
     *
     * @return property value of marketingStatusName
     */
    public String getMarketingStatusName() {
        return marketingStatusName;
    }

    /**
     * Setter method for property <tt>marketingStatusName</tt>.
     *
     * @param marketingStatusName value to be assigned to property marketingStatusName
     */
    public void setMarketingStatusName(String marketingStatusName) {
        this.marketingStatusName = marketingStatusName;
    }

    /**
     * Getter method for property <tt>uom</tt>.
     *
     * @return property value of uom
     */
    public String getUom() {
        return uom;
    }

    /**
     * Setter method for property <tt>uom</tt>.
     *
     * @param uom value to be assigned to property uom
     */
    public void setUom(String uom) {
        this.uom = uom;
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
     * Getter method for property <tt>version</tt>.
     *
     * @return property value of version
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * Setter method for property <tt>version</tt>.
     *
     * @param version value to be assigned to property version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
}
