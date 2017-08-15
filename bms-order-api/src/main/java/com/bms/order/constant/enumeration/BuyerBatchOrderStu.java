package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * 买家订单状态
 *
 * @author li_huiqian
 */
public enum BuyerBatchOrderStu {

    TO_SPLIT("001", "待分拆"), SPLIT_CONFIRM("002", "分拆待确认"), CONFIRMED("003", "已确认"), WAIT_SEND("004",
            "待发货"), PARTIAL_SHIPMENT("005", "部分发货"), ALL_SHIPMENT("006", "全部发货"), PARTIAL_RECEIPT("007",
            "部分收货"), ALL_LATE_RECEIPT("008",
            "全部迟收"), RECEIPT_FINISH("009", "收货完成"), ALL_RETURN("010", "全部退货"), PART_SPLIT("011", "部分分拆"), CANCEL("099", "已取消"),
    SPLIT_FAIL("098", "分拆失败");

    private String code;

    private String name;

    private BuyerBatchOrderStu(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static String findName(String code) {
        for (BuyerBatchOrderStu item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static BuyerBatchOrderStu getInstance(String code) {
        for (BuyerBatchOrderStu item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(BuyerBatchOrderStu[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (BuyerBatchOrderStu value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(BuyerBatchOrderStu.values());
    }

}
