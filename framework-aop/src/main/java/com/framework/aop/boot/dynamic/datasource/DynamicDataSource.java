package com.framework.aop.boot.dynamic.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author zhou_yajun
 * @version 1.0
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    protected Object determineCurrentLookupKey() {
        return DatabaseContextHolder.getCustomerType();
    }



}
