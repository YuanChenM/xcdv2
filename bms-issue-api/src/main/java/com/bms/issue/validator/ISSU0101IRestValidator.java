package com.bms.issue.validator;

import com.bms.issue.bean.param.ISSU0101IBean;
import com.bms.issue.common.rest.BusinessRestParam;
import com.framework.core.utils.CollectionUtils;

/**
 * 问题订单创建接口Validator
 * 
 * @author li_huiqian
 */
public class ISSU0101IRestValidator extends IssueValidator<BusinessRestParam<ISSU0101IBean>> {
    @Override
    public void validator(BusinessRestParam<ISSU0101IBean> param) {
        super.validateOperator(param.getOperator());
        super.validateBeans(param.getBeans());
        if (CollectionUtils.isEmpty(param.getBeans())){
            return;
        }
        for (ISSU0101IBean bean : param.getBeans()){
            this.validateInitiatorType(bean.getInitiatorType(),true);
            this.validateOrderId(bean.getOrderId(),false);
            this.validateInitiatorName(bean.getInitiatorName(),true);
            this.validateInitiateTime(bean.getInitiateTime(),true);
            this.validateIssueStatus(bean.getIssueStatus(),true);
            this.validateInitiatorId(bean.getInitiatorId(),false);
            this.validateIssueDesc(bean.getIssueDesc(),false);
        }
    }
}
