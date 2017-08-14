package com.bms.agif.validator;

import com.bms.agif.bean.param.ButlerBuyerRelationRsPageParam;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;

/**
 * Created by tao_zhifa on 2017/3/17.
 */
public class ButlerBuyerRelationAddValidator extends DefaultCustomValidator<ArrayList<ButlerBuyerRelationRsPageParam>> {

    @Override
    public void validator(ArrayList<ButlerBuyerRelationRsPageParam> paramList) {
        if (!CollectionUtils.isEmpty(paramList)) {
            for (int i = 0, size = paramList.size(); i < size; i++) {
                this.validatorMaxLength("AGIF.L02012", paramList.get(i).getAgentId(), true, 36);
                this.validatorMaxLength("AGIF.L03002", paramList.get(i).getButlerId(), true, 36);
                this.validatorMaxLength("AGIF.L03039", paramList.get(i).getBuyerId(), true, 36);
                if (!StringUtils.isEmpty(paramList.get(i).getMemberType())) {
                    this.validatorMaxLength("AGIF.L03040", paramList.get(i).getMemberType(), true, 1);
                }
                if (!StringUtils.isEmpty(paramList.get(i).getBingingType())) {
                    this.validatorMaxLength("AGIF.L03041",  paramList.get(i).getBingingType(), true, 1);
                }
            }
        } else {
            this.validatorRequired("error.20002", null);
        }
    }
}
