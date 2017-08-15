package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * 买家订单类型
 * 
 * @author li_huiqian
 *
 */
public enum OperatorType {

    UNKNOWN("000", "未知"), BUYER("001", "买家"), SELLER("002", "卖家"), BS("003", "买手"), SA("004", "冻品管家"), MANAGER("005",
            "平台管理人员"), AGENT("006", "销售合伙人"), ORDER_SYSTEM("011", "订单系统"), MADE_4_NET("012", "美迪福系统"), CASH_POOL("013", "资金池系统");

    private String code;

    private String name;

    private OperatorType(String code, String name) {
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
        for (OperatorType item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static OperatorType getInstance(String code) {
        for (OperatorType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(OperatorType[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (OperatorType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(OperatorType.values());
    }

}
