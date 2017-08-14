package com.bms.como.validator;

import com.bms.como.bean.entity.ComoInvAllocation;
import com.framework.validator.DefaultCustomValidator;

public class ComoInvAllocationModifyValidator extends DefaultCustomValidator<ComoInvAllocation> {
    @Override
    public void validator(ComoInvAllocation comoInvAllocation) {
        if (comoInvAllocation != null) {
            this.validatorRequired("allocationId",comoInvAllocation.getAllocationId());
            this.validatorRequired("allocationStu",comoInvAllocation.getAllocationStu());
            this.validatorRequired("allocationResult",comoInvAllocation.getAllocationResult());
            /*this.validatorRequired("completedTime",comoInvAllocation.getCompletedTime());
            this.validatorRequired("completedMan",comoInvAllocation.getCompletedMan());*/
        } else {
            this.validatorRequired("COMO.L01005", null);
        }
    }
}
