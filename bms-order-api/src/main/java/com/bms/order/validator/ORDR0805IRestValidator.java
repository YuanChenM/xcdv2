package com.bms.order.validator;

import com.bms.order.bean.param.ORDR0805IBeanParam;
import com.bms.order.bean.param.ORDR0805ILotParam;
import com.bms.order.bean.param.ORDR0805IProductParam;
import com.bms.order.common.rest.RestRequest;
import com.bms.order.constant.i18n.FieldCode;

/**
 * 买家订单修改接口Validator
 *
 * @author li_huiqian
 */
public class ORDR0805IRestValidator extends OrderValidator<RestRequest<ORDR0805IBeanParam>> {

    @Override
    public void validator(RestRequest<ORDR0805IBeanParam> restRequest) {

        ORDR0805IBeanParam bean = restRequest.getParam();
            // 验证订单数据
            this.validatorLong("returnId",Long.valueOf(bean.getReturnId()), true, Long.MAX_VALUE, Long.MIN_VALUE, 4);
            validateInboundTime(bean.getInboundTime(), true);
            validateInboundUname(bean.getInboundPerson(), false);
            validateProductList(bean.getProductList());
            for (ORDR0805IProductParam productParam : bean.getProductList()) {
                this.validateDetailId(productParam.getReturnDetailId(), true);
                this.validateSkuCode(productParam.getSkuCode(),true);
                this.validatorRequired(FieldCode.LOT_LIST, productParam.getLotList());
                for (ORDR0805ILotParam lotParam : productParam.getLotList()) {
                    this.validateInboundBatch(lotParam.getLotNo(), true);
                    this.validateInboundQty(lotParam.getInboundQty(), true);
                }
            }
        }
}
