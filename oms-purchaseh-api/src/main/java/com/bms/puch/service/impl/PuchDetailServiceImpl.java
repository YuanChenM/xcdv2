/*
 * 2017/03/16 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.puch.service.impl;

import com.bms.puch.bean.param.PuchReceivePageParam;
import com.bms.puch.bean.result.PuchReceiveRestResult;
import com.bms.puch.dao.PuchDetailDao;
import com.bms.puch.service.PuchDetailService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>PuchDetailService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class PuchDetailServiceImpl extends BaseServiceImpl implements PuchDetailService {

    @Autowired
    private PuchDetailDao puchDetailDao;

    @Override
    public BaseDao getBaseDao() {
        return puchDetailDao;
    }

}