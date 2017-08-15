package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 买家退货类型
 * 
 * @author li_huiqian
 *
 */
public enum BuyerReturnType {

	DELAY_RETURN("001", "Delay and Return", "现场迟收退货"),
	REJECT_RETURN("002", "Reject and Return", "现场拒收退货"),
	RECEIVE_RETURN("003", "Receive and Return", "买家收货后退货");

    private String code;

    private String enDesc;
    
    private String cnDesc;

    private BuyerReturnType (String code, String enDesc, String cnDesc) {
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

    public static BuyerReturnType getInstance(String code) {
        for (BuyerReturnType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(BuyerReturnType [] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (BuyerReturnType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(BuyerReturnType.values());
    }

}
