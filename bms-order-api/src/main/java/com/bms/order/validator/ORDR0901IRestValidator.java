package com.bms.order.validator;

import com.bms.order.bean.param.ORDR0901IBean;
import com.bms.order.bean.param.ORDR0901IDetailBean;
import com.bms.order.common.rest.BusinessRestParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;
import com.framework.validator.utils.NumberValidator;

/**
 * 买手退货单创建接口Validator
 *
 * @author li_huiqian
 */
public class ORDR0901IRestValidator extends OrderValidator<BusinessRestParam<ORDR0901IBean>> {
    @Override
    public void validator(BusinessRestParam<ORDR0901IBean> param) {
        super.validateOperator(param.getOperator());
        super.validateBeans(param.getBeans());
        if (CollectionUtils.isEmpty(param.getBeans())){
            return;
        }

        for(ORDR0901IBean bean : param.getBeans()){
            this.validateOrderId(bean.getOrderId(),true);
            this.validateBsId(bean.getBsId(),true);
            this.validateBsReturnSource(bean.getReturnSource(),true);
            this.validateReturnReasonId(bean.getReturnReasonId(),true);
            this.validateBsApplyUserType(bean.getApplyUserType(),true);
            this.validateApplyUid(bean.getApplyUid(),false);
            this.validateApplyUname(bean.getApplyUname(),true);
            this.validateApplyTime(bean.getApplyTime(),true);
            this.validateApplyRemark(bean.getApplyRemark(),false);
            if(!CollectionUtils.isEmpty(bean.getDetails())){
                for(ORDR0901IDetailBean detailBean : bean.getDetails()){
                    this.validateBsStockpileSplitDetailId(detailBean.getBsStockpileSplitDetailId(),true);
                    this.validateGoodsId(detailBean.getGoodsId(),true);
                    this.validateReturnQty(detailBean.getReturnQty(),true);
                    this.validateReasonId(detailBean.getDetailReasonId(),false);
                    this.validatorDecimal("returnPriceUnit", detailBean.getReturnPriceUnit(), false, 15, 4, NumberValidator.POSITIVE);
                }
            }
        }
    }
}
