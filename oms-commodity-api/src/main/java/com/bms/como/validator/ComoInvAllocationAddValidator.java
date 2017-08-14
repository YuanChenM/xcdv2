package com.bms.como.validator;

import com.bms.como.bean.param.ComoInvAllocationDetailRsParam;
import com.bms.como.bean.param.ComoInvAllocationRsParam;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by yuan_zhifei on 2017/4/1.
 */
public class ComoInvAllocationAddValidator extends DefaultCustomValidator<ComoInvAllocationRsParam> {
    @Override
    public void validator(ComoInvAllocationRsParam comoInvAllocationRsParam) {
        if (comoInvAllocationRsParam != null) {
            //this.validatorMaxLength("COMO.L01026", comoInvAllocationRsParam.getAllocationCode(), true, 64);
            this.validatorLong("COMO.L01007", comoInvAllocationRsParam.getLgcsAreaId(), true, Long.MAX_VALUE, 0L, 4);
            this.validatorMaxLength("COMO.L01008", comoInvAllocationRsParam.getLgcsAreaCode(), true, 8);
            this.validatorMaxLength("COMO.L01009", comoInvAllocationRsParam.getLgcsAreaName(), true, 32);
            /*if (StringUtils.isNotEmpty(comoInvAllocationRsParam.getLgcsAreaName())) {
                this.validatorMaxLength("COMO.L01011", comoInvAllocationRsParam.getAllocationRemark(), true, 256);
            }
            this.validatorMaxLength("COMO.L01012", comoInvAllocationRsParam.getApplyMan(), true, 32);*/
            if (CollectionUtils.isNotEmpty(comoInvAllocationRsParam.getDetailRsParams())) {
                ComoInvAllocationDetailRsParam detailRsParam = null;
                for (int i = NumberConst.IntDef.INT_ZERO; i < comoInvAllocationRsParam.getDetailRsParams().size(); i++) {
                    detailRsParam = comoInvAllocationRsParam.getDetailRsParams().get(i);
                    this.validatorLong("COMO.L01013", detailRsParam.getTargetCommodityId(), true, Long.MAX_VALUE, 0L, 4);
                    this.validatorLong("COMO.L01014", detailRsParam.getOriginalCommodityId(), true, Long.MAX_VALUE, 0L, 4);
                    this.validatorMaxLength("COMO.L01015", detailRsParam.getOwnerId(), true, 36);
                    this.validatorMaxLength("COMO.L01016", detailRsParam.getOwnerType(), true, 16);
                    this.validatorMaxLength("COMO.L01017", detailRsParam.getOwnerCode(), true, 16);
                    this.validatorMaxLength("COMO.L01018", detailRsParam.getOwnerName(), true, 64);
                    this.validatorMaxLength("COMO.L01019", detailRsParam.getSkuCode(), true, 32);
                    this.validatorMaxLength("COMO.L01020", detailRsParam.getLotNo(), true, 10);
                    this.validatorMaxLength("COMO.L01021", detailRsParam.getUom(), true, 8);
                    this.validatorMaxLength("COMO.L01022", detailRsParam.getInventoryStu(), true, 3);
//                    this.validatorDecimal("COMO.L01028", detailRsParam.getInventoryQty(), true, 12, 2, 5);
                    this.validatorDecimal("COMO.L01023", detailRsParam.getPlanQty(), true, 12, 2, 5);
//                    this.validatorDecimal("COMO.L01027", detailRsParam.getFactQty(), true, 12, 2, 5);
                }
            } else {
                this.validatorRequired("COMO.L01025", null);
            }
        } else {
            this.validatorRequired("COMO.L01005", null);
        }
    }
}
