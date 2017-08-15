package com.bms.slpd.rest;

import com.bms.common.entity.DictNodeBean;
import com.bms.slpd.bean.param.SLPD0621IParam;
import com.bms.slpd.bean.result.SLPD0621IResult;
import com.bms.slpd.bean.result.field.SLPD0621IDifTspStdResult;
import com.bms.slpd.bean.result.field.SLPD0621ITspStdResult;
import com.bms.slpd.constant.CodeMasterConstant;
import com.bms.slpd.services.SLPD0621IService;
import com.bms.slpd.utils.CodeMasterUtils;
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
@Api(description = "查询储存运输标准指标",
        tags = "SLPD0621IRestController")
public class SLPD0621IRestController extends BaseRestController {

    @Autowired
    private SLPD0621IService slpd0621IService;

    @Autowired
    private CodeMasterUtils codeMasterUtils;

    @ApiOperation(value = "查询储存运输标准指标",
            notes = "查询储存运输标准指标")
    @RequestMapping(value = "/products/storage/transportation/standards/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLPD0621IResult findTspStds(@RequestBody SLPD0621IParam slpd0621IParam) {
        List<SLPD0621ITspStdResult> slpdStds = null;
        List<SLPD0621IDifTspStdResult> slpdDifs = null;
        //查询差异卡
        if(CollectionUtils.isNotEmpty(slpd0621IParam.getProductIds())){
            slpdDifs = slpd0621IService.batchSearch(slpd0621IParam);
            if(CollectionUtils.isEmpty(slpd0621IParam.getBreedIds()) && CollectionUtils.isNotEmpty(slpdDifs)){
                HashSet<Long> breedIdsSet = new HashSet<>();
                //去除重复breedId
                for (SLPD0621IDifTspStdResult slpdDif : slpdDifs) {
                    breedIdsSet.add(slpdDif.getBreedId());
                }
                List list = new ArrayList();
                Iterator it = breedIdsSet.iterator();
                while (it.hasNext()) {
                    list.add(it.next());
                }
                //查询标准档案卡
                SLPD0621IParam findStdParam = new SLPD0621IParam();
                findStdParam.setBreedIds(list);
                slpdStds = slpd0621IService.searchStd(slpd0621IParam);
            }
        }
        if(CollectionUtils.isNotEmpty(slpd0621IParam.getBreedIds())){
            slpdStds = slpd0621IService.searchStd(slpd0621IParam);
            if (slpd0621IParam.getFindAllFlag() == 1 && CollectionUtils.isEmpty(slpdDifs)) {
                slpdDifs = slpd0621IService.batchSearch(slpd0621IParam);
            }
        }

        SLPD0621IResult slpd  = this.getResult(slpdStds,slpdDifs,slpd0621IParam);
        return slpd;
    }


    private SLPD0621IResult getResult(List<SLPD0621ITspStdResult> slpdStds,List<SLPD0621IDifTspStdResult> slpdDifs,SLPD0621IParam param){
        SLPD0621IResult slpd = new SLPD0621IResult();
        slpd.setSlpdStds(this.setStdResultList(slpdStds,param));
        if(param.getFindAllFlag() == 1){
            slpd.setSlpdDifStds(this.setDifStdResultList(slpdDifs,param));
        }
        return slpd;
    }


    //标准档案卡
    private Map<Long, LinkedHashMap<String,List<SLPD0621ITspStdResult>>> setStdResultList(List<SLPD0621ITspStdResult> slpdStds, SLPD0621IParam param){
        Map<Long, List<SLPD0621ITspStdResult>> resultStdMap = new HashMap<>();
        if(CollectionUtils.isNotEmpty(slpdStds)){
            for (SLPD0621ITspStdResult results : slpdStds) {
                if (resultStdMap.containsKey(results.getBreedId())) {
                    List<SLPD0621ITspStdResult> list = resultStdMap.get(results.getBreedId());
                    list.add(results);
                } else {
                    List<SLPD0621ITspStdResult> list = new ArrayList<>();
                    list.add(results);
                    resultStdMap.put(results.getBreedId(), list);
                }
            }
        }
        return this.setStdResultMap(resultStdMap,param.getBreedIds());
    }


