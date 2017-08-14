/*
 * 2016/12/01 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.region.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表REGN_PROVINCE对应的实体RegnProvince</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class RegnProvince extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** PROVINCE_ID */
    private Long provinceId;
    /** PROVINCE_CODE */
    private String provinceCode;
    /** PROVINCE_NAME */
    private String provinceName;
    /** DIVISION_LEVEL */
    private Integer divisionLevel;
    /** DISABLE_FLG */
    private String disableFlg;

    /**
     * <p>默认构造函数</p>
     */
    public RegnProvince() {
    }

    /**
     * <p>PROVINCE_ID</p>
     *
     * @return PROVINCE_ID
     */
    public Long getProvinceId() {
        return provinceId;
    }

    /**
     * <p>PROVINCE_ID</p>
     *
     * @param provinceId PROVINCE_ID
     */
    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }
    /**
     * <p>PROVINCE_CODE</p>
     *
     * @return PROVINCE_CODE
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * <p>PROVINCE_CODE</p>
     *
     * @param provinceCode PROVINCE_CODE
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }
    /**
     * <p>PROVINCE_NAME</p>
     *
     * @return PROVINCE_NAME
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * <p>PROVINCE_NAME</p>
     *
     * @param provinceName PROVINCE_NAME
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
    /**
     * <p>DIVISION_LEVEL</p>
     *
     * @return DIVISION_LEVEL
     */
    public Integer getDivisionLevel() {
        return divisionLevel;
    }

    /**
     * <p>DIVISION_LEVEL</p>
     *
     * @param divisionLevel DIVISION_LEVEL
     */
    public void setDivisionLevel(Integer divisionLevel) {
        this.divisionLevel = divisionLevel;
    }
    /**
     * <p>DISABLE_FLG</p>
     *
     * @return DISABLE_FLG
     */
    public String getDisableFlg() {
        return disableFlg;
    }

    /**
     * <p>DISABLE_FLG</p>
     *
     * @param disableFlg DISABLE_FLG
     */
    public void setDisableFlg(String disableFlg) {
        this.disableFlg = disableFlg;
    }

}
