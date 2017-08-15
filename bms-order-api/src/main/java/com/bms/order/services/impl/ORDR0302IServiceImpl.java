package com.bms.order.services.impl;

import com.bms.order.archive.impl.*;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.param.ORDR0302IBeanParam;
import com.bms.order.bean.result.ORDR0302IXMLResult;
import com.bms.order.bean.template.ORDR0302IXmlTemplate;
import com.bms.order.constant.enumeration.BuyerBatchOrderStu;
import com.bms.order.constant.enumeration.DistributionNotificationStu;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.*;
import com.bms.order.services.ORDR0302IService;
import com.bms.order.util.FtpUtil;
import com.framework.boot.plugin.configserver.ConfigServerPropertyLoad;
import com.framework.core.file.ftp.FtpUtils;
import com.framework.core.file.xml.jaxb.JaxbXmlWrite;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 配送通知单取消接口Service
 *
 * @author li_huiqian
 */
@Service
public class ORDR0302IServiceImpl implements ORDR0302IService {

    @Autowired
    private BaseRedisDao redisDao;

    @Autowired
    private BuyerBatchOrderDao buyerBatchOrderDao;

    @Autowired
    private BuyerBatchOrderAttachedDao buyerBatchOrderAttachedDao;

    @Autowired
    private BuyerForcastDeliverDetailDao buyerForcastDeliverDetailDao;

    @Autowired
    private BuyerForcastDeliverDetailAttachedDao buyerForcastDeliverDetailAttachedDao;

    @Autowired
    private DistributionNotificationDao distributionNotificationDao;

    @Autowired
    private DistributionNotificationDetailDao distributionNotificationDetailDao;

    @Autowired
    private DistributionCancelNotificationDao distributionCancelNotificationDao;


