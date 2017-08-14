package com.bms.prce.bean.param;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sun_jiaju on 2017/01/17.
 */
public class PRCE0210IDealParam implements Serializable {
    private Long[] marketingWayConfigIds;

    private String updId;

    private Date updTime;

    private String updTimeStr;

    private Integer searchFlg;

    private String goodId;

    public Long[] getMarketingWayConfigIds() {
        return marketingWayConfigIds;
    }

    public void setMarketingWayConfigIds(Long[] marketingWayConfigIds) {
        this.marketingWayConfigIds = marketingWayConfigIds;
    }

    public String getUpdId() {
        return updId;
    }

    public void setUpdId(String updId) {
        this.updId = updId;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public String getUpdTimeStr() {
        return updTimeStr;
    }

    public void setUpdTimeStr(String updTimeStr) {
        this.updTimeStr = updTimeStr;
    }

    public Integer getSearchFlg() {
        return searchFlg;
    }

    public void setSearchFlg(Integer searchFlg) {
        this.searchFlg = searchFlg;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }
}
