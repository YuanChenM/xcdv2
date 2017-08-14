package com.framework.number.generate.database.redis;

import com.framework.core.utils.DateUtils;
import com.framework.core.utils.NumberUtils;
import com.framework.core.utils.StringUtils;
import com.framework.number.generate.bean.result.SequenceResult;
import com.framework.number.generate.database.BaseDao;
import com.framework.number.generate.enums.ResetType;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.Map;

/**
 * Created by jackjiang on 16/11/21.
 */
public class RedisDao implements BaseDao {
    private Jedis jedis;

    public RedisDao() {
        RedisConnectionManger redisConnectionManger = new RedisConnectionManger();
        jedis = redisConnectionManger.getJedis();
    }

    @Override
    public long sequence(String type) {
        Transaction tx = jedis.multi();
        tx.incr(type.toUpperCase()+"_INDEX");
        tx.exec();
        Long sequence = Long.valueOf(jedis.get(type.toUpperCase()+"_INDEX"));
        return sequence;
    }

    @Override
    public void reset(String type) {
        jedis.getSet(type.toUpperCase()+"_INDEX", StringUtils.toString(0));
    }

    @Override
    public void set(String key, Map<String, String> map) {
        jedis.hmset(key, map);
    }

    @Override
    public void put(String key, long sequence) {
        String currentDate = DateUtils.fmtCurrent();
        Map<String, String> result = jedis.hgetAll(key);
        result.put(BaseDao.INDEX_KEY,String.valueOf(sequence));
        result.put(BaseDao.UPDATE_TIME_KEY,currentDate);
        this.set(key,result);
    }

    @Override
    public void close() {
        this.jedis.close();
    }

    @Override
    public SequenceResult get(String key) {
        Map<String, String> result = jedis.hgetAll(key);
        if(result == null){
            return null;
        }

        String index = result.get("index");
        String createTime = result.get("createTime");
        String updateTime = result.get("updateTime");
        String resetType = result.get("resetType");
        SequenceResult sequenceResult = new SequenceResult();
        sequenceResult.setIndex(NumberUtils.toLong(index));
        sequenceResult.setCreateDate(createTime);
        sequenceResult.setUpdateTime(updateTime);
        if("Day".equals(resetType)){
            sequenceResult.setResetType(ResetType.Day);
        }
        return sequenceResult;
    }

    @Override
    public void backUp(String key) {

    }
}
