package com.bms.order.validator;

import java.util.List;

import com.bms.order.bean.param.ORDR060201IBeanParam;
import com.bms.order.bean.param.ORDR0602IBeanParam;
import com.bms.order.common.rest.BusinessRestParam;
import com.bms.order.common.rest.param.RestOperator;
import com.bms.order.constant.OrderConst;
import com.bms.order.constant.enumeration.GoodsUnit;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.FieldCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.constant.i18n.ValidatorCode;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.exception.bean.ValidatorExceptionMessage;
import com.framework.validator.utils.NumberValidator;

/**
 * 买手订单修改接口Validator
 * 
 * @author li_huiqian
 */
public class ORDR0602IRestValidator extends OrderCustomValidator<BusinessRestParam<ORDR0602IBeanParam>> {
    @Override
    public void validator(BusinessRestParam<ORDR0602IBeanParam> param) {
        // 验证Operator
        RestOperator operator = param.getOperator();
        this.validateOperator(operator);

        List<ORDR0602IBeanParam> params = param.getBeans();
        for (ORDR0602IBeanParam bean : params) {
            // 验证买手订单
            validatorBsOrder(bean);

            List<ORDR060201IBeanParam> productList = bean.getProducts();
            if (productList != null) {
                if (productList.size() == 0)
                    throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060208);

                for (ORDR060201IBeanParam productParam : productList) {
                    // 验证买手订单明细合集
                    validatorBsOrderDetail(productParam);
                }
            }
        }

    }

    /**
     * 验证买手订单
     * 
     * @param param
     */
    private void validatorBsOrder(ORDR0602IBeanParam param) {

        this.validatorLong(FieldCode.BS_ORDER_ID, param.getBsOrderId(), false, OrderConst.MAX_VALUE_BIGINT_ID,
                OrderConst.MIN_VALUE_BIGINT_ID, NumberValidator.POSITIVE);
        //订单：参考号非必填
        this.validatorMaxLength(FieldCode.BACK_NO,param.getBackNo(),false,OrderConst.MAX_LENGTH_BACK_NO);

        // 优惠金额，非必填，(15,2)，非负数
        this.validatorDecimal(FieldCode.EARNEST_AMOUNT, param.getPreferentialAmount(), false, OrderConst.MAX_M_AMOUNT,
                OrderConst.MAX_D_AMOUNT, NumberValidator.NOT_NEGATIVE);

        // 定金应付金额，非必填，(15,2)，非负数
        this.validatorDecimal(FieldCode.EARNEST_AMOUNT, param.getEarnestAmount(), false, OrderConst.MAX_M_AMOUNT,
                OrderConst.MAX_D_AMOUNT, NumberValidator.NOT_NEGATIVE);

        // 预付应付金额，非必填，(15,2)，非负数
        this.validatorDecimal(FieldCode.EARNEST_AMOUNT, param.getAdvancePaymentAmount(), false, OrderConst.MAX_M_AMOUNT,
                OrderConst.MAX_D_AMOUNT, NumberValidator.NOT_NEGATIVE);

        // 版本号，必填，最大OrderConst.MAX_VALUE_VERSION，最小OrderConst.MIN_VALUE_VERSION，正数
        this.validatorInteger(FieldCode.VER, param.getVer(), true, OrderConst.MAX_VALUE_PAGE_SIZE,
                OrderConst.MIN_VALUE_VERSION, NumberValidator.POSITIVE);
    }

    /**
     * 验证买手订单明细
     * 
     * @param productParam
     */
    private void validatorBsOrderDetail(ORDR060201IBeanParam productParam) {

        if (productParam.getBsOrderDetailId() != null || productParam.getVer() != null) {
            // 买手订单明细id
            this.validatorLong(FieldCode.BS_ORDER_DETAIL_ID, productParam.getBsOrderDetailId(), true,
                    OrderConst.MAX_VALUE_BIGINT_ID, OrderConst.MIN_VALUE_BIGINT_ID, NumberValidator.POSITIVE);
            // 版本号，必填，最大OrderConst.MAX_VALUE_VERSION，最小OrderConst.MIN_VALUE_VERSION，正数
            this.validatorInteger(FieldCode.VER, productParam.getVer(), true, OrderConst.MAX_VALUE_PAGE_SIZE,
                    OrderConst.MIN_VALUE_VERSION, NumberValidator.POSITIVE);

        } else {

            // 商品数量
            if (productParam.getGoodsQuantity() == null) {
                // {0}中没有Code为"{1}"的值
                getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                        null, FieldCode.GOODS_QUANTITY, "GoodsQuantity", productParam.getGoodsQuantity().toString()));
            } else {
                this.validatorStrInteger(FieldCode.GOODS_QUANTITY, productParam.getGoodsQuantity().toString(), true,
                        OrderConst.MAX_VALUE_PAGE_SIZE, OrderConst.MIN_VALUE_START_POS, NumberValidator.POSITIVE);
            }

            // 商品单位
            if (StringUtils.isEmpty(productParam.getGoodsUnit())) {
                // {0}中没有Code为"{1}"的值
                getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                        null, FieldCode.GOODS_UNIT, "goodsUnit", productParam.getGoodsUnit()));
            } else {
                if (GoodsUnit.getInstance(productParam.getGoodsUnit()) == null) {
                    // {0}中没有Code为"{1}"的值
                    getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                            null, FieldCode.GOODS_UNIT, "goodsUnit", productParam.getGoodsUnit()));
                }
            }

            // 商品ID
            this.validatorMaxLength(FieldCode.GOODS_ID, productParam.getGoodsId(), true, OrderConst.MAX_LENGTH_PRODUCT_ID);

        }

    }

}
