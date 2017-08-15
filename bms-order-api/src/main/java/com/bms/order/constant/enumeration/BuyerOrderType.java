package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * 买家订单类型
 * 
 * @author li_huiqian
 *
 */
public enum BuyerOrderType {

    BUYER_A_STANDARD_ORDER("001", "买家A类标准订单"), BUYER_B_STANDARD_ORDER("002", "买家B类标准订单"), BUYER_A_BATCH_ORDER("003",
            "买家A类分批订单"), BUYER_B_BATCH_ORDER("004", "买家B类分批订单");

    private String code;

    private String name;

    private BuyerOrderType(String code, String name) {
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
        for (BuyerOrderType item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static BuyerOrderType getInstance(String code) {
        for (BuyerOrderType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(BuyerOrderType[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (BuyerOrderType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(BuyerOrderType.values());
    }

}
