package com.framework.mybatis.factory;

import com.framework.mybatis.bean.MybatisSpringFactoryProperties;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * @Author zhou_yajun.
 * @Version 1.0
 */
public class MyBatisSpringSqlSessionFactory {

    /**
     * springBoot mybatis <br/>
     * Demo:<br/>
     * MyBatisSpringSqlSessionFactory mybatisSpringSqlSessionFactory = new MyBatisSpringSqlSessionFactory();<br/>
     * MybatisSpringFactoryProperties mybatisSpringFactoryProperties = new MybatisSpringFactoryProperties();<br/>
     * SqlSessionFactory sqlSessionFactory = mybatisSpringSqlSessionFactory.getMybatisSpringSqlSessionFactory(mybatisSpringFactoryProperties);<br/>
     * @param mybatisSpringFactoryProperties
     * @return
     */
    public SqlSessionFactory getMybatisSpringSqlSessionFactory(MybatisSpringFactoryProperties mybatisSpringFactoryProperties){

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(mybatisSpringFactoryProperties.getDataSource());

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            sqlSessionFactoryBean.setConfigLocation(resolver.getResource(mybatisSpringFactoryProperties.getConfigPath()));
            sqlSessionFactoryBean.setMapperLocations(resolver.getResources(mybatisSpringFactoryProperties.getSqlMapPath()));
            return sqlSessionFactoryBean.getObject();
        }catch (Exception var4){
            var4.printStackTrace();
            throw new RuntimeException(var4);
        }
    }
}
