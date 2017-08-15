package com.bms.order.fms.common;

import com.alibaba.fastjson.JSON;
import com.bms.constant.FmsUrlDef;
import com.bms.constant.ThirdPartSys;
import com.bms.order.fms.bean.*;
import com.bms.order.fms.constant.MessageDef;
import com.bms.order.fms.constant.PushOrderType;
import com.bms.order.fms.services.*;
import com.bms.order.fms.utils.FmsUtil;
import com.bms.order.fms.utils.RestClientUtil;
import com.bms.template.AbstractTemplate;
import com.bms.template.TemplateFactory;
import com.framework.core.utils.StringUtils;
import com.log.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by yuan_chen on 2017/4/19 0019.
 * <p>
 * push到fms共通abstract类
 */
public abstract class FmsCommonAbstract {
    Logger logger = LoggerFactory.getLogger(FmsCommonAbstract.class);

    @Autowired
    private FmsBuyerOrderService fmsBuyerOrderService;
    @Autowired
    private FmsBuyerCancelOrderService fmsBuyerCancelOrderService;
    @Autowired
    private FmsBuyerReturnOrderService fmsBuyerReturnOrderService;
    @Autowired
    private FmsAgentOrderService fmsAgentOrderService;
    @Autowired
    private FmsAgentReturnOrderService fmsAgentReturnOrderService;
    @Autowired
    private FmsShortSellOrderService fmsShortSellOrderService;
    @Autowired
    private TemplateFactory templateFactory;

    /**
     * 取得OMS买家订单信息
     */
    private FmsPushBean createBuyerOrder(FmsPushBean fmsPushBean, FmsOrderParam param) {
        logger.debug("===取得OMS买家订单信息===");
        List<FmsBuyerOrderBean> fmsBuyerOrderBeans = fmsBuyerOrderService.getBuyerOrder(param);
        if (fmsBuyerOrderBeans != null && fmsBuyerOrderBeans.size() > 0) {
            FmsRequestData fmsRequestData = FmsUtil.CreateFmsRequestData(fmsBuyerOrderBeans);
            fmsPushBean.setRequestData(fmsRequestData);
        }
        return fmsPushBean;
    }

    /**
     * 取得OMS买家订单取消信息
     */
    private FmsPushBean createBuyerCancelOrder(FmsPushBean fmsPushBean, FmsOrderParam param) {
        logger.debug("===取得OMS买家订单取消信息===");
        List<FmsBuyerCancelOrderBean> fmsBuyerCancelOrderBeans = fmsBuyerCancelOrderService.getBuyerCancelOrder(param);
        if (fmsBuyerCancelOrderBeans != null && fmsBuyerCancelOrderBeans.size() > 0) {
            FmsRequestData fmsRequestData = FmsUtil.CreateFmsRequestData(fmsBuyerCancelOrderBeans);
            fmsPushBean.setRequestData(fmsRequestData);
        }
        return fmsPushBean;
    }

    /**
     * 取得OMS买家订单退货信息
     */
    private FmsPushBean createBuyerReturnOrder(FmsPushBean fmsPushBean, FmsOrderParam param) {
        logger.debug("===取得OMS买家订单退货信息===");
        List<FmsBuyerReturnOrderBean> fmsBuyerReturnOrderBeans = fmsBuyerReturnOrderService.getBuyerReturnOrder(param);
        if (fmsBuyerReturnOrderBeans != null && fmsBuyerReturnOrderBeans.size() > 0) {
            FmsRequestData fmsRequestData = FmsUtil.CreateFmsRequestData(fmsBuyerReturnOrderBeans);
            fmsPushBean.setRequestData(fmsRequestData);
        }
        return fmsPushBean;
    }

    /**
     * 取得OMS买手合伙人囤货订单信息
     */
    private FmsPushBean createAgentOrder(FmsPushBean fmsPushBean, FmsOrderParam param) {
        logger.debug("===取得OMS买手合伙人囤货订单信息===");
        List<FmsAgentOrderBean> fmsAgentOrderBeans = fmsAgentOrderService.getAgentOrder(param);
        if (fmsAgentOrderBeans != null && fmsAgentOrderBeans.size() > 0) {
            FmsRequestData fmsRequestData = FmsUtil.CreateFmsRequestData(fmsAgentOrderBeans);
            fmsPushBean.setRequestData(fmsRequestData);
        }
        return fmsPushBean;
    }

