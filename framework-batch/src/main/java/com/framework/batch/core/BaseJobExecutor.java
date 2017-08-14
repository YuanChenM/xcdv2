package com.framework.batch.core;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * <p>作业执行器接口。</p>
 *
 * @author xia_xiaojie
 * @date 2016/11/08
 * @version 1.0.0
 */
public abstract class BaseJobExecutor {
	@Autowired
	@Qualifier("jobLauncher")
	private JobLauncher jobLauncher;

	/**
	 * <p>执行作业。</p>
	 * 
	 * @param job 作业
	 * @param jobParameters 作业参数
	 * @return 作业执行的句柄
	 * @throws Exception 作业异常
	 */
	public JobExecution execute(Job job, JobParameters jobParameters) throws Exception {
		return jobLauncher.run(job, jobParameters);
	}
	
	/**
	 * <p>执行作业。</p>
	 * 
	 * @param job 作业
	 * @return 作业执行的句柄
	 * @throws Exception 作业异常
	 */
	public JobExecution execute(Job job) throws Exception {
		JobParameters jobParameters = new JobParametersBuilder()
				.addDate("date", new Date())
	    		.toJobParameters();
		return jobLauncher.run(job, jobParameters);
	}

}
