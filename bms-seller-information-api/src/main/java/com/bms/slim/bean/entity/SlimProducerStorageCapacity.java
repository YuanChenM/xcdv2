/*
 * 2017/03/15 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表slim_producer_storage_capacity对应的实体SlimProducerStorageCapacity</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlimProducerStorageCapacity extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 库容ID */
    private Long storageCapacityId;
    /** 卖家角色ID */
    private Long sellerRoleId;
    /** 原料库容 */
    private Integer materialCapacity;
    /** 成品库容 */
    private Integer productCapacity;
    /** 仓库照URL */
    private String warehousePicUrl;

    /**
     * <p>默认构造函数</p>
     */
    public SlimProducerStorageCapacity() {
    }

    /**
     * <p>库容ID</p>
     *
     * @return 库容ID
     */
    public Long getStorageCapacityId() {
        return storageCapacityId;
    }

    /**
     * <p>库容ID</p>
     *
     * @param storageCapacityId 库容ID
     */
    public void setStorageCapacityId(Long storageCapacityId) {
        this.storageCapacityId = storageCapacityId;
    }
    /**
     * <p>卖家角色ID</p>
     *
     * @return 卖家角色ID
     */
    public Long getSellerRoleId() {
        return sellerRoleId;
    }

    /**
     * <p>卖家角色ID</p>
     *
     * @param sellerRoleId 卖家角色ID
     */
    public void setSellerRoleId(Long sellerRoleId) {
        this.sellerRoleId = sellerRoleId;
    }
    /**
     * <p>原料库容</p>
     *
     * @return 原料库容
     */
    public Integer getMaterialCapacity() {
        return materialCapacity;
    }

    /**
     * <p>原料库容</p>
     *
     * @param materialCapacity 原料库容
     */
    public void setMaterialCapacity(Integer materialCapacity) {
        this.materialCapacity = materialCapacity;
    }
    /**
     * <p>成品库容</p>
     *
     * @return 成品库容
     */
    public Integer getProductCapacity() {
        return productCapacity;
    }

    /**
     * <p>成品库容</p>
     *
     * @param productCapacity 成品库容
     */
    public void setProductCapacity(Integer productCapacity) {
        this.productCapacity = productCapacity;
    }
    /**
     * <p>仓库照URL</p>
     *
     * @return 仓库照URL
     */
    public String getWarehousePicUrl() {
        return warehousePicUrl;
    }

    /**
     * <p>仓库照URL</p>
     *
     * @param warehousePicUrl 仓库照URL
     */
    public void setWarehousePicUrl(String warehousePicUrl) {
        this.warehousePicUrl = warehousePicUrl;
    }

}
