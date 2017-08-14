package com.bms.linv.bean.param;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wang_fan on 2017/4/14.
 */
@ApiModel(value = "LINV0101IParam",
    description = "入库业务参数")
public class LINV0101IParam implements Serializable {
    public static String TRANSACTION_TYPE = "101";
    @ApiModelProperty(value = "source")
    private LINV0101ISourceParam source;

    @ApiModelProperty(value = "deal")
    private LINV0101IDealParam deal;

    public LINV0101ISourceParam getSource() {
        return source;
    }

    public void setSource(LINV0101ISourceParam source) {
        this.source = source;
    }

    public LINV0101IDealParam getDeal() {
        return deal;
    }

    public void setDeal(LINV0101IDealParam deal) {
        this.deal = deal;
    }



}