package com.batch.order.service.impl;

import com.batch.order.bean.entity.BuyerOrderHistoryEntity;
import com.batch.order.bean.result.ORDR0101BOrderResult;
import com.batch.order.bean.result.ORDR0201BOrderResult;
import com.batch.order.dao.ORDR0101BDao;
import com.batch.order.dao.ORDR0201BDao;
import com.batch.order.service.ORDR0101BService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.DateUtils;
import com.framework.redis.dao.BaseRedisDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liutao on 2017/1/4.
 */
@Service
public class ORDR0101BServiceImpl extends BaseServiceImpl implements ORDR0101BService {

    private static final Logger logger = LoggerFactory.getLogger(ORDR0101BServiceImpl.class);

    @Autowired
    private ORDR0101BDao ordr0101BDao;

    @Autowired
    private ORDR0201BDao ordr0201BDao;

    @Autowired
    private BaseRedisDao baseRedisDao;

    /**
     * 确认操作
     */
    @Override
    public void confirmOrder() {
        // 得到所有确认订单
        List<ORDR0101BOrderResult> orders = ordr0101BDao.getConfirmOrder();
        if (CollectionUtils.isEmpty(orders)) {
            return;
        }
        Date createTime = DateUtils.getCurrent();
        Long maxId = baseRedisDao.getTablePrimaryKey("ordr_buyer_seller_detail", orders.size());
        Map<Long,Long> orderIdMap = new HashMap<>();
        for (ORDR0101BOrderResult order : orders) {
            orderIdMap.put(order.getBuyerOrderId(),order.getBuyerOrderId());
            order.setSellerDetailId(maxId--);
            order.setCrtTime(createTime);
            order.setUpdTime(createTime);
            order.setCrtId("ORDR0101B");
            order.setUpdId("ORDR0101B");
            order.setDelFlg(false);
            order.setVersion(1);
        }
        logger.debug("插入买家分批订单供货信息表 开始");
        ordr0101BDao.batchInsert(orders);
        logger.debug("插入买家分批订单供货信息表 结束");
        // 更改订单状态
        logger.debug("更改订单状态 开始");
        for (Long buyerOrderId : orderIdMap.values()) {
            ORDR0201BOrderResult orderResult = new ORDR0201BOrderResult();
            orderResult.setBuyerOrderId(buyerOrderId);
            orderResult.setBuyerOrderStu("002");
            BuyerOrderHistoryEntity buyerOrderHistoryEntity = ordr0201BDao.getBuyerOrderHistory(orderResult);
            buyerOrderHistoryEntity.setHistoryId(baseRedisDao.getTablePrimaryKey("ORDR_BUYER_ORDER_HISTORY", 1));
            ordr0201BDao.saveBuyerOrderHistory(buyerOrderHistoryEntity);
            ordr0201BDao.modifyBuyerOrderStu(orderResult);
        }
        logger.debug("更改订单状态 结束");
    }

    @Override
    public BaseDao getBaseDao() {
        return ordr0101BDao;
    }
}
