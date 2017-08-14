package com.bms.linv.validator;

import com.bms.linv.bean.param.LINV0106IDealParam;
import com.bms.linv.bean.param.LINV0106IParam;
import com.bms.linv.bean.param.LINV0106ISourceParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wang_haichun on 2017/4/18.
 */
public class LINV0106IValidator extends DefaultCustomValidator<ArrayList<LINV0106IParam>> {

    @Override
    public void validator(ArrayList<LINV0106IParam> param) {
        if (CollectionUtils.isNotEmpty(param)) {
            for (LINV0106IParam linvParam : param) {
                LINV0106ISourceParam source = linvParam.getSource();
                LINV0106IDealParam deal = linvParam.getDeal();

                this.validatorLong("logicAreaId", source.getLogicAreaId(),true,null,null,4);
                this.validatorMaxLength("salePlatform", source.getSalePlatform(), true, 10);
                this.validatorMaxLength("ownerId", source.getOwnerId(), true, 36);
                this.validatorMaxLength("ownerCode", source.getOwnerCode(), true, 36);
                this.validatorMaxLength("ownerType", source.getOwnerType(), true, 3);
                this.validatorRequired("commodityId", source.getCommodityId());
                this.validatorRequired("ivType", source.getIvType());
                this.validatorMaxLength("comoIvType", source.getComoIvType(), true, 3);
                this.validatorRequired("uom", source.getUom());

                this.validatorRequired("addTargetInv", deal.getAddTargetInv());
                this.validatorRequired("deductSrcInv", deal.getDeductSrcInv());
                this.validatorMaxLength("refNo", deal.getRefNo(), false, 64);
                this.validatorRequired("transactionId", deal.getTransactionId());
                this.validatorMaxLength("transactionNo", deal.getTransactionNo(), true, 64);
                this.validatorRequired("transactionSource", deal.getTransactionSource());
                this.validatorRequired("transactionDetailId", deal.getTransactionDetailId());
                this.validatorRequired("transactionSequence", deal.getTransactionSequence());
                this.validatorMaxLength("targetId", deal.getTargetId(), true, 36);
                this.validatorMaxLength("targetId", deal.getTargetCode(), true, 20);
                this.validatorMaxLength("targetType", deal.getTargetType(), true, 3);
                // 大于等于0
                this.validatorDecimal("releaseQty", deal.getReleaseQty(), true, 12, 2, 5);
                // 大于0
                this.validatorDecimal("returnPrice", deal.getReturnPrice(), false, 12, 4, 4);
                // 大于0
                this.validatorDecimal("returnQty", deal.getReturnQty(), true, 12, 2, 4);
                this.validatorRequired("bizType", deal.getBizType());
            }
        }else {
            this.validatorRequired("202", null);
        }
    }
}
