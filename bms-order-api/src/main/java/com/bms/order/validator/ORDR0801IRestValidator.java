package com.bms.order.validator;

import com.bms.order.bean.param.ORDR0801IBean;
import com.bms.order.bean.param.ORDR0801IDetailBean;
import com.bms.order.common.rest.BusinessRestParam;
import com.bms.order.constant.i18n.FieldCode;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;
import com.framework.validator.utils.NumberValidator;

/**
 * 买家退货单创建接口Validator
 *
 * @author li_huiqian
 */
public class ORDR0801IRestValidator extends OrderValidator<BusinessRestParam<ORDR0801IBean>> {
    @Override
    public void validator(BusinessRestParam<ORDR0801IBean> param) {
        super.validateOperator(param.getOperator());
        super.validateBeans(param.getBeans());
        if (CollectionUtils.isEmpty(param.getBeans())){
            return;
        }

        for(ORDR0801IBean bean : param.getBeans()){
            this.validateOrderId(bean.getOrderId(),true);
            this.validateBuyerId(bean.getBuyerId(),true);
            this.validateBuyerReturnSource(bean.getReturnSource(),true);
            this.validateReasonId(bean.getReturnReasonId(),true);
            this.validateBuyerApplyUserType(bean.getApplyUserType(),true);
            this.validateApplyUid(bean.getApplyUid(),false);
            this.validateApplyUname(bean.getApplyUname(),true);
            this.validateApplyTime(bean.getApplyTime(),true);
            this.validateApplyRemark(bean.getApplyRemark(),false);
            this.validateImage1(bean.getImage1(),false);
            this.validateImage2(bean.getImage2(),false);
            this.validateImage3(bean.getImage3(),false);
            this.validateImage4(bean.getImage4(),false);
            this.validateImage5(bean.getImage5(),false);
            super.validateProductList(bean.getDetails());
            if(!CollectionUtils.isEmpty(bean.getDetails())){
                for(ORDR0801IDetailBean detailBean : bean.getDetails()){
                    this.validateDistributionNotificationId(detailBean.getDistributionNotificationId(),true);
                    this.validateDistributionNotificationDetailId(detailBean.getDistributionNotificationDetailId(),true);
                    this.validateReceiveNotificationDetailId(detailBean.getReceiveNotificationDetailId(),true);
                    this.validateGoodsId(detailBean.getGoodsId(),true);
                    this.validateReturnQty(detailBean.getReturnQty(),true);
                    this.validateReasonId(detailBean.getDetailReasonId(),false);
                    this.validatorDecimal("returnPriceUnit", detailBean.getReturnPriceUnit(), false, 15, 4, NumberValidator.POSITIVE);
                }
            }

        }
    }
}
