package com.batch.order.service.impl;

import com.batch.order.bean.entity.BuyerBatchOrderHistoryEntity;
import com.batch.order.bean.entity.DistributionNotificationDetailEntity;
import com.batch.order.bean.result.*;
import com.batch.order.bean.template.ORDR0301BXmlTemplate;
import com.batch.order.dao.ORDR0301BDao;
import com.batch.order.service.ORDR0301BService;
import com.batch.order.util.FtpUtil;
import com.framework.base.consts.DateFormatDef;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.file.ftp.FtpUtils;
import com.framework.core.file.xml.jaxb.JaxbXmlWrite;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.NumberUtils;
import com.framework.number.generate.NumberGenerateManager;
import com.framework.number.generate.enums.ResetType;
import com.framework.redis.dao.BaseRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by liutao on 2017/1/4.
 */
@Service
public class ORDR0301BServiceImpl extends BaseServiceImpl implements ORDR0301BService {

    @Autowired
    private ORDR0301BDao ordr0301BDao;

    @Autowired
    private BaseRedisDao baseRedisDao;

    @Override
    public BaseDao getBaseDao() {
        return ordr0301BDao;
    }

    @Override
    public void createDistributionNotification() {
        //得到所有满生成配送通知单的订单信息
        List<ORDR0301DistributionResult> orders = ordr0301BDao.getBuyerOrderList();
        if (CollectionUtils.isEmpty(orders)) {
            return;
        }
        Date createTime = DateUtils.getCurrent();
        for (ORDR0301DistributionResult order : orders) {
            Integer count = ordr0301BDao.getDistributionCount(order);
            if (order.getUseNetFlg()) {
                if (!order.getPaymentStu().equals("003")) {
                    continue;
                }
            } else if (count > NumberUtils.INTEGER_ZERO && !order.getPaymentStu().equals("003")) {
                continue;
            }

            List<ORDR0301DistributionResult> orderBatchs = ordr0301BDao.getOrderBatchList(order);
            if (CollectionUtils.isEmpty(orderBatchs)) {
                continue;
            }
            //生产配送通知单
            for (ORDR0301DistributionResult orderBatch : orderBatchs) {
                List<ORDR0301DistributionDetailResult> detailResults = orderBatch.getDetailEntities();
                if (CollectionUtils.isEmpty(detailResults)) {
                    continue;
                }
                orderBatch.setDistributionNotificationId(baseRedisDao.getTablePrimaryKey("ORDR_DISTRIBUTION_NOTIFICATION", 1));

                // 生成配送通知单编码
                String distributionNotificationCode = NumberGenerateManager.timestamp("PSTZ", DateFormatDef.FORMAT_YYYYMMDD, 8, "0", ResetType.Day);
                orderBatch.setDistributionNotificationCode(distributionNotificationCode);

                orderBatch.setSendFlg(true);
                orderBatch.setDistributionNotificationStu("001");
                orderBatch.setCrtId("ORDR0301B");
                orderBatch.setCrtTime(createTime);
                orderBatch.setUpdId("ORDR0301B");
                orderBatch.setUpdTime(createTime);
                orderBatch.setVersion(1);
                orderBatch.setDelFlg(false);
                ordr0301BDao.saveDistributionInfo(orderBatch);
                for (ORDR0301DistributionDetailResult detailResult : detailResults) {
                    List<ORDR0301DistributionDetailsResult> distributionDetailEntities = detailResult.getDistributionDetailEntities();
                    if (CollectionUtils.isEmpty(distributionDetailEntities)) {
                        continue;
                    }
                    for (DistributionNotificationDetailEntity distributionDetailEntitie : distributionDetailEntities) {
                        distributionDetailEntitie.setDistributionNotificationDetailId(baseRedisDao.getTablePrimaryKey("ORDR_DISTRIBUTION_NOTIFICATION_DETAIL", 1));
                        distributionDetailEntitie.setDistributionNotificationId(orderBatch.getDistributionNotificationId());
                        distributionDetailEntitie.setCrtId("ORDR0301B");
                        distributionDetailEntitie.setCrtTime(createTime);
                        distributionDetailEntitie.setUpdId("ORDR0301B");
                        distributionDetailEntitie.setUpdTime(createTime);
                        distributionDetailEntitie.setVersion(1);
                        distributionDetailEntitie.setDelFlg(false);
                        ordr0301BDao.saveDistributionDetailInfo(distributionDetailEntitie);
                    }
                    if (!detailResult.getLateFlg()) {
                        detailResult.setBuyerBatchOrderStu("004");
                    } else {
                        if (detailResult.getBuyerBatchOrderStu().equals("008")) {
                            detailResult.setBuyerBatchOrderStu("004");
                        }
                    }
                    detailResult.setUpdId("ORDR0301B");
                    detailResult.setUpdTime(createTime);
                    BuyerBatchOrderHistoryEntity buyerBatchOrderHistoryEntity = ordr0301BDao.findHistory(detailResult);
                    buyerBatchOrderHistoryEntity.setHistoryId(baseRedisDao.getTablePrimaryKey("ORDR_BUYER_BATCH_ORDER_HISTORY", 1));
                    ordr0301BDao.saveBuyerBatchOrderHistory(buyerBatchOrderHistoryEntity);
                    ordr0301BDao.modifyBuyerBatchInfo(detailResult);
                }


            }

            for (ORDR0301DistributionResult orderBatch : orderBatchs) {
                List<ORDR0301BResult> ordr0301BResults = getORDR0301BResult(orderBatch);
                ORDR0301BXmlTemplate xmlTemplate = new ORDR0301BXmlTemplate();
                xmlTemplate.setData(ordr0301BResults);
                JaxbXmlWrite<ORDR0301BXmlTemplate> xmlWrite = new JaxbXmlWrite<>(xmlTemplate);
                InputStream inputStream = xmlWrite.createXml(ORDR0301BXmlTemplate.class);
                FtpUtils ftpUtils = FtpUtil.getFtpUtils();
                ftpUtils.upload("/ORDR", inputStream, "SO" + orderBatch.getDistributionNotificationCode() + ".xml");
            }
        }
    }

