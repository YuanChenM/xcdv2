package com.bms.order.validator;

import com.bms.order.bean.param.ORDR0606IBeanParam;
import com.bms.order.bean.param.ORDR0606IBeanParam.ORDR0606Product;
import com.bms.order.common.rest.BusinessRestParam;
import com.bms.order.constant.ValidatorConst;
import com.bms.order.constant.enumeration.BsOrderType;
import com.bms.order.constant.enumeration.Currency;
import com.bms.order.constant.i18n.FieldCode;
import com.bms.order.constant.i18n.ValidatorCode;
import com.framework.core.utils.CollectionUtils;
import com.framework.exception.bean.ValidatorExceptionMessage;
import com.framework.validator.utils.NumberValidator;

/**
 * 买手订单创建接口Validator
 *
 * @author li_huiqian
 */
public class ORDR0606IRestValidator extends OrderValidator<BusinessRestParam<ORDR0606IBeanParam>> {
    @Override
    public void validator(BusinessRestParam<ORDR0606IBeanParam> param) {
        // 验证Operator
        this.validateOperator(param.getOperator());
        this.validateBeans(param.getBeans());
        if (CollectionUtils.isEmpty(param.getBeans()))
            return;
        for (ORDR0606IBeanParam bean : param.getBeans()) {
            this.validatorMaxLength(FieldCode.BACK_NO, bean.getBackNo(), true,
                    ValidatorConst.MAX_LENGTH_BACK_NO);
            this.validatorMaxLength(FieldCode.SELLER_CODE, bean.getSellerCode(), false,
                    16);
            this.validatorMaxLength(FieldCode.SELLER_NAME, bean.getSellerName(), false,
                    32);

            this.validateOrderPlaceDatetime(bean.getOrderPlaceDatetime(), true);

            validatorRequired(FieldCode.ORDER_TYPE, bean.getOrderType());
            if (bean.getOrderType() != null && BsOrderType.getInstance(bean.getOrderType()) == null) {
                getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                        null, FieldCode.ORDER_TYPE, FieldCode.ORDER_TYPE, bean.getOrderType()));
            }

            this.validatorMaxLength(FieldCode.BUYER_CODE, bean.getBuyerCode(), false,
                    16);
            this.validatorMaxLength(FieldCode.BUYER_NAME, bean.getBuyerName(), false,
                    32);

            validatorDecimal(FieldCode.TOTAL_PRICE, bean.getTotalPrice(), true,
                    15, 2,
                    NumberValidator.NOT_NEGATIVE);
            validatorDecimal(FieldCode.TAX_RATE, bean.getTaxRate(), false,
                    5, 2,
                    NumberValidator.NOT_NEGATIVE);

            validatorRequired(FieldCode.CURRENCY, bean.getCurrency());
            if (bean.getCurrency() != null && Currency.getInstance(bean.getCurrency()) == null) {
                getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                        null, FieldCode.CURRENCY, FieldCode.CURRENCY, bean.getCurrency()));
            }

            validatorDecimal(FieldCode.SELLER_FEE_MONEY, bean.getTotalPrice(), true,
                    15, 2,
                    NumberValidator.NOT_NEGATIVE);
            validatorDecimal(FieldCode.SELLER_DEPOSIT_MONEY, bean.getTotalPrice(), true,
                    15, 2,
                    NumberValidator.NOT_NEGATIVE);
            validatorDecimal(FieldCode.SELLER_DEL_MONEY, bean.getTotalPrice(), true,
                    15, 2,
                    NumberValidator.NOT_NEGATIVE);
            validatorDecimal(FieldCode.BUYER_FEE_MONEY, bean.getTotalPrice(), true,
                    15, 2,
                    NumberValidator.NOT_NEGATIVE);
            validatorDecimal(FieldCode.BUYER_DEPOSIT_MONEY, bean.getTotalPrice(), true,
                    15, 2,
                    NumberValidator.NOT_NEGATIVE);
            validatorDecimal(FieldCode.BUYER_DEL_MONEY, bean.getTotalPrice(), true,
                    15, 2,
                    NumberValidator.NOT_NEGATIVE);

            validatorStrDate(FieldCode.TRADE_TIME, bean.getTradeTime(), true,
                    ValidatorConst.FORMAT_ORDER_PLACE_DATETIME);

            this.validateProductList(bean.getProducts());
            for (ORDR0606Product product : bean.getProducts()) {
                this.validateGoodsQuantity(product.getOrderCount(), true);
                this.validateGoodsUnit(product.getUnit(), true);

                this.validatorMaxLength(FieldCode.GOODS_CODE, product.getCommodityCode(), false,
                        16);
                this.validatorMaxLength(FieldCode.GOODS_NAME, product.getCommodityName(), false,
                        32);

            }
        }
    }

}
