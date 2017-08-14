package com.bms.como.validator;

import com.bms.como.bean.param.BaseBean;
import com.bms.como.bean.param.ComoInfoRsParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by yuan_zhifei on 2017/3/27.
 */
public class ComoInfoUpdateValidator extends DefaultCustomValidator<BaseBean<ComoInfoRsParam, ComoInfoRsParam>> {
    @Override
    public void validator(BaseBean<ComoInfoRsParam, ComoInfoRsParam> comoInfoRsParamComoInfoRsParamBaseBean) {
        if(comoInfoRsParamComoInfoRsParamBaseBean != null && comoInfoRsParamComoInfoRsParamBaseBean.getFilter() != null){
            ComoInfoRsParam comoInfoRsParam = comoInfoRsParamComoInfoRsParamBaseBean.getFilter();
            this.validatorRequired("commodityId", comoInfoRsParam.getCommodityId());
        }
    }

}
