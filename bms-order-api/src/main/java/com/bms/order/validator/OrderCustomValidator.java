package com.bms.order.validator;

import com.bms.order.common.rest.param.RestOperator;
import com.bms.order.constant.ValidatorConst;
import com.bms.order.constant.enumeration.OperatorType;
import com.bms.order.constant.i18n.FieldCode;
import com.bms.order.constant.i18n.ValidatorCode;
import com.framework.base.bean.Pagination;
import com.framework.base.bean.Sort;
import com.framework.core.utils.StringUtils;
import com.framework.exception.bean.ValidatorExceptionMessage;
import com.framework.validator.DefaultCustomValidator;
import com.framework.validator.utils.NumberValidator;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/2/27.
 */
public abstract class OrderCustomValidator<T extends Serializable> extends DefaultCustomValidator<T> {

    /**
     * 验证操作权限信息
     *
     * @param operator
     */
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
     * 验证排序信息
     *
     * @param sorts
     */
    protected void validateSort(Sort[] sorts){
        if(null != sorts){
            for(Sort sort : sorts){
                if(null == sort.getDescFlag()){
                    getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_SORT,null,null,
                            FieldCode.SORT,"Sort"));
                }

                if(StringUtils.isEmpty(sort.getSortField())){
                    getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_SORT,null,null,
                            FieldCode.SORT,"Sort"));
                }
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
