package com.framework.cache.bean;

import java.io.Serializable;

/**
 * 存储缓存对象
 * @author jiang_nan
 * @version 1.0
 */
public class CacheEntity<K, V> implements Serializable {
    /**默认过期时间 20秒*/
    private final int DEFAULT_VALIDITY_TIME = 20;
    /** 缓存Key */
    private K key;
    /** 缓存Value */
    private V value;
    /** 有效期时长，单位：秒 */
    private long validityTime;
    /** 创建时间 */
    private long createTime;

    /**
     * 默认构造函数<br/>
     * 设置默认有效时间为20秒<br/>
     * 过期时间戳为System.currentTimeMillis() + DEFUALT_VALIDITY_TIME * 1000
     */
    public CacheEntity() {
        this.createTime = System.currentTimeMillis();
        this.validityTime = DEFAULT_VALIDITY_TIME;
    }

    /**
     * 缓存构造函数,设置缓存Key和缓存Value
     * @param key 缓存Key
     * @param value 缓存Value
     */
    public CacheEntity(K key, V value) {
        this();
        this.key = key;
        this.value = value;
    }

    /**
     * 缓存构造函数,设置缓存Key缓存Value,有效时间
     * @param key 缓存Key
     * @param value 缓存Value
     * @param validityTime 有效时间
     */
    public CacheEntity(K key, V value, long validityTime) {
        this(key, value);
        this.validityTime = validityTime;
    }

    /**
     * 获得缓存Key
     * 
     * @return 缓存Key
     */
    public K getKey() {
        return key;
    }

    /**
     * 设置缓存Key
     * 
     * @param key 缓存Key
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * 获得缓存Value
     * 
     * @return 缓存Value
     */
    public V getValue() {
        return value;
    }

    /**
     * 设置缓存Value
     * 
     * @param value
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * 获得有效期时长，单位：秒
     * 
     * @return 有效期时长，单位：秒
     */
    public long getValidityTime() {
        return validityTime;
    }

    /**
     * 设置有效期时长，单位：秒
     * 
     * @param validityTime 有效期时长，单位：秒
     */
    public void setValidityTime(long validityTime) {
        this.validityTime = validityTime;
    }

    /**
     * 获得创建时间
     * 
     * @return 过期时间戳
     */
    public long getCreateTime() {
        return createTime;
    }

    /**
     * 是否过期
     * @return True:过期 False为不过期
     */
    public boolean isExpired() {
        boolean isExpired = System.currentTimeMillis() - getCreateTime() > getValidityTime();
        return isExpired;
    }

}
