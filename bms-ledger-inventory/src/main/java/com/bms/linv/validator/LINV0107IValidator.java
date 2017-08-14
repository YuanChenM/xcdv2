package com.bms.linv.validator;

import com.bms.linv.bean.param.LINV0107IAllocationParam;
import com.bms.linv.bean.param.LINV0107IParam;
import com.bms.linv.bean.param.LINV0107ISourceParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;

/**
 * Created by zheng_xu on 2017/4/24.
 */
public class LINV0107IValidator extends DefaultCustomValidator<ArrayList<LINV0107IParam>> {

    @Override
    public void validator(ArrayList<LINV0107IParam> params) {
        if (CollectionUtils.isNotEmpty(params)) {
            for (LINV0107IParam param : params) {
                LINV0107ISourceParam source = param.getSource();
                LINV0107IAllocationParam allocation = param.getAllocation();

                this.validatorRequired("source", source);
                this.validatorLong("logicAreaId", source.getLogicAreaId(),true,null,null,4);
                this.validatorMaxLength("salePlatform", source.getSalePlatform(), true, 10);
                this.validatorMaxLength("ownerId", source.getOwnerId(), true, 64);
                this.validatorMaxLength("ownerCode", source.getOwnerCode(), true, 64);
                this.validatorMaxLength("ownerdType", source.getOwnerdType(), false, 3);
                this.validatorMaxLength("ownerType", source.getOwnerType(), true, 3);
                this.validatorMaxLength("commodityId", source.getCommodityId(), true, 20);
                this.validatorMaxLength("comoIvType", source.getComoIvType(), true, 3);
                this.validatorMaxLength("ivType", source.getIvType(), true, 3);
                this.validatorMaxLength("uom", source.getUom(), true, 8);

                this.validatorRequired("allocation", param.getAllocation());
                this.validatorMaxLength("refNo", allocation.getTransactionNo(), false, 64);
                this.validatorLong("transactionId", allocation.getTransactionId(), true, null, null, 4);
                this.validatorMaxLength("transactionNo", allocation.getTransactionNo(), true, 64);
                this.validatorLong("transactionDetailId", allocation.getTransactionDetailId(), true, null, null, 4);
                this.validatorMaxLength("transactionSource", allocation.getTransactionSource(), true, 8);
                this.validatorMaxLength("targetId", allocation.getTargetId(), true, 64);
                this.validatorMaxLength("targetCode", allocation.getTargetCode(), true, 64);
                this.validatorMaxLength("targetType", allocation.getTargetType(), true, 3);
                this.validatorDecimal("alocQty", allocation.getAlocQty(), true, 12, 2, 4);
                this.validatorMaxLength("bizType", allocation.getBizType(), true, 3);
            }
        } else {
            this.validatorRequired("202", null);
        }
    }
}
