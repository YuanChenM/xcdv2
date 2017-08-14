package com.bms.linv.constant;

import com.framework.boot.plugin.configserver.ConfigServerPropertyLoad;

/**
 * Created by wang_fan on 2017/4/17.
 */
public class LinvApiUrlConstant {

    public static class SLPD{
        public static String CODE = ConfigServerPropertyLoad.getModelName("slpd-api");
        public static class URIS{
            public static String COMM_SEARCH = "api/classes/machinings/breeds/brands/items/properties/manufacturer/_find";
        }
    }

    public static class SLIM{
        public static String CODE = ConfigServerPropertyLoad.getModelName("slim-api");
        public static class URIS{
            public static String COMM_SEARCH = "api/sellers/entity/_find";
        }
    }

    public static class SLPC{
        public static String CODE = ConfigServerPropertyLoad.getModelName("slpd-api");
        public static class URIS{
            public static String COMM_SEARCH = "api/classes/machinings/breeds/brands/items/properties/producers/_find";
        }
    }

    public static class COMO{
        public static String CODE = ConfigServerPropertyLoad.getModelName("como-api");
        public static class URIS{
            public static String COMM_SEARCH = "api/commodity/salelist/_search";
            public static String COMM_INFO_SEARCH = "api/commodity/info/_search";
            public static String COMM_SALESTATUS_SEARCH = "api/commodity/saleStatus/_search";
        }
    }

    public static class AGIF{
        public static String AGIF = ConfigServerPropertyLoad.getModelName("agif-api");
        public static class URIS{
            public static String AGENT_SEARCH = "api/agent/relation/_search";
        }
    }

    public static class REGION{
        public static String REGION = ConfigServerPropertyLoad.getModelName("region-api");
        public static class URIS{
            public static String REGION_SEARCH = "api/region/logistics/_search";
        }
    }

    public static class WMS_SKU{
        public static String URL = "http://10.66.1.186:8080/ec-top-xcd/ws/stock?wsdl";
    }
}
