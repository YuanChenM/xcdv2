package com.bms.slpd.services.impl;

import com.bms.common.entity.DictNodeBean;
import com.bms.slpd.bean.entity.SlpdProduct;
import com.bms.slpd.bean.param.SLPD0608IParam;
import com.bms.slpd.bean.result.SLPD0608IResult;
import com.bms.slpd.bean.result.field.SLPD0608IDifMctStdResult;
import com.bms.slpd.bean.result.field.SLPD0608IMctStdResult;
import com.bms.slpd.constant.CodeMasterConstant;
import com.bms.slpd.dao.SLPD0608IDao;
import com.bms.slpd.services.SLPD0608IService;
import com.bms.slpd.utils.CodeMasterUtils;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SLPD0608IServiceImpl extends BaseServiceImpl implements SLPD0608IService {

    @Autowired
    private SLPD0608IDao slpd0608IDao;

    @Autowired
    private CodeMasterUtils codeMasterUtils;

    @Override
    public BaseDao getBaseDao() {
        return slpd0608IDao;
    }

    @Override
    public SLPD0608IParam setParamIds(SLPD0608IParam param) {
        if (CollectionUtils.isNotEmpty(param.getBreedIds()) && CollectionUtils.isEmpty(param.getProductIds())) {
            return param;
        } else {
            SLPD0608IParam result = new SLPD0608IParam();
            List<Long> breedIds = new ArrayList<>();
            List<String> productIds = new ArrayList<>();
            List<SlpdProduct> idList = slpd0608IDao.findSlpdProducts(param);
            for (SlpdProduct product : idList) {
                if (!breedIds.contains(product.getBreedId())) {
                    breedIds.add(product.getBreedId());
                }
                productIds.add(product.getProductId());
            }
            result.setBreedIds(breedIds);
            result.setProductIds(productIds);
            return result;
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SLPD0608IResult findMctStdsAndDifStds(SLPD0608IParam param) {
        //查询所有的类型
        List<DictNodeBean> mctStdTypeList = codeMasterUtils.getCodeMasters(CodeMasterConstant.MctStdType.NODE);

        List<SLPD0608IMctStdResult> slpdStds = null;
        List<SLPD0608IDifMctStdResult> slpdDifs = null;
        if(CollectionUtils.isNotEmpty(param.getProductIds())){
            slpdDifs = slpd0608IDao.findMctDifStds(param);
            if(CollectionUtils.isEmpty(param.getBreedIds()) && CollectionUtils.isNotEmpty(slpdDifs)){
                HashSet<Long> breedIdsSet = new HashSet<>();
                //去除重复breedId
                for (SLPD0608IDifMctStdResult slpdDif : slpdDifs) {
                    breedIdsSet.add(slpdDif.getBreedId());
                }
                List list = new ArrayList();
                Iterator it = breedIdsSet.iterator();
                while (it.hasNext()) {
                    list.add(it.next());
                }
                //查询标准档案卡
                SLPD0608IParam findStdParam = new SLPD0608IParam();
                findStdParam.setBreedIds(list);
                slpdStds = slpd0608IDao.findMctStds(findStdParam);
            }
        }
        if(CollectionUtils.isNotEmpty(param.getBreedIds())){
            slpdStds = slpd0608IDao.findMctStds(param);
            if (param.getFindAllFlag() == 1 && CollectionUtils.isEmpty(slpdDifs)) {
                slpdDifs = slpd0608IDao.findMctDifStds(param);
            }
        }

        List<SLPD0608IMctStdResult> slpdOrgStdResults = this.resetStdDate(mctStdTypeList,slpdStds,param.getBreedIds());
        List<SLPD0608IDifMctStdResult> slpdDifsResults = this.resetDifOrgDate(mctStdTypeList,slpdDifs,param);

        SLPD0608IResult slpd = this.getResult(slpdOrgStdResults,slpdDifsResults,param);
        return slpd;
    }


    private SLPD0608IResult getResult(List<SLPD0608IMctStdResult> slpdStds,List<SLPD0608IDifMctStdResult> slpdDifs,SLPD0608IParam param){
        SLPD0608IResult slpd = new SLPD0608IResult();
        slpd.setSlpdStds(this.setStdResultList(slpdStds,param));
        if(param.getFindAllFlag() == 1){
            slpd.setSlpdDifStds(this.setDifStdResultList(slpdDifs,param));
        }
        return slpd;
    }


    //标准档案卡
    private Map<Long,List<SLPD0608IMctStdResult>> setStdResultList(List<SLPD0608IMctStdResult> slpdStds, SLPD0608IParam param){
        Map<Long, List<SLPD0608IMctStdResult>> resultStdMap = new HashMap<>();
        if(CollectionUtils.isNotEmpty(slpdStds) && CollectionUtils.isNotEmpty(param.getBreedIds())){
            List<SLPD0608IMctStdResult> list = null;
            for(Long breedId : param.getBreedIds()){
                list = new ArrayList<>();
                for(SLPD0608IMctStdResult std : slpdStds){
                    if(breedId.equals(std.getBreedId())){
                        list.add(std);
                    }
                }
                resultStdMap.put(breedId,list);
            }
        }
        return resultStdMap;
    }


    //差异卡
    private Map<Object,List<SLPD0608IDifMctStdResult>> setDifStdResultList(List<SLPD0608IDifMctStdResult> slpdDifs,SLPD0608IParam param){
        Map<Object, List<SLPD0608IDifMctStdResult>> resultDifStdMap = new HashMap<>();
        if(CollectionUtils.isNotEmpty(slpdDifs) && CollectionUtils.isNotEmpty(param.getProductIds())){
            List<SLPD0608IDifMctStdResult> list = null;
            if(CollectionUtils.isNotEmpty(param.getBreedIds())){
                for(Long breedId : param.getBreedIds()){
                    list = new ArrayList<>();
                    for(SLPD0608IDifMctStdResult std :slpdDifs){
                        if(breedId.equals(std.getBreedId())){
                            list.add(std);
                        }
                    }
                    resultDifStdMap.put(breedId,list);
                }
            }else if(CollectionUtils.isNotEmpty(param.getProductIds())){
                for(String pruductId : param.getProductIds()){
                    list = new ArrayList<>();
                    for(SLPD0608IDifMctStdResult std :slpdDifs){
                        if(pruductId.equals(std.getProductId())){
                            list.add(std);
                        }
                    }
                    resultDifStdMap.put(pruductId,list);
                }
            }
        }
        return resultDifStdMap;
    }





    /**
     * 档案卡数据
     * @param OrgStdTypeList
     * @param slpdStds
     * @param breedIds
     * @return
     */
    private List<SLPD0608IMctStdResult> resetStdDate(List<DictNodeBean> OrgStdTypeList,List<SLPD0608IMctStdResult> slpdStds,List<Long> breedIds){
        List<SLPD0608IMctStdResult> slpdOrgStdResults = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(OrgStdTypeList) && CollectionUtils.isNotEmpty(breedIds)){
            SLPD0608IMctStdResult orgStd = null;
            for(Long brandId : breedIds){
                for(DictNodeBean type : OrgStdTypeList){
                    boolean flg = true;
                    if(CollectionUtils.isNotEmpty(slpdStds)){
                        for(SLPD0608IMctStdResult result : slpdStds){
                            if(brandId.equals(result.getBreedId()) && type.getDataValue().equals(result.getMctStdType().toString())){
                                flg = false;
                                result.setMctStdType(Long.valueOf(type.getDataValue()));
                                result.setMctStdTypeStr(type.getDataCN());
                                slpdOrgStdResults.add(result);
                                break;
                            }
                        }
                    }
                    if(flg){
                        orgStd = new SLPD0608IMctStdResult();
                        orgStd.setMctStdType(Long.valueOf(type.getDataValue()));
                        orgStd.setMctStdTypeStr(type.getDataCN());
                        orgStd.setBreedId(brandId);
                        slpdOrgStdResults.add(orgStd);
                    }
                }
            }
        }
        return slpdOrgStdResults;
    }


    /**
     * 差异卡数据
     * @param OrgStdTypeList
     * @param slpdDifs
     * @param param
     * @return
     */
    private List<SLPD0608IDifMctStdResult> resetDifOrgDate(List<DictNodeBean> OrgStdTypeList,List<SLPD0608IDifMctStdResult> slpdDifs,SLPD0608IParam param){
        List<SLPD0608IDifMctStdResult> slpdDifOrgStdResults = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(OrgStdTypeList)){
            if(CollectionUtils.isNotEmpty(param.getBreedIds()) && CollectionUtils.isNotEmpty(param.getProductIds())){
                slpdDifOrgStdResults = this.allNotNull(OrgStdTypeList,slpdDifs,param);
            }else if (CollectionUtils.isNotEmpty(param.getBreedIds())){
                slpdDifOrgStdResults = this.breedIdNotNull(OrgStdTypeList,slpdDifs,param);
            }else if(CollectionUtils.isNotEmpty(param.getProductIds())){
                slpdDifOrgStdResults = this.productIdNotNull(OrgStdTypeList,slpdDifs,param);
            }
        }
        return slpdDifOrgStdResults;
    }


    //都不为空
    private List<SLPD0608IDifMctStdResult> allNotNull(List<DictNodeBean> OrgStdTypeList,List<SLPD0608IDifMctStdResult> slpdDifs,SLPD0608IParam param){
        List<SLPD0608IDifMctStdResult> slpdDifOrgStdResults = new ArrayList<>();
        SLPD0608IDifMctStdResult orgStd = null;
        for(Long breedId : param.getBreedIds()){
            for(String productId : param.getProductIds()){
                for(DictNodeBean type : OrgStdTypeList){
                    boolean flg = true;
                    if(CollectionUtils.isNotEmpty(slpdDifs)){
                        for(SLPD0608IDifMctStdResult result : slpdDifs){
                            if(breedId.equals(result.getBreedId()) && productId.equals(result.getProductId()) && type.getDataValue().equals(result.getMctStdType().toString())){
                                flg = false;
                                result.setMctStdType(Long.valueOf(type.getDataValue()));
                                result.setMctStdTypeStr(type.getDataCN());
                                slpdDifOrgStdResults.add(result);
                                break;
                            }
                        }
                    }
                    if(flg){
                        orgStd = new SLPD0608IDifMctStdResult();
                        orgStd.setMctStdType(Long.valueOf(type.getDataValue()));
                        orgStd.setMctStdTypeStr(type.getDataCN());
                        orgStd.setBreedId(breedId);
                        orgStd.setProductId(productId);
                        slpdDifOrgStdResults.add(orgStd);
                    }
                }
            }
        }
        return slpdDifOrgStdResults;
    }

    //品种ID不为空
    private List<SLPD0608IDifMctStdResult> breedIdNotNull(List<DictNodeBean> OrgStdTypeList,List<SLPD0608IDifMctStdResult> slpdDifs,SLPD0608IParam param){
        List<SLPD0608IDifMctStdResult> slpdDifOrgStdResults = new ArrayList<>();
        SLPD0608IDifMctStdResult orgStd = null;
        for(Long breedId : param.getBreedIds()){
            for(DictNodeBean type : OrgStdTypeList){
                boolean flg = true;
                if(CollectionUtils.isNotEmpty(slpdDifs)){
                    for(SLPD0608IDifMctStdResult result : slpdDifs){
                        if(breedId.equals(result.getBreedId()) && type.getDataValue().equals(result.getMctStdType().toString())){
                            flg = false;
                            result.setMctStdType(Long.valueOf(type.getDataValue()));
                            result.setMctStdTypeStr(type.getDataCN());
                            slpdDifOrgStdResults.add(result);
                            break;
                        }
                    }
                }
                if(flg){
                    orgStd = new SLPD0608IDifMctStdResult();
                    orgStd.setMctStdType(Long.valueOf(type.getDataValue()));
                    orgStd.setMctStdTypeStr(type.getDataCN());
                    orgStd.setBreedId(breedId);
                    slpdDifOrgStdResults.add(orgStd);
                }
            }
        }
        return slpdDifOrgStdResults;
    }

    //产品ID不为空
    private List<SLPD0608IDifMctStdResult> productIdNotNull(List<DictNodeBean> OrgStdTypeList,List<SLPD0608IDifMctStdResult> slpdDifs,SLPD0608IParam param){
        List<SLPD0608IDifMctStdResult> slpdDifOrgStdResults = new ArrayList<>();
        SLPD0608IDifMctStdResult orgStd = null;
        for(String productId : param.getProductIds()){
            for(DictNodeBean type : OrgStdTypeList){
                boolean flg = true;
                if(CollectionUtils.isNotEmpty(slpdDifs)){
                    for(SLPD0608IDifMctStdResult result : slpdDifs){
                        if(productId.equals(result.getProductId()) && type.getDataValue().equals(result.getMctStdType().toString())){
                            flg = false;
                            result.setMctStdType(Long.valueOf(type.getDataValue()));
                            result.setMctStdTypeStr(type.getDataCN());
                            slpdDifOrgStdResults.add(result);
                            break;
                        }
                    }
                }
                if(flg){
                    orgStd = new SLPD0608IDifMctStdResult();
                    orgStd.setMctStdType(Long.valueOf(type.getDataValue()));
                    orgStd.setMctStdTypeStr(type.getDataCN());
                    orgStd.setProductId(productId);
                    slpdDifOrgStdResults.add(orgStd);
                }
            }
        }
        return slpdDifOrgStdResults;
    }
}
