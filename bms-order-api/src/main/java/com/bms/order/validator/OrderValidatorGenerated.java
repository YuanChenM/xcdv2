package com.bms.order.validator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.bms.order.constant.ValidatorConst;
import com.bms.order.constant.enumeration.*;
import com.bms.order.constant.i18n.FieldCode;
import com.bms.order.constant.i18n.ValidatorCode;
import com.framework.exception.bean.ValidatorExceptionMessage;
import com.framework.validator.utils.NumberValidator;

public abstract class OrderValidatorGenerated<T extends Serializable> extends OrderCustomValidator<T> {

    /**
     * 验证订单：买家订单ID
     * 
     * @param buyerOrderId
     *            订单：买家订单ID
     */
    protected void validateBuyerOrderId(Long buyerOrderId, boolean required) {
        validatorLong(FieldCode.BUYER_ORDER_ID, buyerOrderId, required, null, null, NumberValidator.POSITIVE);
    }

    /**
     * 验证订单：买家订单编号
     * 
     * @param buyerOrderCode
     *            订单：买家订单编号
     */
    protected void validateBuyerOrderCode(String buyerOrderCode, boolean required) {
        this.validatorMaxLength(FieldCode.BUYER_ORDER_CODE, buyerOrderCode, required,
                ValidatorConst.MAX_LENGTH_BUYER_ORDER_CODE);
    }

    /**
     * 验证订单：参考号
     *
     * @param backNo
     *            订单：参考号
     */
    protected void validateBackNo(String backNo, boolean required) {
        this.validatorMaxLength(FieldCode.BACK_NO, backNo, required,
                ValidatorConst.MAX_LENGTH_BACK_NO);
    }

