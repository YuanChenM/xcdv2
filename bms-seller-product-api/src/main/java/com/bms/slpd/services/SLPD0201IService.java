
package com.bms.slpd.services;


import com.bms.slpd.bean.param.SLPD0201IParam;
import com.bms.slpd.bean.result.field.*;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface SLPD0201IService extends BaseService {

    /**
     * 批量查询品种
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SLPD0201IBreedResult> findBreeds(SLPD0201IParam slpd0201IParam);

    /**
     * 品种ID、单品ID、产品ID映射标准档案卡、档案差异卡
     */
    @Transactional(readOnly = true)
    <T extends SLPDFileCardResult> Map<Serializable, List<T>> mappingIdToFileCards(List<T> fileCards);

    /**
     * 批量查询原种种源标准指标
     */
    @Transactional(readOnly = true)
    List<SLPD0201IOrgStdResult> findOrgStds(List<Long> breedIds);

    /**
     * 批量查询饲养标准指标
     */
    @Transactional(readOnly = true)
    List<SLPD0201IFedStdResult> findFedStds(List<Long> breedIds);

    /**
     * 批量查询加工技术标准指标
     */
    @Transactional(readOnly = true)
    List<SLPD0201IMctStdResult> findMctStds(List<Long> breedIds);

    /**
     * 批量查询加工质量标准指标
     */
    @Transactional(readOnly = true)
    List<SLPD0201ITncStdResult> findTncStds(List<Long> breedIds);


    /**
     * 批量查询通用质量标准指标
     */
    @Transactional(readOnly = true)
    List<SLPD0201IGnqStdResult> findGnqStds(List<Long> breedIds);

    /**
     * 批量查询安全标准标准指标
     */
    @Transactional(readOnly = true)
    List<SLPD0201ISftStdResult> findSftStds(List<Long> breedIds);

    /**
     * 批量查询储存运输标准指标
     */
    @Transactional(readOnly = true)
    List<SLPD0201ITspStdResult> findTspStds(List<Long> breedIds);

    /**
     * 批量查询包装标准标准指标
     */
    @Transactional(readOnly = true)
    List<SLPD0201IPkgStdResult> findPkgStds(List<Long> itemIds);

}