/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLPD_MANUFACTURE_GRADE_EVALUATE对应的实体SlpdManufactureGradeEvaluate</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdManufactureGradeEvaluate extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 主键 */
    private Long id;
    /** 二级分类名 */
    private String machiningName;
    /** 品牌名 */
    private String brandName;
    /** 卖家分类 */
    private String sellerType;
    /** 卖家名称 */
    private String sellerName;
    /** 候选产品池 */
    private String candidateProductPool;
    /** 候选产品池综合价格排名 */
    private String bidPoolPriceRank;
    /** 单品SKU等级分类 */
    private String itemSkuLevel;
    /** 接受电商模式程度 */
    private String olAcceptanceLevel;
    /** 稳定供货程度 */
    private String supplyStability;
    /** 接受贴牌评价 */
    private String oemEvaluation;
    /** 服务水平评价 */
    private String serviceEvaluation;
    /** 应标次数 */
    private Integer bidTimes;
    /** 中标次数 */
    private Integer bidWinningTimes;
    /** 卖方单位等级评定 */
    private String supplierRating;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdManufactureGradeEvaluate() {
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
     * <p>二级分类名</p>
     *
     * @return 二级分类名
     */
    public String getMachiningName() {
        return machiningName;
    }

    /**
     * <p>二级分类名</p>
     *
     * @param machiningName 二级分类名
     */
    public void setMachiningName(String machiningName) {
        this.machiningName = machiningName;
    }
    /**
     * <p>品牌名</p>
     *
     * @return 品牌名
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * <p>品牌名</p>
     *
     * @param brandName 品牌名
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    /**
     * <p>卖家分类</p>
     *
     * @return 卖家分类
     */
    public String getSellerType() {
        return sellerType;
    }

    /**
     * <p>卖家分类</p>
     *
     * @param sellerType 卖家分类
     */
    public void setSellerType(String sellerType) {
        this.sellerType = sellerType;
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
     * <p>候选产品池</p>
     *
     * @return 候选产品池
     */
    public String getCandidateProductPool() {
        return candidateProductPool;
    }

    /**
     * <p>候选产品池</p>
     *
     * @param candidateProductPool 候选产品池
     */
    public void setCandidateProductPool(String candidateProductPool) {
        this.candidateProductPool = candidateProductPool;
    }
    /**
     * <p>候选产品池综合价格排名</p>
     *
     * @return 候选产品池综合价格排名
     */
    public String getBidPoolPriceRank() {
        return bidPoolPriceRank;
    }

    /**
     * <p>候选产品池综合价格排名</p>
     *
     * @param bidPoolPriceRank 候选产品池综合价格排名
     */
    public void setBidPoolPriceRank(String bidPoolPriceRank) {
        this.bidPoolPriceRank = bidPoolPriceRank;
    }
    /**
     * <p>单品SKU等级分类</p>
     *
     * @return 单品SKU等级分类
     */
    public String getItemSkuLevel() {
        return itemSkuLevel;
    }

    /**
     * <p>单品SKU等级分类</p>
     *
     * @param itemSkuLevel 单品SKU等级分类
     */
    public void setItemSkuLevel(String itemSkuLevel) {
        this.itemSkuLevel = itemSkuLevel;
    }
    /**
     * <p>接受电商模式程度</p>
     *
     * @return 接受电商模式程度
     */
    public String getOlAcceptanceLevel() {
        return olAcceptanceLevel;
    }

    /**
     * <p>接受电商模式程度</p>
     *
     * @param olAcceptanceLevel 接受电商模式程度
     */
    public void setOlAcceptanceLevel(String olAcceptanceLevel) {
        this.olAcceptanceLevel = olAcceptanceLevel;
    }
    /**
     * <p>稳定供货程度</p>
     *
     * @return 稳定供货程度
     */
    public String getSupplyStability() {
        return supplyStability;
    }

    /**
     * <p>稳定供货程度</p>
     *
     * @param supplyStability 稳定供货程度
     */
    public void setSupplyStability(String supplyStability) {
        this.supplyStability = supplyStability;
    }
    /**
     * <p>接受贴牌评价</p>
     *
     * @return 接受贴牌评价
     */
    public String getOemEvaluation() {
        return oemEvaluation;
    }

    /**
     * <p>接受贴牌评价</p>
     *
     * @param oemEvaluation 接受贴牌评价
     */
    public void setOemEvaluation(String oemEvaluation) {
        this.oemEvaluation = oemEvaluation;
    }
    /**
     * <p>服务水平评价</p>
     *
     * @return 服务水平评价
     */
    public String getServiceEvaluation() {
        return serviceEvaluation;
    }

    /**
     * <p>服务水平评价</p>
     *
     * @param serviceEvaluation 服务水平评价
     */
    public void setServiceEvaluation(String serviceEvaluation) {
        this.serviceEvaluation = serviceEvaluation;
    }
    /**
     * <p>应标次数</p>
     *
     * @return 应标次数
     */
    public Integer getBidTimes() {
        return bidTimes;
    }

    /**
     * <p>应标次数</p>
     *
     * @param bidTimes 应标次数
     */
    public void setBidTimes(Integer bidTimes) {
        this.bidTimes = bidTimes;
    }
    /**
     * <p>中标次数</p>
     *
     * @return 中标次数
     */
    public Integer getBidWinningTimes() {
        return bidWinningTimes;
    }

    /**
     * <p>中标次数</p>
     *
     * @param bidWinningTimes 中标次数
     */
    public void setBidWinningTimes(Integer bidWinningTimes) {
        this.bidWinningTimes = bidWinningTimes;
    }
    /**
     * <p>卖方单位等级评定</p>
     *
     * @return 卖方单位等级评定
     */
    public String getSupplierRating() {
        return supplierRating;
    }

    /**
     * <p>卖方单位等级评定</p>
     *
     * @param supplierRating 卖方单位等级评定
     */
    public void setSupplierRating(String supplierRating) {
        this.supplierRating = supplierRating;
    }

}
