/*
 * 2017/03/15 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表slim_producer_workshop对应的实体SlimProducerWorkshop</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlimProducerWorkshop extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 主键ID */
    private Long workshopId;
    /** 卖家角色ID */
    private Long sellerRoleId;
    /** 车间名 */
    private String workshopName;
    /** 生产产品 */
    private String productionProduct;
    /** 工艺流程特点 */
    private String proccessFlowCharacter;
    /** 车间照 */
    private String workshopPicUrl;

    /**
     * <p>默认构造函数</p>
     */
    public SlimProducerWorkshop() {
    }

    /**
     * <p>主键ID</p>
     *
     * @return 主键ID
     */
    public Long getWorkshopId() {
        return workshopId;
    }

    /**
     * <p>主键ID</p>
     *
     * @param workshopId 主键ID
     */
    public void setWorkshopId(Long workshopId) {
        this.workshopId = workshopId;
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
     * <p>车间名</p>
     *
     * @return 车间名
     */
    public String getWorkshopName() {
        return workshopName;
    }

    /**
     * <p>车间名</p>
     *
     * @param workshopName 车间名
     */
    public void setWorkshopName(String workshopName) {
        this.workshopName = workshopName;
    }
    /**
     * <p>生产产品</p>
     *
     * @return 生产产品
     */
    public String getProductionProduct() {
        return productionProduct;
    }

    /**
     * <p>生产产品</p>
     *
     * @param productionProduct 生产产品
     */
    public void setProductionProduct(String productionProduct) {
        this.productionProduct = productionProduct;
    }
    /**
     * <p>工艺流程特点</p>
     *
     * @return 工艺流程特点
     */
    public String getProccessFlowCharacter() {
        return proccessFlowCharacter;
    }

    /**
     * <p>工艺流程特点</p>
     *
     * @param proccessFlowCharacter 工艺流程特点
     */
    public void setProccessFlowCharacter(String proccessFlowCharacter) {
        this.proccessFlowCharacter = proccessFlowCharacter;
    }
    /**
     * <p>车间照</p>
     *
     * @return 车间照
     */
    public String getWorkshopPicUrl() {
        return workshopPicUrl;
    }

    /**
     * <p>车间照</p>
     *
     * @param workshopPicUrl 车间照
     */
    public void setWorkshopPicUrl(String workshopPicUrl) {
        this.workshopPicUrl = workshopPicUrl;
    }

}
