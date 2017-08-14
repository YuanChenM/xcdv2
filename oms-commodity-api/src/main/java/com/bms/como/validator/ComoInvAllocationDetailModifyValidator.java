package com.bms.como.validator;

import com.bms.como.bean.entity.ComoInvAllocationDetail;
import com.framework.validator.DefaultCustomValidator;

public class ComoInvAllocationDetailModifyValidator extends DefaultCustomValidator<ComoInvAllocationDetail> {
    @Override
    public void validator(ComoInvAllocationDetail comoInvAllocationDetail) {
        if (comoInvAllocationDetail != null) {
            this.validatorRequired("allocationId",comoInvAllocationDetail.getAllocationId());
        } else {
            this.validatorRequired("COMO.L01005", null);
        }
    }
}
