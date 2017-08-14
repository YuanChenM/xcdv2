package com.bms.como.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by yuan_zhifei on 2017/4/12.
 */
@ApiModel(value = "BatchStorageRsParam", description = "入库批次入参")
public class BatchStorageRsParam implements Serializable {
    @ApiModelProperty(value = "入库批次")
    private String lotNo;
    @ApiModelProperty(value = "产品数量（对应单位箱或者包）")
    private BigDecimal adjustQty;

    public String getLotNo() {
        return lotNo;
    }

    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }

    public BigDecimal getAdjustQty() {
        return adjustQty;
    }

    public void setAdjustQty(BigDecimal adjustQty) {
        this.adjustQty = adjustQty;
    }
}
