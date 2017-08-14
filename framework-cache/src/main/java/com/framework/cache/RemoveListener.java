package com.framework.cache;

import com.framework.cache.bean.CacheRemoveEntity;

/**
 * 删除缓存Listener
 * @author jiang_nan
 * @version 1.0
 * @see com.framework.cache.listener.RemoveListenerImpl
 * @param <K> 缓存Key
 * @param <V> 缓存Value
 */
public interface RemoveListener<K,V> {
    /**
     * 删除Cache监听器事件
     * @param removeEntity remove对象信息
     */
    void onRemove(CacheRemoveEntity<K,V> removeEntity);
}
