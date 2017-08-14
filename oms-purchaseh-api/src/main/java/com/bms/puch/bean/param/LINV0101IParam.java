package com.bms.puch.bean.param;

import java.io.Serializable;

/**
 * Created by guan_zhongheng on 2017/4/21.
 */
public class LINV0101IParam implements Serializable{

    private LINV0101ISourceParam source;

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
