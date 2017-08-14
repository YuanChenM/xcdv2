package com.bms.issue.validator;

import com.bms.issue.bean.param.ISSU0103IBean;
import com.bms.issue.common.rest.BusinessRestParam;
import com.framework.core.utils.CollectionUtils;

/**
 * 问题订单结案提交接口Validator
 * 
 * @author li_huiqian
 */
public class ISSU0103IRestValidator extends IssueValidator<BusinessRestParam<ISSU0103IBean>> {
    @Override
    public void validator(BusinessRestParam<ISSU0103IBean> param) {
        this.validateOperator(param.getOperator());
        this.validateBeans(param.getBeans());
        if (CollectionUtils.isEmpty(param.getBeans())){
            return;
        }

        for (ISSU0103IBean bean : param.getBeans()){
            this.validateIssueId(bean.getIssueId(),true);
            this.validateCloseUid(bean.getCloseUid(),false);
            this.validateCloseUname(bean.getCloseUname(),false);
            this.validateIssueResult(bean.getIssueResult(),false);
            this.validateIssueDecision(bean.getIssueDecision(),false);
            this.validateVersion(bean.getVer(),true);
            this.validateCloseTime(bean.getCloseTime(),false);
        }
    }
}
