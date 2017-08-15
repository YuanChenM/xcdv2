package com.bms.slpd.services.impl;

import com.bms.common.entity.DictNodeBean;
import com.bms.slpd.bean.param.SLPD0624IParam;
import com.bms.slpd.bean.result.SLPD0624IResult;
import com.bms.slpd.bean.result.field.SLPD0624IDifPkgStdResult;
import com.bms.slpd.bean.result.field.SLPD0624IPkgStdResult;
import com.bms.slpd.constant.CodeMasterConstant;
import com.bms.slpd.dao.SLPD0624IDao;
import com.bms.slpd.services.SLPD0624IService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SLPD0624IServiceImpl extends BaseServiceImpl implements SLPD0624IService {

    @Autowired
    private SLPD0624IDao slpd0624IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd0624IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SLPD0624IResult findPkgStdsAndDifStds(SLPD0624IParam param) {

        List<SLPD0624IPkgStdResult> slpdStds  = null;
        List<SLPD0624IDifPkgStdResult> slpdDifs = null;
        //查询差异卡
        if (param.getProductIds() != null && param.getProductIds().size() > 0) {
            slpdDifs = slpd0624IDao.findPkgDifStds(param);

            if (CollectionUtils.isNotEmpty(slpdDifs)) {
                HashSet<Long> itemIdsSet = new HashSet<>();
                //去除重复itemId
                for (SLPD0624IDifPkgStdResult slpdDif : slpdDifs) {
                    itemIdsSet.add(slpdDif.getItemId());
                }
                List list = new ArrayList();
                Iterator it = itemIdsSet.iterator();
                while (it.hasNext()) {
                    list.add(it.next());
                }
                //查询标准档案卡
                SLPD0624IParam findStdParam = new SLPD0624IParam();
                findStdParam.setItemIds(list);
                slpdStds  = slpd0624IDao.findPkgStds(findStdParam);
            }
        }
        if (param.getItemIds() != null && param.getItemIds().size() > 0) {
            if (param.getFindAllFlag() == 1) {
                //查询差异卡集合
                slpdDifs = slpd0624IDao.findPkgDifStds(param);
                //查询标准档案卡
                slpdStds  = slpd0624IDao.findPkgStds(param);
            } else {
                //查询标准档案卡
                slpdStds  = slpd0624IDao.findPkgStds(param);
            }
        }
        SLPD0624IResult slpd = this.getResult(slpdStds,slpdDifs,param);
        return slpd;
    }


    private SLPD0624IResult getResult(List<SLPD0624IPkgStdResult> slpdStds,List<SLPD0624IDifPkgStdResult> slpdDifs,SLPD0624IParam param){
        SLPD0624IResult slpd = new SLPD0624IResult();
        slpd.setSlpdStds(this.setStdResultList(slpdStds,param));
        if(param.getFindAllFlag() == 1){
            slpd.setSlpdDifStds(this.setDifStdResultList(slpdDifs,param));
        }
        return slpd;
    }


    //标准档案卡
    private Map<Long,List<SLPD0624IPkgStdResult>> setStdResultList( List<SLPD0624IPkgStdResult> slpdStds,SLPD0624IParam param){
        Map<Long, List<SLPD0624IPkgStdResult>> resultStdMap = new HashMap<>();
        if(CollectionUtils.isNotEmpty(slpdStds) && CollectionUtils.isNotEmpty(param.getItemIds())){
            List<SLPD0624IPkgStdResult> list = null;
            for(Long itemId : param.getItemIds()){
                list = new ArrayList<>();
                for(SLPD0624IPkgStdResult pkgStd : slpdStds){
                    if(itemId.equals(pkgStd.getItemId())){
                        list.add(pkgStd);
                    }
                }
                resultStdMap.put(itemId,list);
            }
        }
        return resultStdMap;
    }


    //差异卡
    private Map<Object,List<SLPD0624IDifPkgStdResult>> setDifStdResultList(List<SLPD0624IDifPkgStdResult> slpdDifs,SLPD0624IParam param){
        Map<Object, List<SLPD0624IDifPkgStdResult>> resultDifStdMap = new HashMap<>();
        if(CollectionUtils.isNotEmpty(slpdDifs)){
            List<SLPD0624IDifPkgStdResult> list = null;
            if(CollectionUtils.isNotEmpty(param.getItemIds())){
                for(Long itemId : param.getItemIds()){
                    list = new ArrayList<>();
                    for(SLPD0624IDifPkgStdResult difPkgStd :slpdDifs){
                        if(itemId.equals(Long.valueOf(difPkgStd.getItemId()))){
                            list.add(difPkgStd);
                        }
                    }
                    resultDifStdMap.put(itemId,list);
                }
            }else if (CollectionUtils.isNotEmpty(param.getProductIds())){
                for(String productId : param.getProductIds()){
                    list = new ArrayList<>();
                    for(SLPD0624IDifPkgStdResult difPkgStd :slpdDifs){
                        if(productId.equals(difPkgStd.getProductId())){
                            list.add(difPkgStd);
                        }
                    }
                    resultDifStdMap.put(productId,list);
                }
            }
        }
        return resultDifStdMap;
    }





}
