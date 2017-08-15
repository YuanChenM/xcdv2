package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ni_shaotang on 2017/3/2.
 */
public enum PriceUserType {
    STANDARD_USER("0", "标准买家"), PERIOD_USER("1", "账期买家"), BS_USER("2", "买手");
    private String code;

    private String name;

    private PriceUserType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static String findName(Integer code) {
        for (PriceUserType item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static PriceUserType getInstance(Integer code) {
        for (PriceUserType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(PriceUserType[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (PriceUserType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(PriceUserType.values());
    }

}
