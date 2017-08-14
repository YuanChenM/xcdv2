/*
 * 2017/02/16 自动生成 新规作成
 * (c) 江苏润和
 */
package com.bms.region.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>
 * 表REGN_LOGISTICS_ZONE对应的实体RegnLogisticsZone
 * </p>
 *regn_logistics_city
 * @author 自动生成
 * @version 1.0.0
 */
public class RegnLogisticsZone extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 物流区划城市主键 */
    private Long zoneId;
    /** 物流区主键 */
    private Long lgcsAreaId;
    /** 物流区划编码 */
    private String zoneCode;
    /** 物流区划名称 */
    private String zoneName;
    /** 数据有效性标识(默认为有效) */
    private String disableFlg;

    /**
     * <p>
     * 默认构造函数
     * </p>
     */
    public RegnLogisticsZone() {}

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    /**
     * <p>
     * 物流区主键
     * </p>
     *
     * @return 物流区主键
     */
    public Long getLgcsAreaId() {
        return lgcsAreaId;
    }

    /**
     * <p>
     * 物流区主键
     * </p>
     *
     * @param lgcsAreaId 物流区主键
     */
    public void setLgcsAreaId(Long lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
    }

    /**
     * <p>
     * 数据有效性标识(默认为有效)
     * </p>
     *
     * @return 数据有效性标识(默认为有效)
     */
    public String getDisableFlg() {
        return disableFlg;
    }

    /**
     * <p>
     * 数据有效性标识(默认为有效)
     * </p>
     *
     * @param disableFlg 数据有效性标识(默认为有效)
     */
    public void setDisableFlg(String disableFlg) {
        this.disableFlg = disableFlg;
    }

}
