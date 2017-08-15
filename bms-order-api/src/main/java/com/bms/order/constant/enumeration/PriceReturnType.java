package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ni_shaotang on 2017/3/2.
 */
public enum PriceReturnType {
    ALL_PRICE(0, "返回所有时间点的价盘"), MIN_PRICE(1, "返回比价最低"), MAX_PRICE(2, "返回比价最高");
    private Integer code;

    private String name;

    private PriceReturnType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static String findName(Integer code) {
        for (PriceReturnType item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static PriceReturnType getInstance(Integer code) {
        for (PriceReturnType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<Integer, String> getMap(PriceReturnType[] values) {
        if (values == null)
            return null;

        Map<Integer, String> map = new HashMap<>();
        for (PriceReturnType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<Integer, String> getMap() {
        return getMap(PriceReturnType.values());
    }

}
