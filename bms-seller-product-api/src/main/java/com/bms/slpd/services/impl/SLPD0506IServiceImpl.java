package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdBrandOwner;
import com.bms.slpd.bean.param.SLPD0506IParam;
import com.bms.slpd.bean.result.SLPD0506IResult;
import com.bms.slpd.bean.result.wrapper.SlpdBrandItemResult;
import com.bms.slpd.dao.SLPD0506IDao;
import com.bms.slpd.services.SLPD0506IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SLPD0506IServiceImpl extends BaseServiceImpl implements SLPD0506IService {

    @Autowired
    private SLPD0506IDao slpd0506IDao;

    @Override
    public BaseDao getBaseDao() {
      return slpd0506IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SLPD0506IResult findBrandItemsBySql(SLPD0506IParam restRequest) {
        BaseRestPaginationResult<SlpdBrandItemResult> pageResult = super.findPageList(restRequest);
        List<SlpdBrandItemResult> slpdBrandItemResultList  =pageResult.getData();

        if(slpdBrandItemResultList!=null&&slpdBrandItemResultList.size()>0){
            Set<Long> brandIdsSet = new HashSet<>();
            for (SlpdBrandItemResult slpdBrandItemResult : slpdBrandItemResultList) {
                brandIdsSet.add(slpdBrandItemResult.getBrandId());
            }
            List<Long> list= new ArrayList<>(brandIdsSet);
            List<SlpdBrandItemResult> slpdBrandItemResults=slpd0506IDao.findBrandOwners(list);
            HashMap<Long, List<SlpdBrandOwner>> ownerObjsMap = new HashMap<>();
            for (SlpdBrandItemResult slpdBrandItemResult:slpdBrandItemResults){
                ownerObjsMap.put(slpdBrandItemResult.getBrandId(),slpdBrandItemResult.getSlpdBrandOwnerList());
            }
            for (SlpdBrandItemResult slpdBrandItemResult: slpdBrandItemResultList){
                slpdBrandItemResult.setSlpdBrandOwnerList(ownerObjsMap.get(slpdBrandItemResult.getBrandId()));
            }
        }

        return BeanUtils.toBean(pageResult,SLPD0506IResult.class);
    }
}