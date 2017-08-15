package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * 买家订单状态
 * 
 * @author li_huiqian
 *
 */
public enum SalePlatformType {

    YDP("001", "云冻品平台");

    private String code;

    private String name;

    private SalePlatformType(String code, String name) {
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
        for (SalePlatformType item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static SalePlatformType getInstance(String code) {
        for (SalePlatformType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(SalePlatformType[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (SalePlatformType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(SalePlatformType.values());
    }

}
