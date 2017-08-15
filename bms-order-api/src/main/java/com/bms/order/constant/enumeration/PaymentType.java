package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * 买家订单状态
 * 
 * @author li_huiqian
 *
 */
public enum PaymentType {

    PAYING_ONLINE("001", "线上支付"), CASH_ON_DELIVERY("002", "线下付款");

    private String code;

    private String name;

    private PaymentType(String code, String name) {
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
        for (PaymentType item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static PaymentType getInstance(String code) {
        for (PaymentType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(PaymentType[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (PaymentType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(PaymentType.values());
    }

}
