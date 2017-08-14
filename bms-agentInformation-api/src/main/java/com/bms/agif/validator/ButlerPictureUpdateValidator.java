package com.bms.agif.validator;

import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.param.ButlerPictureRsParam;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by tao_zhifa on 2017/3/3.
 */
public class ButlerPictureUpdateValidator extends DefaultCustomValidator<BaseBean<ButlerPictureRsParam, ButlerPictureRsParam>> {

    @Override
    public void validator(BaseBean<ButlerPictureRsParam, ButlerPictureRsParam> baseBean) {
        if (null != baseBean) {
            if(baseBean.getTarget().getDelFlg() == null){
                baseBean.getTarget().setDelFlg(false);
            }
            this.validatorLong("AGIF.L03011", baseBean.getFilter().getPicId(), true, 9223372036854775806L, 0L, 5);
            if (baseBean.getTarget() != null && !baseBean.getTarget().getDelFlg()) {
                if (!StringUtils.isEmpty(baseBean.getFilter().getButlerId())) {
                    this.validatorMaxLength("AGIF.L03002", baseBean.getFilter().getButlerId(), true, 36);
                }
                if (!StringUtils.isEmpty(baseBean.getTarget().getLicensePic())) {
                    this.validatorMaxLength("AGIF.L03012", baseBean.getTarget().getLicensePic(), true, 16);
                }
            }
        } else {
            this.validatorRequired("", null);
        }
    }
}
