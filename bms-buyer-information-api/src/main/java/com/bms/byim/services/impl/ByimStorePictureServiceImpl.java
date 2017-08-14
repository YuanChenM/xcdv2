/*
 * 2016/12/29 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.byim.services.impl;

import com.bms.byim.bean.entity.ByimStorePicture;
import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.StorePictureRsParam;
import com.bms.byim.bean.result.StorePictureRsResult;
import com.bms.byim.dao.ByimStorePictureDao;
import com.bms.byim.services.ByimStorePictureService;
import com.bms.byim.utils.RestCommUtil;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>ByimStorePictureService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class ByimStorePictureServiceImpl extends BaseServiceImpl implements ByimStorePictureService {

    @Autowired
    private ByimStorePictureDao byimStorePictureDao;

    @Override
    public BaseDao getBaseDao() {
        return byimStorePictureDao;
    }

    @Override
    public int saveStorePictures(List<StorePictureRsParam> paramList) {
        int count;
        StorePictureRsResult rsResult = new StorePictureRsResult();
        StorePictureRsParam storePictureRsParam = null;
        ByimStorePicture storePicture = null;
        int result = NumberConst.IntDef.INT_ZERO;
        Date currentDate = DateUtils.getCurrent();
        List<ByimStorePicture> storePictureList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(paramList)) {
            int listSize = paramList.size();
            for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {

                storePictureRsParam = paramList.get(i);
                storePicture = BeanUtils.toBean(storePictureRsParam, ByimStorePicture.class);
                storePicture.setUpdId(getLoginUserId());
                storePicture.setUpdTime(currentDate);

                if(!paramList.get(i).getLicenseType().equals("4") && !paramList.get(i).getLicenseType().equals("5")){
                    count = this.getCount(paramList.get(i));
                    if(count > NumberUtils.INTEGER_ZERO){
                        byimStorePictureDao.delete(storePicture);
                    }
                }
                Long picId = this.maxId("BYIM_STORE_PICTURE");
                storePicture.setPicId(picId);
                storePicture.setCrtId(getLoginUserId());
                storePicture.setCrtTime(currentDate);
                storePicture.setVersion(NumberConst.IntDef.INT_ONE);
                storePicture.setDelFlg(false);
                storePictureList.add(storePicture);
            }


            List<List<ByimStorePicture>> lists = RestCommUtil.insertRanking(storePictureList);
            int listSizes = lists.size();
            for (int i = NumberConst.IntDef.INT_ZERO; i < listSizes; i++) {
                int res = this.batchSave(lists.get(i));
                result += res;
            }
            rsResult.setStorePictureList(storePictureList);
        }

        return result;
    }

    @Override
    public int modifyStorePhotos(List<BaseBean<StorePictureRsParam, StorePictureRsParam>> baseBeanList) {
        BaseBean<ByimStorePicture, ByimStorePicture> baseBean = new BaseBean<>();
        Date currentDate = DateUtils.getCurrent();
        int listSize = baseBeanList.size();
        int result = NumberConst.IntDef.INT_ZERO;
        for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
            StorePictureRsParam filter = baseBeanList.get(i).getFilter();
            StorePictureRsParam target = baseBeanList.get(i).getTarget();
            ByimStorePicture filterEntity = BeanUtils.toBean(filter, ByimStorePicture.class);
            ByimStorePicture targetEntity = BeanUtils.toBean(target, ByimStorePicture.class);
            targetEntity.setUpdId(getLoginUserId());
            targetEntity.setUpdTime(currentDate);
            baseBean.setFilter(filterEntity);
            baseBean.setTarget(targetEntity);
            int res = this.modify(baseBean);
            result += res;
        }
        return result;
    }
}