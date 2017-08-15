package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0404IParam;
import com.framework.validator.DefaultCustomValidator;

/*
 * 新增品牌所有人验证
 */
public class SLPD0404IValidator extends DefaultCustomValidator<SLPD0404IParam> {
    @Override
    public void validator(SLPD0404IParam result) {
        /*List<SlpdBrandOwner> paramList = result.getBeans();


        this.validatorRequired(MessageConstant.Label.Beans, paramList);


        for (SlpdBrandOwner slpd : paramList) {
            this.validatorMaxLength(MessageConstant.Label.OwnerName, slpd.getOwnerName(), true, 256);
            this.validatorMaxLength(MessageConstant.Label.OwnerType, slpd.getOwnerType(), false, 1);
            this.validatorDate(MessageConstant.Label.UpdTime, slpd.getUpdTime(), false);
            this.validatorDate(MessageConstant.Label.CrtTime, slpd.getCrtTime(), false);
            this.validatorMaxLength(MessageConstant.Label.UpdId, slpd.getUpdId(), true, 32);
            this.validatorMaxLength(MessageConstant.Label.CrtId, slpd.getCrtId(), true, 32);
        }*/

    }
}
