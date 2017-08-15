package com.bms.slpd.services.impl;

import com.bms.common.entity.DictNodeBean;
import com.bms.slpd.bean.param.SLPD0605IParam;
import com.bms.slpd.bean.result.SLPD0605IResult;
import com.bms.slpd.bean.result.field.SLPD0605IDifFedStdResult;
import com.bms.slpd.bean.result.field.SLPD0605IFedStdResult;
import com.bms.slpd.constant.CodeMasterConstant;
import com.bms.slpd.dao.SLPD0605IDao;
import com.bms.slpd.services.SLPD0605IService;
import com.bms.slpd.utils.CodeMasterUtils;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.*;

/*
 *查询饲养指标档案卡与差异卡
 */
@Service
public class SLPD0605IServiceImpl extends BaseServiceImpl implements SLPD0605IService {

    @Autowired
    private SLPD0605IDao slpd0605IDao;

    @Autowired
    private CodeMasterUtils codeMasterUtils;

    @Override
    public BaseDao getBaseDao() {
        return slpd0605IDao;
    }

    /**
     * 查询饲养指标差异卡
     */
    @Override
    public List<SLPD0605IFedStdResult> searchStd(Serializable var1) {
        return slpd0605IDao.searchStd(var1);
    }


    /**
     * 查询饲养指标标准卡
     */
    @Override
    public List<SLPD0605IDifFedStdResult> searchDif(Serializable var1) {
        return slpd0605IDao.searchDif(var1);
    }


    /**
     * 查询饲养指标标准卡与差异卡
     */
    @Override
    public SLPD0605IResult searchDifAndStdFeds(SLPD0605IParam param) {
        //查询所有的类型
        List<DictNodeBean> fedStdTypeList = codeMasterUtils.getCodeMasters(CodeMasterConstant.FedStdType.NODE);

        List<SLPD0605IFedStdResult> slpdStds = null;
        List<SLPD0605IDifFedStdResult> slpdDifs = null;

        if(CollectionUtils.isNotEmpty(param.getProductIds())){
            slpdDifs = this.searchDif(param);
            if(CollectionUtils.isEmpty(param.getBreedIds()) && CollectionUtils.isNotEmpty(slpdDifs)){
                HashSet<Long> breedIdsSet = new HashSet<>();
                //去除重复breedId
                for (SLPD0605IDifFedStdResult slpdDif : slpdDifs) {
                    breedIdsSet.add(slpdDif.getBreedId());
                }
                List list = new ArrayList();
                Iterator it = breedIdsSet.iterator();
                while (it.hasNext()) {
                    list.add(it.next());
                }
                //查询标准档案卡
                SLPD0605IParam findStdParam = new SLPD0605IParam();
                findStdParam.setBreedIds(list);
                slpdStds = this.searchStd(findStdParam);
            }
        }
        if(CollectionUtils.isNotEmpty(param.getBreedIds())){
            slpdStds = this.searchStd(param);
            if (param.getFindAllFlag() == 1 && CollectionUtils.isEmpty(slpdDifs)) {
                slpdDifs = this.searchDif(param);
            }
        }

        List<SLPD0605IFedStdResult> slpdStdResult = this.resetStdDate(fedStdTypeList,slpdStds,param.getBreedIds());
        List<SLPD0605IDifFedStdResult> slpdDifStdResult = this.resetDifOrgDate(fedStdTypeList,slpdDifs,param);
        SLPD0605IResult slpd = this.getResult(slpdStdResult,slpdDifStdResult,param);
        return slpd;
    }


    private SLPD0605IResult getResult(List<SLPD0605IFedStdResult> slpdStds,List<SLPD0605IDifFedStdResult> slpdDifs,SLPD0605IParam param){
        SLPD0605IResult slpd = new SLPD0605IResult();
        slpd.setSlpdStds(this.setStdResultList(slpdStds,param));
        if(param.getFindAllFlag() == 1){
            slpd.setSlpdDifStds(this.setDifStdResultList(slpdDifs,param));
        }
        return slpd;
    }


