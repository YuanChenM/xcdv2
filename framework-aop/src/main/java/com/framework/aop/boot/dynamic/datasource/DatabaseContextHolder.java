package com.framework.aop.boot.dynamic.datasource;

import java.util.HashMap;
import java.util.Map;

/**
 * 动态数据源
 *
 * @author zhou_yajun
 * @version 1.0
 */
public class DatabaseContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal();

    public static final String MASTER_DATA_SOURCE = "masterDataSource";

    public static final String SLAVE_DATA_SOURCE = "slaveDataSource";

    private DatabaseContextHolder() {
    }

    public static void setCustomerType(String customerType) {
        contextHolder.set(customerType);
    }

    public static String getCustomerType() {
        return (String) contextHolder.get();
    }

    public static void clearCustomerType() {
        contextHolder.remove();
    }
}
