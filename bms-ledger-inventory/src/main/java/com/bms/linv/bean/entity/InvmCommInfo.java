/*
 * 2017/04/14 自动生成 新规作成
 * (c) 江苏润和
 */
package com.bms.linv.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>
 * 表invm_comm_info对应的实体InvmCommInfo
 * </p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class InvmCommInfo extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 记录ID */
    private Long infoId;
    /** 商品ID */
    private String commodityId;
    /** 物流区域ID */
    private Long laId;
    /** 商品名称 */
    private String commodityName;
    /** 产品ID */
    private String pdId;
    /** 生产商ID，指定生成商作为条件时才会有值 */
    private Long pdrsId;
    /** 生产商编码，指定生成商作为条件时才会有值 */
    private String pdrsCode;
    /** 生产商名称，指定生成商作为条件时才会有值 */
    private String pdrsName;
    /** 采购批次，指定采购批次作为条件时才会有值 */
    private String lotNo;
    /** 销售状态ID */
    private Long saleStatusId;
    /** 销售状态编码 */
    private String saleStatusCode;
    /** 销售状态名称 */
    private String saleStatusName;

    /**
     * <p>
     * 默认构造函数
     * </p>
     */
    public InvmCommInfo() {}

    /**
     * <p>
     * 记录ID
     * </p>
     *
     * @return 记录ID
     */
    public Long getInfoId() {
        return infoId;
    }

    /**
     * <p>
     * 记录ID
     * </p>
     *
     * @param infoId 记录ID
     */
    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }

    /**
     * <p>
     * 商品ID
     * </p>
     *
     * @return 商品ID
     */
    public String getCommodityId() {
        return commodityId;
    }

    /**
     * <p>
     * 商品ID
     * </p>
     *
     * @param commodityId 商品ID
     */
    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    /**
     * <p>
     * 物流区域ID
     * </p>
     *
     * @return 物流区域ID
     */
    public Long getLaId() {
        return laId;
    }

    /**
     * <p>
     * 物流区域ID
     * </p>
     *
     * @param laId 物流区域ID
     */
    public void setLaId(Long laId) {
        this.laId = laId;
    }

    /**
     * <p>
     * 商品名称
     * </p>
     *
     * @return 商品名称
     */
    public String getCommodityName() {
        return commodityName;
    }

    /**
     * <p>
     * 商品名称
     * </p>
     *
     * @param commodityName 商品名称
     */
    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    /**
     * <p>
     * 产品ID
     * </p>
     *
     * @return 产品ID
     */
    public String getPdId() {
        return pdId;
    }

    /**
     * <p>
     * 产品ID
     * </p>
     *
     * @param pdId 产品ID
     */
    public void setPdId(String pdId) {
        this.pdId = pdId;
    }

    /**
     * <p>
     * 生产商ID，指定生成商作为条件时才会有值
     * </p>
     *
     * @return 生产商ID，指定生成商作为条件时才会有值
     */
    public Long getPdrsId() {
        return pdrsId;
    }

    /**
     * <p>
     * 生产商ID，指定生成商作为条件时才会有值
     * </p>
     *
     * @param pdrsId 生产商ID，指定生成商作为条件时才会有值
     */
    public void setPdrsId(Long pdrsId) {
        this.pdrsId = pdrsId;
    }

    /**
     * <p>
     * 生产商编码，指定生成商作为条件时才会有值
     * </p>
     *
     * @return 生产商编码，指定生成商作为条件时才会有值
     */
    public String getPdrsCode() {
        return pdrsCode;
    }

    /**
     * <p>
     * 生产商编码，指定生成商作为条件时才会有值
     * </p>
     *
     * @param pdrsCode 生产商编码，指定生成商作为条件时才会有值
     */
    public void setPdrsCode(String pdrsCode) {
        this.pdrsCode = pdrsCode;
    }

    /**
     * <p>
     * 生产商名称，指定生成商作为条件时才会有值
     * </p>
     *
     * @return 生产商名称，指定生成商作为条件时才会有值
     */
    public String getPdrsName() {
        return pdrsName;
    }

    /**
     * <p>
     * 生产商名称，指定生成商作为条件时才会有值
     * </p>
     *
     * @param pdrsName 生产商名称，指定生成商作为条件时才会有值
     */
    public void setPdrsName(String pdrsName) {
        this.pdrsName = pdrsName;
    }

    /**
     * <p>
     * 采购批次，指定采购批次作为条件时才会有值
     * </p>
     *
     * @return 采购批次，指定采购批次作为条件时才会有值
     */
    public String getLotNo() {
        return lotNo;
    }

    /**
     * <p>
     * 采购批次，指定采购批次作为条件时才会有值
     * </p>
     *
     * @param lotNo 采购批次，指定采购批次作为条件时才会有值
     */
    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }

    /**
     * <p>
     * 销售状态ID
     * </p>
     *
     * @return 销售状态ID
     */
    public Long getSaleStatusId() {
        return saleStatusId;
    }

    /**
     * <p>
     * 销售状态ID
     * </p>
     *
     * @param saleStatusId 销售状态ID
     */
    public void setSaleStatusId(Long saleStatusId) {
        this.saleStatusId = saleStatusId;
    }

    /**
     * <p>
     * 销售状态编码
     * </p>
     *
     * @return 销售状态编码
     */
    public String getSaleStatusCode() {
        return saleStatusCode;
    }

    /**
     * <p>
     * 销售状态编码
     * </p>
     *
     * @param saleStatusCode 销售状态编码
     */
    public void setSaleStatusCode(String saleStatusCode) {
        this.saleStatusCode = saleStatusCode;
    }

    /**
     * <p>
     * 销售状态名称
     * </p>
     *
     * @return 销售状态名称
     */
    public String getSaleStatusName() {
        return saleStatusName;
    }

    /**
     * <p>
     * 销售状态名称
     * </p>
     *
     * @param saleStatusName 销售状态名称
     */
    public void setSaleStatusName(String saleStatusName) {
        this.saleStatusName = saleStatusName;
    }

}
