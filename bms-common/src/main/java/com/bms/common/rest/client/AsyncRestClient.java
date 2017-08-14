package com.bms.common.rest.client;

import com.alibaba.fastjson.TypeReference;
import com.framework.base.web.param.BaseWebPaginationParam;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRestTemplate;

import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

/**
 * 异步 Rest Template 客户端
 * 
 * @author li_huiqian
 *
 */
public class AsyncRestClient extends AbstractRestClient {

    private ListenableFuture<ResponseEntity<String>> future;
    private AsyncRestTemplate restTemplate;

    protected AsyncRestClient(int connectTimeout, int readTimeout, int asyncConnectTimeout, int asyncReadTimeout,String apiKey,String securityKey,AsyncRestTemplate restTemplate) {
        super(connectTimeout, readTimeout, asyncConnectTimeout, asyncReadTimeout,apiKey,securityKey);
        this.restTemplate = restTemplate;
    }

    /**
     * POST请求
     * <p>
     * Demo:<br>
     * <code>
     * AsyncRestClient client = RestClientFactory.newAsyncRestClient();<br>
     * client.asyncPost("http://localhost:8080/user/_find", param);<br>
     * // Other Code...<br>
     *  UserEntity entity = client.getAsyncResult(UserEntity.class);<br>
     * </code>
     * 
     * @param url
     *        请求的URL
     * @param requestEntity
     *        请求对象
     * @return
     */
    public<T extends Serializable> void asyncPost(String url, T requestEntity) {
        executePost(url, requestEntity,null,null);
    }
    /**
     * POST请求
     * <p>
     * Demo:<br>
     * <code>
     * AsyncRestClient client = RestClientFactory.newAsyncRestClient();<br>
     * client.asyncPost("http://localhost:8080/user/_find", param);<br>
     * // Other Code...<br>
     *  UserEntity entity = client.getAsyncResult(UserEntity.class);<br>
     * </code>
     *
     * @param url
     *        请求的URL
     * @param requestEntity
     *        请求对象
     * @return
     */
    public<T extends BaseWebPaginationParam> void asyncPost(String url, T requestEntity, String... showField) {
        executePost(url, requestEntity,showField);
    }

    /**
     * GET请求
     * <p>
     * Demo:<br>
     * <code>
     * AsyncRestClient client = RestClientFactory.newAsyncRestClient();<br>
     * HashMap<String, Object> map = new HashMap<>();<br>
     * map.put("id",100);<br>
     * client.asyncPost("http://localhost:8080/user/{id}", map);<br>
     * // Other Code...<br>
     *  UserEntity entity = client.getAsyncResult(UserEntity.class);<br>
     * </code>
     * 
     * @param url
     *        请求的URL
     * @param map
     *        请求对象
     * @return
     */
    public void asyncGet(String url, HashMap<String, Object> map) {
        executeGet(url, map);
    }

    /**
     * 获取异步请求结果
     * <p>
     * Demo:<br>
     * <code>
     * AsyncRestClient client = RestClientFactory.newAsyncRestClient();<br>
     * client.asyncPost("http://localhost:8080/user/_find", param);<br>
     * // Other Code...<br>
     *  UserEntity entity = client.getAsyncResult(UserEntity.class);<br>
     * </code>
     * 
     * @param typeReference
     * @return
     */
    public <T extends Serializable> T getAsyncResult(TypeReference<T> typeReference) {
        return getResult(typeReference);
    }

    @Override
    protected void executePost(String url, Object requestEntity,String[] showField,String... hideField) {
        future = restTemplate.postForEntity(url, createFormData(requestEntity, showField), String.class);
    }

    @Override
    protected void executeGet(String url, HashMap<String, Object> map) {
        /*AsyncRestTemplate restTemplate = getAsyncRestTemplate();*/
        future = restTemplate.getForEntity(url, String.class, map);
    }

    @Override
    protected <T extends Serializable> T getResult(TypeReference<T> typeReference) {

        ResponseEntity<String> response = null;
        try {
            response = future.get();
        } catch (InterruptedException e) {
            // TODO throw SystemException
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO throw SystemException
            e.printStackTrace();
        }

        return processResponse(response, typeReference);
    }

    public void setRestTemplate(AsyncRestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
