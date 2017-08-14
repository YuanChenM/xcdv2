package com.batch.order.constant.ordr;

import java.util.HashMap;
import java.util.Map;

/**
 * 买手订单类型
 * 
 * @author li_huiqian
 *
 */
public enum BsOrderType {

    BS_A_STOCKPILING_ORDER("001", "买手A类囤货订单"), BS_B_STOCKPILING_ORDER("002", "买手B类囤货订单");

    private String code;

    private String name;

    private BsOrderType(String code, String name) {
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
        for (BsOrderType item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static BsOrderType getInstance(String code) {
        for (BsOrderType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(BsOrderType[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (BsOrderType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(BsOrderType.values());
    }

}
