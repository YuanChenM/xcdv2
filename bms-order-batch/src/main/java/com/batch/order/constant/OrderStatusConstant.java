package com.batch.order.constant;

/**
 * 订单状态常量类
 *
 * @author liu_tao2
 * @version 1.0
 */
public interface OrderStatusConstant {
    /**
     * 买家订单状态
     */
    interface BuyerOrderStu {
        /**
         * 确认中
         */
        String IN_CONFIRMATION = "001";

        /**
         * 已确认
         */
        String CONFIRMED = "002";

        /**
         * 未完成
         */
        String NOT_COMPLETED = "003";

        /**
         * 已完成
         */
        String ALREADY_COMPLETED = "004";

        /**
         * 已核销
         */
        String WRITE_OFF = "005";

        /**
         * 已取消
         */
        String CANCEL = "099";

        /**
         * 创建失败
         */
        String CREATE_FAIL = "100";
    }

    /**
     * 买家分批单状态
     */
    interface BuyerBatchOrderStu {

        /**
         * 待分拆
         */
        String TO_SPLIT = "001";

        /**
         * 分拆待确认
         */
        String SPLIT_CONFIRM = "002";

        /**
         * 已确认
         */
        String CONFIRMED = "003";

        /**
         * 待发货
         */
        String WAIT_SEND = "004";

        /**
         * 部分发货
         */
        String PARTIAL_SHIPMENT = "005";

        /**
         * 全部发货
         */
        String ALL_SHIPMENT = "006";

        /**
         * 部分收货
         */
        String PARTIAL_RECEIPT = "007";

        /**
         * 全部迟收
         */
        String ALL_LATE_RECEIPT = "008";

        /**
         * 收货完成
         */
        String RECEIPT_FINISH = "009";

        /**
         * 全部退货
         */
        String ALL_RETURN = "010";

        /**
         * 部分分拆
         */
        String PART_SPLIT = "011";

        /**
         * 分拆失败
         */
        String SPLIT_FAIL = "098";

        /**
         * 已取消
         */
        String CANCEL = "099";
    }

    /**
     * 配送通知状态
     */
    interface DistributionNotificationStu {
        /**
         * 待配送
         */
        String TO_DISTRIBUTION = "001";

        /**
         * 配送中
         */
        String IN_DISTRIBUTION = "002";

        /**
         * 部分收货
         */
        String PARTIAL_RECEIPT = "003";

        /**
         * 收货完成
         */
        String RECEIPT_FINISH = "004";

        /**
         * 全部迟收
         */
        String ALL_LATE_RECEIPT = "005";

        /**
         * 全部退货
         */
        String ALL_RETURN = "006";

        /**
         * 取消中
         */
        String IN_CANCEL = "098";

        /**
         * 已取消
         */
        String CANCEL = "099";
    }

    /**
     * 买手订单状态
     */
    interface BsOrderStu {
        /**
         * 确认中
         */
        String IN_CONFIRMATION = "001";

        /**
         * 已确认
         */
        String CONFIRMED = "002";

        /**
         * 未完成
         * String NOT_COMPLETED = "003";
         * 已完成
         * String ALREADY_COMPLETED = "004";
         * 已核销
         * String WRITE_OFF = "005";
         */
        //囤货完成
        String COMPLETE_STOCKPILE = "003";
        //囤货失败
        String STOCKPILE_FAILURE = "004";
        /**
         * 已取消
         */
        String CANCEL = "099";

        /**
         * 创建失败
         */
        String CREATE_FAIL = "100";
    }

    /**
     * 买家退货状态
     */
    interface BuyerReturnStu {
        /**
         * 待确认
         */
        String TO_CONFIRM = "001";

        /**
         * 已确认
         */
        String CONFIRM = "002";

        /**
         * 待入库
         */
        String TO_STORAGE = "003";

        /**
         * 已入库
         */
        String IN_STORAGE = "004";

        /**
         * 已核销
         */
        String WRITE_OFF = "005";
    }

    /**
     * 买手退货状态
     */
    interface BsReturnStu {
        /**
         * 待确认
         */
        String TO_CONFIRM = "001";

        /**
         * 已入库
         */
        String IN_STORAGE = "002";

        /**
         * 已核销
         */
        String WRITE_OFF = "003";
    }

    /**
     * 问题订单状态
     */
    interface ProblemStu {
        /**
         * 待处理
         */
        String TO_HANDLE = "001";

        /**
         * 处理中
         */
        String IN_HANDLE = "002";

        /**
         * 已结案
         */
        String CASE_CLOSED = "003";
    }

    /**
     * 支付状态
     */
    interface PaymentStu {
        /**
         * 未支付
         */
        String NOT_PAYMENT = "001";

        /**
         * 部分支付
         */
        String PART_PAYMENT = "002";

        /**
         * 全部支付
         */
        String ALL_PAYMENT = "003";

        /**
         * 待退款
         */
        String TO_REFUND = "004";

        /**
         * 已退款
         */
        String IN_REFUND = "005";
    }
}