    /**
     * 得到生产xml的数据
     *
     * @param orderBatch
     * @return
     */
    public List<ORDR0301BResult> getORDR0301BResult(ORDR0301DistributionResult orderBatch) {
        List<ORDR0301BResult> results = new ArrayList<>();
        ORDR0301BResult result = new ORDR0301BResult();
        ORDR0301BReceiverResult receiver = new ORDR0301BReceiverResult();
        List<ORDR0301BDistributionResult> distributionResults = new ArrayList<>();
        result.setOrderId(orderBatch.getDistributionNotificationId());
        result.setOrderCode(orderBatch.getDistributionNotificationCode());
        result.setOriginalorderId(orderBatch.getBuyerOrderId());
        result.setOrderType(orderBatch.getOrderType());
        result.setBuyerId(orderBatch.getBuyerId());
        result.setBuyerType(orderBatch.getBuyerType());
        result.setBuyerName(orderBatch.getBuyerName());
        result.setRequestedDate(DateUtils.parse(DateUtils.FORMAT_YYYY_MM_DD_HH_MM_SS, DateUtils.format(DateUtils.FORMAT_YYYY_MM_DD_HH_MM_SS, orderBatch.getExpectedArrivalDatetime())));
        result.setScheduledDate(DateUtils.parse(DateUtils.FORMAT_YYYY_MM_DD_HH_MM_SS, DateUtils.format(DateUtils.FORMAT_YYYY_MM_DD_HH_MM_SS, orderBatch.getExpectedSendDatetime())));
        result.setVer(orderBatch.getVersion());
        result.setPaymentType(orderBatch.getPaymentType());
        receiver.setName(orderBatch.getReceiverName());
        receiver.setTel(orderBatch.getReceiverPhone());
        receiver.setWx(orderBatch.getReceiverWechat());
        receiver.setQq(orderBatch.getReceiverQq());
        receiver.setEmail(orderBatch.getReceiverMail());
        receiver.setProvince(orderBatch.getReceiverProvince());
        receiver.setCity(orderBatch.getReceiverCity());
        receiver.setDistrict(orderBatch.getReceiverDistrict());
        receiver.setAddr(orderBatch.getReceiverAddress());
        receiver.setAddr2(orderBatch.getReceiverAssistAddress());
//        receiver.setAddrkey();
        receiver.setDeliveryType(orderBatch.getDistributionType());
        result.setReceiver(receiver);
        List<ORDR0301DistributionDetailResult> detailEntities = orderBatch.getDetailEntities();
        for (ORDR0301DistributionDetailResult detailResult : detailEntities) {
            List<ORDR0301DistributionDetailsResult> distributionDetailsResults = detailResult.getDistributionDetailEntities();
            for (ORDR0301DistributionDetailsResult distributionDetailsResult : distributionDetailsResults) {
                ORDR0301BDistributionResult distributionResult = new ORDR0301BDistributionResult();
                distributionResult.setOrderline(distributionDetailsResult.getBuyerForcastDeliverDetailId());
                distributionResult.setSku(distributionDetailsResult.getSku());
                distributionResult.setInboundBatch(distributionDetailsResult.getBatchCode());
                distributionResult.setUom(distributionDetailsResult.getGoodsUnit());
                distributionResult.setConsignee(distributionDetailsResult.getSellerCode());
                distributionResult.setArea(distributionDetailsResult.getLogisticsZoneName());
                distributionResult.setCompany(distributionDetailsResult.getSellSideCode());
                distributionResult.setQtyoriginal(distributionDetailsResult.getDistributionQuantity());
                distributionResult.setInputQty(distributionDetailsResult.getRealUnitPrice());
                distributionResult.setAttributes(distributionDetailsResult.getLogisticsZoneName());
                distributionResult.setInventoryStatus("AVAILABLE");
                distributionResults.add(distributionResult);
            }
        }
        result.setDistributionResults(distributionResults);
        results.add(result);
        return results;
    }
}
