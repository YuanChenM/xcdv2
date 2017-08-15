package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0502IParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * 新增单品品牌Validator
 */
public class SLPD0502IValidator extends DefaultCustomValidator<SLPD0502IParam> {

    @Override
    public void validator(SLPD0502IParam slpd0502IParam) {
        /*this.validatorRequired(MessageConstant.Label.Params,slpd0502IParam);
        if (null != slpd0502IParam){
            List<SlpdBrandItemParam> itemBrandList = slpd0502IParam.getItemBrandList();
            this.validatorRequired(MessageConstant.Label.Params,itemBrandList);
            if (CollectionUtils.isNotEmpty(itemBrandList)) {

                for (SlpdBrandItemParam param : itemBrandList) {
                    this.validatorRequired(MessageConstant.Label.ItemId,param.getItemId());
                    this.validatorRequired(MessageConstant.Label.BrandId,param.getBrandId());
                    this.validatorRequired(MessageConstant.Label.CrtId,param.getCrtId());
                }
            }
        }*/
    }
}
