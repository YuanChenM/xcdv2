package com.bms.slim.bean.entity.target;

import com.bms.slim.bean.BaseTarget;

/**
 * <p>SLIM0230I批量修改生产商车间指定更新的字段，true：更新，false：不更新。</p>
 */
public class SlimProducerWorkshopTarget extends BaseTarget {

    /** 卖家角色ID */
    private boolean sellerRoleIdFlg;
    /** 车间名 */
    private boolean workshopNameFlg;
    /** 生产产品 */
    private boolean productionProductFlg;
    /** 工艺流程特点 */
    private boolean proccessFlowCharacterFlg;
    /** 车间照 */
    private boolean workshopPicUrlFlg;

    public boolean isSellerRoleIdFlg() {
        return sellerRoleIdFlg;
    }

    public void setSellerRoleIdFlg(boolean sellerRoleIdFlg) {
        this.sellerRoleIdFlg = sellerRoleIdFlg;
    }

    public boolean isWorkshopNameFlg() {
        return workshopNameFlg;
    }

    public void setWorkshopNameFlg(boolean workshopNameFlg) {
        this.workshopNameFlg = workshopNameFlg;
    }

    public boolean isProductionProductFlg() {
        return productionProductFlg;
    }

    public void setProductionProductFlg(boolean productionProductFlg) {
        this.productionProductFlg = productionProductFlg;
    }

    public boolean isProccessFlowCharacterFlg() {
        return proccessFlowCharacterFlg;
    }

    public void setProccessFlowCharacterFlg(boolean proccessFlowCharacterFlg) {
        this.proccessFlowCharacterFlg = proccessFlowCharacterFlg;
    }

    public boolean isWorkshopPicUrlFlg() {
        return workshopPicUrlFlg;
    }

    public void setWorkshopPicUrlFlg(boolean workshopPicUrlFlg) {
        this.workshopPicUrlFlg = workshopPicUrlFlg;
    }
}
