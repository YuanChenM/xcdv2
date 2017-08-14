package com.bms.dictionary.validator;

import com.bms.dictionary.bean.param.ModifyDataParam;
import com.framework.i18n.util.MessageManager;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by dai_youcheng on 2016-11-15.
 */
public class ModifyDataValidator extends DefaultCustomValidator<ModifyDataParam> {
    @Override
    public void validator(ModifyDataParam modifyDataParam) {
        this.validatorRequired("dictionary.Validator.E014",modifyDataParam);
        if(null != modifyDataParam){
            this.validatorRequired("dictionary.Validator.E002", modifyDataParam.getDataId());
            this.validatorPattern("dictionary.Validator.E012", modifyDataParam.getDataEn(), true, "^([a-zA-Z0-9_\\s]+)$", "dictionary.Validator.E011");
            this.validatorRequired("dictionary.Validator.E013", modifyDataParam.getDataCn());
        }
    }
}
