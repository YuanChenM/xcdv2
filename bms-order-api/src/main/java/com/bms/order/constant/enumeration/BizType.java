package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ni_shaotang on 2017/3/9.
 */
public enum BizType {

    SellerSale("008", "平台卖家销售"), AgentSale("009", "买手销售"),ActualStore("003", "实物囤货"), VirtualStore("005", "货权囤货"),AlgorithmicStore("007", "沽货囤货")
    ,ActualStoreReturn("004", "实物囤货退货"),VirtualStoreReturn("006", "货权囤货退货"),SellerSaleReturn("010", "平台卖家销售退货"),AgentSaleReturn("011", "买手销售退货")
    ,Virtual2Actual("012", "买手货权行权");

    private String code;

    private String name;

    private BizType(String code, String name) {
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
        for (BizType item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static BizType getInstance(String code) {
        for (BizType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(BizType[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (BizType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(BizType.values());
    }
}
