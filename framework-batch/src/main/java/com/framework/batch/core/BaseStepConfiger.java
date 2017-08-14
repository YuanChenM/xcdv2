package com.framework.batch.core;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.builder.FaultTolerantStepBuilder;
import org.springframework.batch.core.step.builder.SimpleStepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.framework.batch.core.listener.BaseChunkListener;
import com.framework.batch.core.listener.BaseItemProcessListener;
import com.framework.batch.core.listener.BaseItemReadListener;
import com.framework.batch.core.listener.BaseItemWriteListener;
import com.framework.batch.core.listener.BaseRetryListener;
import com.framework.batch.core.listener.BaseStepListener;

/**
 * <p>作业步(Step)配置接口。</p>
 *
 * @author xia_xiaojie
 * @date 2016/11/07
 * @version 1.0.0
 */
public abstract class BaseStepConfiger<I, O> {
	@Autowired
	@Qualifier("stepBuilders")
	public StepBuilderFactory stepBuilderFactory;
	
	/**
	 * <p>构建作业流。</p>
	 * 
	 * @return 作业步集合
	 */
	public List<Step> buildFlow() {
		return new ArrayList<Step>();
	}

	/**
	 * <p>构建作业步。</p>
	 * 
	 * @param stepName 作业步名称
	 * @param chunk 作业块
	 * @return 作业步 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Step buildStep(String stepName, BaseChunkConfiger<I, O> chunk) {
		//获得StepBuilder
		SimpleStepBuilder<I, O> simpleStepBuilder =  stepBuilderFactory.get(this.rename(stepName))
				.<I, O> chunk(chunk.commitInterval())
				.reader(chunk.reader())
				.processor(chunk.processor())
				.writer(chunk.writer());

		//是否开启拦截器链
		BaseChunkListener chunkListener = null;
		BaseRetryListener retryListener = null;
		if (chunk.enableListeners()) {
			for (Object listener : chunk.listenerChain()) {
				if (listener instanceof BaseStepListener) {
					simpleStepBuilder.listener((BaseStepListener) listener);
				}
				else if (listener instanceof BaseChunkListener) {
					chunkListener = (BaseChunkListener) listener;
				}
				else if (listener instanceof BaseItemReadListener) {
					simpleStepBuilder.listener((BaseItemReadListener) listener);
				}
				else if (listener instanceof BaseItemProcessListener) {
					simpleStepBuilder.listener((BaseItemProcessListener) listener);
				}
				else if (listener instanceof BaseItemWriteListener) {
					simpleStepBuilder.listener((BaseItemWriteListener) listener);
				}
				else if (listener instanceof BaseRetryListener) {
					retryListener = (BaseRetryListener) listener;
				}
			}
		}
		
		//是否开启读、处理事务
		boolean pnt = false;
		if (chunk.readerTransactionalQueue()) {
			simpleStepBuilder.readerIsTransactionalQueue();
		}
		else if (!chunk.processorTransactional()) {
			pnt = !chunk.processorTransactional();
		}
		
		//是否允许容错，即异常跳过(skip)/Step重试(retry)
		if (chunk.faultTolerant()) {
			FaultTolerantStepBuilder<I, O> lerantStepBuilder = simpleStepBuilder.faultTolerant();
			if (pnt) {
				lerantStepBuilder.processorNonTransactional();
			}
			if (null != chunkListener) {
				lerantStepBuilder.listener(chunkListener);
			}
			
			//Step重试
			if (null != retryListener) {
				lerantStepBuilder.listener(retryListener);
			}
			lerantStepBuilder = lerantStepBuilder.retryLimit(chunk.retryLimit());
			for (Class exceptionClass : chunk.retryableExceptionClasses()) {
				lerantStepBuilder.retry(exceptionClass);
			}
			for (Class exceptionClass : chunk.nonRetryableExceptionClasses()) {
				lerantStepBuilder.noRetry(exceptionClass);
			}
			simpleStepBuilder = lerantStepBuilder;	
		}
		
		//生成作业步
		return simpleStepBuilder.build();
	}
	
	/**
	 * <p>重新命名作业步。</p>
	 * 
	 * @param stepName 作业步名称
	 * @return 原作业步名称追加六位随机数
	 */
	private String rename(String stepName) {
		if (null == stepName || stepName.trim().equals("")) {
			stepName = "STEP";
		}
		return stepName + (int) ((Math.random() * 9 + 1) * 100000);
	}

}
