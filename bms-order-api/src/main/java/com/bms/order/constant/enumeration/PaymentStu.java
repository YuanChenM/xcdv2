package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * 买家订单状态
 * 
 * @author li_huiqian
 *
 */
public enum PaymentStu {

    NOT_PAYMENT("001", "未支付"), PART_PAYMENT("002", "部分支付"), ALL_PAYMENT("003", "全部支付"), TO_REFUND("004",
            "待退款"), IN_REFUND("005", "已退款");

    private String code;

    private String name;

    private PaymentStu(String code, String name) {
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
        for (PaymentStu item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static PaymentStu getInstance(String code) {
        for (PaymentStu item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(PaymentStu[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (PaymentStu value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(PaymentStu.values());
    }

}
