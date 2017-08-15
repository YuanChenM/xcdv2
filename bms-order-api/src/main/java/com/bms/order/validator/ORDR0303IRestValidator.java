package com.bms.order.validator;

import com.bms.order.bean.param.ORDR0303IFilterParam;
import com.bms.order.common.rest.SearchRestParam;
import com.bms.order.common.rest.param.RestOperator;
import com.bms.order.constant.OrderConst;
import com.bms.order.constant.enumeration.DistributionNotificationStu;
import com.bms.order.constant.enumeration.OperatorType;
import com.bms.order.constant.i18n.FieldCode;
import com.bms.order.constant.i18n.ValidatorCode;
import com.framework.base.bean.Pagination;
import com.framework.base.bean.Sort;
import com.framework.exception.bean.ValidatorExceptionMessage;
import com.framework.validator.DefaultCustomValidator;
import com.framework.validator.utils.NumberValidator;

import java.util.Date;

/**
 * 配送通知单查询接口Validator
 *
 * @author li_huiqian
 */
public class ORDR0303IRestValidator extends OrderCustomValidator<SearchRestParam<ORDR0303IFilterParam>> {
    @Override
    public void validator(SearchRestParam<ORDR0303IFilterParam> param) {
        // 验证Operator
        RestOperator operator = param.getOperator();
        this.validateOperator(operator);

        // 验证pagination
        Pagination pagination = param.getPagination();
        Integer pagingLevel = param.getPagingLevel();
        validatorPagination(pagination, pagingLevel);

        // 验证sort
        Sort[] sorts = param.getSort();
        validatorSort(sorts);

        // 校验查询条件里的空字符串
        ORDR0303IFilterParam filter = param.getFilter();
        filterParam(filter);
    }

    /**
     * 验证分页信息
     *
     * @param pagination
     * @param pagingLevel
     */
    private void validatorPagination(Pagination pagination, Integer pagingLevel) {
        /* pagination与pagingLevel必须同时存在，如果不同时存在，则报错 */
        if (pagination == null && pagingLevel == null) {
            // 同时不存在的情况
        } else if (pagination != null && pagingLevel != null) {
            // 同时存在的情况
            // 页码，正数
            validatorInteger(FieldCode.START_POS, pagination.getStartPos(), true, OrderConst.MAX_VALUE_START_POS,
                    OrderConst.MIN_VALUE_START_POS, NumberValidator.POSITIVE);
            // 每页条数，正数
            validatorInteger(FieldCode.PAGE_SIZE, pagination.getPageSize(), true, OrderConst.MAX_VALUE_PAGE_SIZE,
                    OrderConst.MIN_VALUE_PAGE_SIZE, NumberValidator.POSITIVE);
            // 分页层级
            validatorInteger(FieldCode.PAGING_LEVEL, pagingLevel, true, OrderConst.MAX_VALUE_ORDR0303I_PAGING_LEVEL,
                    OrderConst.MIN_VALUE_ORDR0303I_PAGING_LEVEL, NumberValidator.ALL);
        } else {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_PAGINATION,
                    null, null, FieldCode.PAGINATION));
        }
    }

    /**
     * 验证排序信息
     *
     * @param sort
     */
    private void validatorSort(Sort[] sort) {

    }

    private void filterParam(ORDR0303IFilterParam filter) {
        // filter不能为空
        validatorRequired(FieldCode.FILTER, filter);
        if (filter == null)
            return;

        // 配送单id
        Long[] distributionNotificationId = filter.getDistributionNotificationId();
        if (distributionNotificationId != null && distributionNotificationId.length > 0) {
            for (int i = 0; i < distributionNotificationId.length; i++) {
                this.validatorLong(FieldCode.DISTRIBUTION_NOTIFICATION_ID, distributionNotificationId[i], true,
                        OrderConst.MAX_VALUE_BIGINT_ID, OrderConst.MIN_VALUE_BIGINT_ID, NumberValidator.POSITIVE);
            }
        }

        // 配送单号
        validatorMaxLength(FieldCode.DISTRIBUTION_NOTIFICATION_CODE, filter.getDistributionNotificationCode(), false,
                OrderConst.MAX_LENGTH_DISTRIBUTION_NOTIFICATION_CODE);

        // 买家订单id
        Long[] buyerOrderIds = filter.getBuyerOrderId();
        if (buyerOrderIds != null) {
            for (int i = 0; i < buyerOrderIds.length; i++) {
                validatorLong(FieldCode.BUYER_ORDER_ID, buyerOrderIds[i], true, OrderConst.MAX_VALUE_BIGINT_ID,
                        OrderConst.MIN_VALUE_BIGINT_ID, NumberValidator.POSITIVE);
            }
        }

        // 买家订单号
        validatorMaxLength(FieldCode.BUYER_ORDER_CODE, filter.getBuyerOrderCode(), false,
                OrderConst.MAX_LENGTH_BUYER_ORDER_CODE);

        // 买家id
        String[] buyerIds = filter.getBuyerId();
        if (buyerIds != null) {
            for (int i = 0; i < buyerIds.length; i++) {
                validatorMaxLength(FieldCode.BUYER_ID, buyerIds[i], true, OrderConst.MAX_LENGTH_BUYER_ID);
            }
        }

        // 买家编码
        validatorMaxLength(FieldCode.BUYER_CODE, filter.getBuyerCode(), false, OrderConst.MAX_LENGTH_BUYER_CODE);

        Date expectedSendDateTimeFrom = filter.getExpectedSendDateTimeFrom();// 预计发货时间
        validatorDate(FieldCode.EXPECTED_SEND_DATETIME_FROM, expectedSendDateTimeFrom, false);

        Date expectedSendDateTimeTo = filter.getExpectedSendDateTimeTo();

        validatorDate(FieldCode.EXPECTED_SEND_DATETIME_TO, expectedSendDateTimeTo, false);

        Date crtTimeFrom = filter.getCrtTimeFrom();// 配送单生成时间

        validatorDate(FieldCode.CRT_TIME_FROM, crtTimeFrom, false);

        Date crtTimeTo = filter.getCrtTimeTo();
        validatorDate(FieldCode.CRT_TIME_TO, crtTimeTo, false);

        // 配送通知单状态
        String[] distributionNotificationStus = filter.getDistributionNotificationStu();
        if (distributionNotificationStus != null) {
            for (int i = 0; i < distributionNotificationStus.length; i++) {
                DistributionNotificationStu distributionNotificationStu = DistributionNotificationStu
                        .getInstance(distributionNotificationStus[i]);
                if (distributionNotificationStu == null) {
                    getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE,
                            null, null, FieldCode.DISTRIBUTION_NOTIFICATION_STU));
                }
            }
        }

    }

}
