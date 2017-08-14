package com.bms.bypo.bean.result;

import com.bms.bypo.bean.param.BuyerPoolRsParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhou_yajun
 * @version 1.0
 */
@ApiModel(value = "BuyerPoolRsResult", description = "物流区分类买家池返回JavaBean")
public class BuyerPoolRsResult implements Serializable {
    @ApiModelProperty(value = "影响条数")
    private int count;
    @ApiModelProperty(value = "插入数据列表")
    private List<BuyerPoolRsParam> buyerPoolList;
    @ApiModelProperty(value = "更新数据主键")
    private Long[] buyerPoolId;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<BuyerPoolRsParam> getBuyerPoolList() {
        return buyerPoolList;
    }

    public void setBuyerPoolList(List<BuyerPoolRsParam> buyerPoolList) {
        this.buyerPoolList = buyerPoolList;
    }

    public Long[] getBuyerPoolId() {
        return buyerPoolId;
    }

    public void setBuyerPoolId(Long[] buyerPoolId) {
        this.buyerPoolId = buyerPoolId;
    }
}
