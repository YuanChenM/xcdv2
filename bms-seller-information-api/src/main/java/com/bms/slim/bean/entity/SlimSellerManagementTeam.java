/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLIM_SELLER_MANAGEMENT_TEAM对应的实体SlimSellerManagementTeam</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlimSellerManagementTeam extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 卖家经营管理团队ID */
    private Long smtId;
    /** 实体卖家ID */
    private Long entitySellerId;
    /** 职务类型 */
    private String positionType;
    /** 姓名 */
    private String name;
    /** 年龄 */
    private Integer age;
    /** 文化程度 */
    private String educationalLevel;
    /** 联系方式 */
    private String contactWay;
    /** 头像 */
    private String avatarUrl;

    /**
     * <p>默认构造函数</p>
     */
    public SlimSellerManagementTeam() {
    }

    /**
     * <p>卖家经营管理团队ID</p>
     *
     * @return 卖家经营管理团队ID
     */
    public Long getSmtId() {
        return smtId;
    }

    /**
     * <p>卖家经营管理团队ID</p>
     *
     * @param smtId 卖家经营管理团队ID
     */
    public void setSmtId(Long smtId) {
        this.smtId = smtId;
    }
    /**
     * <p>实体卖家ID</p>
     *
     * @return 实体卖家ID
     */
    public Long getEntitySellerId() {
        return entitySellerId;
    }

    /**
     * <p>实体卖家ID</p>
     *
     * @param entitySellerId 实体卖家ID
     */
    public void setEntitySellerId(Long entitySellerId) {
        this.entitySellerId = entitySellerId;
    }
    /**
     * <p>职务类型</p>
     *
     * @return 职务类型
     */
    public String getPositionType() {
        return positionType;
    }

    /**
     * <p>职务类型</p>
     *
     * @param positionType 职务类型
     */
    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }
    /**
     * <p>姓名</p>
     *
     * @return 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * <p>姓名</p>
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * <p>年龄</p>
     *
     * @return 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * <p>年龄</p>
     *
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }
    /**
     * <p>文化程度</p>
     *
     * @return 文化程度
     */
    public String getEducationalLevel() {
        return educationalLevel;
    }

    /**
     * <p>文化程度</p>
     *
     * @param educationalLevel 文化程度
     */
    public void setEducationalLevel(String educationalLevel) {
        this.educationalLevel = educationalLevel;
    }
    /**
     * <p>联系方式</p>
     *
     * @return 联系方式
     */
    public String getContactWay() {
        return contactWay;
    }

    /**
     * <p>联系方式</p>
     *
     * @param contactWay 联系方式
     */
    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }
    /**
     * <p>头像</p>
     *
     * @return 头像
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * <p>头像</p>
     *
     * @param avatarUrl 头像
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

}
