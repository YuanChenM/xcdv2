package com.bms.slpd.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0608IParam",
        description = "查询加工技术标准指标(差异)接口入参")
public class SLPD0608IParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "通过查询breedId查询全部差异卡标志,等于1时查询breedId下所有差异卡,其它查询标准卡")
    private int findAllFlag;
    @ApiModelProperty(value = "品种Id集合")
    private List<Long> breedIds;
    @ApiModelProperty(value = "产品Id集合")
    private List<String> productIds;
    @ApiModelProperty(value = "删除标识")
    private boolean delFlg;


    public int getFindAllFlag() {
        return findAllFlag;
    }

    public void setFindAllFlag(int findAllFlag) {
        this.findAllFlag = findAllFlag;
    }

    public List<Long> getBreedIds() {
        return breedIds;
    }

    public void setBreedIds(List<Long> breedIds) {
        this.breedIds = breedIds;
    }

    public List<String> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<String> productIds) {
        this.productIds = productIds;
    }

    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
        this.delFlg = delFlg;
    }
}
