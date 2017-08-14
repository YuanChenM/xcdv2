package com.bms.linv.validator;

import com.bms.linv.bean.param.*;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;

/**
 * Created by zheng_xu on 2017/4/24.
 */
public class LINV0102IValidator extends DefaultCustomValidator<ArrayList<LINV0102IParam>> {

    @Override
    public void validator(ArrayList<LINV0102IParam> params) {
        if (CollectionUtils.isNotEmpty(params)) {
            for (LINV0102IParam param : params) {
                LINV0102ISourceParam source = param.getSource();
                LINV0102IDealParam deal = param.getDeal();

                this.validatorRequired("source", source);
                this.validatorLong("logicAreaId", source.getLogicAreaId(),true,null,null,4);
                this.validatorMaxLength("salePlatform", source.getSalePlatform(), true, 10);
                this.validatorMaxLength("ownerId", source.getOwnerId(), true, 64);
                this.validatorMaxLength("ownerType", source.getOwnerType(), true, 3);
                this.validatorMaxLength("masterOwnerId", source.getMasterOwnerId(), false, 64);
                this.validatorMaxLength("masterOwnerType", source.getMasterOwnerType(), false, 3);
                this.validatorLong("whId", source.getWhId(), false, null, null, 4);
                this.validatorMaxLength("skuCode", source.getSkuCode(), true, 20);
                this.validatorMaxLength("supplierId",source.getSupplierId() , false, 64);
                this.validatorMaxLength("lotNo", source.getLotNo(), true, 10);
                this.validatorMaxLength("ivType", source.getIvType(), true, 3);
                this.validatorLong("salesStatusId", source.getSalesStatusId(), false, null, null, 4);
                this.validatorMaxLength("commodityId", source.getCommodityId(), true, 20);
                this.validatorMaxLength("uom", source.getUom(), true, 8);

                this.validatorRequired("deal", param.getDeal());
                this.validatorLong("transactionId", deal.getTransactionId(), true, null, null, 4);
                this.validatorMaxLength("transactionNo", deal.getTransactionNo(), true, 64);
                this.validatorLong("transactionDetailId", deal.getTransactionDetailId(), true, null, null, 4);
                this.validatorMaxLength("transactionSource", deal.getTransactionSource(), true, 8);
                this.validatorMaxLength("targetId", deal.getTargetId(), true, 64);
                this.validatorMaxLength("targetCode", deal.getTargetCode(), true, 64);
                this.validatorMaxLength("targetType", deal.getTargetType(), true, 3);
                this.validatorDecimal("sellPrice", deal.getSellPrice(), true, 12, 4, 4);
                this.validatorDecimal("releaseQty", deal.getReleaseQty(), true, 12, 2, 4);
                this.validatorDecimal("dispatchedQty", deal.getDispatchedQty(), true, 12, 2, 5);
                this.validatorMaxLength("bizType", deal.getBizType(), true, 3);
            }
        } else {
            this.validatorRequired("202", null);
        }
    }
}
