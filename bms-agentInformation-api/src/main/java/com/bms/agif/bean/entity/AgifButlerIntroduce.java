/*
 * 2017/03/02 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.agif.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表AGIF_BUTLER_INTRODUCE对应的实体AgifButlerIntroduce</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class AgifButlerIntroduce extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** INTRODUCE_ID */
    private Long introduceId;
    /** BUTLER_ID */
    private String butlerId;
    /** 0：经历，1：服务心得，2：感悟或理想 */
    private String introduceType;
    /** INTRODUCE_DETAIL */
    private String introduceDetail;

    /**
     * <p>默认构造函数</p>
     */
    public AgifButlerIntroduce() {
    }

    /**
     * <p>INTRODUCE_ID</p>
     *
     * @return INTRODUCE_ID
     */
    public Long getIntroduceId() {
        return introduceId;
    }

    /**
     * <p>INTRODUCE_ID</p>
     *
     * @param introduceId INTRODUCE_ID
     */
    public void setIntroduceId(Long introduceId) {
        this.introduceId = introduceId;
    }
    /**
     * <p>BUTLER_ID</p>
     *
     * @return BUTLER_ID
     */
    public String getButlerId() {
        return butlerId;
    }

    /**
     * <p>BUTLER_ID</p>
     *
     * @param butlerId BUTLER_ID
     */
    public void setButlerId(String butlerId) {
        this.butlerId = butlerId;
    }
    /**
     * <p>0：经历，1：服务心得，2：感悟或理想</p>
     *
     * @return 0：经历，1：服务心得，2：感悟或理想
     */
    public String getIntroduceType() {
        return introduceType;
    }

    /**
     * <p>0：经历，1：服务心得，2：感悟或理想</p>
     *
     * @param introduceType 0：经历，1：服务心得，2：感悟或理想
     */
    public void setIntroduceType(String introduceType) {
        this.introduceType = introduceType;
    }
    /**
     * <p>INTRODUCE_DETAIL</p>
     *
     * @return INTRODUCE_DETAIL
     */
    public String getIntroduceDetail() {
        return introduceDetail;
    }

    /**
     * <p>INTRODUCE_DETAIL</p>
     *
     * @param introduceDetail INTRODUCE_DETAIL
     */
    public void setIntroduceDetail(String introduceDetail) {
        this.introduceDetail = introduceDetail;
    }

}
