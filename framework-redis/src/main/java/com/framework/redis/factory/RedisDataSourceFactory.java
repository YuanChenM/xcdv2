package com.framework.redis.factory;

import com.framework.redis.config.RedisDataSourceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by mao_yejun on 2016/10/28.
 */
@Configuration
public class RedisDataSourceFactory {
    @Autowired
    private RedisDataSourceProperties redisDataSourceProperties;

    @Bean (name = "redisTemplate")
    public RedisTemplate<String, String> getRedisTemplate() {
        StringRedisTemplate redisTemplate = new StringRedisTemplate();
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        connectionFactory.setHostName(redisDataSourceProperties.getHost());
        connectionFactory.setPort(redisDataSourceProperties.getPort());
        connectionFactory.setPassword(redisDataSourceProperties.getPass());
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(redisDataSourceProperties.getMaxIdle());
        config.setMaxWaitMillis(redisDataSourceProperties.getMaxWaitMillis());
        config.setMaxTotal(redisDataSourceProperties.getMaxTotal());
        connectionFactory.setPoolConfig(config);
        connectionFactory.setDatabase(redisDataSourceProperties.getDbIndex());
        connectionFactory.afterPropertiesSet();
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }
}