    //差异卡
    private Map<Object, Map<Object,List<SLPD0621IDifTspStdResult>>> setDifStdResultList(List<SLPD0621IDifTspStdResult> slpdDifs,SLPD0621IParam param){
        Map<Object, List<SLPD0621IDifTspStdResult>> resultDifStdMap = new HashMap<>();
        if(CollectionUtils.isNotEmpty(slpdDifs)){
            for (SLPD0621IDifTspStdResult results : slpdDifs) {
                if((CollectionUtils.isNotEmpty(param.getBreedIds()) && CollectionUtils.isNotEmpty(param.getProductIds()))
                        || (CollectionUtils.isNotEmpty(param.getBreedIds()) && CollectionUtils.isEmpty(param.getProductIds()))){
                    if (resultDifStdMap.containsKey(results.getBreedId())) {
                        List<SLPD0621IDifTspStdResult> list = resultDifStdMap.get(results.getBreedId());
                        list.add(results);
                    } else {
                        List<SLPD0621IDifTspStdResult> list = new ArrayList<>();
                        list.add(results);
                        resultDifStdMap.put(results.getBreedId(), list);
                    }
                }else if(CollectionUtils.isNotEmpty(param.getProductIds())){
                    if (resultDifStdMap.containsKey(results.getParentType())) {
                        List<SLPD0621IDifTspStdResult> list = resultDifStdMap.get(results.getParentType());
                        list.add(results);
                    } else {
                        List<SLPD0621IDifTspStdResult> list = new ArrayList<>();
                        list.add(results);
                        resultDifStdMap.put(results.getParentType(), list);
                    }
                }
            }
        }
        return this.setDifStdResultMap(resultDifStdMap,param);
    }



    //组装node
    private Map<String,List<DictNodeBean>> getNodeBean(){
        //查询所有的类型
        List<DictNodeBean> gnqStdTypeList = codeMasterUtils.getCodeMasters(CodeMasterConstant.TspStdType.NODE);
        LinkedHashMap<String,List<DictNodeBean>> nodeMap = new LinkedHashMap<>();
        if(CollectionUtils.isNotEmpty(gnqStdTypeList)){
            //父节点
            LinkedHashMap<String,String> parentNode = new LinkedHashMap<>();
            for(DictNodeBean node :gnqStdTypeList){
                if(StringUtils.isNotEmpty(node.getDataValue()) && node.getDataValue().length() == 1){
                    parentNode.put(node.getDataValue(),node.getDataCN());
                }
            }
            //子集合
            List<DictNodeBean> childNodeList = null;
            for(Map.Entry<String,String> entry : parentNode.entrySet()){
                childNodeList = new ArrayList<>();
                for(DictNodeBean node :gnqStdTypeList){
                    if(!entry.getKey().equals(node.getDataValue()) && node.getDataValue().indexOf(entry.getKey()) > -1){
                        node.setDataEN(entry.getKey());
                        childNodeList.add(node);
                    }
                }
                nodeMap.put(entry.getValue(),childNodeList);
            }
        }
        return nodeMap;
    }



    //设置标准档案卡数据
    private Map<Long, LinkedHashMap<String,List<SLPD0621ITspStdResult>>> setStdResultMap(Map<Long, List<SLPD0621ITspStdResult>> resultStdMap, List<Long> breedIds){
        Map<Long, LinkedHashMap<String,List<SLPD0621ITspStdResult>>> resultMap = new HashMap<>();
        //查询所有的类型
        Map<String,List<DictNodeBean>> nodeMap = this.getNodeBean();

        //标准档案卡
        if(!org.springframework.util.CollectionUtils.isEmpty(resultStdMap)){
            for(Map.Entry<Long, List<SLPD0621ITspStdResult>> entry : resultStdMap.entrySet()){
                List<SLPD0621ITspStdResult> results = entry.getValue();
                LinkedHashMap<String,List<SLPD0621ITspStdResult>> slpdStdResult = this.resetStdDate(nodeMap,results,entry.getKey());
                resultMap.put(entry.getKey(),slpdStdResult);
            }
        }else {
            if(CollectionUtils.isNotEmpty(breedIds)){
                SLPD0621ITspStdResult std = null;
                List<SLPD0621ITspStdResult> list = null;
                LinkedHashMap<String,List<SLPD0621ITspStdResult>> map = null;
                for(Long breed : breedIds){
                    map = new LinkedHashMap<>();
                    for(Map.Entry<String,List<DictNodeBean>> entry : nodeMap.entrySet()){
                        list = new ArrayList<>();
                        for(DictNodeBean nodeBean : entry.getValue()){
                            std = new SLPD0621ITspStdResult();
                            std.setBreedId(breed);
                            std.setTspStdType(nodeBean.getDataValue());
                            std.setTspStdTypeStr(nodeBean.getDataCN());
                            std.setParentType(nodeBean.getDataEN());
                            list.add(std);
                        }
                        map.put(entry.getKey(),list);
                    }
                    resultMap.put(breed,map);
                }
            }
        }
        return resultMap;
    }

