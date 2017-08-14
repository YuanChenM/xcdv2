package com.batch.agif.constant.inv;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liutao on 2017/3/7.
 */
public enum InvType {
    Normal("001", "正常品");
    private String code;

    private String name;

    private InvType(String code, String name) {
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
        for (InvType item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static InvType getInstance(String code) {
        for (InvType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(InvType[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (InvType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(InvType.values());
    }
}
