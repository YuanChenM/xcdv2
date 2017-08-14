/*
 * 2016/12/29 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.byim.services.impl;

import com.bms.byim.bean.entity.ByimDeliveryAddr;
import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.DeliveryAddrRsParam;
import com.bms.byim.bean.result.DeliveryAddrRsResult;
import com.bms.byim.dao.ByimDeliveryAddrDao;
import com.bms.byim.services.ByimDeliveryAddrService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>ByimDeliveryAddrService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class ByimDeliveryAddrServiceImpl extends BaseServiceImpl implements ByimDeliveryAddrService {

    Logger logger = LoggerFactory.getLogger(ByimDeliveryAddrServiceImpl.class);

    @Autowired
    private ByimDeliveryAddrDao byimDeliveryAddrDao;

    @Override
    public BaseDao getBaseDao() {
        return byimDeliveryAddrDao;
    }

    @Override
    public DeliveryAddrRsResult addDeliveryAddr(ByimDeliveryAddr addrEntity) {
        DeliveryAddrRsResult addrRsResult = new DeliveryAddrRsResult();
        Date curTime = DateUtils.getCurrent();
        Long deliveryId = this.maxId("BYIM_DELIVERY_ADDR");
        addrEntity.setDeliveryId(deliveryId);
        addrEntity.setUpdTime(curTime);
        addrEntity.setUpdId(getLoginUserId());
        addrEntity.setCrtTime(curTime);
        addrEntity.setCrtId(getLoginUserId());
        addrEntity.setDelFlg(false);
        addrEntity.setVersion(0);
        if (addrEntity.getIsDefaultFlg() != null && addrEntity.getIsDefaultFlg()) {
            byimDeliveryAddrDao.modifyDefaultFlg(addrEntity);
        }
        this.byimDeliveryAddrDao.save(addrEntity);
        addrRsResult = BeanUtils.toBean(addrEntity, DeliveryAddrRsResult.class);
        return addrRsResult;
    }

    @Override
    public int updateDeliveryAddr(BaseBean<DeliveryAddrRsParam, DeliveryAddrRsParam> param) {

        Date curTime = DateUtils.getCurrent();
        logger.info("param转entity");
        BaseBean<ByimDeliveryAddr, ByimDeliveryAddr> addrEntity = new BaseBean<>();
        DeliveryAddrRsParam filterParam = param.getFilter();
        DeliveryAddrRsParam targetParam = param.getTarget();
        ByimDeliveryAddr targetEntity = BeanUtils.toBean(targetParam, ByimDeliveryAddr.class);
        ByimDeliveryAddr filterEntity = BeanUtils.toBean(filterParam, ByimDeliveryAddr.class);
        targetEntity.setUpdTime(curTime);
        targetEntity.setUpdId(getLoginUserId());
        addrEntity.setFilter(filterEntity);
        addrEntity.setTarget(targetEntity);
        if (addrEntity.getTarget().getIsDefaultFlg() != null && addrEntity.getTarget().getIsDefaultFlg()) {
            byimDeliveryAddrDao.modifyDefaultFlg(addrEntity.getFilter());
        }
        return byimDeliveryAddrDao.modify(addrEntity);
    }
}