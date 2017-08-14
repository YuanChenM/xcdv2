package com.bms.issue.validator;

import com.bms.issue.bean.param.ISSU0201IBean;
import com.bms.issue.bean.param.ISSU0206IBean;
import com.bms.issue.common.rest.BusinessRestParam;
import com.bms.issue.constant.i18n.FieldCode;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.utils.NumberValidator;

import java.util.List;

/**
 * 问题点新增接口Validator
 *
 * @author li_huiqian
 */
public class ISSU0206IRestValidator extends IssueValidator<BusinessRestParam<ISSU0206IBean>> {
    @Override
    public void validator(BusinessRestParam<ISSU0206IBean> param) {
        validateOperator(param.getOperator());
        validateBeans(param.getBeans());
        List<ISSU0206IBean> beans = param.getBeans();
        for (ISSU0206IBean bean : beans) {
            //问题ID 正整数
            this.validateQuestionId(bean.getQuestionId(), true);
            //问题点描述 非必填 最大长度356
            this.validateItemDesc(bean.getItemDesc(), false);
            //问题点执行方案 非必填 最大长度356
            this.validateItemSolution(bean.getItemSolution(), false);
            //问题点方案执行人 非必填 最大长度32
            this.validateItemExcutor(bean.getItemExcutor(), false);
            //问题点方案执行时间 非必填
            this.validateItemStartTime(bean.getItemStartTime(), false);
            //问题点处理完成时间 非必填
            this.validateItemEndTime(bean.getItemEndTime(), false);
            //问题点处理结果 非必填 最大长度256
            this.validateItemResult(bean.getItemResult(), false);
            //当事人意见 非必填 最大长度256
            this.validateItemFeedback(bean.getItemFeedBack(), false);
            //问题点结案人 非必填 最大长度256
            this.validateItemCloser(bean.getItemCloser(), false);
            //问题点结案时间 非必填
            this.validateCloseTime(bean.getItemCloseTime(), false);
            if (!CollectionUtils.isEmpty(bean.getAccessorys())) {
                for (ISSU0206IBean.ISSU0206Accessory accessory : bean.getAccessorys()) {
                    this.validateFileId(accessory.getFileId(), true);
                    this.validateFileName(accessory.getFileName(), true);
                    this.validateFileType(accessory.getFileType(), true);
                }
            }
        }
    }
}
