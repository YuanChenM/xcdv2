package com.batch.order.service.impl;

import com.batch.order.bean.RestRequest;
import com.batch.order.bean.entity.BuyerBatchOrderHistoryEntity;
import com.batch.order.bean.entity.DistributionNotificationDetailEntity;
import com.batch.order.bean.param.MailSendRsParam;
import com.batch.order.bean.result.ORDR0302DistributionDetailResult;
import com.batch.order.bean.result.ORDR0302DistributionDetailsResult;
import com.batch.order.bean.result.ORDR0302DistributionResult;
import com.batch.order.bean.result.OrderBatchEmailResult;
import com.batch.order.constant.OrderConstant;
import com.batch.order.dao.ORDR0302BDao;
import com.batch.order.service.ORDR0302BService;
import com.batch.order.util.client.BaseRestClientUtil;
import com.framework.base.consts.DateFormatDef;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.NumberUtils;
import com.framework.number.generate.NumberGenerateManager;
import com.framework.number.generate.enums.ResetType;
import com.framework.redis.dao.BaseRedisDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * Created by liutao on 2017/1/4.
 */
@Service
public class ORDR0302BServiceImpl extends BaseServiceImpl implements ORDR0302BService {

    private static final Logger logger = LoggerFactory.getLogger(ORDR0302BServiceImpl.class);

    @Autowired
    private ORDR0302BDao ordr0302BDao;

    @Autowired
    private BaseRedisDao baseRedisDao;

    @Autowired
    private BaseRestClientUtil baseRestClientUtil;

    @Override
    public BaseDao getBaseDao() {
        return ordr0302BDao;
    }

    @Override
    public void createDistributionNotification() {
        try {
            //得到所有满生成配送通知单的订单信息
            List<ORDR0302DistributionResult> orders = ordr0302BDao.getBuyerOrderList();
            if (CollectionUtils.isEmpty(orders)) {
                return;
            }
            Date createTime = DateUtils.getCurrent();
            for (ORDR0302DistributionResult order : orders) {
                List<ORDR0302DistributionResult> orderBatchs = ordr0302BDao.getOrderBatchList(order);
                if (CollectionUtils.isEmpty(orderBatchs)) {
                    continue;
                }
                //生产配送通知单
                for (ORDR0302DistributionResult orderBatch : orderBatchs) {
                    List<ORDR0302DistributionDetailResult> detailResults = orderBatch.getDetailEntities();
                    if (CollectionUtils.isEmpty(detailResults)) {
                        continue;
                    }
                    orderBatch.setDistributionNotificationId(baseRedisDao.getTablePrimaryKey("ORDR_DISTRIBUTION_NOTIFICATION", 1));

                    // 生成配送通知单编码
                    String distributionNotificationCode = NumberGenerateManager.timestamp("PSTZ", DateFormatDef.FORMAT_YYYYMMDD, 8, "0", ResetType.Day);
                    orderBatch.setDistributionNotificationCode(distributionNotificationCode);

                    orderBatch.setSendFlg(false);
                    orderBatch.setDistributionNotificationStu("007");
                    orderBatch.setCrtId("ORDR0302B");
                    orderBatch.setCrtTime(createTime);
                    orderBatch.setUpdId("ORDR0302B");
                    orderBatch.setUpdTime(createTime);
                    orderBatch.setVersion(1);
                    orderBatch.setDelFlg(false);
                    ordr0302BDao.saveDistributionInfo(orderBatch);
                    for (ORDR0302DistributionDetailResult detailResult : detailResults) {
                        List<ORDR0302DistributionDetailsResult> distributionDetailEntities = detailResult.getDistributionDetailEntities();
                        if (CollectionUtils.isEmpty(distributionDetailEntities)) {
                            continue;
                        }
                        for (DistributionNotificationDetailEntity distributionDetailEntitie : distributionDetailEntities) {
                            distributionDetailEntitie.setDistributionNotificationDetailId(baseRedisDao.getTablePrimaryKey("ORDR_DISTRIBUTION_NOTIFICATION_DETAIL", 1));
                            distributionDetailEntitie.setDistributionNotificationId(orderBatch.getDistributionNotificationId());
                            distributionDetailEntitie.setCrtId("ORDR0302B");
                            distributionDetailEntitie.setCrtTime(createTime);
                            distributionDetailEntitie.setUpdId("ORDR0302B");
                            distributionDetailEntitie.setUpdTime(createTime);
                            distributionDetailEntitie.setVersion(1);
                            distributionDetailEntitie.setDelFlg(false);
                            ordr0302BDao.saveDistributionDetailInfo(distributionDetailEntitie);
                        }
                        if (!detailResult.getLateFlg()) {
                            detailResult.setBuyerBatchOrderStu("004");
                        } else {
                            if (detailResult.getBuyerBatchOrderStu().equals("008")) {
                                detailResult.setBuyerBatchOrderStu("004");
                            }
                        }
                        detailResult.setUpdId("ORDR0302B");
                        detailResult.setUpdTime(createTime);
                        BuyerBatchOrderHistoryEntity buyerBatchOrderHistoryEntity = ordr0302BDao.findHistory(detailResult);
                        buyerBatchOrderHistoryEntity.setHistoryId(baseRedisDao.getTablePrimaryKey("ORDR_BUYER_BATCH_ORDER_HISTORY", 1));
                        ordr0302BDao.saveBuyerBatchOrderHistory(buyerBatchOrderHistoryEntity);
                        ordr0302BDao.modifyBuyerBatchInfo(detailResult);
                    }
                }
            }
        } catch (Exception e){
            // 模板邮件内容
            List<OrderBatchEmailResult> emailResults = new ArrayList<>();
            OrderBatchEmailResult result = new OrderBatchEmailResult();
            result.setBatchNo("ORDR0302B");
            result.setErrorMessage(e.getMessage());
            emailResults.add(result);
            baseRestClientUtil.sendFailMail(emailResults);

            logger.debug(e.getMessage());
            throw e;
        }
    }
}