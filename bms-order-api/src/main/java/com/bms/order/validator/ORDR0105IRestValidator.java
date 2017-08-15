package com.bms.order.validator;

import com.bms.order.bean.param.ORDR0105IFilterParam;
import com.bms.order.common.rest.SearchRestParam;
import com.bms.order.common.rest.param.RestOperator;
import com.bms.order.constant.OrderConst;
import com.bms.order.constant.enumeration.*;
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
 * 买家订单查询接口Validator
 *
 * @author li_huiqian
 */
public class ORDR0105IRestValidator extends OrderCustomValidator<SearchRestParam<ORDR0105IFilterParam>> {
    @Override
    public void validator(SearchRestParam<ORDR0105IFilterParam> param) {
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

        // 验证filter
        ORDR0105IFilterParam filter = param.getFilter();
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
            validatorInteger(FieldCode.PAGING_LEVEL, pagingLevel, true, OrderConst.MAX_VALUE_ORDR0105I_PAGING_LEVEL,
                    OrderConst.MIN_VALUE_ORDR0105I_PAGING_LEVEL, NumberValidator.ALL);
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
    private void validatorFilter(ORDR0105IFilterParam filter) {
        // filter必填
        validatorRequired(FieldCode.FILTER, filter);
        if (filter == null)
            return;

        // 验证filter
        // 订单ID
        Long[] buyerOrderIds = filter.getBuyerOrderId();
        if (buyerOrderIds != null) {
            for (int i = 0; i < buyerOrderIds.length; i++) {
                validatorLong(FieldCode.BUYER_ORDER_ID, buyerOrderIds[i], true, OrderConst.MAX_VALUE_BIGINT_ID,
                        OrderConst.MIN_VALUE_BIGINT_ID, NumberValidator.POSITIVE);
            }
        }

        // 订单编码
        validatorMaxLength(FieldCode.BUYER_ORDER_CODE, filter.getBuyerOrderCode(), false,
                OrderConst.MAX_LENGTH_BUYER_ORDER_CODE);

        // 参考号
        validatorMaxLength(FieldCode.BACK_NO, filter.getBackNo(), false,
                OrderConst.MAX_LENGTH_BACK_NO);

        // 订单类型
        String[] orderTypes = filter.getOrderType();
        if (orderTypes != null) {
            for (int i = 0; i < orderTypes.length; i++) {
                BuyerOrderType orderType = BuyerOrderType.getInstance(orderTypes[i]);
                if (orderType == null) {
                    getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE,
                            null, null, FieldCode.ORDER_TYPE));
                }
            }
        }

        // 是否分批

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

