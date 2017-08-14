package com.bms.byim.validator;

import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.StorePictureRsParam;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;

/**
 * Created by yuan_zhifei on 2016/12/30.
 */
public class StorePictureModifyValidator extends DefaultCustomValidator<ArrayList<BaseBean<StorePictureRsParam, StorePictureRsParam>>> {
    @Override
    public void validator(ArrayList<BaseBean<StorePictureRsParam, StorePictureRsParam>> beanBaseRequest) {
        if (CollectionUtils.isNotEmpty(beanBaseRequest)) {

            int listSize = beanBaseRequest.size();
            for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
                StorePictureRsParam filter = beanBaseRequest.get(i).getFilter();
                StorePictureRsParam target = beanBaseRequest.get(i).getTarget();
                this.validatorLong("BYIM.L00104", filter.getPicId(), true, 9223372036854775807L, 0L, 5);
                if (StringUtils.isNotEmpty(filter.getLicenseType())) {
                    this.validatorMaxLength("BYIM.L00088", filter.getLicenseType(), true, 1);
                }

                if (StringUtils.isNotEmpty(target.getLicensePic())) {
                    this.validatorMaxLength("BYIM.L00089", target.getLicensePic(), true, 16);
                }
            }
        } else {
            this.validatorRequired("BYIM.L00009", null);
        }
    }
}
