package com.framework.batch.core.support;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.BatchConfigurationException;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.explore.support.JobExplorerFactoryBean;
import org.springframework.batch.core.explore.support.MapJobExplorerFactoryBean;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.framework.batch.core.BaseBatchConfiger;

/**
 * <p>批处理配置，包含JobRepository、JobLauncher、JobExplorer、DataSource和TransactionManager的配置。</p>
 *
 * @author xia_xiaojie
 * @date 2016/11/08
 * @version 1.0.0
 */
@Configuration
public class SimpleBatchConfiger implements BaseBatchConfiger {
	private static final Logger logger = LoggerFactory.getLogger(SimpleBatchConfiger.class);
	private DataSource dataSource;
	private PlatformTransactionManager transactionManager;
	private JobRepository jobRepository;
	private JobLauncher jobLauncher;
	private JobExplorer jobExplorer;

	@Autowired
	@Qualifier("dataSource")
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.transactionManager = new DataSourceTransactionManager(dataSource);
	}

	protected SimpleBatchConfiger() {
	}

	public SimpleBatchConfiger(DataSource dataSource) {
		setDataSource(dataSource);
	}

	public JobRepository getJobRepository() {
		return this.jobRepository;
	}

	public PlatformTransactionManager getTransactionManager() {
		return this.transactionManager;
	}

	public JobLauncher getJobLauncher() {
		return this.jobLauncher;
	}

	public JobExplorer getJobExplorer() {
		return this.jobExplorer;
	}

	@PostConstruct
	public void initialize() {
		try {
			//配置Memory Job Repository
			if (this.dataSource == null) {
				logger.warn("No datasource was provided...using a Map based JobRepository");
				if (this.transactionManager == null) {
					this.transactionManager = new ResourcelessTransactionManager();
				}

				MapJobRepositoryFactoryBean jobRepositoryFactory = new MapJobRepositoryFactoryBean(this.transactionManager);
				jobRepositoryFactory.afterPropertiesSet();
				this.jobRepository = jobRepositoryFactory.getObject();

				MapJobExplorerFactoryBean jobExplorerFactory = new MapJobExplorerFactoryBean(jobRepositoryFactory);
				jobExplorerFactory.afterPropertiesSet();
				this.jobExplorer = jobExplorerFactory.getObject();
			}
			//配置DB Job Repository
			else {
				this.jobRepository = createJobRepository();

				JobExplorerFactoryBean jobExplorerFactoryBean = new JobExplorerFactoryBean();
				jobExplorerFactoryBean.setDataSource(this.dataSource);
				jobExplorerFactoryBean.afterPropertiesSet();
				this.jobExplorer = jobExplorerFactoryBean.getObject();
			}
			this.jobLauncher = createJobLauncher();
		}
		catch (Exception e) {
			throw new BatchConfigurationException(e);
		}
	}

	protected JobLauncher createJobLauncher() throws Exception {
		SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
		jobLauncher.setJobRepository(this.jobRepository);
		jobLauncher.afterPropertiesSet();
		return jobLauncher;
	}

	protected JobRepository createJobRepository() throws Exception {
		JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
		factory.setDataSource(this.dataSource);
		factory.setTransactionManager(this.transactionManager);
		factory.afterPropertiesSet();
		return factory.getObject();
	}

}
