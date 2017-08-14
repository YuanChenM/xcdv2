package com.bms.bymt.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by guan_zhongheng on 2016/12/14.
 */
@ApiModel(value = "TerminalMarketBasicRsParam", description = "批发市场基础信息类")
public class TerminalMarketBasicRsParam extends BaseRestPaginationParam {

    @ApiModelProperty(value = "批发市场UUID")
    private String termMarketId;
    @ApiModelProperty(value = "批发市场编码")
    private String termMarketCode;
    @ApiModelProperty(value = "批发市场名称")
    private String termMarketName;
    @ApiModelProperty(value = "批发市场地址")
    private String termMarketAddress;
    @ApiModelProperty(value = "批发市场级别 (一级批发市场 二级批发市场...)")
    private String termMarketLevel;
    @ApiModelProperty(value = "物流区ID")
    private long lgcsAreaId;
    @ApiModelProperty(value = "物流区编码")
    private String lgcsAreaCode;
    @ApiModelProperty(value = "物流区名称")
    private String lgcsAreaName;
    @ApiModelProperty(value = "地区编码")
    private long zoneId;
    @ApiModelProperty(value = "地区编码")
    private String zoneCode;
    @ApiModelProperty(value = "地区名称")
    private String zoneName;
    @ApiModelProperty(value = "占地面积(单位:亩)")
    private Integer coverArea;
    @ApiModelProperty(value = "删除标识")
    private boolean delFlg;
    @ApiModelProperty(value = "批发市场级别名称")
    private String termMarketLevelName;

    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
        this.delFlg = delFlg;
    }

    public String getTermMarketId() {
        return termMarketId;
    }

    public void setTermMarketId(String termMarketId) {
        this.termMarketId = termMarketId;
    }

    public String getTermMarketCode() {
        return termMarketCode;
    }

    public void setTermMarketCode(String termMarketCode) {
        this.termMarketCode = termMarketCode;
    }

    public String getTermMarketName() {
        return termMarketName;
    }

    public void setTermMarketName(String termMarketName) {
        this.termMarketName = termMarketName;
    }

    public String getTermMarketAddress() {
        return termMarketAddress;
    }

    public void setTermMarketAddress(String termMarketAddress) {
        this.termMarketAddress = termMarketAddress;
    }

    public String getTermMarketLevel() {
        return termMarketLevel;
    }

    public void setTermMarketLevel(String termMarketLevel) {
        this.termMarketLevel = termMarketLevel;
    }

    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }

    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

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

    public Integer getCoverArea() {
        return coverArea;
    }

    public void setCoverArea(Integer coverArea) {
        this.coverArea = coverArea;
    }

    public String getTermMarketLevelName() {
        return termMarketLevelName;
    }

    public void setTermMarketLevelName(String termMarketLevelName) {
        this.termMarketLevelName = termMarketLevelName;
    }
}
