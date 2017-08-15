/*
 * 2017/03/15 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表slim_designat_slaughter_permit对应的实体SlimDesignatSlaughterPermit</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlimDesignatSlaughterPermit extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 主键ID */
    private Long dspId;
    /** 卖家角色ID */
    private Long sellerRoleId;
    /** 批准号 */
    private String approvalNo;
    /** 定点屠宰代码 */
    private String dsgtSlgtPrmtCode;
    /** 定点屠宰许可证URL */
    private String dsgtSlgtPrmtUrl;

    /**
     * <p>默认构造函数</p>
     */
    public SlimDesignatSlaughterPermit() {
    }

    /**
     * <p>主键ID</p>
     *
     * @return 主键ID
     */
    public Long getDspId() {
        return dspId;
    }

    /**
     * <p>主键ID</p>
     *
     * @param dspId 主键ID
     */
    public void setDspId(Long dspId) {
        this.dspId = dspId;
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
     * <p>批准号</p>
     *
     * @return 批准号
     */
    public String getApprovalNo() {
        return approvalNo;
    }

    /**
     * <p>批准号</p>
     *
     * @param approvalNo 批准号
     */
    public void setApprovalNo(String approvalNo) {
        this.approvalNo = approvalNo;
    }
    /**
     * <p>定点屠宰代码</p>
     *
     * @return 定点屠宰代码
     */
    public String getDsgtSlgtPrmtCode() {
        return dsgtSlgtPrmtCode;
    }

    /**
     * <p>定点屠宰代码</p>
     *
     * @param dsgtSlgtPrmtCode 定点屠宰代码
     */
    public void setDsgtSlgtPrmtCode(String dsgtSlgtPrmtCode) {
        this.dsgtSlgtPrmtCode = dsgtSlgtPrmtCode;
    }
    /**
     * <p>定点屠宰许可证URL</p>
     *
     * @return 定点屠宰许可证URL
     */
    public String getDsgtSlgtPrmtUrl() {
        return dsgtSlgtPrmtUrl;
    }

    /**
     * <p>定点屠宰许可证URL</p>
     *
     * @param dsgtSlgtPrmtUrl 定点屠宰许可证URL
     */
    public void setDsgtSlgtPrmtUrl(String dsgtSlgtPrmtUrl) {
        this.dsgtSlgtPrmtUrl = dsgtSlgtPrmtUrl;
    }

}
