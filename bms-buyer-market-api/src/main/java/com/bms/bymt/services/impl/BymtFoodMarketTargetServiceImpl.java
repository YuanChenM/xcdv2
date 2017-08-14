/*
 * 2016/12/14 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
 package com.bms.bymt.services.impl;

import com.bms.bymt.bean.BaseRequest;
import com.bms.bymt.bean.entity.BymtFoodMarketTarget;
import com.bms.bymt.bean.param.BaseBean;
import com.bms.bymt.bean.param.FoodMarketTargetRsParam;
import com.bms.bymt.dao.BymtFoodMarketTargetDao;
import com.bms.bymt.services.BymtFoodMarketTargetService;
import com.bms.bymt.utils.RestCommUtil;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>BymtFoodMarketTargetService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
 @Service
 public class BymtFoodMarketTargetServiceImpl extends BaseServiceImpl implements BymtFoodMarketTargetService{

    @Autowired
    private BymtFoodMarketTargetDao bymtFoodMarketTargetDao;

    @Override
    public BaseDao getBaseDao() {
      return bymtFoodMarketTargetDao;
    }


    @Override
    public Integer executeInsert(List<FoodMarketTargetRsParam> rsParam) {

        BeanUtils.toBean(rsParam, BymtFoodMarketTarget.class);
        BymtFoodMarketTarget bymtFoodMarketTarget;
        List<BymtFoodMarketTarget> list = new ArrayList<>();
        Date currentDate = DateUtils.getCurrent();
        for (int i = 0, sizes = rsParam.size(); i < sizes; i++) {
            int proNameCount = getCount(rsParam.get(i));
            if(proNameCount != NumberConst.IntDef.INT_ZERO){
                return NumberConst.IntDef.INT_N_ONE;
            }
            bymtFoodMarketTarget = BeanUtils.toBean(rsParam.get(i), BymtFoodMarketTarget.class);
            Long maxId = maxId("BYMT_TERMINAL_MARKET_TARGET");
            bymtFoodMarketTarget.setTargetId(maxId);
            bymtFoodMarketTarget.setCrtTime(currentDate);
            bymtFoodMarketTarget.setUpdTime(currentDate);
            bymtFoodMarketTarget.setCrtId(getLoginUserId());
            bymtFoodMarketTarget.setUpdId(getLoginUserId());
            list.add(bymtFoodMarketTarget);
        }
        List<List<BymtFoodMarketTarget>> groupList = RestCommUtil.insertRanking(list);
        int countInsert;
        int countAll = NumberUtils.INTEGER_ZERO;


        for(int i=0,sizes=groupList.size();i < sizes;i++){
            countInsert = batchSave(groupList.get(i));
            countAll += countInsert;
        }
        return countAll;
    }

    @Override
    public Integer executeModify(List<BaseBean<FoodMarketTargetRsParam, FoodMarketTargetRsParam>> paramList) {
        int paramSize = paramList.size();
        List<BaseBean<BymtFoodMarketTarget, BymtFoodMarketTarget>> baseBeanList = new ArrayList<>();
        for (int i = 0; i < paramSize; i++) {
            BymtFoodMarketTarget filter = BeanUtils.toBean(paramList.get(i).getFilter(), BymtFoodMarketTarget.class);
            BymtFoodMarketTarget target = BeanUtils.toBean(paramList.get(i).getTarget(), BymtFoodMarketTarget.class);
            Date currentDate = DateUtils.getCurrent();
            target.setUpdId(getLoginUserId());
            target.setUpdTime(currentDate);
            BaseRequest<BaseBean<BymtFoodMarketTarget, BymtFoodMarketTarget>> param = new BaseRequest<>();
            BaseBean<BymtFoodMarketTarget, BymtFoodMarketTarget> bean = new BaseBean<>();
            bean.setFilter(filter);
            bean.setTarget(target);
            param.setBean(bean);
            baseBeanList.add(bean);
        }

        int beansSize = baseBeanList.size();
        int count;
        int lines = NumberUtils.INTEGER_ZERO;
        for(int i=0;i < beansSize;i++){
            count = modify(baseBeanList.get(i));
            if(count == NumberUtils.INTEGER_ZERO){
                return count;
            }else {
                lines ++;
            }
        }

        return lines;
    }

    @Override
    public FoodMarketTargetRsParam findTotal(FoodMarketTargetRsParam param) {
        return bymtFoodMarketTargetDao.findTotal(param);
    }
}