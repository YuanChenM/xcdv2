package com.bms.agif.validator;

import com.bms.agif.bean.param.PartnerDistributionRsParam;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;

/**
 * Created by yuan_zhifei on 2017/3/9.
 */
public class PartnerDistributionAddValidator extends DefaultCustomValidator<ArrayList<PartnerDistributionRsParam>> {
    @Override
    public void validator(ArrayList<PartnerDistributionRsParam> partnerDistributionRsParams) {
        if (CollectionUtils.isNotEmpty(partnerDistributionRsParams)) {
            for (int i = NumberConst.IntDef.INT_ZERO; i < partnerDistributionRsParams.size(); i++) {
                this.validatorMaxLength("AGIF.L01000", partnerDistributionRsParams.get(i).getPartnerId(), true, 36);
                this.validatorLong("AGIF.L02034", partnerDistributionRsParams.get(i).getLgcsAreaId(), true, Long.MAX_VALUE, 0L, 4);
                this.validatorMaxLength("AGIF.L02035", partnerDistributionRsParams.get(i).getLgcsAreaCode(), true, 2);
                this.validatorMaxLength("AGIF.L02036", partnerDistributionRsParams.get(i).getLgcsAreaName(), true, 8);
                this.validatorLong("AGIF.L02037", partnerDistributionRsParams.get(i).getZoneId(), true, Long.MAX_VALUE, 0L, 4);
                this.validatorMaxLength("AGIF.L02038", partnerDistributionRsParams.get(i).getZoneCode(), true, 3);
                this.validatorMaxLength("AGIF.L02039", partnerDistributionRsParams.get(i).getZoneName(), true, 8);
                this.validatorLong("AGIF.L02040", partnerDistributionRsParams.get(i).getDistributionId(), true, Long.MAX_VALUE, 0L, 4);
                this.validatorMaxLength("AGIF.L02041", partnerDistributionRsParams.get(i).getDistributionType(), true, 2);
                this.validatorMaxLength("AGIF.L02043", partnerDistributionRsParams.get(i).getDistributionName(), true, 16);
                this.validatorMaxLength("AGIF.L02044", partnerDistributionRsParams.get(i).getDistributionCode(), true, 4);
                this.validatorMaxLength("AGIF.L02045", partnerDistributionRsParams.get(i).getAuthorizedPartner(), true, 36);
            }
        }
    }
}
