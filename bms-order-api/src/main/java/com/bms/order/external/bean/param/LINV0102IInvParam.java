package com.bms.order.external.bean.param;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wang_fan on 2017/4/19.
 */
public class LINV0102IInvParam implements Serializable {

    private LINV0102IInvSourceParam source = new LINV0102IInvSourceParam();

    private LINV0102IInvDealParam deal = new LINV0102IInvDealParam();

    public LINV0102IInvSourceParam getSource() {
        return source;
    }

    public void setSource(LINV0102IInvSourceParam source) {
        this.source = source;
    }

    public LINV0102IInvDealParam getDeal() {
        return deal;
    }

    public void setDeal(LINV0102IInvDealParam deal) {
        this.deal = deal;
    }
}