package com.bms.slpd.services.impl;

import com.bms.slpd.bean.param.SLPD0201IParam;
import com.bms.slpd.bean.result.field.*;
import com.bms.slpd.dao.SLPD0201IDao;
import com.bms.slpd.services.SLPD0201IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.*;

@Service
public class SLPD0201IServiceImpl extends BaseServiceImpl implements SLPD0201IService {

    @Autowired
    private SLPD0201IDao slpd0201IDao;

    @Override
    public BaseDao getBaseDao() {
        return this.slpd0201IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BaseRestPaginationResult<SLPD0201IBreedResult> findBreeds(SLPD0201IParam slpd0201IParam) {
        BaseRestPaginationResult<SLPD0201IBreedResult> restResult = super.findPageList(slpd0201IParam);
        this.fillSpecifiedFields(restResult.getData(), slpd0201IParam);
        return restResult;
    }

    /**
     * 补充指定数据
     */
    private void fillSpecifiedFields(List<SLPD0201IBreedResult> breeds, SLPD0201IParam slpd0201IParam) {
        if (CollectionUtils.isNotEmpty(breeds)) {
            if (slpd0201IParam.isFileCardFlg()) {
                //this.fillFileCards(breeds);
            }
        }
    }

    /**
     * 品种添加7个标准档案卡
     */
    private void fillFileCards(List<SLPD0201IBreedResult> breeds) {
        Set<Long> breedIdSet = new HashSet<>();
        for (SLPD0201IBreedResult breed : breeds) {
            breedIdSet.add(breed.getBreedId());
        }
        if (CollectionUtils.isEmpty(breedIdSet)) {
            return;
        }
        List<Long> breedIdList = new LinkedList<>(breedIdSet);

        List<SLPD0201IOrgStdResult> orgStds = this.findOrgStds(breedIdList);
        List<SLPD0201IFedStdResult> fedStds = this.findFedStds(breedIdList);
        List<SLPD0201IMctStdResult> mctStds = this.findMctStds(breedIdList);
        List<SLPD0201ITncStdResult> tncStds = this.findTncStds(breedIdList);
        List<SLPD0201IGnqStdResult> gnqStds = this.findGnqStds(breedIdList);
        List<SLPD0201ISftStdResult> sftStds = this.findSftStds(breedIdList);
        List<SLPD0201ITspStdResult> tspStds = this.findTspStds(breedIdList);

        Map<Serializable, List<SLPD0201IOrgStdResult>> orgStdsMap = this.mappingIdToFileCards(orgStds);
        Map<Serializable, List<SLPD0201IFedStdResult>> fedStdsMap = this.mappingIdToFileCards(fedStds);
        Map<Serializable, List<SLPD0201IMctStdResult>> mctStdsMap = this.mappingIdToFileCards(mctStds);
        Map<Serializable, List<SLPD0201ITncStdResult>> tncStdsMap = this.mappingIdToFileCards(tncStds);
        Map<Serializable, List<SLPD0201IGnqStdResult>> gnqStdsMap = this.mappingIdToFileCards(gnqStds);
        Map<Serializable, List<SLPD0201ISftStdResult>> sftStdsMap = this.mappingIdToFileCards(sftStds);
        Map<Serializable, List<SLPD0201ITspStdResult>> tspStdsMap = this.mappingIdToFileCards(tspStds);

        Long breedId = null;
        for (SLPD0201IBreedResult breed : breeds) {
            breedId = breed.getBreedId();
            breed.setOrgStdList(orgStdsMap.get(breedId));
            breed.setFedStdList(fedStdsMap.get(breedId));
            breed.setMctStdList(mctStdsMap.get(breedId));
            breed.setTncStdList(tncStdsMap.get(breedId));
            breed.setGnqStdList(gnqStdsMap.get(breedId));
            breed.setSftStdList(sftStdsMap.get(breedId));
            breed.setTspStdList(tspStdsMap.get(breedId));
        }
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("Duplicates")
    @Override
    public <T extends SLPDFileCardResult> Map<Serializable, List<T>> mappingIdToFileCards(List<T> fileCards) {
        Map<Serializable, List<T>> fileCardsMap = new HashMap<>();
        Serializable key = null;
        List<T> values = null;

        for (T fileCard : fileCards) {
            key = this.getFileCardId(fileCard);
            if (fileCardsMap.containsKey(key)) {
                values = fileCardsMap.get(key);
                values.add(fileCard);
            }
            else {
                values = new LinkedList<>();
                values.add(fileCard);
                fileCardsMap.put(key, values);
            }
        }
        return fileCardsMap;
    }

    /**
     * 根据档案卡类型，获得相应ID
     */
    private Serializable getFileCardId(SLPDFileCardResult fileCard) {
        Serializable id = null;
        if (fileCard instanceof SLPD0201IPkgStdResult) {
            id = fileCard.getItemId();
        }
        else if (fileCard instanceof SLPD0201IOrgStdResult
                || fileCard instanceof SLPD0201IFedStdResult
                || fileCard instanceof SLPD0201IMctStdResult
                || fileCard instanceof SLPD0201ITncStdResult
                || fileCard instanceof SLPD0201IGnqStdResult
                || fileCard instanceof SLPD0201ISftStdResult
                || fileCard instanceof SLPD0201ITspStdResult) {
            id = fileCard.getBreedId();
        }
        else {
            id = fileCard.getProductId();
        }
        return id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<SLPD0201IOrgStdResult> findOrgStds(List<Long> breedIds) {
        if (CollectionUtils.isEmpty(breedIds)) {
            return new ArrayList<>();
        }
        return this.slpd0201IDao.findOrgStds(breedIds);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<SLPD0201IFedStdResult> findFedStds(List<Long> breedIds) {
        if (CollectionUtils.isEmpty(breedIds)) {
            return new ArrayList<>();
        }
        return this.slpd0201IDao.findFedStds(breedIds);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<SLPD0201IMctStdResult> findMctStds(List<Long> breedIds) {
        if (CollectionUtils.isEmpty(breedIds)) {
            return new ArrayList<>();
        }
        return this.slpd0201IDao.findMctStds(breedIds);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<SLPD0201ITncStdResult> findTncStds(List<Long> breedIds) {
        if (CollectionUtils.isEmpty(breedIds)) {
            return new ArrayList<>();
        }
        return this.slpd0201IDao.findTncStds(breedIds);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<SLPD0201IGnqStdResult> findGnqStds(List<Long> breedIds) {
        if (CollectionUtils.isEmpty(breedIds)) {
            return new ArrayList<>();
        }
        return this.slpd0201IDao.findGnqStds(breedIds);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<SLPD0201ISftStdResult> findSftStds(List<Long> breedIds) {
        if (CollectionUtils.isEmpty(breedIds)) {
            return new ArrayList<>();
        }
        return this.slpd0201IDao.findSftStds(breedIds);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<SLPD0201ITspStdResult> findTspStds(List<Long> breedIds) {
        if (CollectionUtils.isEmpty(breedIds)) {
            return new ArrayList<>();
        }
        return this.slpd0201IDao.findTspStds(breedIds);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<SLPD0201IPkgStdResult> findPkgStds(List<Long> itemIds) {
        if (CollectionUtils.isEmpty(itemIds)) {
            return new ArrayList<>();
        }
        return this.slpd0201IDao.findPkgStds(itemIds);
    }

}