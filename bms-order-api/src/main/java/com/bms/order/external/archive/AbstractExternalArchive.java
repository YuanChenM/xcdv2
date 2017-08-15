package com.bms.order.external.archive;

import com.bms.common.rest.apiclient.AsyncApiRestClient;
import com.bms.common.rest.apiclient.RestApiClient;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.bms.order.util.ApplicationContextHelper;

/**
 * 抽象档案类
 * 
 * @author li_huiqian
 *
 */
public abstract class AbstractExternalArchive {

    /**
     * 数据是否同步
     */
    private boolean dataSynced;

    /**
     * 同步Rest Client
     */
    private RestApiClient restClient;

    /**
     * 异步Rest Client
     */
    private AsyncApiRestClient asyncRestClient;

    /**
     * 数据是否从数据源取出，true：是；false：不是
     * 
     * @return
     */
    public boolean isDataSynced() {
        return dataSynced;
    }

    /**
     * 设置数据是否从数据源取出
     * 
     * @param dataSynced
     */
    protected void setDataSynced(boolean dataSynced) {
        this.dataSynced = dataSynced;
    }

    /**
     * 获取同步RestClient
     * 
     * @return
     */
    protected RestApiClient getRestClient() {
        if (restClient != null)
            return restClient;
        restClient = ApplicationContextHelper.getBean(RestApiClientFactory.class).newApiRestClient();
        return restClient;
    }

    /**
     * 获取异步RestClient
     * 
     * @return
     */
    protected AsyncApiRestClient getAsyncRestClient() {
        if (asyncRestClient != null)
            return asyncRestClient;
        asyncRestClient = ApplicationContextHelper.getBean(RestApiClientFactory.class).newAsyncApiRestClient();
        return asyncRestClient;
    }


}
