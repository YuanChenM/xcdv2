/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.param.field;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>表SLPD_BRAND_OWNER_RELATION对应的实体SlpdBrandOwnerRelation</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SLPD0408IBrandOwnerRelationParam implements Serializable {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "品牌与所有人关联ID")
    private Long boRelationId;
    @ApiModelProperty(value = "品牌ID")
    private Long brandId;
    @ApiModelProperty(value = "品牌所有人ID")
    private Long brandOwnerId;
    @ApiModelProperty(value = "删除标志")
    private boolean delFlg;
    @ApiModelProperty(value = "版本号")
    private Integer version;


    public Long getBoRelationId() {
        return boRelationId;
    }

    public void setBoRelationId(Long boRelationId) {
        this.boRelationId = boRelationId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getBrandOwnerId() {
        return brandOwnerId;
    }

    public void setBrandOwnerId(Long brandOwnerId) {
        this.brandOwnerId = brandOwnerId;
    }

    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
        this.delFlg = delFlg;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
