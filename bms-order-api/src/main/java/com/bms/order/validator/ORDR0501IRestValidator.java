package com.bms.order.validator;

import com.bms.order.bean.param.ORDR0501IPaymentRestParam;
import com.bms.order.bean.param.ORDR0501IProductRestParam;
import com.bms.order.bean.param.ORDR0501IRestParam;
import com.bms.order.bean.param.ORDR0501IShipRestParam;
import com.bms.order.common.rest.MeiDefoeRestParam;
import com.bms.order.common.rest.param.RestOperator;
import com.bms.order.constant.i18n.FieldCode;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DecimalUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * 收货通知回传接口Validator
 *
 * @author li_huiqian
 */
public class ORDR0501IRestValidator extends OrderValidator<MeiDefoeRestParam<ORDR0501IRestParam>> {
    @Override
    public void validator(MeiDefoeRestParam<ORDR0501IRestParam> param) {
        RestOperator operator = param.getOperator();
        this.validateOperator(operator);
        ORDR0501IRestParam beanParam = param.getBeans();
        if (null != beanParam) {
            this.validateShipId(beanParam.getShipId(), true);
            this.validateApplyMan(beanParam.getApplyMan(), true);
            this.validateApplyTime(beanParam.getApplyTime(), true);
            this.validateBuyerId(beanParam.getBuyerId(), true);
            this.validateVersion(beanParam.getVer(), true);
            this.validatorRequired(FieldCode.IS_PAID, beanParam.getIsPaid());
            this.validatorRequired(FieldCode.PAYMENT_LIST, beanParam.getPaymentList());
            this.validatorRequired(FieldCode.SHIP_LIST, beanParam.getShipList());

            Boolean isDelay = false;// 是否迟收
            Boolean isReject = false;// 是否拒收
            if (!CollectionUtils.isEmpty(beanParam.getShipList())) {
                for (ORDR0501IShipRestParam shipRestParam : beanParam.getShipList()) {
                    this.validateDeliverCode(shipRestParam.getDeliverCode(), true);
                    this.validateActualReceiveDate(shipRestParam.getActualReceiveDate(), true);
                    this.validatorRequired(FieldCode.PRODUCT_LIST, shipRestParam.getProductList());
                    if (!CollectionUtils.isEmpty(shipRestParam.getProductList())) {
                        List<ORDR0501IProductRestParam> productList = shipRestParam.getProductList();
                        for (ORDR0501IProductRestParam productRestParam : productList) {
                            this.validateShipDetailId(productRestParam.getShipDetailId(), true);
                            this.validateSku(productRestParam.getSkuCode(), true);
                            this.validateReceiveQty(productRestParam.getReceiveQty(), true);
                            this.validateReceivePrice(productRestParam.getReceivePrice(), true);
                            BigDecimal delayQty = productRestParam.getDelayQty();
                            BigDecimal returnQty = productRestParam.getReturnQty();
                            if (DecimalUtils.gt(delayQty, BigDecimal.ZERO)) {// 含有配送数量
                                isDelay = true;
                            }
                            if (DecimalUtils.gt(returnQty, BigDecimal.ZERO)) {
                                isReject = true;
                            }
                            if (delayQty != null) {
                                this.validateDelayQty(productRestParam.getDelayQty(), true);
                                this.validateReturnQty(productRestParam.getReturnQty(), true);
                            }
                            if (returnQty != null) {
                                this.validateDelayQty(productRestParam.getDelayQty(), true);
                                this.validateReturnQty(productRestParam.getReturnQty(), true);
                            }
                        }
                    }
                }
            }
            this.validateReceiptDate(beanParam.getReceiptDate(), isDelay);
            if (isDelay || isReject) {
                this.validateReturnReasonId(beanParam.getReturnReasonID(), true);
            }
        }
    }
}
