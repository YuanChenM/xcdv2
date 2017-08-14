package com.bms.linv.bean.param;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wang_fan on 2017/4/14.
 */
@ApiModel(value = "LINV0105IParam",
    description = "商品交易参数")
public class LINV0105IParam implements Serializable {
    public static String TRANSACTION_TYPE = "105";

    @ApiModelProperty(value = "source")
    private LINV0105ISourceParam source;

    @ApiModelProperty(value = "deal")
    private LINV0105IDealParam deal;


    public LINV0105ISourceParam getSource() {
        return source;
    }

    public void setSource(LINV0105ISourceParam source) {
        this.source = source;
    }

    public LINV0105IDealParam getDeal() {
        return deal;
    }

    public void setDeal(LINV0105IDealParam deal) {
        this.deal = deal;
    }
}