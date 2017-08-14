/*
 * 2016/12/06 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.byim.services.impl;


import com.bms.byim.bean.entity.ByimDeliveryArea;
import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.DeliveryAreaRsParam;
import com.bms.byim.dao.ByimDeliveryAreaDao;
import com.bms.byim.services.ByimDeliveryAreaService;
import com.bms.byim.utils.RestCommUtil;
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
 * <p>ByimDeliveryAreaService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class ByimDeliveryAreaServiceImpl extends BaseServiceImpl implements ByimDeliveryAreaService {

    @Autowired
    private ByimDeliveryAreaDao ByimDeliveryAreaDao;

    @Override
    public BaseDao getBaseDao() {
        return ByimDeliveryAreaDao;
    }

    @Override
    public int saveDeliveryArea(List<DeliveryAreaRsParam> params) {
        List<ByimDeliveryArea> deliveryAreaList = new ArrayList<>();
        Date curTime = DateUtils.getCurrent();
        if (CollectionUtils.isNotEmpty(params)) {
            int size = params.size();
            for (int i = NumberConst.IntDef.INT_ZERO; i < size; i++) {
                ByimDeliveryArea deliveryArea = BeanUtils.toBean(params.get(i), ByimDeliveryArea.class);
                Long deliveryAreaId = this.maxId("BYIM_DELIVERY_AREA");
                deliveryArea.setDeliveryAreaId(deliveryAreaId);
                deliveryArea.setUpdTime(curTime);
                deliveryArea.setUpdId(this.getLoginUserId());
                deliveryArea.setCrtTime(curTime);
                deliveryArea.setCrtId(this.getLoginUserId());
                deliveryArea.setDelFlg(false);
                deliveryArea.setVersion(NumberConst.IntDef.INT_ZERO);
                deliveryAreaList.add(deliveryArea);
            }
        }
        int count = NumberConst.IntDef.INT_ZERO;
        List<List<ByimDeliveryArea>> utilList = RestCommUtil.insertRanking(deliveryAreaList);
        if (CollectionUtils.isNotEmpty(utilList)) {
            for (int i = NumberConst.IntDef.INT_ZERO; i < utilList.size(); i++) {
                count += this.batchSave(utilList.get(i));
            }
        }
        return count;
    }

    @Override
    public int updateDeliveryArea(List<BaseBean<DeliveryAreaRsParam, DeliveryAreaRsParam>> params) {
        int listSize = params.size();
        Date curTime = DateUtils.getCurrent();
        int resultLine = NumberConst.IntDef.INT_ZERO;
        BaseBean<ByimDeliveryArea, ByimDeliveryArea> beanEntity;
        for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
            beanEntity = new BaseBean<>();
            ByimDeliveryArea filterEntity = BeanUtils.toBean(params.get(i).getFilter(), ByimDeliveryArea.class);
            ByimDeliveryArea targetEntity = BeanUtils.toBean(params.get(i).getTarget(), ByimDeliveryArea.class);
            targetEntity.setUpdTime(curTime);
            targetEntity.setUpdId(getLoginUserId());
            beanEntity.setFilter(filterEntity);
            beanEntity.setTarget(targetEntity);
            int line = ByimDeliveryAreaDao.modify(beanEntity);
            resultLine += line;

        }
        return resultLine;
    }

    @Override
    public int findDeliveryArea(List<BaseBean<DeliveryAreaRsParam, DeliveryAreaRsParam>> params) {
        int result = NumberConst.IntDef.INT_ZERO;
        for (int i = NumberConst.IntDef.INT_ZERO; i < params.size(); i++) {
            result = ByimDeliveryAreaDao.findDeliveryArea(params.get(i));
        }
        return result;
    }
}