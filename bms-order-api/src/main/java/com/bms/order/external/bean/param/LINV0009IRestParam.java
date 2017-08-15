package com.bms.order.external.bean.param;

import java.io.Serializable;

/**
 * Created by ni_shaotang on 2017/3/15.
 */
public class LINV0009IRestParam implements Serializable {
    private static final long serialVersionUID = 1L;
    private LINV0009ISource source = new LINV0009ISource();
    private LINV0009IDeal deal = new LINV0009IDeal();

    public LINV0009ISource getSource() {
        return source;
    }

    public void setSource(LINV0009ISource source) {
        this.source = source;
    }

    public LINV0009IDeal getDeal() {
        return deal;
    }

    public void setDeal(LINV0009IDeal deal) {
        this.deal = deal;
    }
}
