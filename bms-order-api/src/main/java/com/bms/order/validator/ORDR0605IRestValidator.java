package com.bms.order.validator;

import com.bms.order.bean.param.ORDR0605IFilterParam;
import com.bms.order.common.rest.SearchRestParam;
import com.bms.order.common.rest.param.RestOperator;
import com.bms.order.constant.OrderConst;
import com.bms.order.constant.enumeration.BsOrderStu;
import com.bms.order.constant.enumeration.BsType;
import com.bms.order.constant.enumeration.OperatorType;
import com.bms.order.constant.enumeration.OrderPlacerType;
import com.bms.order.constant.enumeration.OrderSourceType;
import com.bms.order.constant.enumeration.OrderType;
import com.bms.order.constant.enumeration.PaymentStu;
import com.bms.order.constant.enumeration.SalePlatformType;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.FieldCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.constant.i18n.ValidatorCode;
import com.framework.base.bean.Pagination;
import com.framework.base.bean.Sort;
import com.framework.exception.BusinessException;
import com.framework.exception.bean.ValidatorExceptionMessage;
import com.framework.validator.DefaultCustomValidator;
import com.framework.validator.utils.NumberValidator;

/**
 * 买手订单查询接口Validator
 * 
 * @author li_huiqian
 */
public class ORDR0605IRestValidator extends OrderValidator<SearchRestParam<ORDR0605IFilterParam>> {
    @Override
    public void validator(SearchRestParam<ORDR0605IFilterParam> param) {
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
        ORDR0605IFilterParam filter = param.getFilter();
        validatorFilter(filter);
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
            validatorInteger(FieldCode.PAGING_LEVEL, pagingLevel, true, OrderConst.MAX_VALUE_ORDR0605I_PAGING_LEVEL,
                    OrderConst.MIN_VALUE_ORDR0605I_PAGING_LEVEL, NumberValidator.ALL);
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

    /**
     * 验证filter
     * 
     * @param filter
     */
    public void validatorFilter(ORDR0605IFilterParam filter) {
        // filter必须输入
        validatorRequired(FieldCode.FILTER, filter);
        if (filter == null)
            return;

        // 买手订单ID
        Long[] bsOrderIds = filter.getBsOrderId();
        if (bsOrderIds != null) {
            for (int i = 0; i < bsOrderIds.length; i++) {
                validatorLong(FieldCode.BS_ORDER_ID, bsOrderIds[i], true, OrderConst.MAX_VALUE_BIGINT_ID,
                        OrderConst.MIN_VALUE_BIGINT_ID, NumberValidator.POSITIVE);
            }
        }

        // 买手订单编码
        validatorMaxLength(FieldCode.BS_ORDER_CODE, filter.getBsOrderCode(), false,
                OrderConst.MAX_LENGTH_BS_ORDER_CODE);
        // 参考号
        validatorMaxLength(FieldCode.BACK_NO, filter.getBackNo(), false,
                OrderConst.MAX_LENGTH_BACK_NO);

        // 买手订单类型
        String[] orderTypes = filter.getOrderType();
        if (orderTypes != null) {
            for (int i = 0; i < orderTypes.length; i++) {
                OrderType orderType = OrderType.getInstance(orderTypes[i]);
                if (orderType == null) {
                    getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE,
                            null, null, FieldCode.ORDER_TYPE));
                }
            }
        }

