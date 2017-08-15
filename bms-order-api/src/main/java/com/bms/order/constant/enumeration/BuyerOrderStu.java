package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * 买家订单状态
 * 
 * @author li_huiqian
 *
 */
public enum BuyerOrderStu {

    IN_CONFIRMATION("001", "确认中"), CONFIRMED("002", "已确认"), NOT_COMPLETED("003", "未完成"), ALREADY_COMPLETED("004",
            "已完成"), RETURNED("005", "全部退货"),WRITE_OFF("006", "已核销"), CANCEL("099", "已取消"), CREATE_FAIL("100", "创建失败");

    private String code;

    private String name;

    private BuyerOrderStu(String code, String name) {
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
        for (BuyerOrderStu item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static BuyerOrderStu getInstance(String code) {
        for (BuyerOrderStu item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(BuyerOrderStu[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (BuyerOrderStu value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(BuyerOrderStu.values());
    }

}
