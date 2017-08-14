package com.bms.agif.validator;

import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.param.ButlerRsParam;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by tao_zhifa on 2017/3/3.
 */
public class ButlerUpdateValidator extends DefaultCustomValidator<BaseBean<ButlerRsParam, ButlerRsParam>> {

    @Override
    public void validator(BaseBean<ButlerRsParam, ButlerRsParam> baseBean) {
        if (null != baseBean) {
            if(baseBean.getTarget().getDelFlg() == null){
                baseBean.getTarget().setDelFlg(false);
            }
            if (!StringUtils.isEmpty(baseBean.getFilter().getButlerId())) {
                this.validatorMaxLength("AGIF.L03002", baseBean.getFilter().getButlerId(), true, 36);
            }

            if (baseBean.getTarget() != null && !baseBean.getTarget().getDelFlg()) {
                if (!StringUtils.isEmpty(baseBean.getFilter().getAgentId())) {
                    this.validatorMaxLength("AGIF.L02012", baseBean.getFilter().getAgentId(), true, 36);
                }
                if (!StringUtils.isEmpty(baseBean.getTarget().getButlerCode())) {
                    this.validatorMaxLength("AGIF.L03030", baseBean.getTarget().getButlerCode(), true, 24);
                }
                if (!StringUtils.isEmpty(baseBean.getTarget().getButlerName())) {
                    this.validatorMaxLength("AGIF.L03031", baseBean.getTarget().getButlerName(), true, 32);
                }
                if (!StringUtils.isEmpty(baseBean.getTarget().getButlerBirthday())) {
                    this.validatorMaxLength("AGIF.L03032", baseBean.getTarget().getButlerBirthday(), true, 8);
                }
                if (!StringUtils.isEmpty(baseBean.getTarget().getButlerSex())) {
                    this.validatorMaxLength("AGIF.L03033", baseBean.getTarget().getButlerSex(), true, 1);
                }
                if (!StringUtils.isEmpty(baseBean.getTarget().getButlerWechat())) {
                    this.validatorMaxLength("AGIF.L03034", baseBean.getTarget().getButlerWechat(), true, 16);
                }
                if (!StringUtils.isEmpty(baseBean.getTarget().getButlerQq())) {
                    this.validatorMaxLength("AGIF.L03035", baseBean.getTarget().getButlerQq(), true, 16);
                }
                if (!StringUtils.isEmpty(baseBean.getTarget().getIdCardFront())) {
                    this.validatorMaxLength("AGIF.L03036", baseBean.getTarget().getIdCardFront(), true, 16);
                }
                if (!StringUtils.isEmpty(baseBean.getTarget().getIdCardBack())) {
                    this.validatorMaxLength("AGIF.L03037", baseBean.getTarget().getIdCardBack(), true, 16);
                }
            }
        } else {
            this.validatorRequired("", null);
        }
    }
}
