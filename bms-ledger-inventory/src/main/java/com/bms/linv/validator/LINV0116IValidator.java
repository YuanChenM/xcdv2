package com.bms.linv.validator;

import com.bms.linv.bean.param.*;
import com.bms.linv.bean.result.LINV0116IResult;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;

/**
 * Created by zheng_xu on 2017/4/24.
 */
public class LINV0116IValidator extends DefaultCustomValidator<ArrayList<LINV0116IParam>> {

    @Override
    public void validator(ArrayList<LINV0116IParam> params) {
        if (CollectionUtils.isNotEmpty(params)) {
            for (LINV0116IParam param : params) {
                this.validatorRequired("transactionId", param.getTransactionId());
                this.validatorRequired("transactionNo", param.getTransactionNo());
                this.validatorRequired("transactionDetailId", param.getTransactionDetailId());
                this.validatorRequired("bizType",param.getBizType());
            }
        }else{
            this.validatorRequired("params", null);
        }
    }
}
