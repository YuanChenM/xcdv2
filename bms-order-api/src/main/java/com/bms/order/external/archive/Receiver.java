package com.bms.order.external.archive;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;

import com.alibaba.fastjson.TypeReference;
import com.bms.order.constant.UrlConst;
import com.bms.order.external.bean.entity.ReceiverEntity;
import com.bms.order.external.bean.param.BYIM0113IRestParam;
import com.bms.order.external.bean.result.BYIM0113IRestResult;
import com.framework.base.rest.result.BaseRestPaginationResult;

/**
 * 收货人
 * 
 * @author li_huiqian
 *
 */
public class Receiver extends AbstractExternalArchive {

    /**
     * 收货人Entity
     */
    private ReceiverEntity entity;

    /**
     * 获取收货人Entity
     * 
     * @return
     */
    public ReceiverEntity getEntity() {
        return this.entity;
    }

    /**
     * 买家
     */
    private Buyer buyer;

    /**
     * 获取买家
     * 
     * @return
     */
    public Buyer getBuyer() {
        return buyer;
    }

    private Receiver() {
    }

    /**
     * 通过买家查询收货人信息
     * 
     * @return
     */
    public static List<Receiver> findByBuyer(Buyer buyer) {
        Assert.notNull(buyer);
        Assert.isTrue(buyer.isDataSynced());
        Assert.notNull(buyer.getEntity());
        Assert.hasText(buyer.getEntity().getBuyerId());

        // 获取URL
        String url = UrlConst.API_BYIM_URL + UrlConst.ACTION_BYIM0113I;

        // 构造入参
        BYIM0113IRestParam param = new BYIM0113IRestParam();
        param.setBuyerId(buyer.getEntity().getBuyerId());

        // 返回值类型
        TypeReference<BaseRestPaginationResult<BYIM0113IRestResult>> typeReference = new TypeReference<BaseRestPaginationResult<BYIM0113IRestResult>>() {
        };

        // 调用接口（使用关联对象的rest client）
        BaseRestPaginationResult<BYIM0113IRestResult> paginationResult = buyer.getRestClient().post(url, param,
                typeReference);

        // 判断检索结果
        // 不用判断

        if (paginationResult.getTotal() == 0)
            return null;

        // 获取收货人信息
        List<Receiver> receivers = new ArrayList<>();
        for (int i = 0; i < paginationResult.getTotal(); i++) {
            BYIM0113IRestResult result = paginationResult.getData().get(i);
            Receiver receiver = new Receiver();
            ReceiverEntity entity = new ReceiverEntity();
            entity.setReceiverProvince(result.getProvinceName());
            entity.setReceiverCity(result.getCityName());
            entity.setReceiverDistrict(result.getDistrictName());
            entity.setReceiverAddress(result.getDeliveryAddr());
            entity.setReceiverAssistAddress(result.getReferenceAddr());
            entity.setReceiverName(result.getReceivePersonName());
            entity.setReceiverPhone(result.getReceivePersonTel());
            entity.setReceiverQq(result.getReceivePersonQq());
            entity.setReceiverWechat(result.getReceivePersonWechat());
            entity.setReceiverMail(null); // 买家没有提供这个项目
            entity.setDeliveryArea(result.getDeliveryArea());
            entity.setPassTrafficModel(result.getPassTrafficModel());
            entity.setDefaultFlg(result.getIsDefaultFlg());

            receiver.entity = entity;
            receiver.buyer = buyer;
            receiver.setDataSynced(true);

            receivers.add(receiver);
        }

        return receivers;
    }

}
