package com.bms.slpd.bean.param;

import com.framework.base.rest.param.BaseRestParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLPD0503IParam", description = "修改品牌单品接口入参")
public class SLPD0503IParam extends BaseRestParam {

    @ApiModelProperty(value = "品牌单品ID")
    private Long brandItemId;
    @ApiModelProperty(value = "品牌单品SKU")
    private String brandItemSku;
    @ApiModelProperty(value = "单品ID")
    private Long itemId;
    @ApiModelProperty(value = "品牌ID")
    private Long brandId;
    @ApiModelProperty(value = "删除标志")
    private boolean delFlg;
    @ApiModelProperty(value = "版本号")
    private Integer version;

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getBrandItemId() {
        return brandItemId;
    }

    public void setBrandItemId(Long brandItemId) {
        this.brandItemId = brandItemId;
    }

    public String getBrandItemSku() {
        return brandItemSku;
    }

    public void setBrandItemSku(String brandItemSku) {
        this.brandItemSku = brandItemSku;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
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
