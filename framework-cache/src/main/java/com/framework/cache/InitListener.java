package com.framework.cache;

import java.util.Map;

/**
 * 初始化数据监听
 * @author jiang_nan
 * @version 1.0
 */
public interface InitListener{
    /**
     * 初始化操作
     * @return 初始化数据
     */
    Map<String,Object> init();
}
