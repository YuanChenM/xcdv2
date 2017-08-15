package com.bms.order.validator;

import com.bms.order.bean.param.ORDR0601IBeanParam;
import com.bms.order.bean.param.ORDR0601IBeanParam.ORDR0601Product;
import com.bms.order.common.rest.BusinessRestParam;
import com.bms.order.constant.i18n.FieldCode;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import com.framework.validator.utils.NumberValidator;

/**
 * 买手订单创建接口Validator
 *
 * @author li_huiqian
 */
public class ORDR0601IRestValidator extends OrderValidator<BusinessRestParam<ORDR0601IBeanParam>> {
    @Override
    public void validator(BusinessRestParam<ORDR0601IBeanParam> param) {
        // 验证Operator
        this.validateOperator(param.getOperator());
        this.validateBeans(param.getBeans());
        if (CollectionUtils.isEmpty(param.getBeans()))
            return;
        for (ORDR0601IBeanParam bean : param.getBeans()) {
            this.validateOrderType(bean.getOrderType(), true);
            this.validateBackNo(bean.getBackNo(), false);
            this.validatorMaxLength(FieldCode.LGCS_AREA_CODE, bean.getLgcsAreaCode(), false, 2);
            Boolean flg = false;
            if (!StringUtils.isEmpty(bean.getLgcsAreaCode())){
                flg = true;
            }
            this.validateSaleLabelCode(bean.getSalePlatformType(), true);
            this.validateOrderSourceType(bean.getOrderSourceType(), true);
            this.validateOrderPlacerId(bean.getOrderPlacerId(), true);
            this.validateOrderPlacerType(bean.getOrderPlacerType(), true);
            this.validateOrderPlaceDatetime(bean.getOrderPlaceDatetime(), true);
            this.validateBsId(bean.getBsId(), true);
            this.validateInvoiceFlg(bean.getInvoiceFlg(), false);
            this.validateUseNetFlg(bean.getUseNetFlg(), false);
            this.validatePreferentialAmount(bean.getPreferentialAmount(), false);
            this.validateEarnestAmount(bean.getEarnestAmount(), false);
            this.validateAdvancePaymentAmount(bean.getAdvancePaymentAmount(), false);
            this.validateProductList(bean.getProducts());
            for (ORDR0601Product product : bean.getProducts()) {
                this.validateGoodsQuantity(product.getGoodsQuantity(), true);
                this.validateGoodsUnit(product.getGoodsUnit(), true);
                this.validateGoodsId(product.getGoodsId(), true);
                if (flg){
                    this.validatorDecimal(FieldCode.PRICE_KG, product.getPriceKg(), true, 15, 4, NumberValidator.POSITIVE);
                    this.validatorDecimal(FieldCode.PRICE_UNIT, product.getPriceUnit(), true, 15, 4, NumberValidator.POSITIVE);
                    this.validatorMaxLength(FieldCode.WAY_DESC, product.getWayDesc(), true, 64);
                }
            }
        }
    }

}