    //设置差异卡数据
    private Map<Object, Map<Object,List<SLPD0621IDifTspStdResult>>> setDifStdResultMap(Map<Object, List<SLPD0621IDifTspStdResult>> resultDifStdMap,SLPD0621IParam param){
        Map<Object, Map<Object,List<SLPD0621IDifTspStdResult>>> resultMap = new HashMap<>();
        //查询所有的类型
        Map<String,List<DictNodeBean>> nodeMap = this.getNodeBean();
        //差异卡
        if(!org.springframework.util.CollectionUtils.isEmpty(resultDifStdMap)){
            for(Map.Entry<Object, List<SLPD0621IDifTspStdResult>> entry : resultDifStdMap.entrySet()){
                List<SLPD0621IDifTspStdResult> results = entry.getValue();
                /*if(CollectionUtils.isNotEmpty(results)){
                    Map<String,List<SLPD0621IDifTspStdResult>> slpdDifStdResult = this.resetStdDate(nodeMap,results,null,entry.getKey());
                    resultMap.put(entry.getKey(),slpdDifStdResult);
                }*/
                if(CollectionUtils.isNotEmpty(results)){
                    if((CollectionUtils.isNotEmpty(param.getBreedIds()) && CollectionUtils.isNotEmpty(param.getProductIds()))
                            || (CollectionUtils.isNotEmpty(param.getBreedIds()) && CollectionUtils.isEmpty(param.getProductIds())) ){
                        Map<Object,List<SLPD0621IDifTspStdResult>> slpdDifStdResult = this.resetDifStdDate(nodeMap,results,Long.valueOf(entry.getKey().toString()),null);
                        resultMap.put(entry.getKey(),slpdDifStdResult);
                    }else if(CollectionUtils.isNotEmpty(param.getProductIds())){
                        Map<Object,List<SLPD0621IDifTspStdResult>> slpdDifStdResult = this.resetDifStdDate(nodeMap,results,null,entry.getKey().toString());
                        resultMap.put(entry.getKey(),slpdDifStdResult);
                    }
                }
            }
        }else {
            SLPD0621IDifTspStdResult difStd = null;
            List<SLPD0621IDifTspStdResult> list = null;
            Map<Object,List<SLPD0621IDifTspStdResult>> map = null;
            if((CollectionUtils.isNotEmpty(param.getBreedIds()) && CollectionUtils.isNotEmpty(param.getProductIds()))
                    || (CollectionUtils.isNotEmpty(param.getBreedIds()) && CollectionUtils.isEmpty(param.getProductIds()))){
                for (Long breedId : param.getBreedIds()) {
                    map = new HashMap<>();
                    for (Map.Entry<String, List<DictNodeBean>> entry : nodeMap.entrySet()) {
                        list = new ArrayList<>();
                        for (DictNodeBean nodeBean : entry.getValue()) {
                            difStd = new SLPD0621IDifTspStdResult();
                            difStd.setTspStdType(nodeBean.getDataValue());
                            difStd.setTspStdTypeStr(nodeBean.getDataCN());
                            difStd.setParentType(nodeBean.getDataEN());
                            difStd.setBreedId(breedId);
                            list.add(difStd);
                        }
                        map.put(entry.getKey(), list);
                    }
                    resultMap.put(breedId, map);
                }
            }else if(CollectionUtils.isNotEmpty(param.getProductIds())){
                for (String productId : param.getProductIds()) {
                    map = new HashMap<>();
                    for (Map.Entry<String, List<DictNodeBean>> entry : nodeMap.entrySet()) {
                        list = new ArrayList<>();
                        for (DictNodeBean nodeBean : entry.getValue()) {
                            difStd = new SLPD0621IDifTspStdResult();
                            difStd.setTspStdType(nodeBean.getDataValue());
                            difStd.setTspStdTypeStr(nodeBean.getDataCN());
                            difStd.setParentType(nodeBean.getDataEN());
                            difStd.setProductId(productId);
                            list.add(difStd);
                        }
                        map.put(entry.getKey(), list);
                    }
                    resultMap.put(productId, map);
                }
            }
        }
        return resultMap;
    }



