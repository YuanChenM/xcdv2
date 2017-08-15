package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * 配送通知单取消类型
 * 
 * @author li_huiqian
 *
 */
public enum DistributionCancelType {

    ORDER_CANCEL("001", "订单取消"), DISTRIBUTION_CANCEL("002", "配送通知单取消");

    private String code;

    private String name;

    private DistributionCancelType(String code, String name) {
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
        for (DistributionCancelType item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static DistributionCancelType getInstance(String code) {
        for (DistributionCancelType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(DistributionCancelType[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (DistributionCancelType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(DistributionCancelType.values());
    }

}
