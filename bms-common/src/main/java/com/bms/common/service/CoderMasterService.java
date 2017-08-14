package com.bms.common.service;

import com.bms.common.entity.DictNodeBean;

import java.util.List;

/**
 * Created by zhu_kai1 on 2016/12/23.
 */
public interface CoderMasterService {

    List<DictNodeBean> getCodeMaster(String key);


    String getConfigConstant(String key);
}
