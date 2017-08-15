package com.bms.slpd.bean.param;

import com.bms.slpd.bean.entity.SlpdProducerProduct;
import com.bms.slpd.bean.entity.SlpdProduct;
import com.bms.slpd.bean.entity.SlpdSellerCommodity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0803IParam",
        description = "修改(卖家)单品品牌(规格)生产商接口入参")
public class SLPD0803IParam implements Serializable {

    @ApiModelProperty(value = "对象列表")
    private List<SlpdSellerCommodity> slpdSellerCommodities;
    @ApiModelProperty(value = "目标字段")
    private String[] targets;
    /*目标表
    targetTableFlg=0时,更新SLPD_PRODUCER_PRODUCT/SLPD_SELLER_COMMODITY/SLPD_PRODUCT表字段,
    targetTableFlg=1时,更新SLPD_SELLER_COMMODITY表字段,
    targetTableFlg=2时,更新SLPD_PRODUCT表类型状态,
    targetTableFlg=3时,更新SLPD_PRODUCER_PRODUCT表类型状态
    */
    @ApiModelProperty(value = "目标表")
    private int targetTableFlg;
    @ApiModelProperty(value = "产品表更新对象集合")
    private List<SlpdProduct> slpdProducts;
    @ApiModelProperty(value = "单品品牌(规格)生产商更新对象集合")
    private List<SlpdProducerProduct> slpdProducerProducts;

    public List<SlpdSellerCommodity> getSlpdSellerCommodities() {
        return slpdSellerCommodities;
    }

    public void setSlpdSellerCommodities(List<SlpdSellerCommodity> slpdSellerCommodities) {
        this.slpdSellerCommodities = slpdSellerCommodities;
    }

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }

    public int getTargetTableFlg() {
        return targetTableFlg;
    }

    public void setTargetTableFlg(int targetTableFlg) {
        this.targetTableFlg = targetTableFlg;
    }

    public List<SlpdProduct> getSlpdProducts() {
        return slpdProducts;
    }

    public void setSlpdProducts(List<SlpdProduct> slpdProducts) {
        this.slpdProducts = slpdProducts;
    }

    public List<SlpdProducerProduct> getSlpdProducerProducts() {
        return slpdProducerProducts;
    }

    public void setSlpdProducerProducts(List<SlpdProducerProduct> slpdProducerProducts) {
        this.slpdProducerProducts = slpdProducerProducts;
    }
}
