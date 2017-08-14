package com.bms.issue.validator;

import com.bms.issue.bean.param.ISSU0209IBean;
import com.bms.issue.common.rest.BusinessRestParam;
import com.framework.core.utils.CollectionUtils;

/**
 * 问题处理/结案建议编辑接口Validator
 * 
 * @author li_huiqian
 */
public class ISSU0209IRestValidator extends IssueValidator<BusinessRestParam<ISSU0209IBean>> {
    @Override
    public void validator(BusinessRestParam<ISSU0209IBean> param) {
        this.validateOperator(param.getOperator());
        this.validateBeans(param.getBeans());
        if (CollectionUtils.isEmpty(param.getBeans())){
            return;
        }

        for (ISSU0209IBean bean : param.getBeans()){
            this.validateHandlingId(bean.getHandlingId(),true);
            this.validateQuestionId(bean.getQuestionId(),true);
            this.validateHandlingType(bean.getHandlingType(),true);
            this.validateHandlingTime(bean.getHandlingTime(),false);
            this.validateVersion(bean.getVer(),true);
            this.validateHandlingContent(bean.getHandlingContent(),false);
            this.validateHandlingUid(bean.getHandlingUid(),false);
            this.validateHandlingUname(bean.getHandlingUname(),false);
            this.validateHandlingResult(bean.getHandlingResult(),false);
            this.validateHandlingResultReason(bean.getHandlingResultReason(),false);
        }
    }
}
