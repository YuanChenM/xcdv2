package com.bms.puch.fms.common;

import com.bms.constant.FmsUrlDef;
import com.bms.constant.ThirdPartSys;
import com.bms.puch.fms.bean.*;
import com.bms.puch.fms.constant.MessageDef;
import com.bms.puch.fms.constant.PushOrderType;
import com.bms.puch.fms.services.FmsAgentBidOrderService;
import com.bms.puch.fms.utils.FmsXmlUtil;
import com.bms.puch.fms.utils.RestClientUtil;
import com.framework.core.utils.StringUtils;
import com.log.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by yuan_chen on 2017/4/19 0019.
 * <p>
 * push到fms共通类
 */
@Component
public class FmsCommon {
    Logger logger = LoggerFactory.getLogger(FmsCommon.class);

    @Autowired
    private FmsAgentBidOrderService fmsAgentBidOrderService;

    public FmsCommon() {
    }

    public void pushAgentBidOrder(Long orderId){
        FmsOrderParam fmsOrderParam = new FmsOrderParam();
        fmsOrderParam.setPushOrderId(orderId);
        this.pushAgentBidOrder(PushOrderType.BUYER_AGENT_ORDER_BID, fmsOrderParam);
    }

    /**
     * 向fms推送根据条件从OMS数据库查询出的订单数据
     */
    public FmsPushBean pushAgentBidOrder(String pushOrderType, FmsOrderParam fmsOrderParam) {
        if (FmsUrlDef.getFmsPushFlg()) {
            FmsPushBean fmsPushBean = new FmsPushBean();
            fmsPushBean.setResultMessage(MessageDef.ERROR_ENV);
            return fmsPushBean;
        }
        FmsPushBean fmsPushBean = createFmsPushBean(fmsOrderParam);
        fmsPushBean.setPushType(pushOrderType);
        logger.debug("===OMS数据数据推送开始===");
        fmsPushBean = putAgentBidOrder(fmsPushBean, fmsOrderParam);
        if (StringUtils.isNotEmpty(fmsPushBean.getResultMessage())
                || !StringUtils.isEmpty(fmsOrderParam.getTestFlg())) {
            return fmsPushBean;
        }
        fmsPushBean = pushOrder(fmsPushBean);
        logger.debug("===OMS数据数据推送结束===");
        return fmsPushBean;
    }

    /**
     * 取得OMS竞价囤货订单推送信息
     */
    private FmsPushBean putAgentBidOrder(FmsPushBean fmsPushBean, FmsOrderParam fmsOrderParam) {
        logger.debug("===取得OMS竞价囤货订单推送信息===");
        //竞价囤货订单推送
        List<FmsAgentBidOrderBean> fmsAgentBidOrderBeans = fmsAgentBidOrderService.getAgentBidOrder(fmsOrderParam);
        if (fmsAgentBidOrderBeans != null && fmsAgentBidOrderBeans.size() > 0) {
            FmsRequestData fmsRequestData = FmsXmlUtil.CreateFmsRequestData(fmsAgentBidOrderBeans);
            fmsPushBean.setRequestData(fmsRequestData);
        } else {
            fmsPushBean.setResultMessage(MessageDef.ERROR_BAD_DATA_MSG);
        }
        return fmsPushBean;
    }

    /**
     * 推送订单信息
     */
    private FmsPushBean pushOrder(FmsPushBean fmsPushBean) {
        String postParam = FmsXmlUtil.CreateFmsXmlParam(fmsPushBean.getPushType(), fmsPushBean.getRequestData());
        String xmlResult = doPush(postParam, fmsPushBean);
        logger.debug("===FMS返回信息处理===");
        if (StringUtils.isEmpty(xmlResult)) {
            fmsPushBean.setResultMessage(MessageDef.ERROR_POST_FAIL);
            return fmsPushBean;
        } else {
            fmsPushBean.setResultMessage(xmlResult);
        }
        FmsResult fmsResult = FmsXmlUtil.CreateFmsResult(xmlResult);
        fmsPushBean.setFmsResult(fmsResult);
        //将处理结果写入日志
        if (fmsResult != null) {
            if (StringUtils.equals(fmsResult.getReturnCode(), "S")) {
                LogUtil.doSuccessLog(fmsPushBean.getFmsUrlBean().getPostUrl(), postParam, xmlResult, ThirdPartSys.FMS);
            } else if (StringUtils.equals(fmsResult.getReturnCode(), "E")) {
                LogUtil.doFailLog(fmsPushBean.getFmsUrlBean().getPostUrl(), postParam, xmlResult, ThirdPartSys.FMS);
            } else {
                LogUtil.doExceptionLog(fmsPushBean.getFmsUrlBean().getPostUrl(), postParam, xmlResult, ThirdPartSys.FMS);
            }
        } else {
            LogUtil.doExceptionLog(fmsPushBean.getFmsUrlBean().getPostUrl(), postParam, xmlResult, ThirdPartSys.FMS);
        }
        logger.debug("===FMS返回信息处理===");
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
     * 向fms推送传入参数中的数据
     */
    public String doPush(String xmlParam, FmsPushBean fmsPushBean) {
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
        fmsUrlBean.setPostUrl(FmsUrlDef.postUrl);
        fmsUrlBean.setPostHost(FmsUrlDef.postHost);
        fmsUrlBean.setFmsUser(FmsUrlDef.fmsUser);
        fmsUrlBean.setFmsPsd(FmsUrlDef.fmsPsd);
        fmsPushBean.setFmsUrlBean(fmsUrlBean);
        result = RestClientUtil.post(xmlParam, fmsUrlBean);
        logger.debug("===参数中的数据推送结束===");
        return result;
    }
}