    //标准档案卡
    private Map<Long,List<SLPD0605IFedStdResult>> setStdResultList(List<SLPD0605IFedStdResult> slpdStds, SLPD0605IParam param){
        Map<Long, List<SLPD0605IFedStdResult>> resultStdMap = new HashMap<>();
        if(CollectionUtils.isNotEmpty(slpdStds) && CollectionUtils.isNotEmpty(param.getBreedIds())){
            List<SLPD0605IFedStdResult> list = null;
            for(Long breedId : param.getBreedIds()){
                list = new ArrayList<>();
                for(SLPD0605IFedStdResult std : slpdStds){
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
    private Map<Object,List<SLPD0605IDifFedStdResult>> setDifStdResultList(List<SLPD0605IDifFedStdResult> slpdDifs,SLPD0605IParam param){
        Map<Object, List<SLPD0605IDifFedStdResult>> resultDifStdMap = new HashMap<>();
        if(CollectionUtils.isNotEmpty(slpdDifs) && CollectionUtils.isNotEmpty(param.getBreedIds())){
            List<SLPD0605IDifFedStdResult> list = null;
            if(CollectionUtils.isNotEmpty(param.getBreedIds())){
                for(Long breedId : param.getBreedIds()){
                    list = new ArrayList<>();
                    for(SLPD0605IDifFedStdResult std :slpdDifs){
                        if(breedId.equals(std.getBreedId())){
                            list.add(std);
                        }
                    }
                    resultDifStdMap.put(breedId,list);
                }
            }else if(CollectionUtils.isNotEmpty(param.getProductIds())){
                for(String pruductId : param.getProductIds()){
                    list = new ArrayList<>();
                    for(SLPD0605IDifFedStdResult std :slpdDifs){
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
    private List<SLPD0605IFedStdResult> resetStdDate(List<DictNodeBean> OrgStdTypeList,List<SLPD0605IFedStdResult> slpdStds,List<Long> breedIds){
        List<SLPD0605IFedStdResult> slpdOrgStdResults = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(OrgStdTypeList) && CollectionUtils.isNotEmpty(breedIds)){
            SLPD0605IFedStdResult orgStd = null;
            for(Long brandId : breedIds){
                for(DictNodeBean type : OrgStdTypeList){
                    boolean flg = true;
                    if(CollectionUtils.isNotEmpty(slpdStds)){
                        for(SLPD0605IFedStdResult result : slpdStds){
                            if(brandId.equals(result.getBreedId()) && type.getDataValue().equals(result.getFedStdType().toString())){
                                flg = false;
                                result.setFedStdType(Long.valueOf(type.getDataValue()));
                                result.setFedStdTypeStr(type.getDataCN());
                                slpdOrgStdResults.add(result);
                                break;
                            }
                        }
                    }
                    if(flg){
                        orgStd = new SLPD0605IFedStdResult();
                        orgStd.setFedStdType(Long.valueOf(type.getDataValue()));
                        orgStd.setFedStdTypeStr(type.getDataCN());
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
    private List<SLPD0605IDifFedStdResult> resetDifOrgDate(List<DictNodeBean> OrgStdTypeList,List<SLPD0605IDifFedStdResult> slpdDifs,SLPD0605IParam param){
        List<SLPD0605IDifFedStdResult> slpdDifOrgStdResults = new ArrayList<>();
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
    private List<SLPD0605IDifFedStdResult> allNotNull(List<DictNodeBean> OrgStdTypeList,List<SLPD0605IDifFedStdResult> slpdDifs,SLPD0605IParam param){
        List<SLPD0605IDifFedStdResult> slpdDifOrgStdResults = new ArrayList<>();
        SLPD0605IDifFedStdResult orgStd = null;
        for(Long breedId : param.getBreedIds()){
            for(String productId : param.getProductIds()){
                for(DictNodeBean type : OrgStdTypeList){
                    boolean flg = true;
                    if(CollectionUtils.isNotEmpty(slpdDifs)){
                        for(SLPD0605IDifFedStdResult result : slpdDifs){
                            if(breedId.equals(result.getBreedId()) && productId.equals(result.getProductId()) && type.getDataValue().equals(result.getFedStdType().toString())){
                                flg = false;
                                result.setFedStdType(Long.valueOf(type.getDataValue()));
                                result.setFedStdTypeStr(type.getDataCN());
                                slpdDifOrgStdResults.add(result);
                                break;
                            }
                        }
                    }
                    if(flg){
                        orgStd = new SLPD0605IDifFedStdResult();
                        orgStd.setFedStdType(Long.valueOf(type.getDataValue()));
                        orgStd.setFedStdTypeStr(type.getDataCN());
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
    private List<SLPD0605IDifFedStdResult> breedIdNotNull(List<DictNodeBean> OrgStdTypeList,List<SLPD0605IDifFedStdResult> slpdDifs,SLPD0605IParam param){
        List<SLPD0605IDifFedStdResult> slpdDifOrgStdResults = new ArrayList<>();
        SLPD0605IDifFedStdResult orgStd = null;
        for(Long breedId : param.getBreedIds()){
            for(DictNodeBean type : OrgStdTypeList){
                boolean flg = true;
                if(CollectionUtils.isNotEmpty(slpdDifs)){
                    for(SLPD0605IDifFedStdResult result : slpdDifs){
                        if(breedId.equals(result.getBreedId()) && type.getDataValue().equals(result.getFedStdType().toString())){
                            flg = false;
                            result.setFedStdType(Long.valueOf(type.getDataValue()));
                            result.setFedStdTypeStr(type.getDataCN());
                            slpdDifOrgStdResults.add(result);
                            break;
                        }
                    }
                }
                if(flg){
                    orgStd = new SLPD0605IDifFedStdResult();
                    orgStd.setFedStdType(Long.valueOf(type.getDataValue()));
                    orgStd.setFedStdTypeStr(type.getDataCN());
                    orgStd.setBreedId(breedId);
                    slpdDifOrgStdResults.add(orgStd);
                }
            }
        }
        return slpdDifOrgStdResults;
    }

    //产品ID不为空
    private List<SLPD0605IDifFedStdResult> productIdNotNull(List<DictNodeBean> OrgStdTypeList,List<SLPD0605IDifFedStdResult> slpdDifs,SLPD0605IParam param){
        List<SLPD0605IDifFedStdResult> slpdDifOrgStdResults = new ArrayList<>();
        SLPD0605IDifFedStdResult orgStd = null;
        for(String productId : param.getProductIds()){
            for(DictNodeBean type : OrgStdTypeList){
                boolean flg = true;
                if(CollectionUtils.isNotEmpty(slpdDifs)){
                    for(SLPD0605IDifFedStdResult result : slpdDifs){
                        if(productId.equals(result.getProductId()) && type.getDataValue().equals(result.getFedStdType().toString())){
                            flg = false;
                            result.setFedStdType(Long.valueOf(type.getDataValue()));
                            result.setFedStdTypeStr(type.getDataCN());
                            slpdDifOrgStdResults.add(result);
                            break;
                        }
                    }
                }
                if(flg){
                    orgStd = new SLPD0605IDifFedStdResult();
                    orgStd.setFedStdType(Long.valueOf(type.getDataValue()));
                    orgStd.setFedStdTypeStr(type.getDataCN());
                    orgStd.setProductId(productId);
                    slpdDifOrgStdResults.add(orgStd);
                }
            }
        }
        return slpdDifOrgStdResults;
    }

}