package com.batch.linv.constant;

/**
 * Created by duan_kai on 2016/12/26.
 */
public class LinvTypeCodeMaster {

    public static class OWNER{
        public static String SELLER = "H01";
        public static String SALES = "H02";
    }

    public static class TARGET{
        public static String SALES = "T01";
        public static String BUYER = "T02";
    }

    public static class IV{
        public static String NORMAL = "I01";
        public static String ABNORMAL = "I02";
    }

    public static class ALLOCATION{
        public static String SALE = "001";
        public static String STORE = "002";
        public static String ADJUST = "003";
    }

    public static class ALLOCATION_DEAL{
        public static String PLT_SUMMARY = "L01";
        public static String PDRS = "L02";
        public static String OW_SPEC = "L03";
        public static String OW_PDRS = "L04";
        public static String OW_SP = "L05";
        public static String OW_COMM = "L06";
        public static String OW_STORE = "L07";
    }

    public static class STORE_DEAL{
        public static String OW_COMM = "L03";
        public static String OW_PDRS = "L04";
    }

    public static class RIGHT_DEAL{
        public static String OW_SPEC = "L03";
    }

    public static class STORE_LEVEL{
        public static String OW_SPEC = "L03";
        public static String OW_PDRS = "L04";
    }

    public static class ADJUSTMENT{
        public static String INBOUND = "A001";
        public static String OUTBOUND = "A002";
        public static String BUFFER = "A003";
        public static String LOAD = "A004";
    }

    public static class DEAL_TYPE{
        public static String PLUS = "1";
        public static String SUBTRACT = "2";
    }

    public static class NAME_INFO{
        public static String OWNER = "OWNER";
        public static String BUYER = "BUYER";
        public static String PART = "PART";
        public static String WAREHOUSE = "WAREHOUSE";
        public static String LOGICAREA = "LOGICAREA";
        public static String BRAND = "BRAND";
        public static String PRODUCER = "PRODUCER";
        public static String SUPPLIER = "SUPPLIER";
        public static String MANUFACTURER = "MANUFACTURER";
    }

    public static class NUMBER_GENERATE{
        public static String LOAD = "IV";
        public static String STORE = "ST";
        public static String VIRTUAL = "VT";
        public static String RIGHT = "RT";
        public static String ALLOCATION = "AL";
        public static String ADJUSTMENT = "ADO";
        public static String STOCKTAKING = "STO";
    }

    public static class FLAG{
        public static String TRUE = "1";
        public static String FALSE = "0";
    }
}
