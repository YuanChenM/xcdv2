package com.bms.issue.validator;

import com.bms.issue.common.rest.param.RestBean;
import com.bms.issue.common.rest.param.RestOperator;
import com.bms.issue.constant.ValidatorConst;
import com.bms.issue.constant.enumeration.OperatorType;
import com.bms.issue.constant.i18n.FieldCode;
import com.bms.issue.constant.i18n.ValidatorCode;
import com.framework.base.bean.Pagination;
import com.framework.exception.bean.ValidatorExceptionMessage;
import com.framework.validator.utils.NumberValidator;

import java.io.Serializable;
import java.util.List;

/**
 * 问题订单Validator
 *
 * @param <T>
 * @author li_huiqian
 */
public abstract class IssueValidator<T extends Serializable> extends IssueValidatorGenerated<T> {

    protected <B extends RestBean> void validateBeans(List<B> beans) {
        this.validatorRequired(FieldCode.BEANS, beans);
    }

    protected void validateOperator(RestOperator operator) {
        // 操作者ID，必须
        this.validatorRequired(FieldCode.OPERATOR, operator);

        if (null != operator) {
            // 验证操作者Id，必填，长度<=32
            this.validatorMaxLength(FieldCode.OPERATOR_ID, operator.getOperatorId(), true,
                    ValidatorConst.MAX_LENGTH_OPERATOR_ID);
            // 验证操作者类型，必填，操作者类型必须在OperatorType中
            this.validatorRequired(FieldCode.OPERATOR_TYPE, operator.getOperatorType());
            if (OperatorType.getInstance(operator.getOperatorType()) == null) {
                // {0}中没有Code为"{1}"的值
                getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                        null, FieldCode.OPERATOR_TYPE, "OperatorType", operator.getOperatorType()));
            }
        }
    }

    /**
     * 验证分页信息
     *
     * @param pagination
     * @param pagingLevel
     */
    protected void validatorPagination(Pagination pagination, Integer pagingLevel,Integer maxPagingLevel) {
        /* pagination与pagingLevel必须同时存在，如果不同时存在，则报错 */
        if (pagination == null && pagingLevel == null) {
            // 同时不存在的情况
        } else if (pagination != null && pagingLevel != null) {
            // 同时存在的情况
            // 页码，正数
            validatorInteger(FieldCode.START_POS, pagination.getStartPos(), true, ValidatorConst.MAX_VALUE_START_POS,
                    ValidatorConst.MIN_VALUE_START_POS, NumberValidator.POSITIVE);
            // 每页条数，正数
            validatorInteger(FieldCode.PAGE_SIZE, pagination.getPageSize(), true, ValidatorConst.MAX_VALUE_PAGE_SIZE,
                    ValidatorConst.MIN_VALUE_PAGE_SIZE, NumberValidator.POSITIVE);
            // 分页层级
            validatorInteger(FieldCode.PAGING_LEVEL, pagingLevel, true, maxPagingLevel,
                    ValidatorConst.MIN_VALUE_PAGING_LEVEL, NumberValidator.ALL);
        } else {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_PAGINATION,
                    null, null, FieldCode.PAGINATION));
        }
    }
}
