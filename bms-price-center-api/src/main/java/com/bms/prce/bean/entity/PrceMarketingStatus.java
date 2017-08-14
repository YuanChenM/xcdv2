/*
 * 2017/01/24 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.prce.bean.entity;


import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表PRCE_MARKETING_STATUS对应的实体PrceMarketingStatus</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class PrceMarketingStatus extends BaseEntity {
    /**
     * 序列号
     */
    private static final long serialVersionUID = 1L;
    /**
     * 营销状态ID
     */
    private Long marketingStatusId;
    /**
     * 营销状态名称
     */
    private String marketingStatusName;
    /**
     * 单位
     */
    private String uom;
    /**
     * 所有人类型
     */
    private String ownerType;
    /**
     * 所有人ID
     */
    private Long ownerId;
    /**
     * 所有人名称
     */
    private String ownerName;

    /**
     * <p>默认构造函数</p>
     */
    public PrceMarketingStatus() {
    }

    /**
     * <p>营销状态ID</p>
     *
     * @return 营销状态ID
     */
    public Long getMarketingStatusId() {
        return marketingStatusId;
    }

    /**
     * <p>营销状态ID</p>
     *
     * @param marketingStatusId 营销状态ID
     */
    public void setMarketingStatusId(Long marketingStatusId) {
        this.marketingStatusId = marketingStatusId;
    }

    /**
     * <p>营销状态名称</p>
     *
     * @return 营销状态名称
     */
    public String getMarketingStatusName() {
        return marketingStatusName;
    }

    /**
     * <p>营销状态名称</p>
     *
     * @param marketingStatusName 营销状态名称
     */
    public void setMarketingStatusName(String marketingStatusName) {
        this.marketingStatusName = marketingStatusName;
    }

    /**
     * <p>单位</p>
     *
     * @return 单位
     */
    public String getUom() {
        return uom;
    }

    /**
     * <p>单位</p>
     *
     * @param uom 单位
     */
    public void setUom(String uom) {
        this.uom = uom;
    }

    /**
     * <p>所有人类型</p>
     *
     * @return 所有人类型
     */
    public String getOwnerType() {
        return ownerType;
    }

    /**
     * <p>所有人类型</p>
     *
     * @param ownerType 所有人类型
     */
    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    /**
     * <p>所有人ID</p>
     *
     * @return 所有人ID
     */
    public Long getOwnerId() {
        return ownerId;
    }

    /**
     * <p>所有人ID</p>
     *
     * @param ownerId 所有人ID
     */
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * <p>所有人名称</p>
     *
     * @return 所有人名称
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * <p>所有人名称</p>
     *
     * @param ownerName 所有人名称
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

}
