package com.bms.linv.business;

import com.bms.linv.bean.entity.*;

/**
 * 共通方法
 * Created by zheng_xu on 2017/4/18.
 */
public interface LinvPublicMethodService {

    void addProductInv(InvmLoad invmLoad, InvmLoadDealDetail loadDealDetail);

    void reduceProductInv(InvmLoad invmLoad, InvmLoadDealDetail loadDealDetail);

    void alocProduct(InvmLoadAlocInventory loadAlocInv, InvmLoadAlocDealDetail loadAlocDetail);

    void cancelProcductAloc(InvmLoadAlocInventory loadAlocInv, InvmLoadAlocDealDetail loadAlocDetail);

    void addComoInv(InvmComoInventory comoInv, InvmComoDealDetail comoDealDetail, InvmComoBalanceInventory comoBalanceInv);

    void reduceComoInv(InvmComoInventory comoInv, InvmComoDealDetail comoDealDetail);

    void alocOwComm(InvmComoAlocInventory comoAlocInv, InvmComoAlocDealDetail comoAlocDetail);

    void cancelOwComAloc(InvmComoAlocInventory comoAlocInv, InvmComoAlocDealDetail comoAlocDetail);
}