    /**
     * 平台订单人员对未交付的配送单进行取消发货操作
     *
     * @param operator 操作者
     * @param param    ORDR0302IBeanParam
     */
    @Override
    public void execute(Operator operator, ORDR0302IBeanParam param) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();
        blackboard.setOperator(operator);
        map.put("param", param);
        map.put("blackboard", blackboard);
        pre(map);
        process(map);
        post(map);
    }

    /**
     * 准备
     *
     * @param map HashMap
     */
    private void pre(HashMap<String, Object> map) {
        // 获取参数
        @SuppressWarnings("unused")
        ORDR0302IBeanParam param = (ORDR0302IBeanParam) map.get("param");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 设置DAO
        blackboard.setBaseRedisDao(redisDao);
        blackboard.putBaseDao(distributionNotificationDao);
        blackboard.putBaseDao(distributionCancelNotificationDao);
        blackboard.putBaseDao(buyerBatchOrderDao);
        blackboard.putBaseDao(buyerBatchOrderAttachedDao);
        blackboard.putBaseDao(buyerForcastDeliverDetailDao);
        blackboard.putBaseDao(buyerForcastDeliverDetailAttachedDao);
        blackboard.putBaseDao(distributionNotificationDetailDao);

        //操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);
        // 获取角色-后台
        getBackground(operator);

        DistributionNotification distributionNotification = param.generateDistributionNotification();
        distributionNotification.setBlackboard(blackboard);
        DistributionCancelNotification distributionCancelNotification = param.generateDistributionCancelNotification();
        distributionCancelNotification.setBlackboard(blackboard);
        map.put("distributionNotification", distributionNotification);
        map.put("distributionCancelNotification", distributionCancelNotification);
    }

    /**
     * 执行
     *
     * @param map HashMap
     */
    private void process(HashMap<String, Object> map) {
        // 获取参数
        DistributionNotification distributionNotification = (DistributionNotification) map.get("distributionNotification");
        DistributionCancelNotification distributionCancelNotification = (DistributionCancelNotification) map.get("distributionCancelNotification");
        distributionCancelNotificate(distributionNotification, distributionCancelNotification);
    }

    /**
     * 收尾
     *
     * @param map HashMap
     */
    private void post(HashMap<String, Object> map) {
        // 获取参数

        // 返回参数

    }


    private void distributionCancelNotificate(DistributionNotification distributionNotification,
                                              DistributionCancelNotification distributionCancelNotification) {
        distributionNotification.complete(false);
        // 判断配送通知单是否存在
        if (!distributionNotification.isDataSynced()) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E030201, distributionNotification.getEntity().getDistributionNotificationId().toString());
        }
        String status = distributionNotification.getEntity().getDistributionNotificationStu();
        // 判断配送通知单是否已经被取消
        if (status.equals(DistributionNotificationStu.CANCEL.getCode())) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E030202 , distributionNotification.getEntity().getDistributionNotificationId().toString());
        }
        // 判断配送通知单是否可以取消
        if (!status.equals(DistributionNotificationStu.TO_DISTRIBUTION.getCode())  && !status.equals(DistributionNotificationStu.WAIT_FOR_WAREHOUSE.getCode())
                && !status.equals(DistributionNotificationStu.WAIT_FOR_WMS.getCode())) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E030204, distributionNotification.getEntity().getDistributionNotificationId().toString());
        }
        String targetStu = DistributionNotificationStu.IN_CANCEL.getCode();
        // 判断配送通知单状态为待发货
        if (status.equals(DistributionNotificationStu.TO_DISTRIBUTION.getCode())) {
            DistributionCancelNotification cancel = DistributionCancelNotification.build(distributionCancelNotification.getBlackboard()).forComplete(distributionNotification);
            cancel.complete(false);
            // 没有生成配送取消通知单
            if (!cancel.isDataSynced()) {
                // xml对象数据组装
                ORDR0302IXMLResult ixmlResult = new ORDR0302IXMLResult();
                distributionCancelNotification.link(distributionNotification);
                distributionCancelNotification.getEntity().setDistributionNotificationCode(distributionNotification.getEntity().getDistributionNotificationCode());
                distributionCancelNotification.create();
                ixmlResult.setDistributionNotificationId(distributionCancelNotification.getEntity().getDistributionNotificationId());
                ixmlResult.setOrderId(distributionNotification.getEntity().getBuyerOrderId());
                ixmlResult.setCancelPersonId(distributionCancelNotification.getEntity().getCancelPersonId());
                ixmlResult.setCancelPersonName(distributionCancelNotification.getEntity().getCancelPersonName());
                ixmlResult.setCancelDatetime(DateUtils.formatDateTime(distributionCancelNotification.getEntity().getCancelDatetime()));
                ixmlResult.setRemark(distributionCancelNotification.getEntity().getRemark());
                ixmlResult.setCancelReason(distributionCancelNotification.getEntity().getCancelReason());
                ixmlResult.setWhCode(distributionNotification.getEntity().getWhCode());
                ixmlResult.setWhName(distributionNotification.getEntity().getWhName());

                List<ORDR0302IXMLResult> results = new ArrayList<>();
                results.add(ixmlResult);
                ORDR0302IXmlTemplate xmlTemplate = new ORDR0302IXmlTemplate();
                xmlTemplate.setData(results);
                JaxbXmlWrite<ORDR0302IXmlTemplate> xmlWrite = new JaxbXmlWrite<>(xmlTemplate);
                InputStream inputStream = xmlWrite.createXml(ORDR0302IXmlTemplate.class);
                FtpUtils ftpUtils = FtpUtil.getFtpUtils();
                ftpUtils.upload(ConfigServerPropertyLoad.getProperty(FtpUtil.PATH), inputStream, "OC" + distributionNotification.getEntity().getDistributionNotificationCode() + ".xml");
            } else {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E030203, cancel.getEntity().getDistributionNotificationId().toString());
            }
        } else {
            targetStu = DistributionNotificationStu.CANCEL.getCode();
            modifyBatchOrderStu(distributionNotification);
        }
        // 更新配送通知单状态为取消中
        distributionNotification.getEntity().setDistributionNotificationStu(targetStu);
        distributionNotification.modify();
    }

    /**
     * 更新分批订单状态，可以再次生成配送数据
     *
     * @param distributionNotification
     * @return
     */
    private void modifyBatchOrderStu(DistributionNotification distributionNotification) {
        Map<Long,BuyerBatchOrder> batchOrderMap = new HashMap<>();
        if (CollectionUtils.isNotEmpty(distributionNotification.getDistributionNotificationDetails())){
            for (DistributionNotificationDetail detail : distributionNotification.getDistributionNotificationDetails()){
                BuyerBatchOrder buyerBatchOrder = detail.getBuyerForcastDeliverDetail().getBuyerBatchOrder();
                batchOrderMap.put(buyerBatchOrder.getEntity().getBuyerBatchOrderId(),buyerBatchOrder);
            }
        }
        if (CollectionUtils.isNotEmpty(batchOrderMap.values())){
            for (BuyerBatchOrder buyerBatchOrder : batchOrderMap.values()) {
                if (BuyerBatchOrderStu.WAIT_SEND.getCode().equals(buyerBatchOrder.getEntity().getBuyerBatchOrderStu())) {
                    buyerBatchOrder.getEntity().setBuyerBatchOrderStu(BuyerBatchOrderStu.CONFIRMED.getCode());
                    buyerBatchOrder.modify();
                }
            }
        }
    }

    /**
     * 获取 角色-后台（平台订单人员）
     *
     * @param operator
     * @return
     */
    private void getBackground(Operator operator) {
        Assert.notNull(operator);
        if (operator.isStaff()) {

        } else if (operator.isOrderSystem()) {

        } else {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E030205);
        }
    }
}
