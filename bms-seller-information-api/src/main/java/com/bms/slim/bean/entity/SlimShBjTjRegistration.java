/*
 * 2017/03/17 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表slim_sh_bj_tj_registration对应的实体SlimShBjTjRegistration</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlimShBjTjRegistration extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 主键ID */
    private Long sbtRegId;
    /** 卖家角色ID */
    private Long sellerRoleId;
    /** 单位名称 */
    private String workunitName;
    /** 产品品类名称 */
    private String productCategoryName;
    /** 登记日期 */
    private java.util.Date regDate;
    /** 进沪(京、津)登记URL */
    private String sbtRegUrl;

    /**
     * <p>默认构造函数</p>
     */
    public SlimShBjTjRegistration() {
    }

    /**
     * <p>主键ID</p>
     *
     * @return 主键ID
     */
    public Long getSbtRegId() {
        return sbtRegId;
    }

    /**
     * <p>主键ID</p>
     *
     * @param sbtRegId 主键ID
     */
    public void setSbtRegId(Long sbtRegId) {
        this.sbtRegId = sbtRegId;
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
     * <p>单位名称</p>
     *
     * @return 单位名称
     */
    public String getWorkunitName() {
        return workunitName;
    }

    /**
     * <p>单位名称</p>
     *
     * @param workunitName 单位名称
     */
    public void setWorkunitName(String workunitName) {
        this.workunitName = workunitName;
    }
    /**
     * <p>产品品类名称</p>
     *
     * @return 产品品类名称
     */
    public String getProductCategoryName() {
        return productCategoryName;
    }

    /**
     * <p>产品品类名称</p>
     *
     * @param productCategoryName 产品品类名称
     */
    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }
    /**
     * <p>登记日期</p>
     *
     * @return 登记日期
     */
    public java.util.Date getRegDate() {
        return regDate;
    }

    /**
     * <p>登记日期</p>
     *
     * @param regDate 登记日期
     */
    public void setRegDate(java.util.Date regDate) {
        this.regDate = regDate;
    }
    /**
     * <p>进沪(京、津)登记URL</p>
     *
     * @return 进沪(京、津)登记URL
     */
    public String getSbtRegUrl() {
        return sbtRegUrl;
    }

    /**
     * <p>进沪(京、津)登记URL</p>
     *
     * @param sbtRegUrl 进沪(京、津)登记URL
     */
    public void setSbtRegUrl(String sbtRegUrl) {
        this.sbtRegUrl = sbtRegUrl;
    }

}
