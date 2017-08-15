package com.bms.slim.bean.entity.target;

import com.bms.slim.bean.BaseTarget;

/**
 * <p>SLIM0230I批量修改生产商工厂指定更新的字段，true：更新，false：不更新。</p>
 */
public class SlimProducerFactoryTarget extends BaseTarget {

    /** 卖家角色ID */
    private boolean sellerRoleIdFlg;
    /** 总资产 */
    private boolean totalAssetFlg;
    /** 注册资本 */
    private boolean registeredCapitalFlg;
    /** 占地面积 */
    private boolean coveredAreaFlg;
    /** 厂房面积 */
    private boolean workshopAreaFlg;
    /** 主要设备 */
    private boolean majorEquipmentFlg;
    /** 设计产能 */
    private boolean designCapacityFlg;
    /** 外贸销售占比 */
    private boolean exportSalePercentFlg;
    /** 自销占比 */
    private boolean selfSalePercentFlg;
    /** 代理销售占比 */
    private boolean agentSalePercentFlg;
    /** 厂区照(远景)URL */
    private boolean factoryPicUrlFlg;

    public boolean isSellerRoleIdFlg() {
        return sellerRoleIdFlg;
    }

    public void setSellerRoleIdFlg(boolean sellerRoleIdFlg) {
        this.sellerRoleIdFlg = sellerRoleIdFlg;
    }

    public boolean isTotalAssetFlg() {
        return totalAssetFlg;
    }

    public void setTotalAssetFlg(boolean totalAssetFlg) {
        this.totalAssetFlg = totalAssetFlg;
    }

    public boolean isRegisteredCapitalFlg() {
        return registeredCapitalFlg;
    }

    public void setRegisteredCapitalFlg(boolean registeredCapitalFlg) {
        this.registeredCapitalFlg = registeredCapitalFlg;
    }

    public boolean isCoveredAreaFlg() {
        return coveredAreaFlg;
    }

    public void setCoveredAreaFlg(boolean coveredAreaFlg) {
        this.coveredAreaFlg = coveredAreaFlg;
    }

    public boolean isWorkshopAreaFlg() {
        return workshopAreaFlg;
    }

    public void setWorkshopAreaFlg(boolean workshopAreaFlg) {
        this.workshopAreaFlg = workshopAreaFlg;
    }

    public boolean isMajorEquipmentFlg() {
        return majorEquipmentFlg;
    }

    public void setMajorEquipmentFlg(boolean majorEquipmentFlg) {
        this.majorEquipmentFlg = majorEquipmentFlg;
    }

    public boolean isDesignCapacityFlg() {
        return designCapacityFlg;
    }

    public void setDesignCapacityFlg(boolean designCapacityFlg) {
        this.designCapacityFlg = designCapacityFlg;
    }

    public boolean isExportSalePercentFlg() {
        return exportSalePercentFlg;
    }

    public void setExportSalePercentFlg(boolean exportSalePercentFlg) {
        this.exportSalePercentFlg = exportSalePercentFlg;
    }

    public boolean isSelfSalePercentFlg() {
        return selfSalePercentFlg;
    }

    public void setSelfSalePercentFlg(boolean selfSalePercentFlg) {
        this.selfSalePercentFlg = selfSalePercentFlg;
    }

    public boolean isAgentSalePercentFlg() {
        return agentSalePercentFlg;
    }

    public void setAgentSalePercentFlg(boolean agentSalePercentFlg) {
        this.agentSalePercentFlg = agentSalePercentFlg;
    }

    public boolean isFactoryPicUrlFlg() {
        return factoryPicUrlFlg;
    }

    public void setFactoryPicUrlFlg(boolean factoryPicUrlFlg) {
        this.factoryPicUrlFlg = factoryPicUrlFlg;
    }
}
