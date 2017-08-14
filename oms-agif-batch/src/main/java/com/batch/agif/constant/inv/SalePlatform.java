package com.batch.agif.constant.inv;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liutao on 2017/3/7.
 */
public enum SalePlatform {
    YDP_PLATFORM("001","云冻品平台");

    private String code;

    private String name;

    private SalePlatform(String code, String name) {
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
        for (SalePlatform item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static SalePlatform getInstance(String code) {
        for (SalePlatform item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(SalePlatform[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (SalePlatform value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(SalePlatform.values());
    }
}
