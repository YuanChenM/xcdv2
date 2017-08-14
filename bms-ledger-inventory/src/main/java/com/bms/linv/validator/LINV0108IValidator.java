package com.bms.linv.validator;

import com.bms.linv.bean.param.LINV0108IParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;

/**
 * Created by zheng_xu on 2017/4/24.
 */
public class LINV0108IValidator extends DefaultCustomValidator<ArrayList<LINV0108IParam>> {

    @Override
    public void validator(ArrayList<LINV0108IParam> params) {

        if (CollectionUtils.isNotEmpty(params)) {
            for (LINV0108IParam param : params) {
                this.validatorLong("transactionId", param.getTransactionId(), true, null, null, 4);
                this.validatorMaxLength("transactionNo", param.getTransactionNo(), true, 64);
                this.validatorLong("transactionDetailId", param.getTransactionDetailId(), true, null, null, 4);
                this.validatorMaxLength("transactionSource", param.getTransactionSource(), true, 8);
                this.validatorDecimal("alocQty", param.getCancelQty(), true, 12, 2, 4);
                this.validatorMaxLength("bizType", param.getBizType(), true, 3);
            }
        } else {
            this.validatorRequired("202", null);
        }
    }
}
