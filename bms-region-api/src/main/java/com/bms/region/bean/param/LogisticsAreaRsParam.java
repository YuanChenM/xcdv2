package com.bms.region.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by tao_zhifa on 2016/12/2.
 */
@ApiModel(value = "LogisticsAreaRsParam", description = "物流区域信息Param")
public class LogisticsAreaRsParam implements Serializable {

    @ApiModelProperty(value = "物流区编码")
    /** LGCS_AREA_CODE */
    private String lgcsAreaCode;

    @ApiModelProperty(value = "物流区名称")
    /** LGCS_AREA_NAME */
    private String lgcsAreaName;

    @ApiModelProperty(value = "物流区ID")
    /** LGCS_AREA_ID */
    private Long lgcsAreaId;
    @ApiModelProperty(value = "划分级别")
    /** DIVISION_LEVEL */
    private Integer divisionLevel;
    @ApiModelProperty(value = "是否有效数据")
    /** DISABLE_FLG */
    private String disableFlg;
    /** DEL_FLG */
    @ApiModelProperty(value = "删除标识")
    private boolean delFlg;


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

    public Long getLgcsAreaId() {
        return lgcsAreaId;
    }

    public void setLgcsAreaId(Long lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
    }

    public Integer getDivisionLevel() {
        return divisionLevel;
    }

    public void setDivisionLevel(Integer divisionLevel) {
        this.divisionLevel = divisionLevel;
    }

    public String getDisableFlg() {
        return disableFlg;
    }

    public void setDisableFlg(String disableFlg) {
        this.disableFlg = disableFlg;
    }

    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
        this.delFlg = delFlg;
    }
}