        // 销售平台
        String[] salePlatformTypes = filter.getSalePlatformType();
        if (salePlatformTypes != null) {
            for (int i = 0; i < salePlatformTypes.length; i++) {
                SalePlatformType salePlatformType = SalePlatformType.getInstance(salePlatformTypes[i]);
                if (salePlatformType == null) {
                    getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE,
                            null, null, FieldCode.SALE_PLATFORM_TYPE));
                }
            }
        }

        // 订单来源
        String[] orderSourceTypes = filter.getOrderSourceType();
        if (orderSourceTypes != null) {
            for (int i = 0; i < orderSourceTypes.length; i++) {
                OrderSourceType orderSourceType = OrderSourceType.getInstance(orderSourceTypes[i]);
                if (orderSourceType == null) {
                    getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE,
                            null, null, FieldCode.ORDER_SOURCE_TYPE));
                }
            }
        }

        // 物流区ID
        Long[] logisticsZoneIds = filter.getLogisticsZoneId();
        if (logisticsZoneIds != null) {
            for (int i = 0; i < logisticsZoneIds.length; i++) {
                validatorLong(FieldCode.LOGISTICS_ZONE_ID, logisticsZoneIds[i], true, OrderConst.MAX_VALUE_BIGINT_ID,
                        OrderConst.MIN_VALUE_BIGINT_ID, NumberValidator.POSITIVE);
            }
        }

        // 物流区编码
        validatorMaxLength(FieldCode.LOGISTICS_ZONE_CODE, filter.getLogisticsZoneCode(), false,
                OrderConst.MAX_LENGTH_LOGISTICS_ZONE_CODE);

        // 物流区名称
        validatorMaxLength(FieldCode.LOGISTICS_ZONE_NAME, filter.getLogisticsZoneName(), false,
                OrderConst.MAX_LENGTH_LOGISTICS_ZONE_NAME);

        // 买手id
        String[] bsIds = filter.getBsId();
        if (bsIds != null) {
            for (int i = 0; i < bsIds.length; i++) {
                validatorMaxLength(FieldCode.BS_ID, bsIds[i], true, OrderConst.MAX_LENGTH_BS_ID);
            }
        }

        // 买手编码
        validatorMaxLength(FieldCode.BS_CODE, filter.getBsCode(), false, OrderConst.MAX_LENGTH_BS_CODE);

        // 买手名称
        validatorMaxLength(FieldCode.BS_NAME, filter.getBsName(), false, OrderConst.MAX_LENGTH_BS_NAME);

        // 买手类型
        String[] bsTypes = filter.getBsType();
        if (bsTypes != null) {
            for (int i = 0; i < bsTypes.length; i++) {
                BsType bsType = BsType.getInstance(bsTypes[i]);
                if (bsType == null) {
                    getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE,
                            null, null, FieldCode.BS_TYPE));
                }
            }
        }

        // 下单员ID
        Long[] orderPlacerIds = filter.getOrderPlacerId();
        if (orderPlacerIds != null) {
            for (int i = 0; i < orderPlacerIds.length; i++) {
                validatorLong(FieldCode.ORDER_PLACER_ID, orderPlacerIds[i], true, OrderConst.MAX_VALUE_BIGINT_ID,
                        OrderConst.MIN_VALUE_BIGINT_ID, NumberValidator.POSITIVE);
            }
        }

        // 下单员编码
        validatorMaxLength(FieldCode.ORDER_PLACER_CODE, filter.getOrderPlacerCode(), false,
                OrderConst.MAX_LENGTH_ORDER_PLACER_CODE);

        // 下单员名称
        validatorMaxLength(FieldCode.ORDER_PLACER_NAME, filter.getOrderPlacerName(), false,
                OrderConst.MAX_LENGTH_ORDER_PLACER_NAME);

        // 下单员类型
        String[] orderPlacerTypes = filter.getOrderPlacerType();
        if (orderPlacerTypes != null) {
            for (int i = 0; i < orderPlacerTypes.length; i++) {
                OrderPlacerType orderPlacerType = OrderPlacerType.getInstance(orderPlacerTypes[i]);
                if (orderPlacerType == null) {
                    getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE,
                            null, null, FieldCode.ORDER_PLACER_TYPE));
                }
            }
        }

        // 买手订单状态
        String[] bsOrderStatuss = filter.getBsOrderStatus();
        if (bsOrderStatuss != null) {
            for (int i = 0; i < bsOrderStatuss.length; i++) {
                BsOrderStu bsOrderStatus = BsOrderStu.getInstance(bsOrderStatuss[i]);
                if (bsOrderStatus == null) {
                    getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE,
                            null, null, FieldCode.BS_ORDER_STATUS));
                }
            }
        }

        // 支付状态
        String[] paymentStatuss = filter.getPaymentStatus();
        if (paymentStatuss != null) {
            for (int i = 0; i < paymentStatuss.length; i++) {
                PaymentStu paymentStatus = PaymentStu.getInstance(paymentStatuss[i]);
                if (paymentStatus == null) {
                    getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE,
                            null, null, FieldCode.PAYMENT_STATUS));
                }
            }
        }

        // 下单时间开始
        validatorDate(FieldCode.ORDER_PLACE_DATE_TIME_FROM, filter.getOrderPlaceDateTimeFrom(), false);

        // 下单时间结束
        validatorDate(FieldCode.ORDER_PLACE_DATE_TIME_TO, filter.getOrderPlaceDateTimeTo(), false);

        if (filter.getOrderPlaceDateTimeFrom() != null && filter.getOrderPlaceDateTimeTo() != null) {
            if (filter.getOrderPlaceDateTimeFrom().getTime() > filter.getOrderPlaceDateTimeTo().getTime()) {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060503);
            }
        }

        // 商品ID
        Long[] goodsIds = filter.getGoodsId();
        if (goodsIds != null) {
            for (int i = 0; i < goodsIds.length; i++) {
                validatorLong(FieldCode.GOODS_ID, goodsIds[i], true, OrderConst.MAX_VALUE_BIGINT_ID,
                        OrderConst.MIN_VALUE_BIGINT_ID, NumberValidator.POSITIVE);
            }
        }

        // 销售标签ID
        Long[] saleLabelIds = filter.getSaleLabelId();
        if (saleLabelIds != null) {
            for (int i = 0; i < saleLabelIds.length; i++) {
                validatorLong(FieldCode.SALE_LABEL_ID, saleLabelIds[i], true, OrderConst.MAX_VALUE_BIGINT_ID,
                        OrderConst.MIN_VALUE_BIGINT_ID, NumberValidator.POSITIVE);
            }
        }

        // 销售标签编码
        validatorMaxLength(FieldCode.SALE_LABEL_CODE, filter.getSaleLabelCode(), false,
                OrderConst.MAX_LENGTH_SALE_LABEL_CODE);

        // 销售标签名称
        validatorMaxLength(FieldCode.SALE_LABEL_NAME, filter.getSaleLabelName(), false,
                OrderConst.MAX_LENGTH_SALE_LABEL_NAME);

        // 商品SKU
        validatorMaxLength(FieldCode.SKU, filter.getSku(), false, OrderConst.MAX_LENGTH_SKU);

        // 生产商ID
        Long[] manufacturerIds = filter.getManufacturerId();
        if (manufacturerIds != null) {
            for (int i = 0; i < manufacturerIds.length; i++) {
                validatorLong(FieldCode.MANUFACTURER_ID, manufacturerIds[i], true, OrderConst.MAX_VALUE_BIGINT_ID,
                        OrderConst.MIN_VALUE_BIGINT_ID, NumberValidator.POSITIVE);
            }
        }

        // 生产商编码
        validatorMaxLength(FieldCode.MANUFACTURER_CODE, filter.getManufacturerCode(), false,
                OrderConst.MAX_LENGTH_MANUFACTURER_CODE);

        // 生产商名称
        validatorMaxLength(FieldCode.MANUFACTURER_NAME, filter.getManufacturerName(), false,
                OrderConst.MAX_LENGTH_MANUFACTURER_NAME);

        // 卖家ID
        Long[] sellerIds = filter.getSellerId();
        if (sellerIds != null) {
            for (int i = 0; i < sellerIds.length; i++) {
                validatorLong(FieldCode.SELLER_ID, sellerIds[i], true, OrderConst.MAX_VALUE_BIGINT_ID,
                        OrderConst.MIN_VALUE_BIGINT_ID, NumberValidator.POSITIVE);
            }
        }

        // 卖家编码
        validatorMaxLength(FieldCode.SELLER_CODE, filter.getSellerCode(), false, OrderConst.MAX_LENGTH_SELLER_CODE);

        // 卖家名称
        validatorMaxLength(FieldCode.SELLER_NAME, filter.getSellerName(), false, OrderConst.MAX_LENGTH_SELLER_NAME);

        // 销售方ID
        String[] sellSideIds = filter.getSellSideId();
        if (sellSideIds != null) {
            for (int i = 0; i < sellSideIds.length; i++) {
                this.validateSellSideId(sellSideIds[i], true);
            }
        }

        // 销售方编码
        validatorMaxLength(FieldCode.SELL_SIDE_CODE, filter.getSellSideCode(), false,
                OrderConst.MAX_LENGTH_SELL_SIDE_CODE);

        // 销售方名称
        validatorMaxLength(FieldCode.SELL_SIDE_NAME, filter.getSellSideName(), false,
                OrderConst.MAX_LENGTH_SELL_SIDE_NAME);

    }

}
