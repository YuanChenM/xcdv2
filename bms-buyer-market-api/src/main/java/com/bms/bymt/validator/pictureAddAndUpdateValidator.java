package com.bms.bymt.validator;

import com.bms.bymt.bean.param.BaseBean;
import com.bms.bymt.bean.param.MarketPictureRsParam;
import com.framework.base.consts.NumberConst;
import com.framework.validator.DefaultCustomValidator;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

/**
 * Created by zhao_chen1 on 2016/12/15.
 */
public class pictureAddAndUpdateValidator extends DefaultCustomValidator<ArrayList<BaseBean<MarketPictureRsParam, MarketPictureRsParam>>> {

    @Override
    public void validator(ArrayList<BaseBean<MarketPictureRsParam, MarketPictureRsParam>> params) {
        if (CollectionUtils.isNotEmpty(params)) {
            int size = params.size();
            MarketPictureRsParam filter;
            MarketPictureRsParam target;
            for (int i = NumberConst.IntDef.INT_ZERO; i < size; i++) {
                filter = params.get(i).getFilter();
                target = params.get(i).getTarget();
                this.validatorRequired("BYMT.L00052", target.getMarketId());
                this.validatorRequired("BYMT.L00055", target.isDelFlg());
                this.validatorRequired("BYMT.L00055", filter.isDelFlg());

                if (StringUtils.isNotEmpty(target.getCardAddress())) {
                    this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00054", target.getCardAddress(), false, 16);
                }
                if (filter.getPicId() != null) {
                    this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00052", filter.getPicId().toString(), false, 20);
                }
                if (StringUtils.isNotEmpty(target.getCardType())) {
                    this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00045", target.getCardType(), false, 2);
                }
            }
        } else {
            this.validatorRequired("BYMT.L00028", null);
        }
    }
}
