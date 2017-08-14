package com.framework.cache;

import java.util.Collection;
import java.util.Map;

/**
 * Cache接口定义,每一种不同的接口封装必须继承该接口.
 * @author jiang_nan
 * @version 1.0
 * @see com.framework.cache.map.LocalCache
 * @param <K> 缓存对应的Key
 * @param <V> 缓存对应的Value
 */
public interface Cache<K,V> {
    /**
     * 获取缓存数据
     * @param key 缓存Key
     * @return 缓存Value
     */
    V get(K key);

    /**
     * 新增缓存数据
     * @param key 缓存Key
     * @param value 缓存Value
     * @param milliSecond 缓存生命周期(毫秒)
     */
    void put(K key, V value,long milliSecond);

    /**
     * 新增多条数据
     * @param values 缓存Values
     */
    void putAll(Map<? extends K, ? extends V> values);

    /**
     * 获取缓存长度
     * @return 获得缓存对象列表
     */
    long size();

    /**
     * 清空缓存
     */
    void clean();

    /**
     * 移除缓存
     * @param key 缓存Key
     */
    void remove(K key);

    /**
     * 移除缓存集合
     * @param collection 缓存Key集合
     */
    void remove(Collection<? extends K> collection);

    /**
     * 判断缓存是否存在
     * @param key 缓存Key
     * @return 是否已经存在True,False
     */
    boolean containCache(K key);

}