    /**
     * 取得OMS买手合伙人囤货订单退货信息
     */
    private FmsPushBean createAgentReturnOrder(FmsPushBean fmsPushBean, FmsOrderParam param) {
        logger.debug("===取得OMS买手合伙人囤货订单退货信息===");
        List<FmsAgentReturnOrderBean> fmsAgentReturnOrderBeans = fmsAgentReturnOrderService.getAgentReturnOrder(param);
        if (fmsAgentReturnOrderBeans != null && fmsAgentReturnOrderBeans.size() > 0) {
            FmsRequestData fmsRequestData = FmsUtil.CreateFmsRequestData(fmsAgentReturnOrderBeans);
            fmsPushBean.setRequestData(fmsRequestData);
        }
        return fmsPushBean;
    }

    /**
     * 取得OMS沽货订单信息
     */
    private FmsPushBean createShortSellOrder(FmsPushBean fmsPushBean, FmsOrderParam param) {
        logger.debug("===取得OMS沽货订单信息===");
        List<FmsShortSellOrderBean> fmsShortSellOrderBeans = fmsShortSellOrderService.getShortSellOrder(param);
        if (fmsShortSellOrderBeans != null && fmsShortSellOrderBeans.size() > 0) {
            FmsRequestData fmsRequestData = FmsUtil.CreateFmsRequestData(fmsShortSellOrderBeans);
            fmsPushBean.setRequestData(fmsRequestData);
        }
        return fmsPushBean;
    }

    /**
     * 创建FmsPushBean
     */
    private FmsPushBean createFmsPushBean(FmsOrderParam fmsOrderParam) {
        FmsPushBean fmsPushBean = new FmsPushBean();
        if (fmsOrderParam == null) {
            fmsPushBean.setResultMessage(MessageDef.ERROR_BAD_PARAM_MSG);
            return fmsPushBean;
        }
        fmsPushBean.setFmsUrlBean(fmsOrderParam.getFmsUrlBean());
        if (fmsOrderParam.getPushOrderId() == null
                && StringUtils.isEmpty(fmsOrderParam.getBackNo())
                && StringUtils.isEmpty(fmsOrderParam.getPushOrderCode())) {
            fmsPushBean.setResultMessage(MessageDef.ERROR_BAD_PARAM_MSG);
            return fmsPushBean;
        }
        return fmsPushBean;
    }

    /**
     * 创建订单信息
     */
    private FmsPushBean putOrder(FmsPushBean fmsPushBean, FmsOrderParam fmsOrderParam) {
        if (StringUtils.equals(fmsPushBean.getPushType(), PushOrderType.BUYER_ORDER)) {
            //买家订单推送
            fmsPushBean = createBuyerOrder(fmsPushBean, fmsOrderParam);
        } else if (StringUtils.equals(fmsPushBean.getPushType(), PushOrderType.BUYER_ORDER_CANCEL)) {
            //买家取消订单推送
            fmsPushBean = createBuyerCancelOrder(fmsPushBean, fmsOrderParam);
        } else if (StringUtils.equals(fmsPushBean.getPushType(), PushOrderType.BUYER_ORDER_RETURN)) {
            //买家退货订单推送
            fmsPushBean = createBuyerReturnOrder(fmsPushBean, fmsOrderParam);
        } else if (StringUtils.equals(fmsPushBean.getPushType(), PushOrderType.BUYER_AGENT_ORDER)) {
            //买手囤货订单推送
            fmsPushBean = createAgentOrder(fmsPushBean, fmsOrderParam);
        } else if (StringUtils.equals(fmsPushBean.getPushType(), PushOrderType.BUYER_AGENT_ORDER_RETURN)) {
            //买手囤货退货订单推送
            fmsPushBean = createAgentReturnOrder(fmsPushBean, fmsOrderParam);
        } else if (StringUtils.equals(fmsPushBean.getPushType(), PushOrderType.SHORT_SELL_ORDER)) {
            //估货订单推送
            fmsPushBean = createShortSellOrder(fmsPushBean, fmsOrderParam);
        } else {
            fmsPushBean.setResultMessage(MessageDef.ERROR_BAD_DATA_MSG);
        }
        if (fmsPushBean.getRequestData() == null) {
            fmsPushBean.setResultMessage(MessageDef.ERROR_BAD_DATA_MSG);
        }
        return fmsPushBean;
    }

    /**
     * 推送订单信息
     */
    private FmsPushBean pushOrder(FmsPushBean fmsPushBean) {
        String postParam = FmsUtil.CreateFmsXmlParam(fmsPushBean.getPushType(), fmsPushBean.getRequestData());
        String xmlResult = doPush(postParam, fmsPushBean);

        logger.debug("===FMS返回信息处理===");
        if (StringUtils.isEmpty(xmlResult)) {
            fmsPushBean.setResultMessage(MessageDef.ERROR_POST_FAIL);
            return fmsPushBean;
        } else {
            fmsPushBean.setResultMessage(xmlResult);
        }

        FmsResult fmsResult = FmsUtil.CreateFmsResult(xmlResult);
        fmsPushBean.setFmsResult(fmsResult);
        //将处理结果写入日志
        if (fmsResult != null) {
            if (StringUtils.equals(fmsResult.getReturnCode(), "S")) {
                LogUtil.doSuccessLog(fmsPushBean.getFmsUrlBean().getPostUrl(), postParam, xmlResult, ThirdPartSys.FMS);
            } else {
                LogUtil.doFailLog(fmsPushBean.getFmsUrlBean().getPostUrl(), postParam, xmlResult, ThirdPartSys.FMS);
            }
        } else {
            LogUtil.doExceptionLog(fmsPushBean.getFmsUrlBean().getPostUrl(), postParam, xmlResult, ThirdPartSys.FMS);
        }
        logger.debug("===FMS返回信息处理===");
        return fmsPushBean;
    }

