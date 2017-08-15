package com.bms.order.validator;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.bms.order.bean.param.ORDR0201IBeanParam;
import com.bms.order.common.rest.BusinessRestParam;
import com.bms.order.common.rest.param.RestOperator;
import com.framework.validator.DefaultCustomValidator;

/**
 * 订单分拆单创建接口Validator
 *
 * @author li_huiqian
 */
public class ORDR0201IRestValidator extends OrderCustomValidator<BusinessRestParam<ORDR0201IBeanParam>> {
    @Override
    public void validator(BusinessRestParam<ORDR0201IBeanParam> param) {
        RestOperator operator = param.getOperator();
        if (operator == null) {
            this.validatorRequired("operator", operator);
        } else {
            this.validatorRequired("operatorType", operator.getOperatorType());
            this.validatorRequired("operatorId", operator.getOperatorId());
        }
        List<ORDR0201IBeanParam> beans = param.getBeans();
        if (CollectionUtils.isEmpty(beans)) {
            this.validatorRequired("beans", beans);
        } else {
            for (ORDR0201IBeanParam bean : beans) {
                List<ORDR0201IBeanParam.ORDR0201SpiltDetail> spiltDetails = bean.getSpiltDetails();
                if (CollectionUtils.isEmpty(spiltDetails)) {
                    this.validatorRequired("spiltDetails", spiltDetails);
                } else {
                    for (ORDR0201IBeanParam.ORDR0201SpiltDetail spiltDetail : spiltDetails) {
                        this.validatorRequired("buyerBatchOrderId", spiltDetail.getBuyerBatchOrderId());
                        this.validatorRequired("buyerBatchOrderDetailId", spiltDetail.getBuyerBatchOrderDetailId());
                        this.validatorMaxLength("sellSideType", spiltDetail.getSellSideType(), true, 3);
                        this.validatorRequired("sellSideId", spiltDetail.getSellSideId());
                        this.validatorRequired("goodsId", spiltDetail.getGoodsId());
                        this.validatorRequired("productId", spiltDetail.getProductId());
                        this.validatorRequired("manufacturerId", spiltDetail.getManufacturerId());
                        this.validatorRequired("sellerId", spiltDetail.getSellerId());
                      /*   this.validatorRequired("saleLabelId", spiltDetail.getSaleLabelId());*/
                        this.validatorRequired("sku", spiltDetail.getSku());
                        this.validatorRequired("planSendQuantity", spiltDetail.getPlanSendQuantity());
                    }
                }

            }
        }
    }
}