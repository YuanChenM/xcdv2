package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * 取消对象类型
 * 
 * @author li_huiqian
 *
 */
public enum CancelModeType {

    BUYER_ORDER_CANCEL("001", "买家订单取消"), BS_ORDER_CANCEL("002", "买手订单取消"), BUYER_BATCH_ORDER("003", "买家分批订单");

    private String code;

    private String name;

    private CancelModeType(String code, String name) {
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
        for (CancelModeType item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static CancelModeType getInstance(String code) {
        for (CancelModeType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(CancelModeType[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (CancelModeType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(CancelModeType.values());
    }

}
