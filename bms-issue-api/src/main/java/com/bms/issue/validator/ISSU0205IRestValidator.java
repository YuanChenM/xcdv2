package com.bms.issue.validator;

import com.bms.issue.bean.param.ISSU0205IBean;
import com.bms.issue.common.rest.BusinessRestParam;
import com.bms.issue.common.rest.param.RestOperator;
import com.framework.core.utils.CollectionUtils;

import java.util.Collection;
import java.util.List;

/**
 * 问题附件删除接口Validator
 *
 * @author li_huiqian
 */
public class ISSU0205IRestValidator extends IssueValidator<BusinessRestParam<ISSU0205IBean>> {
    @Override
    public void validator(BusinessRestParam<ISSU0205IBean> param) {
        RestOperator restOperator = param.getOperator();
        this.validateOperator(restOperator);
        List<ISSU0205IBean> list = param.getBeans();
        this.validateBeans(list);
        if (CollectionUtils.isNotEmpty(list)) {
            for (ISSU0205IBean bean : list) {
                this.validateQuestionId(bean.getQuestionId(), true);
                this.validateAccessoryId(bean.getAccessoryId(), true);
                this.validateVersion(bean.getVersion(), true);
            }
        }
    }
}
