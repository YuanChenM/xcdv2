/*
 * 2017/03/23 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.como.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表como_commodity_uom对应的实体ComoCommodityUom</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class ComoCommodityUom extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 销售单位设定ID */
    private Long uomSid;
    /** 商品ID */
    private Long commodityId;
    /** 销售单位，CodeMaster，需要与产品处一致 */
    private String uom;
    /** 是否默认 */
    private Boolean isDefault;

    /**
     * <p>默认构造函数</p>
     */
    public ComoCommodityUom() {
    }

    /**
     * <p>销售单位设定ID</p>
     *
     * @return 销售单位设定ID
     */
    public Long getUomSid() {
        return uomSid;
    }

    /**
     * <p>销售单位设定ID</p>
     *
     * @param uomSid 销售单位设定ID
     */
    public void setUomSid(Long uomSid) {
        this.uomSid = uomSid;
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
     * <p>销售单位，CodeMaster，需要与产品处一致</p>
     *
     * @return 销售单位，CodeMaster，需要与产品处一致
     */
    public String getUom() {
        return uom;
    }

    /**
     * <p>销售单位，CodeMaster，需要与产品处一致</p>
     *
     * @param uom 销售单位，CodeMaster，需要与产品处一致
     */
    public void setUom(String uom) {
        this.uom = uom;
    }
    /**
     * <p>是否默认</p>
     *
     * @return 是否默认
     */
    public Boolean getIsDefault() {
        return isDefault;
    }

    /**
     * <p>是否默认</p>
     *
     * @param isDefault 是否默认
     */
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

}
