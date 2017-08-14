package com.batch.agif.constant.inv;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ni_shaotang on 2017/3/9.
 */
public enum LinvUom {

    Box("001", "箱"),Package("002","包");

    private String code;

    private String name;

    private LinvUom(String code, String name) {
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
        for (LinvUom item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static LinvUom getInstance(String code) {
        for (LinvUom item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(LinvUom[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (LinvUom value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(LinvUom.values());
    }
}
