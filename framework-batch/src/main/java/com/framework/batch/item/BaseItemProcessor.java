package com.framework.batch.item;

import org.springframework.batch.item.ItemProcessor;

/**
 * <p>Item处理接口。</p>
 *
 * @author xia_xiaojie
 * @date 2016/11/08
 * @version 1.0.0
 */
public interface BaseItemProcessor<I, O> extends ItemProcessor<I, O> {

}
