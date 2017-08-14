package com.bms.fms.notice;

import com.bms.fms.bean.NoticeParam;
import com.bms.fms.constant.NoticeType;
import org.springframework.stereotype.Service;

/**
 * Created by yuan_chen on 2017/5/10 0010.
 *
 * 通知FMS系统共通类
 */
@Service
public class FmsNotice extends AbstractNotice{

    /**
     * 通知买家信息变化
     * @param buyerKey 买家主体对象主键
     */
    public void sendBuyer(String buyerKey){
        NoticeParam param = new NoticeParam();
        param.setNoticeKey(buyerKey);
        param.setNoticeType(NoticeType.BUYER);
        super.push(param);
    }

    /**
     * 通知买手信息变化
     * @param agentKey 买手主体对象主键
     */
    public void sendAgent(String agentKey){
        NoticeParam param = new NoticeParam();
        param.setNoticeKey(agentKey);
        param.setNoticeType(NoticeType.AGENT);
        super.push(param);
    }

    /**
     * 通知合伙人信息变化
     * @param partnerKey 合伙人主体对象主键
     */
    public void sendPartner(String partnerKey){
        NoticeParam param = new NoticeParam();
        param.setNoticeKey(partnerKey);
        param.setNoticeType(NoticeType.PARTNER);
        super.push(param);
    }

    /**
     * 通知产品信息变化
     * @param productKey 产品主体对象主键
     */
    public void sendProduct(String productKey){
        NoticeParam param = new NoticeParam();
        param.setNoticeKey(productKey);
        param.setNoticeType(NoticeType.PRODUCT);
        super.push(param);
    }

    /**
     * 通知商品信息变化
     * @param commodityKey 商品主体对象主键
     */
    public void sendCommodity(String commodityKey){
        NoticeParam param = new NoticeParam();
        param.setNoticeKey(commodityKey);
        param.setNoticeType(NoticeType.COMMODITY);
        super.push(param);
    }

    /**
     * 通知商品信息变化
     * @param skuKey 商品主体对象主键
     */
    public void sendSku(String skuKey){
        NoticeParam param = new NoticeParam();
        param.setNoticeKey(skuKey);
        param.setNoticeType(NoticeType.SKU);
        super.push(param);
    }
}
