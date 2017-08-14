/*
 * 2016/12/29 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.byim.services;

import com.bms.byim.bean.entity.ByimStore;
import com.bms.byim.bean.param.StoreRsParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>ByimStoreService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface ByimStoreService extends BaseService {
    @Transactional(readOnly = true)
    int findTerminalMarketUse(StoreRsParam storeRsParam);

    @Transactional
    int modifyStore(ByimStore store);

    @Transactional(readOnly = true)
    List<StoreRsParam> findList(StoreRsParam storeRsParam);
}