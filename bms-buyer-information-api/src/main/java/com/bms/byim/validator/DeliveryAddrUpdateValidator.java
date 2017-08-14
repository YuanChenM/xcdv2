package com.bms.byim.validator;

import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.DeliveryAddrRsParam;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by zhao_chen1 on 2016/12/30.
 */
public class DeliveryAddrUpdateValidator extends DefaultCustomValidator<BaseBean<DeliveryAddrRsParam, DeliveryAddrRsParam>> {
    @Override
    public void validator(BaseBean<DeliveryAddrRsParam, DeliveryAddrRsParam> result) {

        if (result != null) {
            DeliveryAddrRsParam filter = result.getFilter();
            DeliveryAddrRsParam target = result.getTarget();
            this.validatorLong("BYIM.L00109", filter.getDeliveryId(), true, 9223372036854775807L, 0L, 4);

            if (target.isDelFlg()) {

            } else {
                //this.validatorRequired("BYIM.L00051", target.getBuyerId());
                //this.validatorLong("BYIM.L00051", target.getProvinceId(), true, 9223372036854775807L, 0L, 4);
                this.validatorLong("BYIM.L00035", target.getProvinceId(), true, Long.MAX_VALUE, Long.MIN_VALUE, 4);
                this.validatorRequired("BYIM.L00018", target.getProvinceCode());
                this.validatorRequired("BYIM.L00019", target.getProvinceName());
                this.validatorLong("BYIM.L00041", target.getDistrictId(), true, Long.MAX_VALUE, Long.MIN_VALUE, 4);
                this.validatorRequired("BYIM.L00042", target.getDistrictCode());
                this.validatorRequired("BYIM.L00043", target.getDistrictName());
                this.validatorLong("BYIM.L00106", target.getCityId(), true, Long.MAX_VALUE, Long.MIN_VALUE, 4);
                this.validatorRequired("BYIM.L00020", target.getCityCode());
                this.validatorRequired("BYIM.L00017", target.getCityName());
            }
            if (StringUtils.isNotEmpty(target.getDeliveryAddr())) {
                this.validatorMaxLength("BYIM.L00114", target.getDeliveryAddr(), false, 512);
            }

            if (StringUtils.isNotEmpty(target.getReferenceAddr())) {
                this.validatorMaxLength("BYIM.L00110", target.getReferenceAddr(), false, 512);
            }

            if (StringUtils.isNotEmpty(target.getManageAddr())) {
                this.validatorMaxLength("BYIM.L00111", target.getManageAddr(), false, 512);
            }

            if (StringUtils.isNotEmpty(target.getReceivePersonName())) {
                this.validatorMaxLength("BYIM.L00107", target.getReceivePersonName(), false, 32);
            }

            if (StringUtils.isNotEmpty(target.getReceivePersonTel())) {
                this.validatorMaxLength("BYIM.L00108", target.getReceivePersonTel(), false, 32);
            }

            if (StringUtils.isNotEmpty(target.getReceivePersonWechat())) {
                this.validatorMaxLength("BYIM.L00112", target.getReceivePersonWechat(), false, 32);
            }
            this.validatorLong("BYIM.L00021", target.getDeliveryAreaId(), false, Long.MAX_VALUE, Long.MIN_VALUE, 4);

            if (StringUtils.isNotEmpty(target.getDeliveryArea())) {
                this.validatorMaxLength("BYIM.L00013", target.getDeliveryArea(), false, 16);
            }
            if (StringUtils.isNotEmpty(target.getPassTrafficModel())) {
                this.validatorMaxLength("BYIM.L00015", target.getPassTrafficModel(), false, 32);
            }
            //filter  还需要加
            if (StringUtils.isNotEmpty(filter.getDeliveryAddr())) {
                this.validatorMaxLength("BYIM.L00105", filter.getDeliveryAddr(), false, 512);
            }

            if (StringUtils.isNotEmpty(filter.getReferenceAddr())) {
                this.validatorMaxLength("BYIM.L00110", filter.getReferenceAddr(), false, 512);
            }

            if (StringUtils.isNotEmpty(filter.getManageAddr())) {
                this.validatorMaxLength("BYIM.L00111", filter.getManageAddr(), false, 512);
            }

            if (StringUtils.isNotEmpty(filter.getReceivePersonName())) {
                this.validatorMaxLength("BYIM.L00107", filter.getReceivePersonName(), false, 32);
            }

            if (StringUtils.isNotEmpty(filter.getReceivePersonTel())) {
                this.validatorMaxLength("BYIM.L00108", filter.getReceivePersonTel(), false, 32);
            }

            if (StringUtils.isNotEmpty(filter.getReceivePersonWechat())) {
                this.validatorMaxLength("BYIM.L00112", filter.getReceivePersonWechat(), false, 32);
            }
            this.validatorLong("BYIM.L00021", filter.getDeliveryAreaId(), false, Long.MAX_VALUE, Long.MIN_VALUE, 4);

            if (StringUtils.isNotEmpty(filter.getDeliveryArea())) {
                this.validatorMaxLength("BYIM.L00013", filter.getDeliveryArea(), false, 16);
            }
            if (StringUtils.isNotEmpty(filter.getPassTrafficModel())) {
                this.validatorMaxLength("BYIM.L00015", filter.getPassTrafficModel(), false, 32);
            }

        }
    }
}
