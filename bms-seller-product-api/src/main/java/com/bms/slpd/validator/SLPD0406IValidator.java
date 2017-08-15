package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0406IParam;
import com.framework.validator.DefaultCustomValidator;

/*
 * 修改品牌所有人验证
 */
public class SLPD0406IValidator extends DefaultCustomValidator<SLPD0406IParam> {
    @Override
    public void validator(SLPD0406IParam request) {
        /*List<SLPD0406IParam> paramList = request.getBeans();

        this.validatorRequired(MessageConstant.Label.Beans, paramList);
        this.validatorRequired(MessageConstant.Label.Targets, request.getTargets());


        if (CollectionUtils.isNotEmpty(paramList)) {
            for (SLPD0406IParam slpd : paramList) {
                this.validatorMaxLength(MessageConstant.Label.OwnerName, slpd.getOwnerName(), false, 256);
                this.validatorMaxLength(MessageConstant.Label.OwnerType, slpd.getOwnerType(), false, 1);
                this.validatorMaxLength(MessageConstant.Label.UpdId, slpd.getUpdId(), true, 32);
                this.validatorDate(MessageConstant.Label.UpdTime, slpd.getUpdTime(), false);
                this.validatorInteger(MessageConstant.Label.Version, slpd.getVersion(), true, Integer.MAX_VALUE, Integer.MIN_VALUE, 4);
            }
        }*/
    }
}
