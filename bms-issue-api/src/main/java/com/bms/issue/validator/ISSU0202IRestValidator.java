package com.bms.issue.validator;

import com.bms.issue.bean.param.ISSU0202IBean;
import com.bms.issue.common.rest.BusinessRestParam;
import com.bms.issue.common.rest.param.RestOperator;
import com.framework.core.utils.CollectionUtils;

import java.util.List;

/**
 * 问题订单问题结案接口Validator
 * 
 * @author li_huiqian
 */
public class ISSU0202IRestValidator extends IssueValidator<BusinessRestParam<ISSU0202IBean>> {
    @Override
    public void validator(BusinessRestParam<ISSU0202IBean> param) {
        RestOperator operator= param.getOperator();
        this.validateOperator(operator);
       List<ISSU0202IBean>list= param.getBeans();
        this.validateBeans(list);
        if(CollectionUtils.isNotEmpty(list)){
            for (ISSU0202IBean bean:list){
                this.validateQuestionId(bean.getQuestionId(),true);
                this.validateIssueId(bean.getIssueId(),true);
                this.validateVersion(bean.getVersion(),true);
                this.validateCloseTime(bean.getQuestionCloseTime(),true);
                this.validateCloseUid(bean.getQuestionCloseUid(),true);
                this.validateCloseUname(bean.getQuestionCloseUname(),true);
            }
        }
    }
}
