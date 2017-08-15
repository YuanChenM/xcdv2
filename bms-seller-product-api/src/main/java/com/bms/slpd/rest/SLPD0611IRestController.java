package com.bms.slpd.rest;

import com.bms.common.entity.DictNodeBean;
import com.bms.slpd.bean.entity.SlpdDifDiscussStd;
import com.bms.slpd.bean.entity.SlpdDiscussStd;
import com.bms.slpd.bean.param.SLPD0611IParam;
import com.bms.slpd.bean.result.SLPD0611IResult;
import com.bms.slpd.bean.result.field.SLPD0611IDifTncStdResult;
import com.bms.slpd.bean.result.field.SLPD0611ITncStdResult;
import com.bms.slpd.constant.CodeMasterConstant;
import com.bms.slpd.services.SLPD0611IService;
import com.bms.slpd.utils.CodeMasterUtils;
import com.bms.slpd.utils.MessageUtils;
import com.framework.boot.base.BaseRestController;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
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
@Api(description = "查询加工质量标准",tags = "SLPD0611IRestController")
public class SLPD0611IRestController extends BaseRestController {

    @Autowired
    private SLPD0611IService slpd0611IService;

    @Autowired
    private CodeMasterUtils codeMasterUtils;

    @ApiOperation(value = "查询加工质量标准",
            notes = "查询加工质量标准")
    @RequestMapping(value = "/products/process/quality/standards/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLPD0611IResult findTncStds(@RequestBody SLPD0611IParam slpd0611IParam) {
        SLPD0611IResult slpd = new SLPD0611IResult();
        //标准档案卡
        List<SLPD0611ITncStdResult> slpdStds = null;
        //差异卡
        List<SLPD0611IDifTncStdResult> slpdDifs = null;

        if(CollectionUtils.isNotEmpty(slpd0611IParam.getProductIds())){
            slpdDifs = slpd0611IService.searchDif(slpd0611IParam);
            if(CollectionUtils.isEmpty(slpd0611IParam.getBreedIds()) && CollectionUtils.isNotEmpty(slpdDifs)){
                HashSet<Long> breedIdsSet = new HashSet<>();
                //去除重复breedId
                for (SLPD0611IDifTncStdResult slpdDif : slpdDifs) {
                    breedIdsSet.add(slpdDif.getBreedId());
                }
                List list = new ArrayList();
                Iterator it = breedIdsSet.iterator();
                while (it.hasNext()) {
                    list.add(it.next());
                }
                //查询标准档案卡
                SLPD0611IParam findStdParam = new SLPD0611IParam();
                findStdParam.setBreedIds(list);
                slpdStds = slpd0611IService.searchStd(findStdParam);
            }
        }
        if(CollectionUtils.isNotEmpty(slpd0611IParam.getBreedIds())){
            slpdStds = slpd0611IService.searchStd(slpd0611IParam);
            if (slpd0611IParam.getFindAllFlag() == 1 && CollectionUtils.isEmpty(slpdDifs)) {
                slpdDifs = slpd0611IService.searchDif(slpd0611IParam);
            }
        }

        //标准档案卡
        Map<Long, List<SLPD0611ITncStdResult>> resultStdMap = new HashMap<>();
        if(CollectionUtils.isNotEmpty(slpdStds)){
            for (SLPD0611ITncStdResult results : slpdStds) {
                if (resultStdMap.containsKey(results.getBreedId())) {
                    List<SLPD0611ITncStdResult> list = resultStdMap.get(results.getBreedId());
                    list.add(results);
                } else {
                    List<SLPD0611ITncStdResult> list = new ArrayList<>();
                    list.add(results);
                    resultStdMap.put(results.getBreedId(), list);
                }
            }
        }


        //差异卡
        Map<Object, List<SLPD0611IDifTncStdResult>> resultDifStdMap = new HashMap<>();
        if(CollectionUtils.isNotEmpty(slpdDifs)){
            if(CollectionUtils.isNotEmpty(slpd0611IParam.getBreedIds())){
                List<SLPD0611IDifTncStdResult> list = null;
                if(CollectionUtils.isNotEmpty(slpd0611IParam.getBreedIds())){
                    for(Long breedId : slpd0611IParam.getBreedIds()){
                        list = new ArrayList<>();
                        for(SLPD0611IDifTncStdResult std :slpdDifs){
                            if(breedId.equals(std.getBreedId())){
                                list.add(std);
                            }
                        }
                        resultDifStdMap.put(breedId,list);
                    }
                }else if(CollectionUtils.isNotEmpty(slpd0611IParam.getProductIds())){
                    for(String pruductId : slpd0611IParam.getProductIds()){
                        list = new ArrayList<>();
                        for(SLPD0611IDifTncStdResult std :slpdDifs){
                            if(pruductId.equals(std.getProductId())){
                                list.add(std);
                            }
                        }
                        resultDifStdMap.put(pruductId,list);
                    }
                }
            }
        }
        slpd.setSlpdStds(this.setStdResultMap(resultStdMap,slpd0611IParam.getBreedIds()));
        if(slpd0611IParam.getFindAllFlag() == 1){
            slpd.setSlpdDifStds(this.setDifStdResultMap(resultDifStdMap,slpd0611IParam));
        }
        slpd.setMessage(MessageUtils.getSuccessMessage());
        return slpd;
    }


