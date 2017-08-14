package com.bms.agif.validator;

import com.bms.agif.bean.param.ButlerAddressRsParam;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;

/**
 * Created by tao_zhifa on 2017/3/3.
 */
public class ButlerAddressAddValidator extends DefaultCustomValidator<ArrayList<ButlerAddressRsParam>> {
    @Override
    public void validator(ArrayList<ButlerAddressRsParam> paramList) {
        if (!CollectionUtils.isEmpty(paramList)) {
            for (int i = 0, size = paramList.size(); i < size; i++) {
                this.validatorMaxLength(i + 1, "AGIF.L03002", paramList.get(i).getButlerId(), true, 36);
                this.validatorMaxLength(i + 1, "AGIF.L03008", paramList.get(i).getAddrType(), true, 1);
                this.validatorMaxLength(i + 1, "AGIF.L03009", paramList.get(i).getAddrTypeName(), true, 8);


                if(paramList.get(i).getProvinceId() != null){
                    this.validatorLong(i + 1, "AGIF.L02015", paramList.get(i).getProvinceId(), true, 9223372036854775806L, 0L, 5);
                }
                if(!StringUtils.isEmpty(paramList.get(i).getProvinceCode())){
                    this.validatorMaxLength(i + 1, "AGIF.L02016", paramList.get(i).getProvinceCode(), true, 3);
                }
                if(!StringUtils.isEmpty(paramList.get(i).getProvinceName())){
                    this.validatorMaxLength(i + 1, "AGIF.L02017", paramList.get(i).getProvinceName(), true, 8);
                }
                if(paramList.get(i).getCityId() != null){
                    this.validatorLong(i + 1, "AGIF.L02018", paramList.get(i).getCityId(), true, 9223372036854775806L, 0L, 5);
                }
                if(!StringUtils.isEmpty(paramList.get(i).getCityCode())){
                    this.validatorMaxLength(i + 1, "AGIF.L02019", paramList.get(i).getCityCode(), true, 3);
                }
                if(!StringUtils.isEmpty(paramList.get(i).getCityName())){
                    this.validatorMaxLength(i + 1, "AGIF.L02020", paramList.get(i).getCityName(), true, 16);
                }
                if(paramList.get(i).getDistrictId() != null){
                    this.validatorLong(i + 1, "AGIF.L02021", paramList.get(i).getDistrictId(), true, 9223372036854775806L, 0L, 5);
                }
                if(!StringUtils.isEmpty(paramList.get(i).getDistrictCode())){
                    this.validatorMaxLength(i + 1, "AGIF.L02022", paramList.get(i).getDistrictCode(), true, 2);
                }
                if(!StringUtils.isEmpty(paramList.get(i).getDistrictName())){
                    this.validatorMaxLength(i + 1, "AGIF.L02023", paramList.get(i).getDistrictName(), true, 16);
                }
                if(paramList.get(i).getStreetId() != null){
                    this.validatorLong(i + 1, "AGIF.L02024", paramList.get(i).getStreetId(), true, 9223372036854775806L, 0L, 5);
                }
                if(!StringUtils.isEmpty(paramList.get(i).getStreetCode())){
                    this.validatorMaxLength(i + 1, "AGIF.L02025", paramList.get(i).getStreetCode(), true, 2);
                }

                if(!StringUtils.isEmpty(paramList.get(i).getStreetName())){
                    this.validatorMaxLength(i + 1, "AGIF.L02026", paramList.get(i).getStreetName(), true, 32);
                }

                if(!StringUtils.isEmpty(paramList.get(i).getAddrDetail())){
                    this.validatorMaxLength(i + 1, "AGIF.L03010", paramList.get(i).getAddrDetail(), true, 128);
                }
            }
        } else {
            this.validatorRequired("error.20002", null);
        }
    }
}
