package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * 买手订单取消类型
 * 
 * @author li_huiqian
 *
 */
public enum BsOrderCancelType {

    ALL_CANCEL("001", "整单取消"), PART_CANCEL("002", "部分取消");

    private String code;

    private String name;

    private BsOrderCancelType(String code, String name) {
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
        for (BsOrderCancelType item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static BsOrderCancelType getInstance(String code) {
        for (BsOrderCancelType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(BsOrderCancelType[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (BsOrderCancelType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(BsOrderCancelType.values());
    }

}