    /**
     * 档案卡数据
     * @param
     * @param slpdStds
     * @param breedId
     * @return
     */
    private <T>LinkedHashMap<String,List<T>> resetStdDate( Map<String,List<DictNodeBean>> stdTypeList, List<T> slpdStds, Long breedId){
        LinkedHashMap<String,List<T>> resultMap = new LinkedHashMap<>();
        if(!org.springframework.util.CollectionUtils.isEmpty(stdTypeList)){
            if(null != breedId){
                //Map类型  key是父类型
                for(Map.Entry<String,List<DictNodeBean>> entry : stdTypeList.entrySet()){
                    //循环child
                    List<SLPD0621ITspStdResult> slpdStdResults = this.getStdDate(entry.getValue(), (List<SLPD0621ITspStdResult>) slpdStds,breedId);
                    resultMap.put(entry.getKey(), (List<T>) slpdStdResults);
                }
            }
        }
        return resultMap;
    }

    /**
     * 档案卡数据
     * @param
     * @param slpdStds
     * @param breedId
     * @return
     */
    private <T>Map<Object,List<T>> resetDifStdDate( Map<String,List<DictNodeBean>> stdTypeList, List<T> slpdStds, Long breedId,String productId){
        Map<Object,List<T>> resultMap = new HashMap<>();
        if(!org.springframework.util.CollectionUtils.isEmpty(stdTypeList)){
            if(null != breedId || StringUtils.isNotEmpty(productId)){
                //Map类型  key是父类型
                for(Map.Entry<String,List<DictNodeBean>> entry : stdTypeList.entrySet()){
                    //循环child
                    List<SLPD0621IDifTspStdResult> slpdStdResults = this.getStdDifDate(entry.getValue(), (List<SLPD0621IDifTspStdResult>) slpdStds,breedId,productId);
                    resultMap.put(entry.getKey(), (List<T>) slpdStdResults);
                }
            }
        }
        return resultMap;
    }

    //获取标准卡的数据
    private List<SLPD0621ITspStdResult> getStdDate(List<DictNodeBean> nodeBeanList,List<SLPD0621ITspStdResult> slpdStd,Long breedId){
        SLPD0621ITspStdResult std = null;
        List<SLPD0621ITspStdResult> slpdStdResults = new ArrayList<>();
        for(DictNodeBean type : nodeBeanList){
            boolean flg = true;
            //循环数据库结果集
            for(SLPD0621ITspStdResult result : slpdStd){
                //标准档案卡
                if(breedId.equals(result.getBreedId())
                        && type.getDataValue().equals(result.getTspStdType().toString())){
                    flg = false;
                    result.setTspStdType(type.getDataValue());
                    result.setTspStdTypeStr(type.getDataCN());
                    result.setParentType(type.getDataEN());
                    slpdStdResults.add(result);
                    break;
                }
            }
            //标准档案卡
            if(flg){
                std = new SLPD0621ITspStdResult();
                std.setBreedId(breedId);
                std.setTspStdType(type.getDataValue());
                std.setTspStdTypeStr(type.getDataCN());
                std.setParentType(type.getDataEN());
                slpdStdResults.add(std);
            }
        }
        return slpdStdResults;
    }






    //获取差异卡的数据
    private List<SLPD0621IDifTspStdResult> getStdDifDate(List<DictNodeBean> nodeBeanList,List<SLPD0621IDifTspStdResult> slpdStd,Long breedId,String productId){
        SLPD0621IDifTspStdResult std = null;
        List<SLPD0621IDifTspStdResult> slpdStdResults = new ArrayList<>();
        for(DictNodeBean type : nodeBeanList){
            boolean flg = true;
            for(SLPD0621IDifTspStdResult result : slpdStd){
                //标准差异卡
                if(breedId != null){
                    if(breedId.equals(Long.valueOf(result.getBreedId()))
                            && type.getDataValue().equals(result.getTspStdType().toString())){
                        flg = false;
                        result.setTspStdType(type.getDataValue());
                        result.setTspStdTypeStr(type.getDataCN());
                        result.setParentType(type.getDataEN());
                        slpdStdResults.add(result);
                        break;
                    }
                }else if(StringUtils.isNoneEmpty(productId)){
                    if(productId.equals(String.valueOf(result.getProductId()))
                            && type.getDataValue().equals(result.getTspStdType().toString())){
                        flg = false;
                        result.setTspStdType(type.getDataValue());
                        result.setTspStdTypeStr(type.getDataCN());
                        result.setParentType(type.getDataEN());
                        slpdStdResults.add(result);
                        break;
                    }
                }
            }
            //标准档案卡
            if(flg){
                //标准差异卡
                std = new SLPD0621IDifTspStdResult();
                std.setBreedId(breedId);
                std.setProductId(productId);
                std.setTspStdType(type.getDataValue());
                std.setTspStdTypeStr(type.getDataCN());
                std.setParentType(type.getDataEN());
                slpdStdResults.add(std);
            }
        }
        return slpdStdResults;
    }
}
