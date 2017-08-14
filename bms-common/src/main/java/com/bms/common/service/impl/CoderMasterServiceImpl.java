package com.bms.common.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.bms.common.entity.DictLeafNodeBean;
import com.bms.common.entity.DictNodeBean;
import com.bms.common.param.FindNodeParam;
import com.bms.common.rest.client.RestClientFactory;
import com.bms.common.service.CoderMasterService;
import com.framework.cache.CacheManager;
import com.framework.core.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zhu_kai1 on 2016/12/23.
 */
@Service
public class CoderMasterServiceImpl implements CoderMasterService {

    @Autowired
    private RestClientFactory clientFactory;
    // 数据字典初始化url
    public static String dictionaryUrl;

    private static  String CodeMaster = "CodeMaster";

    private static  String ConfigConstant = "ConfigConstant";
    /**
     * 获取codeMaster中的数据
     * @param key
     * @return
     */
    @Override
    public List<DictNodeBean> getCodeMaster(String key) {
        CacheManager cacheManager = CacheManager.getInstance().putListener();
        Object object = cacheManager.get(key);
        if(object !=null){
            if(object instanceof List && !CollectionUtils.isEmpty((List) object)) {
                List<DictNodeBean>  dictNodeBeanList = BeanUtils.toList((List) object, DictNodeBean.class);
                // 自定义排序
                Collections.sort(dictNodeBeanList, new Comparator<DictNodeBean>() {
                    @Override
                    public int compare(DictNodeBean o1, DictNodeBean o2) {
                        return o1.getDataValue().compareTo(o2.getDataValue());
                    }
                });
                return dictNodeBeanList;
            }
        }else {
            List<DictNodeBean> tempList = getDictionaryInfo(key,CodeMaster);
            if(!CollectionUtils.isEmpty(tempList)){
                // 自定义排序
                Collections.sort(tempList, new Comparator<DictNodeBean>() {
                    @Override
                    public int compare(DictNodeBean o1, DictNodeBean o2) {
                        return o1.getDataValue().compareTo(o2.getDataValue());
                    }
                });
                // 往缓存中存
                cacheManager.put(key,tempList,3600*4);
                return tempList;
            }
        }
        return new ArrayList<>();
    }

    /**
     * 获取ConfigConstant的数据
     * @param key
     * @return
     */
    @Override
    public String getConfigConstant(String key) {
        CacheManager cacheManager = CacheManager.getInstance().putListener();
        Object object = cacheManager.get(key);
        if(object !=null){
            List<DictNodeBean> list = (List) object;
            if(!CollectionUtils.isEmpty(list)){
                return list.get(0).getDataCN();
            }
        }else {
            List<DictNodeBean> tempList = getDictionaryInfo(key,ConfigConstant);
            if(!CollectionUtils.isEmpty(tempList)){
                // 往缓存中存
                cacheManager.put(key,tempList);
                return tempList.get(0).getDataCN();
            }
        }
        return null;
    }


    /**
     * 调用数据字典获取对应的值
     * @param key
     * @return
     */
    private List<DictNodeBean> getDictionaryInfo(String key,String rootCode) {
        FindNodeParam param = new FindNodeParam();
        param.setDictCode(key);
        param.setRootCode(rootCode);
        param.setDetail(true);
         DictLeafNodeBean dictionList = clientFactory.newRestClient().post(dictionaryUrl, param, new TypeReference<DictLeafNodeBean>() {
        });
        List<DictNodeBean> tempList = new ArrayList<DictNodeBean>();
        if(null !=dictionList){
            tempList.addAll(dictionList.getValues());
        }
        return tempList;
    }
}
