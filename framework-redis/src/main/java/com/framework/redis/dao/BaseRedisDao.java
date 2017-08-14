package com.framework.redis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by mao_yejun on 2016/10/28.
 */
@Component
public class BaseRedisDao {
    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate<String, String> redisTemplate;

    public BaseRedisDao() {
    }

    /**
     * 根据表名获得主键
     *
     * @param tableName 表名
     * @param step      长度
     * @return
     */
    public Long getTablePrimaryKe(final String tableName, final int step) {
        long result = ((Long) this.redisTemplate.execute(new RedisCallback() {
            public Object doInRedis(RedisConnection connection) {
                RedisSerializer serializer = BaseRedisDao.this.getRedisSerializer();
                byte[] byteKey = serializer.serialize(tableName.toUpperCase());
                Boolean flag = connection.exists(byteKey);
                if (!flag.booleanValue()) {
                    byte[] byteValue = serializer.serialize("99999");
                    connection.set(byteKey, byteValue);
                }

                return connection.incrBy(byteKey, (long) step);
            }
        })).longValue();
        return Long.valueOf(result);
    }

    /**
     * Redis Save
     *
     * @param key   Redis key
     * @param value Redis value
     * @return true保存成功false保存失败
     */
    public boolean save(final String key, final String value) {
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection) {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] byteKey = serializer.serialize(key);
                byte[] byteValue = serializer.serialize(value);
                return connection.setNX(byteKey, byteValue);
            }
        });
        return result;
    }

    /**
     * 根据Redis Key删除Redis value
     *
     * @param key Redis Key
     */
    public void delete(String key) {
        List<String> list = new ArrayList<String>();
        list.add(key);
        delete(list);
    }

    /**
     * 根据Redis Key List删除多个Redis value
     *
     * @param keys Redis Key List
     */
    public void delete(List<String> keys) {
        redisTemplate.delete(keys);
    }

    /**
     * 修改Redis Value
     *
     * @param key   Redis key
     * @param value Redis Value
     * @return true修改成功false修改失败
     */
    public boolean update(final String key, final String value) {
        if (get(key) == null) {
            throw new RuntimeException("数据行不存在, key = " + key);
        }
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection) {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] byteKey = serializer.serialize(key);
                byte[] byteName = serializer.serialize(value);
                connection.set(byteKey, byteName);
                return true;
            }
        });
        return result;
    }

    /**
     * 通过key获取Redis Value
     *
     * @param key Redis Key
     * @return Redis Value
     */
    public String get(final String key) {
        String result = redisTemplate.execute(new RedisCallback<String>() {
            public String doInRedis(RedisConnection connection) {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] byteKey = serializer.serialize(key);
                byte[] byteValue = connection.get(byteKey);
                if (byteValue == null) {
                    return null;
                }
                String value = serializer.deserialize(byteValue);
                return value;
            }
        });
        return result;
    }

    /**
     * 获得Redis Map Value
     *
     * @param key key
     * @return Redis Map Value
     */
    public Map<String, String> getRedisMapValue(final String key) {
        return redisTemplate.execute(new RedisCallback<Map<String, String>>() {
            public Map<String, String> doInRedis(RedisConnection redisConnection) {
                BoundHashOperations<String, String, String> boundHashOperations = redisTemplate.boundHashOps(key);
                Map<String, String> data = boundHashOperations.entries();
                return data;
            }
        });
    }

    /**
     * @param key
     * @param redisMap
     */
    public void saveRedisMap(final String key, final Map<String, Object> redisMap) {
        redisTemplate.execute(new RedisCallback<Void>() {
            @Override
            public Void doInRedis(RedisConnection redisConnection) {
                BoundHashOperations<String, String, Object> boundHashOperations = redisTemplate.boundHashOps(key);
                boundHashOperations.putAll(redisMap);
                return null;
            }
        });
    }

    /**
     * 获取 RedisSerializer
     */
    protected RedisSerializer<String> getRedisSerializer() {
        return redisTemplate.getStringSerializer();
    }


    /**
     * 集合新增
     *
     * @param key
     * @param values
     */
    public long sadd(final String key, final String values) {
        long result = ((Long) redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection) {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] byteKey = serializer.serialize(key);
                byte[] byteValue = serializer.serialize(values);
                return connection.sAdd(byteKey, byteValue);
            }
        })).longValue();
        return result;
    }

    /**
     * 集合排序查询
     *
     * @param key
     */
    public List<String> sort(final String key) {

        List<String> result = redisTemplate.execute(new RedisCallback<List<String>>() {
            public List<String> doInRedis(RedisConnection connection) {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] byteKey = serializer.serialize(key);
                Set<byte[]> list = connection.sMembers(byteKey);
                List<String> result = new ArrayList<String>();
                for (byte[] b : list) {
                    result.add(serializer.deserialize(b));
                }
                Collections.sort(result);
                return result;
            }
        });
        return result;
    }

    /**
     * 移除集合中元素
     *
     * @param key
     * @param values
     */
    public long srem(final String key, final String values) {
        long result = ((Long) redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection) {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] byteKey = serializer.serialize(key);
                byte[] byteValue = serializer.serialize(values);
                return connection.sRem(byteKey, byteValue);
            }
        })).longValue();
        return result;
    }

    /**
     * 计数器
     *
     * @param key  key
     * @param step step
     * @return 结果
     * @author mao_yejun
     */
    public long increment(final String key, final long step) {
        long result = ((long) this.redisTemplate.execute(new RedisCallback() {
            public Object doInRedis(RedisConnection connection) {
                RedisSerializer serializer = getRedisSerializer();
                byte[] byteKey = serializer.serialize(key);
                return connection.incrBy(byteKey, step);
            }
        }));
        return result;
    }


    /**
     * 判断key是否存在
     *
     * @param key key
     * @return 结果
     * @author mao_yejun
     */
    public boolean exist(final String key) {
        boolean result = ((Boolean) this.redisTemplate.execute(new RedisCallback() {
            public Boolean doInRedis(RedisConnection connection) {
                RedisSerializer serializer = getRedisSerializer();
                byte[] byteKey = serializer.serialize(key);
                return connection.exists(byteKey);
            }
        })).booleanValue();
        return result;
    }


    /**
     * 将一个或多个值 value 插入到列表 key 的表尾(最右边)。
     *
     * @param key key
     * @return 结果
     * @author mao_yejun
     */
    public long rpush(final String key, final String value) {
        long result = ((Long) this.redisTemplate.execute(new RedisCallback() {
            public Long doInRedis(RedisConnection connection) {
                RedisSerializer serializer = getRedisSerializer();
                byte[] byteKey = serializer.serialize(key);
                byte[] byteValue = serializer.serialize(value);
                return connection.rPush(byteKey, byteValue);
            }
        })).longValue();
        return result;
    }


    /**
     * 从list中移除
     *
     * @param key    key
     * @param values values
     * @return 结果
     * @author mao_yejun
     */
    public long rpop(final String key, final String values) {
        long result = ((Long) this.redisTemplate.execute(new RedisCallback() {
            public Long doInRedis(RedisConnection connection) {
                RedisSerializer serializer = getRedisSerializer();
                byte[] byteKey = serializer.serialize(key);
                byte[] byteValue = serializer.serialize(values);
                return connection.lRem(byteKey, 0, byteValue);
            }
        })).longValue();
        return result;
    }

    /**
     * 查询list集合
     *
     * @param key key
     * @return 结果
     * @author mao_yejun
     */
    public List<String> getList(final String key) {
        List<String> result = ((List<String>) this.redisTemplate.execute(new RedisCallback() {
            public List<String> doInRedis(RedisConnection connection) {
                RedisSerializer serializer = getRedisSerializer();
                byte[] byteKey = serializer.serialize(key);
                List<String> resultList = new ArrayList<String>();
                List<byte[]> list = connection.lRange(byteKey, 0, 1);
                for (byte[] b : list) {
                    resultList.add((String) serializer.deserialize(b));
                }
                return resultList;
            }
        }));
        return result;
    }

    /**
     * 查询数据type
     *
     * @param key key
     * @return 结果
     * @author mao_yejun
     */
    public DataType getType(final String key) {
        DataType result = (DataType) this.redisTemplate.execute(new RedisCallback() {
            public DataType doInRedis(RedisConnection connection) {
                RedisSerializer serializer = getRedisSerializer();
                byte[] byteKey = serializer.serialize(key);
                return connection.type(byteKey);
            }
        });
        return result;
    }

    /**
     * 向hash中插入一条数据
     *
     * @param key   key
     * @param field field
     * @param value value
     * @return 结果
     * @author mao_yejun
     */
    public boolean saveRedisMapOne(final String key, final String field, final String value) {
        boolean result = ((Boolean) this.redisTemplate.execute(new RedisCallback() {
            public Boolean doInRedis(RedisConnection connection) {
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
     * @param key    key
     * @param fields fields
     * @return 结果
     * @author mao_yejun
     */
    public long removeRedisMapItems(final String key, final String... fields) {
        long result = ((Long) this.redisTemplate.execute(new RedisCallback() {
            public Long doInRedis(RedisConnection connection) {
                StringRedisConnection stringRedisConn = (StringRedisConnection) connection;
                return stringRedisConn.hDel(key, fields);
            }
        })).longValue();
        return result;
    }

    /**
     * 清空当前db
     *
     * @author mao_yejun
     */
    public void flushdb() {
        this.redisTemplate.execute(new RedisCallback() {
            public Boolean doInRedis(RedisConnection connection) {
                connection.flushDb();
                return true;
            }
        });
    }

    /**
     * 给key提供生存周期
     *
     * @param key     key
     * @param seconds seconds
     * @return 结果
     * @author mao_yejun
     */
    public boolean expire(final String key, final String value, final long seconds) {
        boolean result = ((Boolean) this.redisTemplate.execute(new RedisCallback() {
            public Boolean doInRedis(RedisConnection connection) {
                RedisSerializer serializer = getRedisSerializer();
                byte[] byteKey = serializer.serialize(key);
                byte[] byteValue = serializer.serialize(value);
                connection.set(byteKey, byteValue);
                return connection.expire(byteKey, seconds);
            }
        })).booleanValue();
        return result;
    }
}