    //设置标准档案卡数据
    private  Map<Long, List<SLPD0611ITncStdResult>> setStdResultMap(Map<Long, List<SLPD0611ITncStdResult>> resultStdMap,List<Long> breedIds){
        //查询所有的类型
        List<DictNodeBean> tncStdTypeList = codeMasterUtils.getCodeMasters(CodeMasterConstant.TncStdType.NODE);
        //标准档案卡
        if(!org.springframework.util.CollectionUtils.isEmpty(resultStdMap)){
            for(Map.Entry<Long, List<SLPD0611ITncStdResult>> entry : resultStdMap.entrySet()){
                List<SLPD0611ITncStdResult> results = entry.getValue();
                List<SLPD0611ITncStdResult> slpdStdResult = this.resetStdDate(tncStdTypeList,results,entry.getKey());
                resultStdMap.put(entry.getKey(),slpdStdResult);
            }
        }else {
            if(CollectionUtils.isNotEmpty(breedIds)){
                SLPD0611ITncStdResult std = null;
                List<SLPD0611ITncStdResult> list = null;
                for(Long breed : breedIds){
                    list = new ArrayList<>();
                    for(DictNodeBean nodeBean : tncStdTypeList){
                        std = new SLPD0611ITncStdResult();
                        std.setTncStdType(Long.valueOf(nodeBean.getDataValue()));
                        std.setTncStdTypeStr(nodeBean.getDataCN());
                        std.setBreedId(breed);
                        list.add(std);
                    }
                    resultStdMap.put(breed,list);
                }
            }
        }
        return resultStdMap;
    }

    //设置差异卡数据
    private Map<Object, List<SLPD0611IDifTncStdResult>> setDifStdResultMap(Map<Object, List<SLPD0611IDifTncStdResult>> resultDifStdMap,SLPD0611IParam slpd0611IParam){
        //查询所有的类型
        List<DictNodeBean> tncStdTypeList = codeMasterUtils.getCodeMasters(CodeMasterConstant.TncStdType.NODE);
        //差异卡
        if(!org.springframework.util.CollectionUtils.isEmpty(resultDifStdMap)){
            for(Map.Entry<Object, List<SLPD0611IDifTncStdResult>> entry : resultDifStdMap.entrySet()){
                List<SLPD0611IDifTncStdResult> results = entry.getValue();
                if(CollectionUtils.isNotEmpty(results)){
                    List<SLPD0611IDifTncStdResult> slpdDifStdResult = this.resetDifOrgDate(tncStdTypeList,results,slpd0611IParam);
                    resultDifStdMap.put(entry.getKey(),slpdDifStdResult);
                }
            }
        }else {
            List<SLPD0611IDifTncStdResult> list = null;
            SLPD0611IDifTncStdResult difStd = null;
            if(CollectionUtils.isNotEmpty(slpd0611IParam.getBreedIds())){
                for(Long breedId : slpd0611IParam.getBreedIds()){
                    list = new ArrayList<>();
                    for(DictNodeBean nodeBean : tncStdTypeList){
                        difStd = new SLPD0611IDifTncStdResult();
                        difStd.setTncStdType(Long.valueOf(nodeBean.getDataValue()));
                        difStd.setTncStdTypeStr(nodeBean.getDataCN());
                        difStd.setBreedId(breedId);
                        list.add(difStd);
                    }
                    resultDifStdMap.put(breedId,list);
                }
            }else if(CollectionUtils.isNotEmpty(slpd0611IParam.getProductIds())){
                for(String pruductId : slpd0611IParam.getProductIds()){
                    list = new ArrayList<>();
                    for(DictNodeBean nodeBean : tncStdTypeList){
                        difStd = new SLPD0611IDifTncStdResult();
                        difStd.setTncStdType(Long.valueOf(nodeBean.getDataValue()));
                        difStd.setTncStdTypeStr(nodeBean.getDataCN());
                        difStd.setProductId(pruductId);
                        list.add(difStd);
                    }
                    resultDifStdMap.put(pruductId,list);
                }
            }
        }
        return resultDifStdMap;
    }



