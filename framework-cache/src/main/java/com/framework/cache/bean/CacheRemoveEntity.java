package com.framework.cache.bean;

import java.io.Serializable;

/**
 * 缓存删除,监听器需要的Entity.
 * @author jiang_nan
 * @version 1.0
 * @param <K> Cache Key
 * @param <V> Cache Value
 */
public class CacheRemoveEntity<K,V> implements Serializable{
    /**Remove 类型*/
    private String removeType;
    /**Remove Key*/
    private K key;
    /**Remove Value*/
    private V value;

    /**
     * 默认构造函数
     */
    public CacheRemoveEntity(){

    }

    /**
     * 构造函数,设置Remove Type,Key,Value
     * @param removeType remove Type
     * @param key key
     * @param value value
     */
    public CacheRemoveEntity(String removeType, K key, V value) {
        this.removeType = removeType;
        this.key = key;
        this.value = value;
    }

    /**
     * 获得Remove 类型
     * @return Remove 类型
     */
    public String getRemoveType() {
        return removeType;
    }

    /**
     * 设置Remove 类型
     * @param removeType Remove 类型
     */
    public void setRemoveType(String removeType) {
        this.removeType = removeType;
    }

    /**
     * 获得删除的Cache Key
     * @return Cache Key
     */
    public K getKey() {
        return key;
    }

    /**
     * 设置删除的Cache Key
     * @param key 删除的Cache Key
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * 获得Cache Value
     * @return Cache Value
     */
    public V getValue() {
        return value;
    }

    /**
     * 设置Cache value
     * @param value Cache value
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * 返回对象的字符串.
     * @return 对象的字符串.
     */
    @Override
    public String toString() {
        return "Cache Remove Type "+this.removeType + " Remove Key:"+this.key + "Remove Value:"+this.value;
    }
}
