package com.bms.agif.validator;

import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.param.PartnerDistributionRsParam;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by yuan_zhifei on 2017/3/31.
 */
public class PartnerDistributionUpdateValidator extends DefaultCustomValidator<BaseBean<PartnerDistributionRsParam, PartnerDistributionRsParam>> {
    @Override
    public void validator(BaseBean<PartnerDistributionRsParam, PartnerDistributionRsParam> baseBean) {
        if (baseBean != null) {
            this.validatorLong("AGIF.L01014", baseBean.getFilter().getId(), true, Long.MAX_VALUE, 0L, 4);
            if (StringUtils.isNotEmpty(baseBean.getTarget().getLgcsAreaCode())) {
                this.validatorMaxLength("AGIF.L02035", baseBean.getTarget().getLgcsAreaCode(), true, 2);
            }
            if (StringUtils.isNotEmpty(baseBean.getTarget().getLgcsAreaName())) {
                this.validatorMaxLength("AGIF.L02036", baseBean.getTarget().getLgcsAreaName(), true, 8);
            }
            if (StringUtils.isNotEmpty(baseBean.getTarget().getZoneCode())) {
                this.validatorMaxLength("AGIF.L02038", baseBean.getTarget().getZoneCode(), true, 3);
            }
            if (StringUtils.isNotEmpty(baseBean.getTarget().getZoneName())) {
                this.validatorMaxLength("AGIF.L02039", baseBean.getTarget().getZoneName(), true, 8);
            }
            if (StringUtils.isNotEmpty(baseBean.getTarget().getDistributionType())) {
                this.validatorMaxLength("AGIF.L02041", baseBean.getTarget().getDistributionType(), true, 2);
            }
            if (StringUtils.isNotEmpty(baseBean.getTarget().getDistributionName())) {
                this.validatorMaxLength("AGIF.L02043", baseBean.getTarget().getDistributionName(), true, 16);
            }
            if (StringUtils.isNotEmpty(baseBean.getTarget().getDistributionCode())) {
                this.validatorMaxLength("AGIF.L02044", baseBean.getTarget().getDistributionCode(), true, 4);
            }
            if (StringUtils.isNotEmpty(baseBean.getTarget().getAuthorizedPartner())) {
                this.validatorMaxLength("AGIF.L02045", baseBean.getTarget().getAuthorizedPartner(), true, 36);
            }
        } else {
            this.validatorRequired("error.20002", null);
        }
    }
}
