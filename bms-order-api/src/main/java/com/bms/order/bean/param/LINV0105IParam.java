package com.bms.order.bean.param;

import java.io.Serializable;

/**
 * Created by guan_zhongheng on 2017/4/27.
 */
public class LINV0105IParam implements Serializable{

    private LINV0105IDealParam deal;

    private LINV0105ISourceParam source;

    public LINV0105IDealParam getDeal() {
        return deal;
    }

    public void setDeal(LINV0105IDealParam deal) {
        this.deal = deal;
    }

    public LINV0105ISourceParam getSource() {
        return source;
    }

    public void setSource(LINV0105ISourceParam source) {
        this.source = source;
    }
}
