package com.bms.region.validator;

import com.bms.region.bean.param.BaseBean;
import com.bms.region.bean.param.ProvinceRsParam;
import com.bms.region.constant.MessageDef;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;

/**
 * Created by tao_zhifa on 2016/12/5.
 */
public class ProvinceUpdateValidator extends DefaultCustomValidator<ArrayList<BaseBean<ProvinceRsParam, ProvinceRsParam>>> {

    @Override
    public void validator(ArrayList<BaseBean<ProvinceRsParam, ProvinceRsParam>> regnProvinceRestRequest) {
        if(!CollectionUtils.isEmpty(regnProvinceRestRequest)){
            int count = regnProvinceRestRequest.size();
            for (int i = 0; i < count; i++) {
                this.validatorLong(i + 1, MessageDef.Label.L00013, regnProvinceRestRequest.get(i).getFilter().getProvinceId(), true, 9223372036854775806L, 0L, 5);
                if(!StringUtils.isEmpty(regnProvinceRestRequest.get(i).getTarget().getProvinceCode())){
                    this.validatorMaxLength(i + 1, MessageDef.Label.L00011, regnProvinceRestRequest.get(i).getTarget().getProvinceCode(), true, 2);
                }
                if(!StringUtils.isEmpty(regnProvinceRestRequest.get(i).getTarget().getProvinceName())){
                    this.validatorMaxLength(i + 1, MessageDef.Label.L00012, regnProvinceRestRequest.get(i).getTarget().getProvinceName(), true, 8);
                }
                if(!StringUtils.isEmpty(regnProvinceRestRequest.get(i).getTarget().getDisableFlg())){
                    this.validatorMaxLength(i + 1, MessageDef.Label.L00009, regnProvinceRestRequest.get(i).getTarget().getDisableFlg(), true, 1);
                }
            }
        }else {
            this.validatorRequired(MessageDef.Error.E00011,null);
        }

    }
}
