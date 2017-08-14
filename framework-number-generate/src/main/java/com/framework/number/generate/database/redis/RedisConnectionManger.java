package com.framework.number.generate.database.redis;

import com.framework.number.generate.database.redis.properties.RedisParam;
import com.framework.number.generate.database.redis.properties.RedisProperties;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by jackjiang on 16/11/21.
 */
public final class RedisConnectionManger {
    private JedisPool jedisPool;

    public RedisConnectionManger() {
        this.init();
    }

    private void init() {
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        RedisProperties redisProperties = RedisProperties.getRedisProperties();
        RedisParam redisParam = redisProperties.getRedisParam();
        String host = redisParam.getHost();
        int port = redisParam.getPort();
        int timeout = redisParam.getTimeout();
        String password = redisParam.getPassword();
        int database = redisParam.getDatabase();
        jedisPool = new JedisPool(poolConfig, host, port, timeout, password, database);
    }
    public Jedis getJedis(){
        return jedisPool.getResource();
    }

}
