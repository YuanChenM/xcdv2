package com.bms.linv.bean.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by wang_haichun on 2017/4/17.
 */
public class LINV0106IParam implements Serializable {
    public static String TRANSACTION_TYPE = "106";

    @ApiModelProperty(value = "来源信息")
    private LINV0106ISourceParam source;
    @ApiModelProperty(value = "交易信息")
    private LINV0106IDealParam deal;

    public LINV0106ISourceParam getSource() {
        return source;
    }

    public void setSource(LINV0106ISourceParam source) {
        this.source = source;
    }

    public LINV0106IDealParam getDeal() {
        return deal;
    }

    public void setDeal(LINV0106IDealParam deal) {
        this.deal = deal;
    }
}
