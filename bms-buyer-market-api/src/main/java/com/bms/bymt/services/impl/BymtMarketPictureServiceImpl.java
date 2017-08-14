/*
 * 2016/12/14 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.bymt.services.impl;

import com.bms.bymt.bean.entity.BymtMarketPicture;
import com.bms.bymt.bean.param.BaseBean;
import com.bms.bymt.bean.param.MarketPictureRsParam;
import com.bms.bymt.dao.BymtMarketPictureDao;
import com.bms.bymt.services.BymtMarketPictureService;
import com.bms.bymt.utils.RestCommUtil;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>BymtMarketPictureService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class BymtMarketPictureServiceImpl extends BaseServiceImpl implements BymtMarketPictureService {


    @Autowired
    private BymtMarketPictureDao bymtMarketPictureDao;

    @Override
    public BaseDao getBaseDao() {
        return bymtMarketPictureDao;
    }

    @Override
    public Integer updateAndSave(List<BaseBean<MarketPictureRsParam, MarketPictureRsParam>> param) {
        int size = param.size();
        Date curTime = DateUtils.getCurrent();
        int updateCount = NumberConst.IntDef.INT_ZERO;
        int insertCount = NumberConst.IntDef.INT_ZERO;
        List<BymtMarketPicture> insertList = new ArrayList<>();
        BaseBean<BymtMarketPicture, BymtMarketPicture> beanEntity;
        List<MarketPictureRsParam> pictureParamList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(param)) {
            for (int i = NumberConst.IntDef.INT_ZERO; i < size; i++) {
                beanEntity = new BaseBean<>();
                MarketPictureRsParam totalFilterParam = param.get(i).getFilter();
                MarketPictureRsParam totalTargetParam = param.get(i).getTarget();
                BymtMarketPicture pictureFilterEntity = BeanUtils.toBean(totalFilterParam, BymtMarketPicture.class);
                BymtMarketPicture pictureTargetEntity = BeanUtils.toBean(totalTargetParam, BymtMarketPicture.class);
                pictureTargetEntity.setUpdId(getLoginUserId());
                pictureTargetEntity.setUpdTime(curTime);
                pictureTargetEntity.setVersion(NumberConst.IntDef.INT_ZERO);
                if (pictureFilterEntity.getPicId() != null) {
                    beanEntity.setTarget(pictureTargetEntity);
                    beanEntity.setFilter(pictureFilterEntity);
                    updateCount += bymtMarketPictureDao.modify(beanEntity);
                } else {
                    //新增操作
                    Long picId = this.maxId("BYMT_MARKET_PICTURE");
                    pictureTargetEntity.setCrtId(getLoginUserId());
                    pictureTargetEntity.setCrtTime(curTime);
                    pictureTargetEntity.setPicId(picId);
                    insertList.add(pictureTargetEntity);
                }
            }

            List<List<BymtMarketPicture>> utilList = RestCommUtil.insertRanking(insertList);
            if (CollectionUtils.isNotEmpty(utilList)) {
                for (int i = NumberConst.IntDef.INT_ZERO; i < utilList.size(); i++) {
                    insertCount += bymtMarketPictureDao.batchInsert(utilList.get(i));
                }
            }
        }

        int result = updateCount + insertCount;
        return result;
    }
}