    /**
     * 档案卡数据
     * @param
     * @param slpdStds
     * @param breedId
     * @return
     */
    private List<SLPD0611ITncStdResult> resetStdDate(List<DictNodeBean> stdTypeList, List<SLPD0611ITncStdResult> slpdStds, Long breedId){
        List<SLPD0611ITncStdResult> slpdStdResults = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(stdTypeList)){
            if(null != breedId){
                SLPD0611ITncStdResult std = null;
                for(DictNodeBean type : stdTypeList){
                    boolean flg = true;
                    for(SLPD0611ITncStdResult result : slpdStds){
                        //标准档案卡
                        if(breedId.equals(result.getBreedId())
                                && type.getDataValue().equals(result.getTncStdType().toString())){
                            flg = false;
                            result.setTncStdType(Long.valueOf(type.getDataValue()));
                            result.setTncStdTypeStr(type.getDataCN());
                            slpdStdResults.add(result);
                            break;
                        }
                    }
                    //标准档案卡
                    if(flg){
                        std = new SLPD0611ITncStdResult();
                        std.setTncStdType(Long.valueOf(type.getDataValue()));
                        std.setTncStdTypeStr(type.getDataCN());
                        std.setBreedId(breedId);
                        slpdStdResults.add(std);
                    }
                }
            }
        }
        return slpdStdResults;
    }


    /**
     * 差异卡数据
     * @param OrgStdTypeList
     * @param slpdDifs
     * @param param
     * @return
     */
    private List<SLPD0611IDifTncStdResult> resetDifOrgDate(List<DictNodeBean> OrgStdTypeList,List<SLPD0611IDifTncStdResult> slpdDifs,SLPD0611IParam param){
        List<SLPD0611IDifTncStdResult> slpdDifOrgStdResults = new ArrayList<>();
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
    private List<SLPD0611IDifTncStdResult> allNotNull(List<DictNodeBean> OrgStdTypeList,List<SLPD0611IDifTncStdResult> slpdDifs,SLPD0611IParam param){
        List<SLPD0611IDifTncStdResult> slpdDifOrgStdResults = new ArrayList<>();
        SLPD0611IDifTncStdResult orgStd = null;
        for(Long breedId : param.getBreedIds()){
            for(String productId : param.getProductIds()){
                for(DictNodeBean type : OrgStdTypeList){
                    boolean flg = true;
                    if(CollectionUtils.isNotEmpty(slpdDifs)){
                        for(SLPD0611IDifTncStdResult result : slpdDifs){
                            if(breedId.equals(result.getBreedId()) && productId.equals(result.getProductId()) && type.getDataValue().equals(result.getTncStdType().toString())){
                                flg = false;
                                result.setTncStdType(Long.valueOf(type.getDataValue()));
                                result.setTncStdTypeStr(type.getDataCN());
                                slpdDifOrgStdResults.add(result);
                                break;
                            }
                        }
                    }
                    if(flg){
                        orgStd = new SLPD0611IDifTncStdResult();
                        orgStd.setTncStdType(Long.valueOf(type.getDataValue()));
                        orgStd.setTncStdTypeStr(type.getDataCN());
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
    private List<SLPD0611IDifTncStdResult> breedIdNotNull(List<DictNodeBean> OrgStdTypeList,List<SLPD0611IDifTncStdResult> slpdDifs,SLPD0611IParam param){
        List<SLPD0611IDifTncStdResult> slpdDifOrgStdResults = new ArrayList<>();
        SLPD0611IDifTncStdResult orgStd = null;
        for(Long breedId : param.getBreedIds()){
            for(DictNodeBean type : OrgStdTypeList){
                boolean flg = true;
                if(CollectionUtils.isNotEmpty(slpdDifs)){
                    for(SLPD0611IDifTncStdResult result : slpdDifs){
                        if(breedId.equals(result.getBreedId()) && type.getDataValue().equals(result.getTncStdType().toString())){
                            flg = false;
                            result.setTncStdType(Long.valueOf(type.getDataValue()));
                            result.setTncStdTypeStr(type.getDataCN());
                            slpdDifOrgStdResults.add(result);
                            break;
                        }
                    }
                }
                if(flg){
                    orgStd = new SLPD0611IDifTncStdResult();
                    orgStd.setTncStdType(Long.valueOf(type.getDataValue()));
                    orgStd.setTncStdTypeStr(type.getDataCN());
                    orgStd.setBreedId(breedId);
                    slpdDifOrgStdResults.add(orgStd);
                }
            }
        }
        return slpdDifOrgStdResults;
    }

    //产品ID不为空
    private List<SLPD0611IDifTncStdResult> productIdNotNull(List<DictNodeBean> OrgStdTypeList,List<SLPD0611IDifTncStdResult> slpdDifs,SLPD0611IParam param){
        List<SLPD0611IDifTncStdResult> slpdDifOrgStdResults = new ArrayList<>();
        SLPD0611IDifTncStdResult orgStd = null;
        for(String productId : param.getProductIds()){
            for(DictNodeBean type : OrgStdTypeList){
                boolean flg = true;
                if(CollectionUtils.isNotEmpty(slpdDifs)){
                    for(SLPD0611IDifTncStdResult result : slpdDifs){
                        if(productId.equals(result.getProductId()) && type.getDataValue().equals(result.getTncStdType().toString())){
                            flg = false;
                            result.setTncStdType(Long.valueOf(type.getDataValue()));
                            result.setTncStdTypeStr(type.getDataCN());
                            slpdDifOrgStdResults.add(result);
                            break;
                        }
                    }
                }
                if(flg){
                    orgStd = new SLPD0611IDifTncStdResult();
                    orgStd.setTncStdType(Long.valueOf(type.getDataValue()));
                    orgStd.setTncStdTypeStr(type.getDataCN());
                    orgStd.setProductId(productId);
                    slpdDifOrgStdResults.add(orgStd);
                }
            }
        }
        return slpdDifOrgStdResults;
    }

}
