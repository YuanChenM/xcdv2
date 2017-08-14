package com.bms.dictionary.validator;

import com.bms.dictionary.bean.entity.DictNodeValue;
import com.bms.dictionary.bean.param.CreateDataParam;
import com.framework.i18n.util.MessageManager;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by dai_youcheng on 2016-11-15.
 */
public class CreateDataNodeValidator extends DefaultCustomValidator<CreateDataParam> {
    @Override
    public void validator(CreateDataParam createDataParam) {
        this.validatorRequired("dictionary.Validator.E014",createDataParam);
        if(null != createDataParam){
            this.validatorMaxLength("dictionary.Validator.E003", createDataParam.getRootCode(), true, 40);
            this.validatorMaxLength("dictionary.Validator.E005", createDataParam.getDictCode(), true, 40);
            for(DictNodeValue dictNodeValue:createDataParam.getValues()){
                this.validatorPattern("dictionary.Validator.E012", dictNodeValue.getDataEn(), true, "^([a-zA-Z0-9_\\s]+)$", MessageManager.getMessage("dictionary.Validator.E011"));
                this.validatorRequired("dictionary.Validator.E013", dictNodeValue.getDataCn());
                this.validatorRequired("dictionary.Validator.E008",dictNodeValue.getDataValue());
            }
        }
    }
}
