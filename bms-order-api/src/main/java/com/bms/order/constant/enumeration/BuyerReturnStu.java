package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 买家退货状态
 * 
 * @author li_huiqian
 *
 */
public enum BuyerReturnStu {

	TO_CONFIRM("001", "Wait For Confirmation", "待确认"),
	CONFIRMED("002", "Confirmed", "已确认"),
	TO_STORE("003", "Wait For Storing", "待入库"),
	STORED("004", "Stored", "已入库"),
	WRITE_OFF("005", "Write Off", "已核销"),
	CANCEL("099", "Cancelled", "已取消");

    private String code;

    private String enDesc;
    
    private String cnDesc;

    private BuyerReturnStu (String code, String enDesc, String cnDesc) {
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

    public static BuyerReturnStu getInstance(String code) {
        for (BuyerReturnStu item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(BuyerReturnStu [] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (BuyerReturnStu value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(BuyerReturnStu.values());
    }

}
