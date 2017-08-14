package com.framework.batch.item.support;

import com.framework.batch.item.BaseItemProcessor;

/**
 * <p>直接将Reader读到的对象，传递给Writer，不进行任何中间处理。</p>
 *
 * @author xia_xiaojie
 * @date 2016/11/08
 * @version 1.0.0
 */
public class SimpleItemProcessor<I, O> implements BaseItemProcessor<I, O> {

	@SuppressWarnings("unchecked")
	@Override
	public O process(I item) throws Exception {
		return (O) item;
	}

}
