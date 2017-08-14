/*
 * 2016/12/14 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.bymt.services.impl;

import com.bms.bymt.bean.entity.BymtTerminalMarketTarget;
import com.bms.bymt.bean.param.BaseBean;
import com.bms.bymt.bean.param.TerminalMarketTargetRsParam;
import com.bms.bymt.dao.BymtTerminalMarketTargetDao;
import com.bms.bymt.services.BymtTerminalMarketTargetService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>BymtTerminalMarketTargetService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class BymtTerminalMarketTargetServiceImpl extends BaseServiceImpl implements BymtTerminalMarketTargetService {

    @Autowired
    private BymtTerminalMarketTargetDao bymtTerminalMarketTargetDao;

    @Override
    public BaseDao getBaseDao() {
        return bymtTerminalMarketTargetDao;
    }


    @Override
    public Integer executeInsert(List<List<BymtTerminalMarketTarget>> entityList) {
        int countInsert;
        int countAll = NumberUtils.INTEGER_ZERO;
        for (int i = 0, sizes = entityList.size(); i < sizes; i++) {
            countInsert = batchSave(entityList.get(i));
            countAll += countInsert;
        }
        return countAll;
    }

    @Override
    public int executeModify(List<BaseBean<BymtTerminalMarketTarget, BymtTerminalMarketTarget>> paramList) {
        int count = NumberUtils.INTEGER_ZERO;
        int beansSize = paramList.size();
        for (int i = 0; i < beansSize; i++) {
            count = modify(paramList.get(i));
        }

        return count;
    }

    @Override
    public TerminalMarketTargetRsParam findSum(TerminalMarketTargetRsParam marketTargetRsParam) {
        return bymtTerminalMarketTargetDao.findSum(marketTargetRsParam);
    }
}