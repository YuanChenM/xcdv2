/*
 * 2017/03/27 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.como.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表como_sale_status对应的实体ComoSaleStatus</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class ComoSaleStatus extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 销售状态ID */
    private Long saleStatusId;
    /** 销售状态编码 */
    private String saleStatusCode;
    /** 销售状态名称 */
    private String saleStatusName;
    /** 是否默认 */
    private boolean isDefault;
    /** 是否有效 */
    private boolean isValid;

    /**
     * <p>默认构造函数</p>
     */
    public ComoSaleStatus() {
    }

    /**
     * <p>销售状态ID</p>
     *
     * @return 销售状态ID
     */
    public Long getSaleStatusId() {
        return saleStatusId;
    }

    /**
     * <p>销售状态ID</p>
     *
     * @param saleStatusId 销售状态ID
     */
    public void setSaleStatusId(Long saleStatusId) {
        this.saleStatusId = saleStatusId;
    }
    /**
     * <p>销售状态编码</p>
     *
     * @return 销售状态编码
     */
    public String getSaleStatusCode() {
        return saleStatusCode;
    }

    /**
     * <p>销售状态编码</p>
     *
     * @param saleStatusCode 销售状态编码
     */
    public void setSaleStatusCode(String saleStatusCode) {
        this.saleStatusCode = saleStatusCode;
    }
    /**
     * <p>销售状态名称</p>
     *
     * @return 销售状态名称
     */
    public String getSaleStatusName() {
        return saleStatusName;
    }

    /**
     * <p>销售状态名称</p>
     *
     * @param saleStatusName 销售状态名称
     */
    public void setSaleStatusName(String saleStatusName) {
        this.saleStatusName = saleStatusName;
    }
    /**
     * <p>是否默认</p>
     *
     * @return 是否默认
     */
    public boolean getIsDefault() {
        return isDefault;
    }

    /**
     * <p>是否默认</p>
     *
     * @param isDefault 是否默认
     */

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }
    /**
     * <p>是否有效</p>
     *
     * @return 是否有效
     */
    public boolean getIsValid() {
        return isValid;
    }

    /**
     * <p>是否有效</p>
     *
     * @param isValid 是否有效
     */
    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

}
