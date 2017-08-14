package com.framework.number.generate.database;

import com.framework.number.generate.database.redis.RedisDao;

/**
 * Created by jackjiang on 16/11/22.
 */
public final class DaoFactory {
    private static BaseDao baseDao;

    public static BaseDao getBaseDao(){
        if(baseDao == null){
            return new RedisDao();
        }
        return baseDao;
    }

    public static void setBaseDao(BaseDao baseDao){
        DaoFactory.baseDao = baseDao;
    }



}
