package com.bms.linv.bean.param;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wang_fan on 2017/4/19.
 */
@ApiModel(value = "LINV0102IParam",
    description = "销售出库参数")
public class LINV0102IParam implements Serializable {
    public static String TRANSACTION_TYPE = "102";

    @ApiModelProperty(value = "source")
    private LINV0102ISourceParam source;

    @ApiModelProperty(value = "deal")
    private LINV0102IDealParam deal;

    public LINV0102ISourceParam getSource() {
        return source;
    }

    public void setSource(LINV0102ISourceParam source) {
        this.source = source;
    }

    public LINV0102IDealParam getDeal() {
        return deal;
    }

    public void setDeal(LINV0102IDealParam deal) {
        this.deal = deal;
    }
}