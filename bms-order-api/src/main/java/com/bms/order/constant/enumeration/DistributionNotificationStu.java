package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * 买家订单状态
 * 
 * @author li_huiqian
 *
 */
public enum DistributionNotificationStu {

    TO_DISTRIBUTION("001", "待配送"), IN_DISTRIBUTION("002", "配送中"), PARTIAL_RECEIPT("003", "部分收货"), RECEIPT_FINISH("004",
            "收货完成"), ALL_LATE_RECEIPT("005",
                    "全部迟收"), ALL_RETURN("006", "全部退货"),WAIT_FOR_WAREHOUSE("007", "待分配仓库"),WAIT_FOR_WMS("008", "待传递WMS"), IN_CANCEL("098", "取消中"), CANCEL("099", "已取消");

    private String code;

    private String name;

    private DistributionNotificationStu(String code, String name) {
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
        for (DistributionNotificationStu item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static DistributionNotificationStu getInstance(String code) {
        for (DistributionNotificationStu item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(DistributionNotificationStu[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (DistributionNotificationStu value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(DistributionNotificationStu.values());
    }

}
