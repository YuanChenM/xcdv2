package com.bms.agif.validator;

import com.bms.agif.bean.param.AccountParam;
import com.bms.agif.bean.param.BaseBean;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by tao_zhifa on 2017/3/21.
 */
public class AccountModifyValidator extends DefaultCustomValidator<BaseBean<AccountParam,AccountParam>> {

    @Override
    public void validator(BaseBean<AccountParam, AccountParam> baseBean) {
        if (baseBean != null) {

            this.validatorLong("AGIF.L03001",baseBean.getTarget().getAccountId(), true, 9223372036854775806L,0L, 5);
            if(!StringUtils.isEmpty(baseBean.getTarget().getAgentId())){
                this.validatorMaxLength("AGIF.L03002", baseBean.getTarget().getAgentId(), true, 36);
            }
            if(!StringUtils.isEmpty(baseBean.getTarget().getAccountName())){
                this.validatorMaxLength("AGIF.L03003", baseBean.getTarget().getAccountName(), true, 16);
            }
            if(!StringUtils.isEmpty(baseBean.getTarget().getTelNo())){
                this.validatorMaxLength("AGIF.L03005", baseBean.getTarget().getTelNo(), true, 16);
            }
            if(!StringUtils.isEmpty(baseBean.getTarget().getPassword())){
                this.validatorMaxLength("AGIF.L03004", baseBean.getTarget().getPassword(), true, 16);
            }
            if(!StringUtils.isEmpty(baseBean.getTarget().getMailAddr())){
                this.validatorMaxLength("AGIF.L03006", baseBean.getTarget().getMailAddr(), true, 32);
            }


        } else {
            this.validatorRequired("error.20002", null);
        }
    }
}
