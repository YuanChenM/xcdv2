package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * 买家订单状态
 * 
 * @author li_huiqian
 *
 */
public enum Currency {

    CNY("001", "CNY");

    private String code;

    private String name;

    private Currency(String code, String name) {
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
        for (Currency item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static Currency getInstance(String code) {
        for (Currency item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(Currency[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (Currency value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(Currency.values());
    }

}
