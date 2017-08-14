package com.bms.byim.validator;

import com.bms.byim.bean.param.CategoryRsParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;

/**
 * Created by tao_zhifa on 2016/12/9.
 */
public class CategoryAddValidator extends DefaultCustomValidator<ArrayList<CategoryRsParam>> {

    @Override
    public void validator(ArrayList<CategoryRsParam> paramBaseRequest) {
        if(!CollectionUtils.isEmpty(paramBaseRequest)){
            for (int i = 0, lengths = paramBaseRequest.size(); i < lengths; i++) {
                this.validatorLong("BYIM.L00002",paramBaseRequest.get(i).getParentId(),true,9223372036854775806L,0L,5);
                String path = paramBaseRequest.get(i).getNodePath();
                this.validatorMaxLength("BYIM.L00003",paramBaseRequest.get(i).getCategoryName(),true,32);
                if(!paramBaseRequest.get(i).getParentId().equals(0L)){
                    this.validatorMaxLength("BYIM.L00004",paramBaseRequest.get(i).getCategoryCode(),true,8);
                }

            }
        }else {
            this.validatorRequired("BYIM.E00009",null);
        }
    }
}
