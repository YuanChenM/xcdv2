package com.bms.agif.bean.param;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by tao_zhifa on 2017/3/15.
 */
public class BuyerBasicBuyerIdsRsParam extends  BuyerAllRsParam {
    @ApiModelProperty(value = "买家ID数组")
    private String [] buyerIds;
    @ApiModelProperty(value = "买家帐号")
    private String buyerAccount;
    @ApiModelProperty(value = "买家注册手机号")
    private String buyerTelNo;
    @ApiModelProperty(value = "买家店铺号")
    private String buyerStoreNo;
    @ApiModelProperty(value = "买家老板名称")
    private String buyerBossName;
    @ApiModelProperty(value = "批发市场/菜场的Id")
    private String buyerMarketId;
    @ApiModelProperty(value = "批发市场/菜场的名称")
    private String buyerMarketName;


    public String getBuyerAccount() {
        return buyerAccount;
    }

    public void setBuyerAccount(String buyerAccount) {
        this.buyerAccount = buyerAccount;
    }

    public String getBuyerTelNo() {
        return buyerTelNo;
    }

    public void setBuyerTelNo(String buyerTelNo) {
        this.buyerTelNo = buyerTelNo;
    }

    public String getBuyerStoreNo() {
        return buyerStoreNo;
    }

    public void setBuyerStoreNo(String buyerStoreNo) {
        this.buyerStoreNo = buyerStoreNo;
    }

    public String getBuyerBossName() {
        return buyerBossName;
    }

    public void setBuyerBossName(String buyerBossName) {
        this.buyerBossName = buyerBossName;
    }

    public String getBuyerMarketId() {
        return buyerMarketId;
    }

    public void setBuyerMarketId(String buyerMarketId) {
        this.buyerMarketId = buyerMarketId;
    }

    public String getBuyerMarketName() {
        return buyerMarketName;
    }

    public void setBuyerMarketName(String buyerMarketName) {
        this.buyerMarketName = buyerMarketName;
    }

    public String[] getBuyerIds() {
        return buyerIds;
    }

    public void setBuyerIds(String[] buyerIds) {
        this.buyerIds = buyerIds;
    }
}
