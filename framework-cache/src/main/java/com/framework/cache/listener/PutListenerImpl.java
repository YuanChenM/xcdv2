package com.framework.cache.listener;

import com.framework.cache.PutListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 默认添加缓存Listener
 * @author jiang_nan
 * @version 1.0
 */
public class PutListenerImpl implements PutListener<String,Object>{
    private static Logger logger = LoggerFactory.getLogger(PutListenerImpl.class);

    @Override
    public void onPut(String key, Object value) {
        logger.info("本次添加的数据Key:{},数据值:{}",new Object[]{key,value.toString()});
    }
}
