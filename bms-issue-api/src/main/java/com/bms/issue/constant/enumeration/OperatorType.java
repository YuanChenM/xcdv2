package com.bms.issue.constant.enumeration;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 操作者类型
 * 
 * @author li_huiqian
 *
 */
public enum OperatorType {

	BUYER("001", "Buyer", "买家"),
	SELLER("002", "Seller", "卖家"),
	BS("003", "Bs", "买手"),
	SA("004", "Sa", "冻品管家"),
	MANAGER("005", "Manager", "平台管理人员"),
    AGENT("006", "Agent", "销售合伙人"),
    ORDER_SYSTEM("011", "Order System", "订单系统"),
	MADE_4_NET("012", "Made 4 Net", "美迪福系统"),
	CASH_POOL("013", "Cash Pool", "资金池系统");

    private String code;

    private String enDesc;
    
    private String cnDesc;

    private OperatorType (String code, String enDesc, String cnDesc) {
        this.code = code;
        this.enDesc = enDesc;
        this.cnDesc = cnDesc;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
    	Locale locale = Locale.getDefault();
        return getName(locale);
    }
    
    public String getName(Locale locale) {
    	if (locale == Locale.SIMPLIFIED_CHINESE)
    		return cnDesc;
    	else 
    		return enDesc;
    }

    public static OperatorType getInstance(String code) {
        for (OperatorType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(OperatorType [] values) {
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
