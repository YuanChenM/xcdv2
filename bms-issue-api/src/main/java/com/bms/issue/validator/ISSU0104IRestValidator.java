package com.bms.issue.validator;

import com.bms.issue.bean.param.ISSU0104IBean;
import com.bms.issue.common.rest.BusinessRestParam;
import com.bms.issue.constant.i18n.FieldCode;
import com.bms.issue.constant.i18n.ValidatorCode;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.bean.ValidatorExceptionMessage;

/**
 * 问题订单修改接口Validator
 *
 * @author li_huiqian
 */
public class ISSU0104IRestValidator extends IssueValidator<BusinessRestParam<ISSU0104IBean>> {
    @Override
    public void validator(BusinessRestParam<ISSU0104IBean> param) {
        this.validateOperator(param.getOperator());
        this.validateBeans(param.getBeans());
        if (CollectionUtils.isEmpty(param.getBeans())) {
            return;
        }

        for (ISSU0104IBean bean : param.getBeans()) {
            this.validateIssueId(bean.getIssueId(), true);
            this.validateVersion(bean.getVer(), true);
            this.validateCloseTime(bean.getCloseTime(), false);
            this.validateInitiateTime(bean.getInitiateTime(), false);
            this.validateInitiatorType(bean.getInitiatorType(),false);
            this.validateInitiatorId(bean.getInitiatorId(),false);
            this.validateInitiatorName(bean.getInitiatorName(),false);
            this.validateIssueDesc(bean.getIssueDesc(),false);
            this.validateCloseUid(bean.getCloseUid(),false);
            this.validateCloseUname(bean.getCloseUname(),false);
            this.validateIssueResult(bean.getIssueResult(),false);
            this.validateIssueDecision(bean.getIssueDecision(),false);

            //全部都没有flg
            boolean notHave = false;
            //全部都有flg
            boolean allHave = false;
            if (StringUtils.isEmpty(bean.getInitiatorType())
                    && StringUtils.isEmpty(bean.getInitiatorName())) {
                notHave = true;
            }

            if (!StringUtils.isEmpty(bean.getInitiatorType())
                    && !StringUtils.isEmpty(bean.getInitiatorName())) {
                allHave = true;
            }

            //校验发起人信息要不全有 要不全没有
            if (!(notHave || allHave)) {
                getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_INITIATOR, null,
                        null, FieldCode.INITIATOR));
            }

            notHave = false;
            allHave = false;
            if (StringUtils.isEmpty(bean.getCloseUid())
                    && StringUtils.isEmpty(bean.getCloseUname())) {
                notHave = true;
            }

            if (!StringUtils.isEmpty(bean.getCloseUid())
                    && !StringUtils.isEmpty(bean.getCloseUname())) {
                allHave = true;
            }

            //校验结案人信息要不全有 要不全没有
            if (!(notHave || allHave)) {
                getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CLOSE, null,
                        null, FieldCode.CLOSE));
            }

        }
    }
}
