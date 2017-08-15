package com.bms.order.fms.rest;

import com.bms.order.fms.bean.FmsOrderParam;
import com.bms.order.fms.bean.FmsPushBean;
import com.bms.order.fms.bean.FmsUrlBean;
import com.bms.order.fms.common.FmsCommon;
import com.bms.order.fms.constant.MessageDef;
import com.bms.order.fms.constant.PushOrderType;
import com.bms.order.fms.utils.FmsUtil;
import com.framework.boot.base.BaseRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yuan_chen on 2017/4/18 0018.
 * <p>
 * OMS订单对FMS的推送接口控制台
 */
@RestController
@Api(value = "oms-order", description = "OMS订单对FMS的推送接口控制台", position = 1, tags = "OmsToFmsRestController")
public class OmsToFmsRestController extends BaseRestController {
    Logger logger = LoggerFactory.getLogger(OmsToFmsRestController.class);

    @Autowired
    private FmsCommon fmsCommon;

    //判断是否使用真实数据
    private FmsPushBean doPush(String pushOrderType, FmsOrderParam fmsOrderParam) {
        FmsPushBean fmsPushBean = new FmsPushBean();
        if (fmsOrderParam == null) {
            fmsPushBean.setResultMessage(MessageDef.ERROR_BAD_PARAM_MSG);
            return fmsPushBean;
        }
        FmsUrlBean fmsUrlBean = fmsOrderParam.getFmsUrlBean();
        fmsPushBean.setFmsUrlBean(fmsUrlBean);
        if (fmsUrlBean != null && fmsUrlBean.getPostJsonData() != null) {
            String xmlParam;
            xmlParam = FmsUtil.CreateFmsXmlParam(pushOrderType, fmsUrlBean.getPostJsonData());
            String result;
            result = fmsCommon.doPush(xmlParam, fmsPushBean);
            fmsPushBean.setResultMessage(result);
        }else{
            fmsPushBean = fmsCommon.pushOrderToFms(pushOrderType, fmsOrderParam);
        }
        return fmsPushBean;
    }

    @ApiOperation(value = "push买家订单", notes = "push买家订单", position = 1)
    @RequestMapping(value = "/omsToFms1/buyerOrder/push", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public FmsPushBean pushBuyerOrder(@RequestBody FmsOrderParam fmsOrderParam) {
        logger.debug("调用【" + PushOrderType.BUYER_ORDER + "】");
        return doPush(PushOrderType.BUYER_ORDER, fmsOrderParam);
    }

    @ApiOperation(value = "push买家取消订单", notes = "push买家取消订单", position = 2)
    @RequestMapping(value = "/omsToFms2/buyerCancelOrder/push", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public FmsPushBean pushBuyerCancelOrder(@RequestBody FmsOrderParam fmsOrderParam) {
        logger.debug("调用【" + PushOrderType.BUYER_ORDER_CANCEL + "】");
        return doPush(PushOrderType.BUYER_ORDER_CANCEL, fmsOrderParam);
    }

    @ApiOperation(value = "push买家退货订单", notes = "push买家退货订单", position = 3)
    @RequestMapping(value = "/omsToFms3/buyerReturnOrder/push", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public FmsPushBean pushBuyerReturnOrder(@RequestBody FmsOrderParam fmsOrderParam) {
        logger.debug("调用【" + PushOrderType.BUYER_ORDER_RETURN + "】");
        return doPush(PushOrderType.BUYER_ORDER_RETURN, fmsOrderParam);
    }

    @ApiOperation(value = "push买手合伙人囤货订单", notes = "push买手合伙人囤货订单", position = 4)
    @RequestMapping(value = "/omsToFms4/agentOrder/push", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public FmsPushBean pushAgentOrder(@RequestBody FmsOrderParam fmsOrderParam) {
        logger.debug("调用【" + PushOrderType.BUYER_AGENT_ORDER + "】");
        return doPush(PushOrderType.BUYER_AGENT_ORDER, fmsOrderParam);
    }

    @ApiOperation(value = "push买手合伙人囤货订单退货", notes = "push买手合伙人囤货订单退货", position = 5)
    @RequestMapping(value = "/omsToFms5/agentReturnOrder/push", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public FmsPushBean pushAgentReturnOrder(@RequestBody FmsOrderParam fmsOrderParam) {
        logger.debug("调用【" + PushOrderType.BUYER_AGENT_ORDER_RETURN + "】");
        return doPush(PushOrderType.BUYER_AGENT_ORDER_RETURN, fmsOrderParam);
    }

    @ApiOperation(value = "push沽货订单", notes = "push沽货订单", position = 6)
    @RequestMapping(value = "/omsToFms6/shortSellOrder/push", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public FmsPushBean pushShortSellOrder(@RequestBody FmsOrderParam fmsOrderParam) {
        logger.debug("调用【" + PushOrderType.SHORT_SELL_ORDER + "】");
        return doPush(PushOrderType.SHORT_SELL_ORDER, fmsOrderParam);
    }
}
