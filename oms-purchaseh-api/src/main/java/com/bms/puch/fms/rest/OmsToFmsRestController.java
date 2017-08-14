package com.bms.puch.fms.rest;

import com.bms.puch.fms.bean.FmsOrderParam;
import com.bms.puch.fms.bean.FmsPushBean;
import com.bms.puch.fms.bean.FmsUrlBean;
import com.bms.puch.fms.common.FmsCommon;
import com.bms.puch.fms.constant.MessageDef;
import com.bms.puch.fms.constant.PushOrderType;
import com.bms.puch.fms.utils.FmsXmlUtil;
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
@Api(value = "oms-puch", description = "OMS订单对FMS的推送接口控制台", position = 1, tags = "OmsToFmsRestController")
public class OmsToFmsRestController extends BaseRestController {
    Logger logger = LoggerFactory.getLogger(OmsToFmsRestController.class);

    @Autowired
    private FmsCommon fmsCommon;

    @ApiOperation(value = "6.push买手合伙人竞价囤货订单", notes = "push买手合伙人竞价囤货订单", position = 6)
    @RequestMapping(value = "/omsToFms/agentBidOrder/push", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public FmsPushBean pushAgentBidOrder(@RequestBody FmsOrderParam fmsOrderParam) {
        logger.debug("调用【" + PushOrderType.BUYER_AGENT_ORDER_BID + "】");
        FmsPushBean fmsPushBean = new FmsPushBean();
        String pushOrderType = PushOrderType.BUYER_AGENT_ORDER_BID;
        if (fmsOrderParam == null) {
            fmsPushBean.setResultMessage(MessageDef.ERROR_BAD_PARAM_MSG);
            return fmsPushBean;
        }
        FmsUrlBean fmsUrlBean = fmsOrderParam.getFmsUrlBean();
        fmsPushBean.setFmsUrlBean(fmsUrlBean);
        String result;
        if (fmsUrlBean != null && fmsUrlBean.getPostJsonData() != null) {
            String xmlParam;
            xmlParam = FmsXmlUtil.CreateFmsXmlParam(pushOrderType, fmsUrlBean.getPostJsonData());
            result = fmsCommon.doPush(xmlParam, fmsPushBean);
            fmsPushBean.setResultMessage(result);
        } else {
            fmsPushBean = fmsCommon.pushAgentBidOrder(pushOrderType, fmsOrderParam);
        }
        return fmsPushBean;
    }

}
