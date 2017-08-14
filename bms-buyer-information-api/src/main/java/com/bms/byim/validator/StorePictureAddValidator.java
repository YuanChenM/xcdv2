package com.bms.byim.validator;

import com.bms.byim.bean.param.StorePictureRsParam;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuan_zhifei on 2016/12/30.
 */
public class StorePictureAddValidator extends DefaultCustomValidator<ArrayList<StorePictureRsParam>> {
    @Override
    public void validator(ArrayList<StorePictureRsParam> requestStorePictures) {
        List<StorePictureRsParam> pictureRsParams = requestStorePictures;
        StorePictureRsParam pictureRsParam = null;
        if (CollectionUtils.isNotEmpty(pictureRsParams)) {
            int listSize = pictureRsParams.size();
            for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
                pictureRsParam = pictureRsParams.get(i);
                this.validatorRequired("BYIM.L00051", pictureRsParam.getBuyerId());
                this.validatorMaxLength("BYIM.L00051", pictureRsParam.getBuyerId(), true, 36);
                this.validatorRequired("BYIM.L00037", pictureRsParam.getStoreId());
                this.validatorLong("BYIM.L00037", pictureRsParam.getStoreId(), true, 9223372036854775807L, 0L, 5);
                this.validatorRequired("BYIM.L00088", pictureRsParam.getLicenseType());
                this.validatorMaxLength("BYIM.L00088", pictureRsParam.getLicenseType(), true, 1);
                this.validatorRequired("BYIM.L00089", pictureRsParam.getLicensePic());
                this.validatorMaxLength("BYIM.L00089", pictureRsParam.getLicensePic(), true, 16);
            }
        } else {
            this.validatorRequired("BYIM.L00009", null);
        }
    }
}
