package com.framework.base.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.framework.base.properties.MyBatisProperties;
import com.framework.mybatis.bean.MybatisSpringFactoryProperties;
import com.framework.mybatis.factory.MyBatisSpringSqlSessionFactory;

/**
 * <p>
 * 加载Mybatis sqlSessionFactory层 Configuration
 * </p>
 *
 * @author zhangjian3
 * @version 1.0
 * @CreateDate 2016/10/25
 */
@AutoConfigureAfter(DynamicDataSourceConfig.class)
@Configuration
@EnableConfigurationProperties(MyBatisProperties.class)
public class MybatisSpringConfig {
    @Autowired
    private DynamicDataSourceConfig transactionalDataSourceConfig;

    @Autowired
    private MyBatisProperties myBatisProperties;

    /**
     * <p>
     * 加载beanName=mybatisSpring
     * </p>
     *
     * @return sqlSessionFactory
     */
    @Bean(name = "mybatisSpring")
    public SqlSessionFactory sqlSessionFactory() {
        MybatisSpringFactoryProperties mybatisSpringFactoryProperties = new MybatisSpringFactoryProperties();
        DataSource dataSource = this.transactionalDataSourceConfig.dynamicDataSource();
        mybatisSpringFactoryProperties.setDataSource(dataSource);
        mybatisSpringFactoryProperties.setConfigPath(myBatisProperties.getConfigPath());
        mybatisSpringFactoryProperties.setSqlMapPath(myBatisProperties.getMapperLocations());
        return MyBatisSpringSqlSessionFactory.getMybatisSpringSqlSessionFactory(mybatisSpringFactoryProperties);
    }
}
