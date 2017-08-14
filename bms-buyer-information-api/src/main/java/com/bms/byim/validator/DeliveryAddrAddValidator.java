package com.bms.byim.validator;

import com.bms.byim.bean.param.DeliveryAddrRsParam;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

public class DeliveryAddrAddValidator extends DefaultCustomValidator<DeliveryAddrRsParam> {
    @Override
    public void validator(DeliveryAddrRsParam result) {

        if (result != null) {
            DeliveryAddrRsParam param;
            param = result;
            //
            this.validatorRequired("BYIM.L00051", param.getBuyerId());

            this.validatorLong("BYIM.L00051", param.getProvinceId(), true, Long.MAX_VALUE, Long.MIN_VALUE, 4);
            this.validatorLong("BYIM.L00035", param.getProvinceId(), true, Long.MAX_VALUE, Long.MIN_VALUE, 4);
            this.validatorRequired("BYIM.L00018", param.getProvinceCode());
            this.validatorRequired("BYIM.L00019", param.getProvinceName());
            this.validatorLong("BYIM.L00041", param.getDistrictId(), true, Long.MAX_VALUE, Long.MIN_VALUE, 4);
            this.validatorRequired("BYIM.L00042", param.getDistrictCode());
            this.validatorRequired("BYIM.L00043", param.getDistrictName());
            this.validatorLong("BYIM.L00106", param.getCityId(), true, Long.MAX_VALUE, Long.MIN_VALUE,4);
            this.validatorRequired("BYIM.L00020", param.getCityCode());
            this.validatorRequired("BYIM.L00017", param.getCityName());

            this.validatorRequired("BYIM.L00105", param.getDeliveryAddr());

            if (StringUtils.isNotEmpty(param.getReferenceAddr())) {
                this.validatorRequired("BYIM.L00110", param.getReferenceAddr());
            }

            if (StringUtils.isNotEmpty(param.getManageAddr())) {
                this.validatorRequired("BYIM.L00111", param.getManageAddr());
            }


            this.validatorRequired("BYIM.L00107", param.getReceivePersonName());

            this.validatorRequired("BYIM.L00108", param.getReceivePersonTel());

            if (StringUtils.isNotEmpty(param.getReceivePersonWechat())) {
                this.validatorMaxLength("BYIM.L00112", param.getReceivePersonWechat(), false, 32);
            }


            if (param.getDeliveryAreaId() != null) {
                this.validatorLong("BYIM.L00021", param.getDeliveryAreaId(), false, Long.MAX_VALUE, Long.MIN_VALUE, 4);
            }

            if (StringUtils.isNotEmpty(param.getDeliveryArea())) {
                this.validatorMaxLength("BYIM.L00013", param.getDeliveryArea(), false, 16);
            }
            if (StringUtils.isNotEmpty(param.getReceivePersonWechat())) {
                this.validatorMaxLength("BYIM.L00015", param.getPassTrafficModel(), false, 32);
            }

        }
    }
}
