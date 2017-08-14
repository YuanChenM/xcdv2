package com.bms.linv.validator;

import com.bms.linv.bean.param.*;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;

/**
 * Created by zheng_xu on 2017/4/24.
 */
public class LINV0105IValidator extends DefaultCustomValidator<ArrayList<LINV0105IParam>> {

    @Override
    public void validator(ArrayList<LINV0105IParam> params) {
        if (CollectionUtils.isNotEmpty(params)) {
            for (LINV0105IParam param : params) {
                LINV0105ISourceParam source = param.getSource();
                LINV0105IDealParam deal = param.getDeal();

                this.validatorRequired("source", source);
                this.validatorLong("logicAreaId", source.getLogicAreaId(),true,null,null,4);
                this.validatorMaxLength("salePlatform", source.getSalePlatform(), true, 10);
                this.validatorMaxLength("ownerId", source.getOwnerId(), true, 64);
                this.validatorMaxLength("ownerCode", source.getOwnerCode(), true, 64);
                this.validatorMaxLength("ownerType", source.getOwnerType(), true, 3);
                this.validatorMaxLength("ownerdType", source.getOwnerdType(), false, 3);
                this.validatorMaxLength("ivType", source.getIvType(), true, 3);
                this.validatorMaxLength("comoIvType", source.getComoIvType(), true, 3);
                this.validatorMaxLength("uom", source.getUom(), true, 8);

                this.validatorRequired("deal", param.getDeal());
                this.validatorRequired("deductSrcInv", deal.isDeductSrcInv());
                this.validatorRequired("addTargetInv", deal.isAddTargetInv());
                this.validatorMaxLength("refNo", deal.getTransactionNo(), false, 64);
                this.validatorLong("transactionId", deal.getTransactionId(), true, null, null, 4);
                this.validatorMaxLength("transactionNo", deal.getTransactionNo(), true, 64);
                this.validatorLong("transactionDetailId", deal.getTransactionDetailId(), true, null, null, 4);
                this.validatorMaxLength("transactionSource", deal.getTransactionSource(), true, 8);
                this.validatorMaxLength("targetId", deal.getTargetId(), true, 64);
                this.validatorMaxLength("targetCode", deal.getTargetCode(), true, 64);
                this.validatorMaxLength("targetType", deal.getTargetType(), true, 3);
                this.validatorMaxLength("targetName", deal.getTargetName(), true, 20);
                this.validatorDecimal("dealPrice", deal.getDealPrice(), false, 12, 4, 4);
                this.validatorDecimal("releaseQty", deal.getReleaseQty(), true, 12, 2, 5);
                this.validatorDecimal("dealQty", deal.getDealQty(), true, 12, 2, 5);
                this.validatorMaxLength("bizType", deal.getBizType(), true, 3);
            }
        } else {
            this.validatorRequired("202", null);
        }
    }
}
