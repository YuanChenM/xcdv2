package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ni_shaotang on 2017/3/9.
 */
public enum IvType {

    Normal("001", "正常品");

    private String code;

    private String name;

    private IvType(String code, String name) {
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
        for (IvType item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static IvType getInstance(String code) {
        for (IvType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(IvType[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (IvType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(IvType.values());
    }
}
