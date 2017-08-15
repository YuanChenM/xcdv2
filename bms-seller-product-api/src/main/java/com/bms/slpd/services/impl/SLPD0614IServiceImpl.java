package com.bms.slpd.services.impl;


import com.bms.common.entity.DictNodeBean;
import com.bms.slpd.bean.param.SLPD0614IParam;
import com.bms.slpd.bean.result.SLPD0614IResult;
import com.bms.slpd.bean.result.field.SLPD0614IDifGnqStdResult;
import com.bms.slpd.bean.result.field.SLPD0614IGnqStdResult;
import com.bms.slpd.constant.CodeMasterConstant;
import com.bms.slpd.dao.SLPD0614IDao;
import com.bms.slpd.services.SLPD0614IService;
import com.bms.slpd.utils.CodeMasterUtils;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.*;

/**
 * 查询通用质量标准指标档案卡与差异卡
 */
@Service
public class SLPD0614IServiceImpl extends BaseServiceImpl implements SLPD0614IService {

    @Autowired
    private SLPD0614IDao slpd0614IDao;

    @Autowired
    private CodeMasterUtils codeMasterUtils;

    @Override
    public BaseDao getBaseDao() {
        return slpd0614IDao;
    }

    /**
     * 查询通用质量标准指标差异卡
     */
    @Override
    public List<SLPD0614IDifGnqStdResult> searchDif(Serializable var1) {
        return slpd0614IDao.searchDif(var1);
    }

    /**
     * 查询通用质量标准指标档案卡
     */
    @Override
    public List<SLPD0614IGnqStdResult> searchStd(Serializable var1) {
        return slpd0614IDao.searchStd(var1);
    }


    /**
     * 查询通用质量标准指标档案卡与差异卡
     */
    @Override
    public SLPD0614IResult findDifAndStdGnq(SLPD0614IParam param) {
        //查询差异卡
        List<SLPD0614IDifGnqStdResult> slpdDifs = null;
        List<SLPD0614IGnqStdResult> slpdStds = null;
        if(CollectionUtils.isNotEmpty(param.getProductIds())){
            slpdDifs = this.searchDif(param);
            if(CollectionUtils.isEmpty(param.getBreedIds()) && CollectionUtils.isNotEmpty(slpdDifs)){
                HashSet<Long> breedIdsSet = new HashSet<>();
                //去除重复breedId
                for (SLPD0614IDifGnqStdResult slpdDif : slpdDifs) {
                    breedIdsSet.add(slpdDif.getBreedId());
                }
                List list = new ArrayList();
                Iterator it = breedIdsSet.iterator();
                while (it.hasNext()) {
                    list.add(it.next());
                }
                //查询标准档案卡
                SLPD0614IParam findStdParam = new SLPD0614IParam();
                findStdParam.setBreedIds(list);
                slpdStds = this.searchStd(param);
            }
        }
        if(CollectionUtils.isNotEmpty(param.getBreedIds())){
            slpdStds = this.searchStd(param);
            if (param.getFindAllFlag() == 1 && CollectionUtils.isEmpty(slpdDifs)) {
                slpdDifs = this.searchDif(param);
            }
        }
        SLPD0614IResult slpd = this.getResult(slpdStds,slpdDifs,param);
        return slpd;
    }


    private SLPD0614IResult getResult(List<SLPD0614IGnqStdResult> slpdStds,List<SLPD0614IDifGnqStdResult> slpdDifs,SLPD0614IParam param){
        SLPD0614IResult slpd = new SLPD0614IResult();
        slpd.setSlpdStds(this.setStdResultList(slpdStds,param));
        if(param.getFindAllFlag() == 1){
            slpd.setSlpdDifStds(this.setDifStdResultList(slpdDifs,param));
        }
        return slpd;
    }



    //标准档案卡
    private Map<Object, LinkedHashMap<Object,List<SLPD0614IGnqStdResult>>> setStdResultList( List<SLPD0614IGnqStdResult> slpdStds,SLPD0614IParam param){
        LinkedHashMap<Object, List<SLPD0614IGnqStdResult>> resultStdMap = new LinkedHashMap<>();
        if(CollectionUtils.isNotEmpty(slpdStds)){
            for (SLPD0614IGnqStdResult results : slpdStds) {
                if (resultStdMap.containsKey(results.getBreedId())) {
                    List<SLPD0614IGnqStdResult> list = resultStdMap.get(results.getBreedId());
                    list.add(results);
                } else {
                    List<SLPD0614IGnqStdResult> list = new ArrayList<>();
                    list.add(results);
                    resultStdMap.put(results.getBreedId(), list);
                }
            }
        }
        return this.setStdResultMap(resultStdMap,param.getBreedIds());
    }


