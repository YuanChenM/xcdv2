package com.bms.agif.validator;

import com.bms.agif.bean.param.PartnerRsParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by yuan_zhifei on 2017/3/9.
 */
public class PartnerAddValidator extends DefaultCustomValidator<PartnerRsParam> {
    @Override
    public void validator(PartnerRsParam partnerRsParam) {
        if (partnerRsParam != null) {
            this.validatorMaxLength("AGIF.L01001", partnerRsParam.getAccountName(), true, 16);
            this.validatorMaxLength("AGIF.L01002", partnerRsParam.getTelNo(), true, 16);
            this.validatorMaxLength("AGIF.L01003", partnerRsParam.getPassword(), true, 16);
            this.validatorMaxLength("AGIF.L01004", partnerRsParam.getPartnerName(), true, 32);
            //this.validatorMaxLength("AGIF.L01005", partnerRsParam.getPartnerCode(), true, 16);
            this.validatorMaxLength("AGIF.L01006", partnerRsParam.getCategoryCode(), true, 2);
            this.validatorMaxLength("AGIF.L01007", partnerRsParam.getCategoryName(), true, 16);
            this.validatorMaxLength("AGIF.L01008", partnerRsParam.getPartnerSex(), true, 1);
            this.validatorMaxLength("AGIF.L01009", partnerRsParam.getPartnerCardId(), true, 32);
            this.validatorMaxLength("AGIF.L02017", partnerRsParam.getProvinceName(), true, 8);
            this.validatorLong("AGIF.L02015", partnerRsParam.getProvinceId(), true, Long.MAX_VALUE, 0L, 4);
            this.validatorMaxLength("AGIF.L02016", partnerRsParam.getProvinceCode(), true, 2);
            this.validatorLong("AGIF.L02018", partnerRsParam.getCityId(), true, Long.MAX_VALUE, 0L, 4);
            this.validatorMaxLength("AGIF.L02019", partnerRsParam.getCityCode(), true, 3);
            this.validatorMaxLength("AGIF.L02020", partnerRsParam.getCityName(), true, 16);
            this.validatorMaxLength("AGIF.L01010", partnerRsParam.getPartnerBankName(), true, 16);
            this.validatorMaxLength("AGIF.L01011", partnerRsParam.getPartnerBankAccountName(), true, 16);
            this.validatorMaxLength("AGIF.L01012", partnerRsParam.getPartnerBankAccount(), true, 32);
        } else {
            this.validatorRequired("error.20002", null);
        }
    }
}
