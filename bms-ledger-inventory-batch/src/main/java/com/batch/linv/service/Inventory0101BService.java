package com.batch.linv.service;

import com.batch.linv.bean.entity.InvmLoad;
import com.batch.linv.bean.entity.LinvLoad;
import com.framework.boot.base.BaseService;

import java.util.List;
import java.util.Map;

/**
 * Created by wangfan on 2017/2/21.
 */
public interface Inventory0101BService extends BaseService {

    List<Map> findLoadData();

    List<InvmLoad> findAllSkuCode();
}
