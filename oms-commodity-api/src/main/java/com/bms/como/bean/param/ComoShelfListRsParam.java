package com.bms.como.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhang_jian4 on 2017/3/31.
 */
@ApiModel(value = "ComoShelfListRsParam", description = "商品销售上下架管理-修改商品上下架状态入参")
public class ComoShelfListRsParam extends BaseRestPaginationParam {
    private static final long serialVersionUID = 1L;

    /**
     * 物流区商品的上下架状态信息
     * COMO_SHELF_LIST
     */
    @ApiModelProperty(value = "主键-上下架明细ID")
    private Long shelfDetailId;
    @ApiModelProperty(value = "物流区ID")
    private Long lgcsAreaId;
    @ApiModelProperty(value = "商品ID")
    private Long commodityId;
    @ApiModelProperty(value = "物流区编码")
    private String lgcsAreaCode;
    @ApiModelProperty(value = "物流区名称")
    private String lgcsAreaName;
    @ApiModelProperty(value = "销售上架日期")
    private Date addShelfTime;
    @ApiModelProperty(value = "销售下架日期")
    private Date offShelfTime;
    @ApiModelProperty(value = "销售下架日期清空标记")
    private String offShelfTimeFlg;
    @ApiModelProperty(value = "删除标识，true：已删除，false：未删除")
    private Boolean delFlg;
    @ApiModelProperty(value = "新建人ID")
    private String crtId;
    @ApiModelProperty(value = "新建时间")
    private Date crtTime;
    @ApiModelProperty(value = "修改人ID")
    private String updId;
    @ApiModelProperty(value = "修改时间")
    private Date updTime;
    @ApiModelProperty(value = "版本")
    private Integer ver;

    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

    public Long getShelfDetailId() {
        return shelfDetailId;
    }

    public void setShelfDetailId(Long shelfDetailId) {
        this.shelfDetailId = shelfDetailId;
    }

    public Long getLgcsAreaId() {
        return lgcsAreaId;
    }

    public void setLgcsAreaId(Long lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
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

    public Date getAddShelfTime() {
        return addShelfTime;
    }

    public void setAddShelfTime(Date addShelfTime) {
        this.addShelfTime = addShelfTime;
    }

    public Date getOffShelfTime() {
        return offShelfTime;
    }

    public void setOffShelfTime(Date offShelfTime) {
        this.offShelfTime = offShelfTime;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    public String getCrtId() {
        return crtId;
    }

    public void setCrtId(String crtId) {
        this.crtId = crtId;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public String getUpdId() {
        return updId;
    }

    public void setUpdId(String updId) {
        this.updId = updId;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }

    public String getOffShelfTimeFlg() {
        return offShelfTimeFlg;
    }

    public void setOffShelfTimeFlg(String offShelfTimeFlg) {
        this.offShelfTimeFlg = offShelfTimeFlg;
    }
}
