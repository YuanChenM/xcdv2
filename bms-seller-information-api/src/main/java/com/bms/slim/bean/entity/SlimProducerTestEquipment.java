/*
 * 2017/03/15 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表slim_producer_test_equipment对应的实体SlimProducerTestEquipment</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlimProducerTestEquipment extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 检测设备ID */
    private Long testEqpId;
    /** 卖家角色ID */
    private Long sellerRoleId;
    /** 设备名称 */
    private String testEqpName;
    /** 设备主要用途 */
    private String testEqpUse;
    /** 设备照片 */
    private String testEqpPicUrl;

    /**
     * <p>默认构造函数</p>
     */
    public SlimProducerTestEquipment() {
    }

    /**
     * <p>检测设备ID</p>
     *
     * @return 检测设备ID
     */
    public Long getTestEqpId() {
        return testEqpId;
    }

    /**
     * <p>检测设备ID</p>
     *
     * @param testEqpId 检测设备ID
     */
    public void setTestEqpId(Long testEqpId) {
        this.testEqpId = testEqpId;
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
     * <p>设备名称</p>
     *
     * @return 设备名称
     */
    public String getTestEqpName() {
        return testEqpName;
    }

    /**
     * <p>设备名称</p>
     *
     * @param testEqpName 设备名称
     */
    public void setTestEqpName(String testEqpName) {
        this.testEqpName = testEqpName;
    }
    /**
     * <p>设备主要用途</p>
     *
     * @return 设备主要用途
     */
    public String getTestEqpUse() {
        return testEqpUse;
    }

    /**
     * <p>设备主要用途</p>
     *
     * @param testEqpUse 设备主要用途
     */
    public void setTestEqpUse(String testEqpUse) {
        this.testEqpUse = testEqpUse;
    }
    /**
     * <p>设备照片</p>
     *
     * @return 设备照片
     */
    public String getTestEqpPicUrl() {
        return testEqpPicUrl;
    }

    /**
     * <p>设备照片</p>
     *
     * @param testEqpPicUrl 设备照片
     */
    public void setTestEqpPicUrl(String testEqpPicUrl) {
        this.testEqpPicUrl = testEqpPicUrl;
    }

}
