package com.bms.agif.validator;

import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.param.ButlerAddressRsParam;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;

/**
 * Created by tao_zhifa on 2017/3/3.
 */
public class ButlerAddressUpdateValidator extends DefaultCustomValidator<ArrayList<BaseBean<ButlerAddressRsParam, ButlerAddressRsParam>>> {

    @Override
    public void validator(ArrayList<BaseBean<ButlerAddressRsParam, ButlerAddressRsParam>> paramList) {
        if (!CollectionUtils.isEmpty(paramList)) {
            for (int i = 0, size = paramList.size(); i < size; i++) {
                if(paramList.get(i).getTarget().getDelFlg() == null){
                    paramList.get(i).getTarget().setDelFlg(false);
                }
                this.validatorLong(i + 1, "AGIF.L03007", paramList.get(i).getFilter().getAddrId(), true, 9223372036854775806L, 0L, 5);
                if (paramList.get(i).getTarget() != null && !paramList.get(i).getTarget().getDelFlg()) {

                    if (StringUtils.isNotEmpty(paramList.get(i).getFilter().getButlerId())) {
                        this.validatorMaxLength("AGIF.L03002", paramList.get(i).getFilter().getButlerId(), true, 36);
                    }

                    if (StringUtils.isNotEmpty(paramList.get(i).getTarget().getAddrType())) {
                        this.validatorMaxLength("AGIF.L03008", paramList.get(i).getTarget().getAddrType(), true, 1);
                    }
                    if (StringUtils.isNotEmpty(paramList.get(i).getTarget().getAddrTypeName())) {
                        this.validatorMaxLength("AGIF.L03009", paramList.get(i).getTarget().getAddrTypeName(), true, 8);
                    }
                    if (paramList.get(i).getTarget().getDistrictId() != null) {
                        this.validatorLong(i + 1, "AGIF.L02021", paramList.get(i).getTarget().getDistrictId(), true, 9223372036854775806L, 0L, 5);
                    }
                    if (StringUtils.isNotEmpty(paramList.get(i).getTarget().getDistrictCode())) {
                        this.validatorMaxLength("AGIF.L02022", paramList.get(i).getTarget().getDistrictCode(), true, 2);
                    }
                    if (StringUtils.isNotEmpty(paramList.get(i).getTarget().getDistrictName())) {
                        this.validatorMaxLength("AGIF.L02023", paramList.get(i).getTarget().getDistrictName(), true, 16);
                    }
                    if (paramList.get(i).getTarget().getProvinceId() != null) {
                        this.validatorLong(i + 1, "AGIF.L02015", paramList.get(i).getTarget().getProvinceId(), true, 9223372036854775806L, 0L, 5);
                    }
                    if (StringUtils.isNotEmpty(paramList.get(i).getTarget().getProvinceCode())) {
                        this.validatorMaxLength("AGIF.L02016", paramList.get(i).getTarget().getProvinceCode(), true, 3);
                    }
                    if (StringUtils.isNotEmpty(paramList.get(i).getTarget().getProvinceName())) {
                        this.validatorMaxLength("AGIF.L02017", paramList.get(i).getTarget().getProvinceName(), true, 8);
                    }
                    if (paramList.get(i).getTarget().getCityId() != null) {
                        this.validatorLong(i + 1, "AGIF.L02018", paramList.get(i).getTarget().getCityId(), true, 9223372036854775806L, 0L, 5);
                    }
                    if (StringUtils.isNotEmpty(paramList.get(i).getTarget().getCityCode())) {
                        this.validatorMaxLength("AGIF.L02019", paramList.get(i).getTarget().getCityCode(), true, 3);
                    }
                    if (StringUtils.isNotEmpty(paramList.get(i).getTarget().getCityName())) {
                        this.validatorMaxLength("AGIF.L02020", paramList.get(i).getTarget().getCityName(), true, 16);
                    }
                    if (paramList.get(i).getTarget().getStreetId() != null) {
                        this.validatorLong(i + 1, "AGIF.L02024", paramList.get(i).getTarget().getStreetId(), true, 9223372036854775806L, 0L, 5);
                    }
                    if (StringUtils.isNotEmpty(paramList.get(i).getTarget().getStreetCode())) {
                        this.validatorMaxLength("AGIF.L02025", paramList.get(i).getTarget().getStreetCode(), true, 2);
                    }
                    if (StringUtils.isNotEmpty(paramList.get(i).getTarget().getStreetName())) {
                        this.validatorMaxLength("AGIF.L02026", paramList.get(i).getTarget().getStreetName(), true, 32);
                    }
                    if (StringUtils.isNotEmpty(paramList.get(i).getTarget().getAddrDetail())) {
                        this.validatorMaxLength("AGIF.L03010", paramList.get(i).getTarget().getAddrDetail(), true, 128);
                    }
                }
            }
        } else {
            this.validatorRequired("error.20002", null);
        }
    }

}
