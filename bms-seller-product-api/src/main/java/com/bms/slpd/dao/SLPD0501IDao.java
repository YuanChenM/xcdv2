package com.bms.slpd.dao;

import com.bms.slpd.bean.result.field.*;
import com.framework.boot.base.BaseDao;

import java.util.List;
import java.util.Map;

public interface SLPD0501IDao extends BaseDao {

    /**
     * 根据品牌ID，批量查询品牌所有人
     */
    List<Map<String, Object>> findBrandOwnersByBrandIds(List<Long> brandIds);

    /**
     * 批量查询原种种源标准指标差异
     */
    List<SLPD0501IDifOrgStdResult> findDifOrgStds(List<String> productIds);

    /**
     * 批量查询饲养标准指标差异
     */
    List<SLPD0501IDifFedStdResult> findDifFedStds(List<String> productIds);

    /**
     * 批量查询加工技术标准指标差异
     */
    List<SLPD0501IDifMctStdResult> findDifMctStds(List<String> productIds);

    /**
     * 批量查询加工质量标准指标差异
     */
    List<SLPD0501IDifTncStdResult> findDifTncStds(List<String> productIds);

    /**
     * 批量查询通用质量标准指标差异
     */
    List<SLPD0501IDifGnqStdResult> findDifGnqStds(List<String> productIds);

    /**
     * 批量查询安全标准指标差异
     */
    List<SLPD0501IDifSftStdResult> findDifSftStds(List<String> productIds);

    /**
     * 批量查询存储运输标准指标差异
     */
    List<SLPD0501IDifTspStdResult> findDifTspStds(List<String> productIds);

    /**
     * 批量查询包装标准指标差异
     */
    List<SLPD0501IDifPkgStdResult> findDifPkgStds(List<String> productIds);

}