package com.bms.linv.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by zhang_jian4 on 2017/4/18.
 */
@ApiModel(value = "LINV0111IParam",
    description = "产品批次库存查询")
public class LINV0111IParam extends BaseRestPaginationParam{

    @ApiModelProperty(value = "物流区域ID")
    private String[] logisticsId;

    @ApiModelProperty(value = "销售平台")
    private String[] salePlatform;

    @ApiModelProperty(value = "货主ID")
    private String[] ownerId;

    @ApiModelProperty(value = "货主类型")
    private String[] ownerType;

    @ApiModelProperty(value = "生产商ID")
    private String[] producerId;

    @ApiModelProperty(value = "商品ID")
    private String[] commodityId;

    @ApiModelProperty(value = "产品ID")
    private String[] productId;

    @ApiModelProperty(value = "SKU编码")
    private String[] skuCode;

    @ApiModelProperty(value = "入库批次")
    private String[] lotNo;

    @ApiModelProperty(value = "销售状态ID")
    private String[] saleStatusId;

    @ApiModelProperty(value = "单位")
    private String[] uom;

    @ApiModelProperty(value = "库存类型")
    private String[] ivType;

    public String[] getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(String[] logisticsId) {
        this.logisticsId = logisticsId;
    }

    public String[] getSalePlatform() {
        return salePlatform;
    }

    public void setSalePlatform(String[] salePlatform) {
        this.salePlatform = salePlatform;
    }

    public String[] getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String[] ownerId) {
        this.ownerId = ownerId;
    }

    public String[] getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String[] ownerType) {
        this.ownerType = ownerType;
    }

    public String[] getProducerId() {
        return producerId;
    }

    public void setProducerId(String[] producerId) {
        this.producerId = producerId;
    }

    public String[] getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String[] commodityId) {
        this.commodityId = commodityId;
    }

    public String[] getProductId() {
        return productId;
    }

    public void setProductId(String[] productId) {
        this.productId = productId;
    }

    public String[] getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String[] skuCode) {
        this.skuCode = skuCode;
    }

    public String[] getLotNo() {
        return lotNo;
    }

    public void setLotNo(String[] lotNo) {
        this.lotNo = lotNo;
    }

    public String[] getSaleStatusId() {
        return saleStatusId;
    }

    public void setSaleStatusId(String[] saleStatusId) {
        this.saleStatusId = saleStatusId;
    }

    public String[] getUom() {
        return uom;
    }

    public void setUom(String[] uom) {
        this.uom = uom;
    }

    public String[] getIvType() {
        return ivType;
    }

    public void setIvType(String[] ivType) {
        this.ivType = ivType;
    }

}
