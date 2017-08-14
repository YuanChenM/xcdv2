/*
 * 2017/04/14 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.linv.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表invm_wh_info对应的实体InvmWhInfo</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class InvmWhInfo extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 仓库ID */
    private Long whId;
    /** 仓库编码 */
    private String whCode;
    /** 仓库名称 */
    private String whName;
    /** 仓库地址 */
    private String whAddr;
    /** 物流区域ID */
    private Long laId;

    /**
     * <p>默认构造函数</p>
     */
    public InvmWhInfo() {
    }

    /**
     * <p>仓库ID</p>
     *
     * @return 仓库ID
     */
    public Long getWhId() {
        return whId;
    }

    /**
     * <p>仓库ID</p>
     *
     * @param whId 仓库ID
     */
    public void setWhId(Long whId) {
        this.whId = whId;
    }
    /**
     * <p>仓库编码</p>
     *
     * @return 仓库编码
     */
    public String getWhCode() {
        return whCode;
    }

    /**
     * <p>仓库编码</p>
     *
     * @param whCode 仓库编码
     */
    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }
    /**
     * <p>仓库名称</p>
     *
     * @return 仓库名称
     */
    public String getWhName() {
        return whName;
    }

    /**
     * <p>仓库名称</p>
     *
     * @param whName 仓库名称
     */
    public void setWhName(String whName) {
        this.whName = whName;
    }
    /**
     * <p>仓库地址</p>
     *
     * @return 仓库地址
     */
    public String getWhAddr() {
        return whAddr;
    }

    /**
     * <p>仓库地址</p>
     *
     * @param whAddr 仓库地址
     */
    public void setWhAddr(String whAddr) {
        this.whAddr = whAddr;
    }
    /**
     * <p>物流区域ID</p>
     *
     * @return 物流区域ID
     */
    public Long getLaId() {
        return laId;
    }

    /**
     * <p>物流区域ID</p>
     *
     * @param laId 物流区域ID
     */
    public void setLaId(Long laId) {
        this.laId = laId;
    }

}
