package com.bms.order.external.bean.param;

import java.io.Serializable;

/**
 * Created by ni_shaotang on 2017/3/15.
 */
public class LINV0010IRestParam implements Serializable {
    private static final long serialVersionUID = 1L;
    private LINV0010ISource source = new LINV0010ISource();
    private LINV0010IDeal deal = new LINV0010IDeal();

    public LINV0010ISource getSource() {
        return source;
    }

    public void setSource(LINV0010ISource source) {
        this.source = source;
    }

    public LINV0010IDeal getDeal() {
        return deal;
    }

    public void setDeal(LINV0010IDeal deal) {
        this.deal = deal;
    }
}
