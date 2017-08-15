package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * 下单类型
 * 
 * @author li_huiqian
 *
 */
public enum OrderPlacerType {

    BUYER("001", "买家"), SELLER("002", "卖家"), BS("003", "买手"), SA("004", "冻品管家"), MANAGER("005", "平台管理人员");

    private String code;

    private String name;

    private OrderPlacerType(String code, String name) {
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
        for (OrderPlacerType item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static OrderPlacerType getInstance(String code) {
        for (OrderPlacerType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(OrderPlacerType[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (OrderPlacerType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(OrderPlacerType.values());
    }
}
