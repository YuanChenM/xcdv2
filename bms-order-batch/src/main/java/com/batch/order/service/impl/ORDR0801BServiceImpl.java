package com.batch.order.service.impl;

import com.batch.order.bean.RestRequest;
import com.batch.order.bean.entity.BuyerReturnHistoryEntity;
import com.batch.order.bean.param.MailSendRsParam;
import com.batch.order.bean.result.ORDR0801BDetailResult;
import com.batch.order.bean.result.ORDR0801BResult;
import com.batch.order.bean.result.OrderBatchEmailResult;
import com.batch.order.bean.template.ORDR0801BXmlTemplate;
import com.batch.order.constant.OrderConstant;
import com.batch.order.constant.ordr.GoodsUnit;
import com.batch.order.dao.ORDR0801BDao;
import com.batch.order.service.ORDR0801BService;
import com.batch.order.util.FtpUtil;
import com.batch.order.util.client.BaseRestClientUtil;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.boot.plugin.configserver.ConfigServerPropertyLoad;
import com.framework.core.file.ftp.FtpUtils;
import com.framework.core.file.xml.jaxb.JaxbXmlWrite;
import com.framework.core.utils.CollectionUtils;
import com.framework.redis.dao.BaseRedisDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liutao on 2017/1/4.
 */
@Service
public class ORDR0801BServiceImpl extends BaseServiceImpl implements ORDR0801BService{

    private static final Logger logger = LoggerFactory.getLogger(ORDR0801BServiceImpl.class);

    @Override
    public BaseDao getBaseDao() {
        return ordr0801BDao;
    }

    @Autowired
    private ORDR0801BDao ordr0801BDao;

    @Autowired
    private BaseRedisDao baseRedisDao;

    @Autowired
    private BaseRestClientUtil baseRestClientUtil;

    @Override
    public void createReturnXml() {
        List<ORDR0801BResult> results = ordr0801BDao.getReturnResults();

        if (CollectionUtils.isEmpty(results)) {
            return;
        }
        try {
            for (ORDR0801BResult result : results) {
                List<ORDR0801BResult> resultList = new ArrayList<>();
                List<ORDR0801BDetailResult> details = ordr0801BDao.getReturnDetailResults(result);
                if (!CollectionUtils.isEmpty(details)){
                    for (ORDR0801BDetailResult detail : details){
                        GoodsUnit goodsUnit = GoodsUnit.getInstance(detail.getGoodsUnit());
                        if (null != goodsUnit){
                            detail.setGoodsUnit(goodsUnit.getName());
                        }
                    }
                }
                result.setDetails(details);
                resultList.add(result);
                ORDR0801BXmlTemplate xmlTemplate = new ORDR0801BXmlTemplate();
                xmlTemplate.setData(resultList);
                JaxbXmlWrite<ORDR0801BXmlTemplate> xmlWrite = new JaxbXmlWrite<>(xmlTemplate);
                InputStream inputStream = xmlWrite.createXml(ORDR0801BXmlTemplate.class);
                FtpUtils ftpUtils = FtpUtil.getFtpUtils();
                ftpUtils.upload(ConfigServerPropertyLoad.getProperty(FtpUtil.PATH), inputStream,"RE" + result.getReturnCode() + ".xml");
                BuyerReturnHistoryEntity buyerReturnHistoryEntity = ordr0801BDao.getReturnInfo(result);
                buyerReturnHistoryEntity.setHistoryId(baseRedisDao.getTablePrimaryKey("ORDR_BUYER_RETURN_HISTORY",1));
                ordr0801BDao.saveHistory(buyerReturnHistoryEntity);
                ordr0801BDao.modifyReturnStu(result);
            }
        } catch (Exception e){
            // 模板邮件内容
            List<OrderBatchEmailResult> emailResults = new ArrayList<>();
            OrderBatchEmailResult result = new OrderBatchEmailResult();
            result.setBatchNo("ORDR0801B");
            result.setErrorMessage(e.getMessage());
            emailResults.add(result);
            baseRestClientUtil.sendFailMail(emailResults);

            logger.debug(e.getMessage());
            throw e;
        }
    }
}
