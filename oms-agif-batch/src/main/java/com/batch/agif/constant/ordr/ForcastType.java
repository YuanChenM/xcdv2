package com.batch.agif.constant.ordr;

import java.util.HashMap;
import java.util.Map;

/**
 * 买家订单类型
 * 
 * @author li_huiqian
 *
 */
public enum ForcastType {

    STANDARD_SPLIT_DISTRIBUTION("001", "正常分拆预配送"), LATE_DISTRIBUTION("002", "迟收再配送");

    private String code;

    private String name;

    private ForcastType(String code, String name) {
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
        for (ForcastType item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static ForcastType getInstance(String code) {
        for (ForcastType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(ForcastType[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (ForcastType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(ForcastType.values());
    }

}
