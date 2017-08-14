package com.bms.region.validator;

import com.bms.region.bean.param.BaseBean;
import com.bms.region.bean.param.RegnLogDemesneParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by guan_zhongheng on 2017/2/21.
 */
public class LogisticsDemesneUpdateValidator extends DefaultCustomValidator<BaseBean<RegnLogDemesneParam, RegnLogDemesneParam>> {

    @Override
    public void validator(BaseBean<RegnLogDemesneParam, RegnLogDemesneParam> param) {
        if (param != null) {
            this.validatorLong("REGN.L00031", param.getFilter().getDemesneId(), true, 9223372036854775807L, 0L, 4);
            if("0".equals(param.getTarget().getDisableFlg())){

            }else{
                this.validatorRequired("REGN.L00032", param.getTarget().getDemesneType());
                this.validatorRequired("REGN.L00034", param.getTarget().getDemesneName());
                this.validatorRequired("REGN.L00033", param.getTarget().getDemesneCode());
            }
        } else {
            this.validatorRequired("REGN.E00011", null);
        }
    }
}
