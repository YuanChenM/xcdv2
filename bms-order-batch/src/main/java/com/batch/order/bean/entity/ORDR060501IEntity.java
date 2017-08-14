package com.batch.order.bean.entity;

import java.util.List;

/**
 * Created by wu_honglei on 2016/12/29.
 * 买手订单明细
 */
public class ORDR060501IEntity extends BsOrderDetailEntity {
    //买手囤货分拆单明细
    private List<BsStockpileSplitDetailEntity> stockSplitList;


    public List<BsStockpileSplitDetailEntity> getStockSplitList() {
        return stockSplitList;
    }

    public void setStockSplitList(List<BsStockpileSplitDetailEntity> stockSplitList) {
        this.stockSplitList = stockSplitList;
    }
}
