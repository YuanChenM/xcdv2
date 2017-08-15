package com.bms.slpd.bean.entity.target;

import com.bms.slpd.bean.BaseTarget;

public class SlpdSellerCommodityTarget extends BaseTarget {
    /** 卖家ID */
    private boolean sellerIdFlg;
    /** 单品品牌(规格)生产商ID */
    private boolean producerProductIdFlg;
    /** 货号 */
    private boolean articleNoFlg;
    /** 商品ID */
    private boolean commodityIdFlg;
    /** 商品标题 */
    private boolean salesTitleFlg;
    /** 审核状态 */
    private boolean auditStuFlg;
    /** 审核备注 */
    private boolean auditRemarkFlg;

    public boolean isCommodityIdFlg() {
        return commodityIdFlg;
    }

    public void setCommodityIdFlg(boolean commodityIdFlg) {
        this.commodityIdFlg = commodityIdFlg;
    }

    public boolean isSellerIdFlg() {
        return sellerIdFlg;
    }

    public void setSellerIdFlg(boolean sellerIdFlg) {
        this.sellerIdFlg = sellerIdFlg;
    }

    public boolean isProducerProductIdFlg() {
        return producerProductIdFlg;
    }

    public void setProducerProductIdFlg(boolean producerProductIdFlg) {
        this.producerProductIdFlg = producerProductIdFlg;
    }

    public boolean isArticleNoFlg() {
        return articleNoFlg;
    }

    public void setArticleNoFlg(boolean articleNoFlg) {
        this.articleNoFlg = articleNoFlg;
    }

    public boolean isSalesTitleFlg() {
        return salesTitleFlg;
    }

    public void setSalesTitleFlg(boolean salesTitleFlg) {
        this.salesTitleFlg = salesTitleFlg;
    }

    public boolean isAuditStuFlg() {
        return auditStuFlg;
    }

    public void setAuditStuFlg(boolean auditStuFlg) {
        this.auditStuFlg = auditStuFlg;
    }

    public boolean isAuditRemarkFlg() {
        return auditRemarkFlg;
    }

    public void setAuditRemarkFlg(boolean auditRemarkFlg) {
        this.auditRemarkFlg = auditRemarkFlg;
    }
}
