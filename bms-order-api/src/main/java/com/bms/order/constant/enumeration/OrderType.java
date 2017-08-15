package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * 订单分类
 * 
 * @author li_huiqian
 *
 */
public enum OrderType {

    BUYER_ORDER("001", "买家订单"), BS_ORDER("002", "买手订单");

    private String code;

    private String name;

    private OrderType(String code, String name) {
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
        for (OrderType item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static OrderType getInstance(String code) {
        for (OrderType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(OrderType[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (OrderType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(OrderType.values());
    }

}