    /**
     * 验证订单：订单类型
     * 
     * @param orderType
     *            订单：订单类型
     */
    protected void validateOrderType(String orderType, boolean required) {
        OrderType type = OrderType.getInstance(orderType);
        if (required)
            validatorRequired(FieldCode.ORDER_TYPE, orderType);
        if (orderType != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.ORDER_TYPE, FieldCode.ORDER_TYPE, orderType));
        }
    }

    /**
     * 验证订单：销售平台
     * 
     * @param salePlatformType
     *            订单：销售平台
     */
    protected void validateSalePlatformType(String salePlatformType, boolean required) {
        SalePlatformType type = SalePlatformType.getInstance(salePlatformType);
        if (required)
            validatorRequired(FieldCode.SALE_PLATFORM_TYPE, salePlatformType);
        if (salePlatformType != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.SALE_PLATFORM_TYPE, FieldCode.SALE_PLATFORM_TYPE, salePlatformType));
        }
    }

    /**
     * 验证订单：订单来源
     * 
     * @param orderSourceType
     *            订单：订单来源
     */
    protected void validateOrderSourceType(String orderSourceType, boolean required) {
        OrderSourceType type = OrderSourceType.getInstance(orderSourceType);
        if (required)
            validatorRequired(FieldCode.ORDER_SOURCE_TYPE, orderSourceType);
        if (orderSourceType != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.ORDER_SOURCE_TYPE, FieldCode.ORDER_SOURCE_TYPE, orderSourceType));
        }
    }

    /**
     * 验证订单：是否分批
     * 
     * @param batchFlg
     *            订单：是否分批
     */
    protected void validateBatchFlg(Boolean batchFlg, boolean required) {
        if (required)
            validatorRequired(FieldCode.BATCH_FLG, batchFlg);
    }

    /**
     * 验证订单：分拆规则
     * 
     * @param orderSplitType
     *            订单：分拆规则
     */
    protected void validateOrderSplitType(String orderSplitType, boolean required) {
        OrderSplitType type = OrderSplitType.getInstance(orderSplitType);
        if (required)
            validatorRequired(FieldCode.ORDER_SPLIT_TYPE, orderSplitType);
        if (orderSplitType != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.ORDER_SPLIT_TYPE, FieldCode.ORDER_SPLIT_TYPE, orderSplitType));
        }
    }

    /**
     * 验证下单：下单员ID
     * 
     * @param orderPlacerId
     *            下单：下单员ID
     */
    protected void validateOrderPlacerId(String orderPlacerId, boolean required) {
        this.validatorMaxLength(FieldCode.ORDER_PLACER_ID, orderPlacerId, required,
                ValidatorConst.MAX_LENGTH_ORDER_PLACER_ID);
    }

    /**
     * 验证下单：下单员类型
     * 
     * @param orderPlacerType
     *            下单：下单员类型
     */
    protected void validateOrderPlacerType(String orderPlacerType, boolean required) {
        OrderPlacerType type = OrderPlacerType.getInstance(orderPlacerType);
        if (required)
            validatorRequired(FieldCode.ORDER_PLACER_TYPE, orderPlacerType);
        if (orderPlacerType != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.ORDER_PLACER_TYPE, FieldCode.ORDER_PLACER_TYPE, orderPlacerType));
        }
    }

    /**
     * 验证下单：下单时间
     * 
     * @param orderPlaceDatetime
     *            下单：下单时间
     */
    protected void validateOrderPlaceDatetime(Date orderPlaceDatetime, boolean required) {
        validatorDate(FieldCode.ORDER_PLACE_DATETIME, orderPlaceDatetime, required);
    }

    /**
     * 验证下单：下单时间
     * 
     * @param orderPlaceDatetime
     *            下单：下单时间
     */
    protected void validateOrderPlaceDatetime(String orderPlaceDatetime, boolean required) {
        validatorStrDate(FieldCode.ORDER_PLACE_DATETIME, orderPlaceDatetime, required,
                ValidatorConst.FORMAT_ORDER_PLACE_DATETIME);
    }

    /**
     * 验证下单：下单类型
     * 
     * @param orderPlaceType
     *            下单：下单类型
     */
    protected void validateOrderPlaceType(String orderPlaceType, boolean required) {
        OrderPlaceType type = OrderPlaceType.getInstance(orderPlaceType);
        if (required)
            validatorRequired(FieldCode.ORDER_PLACE_TYPE, orderPlaceType);
        if (orderPlaceType != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.ORDER_PLACE_TYPE, FieldCode.ORDER_PLACE_TYPE, orderPlaceType));
        }
    }

    /**
     * 验证区域：物流区ID
     * 
     * @param logisticsZoneId
     *            区域：物流区ID
     */
    protected void validateLogisticsZoneId(Long logisticsZoneId, boolean required) {
        validatorLong(FieldCode.LOGISTICS_ZONE_ID, logisticsZoneId, required, null, null, NumberValidator.POSITIVE);
    }

    /**
     * 验证买家：买家类型编码
     * 
     * @param buyerType
     *            买家：买家类型编码
     */
    protected void validateBuyerType(String buyerType, boolean required) {
        this.validatorMaxLength(FieldCode.BUYER_TYPE, buyerType, required, ValidatorConst.MAX_LENGTH_BUYER_TYPE);
    }

    /**
     * 验证买家：买家类型名称
     * 
     * @param buyerTypeName
     *            买家：买家类型名称
     */
    protected void validateBuyerTypeName(String buyerTypeName, boolean required) {
        this.validatorMaxLength(FieldCode.BUYER_TYPE_NAME, buyerTypeName, required,
                ValidatorConst.MAX_LENGTH_BUYER_TYPE_NAME);
    }

    /**
     * 验证买家：专属买手类型
     * 
     * @param bsType
     *            买家：专属买手类型
     */
    protected void validateBsType(String bsType, boolean required) {
        BsType type = BsType.getInstance(bsType);
        if (required)
            validatorRequired(FieldCode.BS_TYPE, bsType);
        if (bsType != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.BS_TYPE, FieldCode.BS_TYPE, bsType));
        }
    }

    /**
     * /** 验证买家：常客买家等级编码
     * 
     * @param frequenterLevelCode
     *            买家：常客买家等级编码
     */
    protected void validateFrequenterLevelCode(String frequenterLevelCode, boolean required) {
        this.validatorMaxLength(FieldCode.FREQUENTER_LEVEL_CODE, frequenterLevelCode, required,
                ValidatorConst.MAX_LENGTH_FREQUENTER_LEVEL_CODE);
    }

    /**
     * 验证支付：是否开具发票
     * 
     * @param invoiceFlg
     *            支付：是否开具发票
     */
    protected void validateInvoiceFlg(Boolean invoiceFlg, boolean required) {
        if (required)
            validatorRequired(FieldCode.INVOICE_FLG, invoiceFlg);
    }

    /**
     * 验证支付：是否是账期买家
     * 
     * @param netBuyerFlg
     *            支付：是否是账期买家
     */
    protected void validateNetBuyerFlg(Boolean netBuyerFlg, boolean required) {
        if (required)
            validatorRequired(FieldCode.NET_BUYER_FLG, netBuyerFlg);
    }

    /**
     * 验证支付：是否使用账期
     * 
     * @param useNetFlg
     *            支付：是否使用账期
     */
    protected void validateUseNetFlg(Boolean useNetFlg, boolean required) {
        if (required)
            validatorRequired(FieldCode.USE_NET_FLG, useNetFlg);
    }

    /**
     * 验证支付：付款类型
     * 
     * @param paymentType
     *            支付：付款类型
     */
    protected void validatePaymentType(String paymentType, boolean required) {
        PaymentType type = PaymentType.getInstance(paymentType);
        if (required)
            validatorRequired(FieldCode.PAYMENT_TYPE, paymentType);
        if (paymentType != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.PAYMENT_TYPE, FieldCode.PAYMENT_TYPE, paymentType));
        }
    }

    /**
     * 验证支付：支付状态
     * 
     * @param paymentStu
     *            支付：支付状态
     */
    protected void validatePaymentStu(String paymentStu, boolean required) {
        PaymentStu type = PaymentStu.getInstance(paymentStu);
        if (required)
            validatorRequired(FieldCode.PAYMENT_STU, paymentStu);
        if (paymentStu != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.PAYMENT_STU, FieldCode.PAYMENT_STU, paymentStu));
        }
    }

    /**
     * 验证支付：订单金额
     * 
     * @param orderAmount
     *            支付：订单金额
     */
    protected void validateOrderAmount(BigDecimal orderAmount, boolean required) {
        validatorDecimal(FieldCode.ORDER_AMOUNT, orderAmount, required, ValidatorConst.MAX_M_ORDER_AMOUNT,
                ValidatorConst.MAX_D_ORDER_AMOUNT, NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证支付：运费金额
     * 
     * @param freight
     *            支付：运费金额
     */
    protected void validateFreight(BigDecimal freight, boolean required) {
        validatorDecimal(FieldCode.FREIGHT, freight, required, ValidatorConst.MAX_M_FREIGHT,
                ValidatorConst.MAX_D_FREIGHT, NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证支付：优惠金额
     * 
     * @param preferentialAmount
     *            支付：优惠金额
     */
    protected void validatePreferentialAmount(BigDecimal preferentialAmount, boolean required) {
        validatorDecimal(FieldCode.PREFERENTIAL_AMOUNT, preferentialAmount, required,
                ValidatorConst.MAX_M_PREFERENTIAL_AMOUNT, ValidatorConst.MAX_D_PREFERENTIAL_AMOUNT,
                NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证支付：已收金额
     * 
     * @param receiveAmount
     *            支付：已收金额
     */
    protected void validateReceiveAmount(BigDecimal receiveAmount, boolean required) {
        validatorDecimal(FieldCode.RECEIVE_AMOUNT, receiveAmount, required, ValidatorConst.MAX_M_RECEIVE_AMOUNT,
                ValidatorConst.MAX_D_RECEIVE_AMOUNT, NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证支付：定金应付比例
     * 
     * @param earnestPercent
     *            支付：定金应付比例
     */
    protected void validateEarnestPercent(BigDecimal earnestPercent, boolean required) {
        validatorDecimal(FieldCode.EARNEST_PERCENT, earnestPercent, required, ValidatorConst.MAX_M_EARNEST_PERCENT,
                ValidatorConst.MAX_D_EARNEST_PERCENT, NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证支付：定金应付金额
     * 
     * @param earnestAmount
     *            支付：定金应付金额
     */
    protected void validateEarnestAmount(BigDecimal earnestAmount, boolean required) {
        validatorDecimal(FieldCode.EARNEST_AMOUNT, earnestAmount, required, ValidatorConst.MAX_M_EARNEST_AMOUNT,
                ValidatorConst.MAX_D_EARNEST_AMOUNT, NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证支付：应预付比例
     * 
     * @param advancePaymentPercent
     *            支付：应预付比例
     */
    protected void validateAdvancePaymentPercent(BigDecimal advancePaymentPercent, boolean required) {
        validatorDecimal(FieldCode.ADVANCE_PAYMENT_PERCENT, advancePaymentPercent, required,
                ValidatorConst.MAX_M_ADVANCE_PAYMENT_PERCENT, ValidatorConst.MAX_D_ADVANCE_PAYMENT_PERCENT,
                NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证支付：应预付金额
     * 
     * @param advancePaymentAmount
     *            支付：应预付金额
     */
    protected void validateAdvancePaymentAmount(BigDecimal advancePaymentAmount, boolean required) {
        validatorDecimal(FieldCode.ADVANCE_PAYMENT_AMOUNT, advancePaymentAmount, required,
                ValidatorConst.MAX_M_ADVANCE_PAYMENT_AMOUNT, ValidatorConst.MAX_D_ADVANCE_PAYMENT_AMOUNT,
                NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证状态：买家订单状态
     * 
     * @param buyerOrderStu
     *            状态：买家订单状态
     */
    protected void validateBuyerOrderStu(String buyerOrderStu, boolean required) {
        BuyerOrderStu type = BuyerOrderStu.getInstance(buyerOrderStu);
        if (required)
            validatorRequired(FieldCode.BUYER_ORDER_STU, buyerOrderStu);
        if (buyerOrderStu != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.BUYER_ORDER_STU, FieldCode.BUYER_ORDER_STU, buyerOrderStu));
        }
    }

    /**
     * 验证邮件：是否发送
     * 
     * @param mailedFlg
     *            邮件：是否发送
     */
    protected void validateMailedFlg(Boolean mailedFlg, boolean required) {
        if (required)
            validatorRequired(FieldCode.MAILED_FLG, mailedFlg);
    }

    /**
     * 验证明细：买家分批订单明细ID
     * 
     * @param buyerBatchOrderDetailId
     *            明细：买家分批订单明细ID
     */
    protected void validateBuyerBatchOrderDetailId(Long buyerBatchOrderDetailId, boolean required) {
        validatorLong(FieldCode.BUYER_BATCH_ORDER_DETAIL_ID, buyerBatchOrderDetailId, required, null, null,
                NumberValidator.POSITIVE);
    }

    /**
     * 验证明细：买家分批订单ID
     * 
     * @param buyerBatchOrderId
     *            明细：买家分批订单ID
     */
    protected void validateBuyerBatchOrderId(Long buyerBatchOrderId, boolean required) {
        validatorLong(FieldCode.BUYER_BATCH_ORDER_ID, buyerBatchOrderId, required, null, null,
                NumberValidator.POSITIVE);
    }

    /**
     * 验证明细：商品单位
     * 
     * @param goodsUnit
     *            明细：商品单位
     */
    protected void validateGoodsUnit(String goodsUnit, boolean required) {
        GoodsUnit type = GoodsUnit.getInstance(goodsUnit);
        if (required)
            validatorRequired(FieldCode.GOODS_UNIT, goodsUnit);
        if (goodsUnit != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.GOODS_UNIT, FieldCode.GOODS_UNIT, goodsUnit));
        }
    }

    /**
     * 验证明细：商品数量
     * 
     * @param goodsQuantity
     *            明细：商品数量
     */
    protected void validateGoodsQuantity(BigDecimal goodsQuantity, boolean required) {
        validatorDecimal(FieldCode.GOODS_QUANTITY, goodsQuantity, required, ValidatorConst.MAX_M_GOODS_QUANTITY,
                ValidatorConst.MAX_D_GOODS_QUANTITY, NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证明细：取消数量
     * 
     * @param cancelQuantity
     *            明细：取消数量
     */
    protected void validateCancelQuantity(BigDecimal cancelQuantity, boolean required) {
        validatorDecimal(FieldCode.CANCEL_QUANTITY, cancelQuantity, required, ValidatorConst.MAX_M_CANCEL_QUANTITY,
                ValidatorConst.MAX_D_CANCEL_QUANTITY, NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证价盘：下单时单位价格
     * 
     * @param orderCreateUnitPrice
     *            价盘：下单时单位价格
     */
    protected void validateOrderCreateUnitPrice(BigDecimal orderCreateUnitPrice, boolean required) {
        validatorDecimal(FieldCode.ORDER_CREATE_UNIT_PRICE, orderCreateUnitPrice, required,
                ValidatorConst.MAX_M_ORDER_CREATE_UNIT_PRICE, ValidatorConst.MAX_D_ORDER_CREATE_UNIT_PRICE,
                NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证价盘：下单时千克价格
     * 
     * @param orderCreateKgPrice
     *            价盘：下单时千克价格
     */
    protected void validateOrderCreateKgPrice(BigDecimal orderCreateKgPrice, boolean required) {
        validatorDecimal(FieldCode.ORDER_CREATE_KG_PRICE, orderCreateKgPrice, required,
                ValidatorConst.MAX_M_ORDER_CREATE_KG_PRICE, ValidatorConst.MAX_D_ORDER_CREATE_KG_PRICE,
                NumberValidator.NOT_NEGATIVE);
    }



    /**
     * 收货价格
     *
     * @param receivePrice
     *
     */
    protected void validateReceivePrice(BigDecimal receivePrice, boolean required) {
        validatorDecimal(FieldCode.RECEIVE_PRICE, receivePrice, required,
                ValidatorConst.MAX_M_ORDER_CREATE_KG_PRICE, ValidatorConst.MAX_D_ORDER_CREATE_KG_PRICE,
                NumberValidator.NOT_NEGATIVE);
    }
    /**
     * 验证价盘：实际单价
     * 
     * @param realUnitPrice
     *            价盘：实际单价
     */
    protected void validateRealUnitPrice(BigDecimal realUnitPrice, boolean required) {
        validatorDecimal(FieldCode.REAL_UNIT_PRICE, realUnitPrice, required, ValidatorConst.MAX_M_REAL_UNIT_PRICE,
                ValidatorConst.MAX_D_REAL_UNIT_PRICE, NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证价盘：实际千克价格
     * 
     * @param realKgPrice
     *            价盘：实际千克价格
     */
    protected void validateRealKgPrice(BigDecimal realKgPrice, boolean required) {
        validatorDecimal(FieldCode.REAL_KG_PRICE, realKgPrice, required, ValidatorConst.MAX_M_REAL_KG_PRICE,
                ValidatorConst.MAX_D_REAL_KG_PRICE, NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证价盘：首次价盘获取时间
     * 
     * @param priceCreateTime
     *            价盘：首次价盘获取时间
     */
    protected void validatePriceCreateTime(Date priceCreateTime, boolean required) {
        validatorDate(FieldCode.PRICE_CREATE_TIME, priceCreateTime, required);
    }

    /**
     * 验证价盘：首次价盘获取时间
     * 
     * @param priceCreateTime
     *            价盘：首次价盘获取时间
     */
    protected void validatePriceCreateTime(String priceCreateTime, boolean required) {
        validatorStrDate(FieldCode.PRICE_CREATE_TIME, priceCreateTime, required,
                ValidatorConst.FORMAT_PRICE_CREATE_TIME);
    }

    /**
     * 验证价盘：价格通道
     * 
     * @param priceWay
     *            价盘：价格通道
     */
    protected void validatePriceWay(String priceWay, boolean required) {
        this.validatorMaxLength(FieldCode.PRICE_WAY, priceWay, required, ValidatorConst.MAX_LENGTH_PRICE_WAY);
    }

    /**
     * 验证商品：产品ID
     * 
     * @param productId
     *            商品：产品ID
     */
    protected void validateProductId(String productId, boolean required) {
        this.validatorMaxLength(FieldCode.PRODUCT_ID, productId, required, ValidatorConst.MAX_LENGTH_PRODUCT_ID);
    }

    /**
     * 验证商品：生产商ID
     * 
     * @param manufacturerId
     *            商品：生产商ID
     */
    protected void validateManufacturerId(Long manufacturerId, boolean required) {
        validatorLong(FieldCode.MANUFACTURER_ID, manufacturerId, required, null, null, NumberValidator.POSITIVE);
    }

    /**
     * 验证商品：卖家ID
     * 
     * @param sellerId
     *            商品：卖家ID
     */
    protected void validateSellerId(String sellerId, boolean required) {
        this.validatorMaxLength(FieldCode.SELLER_ID, sellerId, required, ValidatorConst.MAX_LENGTH_SELLER_ID);
    }

    /**
     * 验证商品：批次ID
     * 
     * @param batchId
     *            商品：批次ID
     */
    protected void validateBatchId(Long batchId, boolean required) {
        validatorLong(FieldCode.BATCH_ID, batchId, required, null, null, NumberValidator.POSITIVE);
    }

    /**
     * 验证商品：销售标签ID
     * 
     * @param saleLabelId
     *            商品：销售标签ID
     */
    protected void validateSaleLabelId(Long saleLabelId, boolean required) {
        validatorLong(FieldCode.SALE_LABEL_ID, saleLabelId, required, null, null, NumberValidator.POSITIVE);
    }

    /**
     * 验证分批订单：是否分拆完成
     * 
     * @param splitFlg
     *            分批订单：是否分拆完成
     */
    protected void validateSplitFlg(Boolean splitFlg, boolean required) {
        if (required)
            validatorRequired(FieldCode.SPLIT_FLG, splitFlg);
    }

    /**
     * 验证分批订单：是否手动分拆
     * 
     * @param manualSplitFlg
     *            分批订单：是否手动分拆
     */
    protected void validateManualSplitFlg(Boolean manualSplitFlg, boolean required) {
        if (required)
            validatorRequired(FieldCode.MANUAL_SPLIT_FLG, manualSplitFlg);
    }

    /**
     * 验证库存：库存变更Sequence
     * 
     * @param transactionSequence
     *            库存：库存变更Sequence
     */
    protected void validateTransactionSequence(Integer transactionSequence, boolean required) {
        validatorInteger(FieldCode.TRANSACTION_SEQUENCE, transactionSequence, required,
                ValidatorConst.MAX_VALUE_TRANSACTION_SEQUENCE, ValidatorConst.MIN_VALUE_TRANSACTION_SEQUENCE,
                NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证分批订单：买家分批订单编号
     * 
     * @param buyerBatchOrderCode
     *            分批订单：买家分批订单编号
     */
    protected void validateBuyerBatchOrderCode(String buyerBatchOrderCode, boolean required) {
        this.validatorMaxLength(FieldCode.BUYER_BATCH_ORDER_CODE, buyerBatchOrderCode, required,
                ValidatorConst.MAX_LENGTH_BUYER_BATCH_ORDER_CODE);
    }

    /**
     * 验证分批订单：期望配送日
     * 
     * @param requiredDistributionDate
     *            分批订单：期望配送日
     */
    protected void validateRequiredDistributionDate(Date requiredDistributionDate, boolean required) {
        validatorDate(FieldCode.REQUIRED_DISTRIBUTION_DATE, requiredDistributionDate, required);
    }

    /**
     * 验证分批订单：期望配送日
     * 
     * @param requiredDistributionDate
     *            分批订单：期望配送日
     */
    protected void validateRequiredDistributionDate(String requiredDistributionDate, boolean required) {
        validatorStrDate(FieldCode.REQUIRED_DISTRIBUTION_DATE, requiredDistributionDate, required,
                ValidatorConst.FORMAT_REQUIRED_DISTRIBUTION_DATE);
    }

    /**
     * 验证收货要求：预计发货时间
     * 
     * @param expectedSendDatetime
     *            收货要求：预计发货时间
     */
    protected void validateExpectedSendDatetime(Date expectedSendDatetime, boolean required) {
        validatorDate(FieldCode.EXPECTED_SEND_DATETIME, expectedSendDatetime, required);
    }

    /**
     * 验证收货要求：预计发货时间
     * 
     * @param expectedSendDatetime
     *            收货要求：预计发货时间
     */
    protected void validateExpectedSendDatetime(String expectedSendDatetime, boolean required) {
        validatorStrDate(FieldCode.EXPECTED_SEND_DATETIME, expectedSendDatetime, required,
                ValidatorConst.FORMAT_EXPECTED_SEND_DATETIME);
    }

    /**
     * 验证收货要求：预计到货时间
     * 
     * @param expectedArrivalDatetime
     *            收货要求：预计到货时间
     */
    protected void validateExpectedArrivalDatetime(Date expectedArrivalDatetime, boolean required) {
        validatorDate(FieldCode.EXPECTED_ARRIVAL_DATETIME, expectedArrivalDatetime, required);
    }

    /**
     * 验证收货要求：预计到货时间
     * 
     * @param expectedArrivalDatetime
     *            收货要求：预计到货时间
     */
    protected void validateExpectedArrivalDatetime(String expectedArrivalDatetime, boolean required) {
        validatorStrDate(FieldCode.EXPECTED_ARRIVAL_DATETIME, expectedArrivalDatetime, required,
                ValidatorConst.FORMAT_EXPECTED_ARRIVAL_DATETIME);
    }

    /**
     * 验证状态：买家分批单状态
     * 
     * @param buyerBatchOrderStu
     *            状态：买家分批单状态
     */
    protected void validateBuyerBatchOrderStu(String buyerBatchOrderStu, boolean required) {
        BuyerBatchOrderStu type = BuyerBatchOrderStu.getInstance(buyerBatchOrderStu);
        if (required)
            validatorRequired(FieldCode.BUYER_BATCH_ORDER_STU, buyerBatchOrderStu);
        if (buyerBatchOrderStu != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.BUYER_BATCH_ORDER_STU, FieldCode.BUYER_BATCH_ORDER_STU, buyerBatchOrderStu));
        }
    }

    /**
     * 验证通知单：配送单号
     * 
     * @param distributionNotificationCode
     *            通知单：配送单号
     */
    protected void validateDistributionNotificationCode(String distributionNotificationCode, boolean required) {
        this.validatorMaxLength(FieldCode.DISTRIBUTION_NOTIFICATION_CODE, distributionNotificationCode, required,
                ValidatorConst.MAX_LENGTH_DISTRIBUTION_NOTIFICATION_CODE);
    }

    /**
     * 验证收货人：收货人名称
     * 
     * @param receiverName
     *            收货人：收货人名称
     */
    protected void validateReceiverName(String receiverName, boolean required) {
        this.validatorMaxLength(FieldCode.RECEIVER_NAME, receiverName, required,
                ValidatorConst.MAX_LENGTH_RECEIVER_NAME);
    }

    /**
     * 验证收货人：收货人电话
     * 
     * @param receiverPhone
     *            收货人：收货人电话
     */
    protected void validateReceiverPhone(String receiverPhone, boolean required) {
        this.validatorMaxLength(FieldCode.RECEIVER_PHONE, receiverPhone, required,
                ValidatorConst.MAX_LENGTH_RECEIVER_PHONE);
    }

    /**
     * 验证收货人：收货人QQ
     * 
     * @param receiverQq
     *            收货人：收货人QQ
     */
    protected void validateReceiverQq(String receiverQq, boolean required) {
        this.validatorMaxLength(FieldCode.RECEIVER_QQ, receiverQq, required, ValidatorConst.MAX_LENGTH_RECEIVER_QQ);
    }

    /**
     * 验证收货人：收货人微信
     * 
     * @param receiverWechat
     *            收货人：收货人微信
     */
    protected void validateReceiverWechat(String receiverWechat, boolean required) {
        this.validatorMaxLength(FieldCode.RECEIVER_WECHAT, receiverWechat, required,
                ValidatorConst.MAX_LENGTH_RECEIVER_WECHAT);
    }

    /**
     * 验证收货人：收货人邮箱
     * 
     * @param receiverMail
     *            收货人：收货人邮箱
     */
    protected void validateReceiverMail(String receiverMail, boolean required) {
        this.validatorMaxLength(FieldCode.RECEIVER_MAIL, receiverMail, required,
                ValidatorConst.MAX_LENGTH_RECEIVER_MAIL);
    }

    /**
     * 验证收货地址：收货地址省
     * 
     * @param receiverProvince
     *            收货地址：收货地址省
     */
    protected void validateReceiverProvince(String receiverProvince, boolean required) {
        this.validatorMaxLength(FieldCode.RECEIVER_PROVINCE, receiverProvince, required,
                ValidatorConst.MAX_LENGTH_RECEIVER_PROVINCE);
    }

    /**
     * 验证收货地址：收货地址市
     * 
     * @param receiverCity
     *            收货地址：收货地址市
     */
    protected void validateReceiverCity(String receiverCity, boolean required) {
        this.validatorMaxLength(FieldCode.RECEIVER_CITY, receiverCity, required,
                ValidatorConst.MAX_LENGTH_RECEIVER_CITY);
    }

    /**
     * 验证收货地址：收货地址区
     * 
     * @param receiverDistrict
     *            收货地址：收货地址区
     */
    protected void validateReceiverDistrict(String receiverDistrict, boolean required) {
        this.validatorMaxLength(FieldCode.RECEIVER_DISTRICT, receiverDistrict, required,
                ValidatorConst.MAX_LENGTH_RECEIVER_DISTRICT);
    }

    /**
     * 验证收货地址：收货地址详细地址
     * 
     * @param receiverAddress
     *            收货地址：收货地址详细地址
     */
    protected void validateReceiverAddress(String receiverAddress, boolean required) {
        this.validatorMaxLength(FieldCode.RECEIVER_ADDRESS, receiverAddress, required,
                ValidatorConst.MAX_LENGTH_RECEIVER_ADDRESS);
    }

    /**
     * 验证收货地址：辅助地址项目
     * 
     * @param receiverAssistAddress
     *            收货地址：辅助地址项目
     */
    protected void validateReceiverAssistAddress(String receiverAssistAddress, boolean required) {
        this.validatorMaxLength(FieldCode.RECEIVER_ASSIST_ADDRESS, receiverAssistAddress, required,
                ValidatorConst.MAX_LENGTH_RECEIVER_ASSIST_ADDRESS);
    }

    /**
     * 验证收货地址：订单配送区域
     * 
     * @param deliveryArea
     *            收货地址：订单配送区域
     */
    protected void validateDeliveryArea(String deliveryArea, boolean required) {
        this.validatorMaxLength(FieldCode.DELIVERY_AREA, deliveryArea, required,
                ValidatorConst.MAX_LENGTH_DELIVERY_AREA);
    }

    /**
     * 验证收货地址：准入通行车型
     * 
     * @param passTrafficModel
     *            收货地址：准入通行车型
     */
    protected void validatePassTrafficModel(String passTrafficModel, boolean required) {
        this.validatorMaxLength(FieldCode.PASS_TRAFFIC_MODEL, passTrafficModel, required,
                ValidatorConst.MAX_LENGTH_PASS_TRAFFIC_MODEL);
    }

    /**
     * 验证收货要求：配送方式
     * 
     * @param distributionType
     *            收货要求：配送方式
     */
    protected void validateDistributionType(String distributionType, boolean required) {
        DistributionType type = DistributionType.getInstance(distributionType);
        if (required)
            validatorRequired(FieldCode.DISTRIBUTION_TYPE, distributionType);
        if (distributionType != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.DISTRIBUTION_TYPE, FieldCode.DISTRIBUTION_TYPE, distributionType));
        }
    }

    /**
     * 验证收货要求：收货时间段
     * 
     * @param receivePeriod
     *            收货要求：收货时间段
     */
    protected void validateReceivePeriod(String receivePeriod, boolean required) {
        this.validatorMaxLength(FieldCode.RECEIVE_PERIOD, receivePeriod, required,
                ValidatorConst.MAX_LENGTH_RECEIVE_PERIOD);
    }

    /**
     * 验证收货要求：最早时间要求
     * 
     * @param receiveEarliest
     *            收货要求：最早时间要求
     */
    protected void validateReceiveEarliest(String receiveEarliest, boolean required) {
        this.validatorMaxLength(FieldCode.RECEIVE_EARLIEST, receiveEarliest, required,
                ValidatorConst.MAX_LENGTH_RECEIVE_EARLIEST);
    }

    /**
     * 验证收货要求：最晚时间要求
     * 
     * @param receiveLatest
     *            收货要求：最晚时间要求
     */
    protected void validateReceiveLatest(String receiveLatest, boolean required) {
        this.validatorMaxLength(FieldCode.RECEIVE_LATEST, receiveLatest, required,
                ValidatorConst.MAX_LENGTH_RECEIVE_LATEST);
    }

    /**
     * 验证收货要求：收货等待时间
     * 
     * @param receiveWaitHour
     *            收货要求：收货等待时间
     */
    protected void validateReceiveWaitHour(String receiveWaitHour, boolean required) {
        this.validatorMaxLength(FieldCode.RECEIVE_WAIT_HOUR, receiveWaitHour, required,
                ValidatorConst.MAX_LENGTH_RECEIVE_WAIT_HOUR);
    }

    /**
     * 验证收货要求：提前通知时间
     * 
     * @param advancedNotificationHour
     *            收货要求：提前通知时间
     */
    protected void validateAdvancedNotificationHour(String advancedNotificationHour, boolean required) {
        this.validatorMaxLength(FieldCode.ADVANCED_NOTIFICATION_HOUR, advancedNotificationHour, required,
                ValidatorConst.MAX_LENGTH_ADVANCED_NOTIFICATION_HOUR);
    }

    /**
     * 验证收货要求：动检证要求
     * 
     * @param animalQuarantineCertificationFlg
     *            收货要求：动检证要求
     */
    protected void validateAnimalQuarantineCertificationFlg(Boolean animalQuarantineCertificationFlg,
            boolean required) {
        if (required)
            validatorRequired(FieldCode.ANIMAL_QUARANTINE_CERTIFICATION_FLG, animalQuarantineCertificationFlg);
    }

    /**
     * 验证收货要求：装卸要求
     * 
     * @param stevedoreRequirement
     *            收货要求：装卸要求
     */
    protected void validateStevedoreRequirement(String stevedoreRequirement, boolean required) {
        this.validatorMaxLength(FieldCode.STEVEDORE_REQUIREMENT, stevedoreRequirement, required,
                ValidatorConst.MAX_LENGTH_STEVEDORE_REQUIREMENT);
    }

    /**
     * 验证收货要求：包装要求
     * 
     * @param packageRequirement
     *            收货要求：包装要求
     */
    protected void validatePackageRequirement(String packageRequirement, boolean required) {
        this.validatorMaxLength(FieldCode.PACKAGE_REQUIREMENT, packageRequirement, required,
                ValidatorConst.MAX_LENGTH_PACKAGE_REQUIREMENT);
    }

    /**
     * 验证收货要求：距离门店最近停车距离（米）
     * 
     * @param nearestParkingDistance
     *            收货要求：距离门店最近停车距离（米）
     */
    protected void validateNearestParkingDistance(Integer nearestParkingDistance, boolean required) {
        validatorInteger(FieldCode.NEAREST_PARKING_DISTANCE, nearestParkingDistance, required,
                ValidatorConst.MAX_VALUE_NEAREST_PARKING_DISTANCE, ValidatorConst.MIN_VALUE_NEAREST_PARKING_DISTANCE,
                NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证收货要求：备注
     * 
     * @param remark
     *            收货要求：备注
     */
    protected void validateRemark(String remark, boolean required) {
        this.validatorMaxLength(FieldCode.REMARK, remark, required, ValidatorConst.MAX_LENGTH_REMARK);
    }

    /**
     * 验证状态：配送通知单状态
     * 
     * @param distributionNotificationStu
     *            状态：配送通知单状态
     */
    protected void validateDistributionNotificationStu(String distributionNotificationStu, boolean required) {
        DistributionNotificationStu type = DistributionNotificationStu.getInstance(distributionNotificationStu);
        if (required)
            validatorRequired(FieldCode.DISTRIBUTION_NOTIFICATION_STU, distributionNotificationStu);
        if (distributionNotificationStu != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.DISTRIBUTION_NOTIFICATION_STU, FieldCode.DISTRIBUTION_NOTIFICATION_STU,
                    distributionNotificationStu));
        }
    }

    /**
     * 验证状态：通知单是否发送
     * 
     * @param sendFlg
     *            状态：通知单是否发送
     */
    protected void validateSendFlg(Boolean sendFlg, boolean required) {
        if (required)
            validatorRequired(FieldCode.SEND_FLG, sendFlg);
    }

    /**
     * 验证明细：买家订单预配送明细ID
     * 
     * @param buyerForcastDeliverDetailId
     *            明细：买家订单预配送明细ID
     */
    protected void validateBuyerForcastDeliverDetailId(Long buyerForcastDeliverDetailId, boolean required) {
        validatorLong(FieldCode.BUYER_FORCAST_DELIVER_DETAIL_ID, buyerForcastDeliverDetailId, required, null, null,
                NumberValidator.POSITIVE);
    }

    /**
     * 验证商品：商品SKU
     * 
     * @param sku
     *            商品：商品SKU
     */
    protected void validateSku(String sku, boolean required) {
        this.validatorMaxLength(FieldCode.SKU, sku, required, ValidatorConst.MAX_LENGTH_SKU);
    }

    /**
     * 验证商品：批次编码
     * 
     * @param batchCode
     *            商品：批次编码
     */
    protected void validateBatchCode(String batchCode, boolean required) {
        this.validatorMaxLength(FieldCode.BATCH_CODE, batchCode, required, ValidatorConst.MAX_LENGTH_BATCH_CODE);
    }

    /**
     * 验证商品：卖家编码
     * 
     * @param sellerCode
     *            商品：卖家编码
     */
    protected void validateSellerCode(String sellerCode, boolean required) {
        this.validatorMaxLength(FieldCode.SELLER_CODE, sellerCode, required, ValidatorConst.MAX_LENGTH_SELLER_CODE);
    }

    /**
     * 验证配送：配送数量
     * 
     * @param distributionQuantity
     *            配送：配送数量
     */
    protected void validateDistributionQuantity(BigDecimal distributionQuantity, boolean required) {
        validatorDecimal(FieldCode.DISTRIBUTION_QUANTITY, distributionQuantity, required,
                ValidatorConst.MAX_M_DISTRIBUTION_QUANTITY, ValidatorConst.MAX_D_DISTRIBUTION_QUANTITY,
                NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证销售方：销售方编码
     * 
     * @param sellSideCode
     *            销售方：销售方编码
     */
    protected void validateSellSideCode(String sellSideCode, boolean required) {
        this.validatorMaxLength(FieldCode.SELL_SIDE_CODE, sellSideCode, required,
                ValidatorConst.MAX_LENGTH_SELL_SIDE_CODE);
    }

    /**
     * 验证区域：物流区名称
     * 
     * @param logisticsZoneName
     *            区域：物流区名称
     */
    protected void validateLogisticsZoneName(String logisticsZoneName, boolean required) {
        this.validatorMaxLength(FieldCode.LOGISTICS_ZONE_NAME, logisticsZoneName, required,
                ValidatorConst.MAX_LENGTH_LOGISTICS_ZONE_NAME);
    }

    /**
     * 验证通知：发货通知单ID
     * 
     * @param sendNotificationId
     *            通知：发货通知单ID
     */
    protected void validateSendNotificationId(Long sendNotificationId, boolean required) {
        validatorLong(FieldCode.SEND_NOTIFICATION_ID, sendNotificationId, required, null, null,
                NumberValidator.POSITIVE);
    }

    /**
     * 验证通知：发货通知单号
     * 
     * @param sendNotificationCode
     *            通知：发货通知单号
     */
    protected void validateSendNotificationCode(String sendNotificationCode, boolean required) {
        this.validatorMaxLength(FieldCode.SEND_NOTIFICATION_CODE, sendNotificationCode, required,
                ValidatorConst.MAX_LENGTH_SEND_NOTIFICATION_CODE);
    }

    /**
     * 验证配送人：配送人姓名
     * 
     * @param distributionPersonName
     *            配送人：配送人姓名
     */
    protected void validateDistributionPersonName(String distributionPersonName, boolean required) {
        this.validatorMaxLength(FieldCode.DISTRIBUTION_PERSON_NAME, distributionPersonName, required,
                ValidatorConst.MAX_LENGTH_DISTRIBUTION_PERSON_NAME);
    }

    /**
     * 验证配送人：配送人电话
     * 
     * @param distributionPersonPhone
     *            配送人：配送人电话
     */
    protected void validateDistributionPersonPhone(String distributionPersonPhone, boolean required) {
        this.validatorMaxLength(FieldCode.DISTRIBUTION_PERSON_PHONE, distributionPersonPhone, required,
                ValidatorConst.MAX_LENGTH_DISTRIBUTION_PERSON_PHONE);
    }

    /**
     * 验证配送：配送车辆
     * 
     * @param distributionVehicle
     *            配送：配送车辆
     */
    protected void validateDistributionVehicle(String distributionVehicle, boolean required) {
        this.validatorMaxLength(FieldCode.DISTRIBUTION_VEHICLE, distributionVehicle, required,
                ValidatorConst.MAX_LENGTH_DISTRIBUTION_VEHICLE);
    }

    /**
     * 验证配送：实际发车时间
     * 
     * @param realDepartDatetime
     *            配送：实际发车时间
     */
    protected void validateRealDepartDatetime(Date realDepartDatetime, boolean required) {
        validatorDate(FieldCode.REAL_DEPART_DATETIME, realDepartDatetime, required);
    }

    /**
     * 验证配送：实际发车时间
     * 
     * @param realDepartDatetime
     *            配送：实际发车时间
     */
    protected void validateRealDepartDatetime(String realDepartDatetime, boolean required) {
        validatorStrDate(FieldCode.REAL_DEPART_DATETIME, realDepartDatetime, required,
                ValidatorConst.FORMAT_REAL_DEPART_DATETIME);
    }

    /**
     * 验证发货通知：备注
     * 
     * @param remarks
     *            发货通知：备注
     */
    protected void validateRemarks(String remarks, boolean required) {
        this.validatorMaxLength(FieldCode.REMARKS, remarks, required, ValidatorConst.MAX_LENGTH_REMARKS);
    }

    /**
     * 验证明细：预配送类型
     * 
     * @param forcastType
     *            明细：预配送类型
     */
    protected void validateForcastType(String forcastType, boolean required) {
        ForcastType type = ForcastType.getInstance(forcastType);
        if (required)
            validatorRequired(FieldCode.FORCAST_TYPE, forcastType);
        if (forcastType != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.FORCAST_TYPE, FieldCode.FORCAST_TYPE, forcastType));
        }
    }

    /**
     * 验证销售方：供货主体
     * 
     * @param sellSideType
     *            销售方：供货主体
     */
    protected void validateSellSideType(String sellSideType, boolean required) {
        SellSideType type = SellSideType.getInstance(sellSideType);
        if (required)
            validatorRequired(FieldCode.SELL_SIDE_TYPE, sellSideType);
        if (sellSideType != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.SELL_SIDE_TYPE, FieldCode.SELL_SIDE_TYPE, sellSideType));
        }
    }

    /**
     * 验证销售方：供货主体ID
     * 
     * @param sellSideId
     *            销售方：供货主体ID
     */
    protected void validateSellSideId(String sellSideId, boolean required) {
        this.validatorMaxLength(FieldCode.SELL_SIDE_ID, sellSideId, required, ValidatorConst.MAX_LENGTH_SELL_SIDE_ID);
    }

    /**
     * 验证配送：应该发货数量
     * 
     * @param planSendQuantity
     *            配送：应该发货数量
     */
    protected void validatePlanSendQuantity(BigDecimal planSendQuantity, boolean required) {
        validatorDecimal(FieldCode.PLAN_SEND_QUANTITY, planSendQuantity, required,
                ValidatorConst.MAX_M_PLAN_SEND_QUANTITY, ValidatorConst.MAX_D_PLAN_SEND_QUANTITY,
                NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证配送：实际发货数量
     * 
     * @param realSendQuantity
     *            配送：实际发货数量
     */
    protected void validateRealSendQuantity(BigDecimal realSendQuantity, boolean required) {
        validatorDecimal(FieldCode.REAL_SEND_QUANTITY, realSendQuantity, required,
                ValidatorConst.MAX_M_REAL_SEND_QUANTITY, ValidatorConst.MAX_D_REAL_SEND_QUANTITY,
                NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证配送：收货数量
     * 
     * @param receiveQuantity
     *            配送：收货数量
     */
    protected void validateReceiveQuantity(BigDecimal receiveQuantity, boolean required) {
        validatorDecimal(FieldCode.RECEIVE_QUANTITY, receiveQuantity, required, ValidatorConst.MAX_M_RECEIVE_QUANTITY,
                ValidatorConst.MAX_D_RECEIVE_QUANTITY, NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证配送：拒收退货数量
     * 
     * @param rejectQuantity
     *            配送：拒收退货数量
     */
    protected void validateRejectQuantity(BigDecimal rejectQuantity, boolean required) {
        validatorDecimal(FieldCode.REJECT_QUANTITY, rejectQuantity, required, ValidatorConst.MAX_M_REJECT_QUANTITY,
                ValidatorConst.MAX_D_REJECT_QUANTITY, NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证配送：迟收退货数量
     * 
     * @param delayQuantity
     *            配送：迟收退货数量
     */
    protected void validateDelayQuantity(BigDecimal delayQuantity, boolean required) {
        validatorDecimal(FieldCode.DELAY_QUANTITY, delayQuantity, required, ValidatorConst.MAX_M_DELAY_QUANTITY,
                ValidatorConst.MAX_D_DELAY_QUANTITY, NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证配送：再配送日
     * 
     * @param redistributionDate
     *            配送：再配送日
     */
    protected void validateRedistributionDate(Date redistributionDate, boolean required) {
        validatorDate(FieldCode.REDISTRIBUTION_DATE, redistributionDate, required);
    }

    /**
     * 验证配送：再配送日
     * 
     * @param redistributionDate
     *            配送：再配送日
     */
    protected void validateRedistributionDate(String redistributionDate, boolean required) {
        validatorStrDate(FieldCode.REDISTRIBUTION_DATE, redistributionDate, required,
                ValidatorConst.FORMAT_REDISTRIBUTION_DATE);
    }

    /**
     * 验证售后：退货数量
     * 
     * @param returnQuantity
     *            售后：退货数量
     */
    protected void validateReturnQuantity(BigDecimal returnQuantity, boolean required) {
        validatorDecimal(FieldCode.RETURN_QUANTITY, returnQuantity, required, ValidatorConst.MAX_M_RETURN_QUANTITY,
                ValidatorConst.MAX_D_RETURN_QUANTITY, NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证通知：配送取消通知单ID
     * 
     * @param distributionCancelNotificationId
     *            通知：配送取消通知单ID
     */
    protected void validateDistributionCancelNotificationId(Long distributionCancelNotificationId, boolean required) {
        validatorLong(FieldCode.DISTRIBUTION_CANCEL_NOTIFICATION_ID, distributionCancelNotificationId, required, null,
                null, NumberValidator.POSITIVE);
    }

    /**
     * 验证取消：取消类型
     * 
     * @param cancelType
     *            取消：取消类型
     */
    protected void validateCancelType(String cancelType, boolean required) {
        // 订单取消暂未实装
        // CancelType type = CancelType.getInstance(cancelType);
        // if (required)
        // validatorRequired(FieldCode.CANCEL_TYPE, cancelType);
        // if (cancelType != null && type == null) {
        // getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
        // null, FieldCode.CANCEL_TYPE, FieldCode.CANCEL_TYPE, cancelType));
        // }
    }

    /**
     * 验证取消：取消原因
     * 
     * @param cancelReason
     *            取消：取消原因
     */
    protected void validateCancelReason(String cancelReason, boolean required) {
        this.validatorMaxLength(FieldCode.CANCEL_REASON, cancelReason, required,
                ValidatorConst.MAX_LENGTH_CANCEL_REASON);
    }

    /**
     * 验证取消：取消人ID
     * 
     * @param cancelPersonId
     *            取消：取消人ID
     */
    protected void validateCancelPersonId(String cancelPersonId, boolean required) {
        this.validatorMaxLength(FieldCode.CANCEL_PERSON_ID, cancelPersonId, required,
                ValidatorConst.MAX_LENGTH_CANCEL_PERSON_ID);
    }

    /**
     * 验证取消：取消人名称
     * 
     * @param cancelPersonName
     *            取消：取消人名称
     */
    protected void validateCancelPersonName(String cancelPersonName, boolean required) {
        this.validatorMaxLength(FieldCode.CANCEL_PERSON_NAME, cancelPersonName, required,
                ValidatorConst.MAX_LENGTH_CANCEL_PERSON_NAME);
    }

    /**
     * 验证取消：取消人类型
     * 
     * @param cancelPersonType
     *            取消：取消人类型
     */
    protected void validateCancelPersonType(String cancelPersonType, boolean required) {
        // 订单取消暂未实装
        // CancelPersonType type = CancelPersonType.getInstance(cancelPersonType);
        // if (required)
        // validatorRequired(FieldCode.CANCEL_PERSON_TYPE, cancelPersonType);
        // if (cancelPersonType != null && type == null) {
        // getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
        // null, FieldCode.CANCEL_PERSON_TYPE, FieldCode.CANCEL_PERSON_TYPE, cancelPersonType));
        // }
    }

    /**
     * 验证取消：取消时间
     * 
     * @param cancelDatetime
     *            取消：取消时间
     */
    protected void validateCancelDatetime(Date cancelDatetime, boolean required) {
        validatorDate(FieldCode.CANCEL_DATETIME, cancelDatetime, required);
    }

    /**
     * 验证取消：取消时间
     * 
     * @param cancelDatetime
     *            取消：取消时间
     */
    protected void validateCancelDatetime(String cancelDatetime, boolean required) {
        validatorStrDate(FieldCode.CANCEL_DATETIME, cancelDatetime, required, ValidatorConst.FORMAT_CANCEL_DATETIME);
    }

    /**
     * 验证取消：实际取消时间
     * 
     * @param wmsCancelDatetime
     *            取消：实际取消时间
     */
    protected void validateWmsCancelDatetime(Date wmsCancelDatetime, boolean required) {
        validatorDate(FieldCode.WMS_CANCEL_DATETIME, wmsCancelDatetime, required);
    }

    /**
     * 验证取消：实际取消时间
     * 
     * @param wmsCancelDatetime
     *            取消：实际取消时间
     */
    protected void validateWmsCancelDatetime(String wmsCancelDatetime, boolean required) {
        validatorStrDate(FieldCode.WMS_CANCEL_DATETIME, wmsCancelDatetime, required,
                ValidatorConst.FORMAT_WMS_CANCEL_DATETIME);
    }

    /**
     * 验证结果：是否取消成功
     * 
     * @param successFlg
     *            结果：是否取消成功
     */
    protected void validateSuccessFlg(Boolean successFlg, boolean required) {
        if (required)
            validatorRequired(FieldCode.SUCCESS_FLG, successFlg);
    }

    /**
     * 验证通知：收货通知单ID
     * 
     * @param receiveNotificationId
     *            通知：收货通知单ID
     */
    protected void validateReceiveNotificationId(Long receiveNotificationId, boolean required) {
        validatorLong(FieldCode.RECEIVE_NOTIFICATION_ID, receiveNotificationId, required, null, null,
                NumberValidator.POSITIVE);
    }

    /**
     * 验证收货：签收人
     * 
     * @param signatory
     *            收货：签收人
     */
    protected void validateSignatory(String signatory, boolean required) {
        this.validatorMaxLength(FieldCode.SIGNATORY, signatory, required, ValidatorConst.MAX_LENGTH_SIGNATORY);
    }

    /**
     * 验证收货：签收时间
     * 
     * @param receiveTime
     *            收货：签收时间
     */
    protected void validateReceiveTime(Date receiveTime, boolean required) {
        validatorDate(FieldCode.RECEIVE_TIME, receiveTime, required);
    }

    /**
     * 验证收货：签收时间
     * 
     * @param receiveTime
     *            收货：签收时间
     */
    protected void validateReceiveTime(String receiveTime, boolean required) {
        validatorStrDate(FieldCode.RECEIVE_TIME, receiveTime, required, ValidatorConst.FORMAT_RECEIVE_TIME);
    }


    /**
     * 验证收货：签收时间
     *
     * @param actualReceiveDate
     *            收货：签收时间
     */
    protected void validateActualReceiveDate(String actualReceiveDate, boolean required) {
        validatorStrDate(FieldCode.ACTUAL_RECEIVE_DATE, actualReceiveDate, required, ValidatorConst.FORMAT_RECEIVE_TIME);
    }
    /**
     * 验证收货：签收备注
     * 
     * @param receiveRemark
     *            收货：签收备注
     */
    protected void validateReceiveRemark(String receiveRemark, boolean required) {
        this.validatorMaxLength(FieldCode.RECEIVE_REMARK, receiveRemark, required,
                ValidatorConst.MAX_LENGTH_RECEIVE_REMARK);
    }

    /**
     * 验证明细：发货通知单明细ID
     * 
     * @param sendNotificationDetailId
     *            明细：发货通知单明细ID
     */
    protected void validateSendNotificationDetailId(Long sendNotificationDetailId, boolean required) {
        validatorLong(FieldCode.SEND_NOTIFICATION_DETAIL_ID, sendNotificationDetailId, required, null, null,
                NumberValidator.POSITIVE);
    }

    /**
     * 验证商品：批次
     * 
     * @param batch
     *            商品：批次
     */
    protected void validateBatch(String batch, boolean required) {
        this.validatorMaxLength(FieldCode.BATCH, batch, required, ValidatorConst.MAX_LENGTH_BATCH);
    }

    /**
     * 验证收货明细：收货通知单明细ID
     * 
     * @param receiveNotificationDetailId
     *            收货明细：收货通知单明细ID
     */
    protected void validateReceiveNotificationDetailId(Long receiveNotificationDetailId, boolean required) {
        validatorLong(FieldCode.RECEIVE_NOTIFICATION_DETAIL_ID, receiveNotificationDetailId, required, null, null,
                NumberValidator.POSITIVE);
    }

    /**
     * 验证价盘：单价
     * 
     * @param pricePlateUnitPrice
     *            价盘：单价
     */
    protected void validatePricePlateUnitPrice(BigDecimal pricePlateUnitPrice, boolean required) {
        validatorDecimal(FieldCode.PRICE_PLATE_UNIT_PRICE, pricePlateUnitPrice, required,
                ValidatorConst.MAX_M_PRICE_PLATE_UNIT_PRICE, ValidatorConst.MAX_D_PRICE_PLATE_UNIT_PRICE,
                NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证取消：取消ID
     * 
     * @param cancelId
     *            取消：取消ID
     */
    protected void validateCancelId(Long cancelId, boolean required) {
        validatorLong(FieldCode.CANCEL_ID, cancelId, required, null, null, NumberValidator.POSITIVE);
    }

    /**
     * 验证取消：取消对象类型
     * 
     * @param cancelModelType
     *            取消：取消对象类型
     */
    protected void validateCancelModelType(String cancelModelType, boolean required) {
        // TODO 订单取消暂未实装
        // CancelModelType type = CancelModelType.getInstance(cancelModelType);
        // if (required)
        // validatorRequired(FieldCode.CANCEL_MODEL_TYPE, cancelModelType);
        // if (cancelModelType != null && type == null) {
        // getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
        // null, FieldCode.CANCEL_MODEL_TYPE, FieldCode.CANCEL_MODEL_TYPE, cancelModelType));
        // }
    }

    /**
     * 验证取消：取消对象ID
     * 
     * @param cancelModelId
     *            取消：取消对象ID
     */
    protected void validateCancelModelId(Long cancelModelId, boolean required) {
        validatorLong(FieldCode.CANCEL_MODEL_ID, cancelModelId, required, null, null, NumberValidator.POSITIVE);
    }

    /**
     * 验证取消：取消人编码
     * 
     * @param cancelPersonCode
     *            取消：取消人编码
     */
    protected void validateCancelPersonCode(String cancelPersonCode, boolean required) {
        this.validatorMaxLength(FieldCode.CANCEL_PERSON_CODE, cancelPersonCode, required,
                ValidatorConst.MAX_LENGTH_CANCEL_PERSON_CODE);
    }

    /**
     * 验证下单：下单员编码
     * 
     * @param orderPlacerCode
     *            下单：下单员编码
     */
    protected void validateOrderPlacerCode(String orderPlacerCode, boolean required) {
        this.validatorMaxLength(FieldCode.ORDER_PLACER_CODE, orderPlacerCode, required,
                ValidatorConst.MAX_LENGTH_ORDER_PLACER_CODE);
    }

    /**
     * 验证下单：下单员名称
     * 
     * @param orderPlacerName
     *            下单：下单员名称
     */
    protected void validateOrderPlacerName(String orderPlacerName, boolean required) {
        this.validatorMaxLength(FieldCode.ORDER_PLACER_NAME, orderPlacerName, required,
                ValidatorConst.MAX_LENGTH_ORDER_PLACER_NAME);
    }

    /**
     * 验证区域：物流区编码
     * 
     * @param logisticsZoneCode
     *            区域：物流区编码
     */
    protected void validateLogisticsZoneCode(String logisticsZoneCode, boolean required) {
        this.validatorMaxLength(FieldCode.LOGISTICS_ZONE_CODE, logisticsZoneCode, required,
                ValidatorConst.MAX_LENGTH_LOGISTICS_ZONE_CODE);
    }

    /**
     * 验证区域：城市ID
     * 
     * @param cityId
     *            区域：城市ID
     */
    protected void validateCityId(Long cityId, boolean required) {
        validatorLong(FieldCode.CITY_ID, cityId, required, null, null, NumberValidator.POSITIVE);
    }

    /**
     * 验证区域：城市编码
     * 
     * @param cityCode
     *            区域：城市编码
     */
    protected void validateCityCode(String cityCode, boolean required) {
        this.validatorMaxLength(FieldCode.CITY_CODE, cityCode, required, ValidatorConst.MAX_LENGTH_CITY_CODE);
    }

    /**
     * 验证区域：城市名称
     * 
     * @param cityName
     *            区域：城市名称
     */
    protected void validateCityName(String cityName, boolean required) {
        this.validatorMaxLength(FieldCode.CITY_NAME, cityName, required, ValidatorConst.MAX_LENGTH_CITY_NAME);
    }

    /**
     * 验证区域：区县ID
     * 
     * @param countryId
     *            区域：区县ID
     */
    protected void validateCountryId(Long countryId, boolean required) {
        validatorLong(FieldCode.COUNTRY_ID, countryId, required, null, null, NumberValidator.POSITIVE);
    }

    /**
     * 验证区域：区县编码
     * 
     * @param countryCode
     *            区域：区县编码
     */
    protected void validateCountryCode(String countryCode, boolean required) {
        this.validatorMaxLength(FieldCode.COUNTRY_CODE, countryCode, required, ValidatorConst.MAX_LENGTH_COUNTRY_CODE);
    }

    /**
     * 验证区域：区县名称
     * 
     * @param countryName
     *            区域：区县名称
     */
    protected void validateCountryName(String countryName, boolean required) {
        this.validatorMaxLength(FieldCode.COUNTRY_NAME, countryName, required, ValidatorConst.MAX_LENGTH_COUNTRY_NAME);
    }

    /**
     * 验证区域：区域配送站ID
     * 
     * @param regionalDistributionStation
     *            区域：区域配送站ID
     */
    protected void validateRegionalDistributionStation(Long regionalDistributionStation, boolean required) {
        validatorLong(FieldCode.REGIONAL_DISTRIBUTION_STATION, regionalDistributionStation, required,
                ValidatorConst.MAX_VALUE_REGIONAL_DISTRIBUTION_STATION,
                ValidatorConst.MIN_VALUE_REGIONAL_DISTRIBUTION_STATION, NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证区域：区域配送站编码
     * 
     * @param regionalDistributionStationCode
     *            区域：区域配送站编码
     */
    protected void validateRegionalDistributionStationCode(String regionalDistributionStationCode, boolean required) {
        this.validatorMaxLength(FieldCode.REGIONAL_DISTRIBUTION_STATION_CODE, regionalDistributionStationCode, required,
                ValidatorConst.MAX_LENGTH_REGIONAL_DISTRIBUTION_STATION_CODE);
    }

    /**
     * 验证区域：区域配送站名称
     * 
     * @param regionalDistributionStationName
     *            区域：区域配送站名称
     */
    protected void validateRegionalDistributionStationName(String regionalDistributionStationName, boolean required) {
        this.validatorMaxLength(FieldCode.REGIONAL_DISTRIBUTION_STATION_NAME, regionalDistributionStationName, required,
                ValidatorConst.MAX_LENGTH_REGIONAL_DISTRIBUTION_STATION_NAME);
    }

    /**
     * 验证买家：买家联系电话
     * 
     * @param buyerPhone
     *            买家：买家联系电话
     */
    protected void validateBuyerPhone(String buyerPhone, boolean required) {
        this.validatorMaxLength(FieldCode.BUYER_PHONE, buyerPhone, required, ValidatorConst.MAX_LENGTH_BUYER_PHONE);
    }

    /**
     * 验证买家：买家微信号
     * 
     * @param buyerWechat
     *            买家：买家微信号
     */
    protected void validateBuyerWechat(String buyerWechat, boolean required) {
        this.validatorMaxLength(FieldCode.BUYER_WECHAT, buyerWechat, required, ValidatorConst.MAX_LENGTH_BUYER_WECHAT);
    }

    /**
     * 验证买家：买家QQ
     * 
     * @param buyerQq
     *            买家：买家QQ
     */
    protected void validateBuyerQq(String buyerQq, boolean required) {
        this.validatorMaxLength(FieldCode.BUYER_QQ, buyerQq, required, ValidatorConst.MAX_LENGTH_BUYER_QQ);
    }

    /**
     * 验证买家：买家邮箱
     * 
     * @param buyerMail
     *            买家：买家邮箱
     */
    protected void validateBuyerMail(String buyerMail, boolean required) {
        this.validatorMaxLength(FieldCode.BUYER_MAIL, buyerMail, required, ValidatorConst.MAX_LENGTH_BUYER_MAIL);
    }

    /**
     * 验证买家：区域买手ID
     * 
     * @param regionalBsId
     *            买家：区域买手ID
     */
    protected void validateRegionalBsId(String regionalBsId, boolean required) {
        this.validatorMaxLength(FieldCode.REGIONAL_BS_ID, regionalBsId, required,
                ValidatorConst.MAX_LENGTH_REGIONAL_BS_ID);
    }

    /**
     * 验证买家：区域买手编码
     * 
     * @param regionalBsCode
     *            买家：区域买手编码
     */
    protected void validateRegionalBsCode(String regionalBsCode, boolean required) {
        this.validatorMaxLength(FieldCode.REGIONAL_BS_CODE, regionalBsCode, required,
                ValidatorConst.MAX_LENGTH_REGIONAL_BS_CODE);
    }

    /**
     * 验证买家：区域买手名称
     * 
     * @param regionalBsName
     *            买家：区域买手名称
     */
    protected void validateRegionalBsName(String regionalBsName, boolean required) {
        this.validatorMaxLength(FieldCode.REGIONAL_BS_NAME, regionalBsName, required,
                ValidatorConst.MAX_LENGTH_REGIONAL_BS_NAME);
    }

    /**
     * 验证买家：非区域买手ID
     * 
     * @param nonRegionalBsId
     *            买家：非区域买手ID
     */
    protected void validateNonRegionalBsId(String nonRegionalBsId, boolean required) {
        this.validatorMaxLength(FieldCode.NON_REGIONAL_BS_ID, nonRegionalBsId, required,
                ValidatorConst.MAX_LENGTH_NON_REGIONAL_BS_ID);
    }

    /**
     * 验证买家：非区域买手编码
     * 
     * @param nonRegionalBsCode
     *            买家：非区域买手编码
     */
    protected void validateNonRegionalBsCode(String nonRegionalBsCode, boolean required) {
        this.validatorMaxLength(FieldCode.NON_REGIONAL_BS_CODE, nonRegionalBsCode, required,
                ValidatorConst.MAX_LENGTH_NON_REGIONAL_BS_CODE);
    }

    /**
     * 验证买家：非区域买手名称
     * 
     * @param nonRegionalBsName
     *            买家：非区域买手名称
     */
    protected void validateNonRegionalBsName(String nonRegionalBsName, boolean required) {
        this.validatorMaxLength(FieldCode.NON_REGIONAL_BS_NAME, nonRegionalBsName, required,
                ValidatorConst.MAX_LENGTH_NON_REGIONAL_BS_NAME);
    }

    /**
     * 验证买家：区域分销买手ID
     * 
     * @param regionalDistributionBsId
     *            买家：区域分销买手ID
     */
    protected void validateRegionalDistributionBsId(String regionalDistributionBsId, boolean required) {
        this.validatorMaxLength(FieldCode.REGIONAL_DISTRIBUTION_BS_ID, regionalDistributionBsId, required,
                ValidatorConst.MAX_LENGTH_REGIONAL_DISTRIBUTION_BS_ID);
    }

    /**
     * 验证买家：区域分销买手编码
     * 
     * @param regionalDistributionBsCode
     *            买家：区域分销买手编码
     */
    protected void validateRegionalDistributionBsCode(String regionalDistributionBsCode, boolean required) {
        this.validatorMaxLength(FieldCode.REGIONAL_DISTRIBUTION_BS_CODE, regionalDistributionBsCode, required,
                ValidatorConst.MAX_LENGTH_REGIONAL_DISTRIBUTION_BS_CODE);
    }

    /**
     * 验证买家：区域分销买手名称
     * 
     * @param regionalDistributionBsName
     *            买家：区域分销买手名称
     */
    protected void validateRegionalDistributionBsName(String regionalDistributionBsName, boolean required) {
        this.validatorMaxLength(FieldCode.REGIONAL_DISTRIBUTION_BS_NAME, regionalDistributionBsName, required,
                ValidatorConst.MAX_LENGTH_REGIONAL_DISTRIBUTION_BS_NAME);
    }

    /**
     * 验证买家：账期用户买手ID
     * 
     * @param netUserBsId
     *            买家：账期用户买手ID
     */
    protected void validateNetUserBsId(String netUserBsId, boolean required) {
        this.validatorMaxLength(FieldCode.NET_USER_BS_ID, netUserBsId, required,
                ValidatorConst.MAX_LENGTH_NET_USER_BS_ID);
    }

    /**
     * 验证买家：账期用户买手编码
     * 
     * @param netUserBsCode
     *            买家：账期用户买手编码
     */
    protected void validateNetUserBsCode(String netUserBsCode, boolean required) {
        this.validatorMaxLength(FieldCode.NET_USER_BS_CODE, netUserBsCode, required,
                ValidatorConst.MAX_LENGTH_NET_USER_BS_CODE);
    }

    /**
     * 验证买家：账期用户买手名称
     * 
     * @param netUserBsName
     *            买家：账期用户买手名称
     */
    protected void validateNetUserBsName(String netUserBsName, boolean required) {
        this.validatorMaxLength(FieldCode.NET_USER_BS_NAME, netUserBsName, required,
                ValidatorConst.MAX_LENGTH_NET_USER_BS_NAME);
    }

    /**
     * 验证买家：冻品管家ID
     * 
     * @param saId
     *            买家：冻品管家ID
     */
    protected void validateSaId(String saId, boolean required) {
        this.validatorMaxLength(FieldCode.SA_ID, saId, required, ValidatorConst.MAX_LENGTH_SA_ID);
    }

    /**
     * 验证买家：冻品管家编码
     * 
     * @param saCode
     *            买家：冻品管家编码
     */
    protected void validateSaCode(String saCode, boolean required) {
        this.validatorMaxLength(FieldCode.SA_CODE, saCode, required, ValidatorConst.MAX_LENGTH_SA_CODE);
    }

    /**
     * 验证买家：冻品管家名称
     * 
     * @param saName
     *            买家：冻品管家名称
     */
    protected void validateSaName(String saName, boolean required) {
        this.validatorMaxLength(FieldCode.SA_NAME, saName, required, ValidatorConst.MAX_LENGTH_SA_NAME);
    }

    /**
     * 验证商品：单品编码
     * 
     * @param itemCode
     *            商品：单品编码
     */
    protected void validateItemCode(String itemCode, boolean required) {
        this.validatorMaxLength(FieldCode.ITEM_CODE, itemCode, required, ValidatorConst.MAX_LENGTH_ITEM_CODE);
    }

    /**
     * 验证商品：单品名称
     * 
     * @param itemName
     *            商品：单品名称
     */
    protected void validateItemName(String itemName, boolean required) {
        this.validatorMaxLength(FieldCode.ITEM_NAME, itemName, required, ValidatorConst.MAX_LENGTH_ITEM_NAME);
    }

    /**
     * 验证商品：品牌编码
     * 
     * @param brandCode
     *            商品：品牌编码
     */
    protected void validateBrandCode(String brandCode, boolean required) {
        this.validatorMaxLength(FieldCode.BRAND_CODE, brandCode, required, ValidatorConst.MAX_LENGTH_BRAND_CODE);
    }

    /**
     * 验证商品：品牌名称
     * 
     * @param brandName
     *            商品：品牌名称
     */
    protected void validateBrandName(String brandName, boolean required) {
        this.validatorMaxLength(FieldCode.BRAND_NAME, brandName, required, ValidatorConst.MAX_LENGTH_BRAND_NAME);
    }

    /**
     * 验证商品：单品品牌编码
     * 
     * @param itemBrandCode
     *            商品：单品品牌编码
     */
    protected void validateItemBrandCode(String itemBrandCode, boolean required) {
        this.validatorMaxLength(FieldCode.ITEM_BRAND_CODE, itemBrandCode, required,
                ValidatorConst.MAX_LENGTH_ITEM_BRAND_CODE);
    }

    /**
     * 验证商品：生产商编码
     * 
     * @param manufacturerCode
     *            商品：生产商编码
     */
    protected void validateManufacturerCode(String manufacturerCode, boolean required) {
        this.validatorMaxLength(FieldCode.MANUFACTURER_CODE, manufacturerCode, required,
                ValidatorConst.MAX_LENGTH_MANUFACTURER_CODE);
    }

    /**
     * 验证商品：生产商名称
     * 
     * @param manufacturerName
     *            商品：生产商名称
     */
    protected void validateManufacturerName(String manufacturerName, boolean required) {
        this.validatorMaxLength(FieldCode.MANUFACTURER_NAME, manufacturerName, required,
                ValidatorConst.MAX_LENGTH_MANUFACTURER_NAME);
    }

    /**
     * 验证商品：卖家名称
     * 
     * @param sellerName
     *            商品：卖家名称
     */
    protected void validateSellerName(String sellerName, boolean required) {
        this.validatorMaxLength(FieldCode.SELLER_NAME, sellerName, required, ValidatorConst.MAX_LENGTH_SELLER_NAME);
    }

    /**
     * 验证商品：销售标签编码
     * 
     * @param saleLabelCode
     *            商品：销售标签编码
     */
    protected void validateSaleLabelCode(String saleLabelCode, boolean required) {
        this.validatorMaxLength(FieldCode.SALE_LABEL_CODE, saleLabelCode, required,
                ValidatorConst.MAX_LENGTH_SALE_LABEL_CODE);
    }

    /**
     * 验证商品：销售标签名称
     * 
     * @param saleLabelName
     *            商品：销售标签名称
     */
    protected void validateSaleLabelName(String saleLabelName, boolean required) {
        this.validatorMaxLength(FieldCode.SALE_LABEL_NAME, saleLabelName, required,
                ValidatorConst.MAX_LENGTH_SALE_LABEL_NAME);
    }

    /**
     * 验证SKU：小包装特征
     * 
     * @param smallPackageFeature
     *            SKU：小包装特征
     */
    protected void validateSmallPackageFeature(String smallPackageFeature, boolean required) {
        this.validatorMaxLength(FieldCode.SMALL_PACKAGE_FEATURE, smallPackageFeature, required,
                ValidatorConst.MAX_LENGTH_SMALL_PACKAGE_FEATURE);
    }

    /**
     * 验证SKU：小包装件数/大包装个数
     * 
     * @param quantityPerPackage
     *            SKU：小包装件数/大包装个数
     */
    protected void validateQuantityPerPackage(Integer quantityPerPackage, boolean required) {
        validatorInteger(FieldCode.QUANTITY_PER_PACKAGE, quantityPerPackage, required,
                ValidatorConst.MAX_VALUE_QUANTITY_PER_PACKAGE, ValidatorConst.MIN_VALUE_QUANTITY_PER_PACKAGE,
                NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证SKU：净重（克）
     * 
     * @param netWeight
     *            SKU：净重（克）
     */
    protected void validateNetWeight(BigDecimal netWeight, boolean required) {
        validatorDecimal(FieldCode.NET_WEIGHT, netWeight, required, ValidatorConst.MAX_M_NET_WEIGHT,
                ValidatorConst.MAX_D_NET_WEIGHT, NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证SKU：毛重（克）
     * 
     * @param grossWeight
     *            SKU：毛重（克）
     */
    protected void validateGrossWeight(BigDecimal grossWeight, boolean required) {
        validatorDecimal(FieldCode.GROSS_WEIGHT, grossWeight, required, ValidatorConst.MAX_M_GROSS_WEIGHT,
                ValidatorConst.MAX_D_GROSS_WEIGHT, NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证SKU：纸箱尺寸
     * 
     * @param cartonSize
     *            SKU：纸箱尺寸
     */
    protected void validateCartonSize(String cartonSize, boolean required) {
        this.validatorMaxLength(FieldCode.CARTON_SIZE, cartonSize, required, ValidatorConst.MAX_LENGTH_CARTON_SIZE);
    }

    /**
     * 验证SKU：产品等级
     * 
     * @param productLevel
     *            SKU：产品等级
     */
    protected void validateProductLevel(String productLevel, boolean required) {
        this.validatorMaxLength(FieldCode.PRODUCT_LEVEL, productLevel, required,
                ValidatorConst.MAX_LENGTH_PRODUCT_LEVEL);
    }

    /**
     * 验证SKU：托盘标准堆码数（箱）
     * 
     * @param palletStandardStackQuantity
     *            SKU：托盘标准堆码数（箱）
     */
    protected void validatePalletStandardStackQuantity(Integer palletStandardStackQuantity, boolean required) {
        validatorInteger(FieldCode.PALLET_STANDARD_STACK_QUANTITY, palletStandardStackQuantity, required,
                ValidatorConst.MAX_VALUE_PALLET_STANDARD_STACK_QUANTITY,
                ValidatorConst.MIN_VALUE_PALLET_STANDARD_STACK_QUANTITY, NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证销售方：销售方名称
     * 
     * @param sellSideName
     *            销售方：销售方名称
     */
    protected void validateSellSideName(String sellSideName, boolean required) {
        this.validatorMaxLength(FieldCode.SELL_SIDE_NAME, sellSideName, required,
                ValidatorConst.MAX_LENGTH_SELL_SIDE_NAME);
    }

    /**
     * 验证通知单：价格通道通知单ID
     * 
     * @param priceChannelNotificationId
     *            通知单：价格通道通知单ID
     */
    protected void validatePriceChannelNotificationId(Long priceChannelNotificationId, boolean required) {
        validatorLong(FieldCode.PRICE_CHANNEL_NOTIFICATION_ID, priceChannelNotificationId, required, null, null,
                NumberValidator.POSITIVE);
    }

    /**
     * 验证通知单：价格通道通知单号
     * 
     * @param priceChannelNotificationCode
     *            通知单：价格通道通知单号
     */
    protected void validatePriceChannelNotificationCode(String priceChannelNotificationCode, boolean required) {
        this.validatorMaxLength(FieldCode.PRICE_CHANNEL_NOTIFICATION_CODE, priceChannelNotificationCode, required,
                ValidatorConst.MAX_LENGTH_PRICE_CHANNEL_NOTIFICATION_CODE);
    }

    /**
     * 验证明细：商品价盘通知单明细ID
     * 
     * @param priceChannelNotificationDetailId
     *            明细：商品价盘通知单明细ID
     */
    protected void validatePriceChannelNotificationDetailId(Long priceChannelNotificationDetailId, boolean required) {
        validatorLong(FieldCode.PRICE_CHANNEL_NOTIFICATION_DETAIL_ID, priceChannelNotificationDetailId, required, null,
                null, NumberValidator.POSITIVE);
    }

    /**
     * 验证价盘：通道分类ID
     * 
     * @param wayTypeId
     *            价盘：通道分类ID
     */
    protected void validateWayTypeId(Long wayTypeId, boolean required) {
        validatorLong(FieldCode.WAY_TYPE_ID, wayTypeId, required, null, null, NumberValidator.POSITIVE);
    }

    /**
     * 验证价盘：通道分类名称
     * 
     * @param wayTypeName
     *            价盘：通道分类名称
     */
    protected void validateWayTypeName(String wayTypeName, boolean required) {
        this.validatorMaxLength(FieldCode.WAY_TYPE_NAME, wayTypeName, required,
                ValidatorConst.MAX_LENGTH_WAY_TYPE_NAME);
    }

    /**
     * 验证价盘：通道配置ID
     * 
     * @param wayConfigId
     *            价盘：通道配置ID
     */
    protected void validateWayConfigId(Long wayConfigId, boolean required) {
        validatorLong(FieldCode.WAY_CONFIG_ID, wayConfigId, required, null, null, NumberValidator.POSITIVE);
    }

    /**
     * 验证价盘：通道描述
     * 
     * @param wayDesc
     *            价盘：通道描述
     */
    protected void validateWayDesc(String wayDesc, boolean required) {
        this.validatorMaxLength(FieldCode.WAY_DESC, wayDesc, required, ValidatorConst.MAX_LENGTH_WAY_DESC);
    }

    /**
     * 验证价盘：通道开始数量
     * 
     * @param priceChannelStartQuantity
     *            价盘：通道开始数量
     */
    protected void validatePriceChannelStartQuantity(BigDecimal priceChannelStartQuantity, boolean required) {
        validatorDecimal(FieldCode.PRICE_CHANNEL_START_QUANTITY, priceChannelStartQuantity, required,
                ValidatorConst.MAX_M_PRICE_CHANNEL_START_QUANTITY, ValidatorConst.MAX_D_PRICE_CHANNEL_START_QUANTITY,
                NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证价盘：通道结束数量
     * 
     * @param priceChannelEndQuantity
     *            价盘：通道结束数量
     */
    protected void validatePriceChannelEndQuantity(BigDecimal priceChannelEndQuantity, boolean required) {
        validatorDecimal(FieldCode.PRICE_CHANNEL_END_QUANTITY, priceChannelEndQuantity, required,
                ValidatorConst.MAX_M_PRICE_CHANNEL_END_QUANTITY, ValidatorConst.MAX_D_PRICE_CHANNEL_END_QUANTITY,
                NumberValidator.NOT_NEGATIVE);
    }


    /**
     * 收货数量
     *
     * @param receiveQty
     */
    protected void validateReceiveQty(BigDecimal receiveQty, boolean required) {
        validatorDecimal(FieldCode.RECEIVE_QTY, receiveQty, required,
                ValidatorConst.MAX_M_PRICE_CHANNEL_END_QUANTITY, ValidatorConst.MAX_D_PRICE_CHANNEL_END_QUANTITY,
                NumberValidator.NOT_NEGATIVE);
    }




    /**
     * 迟收数量
     *
     * @param delayQty
     */
    protected void validateDelayQty(BigDecimal delayQty, boolean required) {
        validatorDecimal(FieldCode.DELAY_QTY, delayQty, required,
                ValidatorConst.MAX_M_PRICE_CHANNEL_END_QUANTITY, ValidatorConst.MAX_D_PRICE_CHANNEL_END_QUANTITY,
                NumberValidator.NOT_NEGATIVE);
    }




    /**
     * 验证价盘：价格通道单价
     * 
     * @param priceChannelUnitPrice
     *            价盘：价格通道单价
     */
    protected void validatePriceChannelUnitPrice(BigDecimal priceChannelUnitPrice, boolean required) {
        validatorDecimal(FieldCode.PRICE_CHANNEL_UNIT_PRICE, priceChannelUnitPrice, required,
                ValidatorConst.MAX_M_PRICE_CHANNEL_UNIT_PRICE, ValidatorConst.MAX_D_PRICE_CHANNEL_UNIT_PRICE,
                NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证明细：买手订单明细ID
     * 
     * @param bsOrderDetailId
     *            明细：买手订单明细ID
     */
    protected void validateBsOrderDetailId(Long bsOrderDetailId, boolean required) {
        validatorLong(FieldCode.BS_ORDER_DETAIL_ID, bsOrderDetailId, required, null, null, NumberValidator.POSITIVE);
    }

    /**
     * 验证明细：买手订单ID
     * 
     * @param bsOrderId
     *            明细：买手订单ID
     */
    protected void validateBsOrderId(Long bsOrderId, boolean required) {
        validatorLong(FieldCode.BS_ORDER_ID, bsOrderId, required, null, null, NumberValidator.POSITIVE);
    }

    /**
     * 验证订单：买手订单编号
     * 
     * @param bsOrderCode
     *            订单：买手订单编号
     */
    protected void validateBsOrderCode(String bsOrderCode, boolean required) {
        this.validatorMaxLength(FieldCode.BS_ORDER_CODE, bsOrderCode, required,
                ValidatorConst.MAX_LENGTH_BS_ORDER_CODE);
    }

    /**
     * 验证状态：买手订单状态
     * 
     * @param bsOrderStu
     *            状态：买手订单状态
     */
    protected void validateBsOrderStu(String bsOrderStu, boolean required) {
        BsOrderStu type = BsOrderStu.getInstance(bsOrderStu);
        if (required)
            validatorRequired(FieldCode.BS_ORDER_STU, bsOrderStu);
        if (bsOrderStu != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.BS_ORDER_STU, FieldCode.BS_ORDER_STU, bsOrderStu));
        }
    }

    /**
     * 验证订单：囤货完成时间
     * 
     * @param completeTime
     *            订单：囤货完成时间
     */
    protected void validateCompleteTime(Date completeTime, boolean required) {
        validatorDate(FieldCode.COMPLETE_TIME, completeTime, required);
    }

    /**
     * 验证订单：囤货完成时间
     * 
     * @param completeTime
     *            订单：囤货完成时间
     */
    protected void validateCompleteTime(String completeTime, boolean required) {
        validatorStrDate(FieldCode.COMPLETE_TIME, completeTime, required, ValidatorConst.FORMAT_COMPLETE_TIME);
    }

    /**
     * 验证销售明细：囤货销售明细ID
     * 
     * @param stockpileSaleDetailId
     *            销售明细：囤货销售明细ID
     */
    protected void validateStockpileSaleDetailId(Long stockpileSaleDetailId, boolean required) {
        validatorLong(FieldCode.STOCKPILE_SALE_DETAIL_ID, stockpileSaleDetailId, required, null, null,
                NumberValidator.POSITIVE);
    }

    /**
     * 验证销售：销售数量
     * 
     * @param saleQuantity
     *            销售：销售数量
     */
    protected void validateSaleQuantity(BigDecimal saleQuantity, boolean required) {
        validatorDecimal(FieldCode.SALE_QUANTITY, saleQuantity, required, ValidatorConst.MAX_M_SALE_QUANTITY,
                ValidatorConst.MAX_D_SALE_QUANTITY, NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证支付：支付ID
     * 
     * @param paymentId
     *            支付：支付ID
     */
    protected void validatePaymentId(Long paymentId, boolean required) {
        validatorLong(FieldCode.PAYMENT_ID, paymentId, required, null, null, NumberValidator.POSITIVE);
    }

    /**
     * 验证支付：订单ID
     * 
     * @param orderId
     *            支付：订单ID
     */
    protected void validateOrderId(Long orderId, boolean required) {
        validatorLong(FieldCode.ORDER_ID, orderId, required, null, null, NumberValidator.POSITIVE);
    }

    /**
     * 验证支付：分批订单ID
     * 
     * @param batchOrderId
     *            支付：分批订单ID
     */
    protected void validateBatchOrderId(Long batchOrderId, boolean required) {
        validatorLong(FieldCode.BATCH_ORDER_ID, batchOrderId, required, null, null, NumberValidator.POSITIVE);
    }



    /**
     * 验证支付：支付金额
     * 
     * @param paymentAmount
     *            支付：支付金额
     */
    protected void validatePaymentAmount(BigDecimal paymentAmount, boolean required) {
        validatorDecimal(FieldCode.PAYMENT_AMOUNT, paymentAmount, required, ValidatorConst.MAX_M_PAYMENT_AMOUNT,
                ValidatorConst.MAX_D_PAYMENT_AMOUNT, NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证支付：支付时间
     * 
     * @param paymentDatetime
     *            支付：支付时间
     */
    protected void validatePaymentDatetime(Date paymentDatetime, boolean required) {
        validatorDate(FieldCode.PAYMENT_DATETIME, paymentDatetime, required);
    }

    /**
     * 验证支付：支付时间
     * 
     * @param paymentDatetime
     *            支付：支付时间
     */
    protected void validatePaymentDatetime(String paymentDatetime, boolean required) {
        validatorStrDate(FieldCode.PAYMENT_DATETIME, paymentDatetime, required, ValidatorConst.FORMAT_PAYMENT_DATETIME);
    }

    /**
     * 验证销售方：销售方编码
     * 
     * @param saleSideCode
     *            销售方：销售方编码
     */
    protected void validateSaleSideCode(String saleSideCode, boolean required) {
        this.validatorMaxLength(FieldCode.SALE_SIDE_CODE, saleSideCode, required,
                ValidatorConst.MAX_LENGTH_SALE_SIDE_CODE);
    }

    /**
     * 验证顺序号ID
     * 
     * @param id
     *            顺序号ID
     */
    protected void validateId(Long id, boolean required) {
        validatorLong(FieldCode.ID, id, required, ValidatorConst.MAX_VALUE_ID, ValidatorConst.MIN_VALUE_ID,
                NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证常量类型
     * 
     * @param constantType
     *            常量类型
     */
    protected void validateConstantType(String constantType, boolean required) {
        this.validatorMaxLength(FieldCode.CONSTANT_TYPE, constantType, required,
                ValidatorConst.MAX_LENGTH_CONSTANT_TYPE);
    }

    /**
     * 验证常量值名称
     * 
     * @param constantName
     *            常量值名称
     */
    protected void validateConstantName(String constantName, boolean required) {
        this.validatorMaxLength(FieldCode.CONSTANT_NAME, constantName, required,
                ValidatorConst.MAX_LENGTH_CONSTANT_NAME);
    }

    /**
     * 验证常量值
     * 
     * @param constantValue
     *            常量值
     */
    protected void validateConstantValue(String constantValue, boolean required) {
        this.validatorMaxLength(FieldCode.CONSTANT_VALUE, constantValue, required,
                ValidatorConst.MAX_LENGTH_CONSTANT_VALUE);
    }

    /**
     * 验证生效者ID
     * 
     * @param actId
     *            生效者ID
     */
    protected void validateActId(String actId, boolean required) {
        this.validatorMaxLength(FieldCode.ACT_ID, actId, required, ValidatorConst.MAX_LENGTH_ACT_ID);
    }

    /**
     * 验证生效日时
     * 
     * @param actTime
     *            生效日时
     */
    protected void validateActTime(Date actTime, boolean required) {
        validatorDate(FieldCode.ACT_TIME, actTime, required);
    }

    /**
     * 验证生效日时
     * 
     * @param actTime
     *            生效日时
     */
    protected void validateActTime(String actTime, boolean required) {
        validatorStrDate(FieldCode.ACT_TIME, actTime, required, ValidatorConst.FORMAT_ACT_TIME);
    }

    /**
     * 验证版本号
     * 
     * @param ver
     *            版本号
     */
    protected void validateVer(Integer ver, boolean required) {
        validatorInteger(FieldCode.VER, ver, required, ValidatorConst.MAX_VALUE_VER, ValidatorConst.MIN_VALUE_VER,
                NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证退货单ID
     * 
     * @param returnId
     *            退货单ID
     */
    protected void validateReturnId(Long returnId, boolean required) {
        validatorLong(FieldCode.RETURN_ID, returnId, required, null, null, NumberValidator.POSITIVE);
    }

    /**
     * 验证退货单ID
     *
     * @param returnIdStr
     *            退货单ID
     */
    protected void validateReturnId(String returnIdStr, boolean required) {
        try {
            Long returnId = Long.valueOf(returnIdStr);
            this.validateReturnId(returnId, true);
        } catch (NumberFormatException e) {
            this.getExceptionMessageList()
                    .add(new ValidatorExceptionMessage(FieldCode.RETURN_ID, null, null, "退货单ID错误"));
        }
    }

    /**
     * 验证退货单编码
     * 
     * @param returnCode
     *            退货单编码
     */
    protected void validateReturnCode(String returnCode, boolean required) {
        this.validatorMaxLength(FieldCode.RETURN_CODE, returnCode, required, ValidatorConst.MAX_LENGTH_RETURN_CODE);
    }

    /**
     * 验证买家ID
     * 
     * @param buyerId
     *            买家ID
     */
    protected void validateBuyerId(String buyerId, boolean required) {
        this.validatorMaxLength(FieldCode.BUYER_ID, buyerId, required, ValidatorConst.MAX_LENGTH_BUYER_ID);
    }

    /**
     * 验证买家编码
     * 
     * @param buyerCode
     *            买家编码
     */
    protected void validateBuyerCode(String buyerCode, boolean required) {
        this.validatorMaxLength(FieldCode.BUYER_CODE, buyerCode, required, ValidatorConst.MAX_LENGTH_BUYER_CODE);
    }

    /**
     * 验证买家名称
     * 
     * @param buyerName
     *            买家名称
     */
    protected void validateBuyerName(String buyerName, boolean required) {
        this.validatorMaxLength(FieldCode.BUYER_NAME, buyerName, required, ValidatorConst.MAX_LENGTH_BUYER_NAME);
    }

    /**
     * 验证买家退货单来源
     * 
     * @param buyerReturnSource
     *            买家退货单来源
     */
    protected void validateBuyerReturnSource(String buyerReturnSource, boolean required) {
        BuyerReturnSource type = BuyerReturnSource.getInstance(buyerReturnSource);
        if (required)
            validatorRequired(FieldCode.BUYER_RETURN_SOURCE, buyerReturnSource);
        if (buyerReturnSource != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.BUYER_RETURN_SOURCE, FieldCode.BUYER_RETURN_SOURCE, buyerReturnSource));
        }
    }

    /**
     * 验证买家退货类型
     * 
     * @param buyerReturnType
     *            买家退货类型
     */
    protected void validateBuyerReturnType(String buyerReturnType, boolean required) {
        BuyerReturnType type = BuyerReturnType.getInstance(buyerReturnType);
        if (required)
            validatorRequired(FieldCode.BUYER_RETURN_TYPE, buyerReturnType);
        if (buyerReturnType != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.BUYER_RETURN_TYPE, FieldCode.BUYER_RETURN_TYPE, buyerReturnType));
        }
    }

    /**
     * 验证退货总金额
     * 
     * @param returnAmount
     *            退货总金额
     */
    protected void validateReturnAmount(BigDecimal returnAmount, boolean required) {
        validatorDecimal(FieldCode.RETURN_AMOUNT, returnAmount, required, ValidatorConst.MAX_M_RETURN_AMOUNT,
                ValidatorConst.MAX_D_RETURN_AMOUNT, NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证退货原因ID
     * 
     * @param returnReasonId
     *            退货原因ID
     */
    protected void validateReturnReasonId(Long returnReasonId, boolean required) {
        validatorLong(FieldCode.RETURN_REASON_ID, returnReasonId, required, null, null, NumberValidator.POSITIVE);
    }

    /**
     * 验证买家退货申请人类型
     * 
     * @param buyerApplyUserType
     *            买家退货申请人类型
     */
    protected void validateBuyerApplyUserType(String buyerApplyUserType, boolean required) {
        BuyerApplyUserType type = BuyerApplyUserType.getInstance(buyerApplyUserType);
        if (required)
            validatorRequired(FieldCode.BUYER_APPLY_USER_TYPE, buyerApplyUserType);
        if (buyerApplyUserType != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.BUYER_APPLY_USER_TYPE, FieldCode.BUYER_APPLY_USER_TYPE, buyerApplyUserType));
        }
    }

    /**
     * 验证退货申请人ID
     * 
     * @param applyUid
     *            退货申请人ID
     */
    protected void validateApplyUid(String applyUid, boolean required) {
        this.validatorMaxLength(FieldCode.APPLY_UID, applyUid, required, ValidatorConst.MAX_LENGTH_APPLY_UID);
    }

    /**
     * 验证退货申请人名称
     * 
     * @param applyUname
     *            退货申请人名称
     */
    protected void validateApplyUname(String applyUname, boolean required) {
        this.validatorMaxLength(FieldCode.APPLY_UNAME, applyUname, required, ValidatorConst.MAX_LENGTH_APPLY_UNAME);
    }

    /**
     * 验证退货申请时间
     * 
     * @param applyTime
     *            退货申请时间
     */
    protected void validateApplyTime(Date applyTime, boolean required) {
        validatorDate(FieldCode.APPLY_TIME, applyTime, required);
    }

    /**
     * 验证退货申请时间
     * 
     * @param applyTime
     *            退货申请时间
     */
    protected void validateApplyTime(String applyTime, boolean required) {
        validatorStrDate(FieldCode.APPLY_TIME, applyTime, required, ValidatorConst.FORMAT_APPLY_TIME);
    }


    /**
     * 迟收时间
     *
     * @param receiptDate
     *
     */
    protected void validateReceiptDate(String receiptDate, boolean required) {
        validatorStrDate(FieldCode.RECEIPT_DATE, receiptDate, required, ValidatorConst.RECEIPT_DATE);
    }


    /**
     * 验证退货申请备注
     * 
     * @param applyRemark
     *            退货申请备注
     */
    protected void validateApplyRemark(String applyRemark, boolean required) {
        this.validatorMaxLength(FieldCode.APPLY_REMARK, applyRemark, required, ValidatorConst.MAX_LENGTH_APPLY_REMARK);
    }

    /**
     * 验证买家退货确认人类型
     * 
     * @param buyerConfirmUserType
     *            买家退货确认人类型
     */
    protected void validateBuyerConfirmUserType(String buyerConfirmUserType, boolean required) {
        BuyerConfirmUserType type = BuyerConfirmUserType.getInstance(buyerConfirmUserType);
        if (required)
            validatorRequired(FieldCode.BUYER_CONFIRM_USER_TYPE, buyerConfirmUserType);
        if (buyerConfirmUserType != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.BUYER_CONFIRM_USER_TYPE, FieldCode.BUYER_CONFIRM_USER_TYPE, buyerConfirmUserType));
        }
    }

    /**
     * 验证退货确认人ID
     * 
     * @param confirmUid
     *            退货确认人ID
     */
    protected void validateConfirmUid(String confirmUid, boolean required) {
        this.validatorMaxLength(FieldCode.CONFIRM_UID, confirmUid, required, ValidatorConst.MAX_LENGTH_CONFIRM_UID);
    }

    /**
     * 验证退货确认人名称
     * 
     * @param confirmUname
     *            退货确认人名称
     */
    protected void validateConfirmUname(String confirmUname, boolean required) {
        this.validatorMaxLength(FieldCode.CONFIRM_UNAME, confirmUname, required,
                ValidatorConst.MAX_LENGTH_CONFIRM_UNAME);
    }

    /**
     * 验证退货确认时间
     * 
     * @param confirmTime
     *            退货确认时间
     */
    protected void validateConfirmTime(Date confirmTime, boolean required) {
        validatorDate(FieldCode.CONFIRM_TIME, confirmTime, required);
    }

    /**
     * 验证退货确认时间
     * 
     * @param confirmTime
     *            退货确认时间
     */
    protected void validateConfirmTime(String confirmTime, boolean required) {
        validatorStrDate(FieldCode.CONFIRM_TIME, confirmTime, required, ValidatorConst.FORMAT_CONFIRM_TIME);
    }

    /**
     * 验证退货确认方式
     * 
     * @param confirmType
     *            退货确认方式
     */
    protected void validateConfirmType(String confirmType, boolean required) {
        this.validatorMaxLength(FieldCode.CONFIRM_TYPE, confirmType, required, ValidatorConst.MAX_LENGTH_CONFIRM_TYPE);
    }

    /**
     * 验证退货确认备注
     * 
     * @param confirmRemark
     *            退货确认备注
     */
    protected void validateConfirmRemark(String confirmRemark, boolean required) {
        this.validatorMaxLength(FieldCode.CONFIRM_REMARK, confirmRemark, required,
                ValidatorConst.MAX_LENGTH_CONFIRM_REMARK);
    }

    /**
     * 验证入库人ID
     * 
     * @param inboundUid
     *            入库人ID
     */
    protected void validateInboundUid(String inboundUid, boolean required) {
        this.validatorMaxLength(FieldCode.INBOUND_UID, inboundUid, required, ValidatorConst.MAX_LENGTH_INBOUND_UID);
    }

    /**
     * 验证入库人ID
     *
     * @param inboundUid
     *            入库人ID
     */
    protected void validateInboundUid(Long inboundUid, boolean required) {
        this.validatorMaxLength(FieldCode.INBOUND_UID, String.valueOf(inboundUid), required,
                ValidatorConst.MAX_LENGTH_INBOUND_UID);
    }

    /**
     * 验证入库人名称
     * 
     * @param inboundUname
     *            入库人名称
     */
    protected void validateInboundUname(String inboundUname, boolean required) {
        this.validatorMaxLength(FieldCode.INBOUND_UNAME, inboundUname, required,
                ValidatorConst.MAX_LENGTH_INBOUND_UNAME);
    }

    /**
     * 验证入库时间
     * 
     * @param inboundTime
     *            入库时间
     */
    protected void validateInboundTime(Date inboundTime, boolean required) {
        validatorDate(FieldCode.INBOUND_TIME, inboundTime, required);
    }

    /**
     * 验证入库时间
     * 
     * @param inboundTime
     *            入库时间
     */
    protected void validateInboundTime(String inboundTime, boolean required) {
        validatorStrDate(FieldCode.INBOUND_TIME, inboundTime, required, ValidatorConst.FORMAT_INBOUND_TIME);
    }

    /**
     * 验证买家退货状态
     * 
     * @param buyerReturnStatus
     *            买家退货状态
     */
    protected void validateBuyerReturnStatus(String buyerReturnStatus, boolean required) {
        BuyerReturnStu type = BuyerReturnStu.getInstance(buyerReturnStatus);
        if (required)
            validatorRequired(FieldCode.BUYER_RETURN_STATUS, buyerReturnStatus);
        if (buyerReturnStatus != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.BUYER_RETURN_STATUS, FieldCode.BUYER_RETURN_STATUS, buyerReturnStatus));
        }
    }

    /**
     * 验证退货原因照片1
     * 
     * @param image1
     *            退货原因照片1
     */
    protected void validateImage1(String image1, boolean required) {
        this.validatorMaxLength(FieldCode.IMAGE1, image1, required, ValidatorConst.MAX_LENGTH_IMAGE1);
    }

    /**
     * 验证退货原因照片2
     * 
     * @param image2
     *            退货原因照片2
     */
    protected void validateImage2(String image2, boolean required) {
        this.validatorMaxLength(FieldCode.IMAGE2, image2, required, ValidatorConst.MAX_LENGTH_IMAGE2);
    }

    /**
     * 验证退货原因照片3
     * 
     * @param image3
     *            退货原因照片3
     */
    protected void validateImage3(String image3, boolean required) {
        this.validatorMaxLength(FieldCode.IMAGE3, image3, required, ValidatorConst.MAX_LENGTH_IMAGE3);
    }

    /**
     * 验证退货原因照片4
     * 
     * @param image4
     *            退货原因照片4
     */
    protected void validateImage4(String image4, boolean required) {
        this.validatorMaxLength(FieldCode.IMAGE4, image4, required, ValidatorConst.MAX_LENGTH_IMAGE4);
    }

    /**
     * 验证退货原因照片5
     * 
     * @param image5
     *            退货原因照片5
     */
    protected void validateImage5(String image5, boolean required) {
        this.validatorMaxLength(FieldCode.IMAGE5, image5, required, ValidatorConst.MAX_LENGTH_IMAGE5);
    }

    /**
     * 验证共通：删除标志
     * 
     * @param delFlg
     *            共通：删除标志
     */
    protected void validateDelFlg(Boolean delFlg, boolean required) {
        if (required)
            validatorRequired(FieldCode.DEL_FLG, delFlg);
    }

    /**
     * 验证共通：创建者ID
     * 
     * @param crtId
     *            共通：创建者ID
     */
    protected void validateCrtId(String crtId, boolean required) {
        this.validatorMaxLength(FieldCode.CRT_ID, crtId, required, ValidatorConst.MAX_LENGTH_CRT_ID);
    }

    /**
     * 验证共通：创建日时
     * 
     * @param crtTime
     *            共通：创建日时
     */
    protected void validateCrtTime(Date crtTime, boolean required) {
        validatorDate(FieldCode.CRT_TIME, crtTime, required);
    }

    /**
     * 验证共通：创建日时
     * 
     * @param crtTime
     *            共通：创建日时
     */
    protected void validateCrtTime(String crtTime, boolean required) {
        validatorStrDate(FieldCode.CRT_TIME, crtTime, required, ValidatorConst.FORMAT_CRT_TIME);
    }

    /**
     * 验证共通：更新者ID
     * 
     * @param updId
     *            共通：更新者ID
     */
    protected void validateUpdId(String updId, boolean required) {
        this.validatorMaxLength(FieldCode.UPD_ID, updId, required, ValidatorConst.MAX_LENGTH_UPD_ID);
    }

    /**
     * 验证共通：更新日时
     * 
     * @param updTime
     *            共通：更新日时
     */
    protected void validateUpdTime(Date updTime, boolean required) {
        validatorDate(FieldCode.UPD_TIME, updTime, required);
    }

    /**
     * 验证共通：更新日时
     * 
     * @param updTime
     *            共通：更新日时
     */
    protected void validateUpdTime(String updTime, boolean required) {
        validatorStrDate(FieldCode.UPD_TIME, updTime, required, ValidatorConst.FORMAT_UPD_TIME);
    }

    /**
     * 验证共通：版本号
     * 
     * @param version
     *            共通：版本号
     */
    protected void validateVersion(Integer version, boolean required) {
        validatorInteger(FieldCode.VERSION, version, required, ValidatorConst.MAX_VALUE_VERSION,
                ValidatorConst.MIN_VALUE_VERSION, NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证退货明细ID
     * 
     * @param detailId
     *            退货明细ID
     */
    protected void validateDetailId(Long detailId, boolean required) {
        validatorLong(FieldCode.DETAIL_ID, detailId, required, null, null, NumberValidator.POSITIVE);
    }

    /**
     * 验证退货明细ID
     *
     * @param detailIdStr
     *            退货明细ID
     */
    protected void validateDetailId(String detailIdStr, boolean required) {
        try {
            Long detailId = Long.valueOf(detailIdStr);
            validatorLong(FieldCode.DETAIL_ID, detailId, required, null, null, NumberValidator.POSITIVE);
        } catch (NumberFormatException e) {
            this.getExceptionMessageList()
                    .add(new ValidatorExceptionMessage(FieldCode.DETAIL_ID, null, null, "退货明细ID错误"));
        }
    }

    /**
     * 验证配送明细ID
     * 
     * @param distributionNotificationDetailId
     *            配送明细ID
     */
    protected void validateDistributionNotificationDetailId(Long distributionNotificationDetailId, boolean required) {
        validatorLong(FieldCode.DISTRIBUTION_NOTIFICATION_DETAIL_ID, distributionNotificationDetailId, required, null,
                null, NumberValidator.POSITIVE);
    }

    /**
     * 验证配送明细ID
     *
     * @param shipDetailId
     *            配送明细ID
     */
    protected void validateShipDetailId(Long shipDetailId, boolean required) {
        validatorLong(FieldCode.SHIP_DETAIL_ID, shipDetailId, required, null,
                null, NumberValidator.POSITIVE);
    }
    /**
     * 验证商品ID
     * 
     * @param goodsId
     *            商品ID
     */
    protected void validateGoodsId(String goodsId, boolean required) {
        this.validatorMaxLength(FieldCode.GOODS_ID, goodsId, required, ValidatorConst.MAX_LENGTH_GOODS_ID);
    }

    /**
     * 验证销售单位
     * 
     * @param salesUnit
     *            销售单位
     */
    protected void validateSalesUnit(String salesUnit, boolean required) {
        GoodsUnit type = GoodsUnit.getInstance(salesUnit);
        if (required)
            validatorRequired(FieldCode.SALES_UNIT, salesUnit);
        if (salesUnit != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.SALES_UNIT, FieldCode.SALES_UNIT, salesUnit));
        }
    }

    /**
     * 验证退货数量
     * 
     * @param returnQty
     *            退货数量
     */
    protected void validateReturnQty(BigDecimal returnQty, boolean required) {
        validatorDecimal(FieldCode.RETURN_QTY, returnQty, required, ValidatorConst.MAX_M_RETURN_QTY,
                ValidatorConst.MAX_D_RETURN_QTY, NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证退货原因ID
     * 
     * @param reasonId
     *            退货原因ID
     */
    protected void validateReasonId(Long reasonId, boolean required) {
        validatorLong(FieldCode.REASON_ID, reasonId, required, null, null, NumberValidator.POSITIVE);
    }

    /**
     * 验证退货入库批次
     * 
     * @param inboundBatch
     *            退货入库批次
     */
    protected void validateInboundBatch(String inboundBatch, boolean required) {
        this.validatorMaxLength(FieldCode.INBOUND_BATCH, inboundBatch, required,
                ValidatorConst.MAX_LENGTH_INBOUND_BATCH);
    }

    /**
     * 验证退货入库批次
     *
     * @param inboundBatch
     *            退货入库批次
     */
    protected void validateInboundBatch(Long inboundBatch, boolean required) {
        this.validatorMaxLength(FieldCode.INBOUND_BATCH, String.valueOf(inboundBatch), required,
                ValidatorConst.MAX_LENGTH_INBOUND_BATCH);
    }

    /**
     * SKU编码
     *
     * @param skuCode
     *            退货入库批次
     */
    protected void validateSkuCode(String skuCode, boolean required) {
        this.validatorRequired(FieldCode.SKU_CODE, skuCode);
    }

    /**
     * 验证配送单ID
     * 
     * @param distributionNotificationId
     *            配送单ID
     */
    protected void validateDistributionNotificationId(Long distributionNotificationId, boolean required) {
        validatorLong(FieldCode.DISTRIBUTION_NOTIFICATION_ID, distributionNotificationId, required, null, null,
                NumberValidator.POSITIVE);
    }

    /**
     * 验证退货入库数量
     * 
     * @param inboundQty
     *            退货入库数量
     */
    protected void validateInboundQty(Integer inboundQty, boolean required) {
        validatorInteger(FieldCode.INBOUND_QTY, inboundQty, required, ValidatorConst.MAX_VALUE_INBOUND_QTY,
                ValidatorConst.MIN_VALUE_INBOUND_QTY, NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证退货入库数量
     *
     * @param inboundQtyStr
     *            退货入库数量
     */
    protected void validateInboundQty(String inboundQtyStr, boolean required) {
        try {
            Integer inboundQty = Integer.valueOf(inboundQtyStr);
            validatorInteger(FieldCode.INBOUND_QTY, inboundQty, required, ValidatorConst.MAX_VALUE_INBOUND_QTY,
                    ValidatorConst.MIN_VALUE_INBOUND_QTY, NumberValidator.NOT_NEGATIVE);
        } catch (NumberFormatException e) {
            this.getExceptionMessageList()
                    .add(new ValidatorExceptionMessage(FieldCode.INBOUND_QTY, null, null, "WMS入库数量错误"));
        }
    }

    /**
     * 验证履历ID
     * 
     * @param historyId
     *            履历ID
     */
    protected void validateHistoryId(Long historyId, boolean required) {
        validatorLong(FieldCode.HISTORY_ID, historyId, required, null, null, NumberValidator.POSITIVE);
    }

    /**
     * 验证退货原因名称
     * 
     * @param reasonName
     *            退货原因名称
     */
    protected void validateReasonName(String reasonName, boolean required) {
        this.validatorMaxLength(FieldCode.REASON_NAME, reasonName, required, ValidatorConst.MAX_LENGTH_REASON_NAME);
    }

    /**
     * 验证适用类型
     * 
     * @param applyType
     *            适用类型
     */
    protected void validateApplyType(String applyType, boolean required) {
        this.validatorMaxLength(FieldCode.APPLY_TYPE, applyType, required, ValidatorConst.MAX_LENGTH_APPLY_TYPE);
    }

    /**
     * 验证适用对象
     * 
     * @param applyObject
     *            适用对象
     */
    protected void validateApplyObject(String applyObject, boolean required) {
        ApplyObject type = ApplyObject.getInstance(applyObject);
        if (required)
            validatorRequired(FieldCode.APPLY_OBJECT, applyObject);
        if (applyObject != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.APPLY_OBJECT, FieldCode.APPLY_OBJECT, applyObject));
        }
    }

    /**
     * 验证买手ID
     * 
     * @param bsId
     *            买手ID
     */
    protected void validateBsId(String bsId, boolean required) {
        this.validatorMaxLength(FieldCode.BS_ID, bsId, required, ValidatorConst.MAX_LENGTH_BS_ID);
    }

    /**
     * 验证买手编码
     * 
     * @param bsCode
     *            买手编码
     */
    protected void validateBsCode(String bsCode, boolean required) {
        this.validatorMaxLength(FieldCode.BS_CODE, bsCode, required, ValidatorConst.MAX_LENGTH_BS_CODE);
    }

    /**
     * 验证买手名称
     * 
     * @param bsName
     *            买手名称
     */
    protected void validateBsName(String bsName, boolean required) {
        this.validatorMaxLength(FieldCode.BS_NAME, bsName, required, ValidatorConst.MAX_LENGTH_BS_NAME);
    }

    /**
     * 验证买手退货单来源
     * 
     * @param bsReturnSource
     *            买手退货单来源
     */
    protected void validateBsReturnSource(String bsReturnSource, boolean required) {
        BsReturnSource type = BsReturnSource.getInstance(bsReturnSource);
        if (required)
            validatorRequired(FieldCode.BS_RETURN_SOURCE, bsReturnSource);
        if (bsReturnSource != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.BS_RETURN_SOURCE, FieldCode.BS_RETURN_SOURCE, bsReturnSource));
        }
    }

    /**
     * 验证买手退货类型
     * 
     * @param bsReturnType
     *            买手退货类型
     */
    protected void validateBsReturnType(String bsReturnType, boolean required) {
        BsReturnType type = BsReturnType.getInstance(bsReturnType);
        if (required)
            validatorRequired(FieldCode.BS_RETURN_TYPE, bsReturnType);
        if (bsReturnType != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.BS_RETURN_TYPE, FieldCode.BS_RETURN_TYPE, bsReturnType));
        }
    }

    /**
     * 验证买手退货申请人类型
     * 
     * @param bsApplyUserType
     *            买手退货申请人类型
     */
    protected void validateBsApplyUserType(String bsApplyUserType, boolean required) {
        BsApplyUserType type = BsApplyUserType.getInstance(bsApplyUserType);
        if (required)
            validatorRequired(FieldCode.BS_APPLY_USER_TYPE, bsApplyUserType);
        if (bsApplyUserType != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.BS_APPLY_USER_TYPE, FieldCode.BS_APPLY_USER_TYPE, bsApplyUserType));
        }
    }

    /**
     * 验证买手退货状态
     * 
     * @param bsReturnStu
     *            买手退货状态
     */
    protected void validateBsReturnStu(String bsReturnStu, boolean required) {
        BsReturnStu type = BsReturnStu.getInstance(bsReturnStu);
        if (required)
            validatorRequired(FieldCode.BS_RETURN_STU, bsReturnStu);
        if (bsReturnStu != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.BS_RETURN_STU, FieldCode.BS_RETURN_STU, bsReturnStu));
        }
    }

    /**
     * 验证买手囤货分拆单明细ID
     * 
     * @param bsStockpileSplitDetailId
     *            买手囤货分拆单明细ID
     */
    protected void validateBsStockpileSplitDetailId(Long bsStockpileSplitDetailId, boolean required) {
        validatorLong(FieldCode.BS_STOCKPILE_SPLIT_DETAIL_ID, bsStockpileSplitDetailId, required, null, null,
                NumberValidator.POSITIVE);
    }


    /**
     * 验证通知：配送单id
     *
     * @param shipId
     *            通知：配送取消通知单ID
     */
    protected void validateShipId(Long shipId, boolean required) {
        validatorLong(FieldCode.SHIP_ID, shipId, required, null,
                null, NumberValidator.POSITIVE);
    }



    /**
     * 验证退货申请人名称
     *
     * @param applyMan
     *            退货申请人名称
     */
    protected void validateApplyMan(String applyMan, boolean required) {
        this.validatorMaxLength(FieldCode.APPLY_MAN, applyMan, required, ValidatorConst.MAX_LENGTH_APPLY_UNAME);
    }

    /**
     * 验证订单：支付方式
     *
     * @param paymentWay
     *            订单：支付方式
     */
    protected void validatePaymentWay(String paymentWay, boolean required) {
        PaymentWay style = PaymentWay.getInstance(paymentWay);
        if (required)
            validatorRequired(FieldCode.PAYMENT_WAY, paymentWay);
        if (paymentWay != null && style == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.PAYMENT_WAY, FieldCode.PAYMENT_WAY, paymentWay));
        }
    }

    /**
     * 验证订单：支付科目
     *
     * @param paymentSubject
     *            订单：支付科目
     */
    protected void validatePaymentSubject(String paymentSubject, boolean required) {
        PaymentSubject subject = PaymentSubject.getInstance(paymentSubject);
        if (required)
            validatorRequired(FieldCode.PAYMENT_SUBJECT, paymentSubject);
        if (paymentSubject != null && subject == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.PAYMENT_SUBJECT, FieldCode.PAYMENT_SUBJECT, paymentSubject));
        }
    }
}
