/*
 * 2016/12/14 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.bymt.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表BYMT_TERMINAL_MARKET_BASIC对应的实体BymtTerminalMarketBasic</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class BymtTerminalMarketBasic extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 批发市场UUID */
    private String termMarketId;
    /** 批发市场编码 */
    private String termMarketCode;
    /** 批发市场名称 */
    private String termMarketName;
    /** 批发市场地址 */
    private String termMarketAddress;
    /** 批发市场级别 (一级批发市场 二级批发市场...) */
    private String termMarketLevel;
    /** 物流区编码 */
    private String lgcsAreaCode;
    /** 物流区名称 */
    private String lgcsAreaName;
    /** 物流区ID */
    private long lgcsAreaId;
    /** 地区ID */
    private long zoneId;
    /** 地区编码 */
    private String zoneCode;
    /** 地区名称 */
    private String zoneName;
    /** 占地面积(单位:亩) */
    private Integer coverArea;

    /**
     * <p>默认构造函数</p>
     */
    public BymtTerminalMarketBasic() {
    }

    /**
     * <p>批发市场UUID</p>
     *
     * @return 批发市场UUID
     */
    public String getTermMarketId() {
        return termMarketId;
    }

    /**
     * <p>批发市场UUID</p>
     *
     * @param termMarketId 批发市场UUID
     */
    public void setTermMarketId(String termMarketId) {
        this.termMarketId = termMarketId;
    }
    /**
     * <p>批发市场编码</p>
     *
     * @return 批发市场编码
     */
    public String getTermMarketCode() {
        return termMarketCode;
    }

    /**
     * <p>批发市场编码</p>
     *
     * @param termMarketCode 批发市场编码
     */
    public void setTermMarketCode(String termMarketCode) {
        this.termMarketCode = termMarketCode;
    }
    /**
     * <p>批发市场名称</p>
     *
     * @return 批发市场名称
     */
    public String getTermMarketName() {
        return termMarketName;
    }

    /**
     * <p>批发市场名称</p>
     *
     * @param termMarketName 批发市场名称
     */
    public void setTermMarketName(String termMarketName) {
        this.termMarketName = termMarketName;
    }
    /**
     * <p>批发市场地址</p>
     *
     * @return 批发市场地址
     */
    public String getTermMarketAddress() {
        return termMarketAddress;
    }

    /**
     * <p>批发市场地址</p>
     *
     * @param termMarketAddress 批发市场地址
     */
    public void setTermMarketAddress(String termMarketAddress) {
        this.termMarketAddress = termMarketAddress;
    }
    /**
     * <p>批发市场级别 (一级批发市场 二级批发市场...)</p>
     *
     * @return 批发市场级别 (一级批发市场 二级批发市场...)
     */
    public String getTermMarketLevel() {
        return termMarketLevel;
    }

    /**
     * <p>批发市场级别 (一级批发市场 二级批发市场...)</p>
     *
     * @param termMarketLevel 批发市场级别 (一级批发市场 二级批发市场...)
     */
    public void setTermMarketLevel(String termMarketLevel) {
        this.termMarketLevel = termMarketLevel;
    }
    /**
     * <p>物流区编码</p>
     *
     * @return 物流区编码
     */
    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    /**
     * <p>物流区编码</p>
     *
     * @param lgcsAreaCode 物流区编码
     */
    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }
    /**
     * <p>物流区名称</p>
     *
     * @return 物流区名称
     */
    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

    /**
     * <p>物流区名称</p>
     *
     * @param lgcsAreaName 物流区名称
     */
    public void setLgcsAreaName(String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }

    public long getLgcsAreaId() {
        return lgcsAreaId;
    }

    public void setLgcsAreaId(long lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
    }

    public long getZoneId() {
        return zoneId;
    }

    public void setZoneId(long zoneId) {
        this.zoneId = zoneId;
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
     * <p>占地面积(单位:亩)</p>
     *
     * @return 占地面积(单位:亩)
     */
    public Integer getCoverArea() {
        return coverArea;
    }

    /**
     * <p>占地面积(单位:亩)</p>
     *
     * @param coverArea 占地面积(单位:亩)
     */
    public void setCoverArea(Integer coverArea) {
        this.coverArea = coverArea;
    }

}
