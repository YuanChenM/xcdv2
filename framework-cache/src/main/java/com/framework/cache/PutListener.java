package com.framework.cache;

/**
 * 添加缓存数据Listener
 * @author jiang_nan
 * @version 1.0
 * @see com.framework.cache.listener.PutListenerImpl
 * @param <K> 缓存Key
 * @param <V> 缓存Value
 */
public interface PutListener<K,V> {
    /**
     * 缓存添加监听事件
     * @param key 缓存Key
     * @param value 缓存Value
     */
    void onPut(K key,V value);
}
