package com.framework.batch.core;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.listener.ChunkListenerSupport;
import org.springframework.batch.core.listener.ItemListenerSupport;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.retry.listener.RetryListenerSupport;

import com.framework.batch.constant.BatchConstant;

/**
 * <p>作业块(Chunk)配置接口。</p>
 *
 * @author xia_xiaojie
 * @date 2016/11/07
 * @version 1.0.0
 */
public abstract class BaseChunkConfiger<I, O> {
	
	/**
	 * <p>提交间隔，读、处理指定条数的数据后，通过writer一次性批量写入，并提交事务。</p>
	 * 
	 * @return 提交间隔
	 */
	public int commitInterval() {
		return BatchConstant.Chunks.COMMIT_INTERVAL;
	};

	/**
	 * <p>读数据的对象。</p>
	 * 
	 * @return ItemReader子对象
	 */
	public abstract ItemReader<I> reader();

	/**
	 * <p>处理数据的对象。</p>
	 * 
	 * @return ItemProcessor子对象
	 */
	public abstract ItemProcessor<I, O> processor();

	/**
	 * <p>写数据的对象。</p>
	 * 
	 * @return ItemWriter子对象
	 */
	public abstract ItemWriter<O> writer();

	/**
	 * <p>是否从一个事务性的队列读取数据，</p>
	 * <p>true表示从一个事务性的队列中读取数据，一旦发生异常会导致事务回滚，从队列中读取的数据同样会被重新放回到队列中；</p>
	 * <p>false表示从一个没有事务的队列获取数据，一旦发生异常会导致事务回滚，消费掉的数据不会重新放回到队列中。</p>
	 * <p>需要注意：如果将reader-transactional-queue设置为true，则processor-transactional必须设置为true。</p>
	 * 
	 * @return 读事务标识
	 */
	public boolean readerTransactionalQueue() {
		return false;
	}
	
	/**
	 * <p>处理数据是否在事务中，</p>
	 * <p>true表示将processor处理的结果放在缓存中，当执行重试或者跳过策略时，可以看到缓存中处理的数据；</p>
	 * <p>false表示不会将processor处理的结果放在缓存中，即processor在chunk的每一条记录仅会执行一次。</p>
	 * <p>需要注意：如果将reader-transactional-queue设置为true，则processor-transactional必须设置为true。</p>
	 * 
	 * @return 处理事务标识
	 */
	public boolean processorTransactional() {
		return false;
	}
	
	/**
	 * <p>是否容错，true表示允许skip/retry操作，false表示不允许。</p>
	 * 
	 * @return 容错标识
	 */
	public boolean faultTolerant() {
		return true;
	}
	
	/**
	 * <p>重试Step的最大次数。</p>
	 * 
	 * @return 重试次数
	 */
	public int retryLimit() {
		return BatchConstant.Chunks.RETRY_LIMIT;
	}
	
	/**
	 * <p>定义可以重试的异常，如果发生了定义的异常或者子类异常都会重试Step。</p>
	 * 
	 * @return 异常数组
	 */
	@SuppressWarnings("rawtypes")
	public Class[] retryableExceptionClasses() {
		return new Class[] { Exception.class };
	}
	
	/**
	 * <p>定义不可以重试的异常，如果发生了定义的异常或者子类异常都不会重试Step。</p>
	 * 
	 * @return 异常数组
	 */
	@SuppressWarnings("rawtypes")
	public Class[] nonRetryableExceptionClasses() {
		return new Class[] {};
	}
	
	/**
	 * <p>是否开启拦截器链，true表示开启，false表示关闭。</p>
	 * 
	 * @return 拦截器链标识
	 */
	public boolean enableListeners() {
		return false;
	}
	
	/**
	 * <p>配置拦截器链。</p>
	 * <pre>
	 * 需要注意：重写此方法可以自定义拦截器链，配置顺序从上到下依次为step、tasklet、chunk、item(read、process、write)、skip、retry，只需加入需要用到的拦截器;
	 *          重写enableListeners()方法，开启拦截器链。
	 * </pre>
	 * 
	 * @return 拦截器集合
	 */
	public List<Object> listenerChain() {
		List<Object> listeners = new ArrayList<Object>();
		listeners.add(new StepExecutionListenerSupport());
		listeners.add(new ChunkListenerSupport());
		listeners.add(new ItemListenerSupport<I, O>());
		listeners.add(new RetryListenerSupport());
		return listeners;
	}
	
}
