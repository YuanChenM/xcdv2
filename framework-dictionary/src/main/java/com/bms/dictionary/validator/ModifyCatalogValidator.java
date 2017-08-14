package com.bms.dictionary.validator;

import com.bms.dictionary.bean.param.ModifyDictParam;
import com.framework.i18n.util.MessageManager;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by dai_youcheng on 2016-11-15.
 */
public class ModifyCatalogValidator extends DefaultCustomValidator<ModifyDictParam> {
    @Override
    public void validator(ModifyDictParam modifyDictParam) {
        this.validatorRequired("dictionary.Validator.E014",modifyDictParam);
        if(null != modifyDictParam){
            this.validatorRequired("dictionary.Validator.E001", modifyDictParam.getDictId());
            this.validatorPattern("dictionary.Validator.E006", modifyDictParam.getDictEn(), true, "^([a-zA-Z0-9_\\s]+)$", MessageManager.getMessage("dictionary.Validator.E011"));
            this.validatorRequired("dictionary.Validator.E007", modifyDictParam.getDictCn());
        }
    }
}
