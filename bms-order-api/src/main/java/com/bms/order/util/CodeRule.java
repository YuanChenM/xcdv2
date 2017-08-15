package com.bms.order.util;

import com.framework.base.consts.DateFormatDef;
import com.framework.number.generate.NumberGenerateManager;
import com.framework.number.generate.enums.ResetType;

/**
 * 编码规则
 * 
 * @author li_huiqian
 *
 */
public class CodeRule {

    /**
     * 通用规则
     * 
     * @param prefix
     * @return
     */
    public static String commonRule(String prefix) {
        return NumberGenerateManager.timestamp(prefix, DateFormatDef.FORMAT_YYYYMMDD, 8, "0", ResetType.Day);
    }

    /**
     * 订单规则
     * 
     * @param prefix
     * @param buyerSideCode
     * @return
     */
    public static String orderRule(String prefix, String buyerSideCode) {
        return NumberGenerateManager.timestamp(prefix + '-' + buyerSideCode, DateFormatDef.FORMAT_YYYYMMDD, 8, "0",
                ResetType.Day);
    }

    /**
     * 分批订单规则
     * 
     * @param orderCode
     * @return
     */
    public static String batchOrderRule(String orderCode) {
        return NumberGenerateManager.sequences(orderCode, 4, "0", null);
    }

}
