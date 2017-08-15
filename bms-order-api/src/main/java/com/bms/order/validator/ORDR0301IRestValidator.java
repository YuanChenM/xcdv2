package com.bms.order.validator;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.bms.order.bean.param.ORDR0301IBeanParam;
import com.bms.order.common.rest.BusinessRestParam;
import com.bms.order.common.rest.param.RestOperator;
import com.framework.validator.DefaultCustomValidator;

/**
 * 配送通知单创建接口Validator
 *
 * @author li_huiqian
 */
public class ORDR0301IRestValidator extends OrderCustomValidator<BusinessRestParam<ORDR0301IBeanParam>> {
    @Override
    public void validator(BusinessRestParam<ORDR0301IBeanParam> param) {

        RestOperator operator = param.getOperator();
        this.validateOperator(operator);

        List<ORDR0301IBeanParam> beans = param.getBeans();

        int index = 1;
        for (ORDR0301IBeanParam bean : beans) {

            this.validatorRequired(index, "buyerOrderId", bean.getBuyerOrderId());
            this.validatorRequired(index, "receiverName", bean.getReceiverName());
            this.validatorRequired(index, "receiverPhone", bean.getReceiverPhone());
            this.validatorRequired(index, "receiverQQ", bean.getReceiverQQ());
            this.validatorRequired(index, "receiverWechat", bean.getReceiverWechat());
            this.validatorRequired(index, "receiverMail", bean.getReceiverMail());
            this.validatorRequired(index, "receiverProvince", bean.getReceiverProvince());
            this.validatorRequired(index, "receiverCity", bean.getReceiverCity());
            this.validatorRequired(index, "receiverDistrict", bean.getReceiverDistrict());
            this.validatorRequired(index, "receiverAddress", bean.getReceiverAddress());
            this.validatorRequired(index, "receiverAssistAddress", bean.getReceiverAssistAddress());
            this.validatorRequired(index, "receivePeriod", bean.getReceivePeriod());
            this.validatorRequired(index, "animalQuarantineCertificationFlg",
                    bean.getAnimalQuarantineCertificationFlg());
            this.validatorRequired(index, "details", bean.getDetails());
            if (CollectionUtils.isNotEmpty(bean.getDetails())) {
                int indexOfDetails = 1;
                for (ORDR0301IBeanParam.ORDR0301IDetail detail : bean.getDetails()) {
                    this.validatorRequired(indexOfDetails, "buyerForcastDeliverDetailId",
                            detail.getBuyerForcastDeliverDetailId());
                    indexOfDetails++;
                }
            }
            index++;
        }
    }
}
