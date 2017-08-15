package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 买家退货单来源
 * 
 * @author li_huiqian
 *
 */
public enum BuyerReturnSource {

	DISTRIBUTION_SYSTEM("001", "Distribution System", "配送系统"),
	YDP("002", "YDP", "云冻品平台"),
	ORDER_BACKEND("003", "Order Backend", "订单后台");

    private String code;

    private String enDesc;
    
    private String cnDesc;

    private BuyerReturnSource (String code, String enDesc, String cnDesc) {
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

    public static BuyerReturnSource getInstance(String code) {
        for (BuyerReturnSource item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(BuyerReturnSource [] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (BuyerReturnSource value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(BuyerReturnSource.values());
    }

}
