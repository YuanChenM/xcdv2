package com.bms.slpd.rest;

import com.bms.common.entity.DictNodeBean;
import com.bms.slpd.bean.param.SLPD0602IParam;
import com.bms.slpd.bean.result.SLPD0602IResult;
import com.bms.slpd.bean.result.field.SLPD0602IDifOrgStdResult;
import com.bms.slpd.bean.result.field.SLPD0602IOrgStdResult;
import com.bms.slpd.constant.CodeMasterConstant;
import com.bms.slpd.services.SLPD0602IService;
import com.bms.slpd.utils.CodeMasterUtils;
import com.bms.slpd.utils.MessageUtils;
import com.framework.boot.base.BaseRestController;
import com.framework.core.utils.CollectionUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@Api(description = "查询原种种源标准指标",
        tags = "SLPD0602IRestController")
public class SLPD0602IRestController extends BaseRestController {

    @Autowired
    private SLPD0602IService slpd0602IService;

    @Autowired
    private CodeMasterUtils codeMasterUtils;

    @ApiOperation(value = "查询原种种源标准指标",
            notes = "查询原种种源标准指标")
    @RequestMapping(value = "/products/origin/standards/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLPD0602IResult findOrgStds(@RequestBody SLPD0602IParam slpd0602IParam) {
        //查询所有的类型
        List<DictNodeBean> OrgStdTypeList = codeMasterUtils.getCodeMasters(CodeMasterConstant.OrgStdType.NODE);

        List<SLPD0602IOrgStdResult> slpdStds = null;
        List<SLPD0602IDifOrgStdResult> slpdDifs = null;
        if(CollectionUtils.isNotEmpty(slpd0602IParam.getProductIds())){
            slpdDifs = slpd0602IService.searchDif(slpd0602IParam);
            if(CollectionUtils.isEmpty(slpd0602IParam.getBreedIds()) && CollectionUtils.isNotEmpty(slpdDifs)){
                HashSet<Long> breedIdsSet = new HashSet<>();
                //去除重复breedId
                for (SLPD0602IDifOrgStdResult slpdDif : slpdDifs) {
                    breedIdsSet.add(slpdDif.getBreedId());
                }
                List list = new ArrayList();
                Iterator it = breedIdsSet.iterator();
                while (it.hasNext()) {
                    list.add(it.next());
                }
                //查询标准档案卡
                SLPD0602IParam findStdParam = new SLPD0602IParam();
                findStdParam.setBreedIds(list);
                slpdStds = slpd0602IService.searchStd(findStdParam);
            }
        }
        if(CollectionUtils.isNotEmpty(slpd0602IParam.getBreedIds())){
            slpdStds = slpd0602IService.searchStd(slpd0602IParam);
            if (slpd0602IParam.getFindAllFlag() == 1 && CollectionUtils.isEmpty(slpdDifs)) {
                slpdDifs = slpd0602IService.searchDif(slpd0602IParam);
            }
        }

        List<SLPD0602IOrgStdResult> slpdOrgStdResults = this.resetStdDate(OrgStdTypeList,slpdStds,slpd0602IParam.getBreedIds());
        List<SLPD0602IDifOrgStdResult> slpdDifsResults = this.resetDifOrgDate(OrgStdTypeList,slpdDifs,slpd0602IParam);

        SLPD0602IResult slpd = this.getResult(slpdOrgStdResults,slpdDifsResults,slpd0602IParam);
        slpd.setMessage(MessageUtils.getSuccessMessage());
        return slpd;
    }


    private SLPD0602IResult getResult(List<SLPD0602IOrgStdResult> slpdStds,List<SLPD0602IDifOrgStdResult> slpdDifs,SLPD0602IParam param){
        SLPD0602IResult slpd = new SLPD0602IResult();
        slpd.setSlpdStds(this.setStdResultList(slpdStds,param));
        if(param.getFindAllFlag() == 1){
            slpd.setSlpdDifStds(this.setDifStdResultList(slpdDifs,param));
        }
        return slpd;
    }


