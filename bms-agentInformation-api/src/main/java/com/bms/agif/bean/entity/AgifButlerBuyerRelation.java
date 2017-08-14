/*
 * 2017/03/15 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.agif.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表agif_butler_buyer_relation对应的实体AgifButlerBuyerRelation</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class AgifButlerBuyerRelation extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 关系ID */
    private Long relationId;
    /** 买手ID */
    private String agentId;
    /** 管家ID */
    private String butlerId;
    /** 买家ID */
    private String buyerId;
    /** 1:普通会员 2:专属会员 */
    private String memberType;
    /** 1:平台分配 2:买家找管家 3:管家找买家 */
    private String bingingType;
    /** 开始时间 */
    private java.util.Date startTime;
    /** 结束时间 */
    private java.util.Date endTime;
    /** 解除关系原因 */
    private String releaseReason;

    /**
     * <p>默认构造函数</p>
     */
    public AgifButlerBuyerRelation() {
    }

    /**
     * <p>关系ID</p>
     *
     * @return 关系ID
     */
    public Long getRelationId() {
        return relationId;
    }

    /**
     * <p>关系ID</p>
     *
     * @param relationId 关系ID
     */
    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }
    /**
     * <p>买手ID</p>
     *
     * @return 买手ID
     */
    public String getAgentId() {
        return agentId;
    }

    /**
     * <p>买手ID</p>
     *
     * @param agentId 买手ID
     */
    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }
    /**
     * <p>管家ID</p>
     *
     * @return 管家ID
     */
    public String getButlerId() {
        return butlerId;
    }

    /**
     * <p>管家ID</p>
     *
     * @param butlerId 管家ID
     */
    public void setButlerId(String butlerId) {
        this.butlerId = butlerId;
    }
    /**
     * <p>买家ID</p>
     *
     * @return 买家ID
     */
    public String getBuyerId() {
        return buyerId;
    }

    /**
     * <p>买家ID</p>
     *
     * @param buyerId 买家ID
     */
    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }
    /**
     * <p>1:普通会员 2:专属会员</p>
     *
     * @return 1:普通会员 2:专属会员
     */
    public String getMemberType() {
        return memberType;
    }

    /**
     * <p>1:普通会员 2:专属会员</p>
     *
     * @param memberType 1:普通会员 2:专属会员
     */
    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }
    /**
     * <p>1:平台分配 2:买家找管家 3:管家找买家</p>
     *
     * @return 1:平台分配 2:买家找管家 3:管家找买家
     */
    public String getBingingType() {
        return bingingType;
    }

    /**
     * <p>1:平台分配 2:买家找管家 3:管家找买家</p>
     *
     * @param bingingType 1:平台分配 2:买家找管家 3:管家找买家
     */
    public void setBingingType(String bingingType) {
        this.bingingType = bingingType;
    }
    /**
     * <p>开始时间</p>
     *
     * @return 开始时间
     */
    public java.util.Date getStartTime() {
        return startTime;
    }

    /**
     * <p>开始时间</p>
     *
     * @param startTime 开始时间
     */
    public void setStartTime(java.util.Date startTime) {
        this.startTime = startTime;
    }
    /**
     * <p>结束时间</p>
     *
     * @return 结束时间
     */
    public java.util.Date getEndTime() {
        return endTime;
    }

    /**
     * <p>结束时间</p>
     *
     * @param endTime 结束时间
     */
    public void setEndTime(java.util.Date endTime) {
        this.endTime = endTime;
    }
    /**
     * <p>解除关系原因</p>
     *
     * @return 解除关系原因
     */
    public String getReleaseReason() {
        return releaseReason;
    }

    /**
     * <p>解除关系原因</p>
     *
     * @param releaseReason 解除关系原因
     */
    public void setReleaseReason(String releaseReason) {
        this.releaseReason = releaseReason;
    }

}
