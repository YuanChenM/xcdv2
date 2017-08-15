package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * 订单来源
 * 
 * @author li_huiqian
 *
 */
public enum OrderSourceType {

    YDP_WEB("001", "云冻品WEB"), YDP_BUYER_APP("002", "云冻品买家App"), YDP_H5("003", "云冻品H5"), YTS_WEB("004", "云团膳WEB"),
    YTS_H5("005","云团膳H5"), YTH_WEB("006", "云囤货WEB"), YTH_H5("007", "云囤货H5"), YTH_SA_APP("008", "云囤货买手App"), YCC_WEB("009", "云菜场WEB"),
    YCC_H5("010", "云菜场H5"), YCC_APP("011", "云菜场App"), SERIES_PC("012", "竞价交易PC客户端"), SERIES_APP("013", "竞价交易App"),
    NO_SERIES_WEB("014", "定向分销交易WEB"), NO_SERIES_APP("015", "定向分销交易App"), YTH_WEB_YTS("016", "云囤货WEB-代云团膳买家下单"),YTH_H5_YTS("017", "云囤货H5-代云团膳买家下单"),
    YTH_SA_APP_YTS("018", "云囤货买手App-代云团膳买家下单"),MANAGE_SYSTEM("019", "后台管理系统");

    private String code;

    private String name;

    private OrderSourceType(String code, String name) {
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
        for (OrderSourceType item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static OrderSourceType getInstance(String code) {
        for (OrderSourceType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(OrderSourceType[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (OrderSourceType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(OrderSourceType.values());
    }

}
