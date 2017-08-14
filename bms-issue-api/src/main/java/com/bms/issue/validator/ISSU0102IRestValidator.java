package com.bms.issue.validator;

import com.bms.issue.bean.param.ISSU0102IBean;
import com.bms.issue.common.rest.BusinessRestParam;
import com.framework.core.utils.CollectionUtils;

/**
 * 问题订单发起提交接口Validator
 * 
 * @author li_huiqian
 */
public class ISSU0102IRestValidator extends IssueValidator<BusinessRestParam<ISSU0102IBean>> {
    @Override
    public void validator(BusinessRestParam<ISSU0102IBean> param) {
        this.validateOperator(param.getOperator());
        this.validateBeans(param.getBeans());
        if (CollectionUtils.isEmpty(param.getBeans())){
            return;
        }
        for (ISSU0102IBean bean : param.getBeans()){
            this.validateIssueId(bean.getIssueId(),true);
            this.validateVersion(bean.getVer(),true);
        }
    }
}
