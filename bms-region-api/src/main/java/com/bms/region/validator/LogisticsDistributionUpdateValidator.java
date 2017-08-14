package com.bms.region.validator;

import com.bms.region.bean.param.BaseBean;
import com.bms.region.bean.param.RegnLogDistributionParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by guan_zhongheng on 2017/2/21.
 */
public class LogisticsDistributionUpdateValidator
        extends DefaultCustomValidator<BaseBean<RegnLogDistributionParam, RegnLogDistributionParam>> {

    @Override
    public void validator(BaseBean<RegnLogDistributionParam, RegnLogDistributionParam> param) {
        if (param != null) {
            this.validatorLong("REGN.L00027", param.getFilter().getDistributionId(), true, 9223372036854775807L, 0L, 4);
            if ( "0".equals(param.getTarget().getDisableFlg())) {
            } else {
                this.validatorRequired("REGN.L00028", param.getTarget().getDistributionType());
                this.validatorRequired("REGN.L00030", param.getTarget().getDistributionName());
                this.validatorRequired("REGN.L00029", param.getTarget().getDistributionCode());
            }
        } else {
            this.validatorRequired("REGN.E00011", null);
        }
    }
}
