package com.bms.bypo.validator;

import com.bms.bypo.bean.param.BaseBean;
import com.bms.bypo.bean.param.ProductSaleRsParam;
import com.bms.bypo.constant.MessageDef;
import com.framework.validator.DefaultCustomValidator;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by zhang_jian4 on 2017/01/06
 */
public class ProductSaleModifyValidator extends DefaultCustomValidator<BaseBean<ProductSaleRsParam, ProductSaleRsParam>> {
    @Override
    public void validator(BaseBean<ProductSaleRsParam, ProductSaleRsParam> params) {
        if (params != null) {
            ProductSaleRsParam filter;
            ProductSaleRsParam target;
            filter = params.getFilter();
            target = params.getTarget();
            this.validatorRequired(MessageDef.Label.L00055, filter.getProductSaleId());
            // 根据delFlg 判断是更新还是删除
            if (!target.isDelFlg()) {
                // 判断查询参数的长度
                if (filter.getSaleDate() != null) {
                    this.validatorDate(MessageDef.Label.L00056, filter.getSaleDate(), true);
                }
                if (filter.getSaleAmount() != null) {
                    this.validatorInteger(MessageDef.Label.L00057, filter.getSaleAmount(), true, 2147483647, 0, 5);
                }
                if (filter.getPrice() != null) {
                    this.validatorDecimal(MessageDef.Label.L00058, filter.getPrice(), true, 12, 2, 5);
                }
                if (StringUtils.isNotEmpty(filter.getPriceChannel())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00059, filter.getPriceChannel(), true, 32);
                }
                if (StringUtils.isNotEmpty(filter.getCustomer())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00060, filter.getCustomer(), true, 32);
                }

                //
                if (target.getSaleDate() != null) {
                    this.validatorDate(MessageDef.Label.L00056, target.getSaleDate(), true);
                }
                if (target.getSaleAmount() != null) {
                    this.validatorInteger(MessageDef.Label.L00057, target.getSaleAmount(), true, 2147483647, 0, 5);
                }
                if (target.getPrice() != null) {
                    this.validatorDecimal(MessageDef.Label.L00058, target.getPrice(), true, 12, 2, 5);
                }
                if (StringUtils.isNotEmpty(target.getPriceChannel())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00059, target.getPriceChannel(), true, 32);
                }
                if (StringUtils.isNotEmpty(target.getCustomer())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00060, target.getCustomer(), true, 32);
                }
            }

        } else {
            this.validatorRequired(MessageDef.Label.L00018, null);
        }

    }
}
