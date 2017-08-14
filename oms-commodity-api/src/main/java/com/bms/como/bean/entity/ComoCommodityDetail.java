/*
 * 2017/03/23 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.como.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表como_commodity_detail对应的实体ComoCommodityDetail</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class ComoCommodityDetail extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 设定ID */
    private Long detailId;
    /** 商品ID */
    private Long commodityId;
    /** 物流区域ID */
    private Long lgcsAreaId;
    /** 货权人类型，CodeMaster */
    private String ownerType;
    /** 货权人ID */
    private Long ownerId;
    /** 货权人编码 */
    private String onwerCode;
    /** 货权人名称 */
    private String ownerName;
    /** 产品主键ID */
    private Long productPid;
    /** 库存状态 */
    private String inventoryStu;
    /** SKU编码 */
    private String skuCode;
    /** 生产商ID */
    private Long producerId;
    /** 生产商编码 */
    private String producerCode;
    /** 生产商名称 */
    private String producerName;
    /** 入库批次 */
    private String lotNo;

    /**
     * <p>默认构造函数</p>
     */
    public ComoCommodityDetail() {
    }

    /**
     * <p>设定ID</p>
     *
     * @return 设定ID
     */
    public Long getDetailId() {
        return detailId;
    }

    /**
     * <p>设定ID</p>
     *
     * @param detailId 设定ID
     */
    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }
    /**
     * <p>商品ID</p>
     *
     * @return 商品ID
     */
    public Long getCommodityId() {
        return commodityId;
    }

    /**
     * <p>商品ID</p>
     *
     * @param commodityId 商品ID
     */
    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }
    /**
     * <p>物流区域ID</p>
     *
     * @return 物流区域ID
     */
    public Long getLgcsAreaId() {
        return lgcsAreaId;
    }

    /**
     * <p>物流区域ID</p>
     *
     * @param lgcsAreaId 物流区域ID
     */
    public void setLgcsAreaId(Long lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
    }
    /**
     * <p>货权人类型，CodeMaster</p>
     *
     * @return 货权人类型，CodeMaster
     */
    public String getOwnerType() {
        return ownerType;
    }

    /**
     * <p>货权人类型，CodeMaster</p>
     *
     * @param ownerType 货权人类型，CodeMaster
     */
    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }
    /**
     * <p>货权人ID</p>
     *
     * @return 货权人ID
     */
    public Long getOwnerId() {
        return ownerId;
    }

    /**
     * <p>货权人ID</p>
     *
     * @param ownerId 货权人ID
     */
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
    /**
     * <p>货权人编码</p>
     *
     * @return 货权人编码
     */
    public String getOnwerCode() {
        return onwerCode;
    }

    /**
     * <p>货权人编码</p>
     *
     * @param onwerCode 货权人编码
     */
    public void setOnwerCode(String onwerCode) {
        this.onwerCode = onwerCode;
    }
    /**
     * <p>货权人名称</p>
     *
     * @return 货权人名称
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * <p>货权人名称</p>
     *
     * @param ownerName 货权人名称
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    /**
     * <p>产品主键ID</p>
     *
     * @return 产品主键ID
     */
    public Long getProductPid() {
        return productPid;
    }

    /**
     * <p>产品主键ID</p>
     *
     * @param productPid 产品主键ID
     */
    public void setProductPid(Long productPid) {
        this.productPid = productPid;
    }
    /**
     * <p>库存状态</p>
     *
     * @return 库存状态
     */
    public String getInventoryStu() {
        return inventoryStu;
    }

    /**
     * <p>库存状态</p>
     *
     * @param inventoryStu 库存状态
     */
    public void setInventoryStu(String inventoryStu) {
        this.inventoryStu = inventoryStu;
    }
    /**
     * <p>SKU编码</p>
     *
     * @return SKU编码
     */
    public String getSkuCode() {
        return skuCode;
    }

    /**
     * <p>SKU编码</p>
     *
     * @param skuCode SKU编码
     */
    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }
    /**
     * <p>生产商ID</p>
     *
     * @return 生产商ID
     */
    public Long getProducerId() {
        return producerId;
    }

    /**
     * <p>生产商ID</p>
     *
     * @param producerId 生产商ID
     */
    public void setProducerId(Long producerId) {
        this.producerId = producerId;
    }
    /**
     * <p>生产商编码</p>
     *
     * @return 生产商编码
     */
    public String getProducerCode() {
        return producerCode;
    }

    /**
     * <p>生产商编码</p>
     *
     * @param producerCode 生产商编码
     */
    public void setProducerCode(String producerCode) {
        this.producerCode = producerCode;
    }
    /**
     * <p>生产商名称</p>
     *
     * @return 生产商名称
     */
    public String getProducerName() {
        return producerName;
    }

    /**
     * <p>生产商名称</p>
     *
     * @param producerName 生产商名称
     */
    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }
    /**
     * <p>入库批次</p>
     *
     * @return 入库批次
     */
    public String getLotNo() {
        return lotNo;
    }

    /**
     * <p>入库批次</p>
     *
     * @param lotNo 入库批次
     */
    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }

}
