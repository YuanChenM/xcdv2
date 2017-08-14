package com.bms.bypo.validator;

import com.bms.bypo.bean.param.ProductSaleRsParam;
import com.bms.bypo.constant.MessageDef;
import com.framework.validator.DefaultCustomValidator;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by zhang_jian4 on 2017/01/06.
 */
public class ProductSaleAddValidator extends DefaultCustomValidator<ProductSaleRsParam> {
    @Override
    public void validator(ProductSaleRsParam param) {
        if (null != param) {
            this.validatorRequired(MessageDef.Label.L00053, param.getResearchProductId());

            if (param.getSaleDate() != null) {
                this.validatorDate(MessageDef.Label.L00056, param.getSaleDate(), true);
            }
            if (param.getSaleAmount() != null) {
                this.validatorInteger(MessageDef.Label.L00057, param.getSaleAmount(), true, 2147483647, 0, 5);
            }
            if (param.getPrice() != null) {
                this.validatorDecimal(MessageDef.Label.L00058, param.getPrice(), true, 12, 2, 5);
            }
            if (StringUtils.isNotEmpty(param.getPriceChannel())) {
                this.validatorMaxLength(MessageDef.Label.L00059, param.getPriceChannel(), true, 32);
            }
            if (StringUtils.isNotEmpty(param.getCustomer())) {
                this.validatorMaxLength(MessageDef.Label.L00060, param.getCustomer(), true, 32);
            }

        } else {
            this.validatorRequired(MessageDef.Label.L00054, null);
        }
    }
}