    //标准档案卡
    private Map<Long,List<SLPD0602IOrgStdResult>> setStdResultList(List<SLPD0602IOrgStdResult> slpdStds, SLPD0602IParam param){
        Map<Long, List<SLPD0602IOrgStdResult>> resultStdMap = new HashMap<>();
        if(CollectionUtils.isNotEmpty(slpdStds) && CollectionUtils.isNotEmpty(param.getBreedIds())){
            List<SLPD0602IOrgStdResult> list = null;
            for(Long breedId : param.getBreedIds()){
                list = new ArrayList<>();
                for(SLPD0602IOrgStdResult std : slpdStds){
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
    private Map<Object,List<SLPD0602IDifOrgStdResult>> setDifStdResultList(List<SLPD0602IDifOrgStdResult> slpdDifs,SLPD0602IParam param){
        Map<Object, List<SLPD0602IDifOrgStdResult>> resultDifStdMap = new HashMap<>();
        if(CollectionUtils.isNotEmpty(slpdDifs)){
            List<SLPD0602IDifOrgStdResult> list = null;
            if(CollectionUtils.isNotEmpty(param.getBreedIds())){
                for(Long breedId : param.getBreedIds()){
                    list = new ArrayList<>();
                    for(SLPD0602IDifOrgStdResult std :slpdDifs){
                        if(breedId.equals(std.getBreedId())){
                            list.add(std);
                        }
                    }
                    resultDifStdMap.put(breedId,list);
                }
            }else if(CollectionUtils.isNotEmpty(param.getProductIds())){
                for(String pruductId : param.getProductIds()){
                    list = new ArrayList<>();
                    for(SLPD0602IDifOrgStdResult std :slpdDifs){
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
    private List<SLPD0602IOrgStdResult> resetStdDate(List<DictNodeBean> OrgStdTypeList,List<SLPD0602IOrgStdResult> slpdStds,List<Long> breedIds){
        List<SLPD0602IOrgStdResult> slpdOrgStdResults = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(OrgStdTypeList) && CollectionUtils.isNotEmpty(breedIds)){
            SLPD0602IOrgStdResult orgStd = null;
            for(Long brandId : breedIds){
                for(DictNodeBean type : OrgStdTypeList){
                    boolean flg = true;
                    if(CollectionUtils.isNotEmpty(slpdStds)){
                        for(SLPD0602IOrgStdResult result : slpdStds){
                            if(brandId.equals(result.getBreedId()) && type.getDataValue().equals(result.getOrgStdType().toString())){
                                flg = false;
                                result.setOrgStdType(Long.valueOf(type.getDataValue()));
                                result.setOrgStdTypeStr(type.getDataCN());
                                slpdOrgStdResults.add(result);
                                break;
                            }
                        }
                    }
                    if(flg){
                        orgStd = new SLPD0602IOrgStdResult();
                        orgStd.setOrgStdType(Long.valueOf(type.getDataValue()));
                        orgStd.setOrgStdTypeStr(type.getDataCN());
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
    private List<SLPD0602IDifOrgStdResult> resetDifOrgDate(List<DictNodeBean> OrgStdTypeList,List<SLPD0602IDifOrgStdResult> slpdDifs,SLPD0602IParam param){
        List<SLPD0602IDifOrgStdResult> slpdDifOrgStdResults = new ArrayList<>();
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
    private List<SLPD0602IDifOrgStdResult> allNotNull(List<DictNodeBean> OrgStdTypeList,List<SLPD0602IDifOrgStdResult> slpdDifs,SLPD0602IParam param){
        List<SLPD0602IDifOrgStdResult> slpdDifOrgStdResults = new ArrayList<>();
        SLPD0602IDifOrgStdResult orgStd = null;
        for(Long breedId : param.getBreedIds()){
            for(String productId : param.getProductIds()){
                for(DictNodeBean type : OrgStdTypeList){
                    boolean flg = true;
                    if(CollectionUtils.isNotEmpty(slpdDifs)){
                        for(SLPD0602IDifOrgStdResult result : slpdDifs){
                            if(breedId.equals(result.getBreedId()) && productId.equals(result.getProductId()) && type.getDataValue().equals(result.getOrgStdType().toString())){
                                flg = false;
                                result.setOrgStdType(Long.valueOf(type.getDataValue()));
                                result.setOrgStdTypeStr(type.getDataCN());
                                slpdDifOrgStdResults.add(result);
                                break;
                            }
                        }
                    }
                    if(flg){
                        orgStd = new SLPD0602IDifOrgStdResult();
                        orgStd.setOrgStdType(Long.valueOf(type.getDataValue()));
                        orgStd.setOrgStdTypeStr(type.getDataCN());
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
    private List<SLPD0602IDifOrgStdResult> breedIdNotNull(List<DictNodeBean> OrgStdTypeList,List<SLPD0602IDifOrgStdResult> slpdDifs,SLPD0602IParam param){
        List<SLPD0602IDifOrgStdResult> slpdDifOrgStdResults = new ArrayList<>();
        SLPD0602IDifOrgStdResult orgStd = null;
        for(Long breedId : param.getBreedIds()){
            for(DictNodeBean type : OrgStdTypeList){
                boolean flg = true;
                if(CollectionUtils.isNotEmpty(slpdDifs)){
                    for(SLPD0602IDifOrgStdResult result : slpdDifs){
                        if(breedId.equals(result.getBreedId()) && type.getDataValue().equals(result.getOrgStdType().toString())){
                            flg = false;
                            result.setOrgStdType(Long.valueOf(type.getDataValue()));
                            result.setOrgStdTypeStr(type.getDataCN());
                            slpdDifOrgStdResults.add(result);
                            break;
                        }
                    }
                }
                if(flg){
                    orgStd = new SLPD0602IDifOrgStdResult();
                    orgStd.setOrgStdType(Long.valueOf(type.getDataValue()));
                    orgStd.setOrgStdTypeStr(type.getDataCN());
                    orgStd.setBreedId(breedId);
                    slpdDifOrgStdResults.add(orgStd);
                }
            }
        }
        return slpdDifOrgStdResults;
    }

    //产品ID不为空
    private List<SLPD0602IDifOrgStdResult> productIdNotNull(List<DictNodeBean> OrgStdTypeList,List<SLPD0602IDifOrgStdResult> slpdDifs,SLPD0602IParam param){
        List<SLPD0602IDifOrgStdResult> slpdDifOrgStdResults = new ArrayList<>();
        SLPD0602IDifOrgStdResult orgStd = null;
        for(String productId : param.getProductIds()){
            for(DictNodeBean type : OrgStdTypeList){
                boolean flg = true;
                if(CollectionUtils.isNotEmpty(slpdDifs)){
                    for(SLPD0602IDifOrgStdResult result : slpdDifs){
                        if(productId.equals(result.getProductId()) && type.getDataValue().equals(result.getOrgStdType().toString())){
                            flg = false;
                            result.setOrgStdType(Long.valueOf(type.getDataValue()));
                            result.setOrgStdTypeStr(type.getDataCN());
                            slpdDifOrgStdResults.add(result);
                            break;
                        }
                    }
                }
                if(flg){
                    orgStd = new SLPD0602IDifOrgStdResult();
                    orgStd.setOrgStdType(Long.valueOf(type.getDataValue()));
                    orgStd.setOrgStdTypeStr(type.getDataCN());
                    orgStd.setProductId(productId);
                    slpdDifOrgStdResults.add(orgStd);
                }
            }
        }
        return slpdDifOrgStdResults;
    }
}
