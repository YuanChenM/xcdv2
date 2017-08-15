package com.bms.order.external.bean.param;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wang_fan on 2017/4/14.
 */
public class LINV0105IInvParam implements Serializable {

    private LINV0105IInvSourceParam source = new LINV0105IInvSourceParam();

    private LINV0105IInvDealParam deal = new LINV0105IInvDealParam();


    public LINV0105IInvSourceParam getSource() {
        return source;
    }

    public void setSource(LINV0105IInvSourceParam source) {
        this.source = source;
    }

    public LINV0105IInvDealParam getDeal() {
        return deal;
    }

    public void setDeal(LINV0105IInvDealParam deal) {
        this.deal = deal;
    }
}