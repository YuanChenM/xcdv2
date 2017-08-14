package com.bms.common.service;


/**
 * Created by mao_yejun on 2016/12/1.
 */

public interface CommonService {
    void updateVersion(String tableName, String[] primaryKey, Object[] primaryKeyValue, int ver);
}
