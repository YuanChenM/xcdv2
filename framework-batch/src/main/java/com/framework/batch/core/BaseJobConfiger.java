package com.framework.batch.core;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.job.builder.JobFlowBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * <p>作业(Job)配置接口。</p>
 *
 * @author xia_xiaojie
 * @date 2016/11/08
 * @version 1.0.0
 */
public abstract class BaseJobConfiger {
	private RunIdIncrementer runIdIncrementer = new RunIdIncrementer();
	
	@Autowired
	@Qualifier("jobBuilders")
	public JobBuilderFactory jobBuilderFactory;
	
	/**
	 * <p>配置作业拦截器。</p>
	 * 
	 * @return 作业拦截器
	 */
	public JobExecutionListener jobListener() {
		return new JobExecutionListenerSupport();
	}
	
	/**
	 * <p>构建作业。</p>
	 * 
	 * @param jobName 作业名称
	 * @param step 作业步
	 * @return 作业
	 */
	public Job buildJob(String jobName, Step step) {
		return jobBuilderFactory.get(this.rename(jobName))
                .incrementer(runIdIncrementer)
                .listener(this.jobListener())
                .flow(step)
                .end()
                .build();
	}

	/**
	 * <p>构建作业。</p>
	 * 
	 * @param jobName 作业名称
	 * @param steps 作业流
	 * @return 作业
	 */
	public Job buildJob(String jobName, List<Step> steps) {
		JobFlowBuilder jobFlowBuilder = jobBuilderFactory.get(this.rename(jobName))
				.incrementer(runIdIncrementer)
				.listener(this.jobListener())
				.flow(steps.get(0));

		for (int i = 1; i < steps.size(); i++) {
			jobFlowBuilder.next(steps.get(i));
		}
		return jobFlowBuilder.end().build();
	}
	
	/**
	 * <p>重新命名作业。</p>
	 * 
	 * @param jobName 作业名称
	 * @return 原作业名称追加六位随机数
	 */
	private String rename(String jobName) {
		if (null == jobName || jobName.trim().equals("")) {
			jobName = "JOB";
		}
		return jobName + (int) ((Math.random() * 9 + 1) * 100000);
	}

}
