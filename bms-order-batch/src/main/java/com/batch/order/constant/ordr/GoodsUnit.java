package com.batch.order.constant.ordr;

import java.util.HashMap;
import java.util.Map;

/**
 * 买家订单状态
 * 
 * @author li_huiqian
 *
 */
public enum GoodsUnit {

    PACKAGE("001", "箱"), KG("002", "千克");

    private String code;

    private String name;

    private GoodsUnit(String code, String name) {
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
        for (GoodsUnit item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static GoodsUnit getInstance(String code) {
        for (GoodsUnit item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(GoodsUnit[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (GoodsUnit value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(GoodsUnit.values());
    }

}
