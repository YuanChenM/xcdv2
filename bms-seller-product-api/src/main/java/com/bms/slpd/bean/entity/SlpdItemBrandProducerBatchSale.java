/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLPD_ITEM_BRAND_PRODUCER_BATCH_SALE对应的实体SlpdItemBrandProducerBatchSale</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdItemBrandProducerBatchSale extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 主键 */
    private Long id;
    /** 产品销售一级状态 */
    private String saleOneStu;
    /** 产品销售二级状态 */
    private String saleTwoStu;
    /** 品种名 */
    private String breedName;
    /** 单品名 */
    private String itemName;
    /** 品牌所有人 */
    private String brandOwnerName;
    /** 生产商名称 */
    private String producerName;
    /** 小包装特征 */
    private String packageFeature;
    /** 小包装件数/大包装个数 */
    private Integer packageNumber;
    /** 净重（克） */
    private java.math.BigDecimal netWeight;
    /** 毛重（克） */
    private java.math.BigDecimal grossWeight;
    /** 纸箱尺寸（cm），长*宽*高 */
    private String cartonDimension;
    /** 质量等级 */
    private String qualityGrade;
    /** 托盘堆码数(箱) */
    private Integer palletStackingLimit;
    /** 价盘期 */
    private String priceCycle;
    /** 中标价 */
    private java.math.BigDecimal bidPrice;
    /** 中标量 */
    private Integer bidNumber;
    /** 订单编号 */
    private String orderCode;
    /** 生产批次 */
    private String productionBatch;
    /** 入库日期 */
    private java.util.Date instockDate;
    /** 入库量(箱) */
    private Integer instockNumber;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdItemBrandProducerBatchSale() {
    }

    /**
     * <p>主键</p>
     *
     * @return 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * <p>主键</p>
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * <p>产品销售一级状态</p>
     *
     * @return 产品销售一级状态
     */
    public String getSaleOneStu() {
        return saleOneStu;
    }

    /**
     * <p>产品销售一级状态</p>
     *
     * @param saleOneStu 产品销售一级状态
     */
    public void setSaleOneStu(String saleOneStu) {
        this.saleOneStu = saleOneStu;
    }
    /**
     * <p>产品销售二级状态</p>
     *
     * @return 产品销售二级状态
     */
    public String getSaleTwoStu() {
        return saleTwoStu;
    }

    /**
     * <p>产品销售二级状态</p>
     *
     * @param saleTwoStu 产品销售二级状态
     */
    public void setSaleTwoStu(String saleTwoStu) {
        this.saleTwoStu = saleTwoStu;
    }
    /**
     * <p>品种名</p>
     *
     * @return 品种名
     */
    public String getBreedName() {
        return breedName;
    }

    /**
     * <p>品种名</p>
     *
     * @param breedName 品种名
     */
    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }
    /**
     * <p>单品名</p>
     *
     * @return 单品名
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * <p>单品名</p>
     *
     * @param itemName 单品名
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    /**
     * <p>品牌所有人</p>
     *
     * @return 品牌所有人
     */
    public String getBrandOwnerName() {
        return brandOwnerName;
    }

    /**
     * <p>品牌所有人</p>
     *
     * @param brandOwnerName 品牌所有人
     */
    public void setBrandOwnerName(String brandOwnerName) {
        this.brandOwnerName = brandOwnerName;
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
     * <p>小包装特征</p>
     *
     * @return 小包装特征
     */
    public String getPackageFeature() {
        return packageFeature;
    }

    /**
     * <p>小包装特征</p>
     *
     * @param packageFeature 小包装特征
     */
    public void setPackageFeature(String packageFeature) {
        this.packageFeature = packageFeature;
    }
    /**
     * <p>小包装件数/大包装个数</p>
     *
     * @return 小包装件数/大包装个数
     */
    public Integer getPackageNumber() {
        return packageNumber;
    }

    /**
     * <p>小包装件数/大包装个数</p>
     *
     * @param packageNumber 小包装件数/大包装个数
     */
    public void setPackageNumber(Integer packageNumber) {
        this.packageNumber = packageNumber;
    }
    /**
     * <p>净重（克）</p>
     *
     * @return 净重（克）
     */
    public java.math.BigDecimal getNetWeight() {
        return netWeight;
    }

    /**
     * <p>净重（克）</p>
     *
     * @param netWeight 净重（克）
     */
    public void setNetWeight(java.math.BigDecimal netWeight) {
        this.netWeight = netWeight;
    }
    /**
     * <p>毛重（克）</p>
     *
     * @return 毛重（克）
     */
    public java.math.BigDecimal getGrossWeight() {
        return grossWeight;
    }

    /**
     * <p>毛重（克）</p>
     *
     * @param grossWeight 毛重（克）
     */
    public void setGrossWeight(java.math.BigDecimal grossWeight) {
        this.grossWeight = grossWeight;
    }
    /**
     * <p>纸箱尺寸（cm），长*宽*高</p>
     *
     * @return 纸箱尺寸（cm），长*宽*高
     */
    public String getCartonDimension() {
        return cartonDimension;
    }

    /**
     * <p>纸箱尺寸（cm），长*宽*高</p>
     *
     * @param cartonDimension 纸箱尺寸（cm），长*宽*高
     */
    public void setCartonDimension(String cartonDimension) {
        this.cartonDimension = cartonDimension;
    }
    /**
     * <p>质量等级</p>
     *
     * @return 质量等级
     */
    public String getQualityGrade() {
        return qualityGrade;
    }

    /**
     * <p>质量等级</p>
     *
     * @param qualityGrade 质量等级
     */
    public void setQualityGrade(String qualityGrade) {
        this.qualityGrade = qualityGrade;
    }
    /**
     * <p>托盘堆码数(箱)</p>
     *
     * @return 托盘堆码数(箱)
     */
    public Integer getPalletStackingLimit() {
        return palletStackingLimit;
    }

    /**
     * <p>托盘堆码数(箱)</p>
     *
     * @param palletStackingLimit 托盘堆码数(箱)
     */
    public void setPalletStackingLimit(Integer palletStackingLimit) {
        this.palletStackingLimit = palletStackingLimit;
    }
    /**
     * <p>价盘期</p>
     *
     * @return 价盘期
     */
    public String getPriceCycle() {
        return priceCycle;
    }

    /**
     * <p>价盘期</p>
     *
     * @param priceCycle 价盘期
     */
    public void setPriceCycle(String priceCycle) {
        this.priceCycle = priceCycle;
    }
    /**
     * <p>中标价</p>
     *
     * @return 中标价
     */
    public java.math.BigDecimal getBidPrice() {
        return bidPrice;
    }

    /**
     * <p>中标价</p>
     *
     * @param bidPrice 中标价
     */
    public void setBidPrice(java.math.BigDecimal bidPrice) {
        this.bidPrice = bidPrice;
    }
    /**
     * <p>中标量</p>
     *
     * @return 中标量
     */
    public Integer getBidNumber() {
        return bidNumber;
    }

    /**
     * <p>中标量</p>
     *
     * @param bidNumber 中标量
     */
    public void setBidNumber(Integer bidNumber) {
        this.bidNumber = bidNumber;
    }
    /**
     * <p>订单编号</p>
     *
     * @return 订单编号
     */
    public String getOrderCode() {
        return orderCode;
    }

    /**
     * <p>订单编号</p>
     *
     * @param orderCode 订单编号
     */
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
    /**
     * <p>生产批次</p>
     *
     * @return 生产批次
     */
    public String getProductionBatch() {
        return productionBatch;
    }

    /**
     * <p>生产批次</p>
     *
     * @param productionBatch 生产批次
     */
    public void setProductionBatch(String productionBatch) {
        this.productionBatch = productionBatch;
    }
    /**
     * <p>入库日期</p>
     *
     * @return 入库日期
     */
    public java.util.Date getInstockDate() {
        return instockDate;
    }

    /**
     * <p>入库日期</p>
     *
     * @param instockDate 入库日期
     */
    public void setInstockDate(java.util.Date instockDate) {
        this.instockDate = instockDate;
    }
    /**
     * <p>入库量(箱)</p>
     *
     * @return 入库量(箱)
     */
    public Integer getInstockNumber() {
        return instockNumber;
    }

    /**
     * <p>入库量(箱)</p>
     *
     * @param instockNumber 入库量(箱)
     */
    public void setInstockNumber(Integer instockNumber) {
        this.instockNumber = instockNumber;
    }

}
