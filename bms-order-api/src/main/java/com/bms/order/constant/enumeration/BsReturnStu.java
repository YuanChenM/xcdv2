package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 买手退货状态
 * 
 * @author li_huiqian
 *
 */
public enum BsReturnStu {

	TO_CONFIRM("001", "Wait for Confirmation", "待确认"),
	COMPLETE("002", "Complete", "已完成"),
	WRITE_OFF("003", "Write Off", "已核销"),
	CANCEL("004", "Cancelled", "已取消");

    private String code;

    private String enDesc;
    
    private String cnDesc;

    private BsReturnStu (String code, String enDesc, String cnDesc) {
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

    public static BsReturnStu getInstance(String code) {
        for (BsReturnStu item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(BsReturnStu [] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (BsReturnStu value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(BsReturnStu.values());
    }

}
