/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLPD_PRODUCER_SELLER_ONLINE对应的实体SlpdProducerSellerOnline</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdProducerSellerOnline extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 主键 */
    private Long id;
    /** 产品需求等级 */
    private String demandLevel;
    /** 品种名 */
    private String breedName;
    /** 单品名 */
    private String itemName;
    /** 品牌所有人 */
    private String brandOwnerName;
    /** 生产商名称 */
    private String producerName;
    /** 卖家名称 */
    private String sellerName;
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
    /** 登记日期 */
    private java.util.Date registerDate;
    /** 上线物流区 */
    private String lgcsareaName;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdProducerSellerOnline() {
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
     * <p>产品需求等级</p>
     *
     * @return 产品需求等级
     */
    public String getDemandLevel() {
        return demandLevel;
    }

    /**
     * <p>产品需求等级</p>
     *
     * @param demandLevel 产品需求等级
     */
    public void setDemandLevel(String demandLevel) {
        this.demandLevel = demandLevel;
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
     * <p>卖家名称</p>
     *
     * @return 卖家名称
     */
    public String getSellerName() {
        return sellerName;
    }

    /**
     * <p>卖家名称</p>
     *
     * @param sellerName 卖家名称
     */
    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
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
     * <p>登记日期</p>
     *
     * @return 登记日期
     */
    public java.util.Date getRegisterDate() {
        return registerDate;
    }

    /**
     * <p>登记日期</p>
     *
     * @param registerDate 登记日期
     */
    public void setRegisterDate(java.util.Date registerDate) {
        this.registerDate = registerDate;
    }
    /**
     * <p>上线物流区</p>
     *
     * @return 上线物流区
     */
    public String getLgcsareaName() {
        return lgcsareaName;
    }

    /**
     * <p>上线物流区</p>
     *
     * @param lgcsareaName 上线物流区
     */
    public void setLgcsareaName(String lgcsareaName) {
        this.lgcsareaName = lgcsareaName;
    }

}
