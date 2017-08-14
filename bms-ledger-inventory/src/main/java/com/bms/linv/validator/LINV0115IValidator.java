package com.bms.linv.validator;

import com.bms.linv.bean.param.*;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by zhang_jian4 on 2017/4/21.
 */
public class LINV0115IValidator extends DefaultCustomValidator<ArrayList<LINV0115IParam>> {


    @Override
    public void validator(ArrayList<LINV0115IParam> param) {
        if (param == null || CollectionUtils.isEmpty(param)) {
            return;
        }

        for (LINV0115IParam linv0115IParam : param) {
            LINV0115ISourceParam source = linv0115IParam.getSource();
            LINV0115IDealParam deal = linv0115IParam.getDeal();

            this.validatorLong("logicAreaId", source.getLogicAreaId(),true,null,null,4);
            this.validatorRequired("salePlatform", source.getSalePlatform());
            this.validatorRequired("ownerId", source.getOwnerId());
            this.validatorRequired("ownerCode", source.getOwnerCode());
            this.validatorRequired("ownerType", source.getOwnerType());
            this.validatorRequired("oldCommodityId", source.getOldCommodityId());
            this.validatorRequired("skuCode", source.getSkuCode());
            this.validatorRequired("ivType", source.getIvType());
            this.validatorRequired("uom", source.getUom());
            this.validatorRequired("transactionId", deal.getTransactionId());
            this.validatorRequired("transactionNo", deal.getTransactionNo());
            this.validatorRequired("transactionSource", deal.getTransactionSource());
            this.validatorRequired("transactionDetailId", deal.getTransactionDetailId());
            this.validatorRequired("transactionSequence", deal.getTransactionSequence());
            this.validatorRequired("newCommodityId", deal.getNewCommodityId());
            this.validatorRequired("transferQty", deal.getTransferQty());
            this.validatorRequired("bizType", deal.getBizType());

            this.validatorMaxLength("salePlatform", source.getSalePlatform(), true, 10);
            this.validatorMaxLength("ownerId", source.getOwnerId(), true, 36);
            this.validatorMaxLength("ownerCode", source.getOwnerCode(), true, 20);
            this.validatorMaxLength("ownerType", source.getOwnerType(), true, 3);
            this.validatorMaxLength("ownerdType", source.getOwnerdType(), true, 3);
            this.validatorMaxLength("ivType", source.getIvType(), true, 3);
            this.validatorMaxLength("refNo", deal.getRefNo(), true, 64);
            this.validatorMaxLength("transactionNo", deal.getTransactionNo(), true, 40);

            //大于等于0
//            this.validatorDecimal("transferQty", deal.getTransferQty(), true, 12, 2, 8);
        }
    }
}
