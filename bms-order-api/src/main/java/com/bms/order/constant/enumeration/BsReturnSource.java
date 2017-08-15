package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 买手退货单来源
 * 
 * @author li_huiqian
 *
 */
public enum BsReturnSource {

	BS_PLATFORM("001", "Bs Platform", "买手平台"),
	ORDER_BACKEND("002", "Order Backend", "订单后台");

    private String code;

    private String enDesc;
    
    private String cnDesc;

    private BsReturnSource (String code, String enDesc, String cnDesc) {
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

    public static BsReturnSource getInstance(String code) {
        for (BsReturnSource item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(BsReturnSource [] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (BsReturnSource value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(BsReturnSource.values());
    }

}
