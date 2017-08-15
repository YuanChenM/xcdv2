package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * 支付科目
 *
 * @author li_huiqian
 */
public enum PaymentSubject {

    Deposit("001", "预付款"), Down_Payment("002", "预付定金"), Remaining_Fund("003", "订单尾款"), Freight("004", "运输款"), Service_Charge("005", "服务费"),
    Transaction_Charge("006", "交易手续费"), Refund("007", "退货款");

    private String code;

    private String name;

    private PaymentSubject(String code, String name) {
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
        for (PaymentSubject item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static PaymentSubject getInstance(String code) {
        for (PaymentSubject item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(PaymentSubject[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (PaymentSubject value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(PaymentSubject.values());
    }

}
