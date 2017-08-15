package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * 买手订单类型
 * 
 * @author li_huiqian
 *
 */
public enum BsOrderStu {

    IN_CONFIRMATION("001", "确认中"), CONFIRMED("002", "已确认"), COMPLETE_STOCKPILE("003", "囤货完成"), STOCKPILE_FAILURE("004",
            "囤货失败"),RETURNED("005","全部退货"), CANCEL("099", "已取消"), CREATE_FAIL("100", "创建失败");

    private String code;

    private String name;

    private BsOrderStu(String code, String name) {
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
        for (BsOrderStu item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static BsOrderStu getInstance(String code) {
        for (BsOrderStu item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(BsOrderStu[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (BsOrderStu value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(BsOrderStu.values());
    }

}
