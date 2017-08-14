package com.framework.base.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.framework.base.properties.ConfigServerPropertyLoad;
import com.framework.mybatis.factory.MapperScannerConfigurerFactory;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.Servlet;

/**
 * <p>
 * 扫描Dao层 Configuration
 * </p>
 * 
 * @author zhangjian3
 * @version 1.0
 * @CreateDate 2016/10/24
 */
@Configuration
@AutoConfigureAfter(MybatisSpringConfig.class)
public class MybatisDaoConfig {

    @Bean(name = "mapperScannerConfigurer")
    public MapperScannerConfigurer mapperScannerConfigurer() {
        return MapperScannerConfigurerFactory.getMapperScannerConfigurer("mybatisSpring",
            ConfigServerPropertyLoad.getDaoBasePackagePath());
    }
}
