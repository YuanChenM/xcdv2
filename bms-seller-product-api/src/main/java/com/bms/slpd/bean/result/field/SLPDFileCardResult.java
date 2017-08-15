package com.bms.slpd.bean.result.field;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>标准档案卡和档案差异卡对象的父类。</p>
 */
public class SLPDFileCardResult implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 品种ID */
    private Long breedId;
    /** 单品ID */
    private Long ItemId;
    /** 产品ID */
    private String productId;
    /** 删除标识 */
    private boolean delFlg;
    /** 创建者ID */
    private String crtId;
    /** 创建时间 */
    private Date crtTime;
    /** 更新者ID */
    private String updId;
    /** 更新时间 */
    private Date updTime;
    /** 版本 */
    private Integer version;

    public Long getBreedId() {
        return breedId;
    }

    public void setBreedId(Long breedId) {
        this.breedId = breedId;
    }

    public Long getItemId() {
        return ItemId;
    }

    public void setItemId(Long itemId) {
        ItemId = itemId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
        this.delFlg = delFlg;
    }

    public String getCrtId() {
        return crtId;
    }

    public void setCrtId(String crtId) {
        this.crtId = crtId;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}
