package com.bms.order.external.bean.param;

import java.io.Serializable;

/**
 * Created by ni_shaotang on 2017/3/2.
 */
public class LINV0002IRestParam implements Serializable {
    private static final long serialVersionUID = 1L;
    private LINV0002ISource source = new LINV0002ISource();
    private LINV0002IDeal deal = new LINV0002IDeal();

    public LINV0002ISource getSource() {
        return source;
    }

    public void setSource(LINV0002ISource source) {
        this.source = source;
    }

    public LINV0002IDeal getDeal() {
        return deal;
    }

    public void setDeal(LINV0002IDeal deal) {
        this.deal = deal;
    }
}
