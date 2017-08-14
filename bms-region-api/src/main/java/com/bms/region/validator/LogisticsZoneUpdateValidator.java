package com.bms.region.validator;

import com.bms.region.bean.param.BaseBean;
import com.bms.region.bean.param.RegnLogisticsZoneParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by guan_zhongheng on 2017/2/21.
 */
public class LogisticsZoneUpdateValidator extends DefaultCustomValidator<BaseBean<RegnLogisticsZoneParam, RegnLogisticsZoneParam>> {

    @Override
    public void validator(BaseBean<RegnLogisticsZoneParam, RegnLogisticsZoneParam> regnLogisticsCityParamBaseBean) {
        if(regnLogisticsCityParamBaseBean != null){
            this.validatorLong("REGN.L00010", regnLogisticsCityParamBaseBean.getFilter().getZoneId(), true, 9223372036854775807L, 0L, 4);
            if("0".equals(regnLogisticsCityParamBaseBean.getTarget().getDisableFlg())){
            }else{
                this.validatorMaxLength("REGN.L00025", regnLogisticsCityParamBaseBean.getTarget().getZoneCode().trim(), true, 3);
                this.validatorMaxLength("REGN.L00026", regnLogisticsCityParamBaseBean.getTarget().getZoneName().trim(), true, 8);
            }
        }else {
            this.validatorRequired("REGN.E00011", null);
        }
    }
}
