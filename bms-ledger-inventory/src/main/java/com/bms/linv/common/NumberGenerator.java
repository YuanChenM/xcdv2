package com.bms.linv.common;

import com.bms.linv.constant.LinvTypeCodeMaster;
import com.framework.core.utils.DateUtils;
import com.framework.number.generate.NumberGenerateManager;

/**
 * Created by duan_kai on 2017/1/4.
 */
public class NumberGenerator {
    public static String getNewLoadNumber(){
        return NumberGenerateManager.timestamp(LinvTypeCodeMaster.NUMBER_GENERATE.LOAD, DateUtils.FORMAT_YYMMDD, 5);
    }

    public static String getNewCommodityNumber(){
        return NumberGenerateManager.timestamp(LinvTypeCodeMaster.NUMBER_GENERATE.COMMODITY, DateUtils.FORMAT_YYMMDD, 5);
    }

    public static String getNewProductAllocationNumber(){
        return NumberGenerateManager.timestamp(LinvTypeCodeMaster.NUMBER_GENERATE.PRODUCT_ALLOCATION, DateUtils.FORMAT_YYMMDD, 5);
    }

    public static String getNewCommAllocationNumber(){
        return NumberGenerateManager.timestamp(LinvTypeCodeMaster.NUMBER_GENERATE.COMM_ALLOCATION, DateUtils.FORMAT_YYMMDD, 5);
    }

    public static String getNewLoadAdjustmentNumber(){
        return NumberGenerateManager.timestamp(LinvTypeCodeMaster.NUMBER_GENERATE.LOAD_ADJUSTMENT, DateUtils.FORMAT_YYMMDD, 5);
    }

    public static String getNewCommAdjustmentNumber(){
        return NumberGenerateManager.timestamp(LinvTypeCodeMaster.NUMBER_GENERATE.COMM_ADJUSTMENT, DateUtils.FORMAT_YYMMDD, 5);
    }
}
