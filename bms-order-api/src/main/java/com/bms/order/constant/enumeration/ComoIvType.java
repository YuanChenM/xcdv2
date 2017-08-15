package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * 商品库存类型
 * 
 * @author li_huiqian
 *
 */
public enum ComoIvType {

    Actual("001", "实物"), Virtual("002", "货权");

    private String code;

    private String name;

    private ComoIvType(String code, String name) {
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
        for (ComoIvType item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static ComoIvType getInstance(String code) {
        for (ComoIvType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(ComoIvType[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (ComoIvType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(ComoIvType.values());
    }

}
