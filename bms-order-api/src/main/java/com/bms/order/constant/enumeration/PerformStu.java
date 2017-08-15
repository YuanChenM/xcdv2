package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * 买家订单状态
 * 
 * @author li_huiqian
 *
 */
public enum PerformStu {

    WAIT_PERFORM("001", "待行权"), COMPLETE("002", "已完成");

    private String code;

    private String name;

    private PerformStu(String code, String name) {
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
        for (PerformStu item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static PerformStu getInstance(String code) {
        for (PerformStu item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(PerformStu[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (PerformStu value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(PerformStu.values());
    }

}
