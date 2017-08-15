package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ni_shaotang on 2017/3/9.
 */
public enum IsStoreFlag {

    BS("1", "表示从买手发货"), PLATFORM("2", "表示从平台发货");

    private String code;

    private String name;

    private IsStoreFlag(String code, String name) {
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
        for (IsStoreFlag item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static IsStoreFlag getInstance(String code) {
        for (IsStoreFlag item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(IsStoreFlag[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (IsStoreFlag value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(IsStoreFlag.values());
    }
}
