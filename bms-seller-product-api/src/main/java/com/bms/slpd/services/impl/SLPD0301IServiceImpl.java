package com.bms.slpd.services.impl;

import com.bms.slpd.bean.param.SLPD0301IParam;
import com.bms.slpd.bean.result.SLPD0301IResult;
import com.bms.slpd.bean.result.field.*;
import com.bms.slpd.dao.SLPD0301IDao;
import com.bms.slpd.services.SLPD0201IService;
import com.bms.slpd.services.SLPD0301IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.*;

@Service
public class SLPD0301IServiceImpl extends BaseServiceImpl implements SLPD0301IService {

    @Autowired
    private SLPD0201IService slpd0201IService;
    @Autowired
    private SLPD0301IDao slpd0301IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd0301IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BaseRestPaginationResult<SLPD0301IItemResult> findItems(SLPD0301IParam slpd0301IParam) {
        BaseRestPaginationResult<SLPD0301IItemResult> restResult = super.findPageList(slpd0301IParam);
        this.fillSpecifiedFields(restResult.getData(), slpd0301IParam);
        return restResult;
    }

    /**
     * 补充指定数据
     */
    private void fillSpecifiedFields(List<SLPD0301IItemResult> items, SLPD0301IParam slpd0301IParam) {
        if (CollectionUtils.isNotEmpty(items)) {
            if (slpd0301IParam.isFileCardFlg()) {
                //this.fillFileCards(items);
            }
        }
    }

    /**
     * 产品添加8个标准档案卡
     */
    private void fillFileCards(List<SLPD0301IItemResult> items) {
        Set<Long> breedIdSet = new HashSet<>();
        Set<Long> itemIdSet = new HashSet<>();
        for (SLPD0301IItemResult item : items) {
            breedIdSet.add(item.getBreed().getBreedId());
            itemIdSet.add(item.getItemId());
        }

        if (CollectionUtils.isEmpty(breedIdSet) || CollectionUtils.isEmpty(itemIdSet)) {
            return;
        }
        List<Long> breedIdList = new LinkedList<>(breedIdSet);
        List<Long> itemIdList = new LinkedList<>(itemIdSet);

        List<SLPD0201IOrgStdResult> orgStds = this.slpd0201IService.findOrgStds(breedIdList);
        List<SLPD0201IFedStdResult> fedStds = this.slpd0201IService.findFedStds(breedIdList);
        List<SLPD0201IMctStdResult> mctStds = this.slpd0201IService.findMctStds(breedIdList);
        List<SLPD0201ITncStdResult> tncStds = this.slpd0201IService.findTncStds(breedIdList);
        List<SLPD0201IGnqStdResult> gnqStds = this.slpd0201IService.findGnqStds(breedIdList);
        List<SLPD0201ISftStdResult> sftStds = this.slpd0201IService.findSftStds(breedIdList);
        List<SLPD0201ITspStdResult> tspStds = this.slpd0201IService.findTspStds(breedIdList);
        List<SLPD0201IPkgStdResult> pkgStds = this.slpd0201IService.findPkgStds(itemIdList);

        Map<Serializable, List<SLPD0201IOrgStdResult>> orgStdsMap = slpd0201IService.mappingIdToFileCards(orgStds);
        Map<Serializable, List<SLPD0201IFedStdResult>> fedStdsMap = slpd0201IService.mappingIdToFileCards(fedStds);
        Map<Serializable, List<SLPD0201IMctStdResult>> mctStdsMap = slpd0201IService.mappingIdToFileCards(mctStds);
        Map<Serializable, List<SLPD0201ITncStdResult>> tncStdsMap = slpd0201IService.mappingIdToFileCards(tncStds);
        Map<Serializable, List<SLPD0201IGnqStdResult>> gnqStdsMap = slpd0201IService.mappingIdToFileCards(gnqStds);
        Map<Serializable, List<SLPD0201ISftStdResult>> sftStdsMap = slpd0201IService.mappingIdToFileCards(sftStds);
        Map<Serializable, List<SLPD0201ITspStdResult>> tspStdsMap = slpd0201IService.mappingIdToFileCards(tspStds);
        Map<Serializable, List<SLPD0201IPkgStdResult>> pkgStdsMap = slpd0201IService.mappingIdToFileCards(pkgStds);

        Long breedId = null;
        for (SLPD0301IItemResult item : items) {
            breedId = item.getBreed().getBreedId();
            item.setOrgStdList(orgStdsMap.get(breedId));
            item.setFedStdList(fedStdsMap.get(breedId));
            item.setMctStdList(mctStdsMap.get(breedId));
            item.setTncStdList(tncStdsMap.get(breedId));
            item.setGnqStdList(gnqStdsMap.get(breedId));
            item.setSftStdList(sftStdsMap.get(breedId));
            item.setTspStdList(tspStdsMap.get(breedId));
            item.setPkgStdList(pkgStdsMap.get(item.getItemId()));
        }
    }

}
