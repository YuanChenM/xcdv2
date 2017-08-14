package com.bms.region.services;

import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

/**
 * Created by guan_zhongheng on 2017/4/14.
 */
public interface RegnCommonService {

    @Transactional
    void checkSystemUse(HashMap<String,Long> param);
}
