package com.bms.issue.validator;

import com.bms.issue.bean.param.ISSU0208IBean;
import com.bms.issue.common.rest.BusinessRestParam;
import com.bms.issue.common.rest.param.RestOperator;
import com.framework.core.utils.CollectionUtils;

import java.util.Collection;
import java.util.List;

/**
 * 问题处理/结案建议新增接口Validator
 *
 * @author li_huiqian
 */
public class ISSU0208IRestValidator extends IssueValidator<BusinessRestParam<ISSU0208IBean>> {
    @Override
    public void validator(BusinessRestParam<ISSU0208IBean> param) {
        RestOperator restOperator = param.getOperator();
        this.validateOperator(restOperator);
        List<ISSU0208IBean> list = param.getBeans();
        this.validateBeans(list);
        if (!CollectionUtils.isEmpty(list)) {
            for (ISSU0208IBean bean : list) {
                this.validateQuestionId(bean.getQuestionId(), true);
                this.validateHandlingType(bean.getHandlingType(), true);
                this.validateHandlingTime(bean.getHandlingTime(), false);
                this.validateHandlingContent(bean.getHandlingContent(), false);
                this.validateHandlingUid(bean.getHandlingUid(), false);
                this.validateHandlingUname(bean.getHandlingUname(), false);
                this.validateHandlingResult(bean.getHandlingResult(), false);
                this.validateHandlingResultReason(bean.getHandlingResultReason(), false);
            }
        }
    }
}
