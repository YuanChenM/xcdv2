/*
 * 2016/12/14 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.bymt.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表BYMT_MARKET_PICTURE对应的实体BymtMarketPicture</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class BymtMarketPicture extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 证件主键 */
    private Long picId;
    /** 市场ID(包含批发市场、菜场UUID) */
    private String marketId;
    /** 营业执照 */
    private String cardAddress;
    /** 证件图片类型(01:营业执照 02:组织机构代码 03:税务机构代码证 04:银行开户许可证 05平面图 06:门头照及周边图) */
    private String cardType;

    /**
     * <p>默认构造函数</p>
     */
    public BymtMarketPicture() {
    }

    /**
     * <p>证件主键</p>
     *
     * @return 证件主键
     */
    public Long getPicId() {
        return picId;
    }

    /**
     * <p>证件主键</p>
     *
     * @param picId 证件主键
     */
    public void setPicId(Long picId) {
        this.picId = picId;
    }
    /**
     * <p>市场ID(包含批发市场、菜场UUID)</p>
     *
     * @return 市场ID(包含批发市场、菜场UUID)
     */
    public String getMarketId() {
        return marketId;
    }

    /**
     * <p>市场ID(包含批发市场、菜场UUID)</p>
     *
     * @param marketId 市场ID(包含批发市场、菜场UUID)
     */
    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }
    /**
     * <p>营业执照</p>
     *
     * @return 营业执照
     */
    public String getCardAddress() {
        return cardAddress;
    }

    /**
     * <p>营业执照</p>
     *
     * @param cardAddress 营业执照
     */
    public void setCardAddress(String cardAddress) {
        this.cardAddress = cardAddress;
    }
    /**
     * <p>证件图片类型(01:营业执照 02:组织机构代码 03:税务机构代码证 04:银行开户许可证 05平面图 06:门头照及周边图)</p>
     *
     * @return 证件图片类型(01:营业执照 02:组织机构代码 03:税务机构代码证 04:银行开户许可证 05平面图 06:门头照及周边图)
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * <p>证件图片类型(01:营业执照 02:组织机构代码 03:税务机构代码证 04:银行开户许可证 05平面图 06:门头照及周边图)</p>
     *
     * @param cardType 证件图片类型(01:营业执照 02:组织机构代码 03:税务机构代码证 04:银行开户许可证 05平面图 06:门头照及周边图)
     */
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

}
