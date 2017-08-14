package com.bms.byim.validator;

import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.StandardFrequenterLevelRsParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;

/**
 * Created by zhao_chen1 on 2016/2/23.
 */
public class StandardFrequenterLevelUpdateValidator extends DefaultCustomValidator<ArrayList<BaseBean<StandardFrequenterLevelRsParam, StandardFrequenterLevelRsParam>>> {
    @Override
    public void validator(ArrayList<BaseBean<StandardFrequenterLevelRsParam, StandardFrequenterLevelRsParam>> result) {
        if (CollectionUtils.isNotEmpty(result)) {
            for (int i = 0; i < result.size(); i++) {
                StandardFrequenterLevelRsParam filter = result.get(i).getFilter();
                StandardFrequenterLevelRsParam target = result.get(i).getFilter();
            }
        }
    }
}
