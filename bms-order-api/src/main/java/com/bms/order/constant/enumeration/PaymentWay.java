package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * 支付方式
 *
 * @author li_huiqian
 */
public enum PaymentWay {

    POS("001", "POS机刷卡"), Ali_Pay("002", "支付宝"), Wechat_Pay("003", "微信"), Bank_Transfer("004", "银行转账"), Cash("005", "现金"),
    Membership_Card("006", "会员卡"), Refund_Deduction("007", "退款抵扣"), Loan("008", "贷款支付"), Other("999", "其他");

    private String code;

    private String name;

    private PaymentWay(String code, String name) {
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
        for (PaymentWay item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static PaymentWay getInstance(String code) {
        for (PaymentWay item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(PaymentWay[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (PaymentWay value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(PaymentWay.values());
    }

}
