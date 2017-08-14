package com.framework.cache.listener;

import com.framework.cache.RemoveListener;
import com.framework.cache.bean.CacheRemoveEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 默认缓存删除Listener
 * @author jiang_nan
 * @version 1.0
 */
public class RemoveListenerImpl implements RemoveListener<String,Object> {
    /**Logger*/
    private static Logger logger = LoggerFactory.getLogger(RemoveListenerImpl.class);
    /**
     * 删除Cache监听器事件
     *
     * @param removeEntity remove对象信息
     */
    @Override
    public void onRemove(CacheRemoveEntity<String, Object> removeEntity) {
        String removeType = removeEntity.getRemoveType();
        String key = removeEntity.getRemoveType();
        Object value = removeEntity.getValue();
        logger.info("删除数据类型:{},删除数据Key:{},删除数据Value:{}",removeType,key,value);
    }
}
