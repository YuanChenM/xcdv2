package com.framework.number.generate.database.redis.properties;

import com.framework.exception.SystemException;

import java.io.Serializable;

/**
 * 连接Redis参数代理的类.<br/>
 * @author jiang_nan
 * @version 1.0
 */
public class RedisProperties implements Serializable{

    private RedisParam redisParam;
    private static RedisProperties redisProperties;

    private RedisProperties(RedisParam redisParam){
        this.redisParam = redisParam;
    }

    public static RedisProperties getRedisProperties(){
        if(redisProperties == null){
            throw new SystemException("Redis Properties不能为空");
        }
        return redisProperties;
    }
    public static void setRedisProperties(RedisParam redisParam){
        redisProperties = new RedisProperties(redisParam);
    }

    public RedisParam getRedisParam() {
        return redisParam;
    }
}
