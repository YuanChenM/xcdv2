/*
 * 2016/12/06 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.byim.bean.entity;


import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表BYIM_MARKETING_STATUS对应的实体ByimMarketingStatus</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class ByimMarketingStatus extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** MARKETING_STATUS_ID */
    private Long marketingStatusId;
    /** PARENT_ID */
    private Long parentId;
    /** NODE_PATH */
    private String nodePath;
    /** MARKETING_STATUS_NAME */
    private String marketingStatusName;
    /** MARKETING_STATUS_CODE */
    private String marketingStatusCode;

    /**
     * <p>默认构造函数</p>
     */
    public ByimMarketingStatus() {
    }

    /**
     * <p>MARKETING_STATUS_ID</p>
     *
     * @return MARKETING_STATUS_ID
     */
    public Long getMarketingStatusId() {
        return marketingStatusId;
    }

    /**
     * <p>MARKETING_STATUS_ID</p>
     *
     * @param marketingStatusId MARKETING_STATUS_ID
     */
    public void setMarketingStatusId(Long marketingStatusId) {
        this.marketingStatusId = marketingStatusId;
    }
    /**
     * <p>PARENT_ID</p>
     *
     * @return PARENT_ID
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * <p>PARENT_ID</p>
     *
     * @param parentId PARENT_ID
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    /**
     * <p>NODE_PATH</p>
     *
     * @return NODE_PATH
     */
    public String getNodePath() {
        return nodePath;
    }

    /**
     * <p>NODE_PATH</p>
     *
     * @param nodePath NODE_PATH
     */
    public void setNodePath(String nodePath) {
        this.nodePath = nodePath;
    }
    /**
     * <p>MARKETING_STATUS_NAME</p>
     *
     * @return MARKETING_STATUS_NAME
     */
    public String getMarketingStatusName() {
        return marketingStatusName;
    }

    /**
     * <p>MARKETING_STATUS_NAME</p>
     *
     * @param marketingStatusName MARKETING_STATUS_NAME
     */
    public void setMarketingStatusName(String marketingStatusName) {
        this.marketingStatusName = marketingStatusName;
    }
    /**
     * <p>MARKETING_STATUS_CODE</p>
     *
     * @return MARKETING_STATUS_CODE
     */
    public String getMarketingStatusCode() {
        return marketingStatusCode;
    }

    /**
     * <p>MARKETING_STATUS_CODE</p>
     *
     * @param marketingStatusCode MARKETING_STATUS_CODE
     */
    public void setMarketingStatusCode(String marketingStatusCode) {
        this.marketingStatusCode = marketingStatusCode;
    }

}
