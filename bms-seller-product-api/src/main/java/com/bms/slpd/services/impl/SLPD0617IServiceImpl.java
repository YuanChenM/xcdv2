package com.bms.slpd.services.impl;

import com.bms.common.entity.DictNodeBean;
import com.bms.slpd.bean.param.SLPD0617IParam;
import com.bms.slpd.bean.result.SLPD0617IResult;
import com.bms.slpd.bean.result.field.SLPD0617IDifSftStdResult;
import com.bms.slpd.bean.result.field.SLPD0617ISftStdResult;
import com.bms.slpd.constant.CodeMasterConstant;
import com.bms.slpd.dao.SLPD0617IDao;
import com.bms.slpd.services.SLPD0608IService;
import com.bms.slpd.services.SLPD0617IService;
import com.bms.slpd.utils.CodeMasterUtils;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SLPD0617IServiceImpl extends BaseServiceImpl implements SLPD0617IService {

    @Autowired
    private SLPD0617IDao slpd0617IDao;

    @Autowired
    SLPD0608IService slpd0608IService;

    @Autowired
    private CodeMasterUtils codeMasterUtils;

    @Override
    public BaseDao getBaseDao() {
        return slpd0617IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SLPD0617IResult findSftStdsAndDifStds(SLPD0617IParam param) {

        List<SLPD0617ISftStdResult> slpdStds  = null;
        List<SLPD0617IDifSftStdResult> slpdDifs = null;
        if(CollectionUtils.isNotEmpty(param.getProductIds())){
            slpdDifs = slpd0617IDao.findSftDifStds(param);
            if(CollectionUtils.isEmpty(param.getBreedIds()) && CollectionUtils.isNotEmpty(slpdDifs)){
                HashSet<Long> breedIdsSet = new HashSet<>();
                //去除重复breedId
                for (SLPD0617IDifSftStdResult slpdDif : slpdDifs) {
                    breedIdsSet.add(slpdDif.getBreedId());
                }
                List list = new ArrayList();
                Iterator it = breedIdsSet.iterator();
                while (it.hasNext()) {
                    list.add(it.next());
                }
                //查询标准档案卡
                SLPD0617IParam findStdParam = new SLPD0617IParam();
                findStdParam.setBreedIds(list);
                slpdStds  = slpd0617IDao.findSftStds(param);
            }
        }
        if(CollectionUtils.isNotEmpty(param.getBreedIds())){
            slpdStds  = slpd0617IDao.findSftStds(param);
            if (param.getFindAllFlag() == 1 && CollectionUtils.isEmpty(slpdDifs)) {
                slpdDifs = slpd0617IDao.findSftDifStds(param);
            }
        }
        SLPD0617IResult slpd = this.getResult(slpdStds,slpdDifs,param);
        return slpd;
    }


    private SLPD0617IResult getResult(List<SLPD0617ISftStdResult> slpdStds,List<SLPD0617IDifSftStdResult> slpdDifs,SLPD0617IParam param){
        SLPD0617IResult slpd = new SLPD0617IResult();
        slpd.setSlpdStds(this.setStdResultList(slpdStds,param));
        if(param.getFindAllFlag() == 1){
            slpd.setSlpdDifStds(this.setDifStdResultList(slpdDifs,param));
        }
        return slpd;
    }


    //标准档案卡
    private Map<Long, LinkedHashMap<String,List<SLPD0617ISftStdResult>>> setStdResultList( List<SLPD0617ISftStdResult> slpdStds,SLPD0617IParam param){
        Map<Long, List<SLPD0617ISftStdResult>> resultStdMap = new HashMap<>();
        if(CollectionUtils.isNotEmpty(slpdStds)){
            for (SLPD0617ISftStdResult results : slpdStds) {
                if (resultStdMap.containsKey(results.getBreedId())) {
                    List<SLPD0617ISftStdResult> list = resultStdMap.get(results.getBreedId());
                    list.add(results);
                } else {
                    List<SLPD0617ISftStdResult> list = new ArrayList<>();
                    list.add(results);
                    resultStdMap.put(results.getBreedId(), list);
                }
            }
        }
        return this.setStdResultMap(resultStdMap,param.getBreedIds());
    }


    //差异卡
    private Map<Object, Map<Object,List<SLPD0617IDifSftStdResult>>> setDifStdResultList(List<SLPD0617IDifSftStdResult> slpdDifs,SLPD0617IParam param){
        Map<Object, List<SLPD0617IDifSftStdResult>> resultDifStdMap = new HashMap<>();
        if(CollectionUtils.isNotEmpty(slpdDifs)){
            for (SLPD0617IDifSftStdResult results : slpdDifs) {
                if((CollectionUtils.isNotEmpty(param.getBreedIds()) && CollectionUtils.isNotEmpty(param.getProductIds()))
                        || (CollectionUtils.isNotEmpty(param.getBreedIds()) && CollectionUtils.isEmpty(param.getProductIds()))){
                    if (resultDifStdMap.containsKey(results.getBreedId())) {
                        List<SLPD0617IDifSftStdResult> list = resultDifStdMap.get(results.getBreedId());
                        list.add(results);
                    } else {
                        List<SLPD0617IDifSftStdResult> list = new ArrayList<>();
                        list.add(results);
                        resultDifStdMap.put(results.getBreedId(), list);
                    }
                }else if(CollectionUtils.isNotEmpty(param.getProductIds())){
                    if (resultDifStdMap.containsKey(results.getParentType())) {
                        List<SLPD0617IDifSftStdResult> list = resultDifStdMap.get(results.getParentType());
                        list.add(results);
                    } else {
                        List<SLPD0617IDifSftStdResult> list = new ArrayList<>();
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
        List<DictNodeBean> gnqStdTypeList = codeMasterUtils.getCodeMasters(CodeMasterConstant.SftStdType.NODE);
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
    private Map<Long, LinkedHashMap<String,List<SLPD0617ISftStdResult>>> setStdResultMap(Map<Long, List<SLPD0617ISftStdResult>> resultStdMap, List<Long> breedIds){
        Map<Long, LinkedHashMap<String,List<SLPD0617ISftStdResult>>> resultMap = new HashMap<>();
        //查询所有的类型
        Map<String,List<DictNodeBean>> nodeMap = this.getNodeBean();

        //标准档案卡
        if(!org.springframework.util.CollectionUtils.isEmpty(resultStdMap)){
            for(Map.Entry<Long, List<SLPD0617ISftStdResult>> entry : resultStdMap.entrySet()){
                List<SLPD0617ISftStdResult> results = entry.getValue();
                LinkedHashMap<String,List<SLPD0617ISftStdResult>> slpdStdResult = this.resetStdDate(nodeMap,results,entry.getKey());
                resultMap.put(entry.getKey(),slpdStdResult);
            }
        }else {
            if(CollectionUtils.isNotEmpty(breedIds)){
                SLPD0617ISftStdResult std = null;
                List<SLPD0617ISftStdResult> list = null;
                LinkedHashMap<String,List<SLPD0617ISftStdResult>> map = null;
                for(Long breed : breedIds){
                    map = new LinkedHashMap<>();
                    for(Map.Entry<String,List<DictNodeBean>> entry : nodeMap.entrySet()){
                        list = new ArrayList<>();
                        for(DictNodeBean nodeBean : entry.getValue()){
                            std = new SLPD0617ISftStdResult();
                            std.setBreedId(breed);
                            std.setSftStdType(nodeBean.getDataValue());
                            std.setSftStdTypeStr(nodeBean.getDataCN());
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
    private Map<Object, Map<Object,List<SLPD0617IDifSftStdResult>>> setDifStdResultMap(Map<Object, List<SLPD0617IDifSftStdResult>> resultDifStdMap,SLPD0617IParam param){
        Map<Object, Map<Object,List<SLPD0617IDifSftStdResult>>> resultMap = new HashMap<>();
        //查询所有的类型
        Map<String,List<DictNodeBean>> nodeMap = this.getNodeBean();
        //差异卡
        if(!org.springframework.util.CollectionUtils.isEmpty(resultDifStdMap)){
            for(Map.Entry<Object, List<SLPD0617IDifSftStdResult>> entry : resultDifStdMap.entrySet()){
                List<SLPD0617IDifSftStdResult> results = entry.getValue();
                if(CollectionUtils.isNotEmpty(results)){
                    if((CollectionUtils.isNotEmpty(param.getBreedIds()) && CollectionUtils.isNotEmpty(param.getProductIds()))
                            || (CollectionUtils.isNotEmpty(param.getBreedIds()) && CollectionUtils.isEmpty(param.getProductIds())) ){
                        Map<Object,List<SLPD0617IDifSftStdResult>> slpdDifStdResult = this.resetDifStdDate(nodeMap,results,Long.valueOf(entry.getKey().toString()),null);
                        resultMap.put(entry.getKey(),slpdDifStdResult);
                    }else if(CollectionUtils.isNotEmpty(param.getProductIds())){
                        Map<Object,List<SLPD0617IDifSftStdResult>> slpdDifStdResult = this.resetDifStdDate(nodeMap,results,null,entry.getKey().toString());
                        resultMap.put(entry.getKey(),slpdDifStdResult);
                    }
                }
            }
        }else {
            SLPD0617IDifSftStdResult difStd = null;
            List<SLPD0617IDifSftStdResult> list = null;
            Map<Object,List<SLPD0617IDifSftStdResult>> map = null;
            if((CollectionUtils.isNotEmpty(param.getBreedIds()) && CollectionUtils.isNotEmpty(param.getProductIds()))
                    || (CollectionUtils.isNotEmpty(param.getBreedIds()) && CollectionUtils.isEmpty(param.getProductIds()))){
                for (Long breedId : param.getBreedIds()) {
                    map = new HashMap<>();
                    for (Map.Entry<String, List<DictNodeBean>> entry : nodeMap.entrySet()) {
                        list = new ArrayList<>();
                        for (DictNodeBean nodeBean : entry.getValue()) {
                            difStd = new SLPD0617IDifSftStdResult();
                            difStd.setSftStdType(nodeBean.getDataValue());
                            difStd.setSftStdTypeStr(nodeBean.getDataCN());
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
                            difStd = new SLPD0617IDifSftStdResult();
                            difStd.setSftStdType(nodeBean.getDataValue());
                            difStd.setSftStdTypeStr(nodeBean.getDataCN());
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
                    List<SLPD0617ISftStdResult> slpdStdResults = this.getStdDate(entry.getValue(), (List<SLPD0617ISftStdResult>) slpdStds,breedId);
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
                    List<SLPD0617IDifSftStdResult> slpdStdResults = this.getStdDifDate(entry.getValue(), (List<SLPD0617IDifSftStdResult>) slpdStds,breedId,productId);
                    resultMap.put(entry.getKey(), (List<T>) slpdStdResults);
                }
            }
        }
        return resultMap;
    }


    //获取标准卡的数据
    private List<SLPD0617ISftStdResult> getStdDate(List<DictNodeBean> nodeBeanList,List<SLPD0617ISftStdResult> slpdStd,Long breedId){
        SLPD0617ISftStdResult std = null;
        List<SLPD0617ISftStdResult> slpdStdResults = new ArrayList<>();
        for(DictNodeBean type : nodeBeanList){
            boolean flg = true;
            //循环数据库结果集
            for(SLPD0617ISftStdResult result : slpdStd){
                //标准档案卡
                if(breedId.equals(result.getBreedId())
                        && type.getDataValue().equals(result.getSftStdType().toString())){
                    flg = false;
                    result.setSftStdType(type.getDataValue());
                    result.setSftStdTypeStr(type.getDataCN());
                    result.setParentType(type.getDataEN());
                    slpdStdResults.add(result);
                    break;
                }
            }
            //标准档案卡
            if(flg){
                std = new SLPD0617ISftStdResult();
                std.setBreedId(breedId);
                std.setSftStdType(type.getDataValue());
                std.setSftStdTypeStr(type.getDataCN());
                std.setParentType(type.getDataEN());
                slpdStdResults.add(std);
            }
        }
        return slpdStdResults;
    }






    //获取差异卡的数据
    private List<SLPD0617IDifSftStdResult> getStdDifDate(List<DictNodeBean> nodeBeanList,List<SLPD0617IDifSftStdResult> slpdStd,Long breedId,String productId){
        SLPD0617IDifSftStdResult std = null;
        List<SLPD0617IDifSftStdResult> slpdStdResults = new ArrayList<>();
        for(DictNodeBean type : nodeBeanList){
            boolean flg = true;
            for(SLPD0617IDifSftStdResult result : slpdStd){
                if(breedId != null){
                    if(breedId.equals(Long.valueOf(result.getBreedId()))
                            && type.getDataValue().equals(result.getSftStdType().toString())){
                        flg = false;
                        result.setSftStdType(type.getDataValue());
                        result.setSftStdTypeStr(type.getDataCN());
                        result.setParentType(type.getDataEN());
                        slpdStdResults.add(result);
                        break;
                    }
                }else if(StringUtils.isNoneEmpty(productId)){
                    if(productId.equals(String.valueOf(result.getProductId()))
                            && type.getDataValue().equals(result.getSftStdType().toString())){
                        flg = false;
                        result.setSftStdType(type.getDataValue());
                        result.setSftStdTypeStr(type.getDataCN());
                        result.setParentType(type.getDataEN());
                        slpdStdResults.add(result);
                        break;
                    }
                }
            }
            //标准档案卡
            if(flg){
                //标准差异卡
                std = new SLPD0617IDifSftStdResult();
                std.setBreedId(breedId);
                std.setProductId(productId);
                std.setSftStdType(type.getDataValue());
                std.setSftStdTypeStr(type.getDataCN());
                std.setParentType(type.getDataEN());
                slpdStdResults.add(std);
            }
        }
        return slpdStdResults;
    }

}
