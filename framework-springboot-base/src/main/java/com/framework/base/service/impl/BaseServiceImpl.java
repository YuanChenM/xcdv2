package com.framework.base.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.framework.base.bean.param.page.BasePagePagingParam;
import com.framework.base.bean.param.rest.BaseRestPagingParam;
import com.framework.base.bean.result.page.BasePagePagingResult;
import com.framework.base.bean.result.rest.BaseRestPagingResult;
import com.framework.base.consts.NumberConst;
import com.framework.base.dao.BaseDao;
import com.framework.base.service.BaseService;
import com.framework.exception.DataNotFindException;

/**
 * @author liu_tao2
 * @version 1.0
 */
public abstract class BaseServiceImpl implements BaseService {

    public abstract BaseDao getBaseDao() ;
    @Override
    public <T extends Serializable> T findOne(Serializable param) {
        return this.getBaseDao().findOne(param);
    }
    @Override
    public <T extends Serializable> T load(Serializable param) {
        Serializable entity = this.getBaseDao().findOne(param);
        if (entity == null) {
            throw new DataNotFindException("没有找到你想要的数据");
        }
        return (T) entity;
    }
    @Override
    public <T extends Serializable> List<T> findList(Serializable param) {
        return this.getBaseDao().findAll(param);
    }
    @Override
    public int getCount(Serializable param) {
        return this.getBaseDao().count(param);
    }
    @Override
    public int modify(Serializable param) {
        return this.getBaseDao().modify(param);
    }
    @Override
    public int save(Serializable param) {
        return this.getBaseDao().save(param);
    }
    @Override
    public int remove(Serializable param) {
        return this.getBaseDao().remove(param);
    }
    @Override
    public int getPageCount(Serializable param) {
        return this.getBaseDao().count(param);
    }
    @Override
    public <T extends Serializable> BaseRestPagingResult<T> findPageList(BaseRestPagingParam param) {
        BaseRestPagingResult<T> pageResult = new BaseRestPagingResult<>();
        pageResult.setTotal(this.getPageCount(param));
        if (pageResult.getTotal() != NumberConst.IntDef.INT_ZERO) {
            pageResult.setData((List<T>) this.findPage(param));
        } else {
            pageResult.setData(new ArrayList<T>());
        }
        return pageResult;
    }
    @Override
    public <T extends Serializable> BasePagePagingResult<T> findPageList(BasePagePagingParam param) {
        BasePagePagingResult<T> pageResult = new BasePagePagingResult<>();
        pageResult.setTotal(this.getPageCount(param));
        if (pageResult.getTotal() != NumberConst.IntDef.INT_ZERO) {
            pageResult.setData((List<T>) this.findPage(param));
        } else {
            pageResult.setData(new ArrayList<T>());
        }
        return pageResult;
    }
    @Transactional
    public <T extends Serializable> List<T> findPage(BasePagePagingParam param) {
        return this.getBaseDao().findPageList(param);
    }
    @Transactional
    public <T extends Serializable> List<T> findPage(BaseRestPagingParam param) {
        return this.getBaseDao().findPageList(param);
    }
    @Override
    public <T extends Serializable> int batchSave(List<T> params) {
        return this.getBaseDao().batchInsert(params);
    }
}
