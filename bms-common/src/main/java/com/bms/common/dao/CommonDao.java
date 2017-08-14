package com.bms.common.dao;

import java.io.Serializable;

/**
 * Created by mao_yejun on 2016/12/1.
 */
public interface CommonDao {
    /**
     * 跟新版本做排他处理
     *
     * @param param
     * @return
     */
    int updateVersion(Serializable param);
}