    //差异卡
    private Map<Object, Map<Object,List<SLPD0614IDifGnqStdResult>>> setDifStdResultList(List<SLPD0614IDifGnqStdResult> slpdDifs,SLPD0614IParam param){
        Map<Object, List<SLPD0614IDifGnqStdResult>> resultDifStdMap = new HashMap<>();
        if(CollectionUtils.isNotEmpty(slpdDifs)){
            for (SLPD0614IDifGnqStdResult results : slpdDifs) {
                if((CollectionUtils.isNotEmpty(param.getBreedIds()) && CollectionUtils.isNotEmpty(param.getProductIds()))
                        || (CollectionUtils.isNotEmpty(param.getBreedIds()) && CollectionUtils.isEmpty(param.getProductIds()))){
                    if (resultDifStdMap.containsKey(results.getBreedId())) {
                        List<SLPD0614IDifGnqStdResult> list = resultDifStdMap.get(results.getBreedId());
                        list.add(results);
                    } else {
                        List<SLPD0614IDifGnqStdResult> list = new ArrayList<>();
                        list.add(results);
                        resultDifStdMap.put(results.getBreedId(), list);
                    }
                }else if(CollectionUtils.isNotEmpty(param.getProductIds())){
                    if (resultDifStdMap.containsKey(results.getParentType())) {
                        List<SLPD0614IDifGnqStdResult> list = resultDifStdMap.get(results.getParentType());
                        list.add(results);
                    } else {
                        List<SLPD0614IDifGnqStdResult> list = new ArrayList<>();
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
        List<DictNodeBean> gnqStdTypeList = codeMasterUtils.getCodeMasters(CodeMasterConstant.GnqStdType.NODE);
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
    private Map<Object, LinkedHashMap<Object,List<SLPD0614IGnqStdResult>>> setStdResultMap(Map<Object, List<SLPD0614IGnqStdResult>> resultStdMap, List<Long> breedIds){
        Map<Object, LinkedHashMap<Object,List<SLPD0614IGnqStdResult>>> resultMap = new HashMap<>();
        //查询所有的类型
        Map<String,List<DictNodeBean>> nodeMap = this.getNodeBean();

        //标准档案卡
        if(!org.springframework.util.CollectionUtils.isEmpty(resultStdMap)){
            for(Map.Entry<Object, List<SLPD0614IGnqStdResult>> entry : resultStdMap.entrySet()){
                List<SLPD0614IGnqStdResult> results = entry.getValue();
                LinkedHashMap<Object,List<SLPD0614IGnqStdResult>> slpdStdResult = this.resetStdDate(nodeMap,results,Long.valueOf(entry.getKey().toString()));
                resultMap.put(entry.getKey(),slpdStdResult);
            }
        }else {
            if(CollectionUtils.isNotEmpty(breedIds)){
                SLPD0614IGnqStdResult std = null;
                List<SLPD0614IGnqStdResult> list = null;
                LinkedHashMap<Object,List<SLPD0614IGnqStdResult>> map = null;
                for(Long breed : breedIds){
                    map = new LinkedHashMap<>();
                    for(Map.Entry<String,List<DictNodeBean>> entry : nodeMap.entrySet()){
                        list = new ArrayList<>();
                        for(DictNodeBean nodeBean : entry.getValue()){
                            std = new SLPD0614IGnqStdResult();
                            std.setBreedId(breed);
                            std.setGnqStdType(nodeBean.getDataValue());
                            std.setGnqStdTypeStr(nodeBean.getDataCN());
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
    private Map<Object, Map<Object,List<SLPD0614IDifGnqStdResult>>> setDifStdResultMap(Map<Object, List<SLPD0614IDifGnqStdResult>> resultDifStdMap,SLPD0614IParam param){
        Map<Object, Map<Object,List<SLPD0614IDifGnqStdResult>>> resultMap = new HashMap<>();
        //查询所有的类型
        Map<String,List<DictNodeBean>> nodeMap = this.getNodeBean();
        //差异卡
        if(!org.springframework.util.CollectionUtils.isEmpty(resultDifStdMap)){
            for(Map.Entry<Object, List<SLPD0614IDifGnqStdResult>> entry : resultDifStdMap.entrySet()){
                List<SLPD0614IDifGnqStdResult> results = entry.getValue();
                if(CollectionUtils.isNotEmpty(results)){
                    if((CollectionUtils.isNotEmpty(param.getBreedIds()) && CollectionUtils.isNotEmpty(param.getProductIds()))
                            || (CollectionUtils.isNotEmpty(param.getBreedIds()) && CollectionUtils.isEmpty(param.getProductIds())) ){
                        Map<Object,List<SLPD0614IDifGnqStdResult>> slpdDifStdResult = this.resetDifStdDate(nodeMap,results,Long.valueOf(entry.getKey().toString()),null);
                        resultMap.put(entry.getKey(),slpdDifStdResult);
                    }else if(CollectionUtils.isNotEmpty(param.getProductIds())){
                        Map<Object,List<SLPD0614IDifGnqStdResult>> slpdDifStdResult = this.resetDifStdDate(nodeMap,results,null,entry.getKey().toString());
                        resultMap.put(entry.getKey(),slpdDifStdResult);
                    }
                }
            }
        }else {
                SLPD0614IDifGnqStdResult difStd = null;
                List<SLPD0614IDifGnqStdResult> list = null;
                Map<Object,List<SLPD0614IDifGnqStdResult>> map = null;
                if((CollectionUtils.isNotEmpty(param.getBreedIds()) && CollectionUtils.isNotEmpty(param.getProductIds()))
                        || (CollectionUtils.isNotEmpty(param.getBreedIds()) && CollectionUtils.isEmpty(param.getProductIds()))){
                    for (Long breedId : param.getBreedIds()) {
                        map = new HashMap<>();
                        for (Map.Entry<String, List<DictNodeBean>> entry : nodeMap.entrySet()) {
                            list = new ArrayList<>();
                            for (DictNodeBean nodeBean : entry.getValue()) {
                                difStd = new SLPD0614IDifGnqStdResult();
                                difStd.setGnqStdType(nodeBean.getDataValue());
                                difStd.setGnqStdTypeStr(nodeBean.getDataCN());
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
                                difStd = new SLPD0614IDifGnqStdResult();
                                difStd.setGnqStdType(nodeBean.getDataValue());
                                difStd.setGnqStdTypeStr(nodeBean.getDataCN());
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
    private <T>LinkedHashMap<Object,List<T>> resetStdDate( Map<String,List<DictNodeBean>> stdTypeList, List<T> slpdStds, Long breedId){
        LinkedHashMap<Object,List<T>> resultMap = new LinkedHashMap<>();
        if(!org.springframework.util.CollectionUtils.isEmpty(stdTypeList)){
            if(null != breedId){
                //Map类型  key是父类型
                for(Map.Entry<String,List<DictNodeBean>> entry : stdTypeList.entrySet()){
                    //循环child
                    List<SLPD0614IGnqStdResult> slpdStdResults = this.getStdDate(entry.getValue(), (List<SLPD0614IGnqStdResult>) slpdStds,breedId);
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
                    List<SLPD0614IDifGnqStdResult> slpdStdResults = this.getStdDifDate(entry.getValue(), (List<SLPD0614IDifGnqStdResult>) slpdStds,breedId,productId);
                    resultMap.put(entry.getKey(), (List<T>) slpdStdResults);
                }
            }
        }
        return resultMap;
    }


    //获取标准卡的数据
    private List<SLPD0614IGnqStdResult> getStdDate(List<DictNodeBean> nodeBeanList,List<SLPD0614IGnqStdResult> slpdStd,Long breedId){
        SLPD0614IGnqStdResult std = null;
        List<SLPD0614IGnqStdResult> slpdStdResults = new ArrayList<>();
        for(DictNodeBean type : nodeBeanList){
            boolean flg = true;
            //循环数据库结果集
            for(SLPD0614IGnqStdResult result : slpdStd){
                //标准档案卡
                if(breedId.equals(result.getBreedId())
                        && type.getDataValue().equals(result.getGnqStdType().toString())){
                    flg = false;
                    result.setGnqStdType(type.getDataValue());
                    result.setGnqStdTypeStr(type.getDataCN());
                    result.setParentType(type.getDataEN());
                    slpdStdResults.add(result);
                    break;
                }
            }
            //标准档案卡
            if(flg){
                std = new SLPD0614IGnqStdResult();
                std.setBreedId(breedId);
                std.setGnqStdType(type.getDataValue());
                std.setGnqStdTypeStr(type.getDataCN());
                std.setParentType(type.getDataEN());
                slpdStdResults.add(std);
            }
        }
        return slpdStdResults;
    }






    //获取差异卡的数据
    private List<SLPD0614IDifGnqStdResult> getStdDifDate(List<DictNodeBean> nodeBeanList,List<SLPD0614IDifGnqStdResult> slpdStd,Long breedId,String productId){
        SLPD0614IDifGnqStdResult std = null;
        List<SLPD0614IDifGnqStdResult> slpdStdResults = new ArrayList<>();
        for(DictNodeBean type : nodeBeanList){
            boolean flg = true;
            for(SLPD0614IDifGnqStdResult result : slpdStd){
                //标准差异卡
                if(breedId != null){
                    if(breedId.equals(Long.valueOf(result.getBreedId()))
                            && type.getDataValue().equals(result.getGnqStdType().toString())){
                        flg = false;
                        result.setGnqStdType(type.getDataValue());
                        result.setGnqStdTypeStr(type.getDataCN());
                        result.setParentType(type.getDataEN());
                        slpdStdResults.add(result);
                        break;
                    }
                }else if(StringUtils.isNoneEmpty(productId)){
                    if(productId.equals(String.valueOf(result.getProductId()))
                            && type.getDataValue().equals(result.getGnqStdType().toString())){
                        flg = false;
                        result.setGnqStdType(type.getDataValue());
                        result.setGnqStdTypeStr(type.getDataCN());
                        result.setParentType(type.getDataEN());
                        slpdStdResults.add(result);
                        break;
                    }
                }

            }
            //标准档案卡
            if(flg){
                //标准差异卡
                std = new SLPD0614IDifGnqStdResult();
                std.setBreedId(breedId);
                std.setProductId(productId);
                std.setGnqStdType(type.getDataValue());
                std.setGnqStdTypeStr(type.getDataCN());
                std.setParentType(type.getDataEN());
                slpdStdResults.add(std);
            }
        }
        return slpdStdResults;
    }
}