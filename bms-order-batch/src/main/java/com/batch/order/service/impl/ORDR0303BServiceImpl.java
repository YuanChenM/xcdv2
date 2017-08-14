package com.batch.order.service.impl;

import com.batch.order.bean.entity.DistributionNotificationEntity;
import com.batch.order.bean.entity.DistributionNotificationHistoryEntity;
import com.batch.order.bean.result.ORDR0303BDistributionResult;
import com.batch.order.bean.result.ORDR0303BReceiverResult;
import com.batch.order.bean.result.ORDR0303BResult;
import com.batch.order.bean.result.OrderBatchEmailResult;
import com.batch.order.bean.template.ORDR0303BXmlTemplate;
import com.batch.order.dao.ORDR0303BDao;
import com.batch.order.service.ORDR0303BService;
import com.batch.order.util.FtpUtil;
import com.batch.order.util.client.BaseRestClientUtil;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.boot.plugin.configserver.ConfigServerPropertyLoad;
import com.framework.core.file.ftp.FtpUtils;
import com.framework.core.file.xml.jaxb.JaxbXmlWrite;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.NumberUtils;
import com.framework.redis.dao.BaseRedisDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liutao on 2017/1/4.
 */
@Service
public class ORDR0303BServiceImpl extends BaseServiceImpl implements ORDR0303BService {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ORDR0303BServiceImpl.class);

    @Autowired
    private ORDR0303BDao ordr0303BDao;

    @Autowired
    private BaseRedisDao baseRedisDao;

    @Autowired
    private BaseRestClientUtil baseRestClientUtil;

    @Override
    public BaseDao getBaseDao() {
        return ordr0303BDao;
    }

    @Override
    public void createDistributionNotification() {
        // 得到所有满足生成xml的配送通知单信息
        List<ORDR0303BResult> xmlResults = ordr0303BDao.getXmlList();
        if (CollectionUtils.isEmpty(xmlResults)) {
            return;
        }
        try{
            // createXml
            for (ORDR0303BResult xmlResult : xmlResults) {
                Integer disCount = ordr0303BDao.getDistributionCount(xmlResult);
                Integer recCount = ordr0303BDao.getReceiveCount(xmlResult);
                Boolean notCreateFlg = true;
                if (disCount == 0 || (disCount > 0 && recCount > 0)){
                    notCreateFlg = false;
                }
                if (xmlResult.getUseNetFlg()) {
                    if (!xmlResult.getPaymentStu().equals("003")) {
                        continue;
                    }
                } else if (notCreateFlg && !xmlResult.getPaymentStu().equals("003")) {
                    continue;
                }
                createXml(xmlResult);
            }
        } catch (Exception e){
            // 模板邮件内容
            List<OrderBatchEmailResult> emailResults = new ArrayList<>();
            OrderBatchEmailResult result = new OrderBatchEmailResult();
            result.setBatchNo("ORDR0303B");
            result.setErrorMessage(e.getMessage());
            emailResults.add(result);

            baseRestClientUtil.sendFailMail(emailResults);
            logger.debug(e.getMessage());
            throw e;
        }
    }

    /**
     * 生成xml
     *
     * @param result
     * @return
     */
    public void createXml(ORDR0303BResult result) {
        List<ORDR0303BResult> results = new ArrayList<>();
        ORDR0303BReceiverResult receiver = new ORDR0303BReceiverResult();
        BeanUtils.copyProperties(result, receiver);
        result.setReceiver(receiver);
        if (result.getReceiveAmount().compareTo(result.getOrderAmount()) < 0){
            result.setNeedPay("true");
        } else {
            result.setNeedPay("false");
        }
        // 获取配送单详细信息
        List<ORDR0303BDistributionResult> disDetails = ordr0303BDao.getDetailList(result);
        result.setDistributionResults(disDetails);
        results.add(result);
        // 生成上传xml
        ORDR0303BXmlTemplate xmlTemplate = new ORDR0303BXmlTemplate();
        xmlTemplate.setData(results);
        JaxbXmlWrite<ORDR0303BXmlTemplate> xmlWrite = new JaxbXmlWrite<>(xmlTemplate);
        InputStream inputStream = xmlWrite.createXml(ORDR0303BXmlTemplate.class);
        FtpUtils ftpUtils = FtpUtil.getFtpUtils();
        if (ftpUtils.upload(ConfigServerPropertyLoad.getProperty(FtpUtil.PATH), inputStream, "SO" + result.getOrderCode() + ".xml")) {
            logger.info("SO" + result.getOrderCode() + ".xml" + "文件上传成功");
            DistributionNotificationEntity entity = new DistributionNotificationEntity();
            entity.setDistributionNotificationId(result.getOrderId());
            entity.setDistributionNotificationStu("001");
            entity.setSendFlg(true);
            entity.setUpdTime(DateUtils.getCurrent());
            entity.setUpdId("ORDR0303");
            DistributionNotificationHistoryEntity disHistoryEntity = ordr0303BDao.findHistory(entity);
            disHistoryEntity.setHistoryId(baseRedisDao.getTablePrimaryKey("ordr_distribution_notification_history", 1));
            ordr0303BDao.saveHistory(disHistoryEntity);
            // 更新配送表 待发货
            ordr0303BDao.modifyDisStatus(entity);
        } else {
            logger.info("SO" + result.getOrderCode() + ".xml" + "文件上传失败");
        }
    }
}
