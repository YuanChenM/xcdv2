package com.bms.region.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by guan_zhongheng on 2017/2/20.
 */
@ApiModel(value = "RegnLogisticsRelationParam", description = "物流区划、行政区划关联关系类")
public class RegnLogisticsRelationParam implements Serializable{

    @ApiModelProperty(value = "关联关系主键")
    private Long relaId;
    @ApiModelProperty(value = "物流区划主键")
    private String lgcsKey;
    @ApiModelProperty(value = "行政区划主键")
    private String regnKey;
    @ApiModelProperty(value = "关联层级（1：物流城市与行政城市 2：配送站与区县 3：领地与街道）")
    private String relaType;

    public Long getRelaId() {
        return relaId;
    }

    public void setRelaId(Long relaId) {
        this.relaId = relaId;
    }

    public String getLgcsKey() {
        return lgcsKey;
    }

    public void setLgcsKey(String lgcsKey) {
        this.lgcsKey = lgcsKey;
    }

    public String getRegnKey() {
        return regnKey;
    }

    public void setRegnKey(String regnKey) {
        this.regnKey = regnKey;
    }

    public String getRelaType() {
        return relaType;
    }

    public void setRelaType(String relaType) {
        this.relaType = relaType;
    }
}
