package com.bms.linv.validator;

import com.bms.linv.bean.param.LINV0104IParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;

/**
 * Created by guan_zhongheng on 2017/4/20.
 */
public class LINV0104IValidator extends DefaultCustomValidator<ArrayList<LINV0104IParam>> {

    @Override
    public void validator(ArrayList<LINV0104IParam> params) {

        if (CollectionUtils.isNotEmpty(params)) {
            for (LINV0104IParam param : params) {
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
