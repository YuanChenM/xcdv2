package com.framework.number.generate.database;

import com.framework.number.generate.bean.result.SequenceResult;

import java.util.Map;

/**
 * Sequences固化数据需要的DAO
 * @see com.framework.number.generate.database.redis.RedisDao
 * @author jiang_nan
 * @version 1.0
 */
public interface BaseDao {

    String INDEX_KEY = "index";

    String CREATE_TIME_KEY = "createTime";

    String UPDATE_TIME_KEY = "updateTime";

    String RESET_KEY = "resetType";

    long sequence(String type);

    void reset(String type);

    void set(String key,Map<String,String> map);

    void put(String key,long sequence);

    void close();

    SequenceResult get(String key);

    void backUp(String key);

}
