package com.framework.base.service;

import java.io.Serializable;
import java.util.List;

import com.framework.base.bean.param.page.BasePagePagingParam;
import com.framework.base.bean.param.rest.BaseRestPagingParam;
import com.framework.base.bean.result.page.BasePagePagingResult;
import com.framework.base.bean.result.rest.BaseRestPagingResult;
import com.framework.exception.DataNotFindException;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liu_tao2
 * @version 1.0
 */
public interface BaseService {

    @Transactional(readOnly = true)
    <T extends Serializable> T findOne(Serializable param);

    @Transactional(readOnly = true)
    <T extends Serializable> T load(Serializable param) throws DataNotFindException;

    @Transactional(readOnly = true)
    <T extends Serializable> List<T> findList(Serializable param);

    @Transactional(readOnly = true)
    int getCount(Serializable param);

    @Transactional
    int modify(Serializable param);

    @Transactional
    int save(Serializable param);

    @Transactional
    int remove(Serializable param);

    @Transactional(readOnly = true)
    int getPageCount(Serializable param);

    @Transactional(readOnly = true)
    <T extends Serializable> BaseRestPagingResult<T> findPageList(BaseRestPagingParam param);

    @Transactional(readOnly = true)
    <T extends Serializable> BasePagePagingResult<T> findPageList(BasePagePagingParam param);

    @Transactional
    <T extends Serializable> int batchSave(List<T> params);
}
