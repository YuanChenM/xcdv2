package com.framework.cache;

import java.util.Map;

import com.framework.cache.bean.CacheEntity;
import com.framework.cache.bean.CacheRemoveEntity;
import com.framework.cache.listener.PutListenerImpl;
import com.framework.cache.listener.RemoveListenerImpl;
import com.framework.cache.map.LocalCache;

/**
 * 缓存Manager对象,所有的缓存操作必须使用该缓存.<br/>
 * 使用方法:<br/>
 * 设置缓存:<br/>
 * CacheManager cacheManager = CacheManager.getInstance().putListener();<br/>
 * cacheManager.put("aaa","aaaa");<br/>
 * 获得缓存:<br/>
 * CacheManager cacheManager = CacheManager.getInstance().putListener();<br/>
 * String value = (String)cacheManager.get("aaa");<br/>
 * 删除缓存:<br/>
 * CacheManager cacheManager = CacheManager.getInstance().putListener();<br/>
 * cacheManager.remove("aaa");
 * @author jiang_nan
 * @version 1.0
 */
public final class CacheManager {
    /**Cache Manager*/
    private static CacheManager cacheManager;
    /**默认缓存的有效时间为1年*/
    private final static long DEFAULT_VALIDITY_TIME = 365 * 24 * 60 * 60 * 1000;
    /**本地缓存对象*/
    private LocalCache localCache;
    /**Remove Listener*/
    private RemoveListener<String,Object> removeListener;
    /**Put Listener*/
    private PutListener<String,Object> putListener;

    /**
     * 默认构造函数
     */
    private CacheManager() {}

    /**
     * 获得Cache Manager对象
     * @return CacheManager
     */
    public static CacheManager getInstance() {
        if (cacheManager == null) {
            cacheManager = new CacheManager();
            cacheManager.localCache = new LocalCache();
        }
        return cacheManager;
    }

    /**
     * 添加Remove Listener
     * @return CacheManager
     */
    public CacheManager removeListener(){
        cacheManager.removeListener = new RemoveListenerImpl();
        return cacheManager;
    }

    /**
     * 添加自定义Remove Listener
     * @param removeListener 自定义Remove Listener
     * @return CacheManager
     */
    public CacheManager removeListener(RemoveListener<String,Object> removeListener){
        cacheManager.removeListener = removeListener;
        return cacheManager;
    }

    /**
     * 初始化Cache
     * @param initListener Init Listener
     */
    public void init(InitListener initListener){
        cacheManager.localCache.clean();
        Map<String,Object> dataMap = initListener.init();
        putAll(dataMap);
    }

    /**
     * Put Listener
     * @return CacheManager
     */
    public CacheManager putListener(){
        cacheManager.putListener = new PutListenerImpl();
        return cacheManager;
    }

    /**
     * 批量插入缓存数据
     * @param map 缓存数据
     */
    public void putAll(Map<String,Object> map){
        for(Map.Entry<String,Object> entry : map.entrySet()){
            this.put(entry.getKey(),entry.getValue());
        }
    }

    /**
     * 插入缓存数据
     * @param key 缓存Key
     * @param value 缓存Value
     */
    public void put(String key, Object value) {
        put(key,value,DEFAULT_VALIDITY_TIME);
    }

    /**
     * 插入缓存数据
     * @param key 缓存Key
     * @param value 缓存Value
     * @param milliSecond 时效(秒)
     */
    public void put(String key, Object value, long milliSecond){
        cacheManager.localCache.put(key,value,milliSecond);
        if(cacheManager.putListener != null){
            cacheManager.putListener.onPut(key,value);
        }
    }

    /**
     * 获得缓存对象
     * @param key 缓存Key
     * @return 缓存对象
     */
    public Object get(String key){
        CacheEntity<String,Object> cacheEntity = (CacheEntity<String,Object>)cacheManager.localCache.get(key);
        return cacheEntity.getValue();
    }

    /**
     * 手动删除缓存
     * @param key 缓存Key
     */
    public void remove(String key){
        Object value = cacheManager.get(key);
        cacheManager.localCache.remove(key);
        if(cacheManager.removeListener != null){
            CacheRemoveEntity<String,Object> removeEntity = new CacheRemoveEntity("手动删除",key,value);
            cacheManager.removeListener.onRemove(removeEntity);
        }
    }
}
