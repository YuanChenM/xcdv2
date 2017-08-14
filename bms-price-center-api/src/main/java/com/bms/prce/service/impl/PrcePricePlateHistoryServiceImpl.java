/*
 * 2017/01/10 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
 package com.bms.prce.service.impl;

 import com.bms.prce.bean.entity.PrcePricePlateDetailHistory;
 import com.bms.prce.bean.entity.PrcePricePlateHistory;
 import com.bms.prce.bean.param.PRCE0210IDealParam;
 import com.bms.prce.dao.PrcePricePlateDetailHistoryDao;
 import com.bms.prce.dao.PrcePricePlateHistoryDao;
 import com.bms.prce.service.PrcePricePlateHistoryService;
 import com.framework.boot.base.BaseDao;
 import com.framework.boot.base.BaseServiceImpl;
 import com.framework.redis.dao.BaseRedisDao;
 import org.apache.commons.collections.CollectionUtils;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 import java.util.List;

/**
 * <p>PrcePricePlateHistoryService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
 @Service
 public class PrcePricePlateHistoryServiceImpl extends BaseServiceImpl implements PrcePricePlateHistoryService {
    @Autowired
    private PrcePricePlateHistoryDao pricePlateHistoryDao;

    @Autowired
    private PrcePricePlateDetailHistoryDao pricePlateDetailHistoryDao;

    @Autowired
    private BaseRedisDao baseRedisDao;

    /**
     * 保存履历
     *
     * @param param
     */
    public void saveHistory(PRCE0210IDealParam param) {
        // 价盘履历
        pricePlateHistoryDao.save(param);
        // 价盘详细履历
        pricePlateDetailHistoryDao.save(param);
    }

    @Override
    public BaseDao getBaseDao() {
        return pricePlateHistoryDao;
    }
 }