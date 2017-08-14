package com.bms.bymt.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by guan_zhongheng on 2016/12/16.
 */
@ApiModel(value = "MarketPictureRsParam", description = "证件信息类")
public class MarketPictureRsParam extends BaseRestPaginationParam {

    @ApiModelProperty(value = "证件主键")
    private Long picId;
    @ApiModelProperty(value = "市场ID(包含批发市场、菜场UUID)")
    private String marketId;
    @ApiModelProperty(value = "证件图片信息")
    private String cardAddress;
    @ApiModelProperty(value = "证件图片类型(01:营业执照 02:组织机构代码 03:税务机构代码证 04:银行开户许可证 05平面图 06:门头照及周边图)")
    private String cardType;

    @ApiModelProperty(value = "删除标识")
    private boolean delFlg;

    public Long getPicId() {
        return picId;
    }

    public void setPicId(Long picId) {
        this.picId = picId;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    public String getCardAddress() {
        return cardAddress;
    }

    public void setCardAddress(String cardAddress) {
        this.cardAddress = cardAddress;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
        this.delFlg = delFlg;
    }
}
