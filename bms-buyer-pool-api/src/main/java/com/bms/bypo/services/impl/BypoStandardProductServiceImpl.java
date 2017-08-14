/*
 * 2016/12/20 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.bypo.services.impl;

import com.bms.bypo.bean.param.StandardProductRsParam;
import com.bms.bypo.dao.BypoStandardProductDao;
import com.bms.bypo.services.BypoStandardProductService;
import com.framework.base.bean.Pagination;
import com.framework.base.rest.param.BaseRestPaginationParam;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>BypoStandardProductService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class BypoStandardProductServiceImpl extends BaseServiceImpl implements BypoStandardProductService {

    @Autowired
    private BypoStandardProductDao bypoStandardProductDao;

    @Override
    public BaseDao getBaseDao() {
        return bypoStandardProductDao;
    }

    @Override
    public int standardProductIsExist(StandardProductRsParam standardProductRsParam) {
        return bypoStandardProductDao.standardProductIsExist(standardProductRsParam);
    }

    public <O extends Serializable, T extends BaseRestPaginationParam> BaseRestPaginationResult<O> findStandardProduct(StandardProductRsParam param) {
        BaseRestPaginationResult pageResult = new BaseRestPaginationResult();
        Page page;
        if (param == null) {
            page = PageHelper.startPage(0, 0, true, Boolean.valueOf(false), Boolean.valueOf(true));
        } else {
            Pagination data = param.getPagination();
            if (data == null) {
                page = PageHelper.startPage(0, 0, true, Boolean.valueOf(false), Boolean.valueOf(true));
            } else {
                page = PageHelper.startPage(data.getStartPos(), data.getPageSize(), true, Boolean.valueOf(false), Boolean.valueOf(true));
            }

            this.setSort(param.getSort());
        }

        List data1 = this.bypoStandardProductDao.findStandardProduct(param);
        pageResult.setTotal(page.getTotal());
        if (page.getTotal() != 0L) {
            pageResult.setData(data1);
        } else {
            pageResult.setData(new ArrayList());
        }

        return pageResult;
    }

}