package com.bms.agif.validator;

import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.param.PartnerRsParam;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by yuan_zhifei on 2017/3/9.
 */
public class PartnerUpdateValidator extends DefaultCustomValidator<BaseBean<PartnerRsParam, PartnerRsParam>> {
    @Override
    public void validator(BaseBean<PartnerRsParam, PartnerRsParam> baseBean) {
        if (baseBean != null) {
            if (StringUtils.isNotEmpty(baseBean.getFilter().getPartnerId())) {
                this.validatorMaxLength("AGIF.L01000", baseBean.getFilter().getPartnerId(), true, 36);
            }

            if (StringUtils.isNotEmpty(baseBean.getFilter().getPartnerCode())) {
                this.validatorMaxLength("AGIF.L01005", baseBean.getFilter().getPartnerCode(), true, 36);
            }

            if (StringUtils.isNotEmpty(baseBean.getTarget().getPartnerName())) {
                this.validatorMaxLength("AGIF.L01004", baseBean.getTarget().getPartnerName(), true, 32);
            }
            /*if (StringUtils.isNotEmpty(baseBean.getTarget().getPartnerCode())) {
                this.validatorMaxLength("AGIF.L01005", baseBean.getTarget().getPartnerCode(), true, 16);
            }*/
            if (StringUtils.isNotEmpty(baseBean.getTarget().getCategoryCode())) {
                this.validatorMaxLength("AGIF.L01006", baseBean.getTarget().getCategoryCode(), true, 2);
            }
            if (StringUtils.isNotEmpty(baseBean.getTarget().getCategoryName())) {
                this.validatorMaxLength("AGIF.L01007", baseBean.getTarget().getCategoryName(), true, 16);
            }
            if (StringUtils.isNotEmpty(baseBean.getTarget().getPartnerSex())) {
                this.validatorMaxLength("AGIF.L01008", baseBean.getTarget().getPartnerSex(), true, 1);
            }
            if (StringUtils.isNotEmpty(baseBean.getTarget().getPartnerCardId())) {
                this.validatorMaxLength("AGIF.L01009", baseBean.getTarget().getPartnerCardId(), true, 32);
            }
            if (StringUtils.isNotEmpty(baseBean.getTarget().getProvinceName())) {
                this.validatorMaxLength("AGIF.L02017", baseBean.getTarget().getProvinceName(), true, 8);
            }
            if (StringUtils.isNotEmpty(baseBean.getTarget().getProvinceCode())) {
                this.validatorMaxLength("AGIF.L02016", baseBean.getTarget().getProvinceCode(), true, 2);
            }
            if (StringUtils.isNotEmpty(baseBean.getTarget().getCityCode())) {
                this.validatorMaxLength("AGIF.L02019", baseBean.getTarget().getCityCode(), true, 3);
            }
            if (StringUtils.isNotEmpty(baseBean.getTarget().getCityName())) {
                this.validatorMaxLength("AGIF.L02020", baseBean.getTarget().getCityName(), true, 16);
            }
            if (StringUtils.isNotEmpty(baseBean.getTarget().getPartnerBankName())) {
                this.validatorMaxLength("AGIF.L01010", baseBean.getTarget().getPartnerBankName(), true, 16);
            }
            if (StringUtils.isNotEmpty(baseBean.getTarget().getPartnerBankAccountName())) {
                this.validatorMaxLength("AGIF.L01011", baseBean.getTarget().getPartnerBankAccountName(), true, 16);
            }
            if (StringUtils.isNotEmpty(baseBean.getTarget().getPartnerBankAccount())) {
                this.validatorMaxLength("AGIF.L01012", baseBean.getTarget().getPartnerBankAccount(), true, 32);
            }
        } else {
            this.validatorRequired("error.20002", null);
        }
    }
}