    /**
     * 向fms推送根据条件从OMS数据库查询出的订单数据
     */
    protected FmsPushBean pushOrderToFms(String pushOrderType, FmsOrderParam fmsOrderParam) {
        if (FmsUrlDef.getFmsPushFlg()) {
            FmsPushBean fmsPushBean = new FmsPushBean();
            fmsPushBean.setResultMessage(MessageDef.ERROR_ENV);
            return fmsPushBean;
        }
        FmsPushBean fmsPushBean = createFmsPushBean(fmsOrderParam);
        if (!StringUtils.isEmpty(fmsPushBean.getResultMessage())) {
            return fmsPushBean;
        }
        fmsPushBean.setPushType(pushOrderType);

        logger.debug("===获取OMS数据开始===");
        fmsPushBean = putOrder(fmsPushBean, fmsOrderParam);
        if (!StringUtils.isEmpty(fmsPushBean.getResultMessage())
                || !StringUtils.isEmpty(fmsOrderParam.getTestFlg())) {
            return fmsPushBean;
        }
        logger.debug("===获取OMS数据开始结束===");

        if(StringUtils.equals(fmsOrderParam.getAsyncFlg(), "async")){
            logger.debug("===OMS数据数据异步推送开始===");
            asyncPush(fmsPushBean);
            fmsPushBean.setResultMessage(MessageDef.INFO_ASYNC);
            logger.debug("===OMS数据数据异步推送结束===");
        }else {
            logger.debug("===OMS数据数据推送开始===");
            fmsPushBean = pushOrder(fmsPushBean);
            logger.debug("===OMS数据数据推送结束===");
        }
        return fmsPushBean;
    }

    /**
     * 向fms推送传入参数中的数据
     */
    protected String doPush(String xmlParam, FmsPushBean fmsPushBean) {
        logger.debug("===参数中的数据推送开始===");
        String result;
        if (fmsPushBean.getFmsUrlBean() != null) {
            if (!StringUtils.isEmpty(fmsPushBean.getFmsUrlBean().getPostUrl())
                    && !StringUtils.isEmpty(fmsPushBean.getFmsUrlBean().getPostHost())
                    && !StringUtils.isEmpty(fmsPushBean.getFmsUrlBean().getFmsUser())
                    && !StringUtils.isEmpty(fmsPushBean.getFmsUrlBean().getFmsPsd())) {
                logger.debug("使用参数中的url进行数据推送");
                result = RestClientUtil.post(xmlParam, fmsPushBean.getFmsUrlBean());
                logger.debug("===数据推送结束===");
                return result;
            }
        }
        logger.debug("使用默认配置中的url进行数据推送");
        FmsUrlBean fmsUrlBean = new FmsUrlBean();
        fmsUrlBean.setPostUrl(FmsUrlDef.getPostUrl());
        fmsUrlBean.setPostHost(FmsUrlDef.getPostHost());
        fmsUrlBean.setFmsUser(FmsUrlDef.getFmsUser());
        fmsUrlBean.setFmsPsd(FmsUrlDef.getFmsPsd());
        fmsPushBean.setFmsUrlBean(fmsUrlBean);
        result = RestClientUtil.post(xmlParam, fmsPushBean.getFmsUrlBean());
        logger.debug("===参数中的数据推送结束===");
        return result;
    }

    protected void writeLog(FmsPushBean fmsPushBean){
        logger.debug("==============================");
        logger.debug("推送结束，推送信息如下：");
        String pushResult = JSON.toJSONString(fmsPushBean);
        logger.debug(pushResult);
        logger.debug("==============================");
    }

    private void asyncPush(FmsPushBean fmsPushBean) {
        String url = FmsUrlDef.getPostUrl();
        AbstractTemplate fmsTemplate = this.templateFactory.getTemplete(ThirdPartSys.FMS.name());
        String postParam = FmsUtil.CreateFmsXmlParam(fmsPushBean.getPushType(), fmsPushBean.getRequestData());
        fmsTemplate.asyncPost(url, postParam);
        writeLog(fmsPushBean);
    }
}
