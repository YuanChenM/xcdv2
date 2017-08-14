package com.msk.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BaseRedisDao {
    /** logger */
    private static Logger logger = LoggerFactory.getLogger(BaseRedisDao.class);

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public RedisTemplate<String, String> getRedisTemplate() {
        return redisTemplate;
    }

    /**
     * 获得Redis Map Value
     * @param key key
     * @return Redis Map Value
     */
    public Map<String,String> getRedisMapValue(final String key){
        logger.info("redis getRedisMapValue方法执行！");
        return redisTemplate.execute(new RedisCallback<Map<String,String>>() {
            public Map<String, String> doInRedis(RedisConnection redisConnection) throws DataAccessException {
                BoundHashOperations<String, String, String> boundHashOperations = redisTemplate.boundHashOps(key);
                Map<String, String> data = boundHashOperations.entries();
                return data;
            }
        });
    }

    /**
     *
     * @param key
     * @param redisMap
     */
    public void saveRedisMap(final String key,final Map<String,Object> redisMap){
        redisTemplate.execute(new RedisCallback<Void>() {
            @Override
            public Void doInRedis(RedisConnection redisConnection) throws DataAccessException {
                BoundHashOperations<String, String, Object> boundHashOperations = redisTemplate.boundHashOps(key);
                boundHashOperations.putAll(redisMap);
                return null;
            }
        });
    }

    /**
     * 设置Data Base
     * @param index Data Base Index
     */
    public void setDatabase(int index){
        JedisConnectionFactory connectionFactory = (JedisConnectionFactory)this.redisTemplate.getConnectionFactory();
        connectionFactory.setDatabase(index);
    }

    /**
     * 判断key是否存在
     *
     * @param key key
     * @return 结果
     * @author shi_yuxi
     */
    public boolean exist(final String key) {
        boolean result = ((Boolean) this.redisTemplate.execute(new RedisCallback() {
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer serializer = getRedisSerializer();
                byte[] byteKey = serializer.serialize(key);
                return connection.exists(byteKey);
            }
        })).booleanValue();
        return result;
    }

    /**
     * 向hash中插入一条数据
     *
     * @param key   key
     * @param field field
     * @param value value
     * @return 结果
     * @author shi_yuxi
     */
    public boolean saveRedisMapOne(final String key, final String field, final String value) {
        boolean result = ((Boolean) this.redisTemplate.execute(new RedisCallback() {
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer serializer = getRedisSerializer();
                byte[] byteKey = serializer.serialize(key);
                byte[] byteField = serializer.serialize(field);
                byte[] byteValue = serializer.serialize(value);
                return connection.hSet(byteKey, byteField, byteValue);
            }
        })).booleanValue();
        return result;
    }

    /**
     * 向hash中插入一条或多条数据
     *
     * @param key   key
     * @param fields fields
     * @return 结果
     * @author shi_yuxi
     */
    public long removeRedisMapItems(final String key, final String... fields) {
        long result = ((Long) this.redisTemplate.execute(new RedisCallback() {
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection)connection;
                return stringRedisConn.hDel(key,fields);
            }
        })).longValue();
        return result;
    }

    protected RedisSerializer<String> getRedisSerializer() {
        return redisTemplate.getStringSerializer();
    }

}
