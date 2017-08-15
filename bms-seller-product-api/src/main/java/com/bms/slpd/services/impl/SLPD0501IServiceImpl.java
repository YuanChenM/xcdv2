package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdBrandOwner;
import com.bms.slpd.bean.param.SLPD0501IParam;
import com.bms.slpd.bean.result.field.*;
import com.bms.slpd.constant.CodeMasterConstant;
import com.bms.slpd.dao.SLPD0501IDao;
import com.bms.slpd.services.SLPD0201IService;
import com.bms.slpd.services.SLPD0501IService;
import com.bms.slpd.utils.CodeMasterUtils;
import com.framework.base.consts.NumberConst;
import com.framework.base.consts.StringConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.*;

@Service
public class SLPD0501IServiceImpl extends BaseServiceImpl implements SLPD0501IService {

    @Autowired
    private CodeMasterUtils codeMasterUtils;
    @Autowired
    private SLPD0201IService slpd0201iService;
    @Autowired
    private SLPD0501IDao slpd0501iDao;

    @Override
    public BaseDao getBaseDao() {
        return this.slpd0501iDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BaseRestPaginationResult<SLPD0501IProductResult> findProducts(SLPD0501IParam slpd0501iParam) {
        BaseRestPaginationResult<SLPD0501IProductResult> restResult = super.findPageList(slpd0501iParam);
        this.fillSpecifiedFields(restResult.getData(), slpd0501iParam);
        return restResult;
    }

    /**
     * 补充指定数据
     */
    private void fillSpecifiedFields(List<SLPD0501IProductResult> products, SLPD0501IParam slpd0501iParam) {
        if (CollectionUtils.isNotEmpty(products)) {
            this.fillBrandOwners(products);
            if (slpd0501iParam.isFileCardFlg()) {
                //this.fillFileCards(products);
            }
            this.fillCodeMasters(products);
        }
    }

    /**
     * 单品品牌对象添加品牌所有人
     */
    @SuppressWarnings("unchecked")
    private void fillBrandOwners(List<SLPD0501IProductResult> products) {
        Map<Long, List<SlpdBrandOwner>> bidOwnersMap = this.mappingBrandIdToBrandOwners(products);
        if (bidOwnersMap == null || bidOwnersMap.size() == NumberConst.IntDef.INT_ZERO) {
            return;
        }

        SLPD0501IBrandResult brand = null;
        Long brandId = null;
        List<SlpdBrandOwner> brandOwners = null;

        for (SLPD0501IProductResult product : products) {
            brand = product.getBrandItemProperty().getBrand();
            brandId = brand.getBrandId();
            brandOwners = bidOwnersMap.get(brandId);
            brand.setBrandOwnerList(brandOwners);
            brand.setOwnersName(this.appendBrandOwnerNames(brandOwners));
        }
    }

    /**
     * 品牌ID映射品牌所有人
     */
    @SuppressWarnings({"Duplicates", "unchecked"})
    private Map<Long, List<SlpdBrandOwner>> mappingBrandIdToBrandOwners(List<SLPD0501IProductResult> products) {
        List<Map<String, Object>> bidOwnerMaps = this.findBrandOwnersByBrandIds(products);
        if (CollectionUtils.isEmpty(bidOwnerMaps)) {
            return null;
        }

        Map<Long, List<SlpdBrandOwner>> bidOwnersMap = new HashMap<>();
        List<SlpdBrandOwner> brandOwners = null;
        Long brandId = null;
        SlpdBrandOwner brandOwner = null;

        for (Map<String, Object> bidOwnerMap : bidOwnerMaps) {
            brandId = Long.valueOf(String.valueOf(bidOwnerMap.get("brandId")));
            brandOwner = (SlpdBrandOwner) bidOwnerMap.get("brandOwner");

            if (bidOwnersMap.containsKey(brandId)) {
                brandOwners = bidOwnersMap.get(brandId);
                brandOwners.add(brandOwner);
            } else {
                brandOwners = new LinkedList<>();
                brandOwners.add(brandOwner);
                bidOwnersMap.put(brandId, brandOwners);
            }
        }
        return bidOwnersMap;
    }

    /**
     * 根据品牌ID，批量查询品牌所有人
     */
    private List<Map<String, Object>> findBrandOwnersByBrandIds(List<SLPD0501IProductResult> products) {
        Set<Long> brandIdSet = new HashSet<>();
        for (SLPD0501IProductResult product : products) {
            brandIdSet.add(product.getBrandItemProperty().getBrand().getBrandId());
        }

        if (CollectionUtils.isEmpty(brandIdSet)) {
            return null;
        }
        List<Long> brandIdList = new LinkedList<>(brandIdSet);
        return this.slpd0501iDao.findBrandOwnersByBrandIds(brandIdList);
    }

    /**
     * 拼接品牌所有人名称
     */
    private String appendBrandOwnerNames(List<SlpdBrandOwner> brandOwners) {
        if (CollectionUtils.isEmpty(brandOwners)) {
            return StringConst.EMPTY;
        }

        StringBuilder ownersName = new StringBuilder();
        for (SlpdBrandOwner brandOwner : brandOwners) {
            ownersName.append(brandOwner.getOwnerName()).append(StringConst.COMMA);
        }
        return ownersName.substring(NumberConst.IntDef.INT_ZERO, ownersName.lastIndexOf(StringConst.COMMA));
    }

    /**
     * 产品添加标准档案卡和档案差异卡
     */
    private void fillFileCards(List<SLPD0501IProductResult> products) {
        Set<Long> breedIdSet = new HashSet<>();
        Set<Long> itemIdSet = new HashSet<>();
        Set<String> productIdSet = new HashSet<>();

        SLPD0501IItemResult item = null;
        for (SLPD0501IProductResult product : products) {
            productIdSet.add(product.getProductId());
            item = product.getBrandItemProperty().getItem();
            itemIdSet.add(item.getItemId());
            breedIdSet.add(item.getBreed().getBreedId());
        }

        List<Long> breedIdList = new ArrayList<>(breedIdSet);
        List<Long> itemIdList = new ArrayList<>(itemIdSet);
        List<String> productIdList = new ArrayList<>(productIdSet);

        Map<Serializable, List<SLPD0201IOrgStdResult>> orgStdsMap = this.slpd0201iService.mappingIdToFileCards(this.slpd0201iService.findOrgStds(breedIdList));
        Map<Serializable, List<SLPD0201IFedStdResult>> fedStdsMap = this.slpd0201iService.mappingIdToFileCards(this.slpd0201iService.findFedStds(breedIdList));
        Map<Serializable, List<SLPD0201IMctStdResult>> mctStdsMap = this.slpd0201iService.mappingIdToFileCards(this.slpd0201iService.findMctStds(breedIdList));
        Map<Serializable, List<SLPD0201ITncStdResult>> tncStdsMap = this.slpd0201iService.mappingIdToFileCards(this.slpd0201iService.findTncStds(breedIdList));
        Map<Serializable, List<SLPD0201IGnqStdResult>> gnqStdsMap = this.slpd0201iService.mappingIdToFileCards(this.slpd0201iService.findGnqStds(breedIdList));
        Map<Serializable, List<SLPD0201ISftStdResult>> sftStdsMap = this.slpd0201iService.mappingIdToFileCards(this.slpd0201iService.findSftStds(breedIdList));
        Map<Serializable, List<SLPD0201ITspStdResult>> tspStdsMap = this.slpd0201iService.mappingIdToFileCards(this.slpd0201iService.findTspStds(breedIdList));
        Map<Serializable, List<SLPD0201IPkgStdResult>> pkgStdsMap = this.slpd0201iService.mappingIdToFileCards(this.slpd0201iService.findPkgStds(itemIdList));

        Map<Serializable, List<SLPD0501IDifOrgStdResult>> difOrgStdsMap = this.slpd0201iService.mappingIdToFileCards(this.findDifOrgStds(productIdList));
        Map<Serializable, List<SLPD0501IDifFedStdResult>> difFedStdsMap = this.slpd0201iService.mappingIdToFileCards(this.findDifFedStds(productIdList));
        Map<Serializable, List<SLPD0501IDifMctStdResult>> difMctStdsMap = this.slpd0201iService.mappingIdToFileCards(this.findDifMctStds(productIdList));
        Map<Serializable, List<SLPD0501IDifTncStdResult>> difTncStdsMap = this.slpd0201iService.mappingIdToFileCards(this.findDifTncStds(productIdList));
        Map<Serializable, List<SLPD0501IDifGnqStdResult>> difGnqStdsMap = this.slpd0201iService.mappingIdToFileCards(this.findDifGnqStds(productIdList));
        Map<Serializable, List<SLPD0501IDifSftStdResult>> difSftStdsMap = this.slpd0201iService.mappingIdToFileCards(this.findDifSftStds(productIdList));
        Map<Serializable, List<SLPD0501IDifTspStdResult>> difTspStdsMap = this.slpd0201iService.mappingIdToFileCards(this.findDifTspStds(productIdList));
        Map<Serializable, List<SLPD0501IDifPkgStdResult>> difPkgStdsMap = this.slpd0201iService.mappingIdToFileCards(this.findDifPkgStds(productIdList));

        Serializable breedId = null;
        Serializable itemId = null;
        Serializable productId = null;

        for (SLPD0501IProductResult product : products) {
            productId = product.getProductId();
            item = product.getBrandItemProperty().getItem();
            itemId = item.getItemId();
            breedId = item.getBreed().getBreedId();

            product.setOrgStdList(orgStdsMap.get(breedId));
            product.setFedStdList(fedStdsMap.get(breedId));
            product.setMctStdList(mctStdsMap.get(breedId));
            product.setTncStdList(tncStdsMap.get(breedId));
            product.setGnqStdList(gnqStdsMap.get(breedId));
            product.setSftStdList(sftStdsMap.get(breedId));
            product.setTspStdList(tspStdsMap.get(breedId));
            product.setPkgStdList(pkgStdsMap.get(itemId));

            product.setDifOrgStdList(difOrgStdsMap.get(productId));
            product.setDifFedStdList(difFedStdsMap.get(productId));
            product.setDifMctStdList(difMctStdsMap.get(productId));
            product.setDifTncStdList(difTncStdsMap.get(productId));
            product.setDifGnqStdList(difGnqStdsMap.get(productId));
            product.setDifSftStdList(difSftStdsMap.get(productId));
            product.setDifTspStdList(difTspStdsMap.get(productId));
            product.setDifPkgStdList(difPkgStdsMap.get(productId));
        }
    }

    /**
     * 批量查询原种种源标准指标差异
     */
    public List<SLPD0501IDifOrgStdResult> findDifOrgStds(List<String> productIds) {
        if (CollectionUtils.isEmpty(productIds)) {
            return new ArrayList<>();
        }
        return this.slpd0501iDao.findDifOrgStds(productIds);
    }

    /**
     * 批量查询饲养标准指标差异
     */
    private List<SLPD0501IDifFedStdResult> findDifFedStds(List<String> productIds) {
        if (CollectionUtils.isEmpty(productIds)) {
            return new ArrayList<>();
        }
        return this.slpd0501iDao.findDifFedStds(productIds);
    }

    /**
     * 批量查询加工技术标准指标差异
     */
    private List<SLPD0501IDifMctStdResult> findDifMctStds(List<String> productIds) {
        if (CollectionUtils.isEmpty(productIds)) {
            return new ArrayList<>();
        }
        return this.slpd0501iDao.findDifMctStds(productIds);
    }

    /**
     * 批量查询加工质量标准差异
     */
    private List<SLPD0501IDifTncStdResult> findDifTncStds(List<String> productIds) {
        if (CollectionUtils.isEmpty(productIds)) {
            return new ArrayList<>();
        }
        return this.slpd0501iDao.findDifTncStds(productIds);
    }

    /**
     * 批量查询通用质量标准指标差异
     */
    private List<SLPD0501IDifGnqStdResult> findDifGnqStds(List<String> productIds) {
        if (CollectionUtils.isEmpty(productIds)) {
            return new ArrayList<>();
        }
        return this.slpd0501iDao.findDifGnqStds(productIds);
    }

    /**
     * 批量查询安全标准指标差异
     */
    private List<SLPD0501IDifSftStdResult> findDifSftStds(List<String> productIds) {
        if (CollectionUtils.isEmpty(productIds)) {
            return new ArrayList<>();
        }
        return this.slpd0501iDao.findDifSftStds(productIds);
    }

    /**
     * 批量查询储存运输标准指标差异
     */
    private List<SLPD0501IDifTspStdResult> findDifTspStds(List<String> productIds) {
        if (CollectionUtils.isEmpty(productIds)) {
            return new ArrayList<>();
        }
        return this.slpd0501iDao.findDifTspStds(productIds);
    }

    /**
     * 批量查询包装标准指标差异
     */
    private List<SLPD0501IDifPkgStdResult> findDifPkgStds(List<String> productIds) {
        if (CollectionUtils.isEmpty(productIds)) {
            return new ArrayList<>();
        }
        return this.slpd0501iDao.findDifPkgStds(productIds);
    }

    /**
     * 产品添加中文常量
     */
    private void fillCodeMasters(List<SLPD0501IProductResult> products) {
        Map<String, String> qualityGradeTypeMap = this.codeMasterUtils.getCodeMaster(CodeMasterConstant.QualityGradeType.NODE);
        Map<String, String> productAuditStuMap = this.codeMasterUtils.getCodeMaster(CodeMasterConstant.ProductAuditStu.NODE);
        Map<String, String> productSourceTypeMap = this.codeMasterUtils.getCodeMaster(CodeMasterConstant.ProductSourceType.NODE);
        Map<String, String> brandTypeMap = this.codeMasterUtils.getCodeMaster(CodeMasterConstant.BrandType.NODE);

        SLPD0501IBrandItemPropertyResult brandItemProperty = null;
        SLPD0501IBrandResult brand = null;

        for (SLPD0501IProductResult product : products) {
            product.setQualityGradeTypeStr(qualityGradeTypeMap.get(product.getQualityGradeType()));
            product.setAuditStuStr(productAuditStuMap.get(product.getAuditStu()));

            brandItemProperty = product.getBrandItemProperty();
            if (null != brandItemProperty) {
                brandItemProperty.setSourceTypeStr(productSourceTypeMap.get(brandItemProperty.getSourceType()));
                brandItemProperty.setQualityGradeTypeStr(qualityGradeTypeMap.get(brandItemProperty.getQualityGradeType()));
                brand = brandItemProperty.getBrand();
                if (null != brand) {
                    brand.setBrandTypeStr(brandTypeMap.get(brand.getBrandType()));
                }
            }
        }
    }

}