        // 销售平台
        String[] salePlatformTypes = filter.getSalePlatformType();
        if (salePlatformTypes != null) {
            for (int i = 0; i < salePlatformTypes.length; i++) {
                SalePlatformType salePlatformType = SalePlatformType.getInstance(salePlatformTypes[i]);
                if (salePlatformType == null) {
                    getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE,
                            null, null, FieldCode.SALE_PLATFORM));
                }
            }
        }

        // 订单状态
        String[] buyerOrderStus = filter.getBuyerOrderStu();
        if (buyerOrderStus != null) {
            for (int i = 0; i < buyerOrderStus.length; i++) {
                BuyerOrderStu buyerOrderStu = BuyerOrderStu.getInstance(buyerOrderStus[i]);
                if (buyerOrderStu == null) {
                    getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE,
                            null, null, FieldCode.BUYER_ORDER_STU));
                }
            }
        }

        // 下单类型
        String[] orderPlaceTypes = filter.getOrderPlaceType();
        if (orderPlaceTypes != null) {
            for (int i = 0; i < orderPlaceTypes.length; i++) {
                OrderPlaceType orderPlaceType = OrderPlaceType.getInstance(orderPlaceTypes[i]);
                if (orderPlaceType == null) {
                    getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE,
                            null, null, FieldCode.ORDER_PLACE_TYPE));
                }
            }
        }

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

        // 下单员ID
        String[] orderPlacerIds = filter.getOrderPlacerId();
        if (orderPlacerIds != null) {
            for (int i = 0; i < orderPlacerIds.length; i++) {
                validatorMaxLength(FieldCode.ORDER_PLACER_ID, orderPlacerIds[i], true,
                        OrderConst.MAX_LENGTH_ORDER_PLACER_ID);
            }
        }

        // 下单员编码
        validatorMaxLength(FieldCode.ORDER_PLACER_CODE, filter.getOrderPlacerCode(), false,
                OrderConst.MAX_LENGTH_ORDER_PLACER_CODE);

        // 下单员名称
        validatorMaxLength(FieldCode.ORDER_PLACER_NAME, filter.getOrderPlacerName(), false,
                OrderConst.MAX_LENGTH_ORDER_PLACER_NAME);

        // 下单时间开始
        validatorDate(FieldCode.ORDER_PLACE_DATE_TIME_FROM, filter.getOrderPlaceDateTimeFrom(), false);

        // 下单时间结束
        validatorDate(FieldCode.ORDER_PLACE_DATE_TIME_TO, filter.getOrderPlaceDateTimeTo(), false);

        if (filter.getOrderPlaceDateTimeFrom() != null && filter.getOrderPlaceDateTimeTo() != null) {
            if (filter.getOrderPlaceDateTimeFrom().getTime() > filter.getOrderPlaceDateTimeTo().getTime()) {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E010505);
            }
        }

        // 付款类型
        String[] paymentTypes = filter.getPaymentType();
        if (paymentTypes != null) {
            for (int i = 0; i < paymentTypes.length; i++) {
                PaymentType paymentType = PaymentType.getInstance(paymentTypes[i]);
                if (paymentType == null) {
                    getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE,
                            null, null, FieldCode.PAYMENT_TYPE));
                }
            }
        }

        // 是否开发票

        // 是否使用账期

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

        // 分批订单ID
        Long[] batchOrderIds = filter.getBatchOrderId();
        if (batchOrderIds != null) {
            for (int i = 0; i < batchOrderIds.length; i++) {
                validatorLong(FieldCode.BUYER_BATCH_ORDER_ID, batchOrderIds[i], true, OrderConst.MAX_VALUE_BIGINT_ID,
                        OrderConst.MIN_VALUE_BIGINT_ID, NumberValidator.POSITIVE);
            }
        }

        // 分批订单编码
        validatorMaxLength(FieldCode.BUYER_BATCH_ORDER_CODE, filter.getBatchOrderCode(), false,
                OrderConst.MAX_LENGTH_BUYER_BATCH_ORDER_CODE);

        // 期望配送日开始
        validatorDate(FieldCode.REQUIRED_DISTRIBUTION_DATE_FROM, filter.getRequiredDistributionDateFrom(), false);

        // 期望配送日结束
        validatorDate(FieldCode.REQUIRED_DISTRIBUTION_DATE_TO, filter.getRequiredDistributionDateTo(), false);

        if (filter.getRequiredDistributionDateFrom() != null && filter.getRequiredDistributionDateTo() != null) {
            if (filter.getRequiredDistributionDateFrom().getTime() > filter.getRequiredDistributionDateTo().getTime()) {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E010506);
            }
        }

        // 分批订单状态
        String[] buyerBatchOrderStus = filter.getBuyerBatchOrderStu();
        if (buyerBatchOrderStus != null) {
            for (int i = 0; i < buyerBatchOrderStus.length; i++) {
                BuyerBatchOrderStu buyerBatchOrderStu = BuyerBatchOrderStu.getInstance(buyerBatchOrderStus[i]);
                if (buyerBatchOrderStu == null) {
                    getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE,
                            null, null, FieldCode.BUYER_BATCH_ORDER_STU));
                }
            }
        }

        // 分批订单明细ID
        Long[] buyerBatchOrderDetailIds = filter.getBuyerBatchOrderDetailId();
        if (buyerBatchOrderDetailIds != null) {
            for (int i = 0; i < buyerBatchOrderDetailIds.length; i++) {
                validatorLong(FieldCode.BUYER_BATCH_ORDER_DETAIL_ID, buyerBatchOrderDetailIds[i], true,
                        OrderConst.MAX_VALUE_BIGINT_ID, OrderConst.MIN_VALUE_BIGINT_ID, NumberValidator.POSITIVE);
            }
        }

        // 买家ID
        String[] buyerIds = filter.getBuyerId();
        if (buyerIds != null) {
            for (int i = 0; i < buyerIds.length; i++) {
                validatorMaxLength(FieldCode.BUYER_ID, buyerIds[i], true, OrderConst.MAX_LENGTH_BUYER_ID);
            }
        }

        // 买家类型
        String[] buyerTypes = filter.getBuyerType();
        if (buyerTypes != null) {
            for (int i = 0; i < buyerTypes.length; i++) {
                String buyerType=buyerTypes[i];
                validatorMaxLength(FieldCode.BUYER_TYPE, buyerType, false,
                        OrderConst.MAX_LENGTH_BUYER_TYPE_NAME);
            }
        };

        // 买家类型名称
        validatorMaxLength(FieldCode.BUYER_TYPE_NAME, filter.getBuyerTypeName(), false,
                OrderConst.MAX_LENGTH_BUYER_TYPE_NAME);

        // 买家编码
        validatorMaxLength(FieldCode.BUYER_CODE, filter.getBuyerCode(), false, OrderConst.MAX_LENGTH_BUYER_CODE);

        // 是否是账期买家

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

        // 专属买手ID
        String[] bsIds = filter.getBsId();
        if (bsIds != null) {
            for (int i = 0; i < bsIds.length; i++) {
                validatorStrLong(FieldCode.BS_ID, bsIds[i], true, OrderConst.MAX_VALUE_BIGINT_ID,
                        OrderConst.MIN_VALUE_BIGINT_ID, NumberValidator.POSITIVE);
            }
        }

        // 买手名称
        validatorMaxLength(FieldCode.BS_NAME, filter.getBsName(), false, OrderConst.MAX_LENGTH_BS_NAME);

        // 管家ID
        String[] saIds = filter.getSaId();
        if (saIds != null) {
            for (int i = 0; i < saIds.length; i++) {
                validatorStrLong(FieldCode.SA_ID, saIds[i], true, OrderConst.MAX_VALUE_BIGINT_ID,
                        OrderConst.MIN_VALUE_BIGINT_ID, NumberValidator.POSITIVE);
            }
        }

        // 管家名称
        validatorMaxLength(FieldCode.SA_NAME, filter.getSaName(), false, OrderConst.MAX_LENGTH_SA_NAME);

        // 管家编码
        validatorMaxLength(FieldCode.SA_CODE, filter.getSaCode(), false, OrderConst.MAX_LENGTH_SA_CODE);

        // 预配送类型
        if (filter.getForcastType() != null)
            if (ForcastType.getInstance(filter.getForcastType()) == null) {
                getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                        null, FieldCode.FORCAST_TYPE));
            }

        // 供货方主体
        String[] sellSideTypes = filter.getSellSideType();
        if (sellSideTypes != null) {
            for (int i = 0; i < sellSideTypes.length; i++) {
                SellSideType sellSideType = SellSideType.getInstance(sellSideTypes[i]);
                if (sellSideType == null) {
                    getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE,
                            null, null, FieldCode.SELL_SIDE_TYPE));
                }
            }
        }

        // 销售方ID
        String[] sellSideIds = filter.getSellSideId();
        if (sellSideIds != null) {
            for (int i = 0; i < sellSideIds.length; i++) {
                validatorMaxLength(FieldCode.SELL_SIDE_ID, sellSideIds[i], true, OrderConst.MAX_LENGTH_SELL_SIDE_ID);
            }
        }

        // 销售方编码
        validatorMaxLength(FieldCode.SELL_SIDE_CODE, filter.getSellSideCode(), false,
                OrderConst.MAX_LENGTH_SELL_SIDE_CODE);

        // 销售方名称
        validatorMaxLength(FieldCode.SELL_SIDE_NAME, filter.getSellSideName(), false,
                OrderConst.MAX_LENGTH_SELL_SIDE_NAME);

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

        // 区域配送站ID

        Long[] regionalDistributionStations = filter.getRegionalDistributionStation();
        if (regionalDistributionStations != null) {
            for (int i = 0; i < regionalDistributionStations.length; i++) {
                validatorLong(FieldCode.REGIONAL_DISTRIBUTION_STATION, regionalDistributionStations[i], true,
                        OrderConst.MAX_VALUE_BIGINT_ID, OrderConst.MIN_VALUE_BIGINT_ID, NumberValidator.POSITIVE);
            }
        }

        // 区域配送站编码
        validatorMaxLength(FieldCode.REGIONAL_DISTRIBUTION_STATION_CODE, filter.getRegionalDistributionStationCode(),
                false, OrderConst.MAX_LENGTH_REGIONAL_DISTRIBUTION_STATION_CODE);

        // 区域配送站名称
        validatorMaxLength(FieldCode.REGIONAL_DISTRIBUTION_STATION_NAME, filter.getRegionalDistributionStationName(),
                false, OrderConst.MAX_LENGTH_REGIONAL_DISTRIBUTION_STATION_NAME);

    }
}
