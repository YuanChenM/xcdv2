package com.framework.batch.item;

import org.springframework.batch.item.file.transform.LineAggregator;

/**
 * <p>行聚合器接口，定义了将Item对象转换为Object数组，再将Object数组转换为字符串，即Flat文件的一条文本记录。</p>
 *
 * @author xia_xiaojie
 * @date 2016/11/09
 * @version 1.0.0
 */
public interface BaseLineAggregator<O> extends LineAggregator<O> {
	
}
