package com.bms.issue.validator;

import com.bms.issue.bean.param.ISSU0201IBean;
import com.bms.issue.common.rest.BusinessRestParam;
import com.framework.core.utils.CollectionUtils;

/**
 * 问题订单问题新增接口Validator
 * 
 * @author li_huiqian
 */
public class ISSU0201IRestValidator extends IssueValidator<BusinessRestParam<ISSU0201IBean>> {
    @Override
    public void validator(BusinessRestParam<ISSU0201IBean> param) {
        super.validateOperator(param.getOperator());
        super.validateBeans(param.getBeans());
        if (CollectionUtils.isEmpty(param.getBeans())){
            return;
        }
        for(ISSU0201IBean bean : param.getBeans()){
            this.validateIssueId(bean.getIssueId(),true);
            this.validateOrderDetailId(bean.getOrderDetailId(),false);
            this.validateQuestionCatagory1(bean.getQuestionCatagory1(),false);
            this.validateQuestionCatagory2(bean.getQuestionCatagory2(),false);
            this.validateQuestionCatagory3(bean.getQuestionCatagory3(),false);
            this.validateQuestionKeyword(bean.getQuestionKeyword(),false);
            this.validateQuestionDesc(bean.getQuestionDesc(),false);
            if(!CollectionUtils.isEmpty(bean.getAccessorys())){
                for(ISSU0201IBean.ISSU0201Accessory accessory : bean.getAccessorys()){
                    this.validateFileId(accessory.getFileId(),true);
                    this.validateFileName(accessory.getFileName(),true);
                    this.validateFileType(accessory.getFileType(),true);
                }
            }
        }
    }
}
