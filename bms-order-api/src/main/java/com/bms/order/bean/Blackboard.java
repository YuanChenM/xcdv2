package com.bms.order.bean;

import java.util.HashMap;

import com.bms.order.archive.impl.Operator;
import com.framework.boot.base.BaseDao;
import com.framework.redis.dao.BaseRedisDao;
import org.springframework.util.Assert;

/**
 * 黑板类，生命周期同Request生命周期
 *
 * @author li_huiqian
 */
public class Blackboard {

    /**
     * 操作者
     */
    private Operator operator;

    /**
     * BaseRedisDao
     */
    private BaseRedisDao redisDao;

    /**
     * 存储dao的map
     */
    private HashMap<Class<?>, BaseDao> daoMap;

    public Blackboard() {
        this.daoMap = new HashMap<>();
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public void setBaseRedisDao(BaseRedisDao redisDao) {
        this.redisDao = redisDao;
    }

    public long maxId(String tableName) {
        Assert.notNull(redisDao, "redisDao cannot be null please autowired redisDao and set redisDao into blackboard.");
        return redisDao.getTablePrimaryKey(tableName, 1);
    }

    public long maxId(String tableName, int step) {
        Assert.notNull(redisDao, "redisDao cannot be null please autowired redisDao and set redisDao into blackboard.");
        Long maxId = redisDao.getTablePrimaryKey(tableName, step);
        Long startId=maxId-step+1;
        return startId;
    }

    @SuppressWarnings("unchecked")
    public <T extends BaseDao> T getDao(Class<T> clazz) {
        return (T) daoMap.get(clazz);
    }

    public BaseDao putBaseDao(BaseDao dao) {
        Class<?>[] interfaces = dao.getClass().getInterfaces();
        Class<?> daoInterface = null;
        for (Class<?> i : interfaces) {
            if (i.getSimpleName().endsWith("Dao")) {
                daoInterface = i;
                break;
            }
        }
        return daoMap.put(daoInterface, dao);
    }

}
