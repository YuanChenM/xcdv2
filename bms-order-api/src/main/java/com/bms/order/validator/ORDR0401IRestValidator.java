package com.bms.order.validator;

import com.bms.order.bean.param.ORDR0401IBeanParam;
import com.bms.order.common.rest.RestRequest;
import com.bms.order.constant.ValidatorConst;
import com.bms.order.constant.enumeration.GoodsUnit;
import com.bms.order.constant.i18n.ValidatorCode;
import com.framework.core.utils.DateUtils;
import com.framework.exception.bean.ValidatorExceptionMessage;
import com.framework.validator.utils.NumberValidator;

/**
 * 发货通知回传接口Validator
 *
 * @author li_huiqian
 */
public class ORDR0401IRestValidator extends OrderValidator<RestRequest<ORDR0401IBeanParam>> {
    @Override
    public void validator(RestRequest<ORDR0401IBeanParam>  request) {
            ORDR0401IBeanParam bean = request.getParam();
            this.validatorLong("ORDR.Field.orderId", bean.getOrderId(), true, Long.MAX_VALUE, Long.MIN_VALUE, 4);
            this.validatorLong("ORDR.Field.shipId", bean.getShipId(), true, Long.MAX_VALUE, Long.MIN_VALUE, 4);
            this.validatorMaxLength("ORDR.Field.whCode", bean.getWhCode(), true, 20);
            this.validatorMaxLength("ORDR.Field.whName", bean.getWhName(), true, 30);
            this.validatorRequired("ORDR.Field.shipList", bean.getShipList());
            for (ORDR0401IBeanParam.ORDR0401IDetail ship : bean.getShipList()){
                this.validatorMaxLength("ORDR.Field.deliverCode", ship.getDeliverCode(), true, ValidatorConst.MAX_LENGTH_SEND_NOTIFICATION_CODE);
                this.validatorMaxLength("ORDR.Field.deliverPerson", ship.getDeliverPerson(), true, ValidatorConst.MAX_LENGTH_DISTRIBUTION_PERSON_NAME);
                this.validatorMaxLength("ORDR.Field.personMobile", ship.getPersonMobile(), true, ValidatorConst.MAX_LENGTH_DISTRIBUTION_PERSON_PHONE);
                this.validatorMaxLength("ORDR.Field.deliverMode", ship.getDeliverMode(), false, ValidatorConst.MAX_LENGTH_DISTRIBUTION_TYPE);
                this.validatorMaxLength("ORDR.Field.remarks", ship.getRemarks(), false, ValidatorConst.MAX_LENGTH_SEND_NOTIFICATION_REMARKS);
                validatorDate("ORDR.Field.deliverDate", DateUtils.parseDateTime(ship.getDeliverDate()), true);
                validatorDate("ORDR.Field.expectReceiveDate", DateUtils.parseDateTime(ship.getExpectReceiveDate()), false);
                this.validatorRequired("ORDR.Field.productList", ship.getProductList());
                for (ORDR0401IBeanParam.ORDR0401IDetail.ORDR0401IProductList product : ship.getProductList()){
                    validatorLong("ORDR.Field.shipDetailId", product.getShipDetailId(), true, null,null, NumberValidator.POSITIVE);
                    this.validatorRequired("ORDR.Field.skuCode", product.getSkuCode());
                    GoodsUnit type = GoodsUnit.getInstance(product.getUnit());
                    validatorRequired("ORDR.Field.unit", product.getUnit());
                    if (product.getUnit() != null && type == null) {
                        getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,null, "ORDR.Field.unit", "ORDR.Field.unit", product.getUnit()));
                    }
                    this.validatorRequired("ORDR.Field.lotList", product.getLotList());
                    for (ORDR0401IBeanParam.ORDR0401IDetail.ORDR0401IProductList.ORDR0401ILotList lot : product.getLotList()){
                        validatorDecimal("ORDR.Field.sendQty", lot.getSendQty(), true, ValidatorConst.MAX_M_RETURN_QTY,ValidatorConst.MAX_D_RETURN_QTY, NumberValidator.POSITIVE);
                    }
                }
            }
    }
}
