package com.framework.batch.core;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.BatchConfigurer;

/**
 * <p>批处理配置接口，包含JobRepository、JobLauncher、JobExplorer、DataSource和TransactionManager的配置。</p>
 *
 * @author xia_xiaojie
 * @date 2016/11/08
 * @version 1.0.0
 */
public interface BaseBatchConfiger extends BatchConfigurer {
	
	/**
	 * <p>配置数据源。</p>
	 * 
	 * @param dataSource 数据源
	 */
	void setDataSource(DataSource dataSource);
	
}
