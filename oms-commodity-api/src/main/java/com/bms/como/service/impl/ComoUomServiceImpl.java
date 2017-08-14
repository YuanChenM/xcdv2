package com.bms.como.service.impl;

import com.bms.como.bean.entity.ComoCommodityUom;
import com.bms.como.dao.ComoUomDao;
import com.bms.como.service.ComoUomService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wang_haichun on 2017/3/29.
 */
@Service
public class ComoUomServiceImpl extends BaseServiceImpl implements ComoUomService {

    @Autowired
    private ComoUomDao comoUomDao;

    @Override
    public BaseDao getBaseDao() {
        return comoUomDao;
    }


    @Override
    public List<ComoCommodityUom> findUomByComoIds(List<Long> comoIds) {
        return comoUomDao.findUomByComoIds(comoIds);
    }

    @Override
    public int delUomByComoIds(List<Long> uomSid) {
        return comoUomDao.delUomByComoIds(uomSid);
    }
}
