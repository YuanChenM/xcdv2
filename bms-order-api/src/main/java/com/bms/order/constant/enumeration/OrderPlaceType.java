package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * 下单类型
 * 
 * @author li_huiqian
 *
 */
public enum OrderPlaceType {

    A_TYPE("001", "A类"), B_TYPE("002", "B类");

    private String code;

    private String name;

    private OrderPlaceType(String code, String name) {
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
        for (OrderPlaceType item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static OrderPlaceType getInstance(String code) {
        for (OrderPlaceType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(OrderPlaceType[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (OrderPlaceType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(OrderPlaceType.values());
    }

}
