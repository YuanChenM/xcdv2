package com.bms.slpd.services;

import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public interface SLPD0611IService extends BaseService {

    /**
     * <p>查询加工质量标准</p>
     */
    @Transactional
    <T extends Serializable> List<T> batchSearch(Serializable var1);

    @Transactional
    <T extends Serializable> List<T> searchStd(Serializable var1);

    @Transactional
    <T extends Serializable> List<T> searchDif(Serializable var1);

    @Transactional
    <T extends Serializable>List<T> searchDiscuss(Serializable var1);

    @Transactional
    <T extends Serializable>List<T> searchDifDiscuss(Serializable var1);
}