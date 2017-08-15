
package com.bms.slpd.dao;

import com.bms.slpd.bean.result.field.*;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLPD0201IDao extends BaseDao {

    /**
     * 批量查询原种种源标准指标
     */
    List<SLPD0201IOrgStdResult> findOrgStds(List<Long> breedIds);

    /**
     * 批量查询饲养标准指标
     */
    List<SLPD0201IFedStdResult> findFedStds(List<Long> breedIds);

    /**
     * 批量查询加工技术标准指标
     */
    List<SLPD0201IMctStdResult> findMctStds(List<Long> breedIds);

    /**
     * 批量查询加工质量标准指标
     */
    List<SLPD0201ITncStdResult> findTncStds(List<Long> breedIds);


    /**
     * 批量查询通用质量标准指标
     */
    List<SLPD0201IGnqStdResult> findGnqStds(List<Long> breedIds);

    /**
     * 批量查询安全标准标准指标
     */
    List<SLPD0201ISftStdResult> findSftStds(List<Long> breedIds);

    /**
     * 批量查询储存运输标准指标
     */
    List<SLPD0201ITspStdResult> findTspStds(List<Long> breedIds);

    /**
     * 批量查询包装标准标准指标
     */
    List<SLPD0201IPkgStdResult> findPkgStds(List<Long> itemIds);

}