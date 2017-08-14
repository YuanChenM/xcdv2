package com.bms.dictionary.validator;

import com.bms.dictionary.bean.param.CreateDictParam;
import com.framework.i18n.util.MessageManager;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by dai_youcheng on 2016-11-15.
 */
public class CreateCatalogNodeValidator extends DefaultCustomValidator<CreateDictParam> {

    @Override
    public void validator(CreateDictParam createDictParam) {
        this.validatorRequired("dictionary.Validator.E014",createDictParam);
        if(null != createDictParam){
            this.validatorMaxLength("dictionary.Validator.E003", createDictParam.getRootCode(),true,40);
            this.validatorMaxLength("dictionary.Validator.E004", createDictParam.getParentCode(), true, 40);
            this.validatorMaxLength("dictionary.Validator.E005", createDictParam.getDictCode(), true, 40);
            this.validatorPattern("dictionary.Validator.E006", createDictParam.getDictEn(), true, "^([a-zA-Z0-9_\\s]+)$", MessageManager.getMessage("dictionary.Validator.E011"));
            this.validatorRequired("dictionary.Validator.E007", createDictParam.getDictCn());
            this.validatorRequired("dictionary.Validator.E009", createDictParam.getIsRoot());
        }
    }
}
