package com.bms.agif.validator;

import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.param.ButlerIntroduceRsParam;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;

/**
 * Created by tao_zhifa on 2017/3/3.
 */
public class ButlerIntroduceUpdateValidator extends DefaultCustomValidator<ArrayList<BaseBean<ButlerIntroduceRsParam, ButlerIntroduceRsParam>>> {

    @Override
    public void validator(ArrayList<BaseBean<ButlerIntroduceRsParam, ButlerIntroduceRsParam>> paramList) {
        if (!CollectionUtils.isEmpty(paramList)) {
            for (int i = 0, size = paramList.size(); i < size; i++) {
                if(paramList.get(i).getTarget().getDelFlg() == null){
                    paramList.get(i).getTarget().setDelFlg(false);
                }
                this.validatorLong(i + 1, "AGIF.L03018", paramList.get(i).getFilter().getIntroduceId(), true, 9223372036854775806L, 0L, 5);
                if (StringUtils.isNotEmpty(paramList.get(i).getFilter().getButlerId())) {
                    this.validatorMaxLength("AGIF.L03002", paramList.get(i).getFilter().getButlerId(), true, 36);
                }
                if (paramList.get(i).getTarget() != null && !paramList.get(i).getTarget().getDelFlg()) {
                    if (StringUtils.isNotEmpty(paramList.get(i).getTarget().getIntroduceDetail())) {
                        this.validatorMaxLength("AGIF.L03020", paramList.get(i).getTarget().getIntroduceDetail(), true, 128);
                    }
                }
            }
        } else {
            this.validatorRequired("error.20002", null);
        }
    }
}
