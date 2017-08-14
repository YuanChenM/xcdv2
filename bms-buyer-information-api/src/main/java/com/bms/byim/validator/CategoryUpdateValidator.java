package com.bms.byim.validator;

import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.CategoryRsParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;

/**
 * Created by tao_zhifa on 2016/12/9.
 */
public class CategoryUpdateValidator extends DefaultCustomValidator<ArrayList<BaseBean<CategoryRsParam, CategoryRsParam>>> {

    @Override
    public void validator(ArrayList<BaseBean<CategoryRsParam, CategoryRsParam>> baseBeanBaseRequest) {

        if (!CollectionUtils.isEmpty(baseBeanBaseRequest)) {
            for (int i = 0, lengths = baseBeanBaseRequest.size(); i < lengths; i++) {
                if (!StringUtils.isEmpty(baseBeanBaseRequest.get(i).getTarget().getCategoryName())) {
                    this.validatorMaxLength("BYIM.L00003", baseBeanBaseRequest.get(i).getTarget().getCategoryName(), true, 32);
                }
                if (!StringUtils.isEmpty(baseBeanBaseRequest.get(i).getTarget().getCategoryCode())) {
                    this.validatorMaxLength("BYIM.L00004", baseBeanBaseRequest.get(i).getTarget().getCategoryCode(), true, 8);
                }
                this.validatorLong("BYIM.L00006", baseBeanBaseRequest.get(i).getFilter().getCategoryId(), true, 9223372036854775806L, 0L, 5);
            }
        } else {
            this.validatorRequired("BYIM.E00009", null);
        }

    }
}

