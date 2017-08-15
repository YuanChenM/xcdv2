package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ni_shaotang on 2017/3/2.
 */
public enum PriceBuyerLevel {
    LEVEL_STANDARD("0", "标准买家"), LEVEL_ONE("1", "一级买家"), LEVEL_TWO("2", "二级买家"), LEVEL_THREE("3", "三级买家");
    private String code;

    private String name;

    private PriceBuyerLevel(String code, String name) {
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
        for (PriceBuyerLevel item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static PriceBuyerLevel getInstance(Integer code) {
        for (PriceBuyerLevel item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(PriceBuyerLevel[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (PriceBuyerLevel value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(PriceBuyerLevel.values());
    }

}
