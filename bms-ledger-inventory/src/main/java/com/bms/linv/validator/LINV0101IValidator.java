package com.bms.linv.validator;

import com.bms.linv.bean.param.LINV0101IDealParam;
import com.bms.linv.bean.param.LINV0101IParam;
import com.bms.linv.bean.param.LINV0101ISourceParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;

/**
 * Created by zheng_xu on 2017/4/24.
 */
public class LINV0101IValidator extends DefaultCustomValidator<ArrayList<LINV0101IParam>> {

    @Override
    public void validator(ArrayList<LINV0101IParam> params) {
        if (CollectionUtils.isNotEmpty(params)) {
            for (LINV0101IParam param : params) {
                LINV0101ISourceParam source = param.getSource();
                LINV0101IDealParam deal = param.getDeal();

                this.validatorRequired("source", source);
                this.validatorLong("logicAreaId", source.getLogicAreaId(),true,null,null,4);
                this.validatorMaxLength("logicAreaCode", source.getLogicAreaCode(), true, 20);
                this.validatorMaxLength("logicAreaName", source.getLogicAreaName(), true, 30);
                this.validatorMaxLength("salePlatform", source.getSalePlatform(), true, 10);
                this.validatorMaxLength("ownerId", source.getOwnerId(), true, 64);
                this.validatorMaxLength("ownerCode", source.getOwnerCode(), true, 64);
                this.validatorMaxLength("ownerType", source.getOwnerType(), true, 3);
                this.validatorMaxLength("ownerdType", source.getOwnerdType(), false, 3);
                this.validatorMaxLength("masterOwnerId", source.getMasterOwnerId(), false, 64);
                this.validatorMaxLength("masterOwnerCode", source.getMasterOwnerCode(), false, 64);
                this.validatorMaxLength("masterOwnerType", source.getMasterOwnerType(), false, 3);
                this.validatorMaxLength("masterOwnerName", source.getMasterOwnerName(), false, 32);
                this.validatorMaxLength("ownerName", source.getOwnerName(), true, 32);
                this.validatorLong("whId", source.getWhId(), false, null, null, 4);
                this.validatorMaxLength("whCode", source.getWhCode(), false, 16);
                this.validatorMaxLength("whName", source.getWhName(), false, 32);
                this.validatorMaxLength("skuCode", source.getSkuCode(), true, 20);
                this.validatorMaxLength("uom", source.getUom(), true, 8);

                this.validatorRequired("deal", param.getDeal());
                this.validatorMaxLength("refNo", deal.getTransactionNo(), false, 64);
                this.validatorLong("transactionId", deal.getTransactionId(), true, null, null, 4);
                this.validatorMaxLength("transactionNo", deal.getTransactionNo(), true, 64);
                this.validatorLong("transactionDetailId", deal.getTransactionDetailId(), true, null, null, 4);
                this.validatorMaxLength("transactionSource", deal.getTransactionSource(), true, 8);
                this.validatorMaxLength("supplierId", deal.getSupplierId(), true, 64);
                this.validatorMaxLength("supplierCode", deal.getSupplierCode(), true, 64);
                this.validatorMaxLength("supplierName", deal.getSupplierName(), true, 32);
                this.validatorMaxLength("lotNo", deal.getLotNo(), true, 10);
                this.validatorDecimal("buyPrice", deal.getBuyPrice(), true, 12, 4, 4);
                this.validatorDecimal("recvQty", deal.getRecvQty(), true, 12, 2, 5);
                this.validatorMaxLength("ivType", deal.getIvType(), true, 3);
                this.validatorLong("salesStatusId", deal.getSalesStatusId(), false, null, null, 4);
                this.validatorMaxLength("salesStatusCode", deal.getSalesStatusCode(), false, 32);
                this.validatorMaxLength("bizType", deal.getBizType(), true, 3);
            }
        } else {
            this.validatorRequired("202", null);
        }
    }
}
