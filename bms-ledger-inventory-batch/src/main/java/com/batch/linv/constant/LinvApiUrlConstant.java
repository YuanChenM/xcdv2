package com.batch.linv.constant;

import com.framework.boot.plugin.configserver.ConfigServerPropertyLoad;

/**
 * Created by duan_kai on 2017/2/15.
 */
public class LinvApiUrlConstant {

    public static class SLPD{
        public static String CODE = ConfigServerPropertyLoad.getModelName("slpd-api");
        public static class URIS{
            public static String COMM_SEARCH = "api/classes/machinings/breeds/brands/items/properties/manufacturer/_find";
        }
    }

    public static class COMO{
        public static String CODE = ConfigServerPropertyLoad.getModelName("como-api");
        public static class URIS{
            public static String COMM_SEARCH = "api/commodity/info/_search";
        }
    }

    public static class WMS_SKU{
        public static String URL = ConfigServerPropertyLoad.getProperty("Linv.interface.WMS_SKU");
    }

}
